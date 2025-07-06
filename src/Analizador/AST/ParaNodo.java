package Analizador.AST;

public class ParaNodo implements Nodo {
    private final Nodo inicializacion;
    private final Nodo condicion;
    private final Nodo incremento;
    private final Nodo cuerpo;

    public ParaNodo(Nodo inicializacion, Nodo condicion, Nodo incremento, Nodo cuerpo) {
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.incremento = incremento;
        this.cuerpo = cuerpo;
    }

    public Nodo getInicializacion() { return inicializacion; }
    public Nodo getCondicion() { return condicion; }
    public Nodo getIncremento() { return incremento; }
    public Nodo getCuerpo() { return cuerpo; }
    
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}