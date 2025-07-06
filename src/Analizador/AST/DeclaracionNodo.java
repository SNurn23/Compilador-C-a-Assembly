package Analizador.AST;

public class DeclaracionNodo implements Nodo {
    private final String tipo;
    private final IdentificadorNodo identificador;
    private final Nodo expresionInicial; // Puede ser null

    public DeclaracionNodo(String tipo, IdentificadorNodo identificador, Nodo expresionInicial) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.expresionInicial = expresionInicial;
    }

    public String getTipo() { return tipo; }
    public IdentificadorNodo getIdentificador() { return identificador; }
    public Nodo getExpresionInicial() { return expresionInicial; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}