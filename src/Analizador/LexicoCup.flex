package Analizador;
import java_cup.runtime.Symbol;
%%
%class LexicoCup
%type java_cup.runtime.Symbol
%cup 
%full
%line
%char

/* Expresiones Regulares */
L=[a-zA-Z_]+
D=[0-9]+
// CORRECCIÓN: Se añaden todos los tipos de espacios en blanco en una sola regla.
espacio=[ \t\r\n\u00A0]+

/* Comentarios */
LineComment = "//" [^\r\n]*
BlockComment = "/*" ( [^*] | \*+[^*/] )* \*+ "/"

%{
    // --- PRUEBA DE REGENERACIÓN - JULIO 2025 ---
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Reglas */

/* Ignorar todos los espacios en blanco, incluidos saltos de línea y no estándar */
{espacio} {/*Ignore*/}

/* Comentarios */
{LineComment} | {BlockComment} {/*Ignore*/}

/* Palabras reservadas */
( "break" ) {return new Symbol(sym.Break, yychar, yyline, yytext());}
( "case" ) {return new Symbol(sym.Case, yychar, yyline, yytext());}
( "char" ) {return new Symbol(sym.Char, yychar, yyline, yytext());}
( "cin" ) {return new Symbol(sym.Cin, yychar, yyline, yytext());}
( "cout" ) {return new Symbol(sym.Cout, yychar, yyline, yytext());}
( "double" ) {return new Symbol(sym.Double, yychar, yyline, yytext());}
( "else" ) {return new Symbol(sym.Else, yychar, yyline, yytext());}
( "for" ) {return new Symbol(sym.For, yychar, yyline, yytext());}
( "if" ) {return new Symbol(sym.If, yychar, yyline, yytext());}
( "include" ) {return new Symbol(sym.Include, yychar, yyline, yytext());}
( "int" ) {return new Symbol(sym.Int, yychar, yyline, yytext());}
( "iostream" ) {return new Symbol(sym.Iostream, yychar, yyline, yytext());}
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}
( "namespace" ) {return new Symbol(sym.Namespace, yychar, yyline, yytext());}
( "return" ) {return new Symbol(sym.Return, yychar, yyline, yytext());}
( "std" ) {return new Symbol(sym.Std, yychar, yyline, yytext());}
( "using" ) {return new Symbol(sym.Using, yychar, yyline, yytext());}
( "while" ) {return new Symbol(sym.While, yychar, yyline, yytext());}
( "true" ) {return new Symbol(sym.True, yychar, yyline, yytext());}
( "false" ) {return new Symbol(sym.False, yychar, yyline, yytext());}
/* Agrega aquí el resto de tus palabras reservadas si las necesitas para la sintaxis */


/* Literales */
L?\"(\\.|[^\\\"])*\" {return new Symbol(sym.STRING_LITERAL, yychar, yyline, yytext());}
("-("{D}+")") | ("-("{D}+.{D}+")") | -({D})+ | {D}+ | {D}+.{D}+ | -{D}+.{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}


/* Operadores y Símbolos */
( "==" ) {return new Symbol(sym.ComparadorIgual, yychar, yyline, yytext());}
( ">=" ) {return new Symbol(sym.MayorIgual, yychar, yyline, yytext());}
( "<=" ) {return new Symbol(sym.MenorIgual, yychar, yyline, yytext());}
( "!=" ) {return new Symbol(sym.Diferente, yychar, yyline, yytext());}
( "&&" ) {return new Symbol(sym.Y_logico, yychar, yyline, yytext());}
( "||" ) {return new Symbol(sym.O_logico, yychar, yyline, yytext());}
( "<<" ) {return new Symbol(sym.DobleMenor, yychar, yyline, yytext());}
( ">>" ) {return new Symbol(sym.DobleMayor, yychar, yyline, yytext());}
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}
( "%" ) {return new Symbol(sym.Modulo, yychar, yyline, yytext());}
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}
( "<" ) {return new Symbol(sym.MenorQue, yychar, yyline, yytext());}
( ">" ) {return new Symbol(sym.MayorQue, yychar, yyline, yytext());}
( "!" ) {return new Symbol(sym.Negador, yychar, yyline, yytext());}
( "#" ) {return new Symbol(sym.Numeral, yychar, yyline, yytext());}
( "(" ) {return new Symbol(sym.Parent_a, yychar, yyline, yytext());}
( ")" ) {return new Symbol(sym.Parent_c, yychar, yyline, yytext());}
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}