package Analizador.AST;

public class HacerMientrasNodo implements Nodo {
    private final Nodo cuerpo;
    private final Nodo condicion;

    public HacerMientrasNodo(Nodo cuerpo, Nodo condicion) {
        this.cuerpo = cuerpo;
        this.condicion = condicion;
    }

    public Nodo getCuerpo() { return cuerpo; }
    public Nodo getCondicion() { return condicion; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}