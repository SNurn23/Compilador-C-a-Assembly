package Analizador.AST;

import java.util.List;

public class ImprimirNodo implements Nodo {
    private final List<Nodo> expresiones;

    public ImprimirNodo(List<Nodo> expresiones) {
        this.expresiones = expresiones;
    }

    public List<Nodo> getExpresiones() {
        return expresiones;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}