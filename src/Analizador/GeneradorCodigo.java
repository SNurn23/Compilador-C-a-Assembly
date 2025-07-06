package Analizador;

import Analizador.AST.*;
import java.util.Arrays;

public class GeneradorCodigo implements Visitor<String> {
    private int indentacion = 0;

    public String generar(Nodo root) {
        return root.accept(this);
    }
    
    private String getIndentacion() {
        if (this.indentacion <= 0) {
            return "";
        }
        char[] spaces = new char[this.indentacion * 4];
        Arrays.fill(spaces, ' ');
        return new String(spaces);
    }

    @Override
    public String visit(ImprimirNodo nodo) {
        StringBuilder sb = new StringBuilder("cout << ");
        for (int i = 0; i < nodo.getExpresiones().size(); i++) {
            sb.append(nodo.getExpresiones().get(i).accept(this));
            if (i < nodo.getExpresiones().size() - 1) {
                sb.append(" << ");
            }
        }
        // ----- ESTA ES LA LÍNEA CRÍTICA Y CORREGIDA -----
        // Añadimos '<< endl' para forzar la limpieza del búfer.
        sb.append(" << endl;\n"); 
        return sb.toString();
    }

    // --- El resto de los métodos visit no necesitan cambios ---
    // (Pégalos tal cual si es necesario)
    @Override
    public String visit(ProgramaNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("#include <iostream>\n");
        sb.append("using namespace std;\n\n");
        sb.append("int main() {\n");
        indentacion++;
        sb.append(nodo.getSentencias().accept(this));
        indentacion--;
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String visit(SecuenciaNodo nodo) {
        StringBuilder sb = new StringBuilder();
        for (Nodo sentencia : nodo.getSentencias()) {
            if(sentencia == null) continue;
            sb.append(getIndentacion());
            sb.append(sentencia.accept(this));
        }
        return sb.toString();
    }
    
    @Override
    public String visit(RetornoNodo nodo) {
        if (nodo.getExpresion() != null) {
            return "return " + nodo.getExpresion().accept(this) + ";\n";
        }
        return "return;\n";
    }

    @Override
    public String visit(DeclaracionNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append(nodo.getTipo()).append(" ").append(nodo.getIdentificador().accept(this));
        if (nodo.getExpresionInicial() != null) {
            sb.append(" = ").append(nodo.getExpresionInicial().accept(this));
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    @Override
    public String visit(AsignacionNodo nodo) {
        return String.format("%s = %s;\n",
                nodo.getIdentificador().accept(this),
                nodo.getExpresion().accept(this));
    }

    @Override
    public String visit(ExpresionBinariaNodo nodo) {
        return String.format("(%s %s %s)",
                nodo.getIzquierda().accept(this),
                nodo.getOperador(),
                nodo.getDerecha().accept(this));
    }
    
    @Override
    public String visit(SiNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(nodo.getCondicion().accept(this)).append(") {\n");
        indentacion++;
        sb.append(nodo.getBloqueThen().accept(this));
        indentacion--;
        sb.append(getIndentacion()).append("}");
        if (nodo.getBloqueElse() != null) {
            sb.append(" else ");
            if (nodo.getBloqueElse() instanceof SecuenciaNodo && ((SecuenciaNodo)nodo.getBloqueElse()).getSentencias().size() == 1 && ((SecuenciaNodo)nodo.getBloqueElse()).getSentencias().get(0) instanceof SiNodo){
                 sb.append(nodo.getBloqueElse().accept(this).trim());
            } else {
                 sb.append("{\n");
                 indentacion++;
                 sb.append(nodo.getBloqueElse().accept(this));
                 indentacion--;
                 sb.append(getIndentacion()).append("}");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String visit(MientrasNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("while (").append(nodo.getCondicion().accept(this)).append(") {\n");
        indentacion++;
        sb.append(nodo.getCuerpo().accept(this));
        indentacion--;
        sb.append(getIndentacion()).append("}\n");
        return sb.toString();
    }

    @Override
    public String visit(HacerMientrasNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("do {\n");
        indentacion++;
        sb.append(nodo.getCuerpo().accept(this));
        indentacion--;
        sb.append(getIndentacion()).append("} while (").append(nodo.getCondicion().accept(this)).append(");\n");
        return sb.toString();
    }

    @Override
    public String visit(ParaNodo nodo) {
        StringBuilder sb = new StringBuilder();
        sb.append("for (");
        sb.append(nodo.getInicializacion().accept(this).replace(";\n", ""));
        sb.append("; ").append(nodo.getCondicion().accept(this));
        sb.append("; ").append(nodo.getIncremento().accept(this).replace(";\n", ""));
        sb.append(") {\n");
        indentacion++;
        sb.append(nodo.getCuerpo().accept(this));
        indentacion--;
        sb.append(getIndentacion()).append("}\n");
        return sb.toString();
    }
    
    @Override
    public String visit(LeerNodo nodo) {
        StringBuilder sb = new StringBuilder("cin >> ");
         for (int i = 0; i < nodo.getIdentificadores().size(); i++) {
            sb.append(nodo.getIdentificadores().get(i).accept(this));
            if (i < nodo.getIdentificadores().size() - 1) {
                sb.append(" >> ");
            }
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    @Override
    public String visit(ExpresionUnariaNodo nodo) {
         return String.format("(%s%s)", nodo.getOperador(), nodo.getOperando().accept(this));
    }
    
    @Override
    public String visit(IdentificadorNodo nodo) {
        return nodo.getNombre();
    }

    @Override
    public String visit(LiteralNumeroNodo nodo) {
        if (nodo.esEntero()) {
            return String.valueOf((long) nodo.getValor());
        }
        return String.valueOf(nodo.getValor());
    }

    @Override
    public String visit(LiteralStringNodo nodo) {
        return "\"" + nodo.getValor() + "\"";
    }

    @Override
    public String visit(LiteralBooleanoNodo nodo) {
        return nodo.getValor() ? "true" : "false";
    }
}