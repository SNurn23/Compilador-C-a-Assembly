package Analizador.AST;

import java.util.List;

public class LeerNodo implements Nodo {
    private final List<IdentificadorNodo> identificadores;

    public LeerNodo(List<IdentificadorNodo> identificadores) {
        this.identificadores = identificadores;
    }

    public List<IdentificadorNodo> getIdentificadores() {
        return identificadores;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}