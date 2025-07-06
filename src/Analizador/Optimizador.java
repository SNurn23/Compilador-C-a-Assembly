package Analizador;

import Analizador.AST.*;
import java.util.List;

/**
 * Optimizador que realiza "Plegado de Constantes" y recorre el AST completo.
 */
public class Optimizador implements Visitor<Nodo> {

    public Nodo optimizar(Nodo root) {
        return root.accept(this);
    }

    @Override
    public Nodo visit(ProgramaNodo nodo) {
        // Visita las sentencias del programa
        nodo.getSentencias().accept(this);
        return nodo;
    }
    
    @Override
    public Nodo visit(SecuenciaNodo nodo) {
        // Itera sobre una copia para poder modificar la lista original si es necesario
        for (int i = 0; i < nodo.getSentencias().size(); i++) {
            Nodo sentencia = nodo.getSentencias().get(i);
            if (sentencia != null) {
                // Reemplaza la sentencia original por la versión optimizada
                nodo.getSentencias().set(i, sentencia.accept(this));
            }
        }
        return nodo;
    }

    @Override
    public Nodo visit(ExpresionBinariaNodo nodo) {
        // Optimiza los hijos primero (recorrido post-orden)
        nodo.setIzquierda(nodo.getIzquierda().accept(this));
        nodo.setDerecha(nodo.getDerecha().accept(this));

        // Intenta plegar la constante si ambos hijos son literales numéricos
        if (nodo.getIzquierda() instanceof LiteralNumeroNodo && nodo.getDerecha() instanceof LiteralNumeroNodo) {
            double val1 = ((LiteralNumeroNodo) nodo.getIzquierda()).getValor();
            double val2 = ((LiteralNumeroNodo) nodo.getDerecha()).getValor();

            switch (nodo.getOperador()) {
                case "+": return new LiteralNumeroNodo(val1 + val2);
                case "-": return new LiteralNumeroNodo(val1 - val2);
                case "*": return new LiteralNumeroNodo(val1 * val2);
                case "/": return (val2 != 0) ? new LiteralNumeroNodo(val1 / val2) : nodo;
            }
        }
        return nodo;
    }
    
    @Override
    public Nodo visit(DeclaracionNodo nodo) {
        // Si hay una expresión de inicialización, visítala para optimizarla
        if (nodo.getExpresionInicial() != null) {
            // No se puede asignar el resultado porque el tipo de nodo.expresionInicial es Nodo, no DeclaracionNodo
            // Pero el accept modificará el sub-árbol internamente.
             nodo.getExpresionInicial().accept(this);
        }
        return nodo;
    }

    @Override
    public Nodo visit(AsignacionNodo nodo) {
        nodo.getExpresion().accept(this);
        return nodo;
    }

    @Override
    public Nodo visit(SiNodo nodo) {
        nodo.getCondicion().accept(this);
        nodo.getBloqueThen().accept(this);
        if (nodo.getBloqueElse() != null) {
            nodo.getBloqueElse().accept(this);
        }
        return nodo;
    }
    
    @Override
    public Nodo visit(MientrasNodo nodo) {
        nodo.getCondicion().accept(this);
        nodo.getCuerpo().accept(this);
        return nodo;
    }

    @Override
    public Nodo visit(HacerMientrasNodo nodo) {
        nodo.getCuerpo().accept(this);
        nodo.getCondicion().accept(this);
        return nodo;
    }

    @Override
    public Nodo visit(ParaNodo nodo) {
        if(nodo.getInicializacion() != null) nodo.getInicializacion().accept(this);
        if(nodo.getCondicion() != null) nodo.getCondicion().accept(this);
        if(nodo.getIncremento() != null) nodo.getIncremento().accept(this);
        if(nodo.getCuerpo() != null) nodo.getCuerpo().accept(this);
        return nodo;
    }

    @Override
    public Nodo visit(ImprimirNodo nodo) {
        List<Nodo> expresiones = nodo.getExpresiones();
        for(int i = 0; i < expresiones.size(); i++) {
            expresiones.set(i, expresiones.get(i).accept(this));
        }
        return nodo;
    }

    @Override
    public Nodo visit(RetornoNodo nodo) {
        if (nodo.getExpresion() != null) {
            nodo.getExpresion().accept(this);
        }
        return nodo;
    }

    @Override
    public Nodo visit(ExpresionUnariaNodo nodo) {
        nodo.getOperando().accept(this);
        return nodo;
    }
    
    // Nodos que no tienen sub-árboles para optimizar o no aplican para esta optimización.
    @Override public Nodo visit(LeerNodo nodo) { return nodo; }
    @Override public Nodo visit(IdentificadorNodo nodo) { return nodo; }
    @Override public Nodo visit(LiteralNumeroNodo nodo) { return nodo; }
    @Override public Nodo visit(LiteralStringNodo nodo) { return nodo; }
    @Override public Nodo visit(LiteralBooleanoNodo nodo) { return nodo; }
}