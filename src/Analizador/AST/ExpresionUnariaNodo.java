package Analizador.AST;

public class ExpresionUnariaNodo implements Nodo {
    private final String operador;
    private final Nodo operando;

    public ExpresionUnariaNodo(String operador, Nodo operando) {
        this.operador = operador;
        this.operando = operando;
    }
    
    public String getOperador() { return operador; }
    public Nodo getOperando() { return operando; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}