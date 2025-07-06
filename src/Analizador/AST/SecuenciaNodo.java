package Analizador.AST;

import java.util.ArrayList;
import java.util.List;

public class SecuenciaNodo implements Nodo {
    private final List<Nodo> sentencias;

    public SecuenciaNodo() {
        this.sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Nodo sentencia) {
        if (sentencia != null) {
            this.sentencias.add(sentencia);
        }
    }

    public List<Nodo> getSentencias() {
        return sentencias;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}