package Analizador.AST;

public class ProgramaNodo implements Nodo {
    private final SecuenciaNodo sentencias;

    public ProgramaNodo(SecuenciaNodo sentencias) {
        this.sentencias = sentencias;
    }

    public SecuenciaNodo getSentencias() {
        return sentencias;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}