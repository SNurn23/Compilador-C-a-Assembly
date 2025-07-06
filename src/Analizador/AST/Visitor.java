package Analizador.AST;

// Interfaz para el patrón de diseño Visitor.
// Define un método visit para cada tipo de nodo concreto en nuestro AST.
public interface Visitor<T> {
    T visit(ProgramaNodo nodo);
    T visit(DeclaracionNodo nodo);
    T visit(AsignacionNodo nodo);
    T visit(SiNodo nodo); // "If" es palabra reservada
    T visit(MientrasNodo nodo); // "While"
    T visit(HacerMientrasNodo nodo); // "Do-While"
    T visit(ParaNodo nodo); // "For"
    T visit(ImprimirNodo nodo); // Cout o Printf
    T visit(LeerNodo nodo); // Cin o Scanf
    T visit(RetornoNodo nodo);
    T visit(SecuenciaNodo nodo);
    T visit(ExpresionBinariaNodo nodo);
    T visit(ExpresionUnariaNodo nodo);
    T visit(IdentificadorNodo nodo);
    T visit(LiteralNumeroNodo nodo);
    T visit(LiteralStringNodo nodo);
    T visit(LiteralBooleanoNodo nodo);
    // Agrega más métodos visit para otros nodos si los necesitas.
}