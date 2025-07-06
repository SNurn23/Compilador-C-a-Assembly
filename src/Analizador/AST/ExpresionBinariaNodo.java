package Analizador.AST;

public class ExpresionBinariaNodo implements Nodo {
    private final String operador;
    private Nodo izquierda;
    private Nodo derecha;

    public ExpresionBinariaNodo(String operador, Nodo izquierda, Nodo derecha) {
        this.operador = operador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
    
    public String getOperador() { return operador; }
    public Nodo getIzquierda() { return izquierda; }
    public Nodo getDerecha() { return derecha; }
    
    public void setIzquierda(Nodo izquierda) { this.izquierda = izquierda; }
    public void setDerecha(Nodo derecha) { this.derecha = derecha; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}