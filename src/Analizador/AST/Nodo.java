package Analizador.AST;

public interface Nodo {
    <T> T accept(Visitor<T> visitor);
}