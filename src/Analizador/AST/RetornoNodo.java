package Analizador.AST;

public class RetornoNodo implements Nodo {
    private final Nodo expresion; // Puede ser null para un return vacío

    public RetornoNodo(Nodo expresion) {
        this.expresion = expresion;
    }

    public Nodo getExpresion() {
        return expresion;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}