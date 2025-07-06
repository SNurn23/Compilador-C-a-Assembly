package Analizador.AST;

public class MientrasNodo implements Nodo {
    private final Nodo condicion;
    private final Nodo cuerpo;

    public MientrasNodo(Nodo condicion, Nodo cuerpo) {
        this.condicion = condicion;
        this.cuerpo = cuerpo;
    }

    public Nodo getCondicion() { return condicion; }
    public Nodo getCuerpo() { return cuerpo; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}