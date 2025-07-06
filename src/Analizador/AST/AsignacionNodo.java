package Analizador.AST;

public class AsignacionNodo implements Nodo {
    private final IdentificadorNodo identificador;
    private final Nodo expresion;

    public AsignacionNodo(IdentificadorNodo identificador, Nodo expresion) {
        this.identificador = identificador;
        this.expresion = expresion;
    }

    public IdentificadorNodo getIdentificador() { return identificador; }
    public Nodo getExpresion() { return expresion; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}