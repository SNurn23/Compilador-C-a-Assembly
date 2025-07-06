package Analizador;

import Analizador.AST.Nodo;
import Analizador.AST.ProgramaNodo;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 * Esta clase encapsula toda la lógica de compilación:
 * 1. Parseo (String -> AST)
 * 2. Optimización (AST -> AST Optimizado)
 * 3. Generación de Código (AST Optimizado -> String)
 */
public class Compilador {

    /**
     * Procesa una cadena de código fuente y devuelve su versión optimizada.
     *
     * @param codigoOriginal El código fuente a procesar.
     * @return Una cadena con el código fuente optimizado.
     * @throws ErrorDeSintaxisException Si se encuentra un error de sintaxis en el código original.
     * @throws Exception Si ocurre cualquier otro error durante el proceso.
     */
    public String optimizar(String codigoOriginal) throws ErrorDeSintaxisException, Exception {
        Sintaxis parser = new Sintaxis(new LexicoCup(new StringReader(codigoOriginal)));
        
        try {
            // 1. Ejecutar el parseo para obtener el AST
            Symbol parseResult = parser.parse();
            Nodo astRoot = (Nodo) parseResult.value;

            if (astRoot == null) {
                throw new Exception("El árbol de sintaxis no pudo ser generado.");
            }

            // 2. Optimizar el AST
            Optimizador optimizador = new Optimizador();
            Nodo astOptimizado = optimizador.optimizar(astRoot);

            // 3. Generar el código final a partir del AST optimizado
            GeneradorCodigo generador = new GeneradorCodigo();
            String codigoOptimizado = generador.generar(astOptimizado);

            return codigoOptimizado;

        } catch (Exception ex) {
            // Si el parser falla, captura la excepción, obtén el símbolo del error
            // y vuelve a lanzar nuestra excepción personalizada para que la Vista la maneje.
            Symbol errorSymbol = parser.getS();
            throw new ErrorDeSintaxisException("Error de sintaxis detectado por el parser.", errorSymbol, ex);
        }
    }
}