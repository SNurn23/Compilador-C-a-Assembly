package Analizador.AST;

public class IdentificadorNodo implements Nodo {
    private final String nombre;

    public IdentificadorNodo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}