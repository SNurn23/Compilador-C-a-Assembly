package Analizador.AST;

public class LiteralStringNodo implements Nodo {
    private final String valor;

    public LiteralStringNodo(String valor) {
        // Quitar las comillas del inicio y del final
        if (valor.startsWith("\"") && valor.endsWith("\"")) {
            this.valor = valor.substring(1, valor.length() - 1);
        } else {
            this.valor = valor;
        }
    }

    public String getValor() {
        return valor;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}