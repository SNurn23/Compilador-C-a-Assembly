package Analizador.AST;

public class SiNodo implements Nodo {
    private final Nodo condicion;
    private final Nodo bloqueThen;
    private final Nodo bloqueElse; // Puede ser null

    public SiNodo(Nodo condicion, Nodo bloqueThen, Nodo bloqueElse) {
        this.condicion = condicion;
        this.bloqueThen = bloqueThen;
        this.bloqueElse = bloqueElse;
    }
    
    public Nodo getCondicion() { return condicion; }
    public Nodo getBloqueThen() { return bloqueThen; }
    public Nodo getBloqueElse() { return bloqueElse; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}