package Analizador.AST;

public class LiteralBooleanoNodo implements Nodo {
    private final boolean valor;

    public LiteralBooleanoNodo(boolean valor) {
        this.valor = valor;
    }

    public boolean getValor() {
        return valor;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}