package Analizador.AST;

public class LiteralNumeroNodo implements Nodo {
    private final double valor;

    public LiteralNumeroNodo(String textoValor) {
        this.valor = Double.parseDouble(textoValor);
    }
    
    public LiteralNumeroNodo(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
    
    // Método para saber si es entero y no imprimir ".0"
    public boolean esEntero() {
        return this.valor == (long) this.valor;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}