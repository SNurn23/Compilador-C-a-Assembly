package Analizador;

import java_cup.runtime.Symbol;

/**
 * Una excepción personalizada para manejar errores de sintaxis de forma estructurada.
 * Contiene el símbolo que causó el error para poder mostrar detalles en la GUI.
 */
public class ErrorDeSintaxisException extends Exception {
    
    private final Symbol symbol;

    public ErrorDeSintaxisException(String message, Symbol symbol, Throwable cause) {
        super(message, cause);
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}