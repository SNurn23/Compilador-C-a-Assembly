package Analizador;
import static Analizador.Tokens.*;
%%
%class Lexico
%type Tokens

/* Expresiones Regulares */
L=[a-zA-Z_]+
D=[0-9]+
// CORRECCIÓN: Se añade \u00A0 para reconocer espacios no estándar y se agrupan todos los espacios
espacio_ignorable = [ \t\r\u00A0]+

/* Comentarios */
LineComment = "//" [^\r\n]*
BlockComment = "/*" ( [^*] | \*+[^*/] )* \*+ "/"

%{
    public String lexemas;
%}
%%

/* Reglas */

/* Espacios en blanco (sin incluir saltos de línea) */
{espacio_ignorable} {/*Ignore*/}

/* Salto de linea (se maneja por separado para contar líneas en la GUI) */
( \n ) {return Linea;}

/* Comentarios */
{LineComment} | {BlockComment} {/*Ignore*/}

/* Palabras reservadas */
( "break" ) {lexemas=yytext(); return Break;}
( "system" ) {lexemas=yytext(); return _System;}
( "string" ) {lexemas=yytext(); return _String;}
( "case" ) {lexemas=yytext(); return Case;}
( "printf" ) {lexemas=yytext(); return Printf;}
( "scanf" ) {lexemas=yytext(); return Scanf;}
( "const" ) {lexemas=yytext(); return Const;}
( "continue" ) {lexemas=yytext(); return Continue;}
( "default" ) {lexemas=yytext(); return Default;}
( "define" ) {lexemas=yytext(); return Define;}
( "while" ) {lexemas=yytext(); return While;}
( "do" ) {lexemas=yytext(); return Do;}
( "double" ) {lexemas=yytext(); return Double;}
( "else" ) {lexemas=yytext(); return Else;}
( "for" ) {lexemas=yytext(); return For;}
( "if" ) {lexemas=yytext(); return If;}
( "int" ) {lexemas=yytext(); return Int;}
( "bool" ) {lexemas=yytext(); return Bool;}
( "long" ) {lexemas=yytext(); return Long;}
( "short" ) {lexemas=yytext(); return Short;}
( "float" ) {lexemas=yytext(); return Float;}
( "byte" ) {lexemas=yytext(); return Byte;}
( "char" ) {lexemas=yytext(); return Char;}
( "include" ) {lexemas=yytext(); return Include;}
( "namespace" ) {lexemas=yytext(); return Namespace;}
( "std" ) {lexemas=yytext(); return Std;}
( "iostream" ) {lexemas=yytext(); return Iostream;}
( "using" ) {lexemas=yytext(); return Using;}
( "false" ) {lexemas=yytext(); return False;}
( "true" ) {lexemas=yytext(); return True;}
( "endl" ) {lexemas=yytext(); return Endl;}
( "main" ) {lexemas=yytext(); return Main;}
( "register" ) {lexemas=yytext(); return Register;}
( "cout" ) {lexemas=yytext(); return Cout;}
( "void" ) {lexemas=yytext(); return Void;}
( "typedef" ) {lexemas=yytext(); return Typedef;}
( "switch" ) {lexemas=yytext(); return Switch;}
( "unsigned" ) {lexemas=yytext(); return Unsigned;}
( "cin" ) {lexemas=yytext(); return Cin;}
( "return" ) {lexemas=yytext(); return Return;}

/* Literales */
L?\"(\\.|[^\\\"])*\" {lexemas=yytext(); return STRING_LITERAL;}
("-("{D}+")") | ("-("{D}+.{D}+")") | -({D})+ | {D}+ | {D}+.{D}+ | -{D}+.{D}+ {lexemas=yytext(); return Numero;}

/* Operadores y Símbolos */
( "++" ) {lexemas=yytext(); return Incremento;}
( "--" ) {lexemas=yytext(); return Decremento;}
( "==" ) {lexemas=yytext(); return ComparadorIgual;}
( "!=" ) {lexemas=yytext(); return Diferente;}
( ">=" ) {lexemas=yytext(); return MayorIgual;}
( "<=" ) {lexemas=yytext(); return MenorIgual;}
( "+=" ) {lexemas=yytext(); return MasIgual;}
( "-=" ) {lexemas=yytext(); return MenosIgual;}
( "*=" ) {lexemas=yytext(); return MultiplicacionIgual;}
( "/=" ) {lexemas=yytext(); return DivisionIgual;}
( "%=" ) {lexemas=yytext(); return ModuloIgual;}
( "&&" ) {lexemas=yytext(); return Y_logico;}
( "||" ) {lexemas=yytext(); return O_logico;}
( ">>" ) {lexemas=yytext(); return DobleMayor;}
( "<<" ) {lexemas=yytext(); return DobleMenor;}
( "=" ) {lexemas=yytext(); return Igual;}
( "!" ) {lexemas=yytext(); return Negador;}
( ">" ) {lexemas=yytext(); return MayorQue;}
( "<" ) {lexemas=yytext(); return MenorQue;}
( "+" ) {lexemas=yytext(); return Suma;}
( "-" ) {lexemas=yytext(); return Resta;}
( "*" ) {lexemas=yytext(); return Multiplicacion;}
( "/" ) {lexemas=yytext(); return Division;}
( "%" ) {lexemas=yytext(); return Modulo;}
( "&" ) {lexemas=yytext(); return BitAnd;}
( "|" ) {lexemas=yytext(); return BitOr;}
( "^" ) {lexemas=yytext(); return Op_potencia;}
( "#" ) {lexemas=yytext(); return Numeral;}
( "(" ) {lexemas=yytext(); return Parent_a;}
( ")" ) {lexemas=yytext(); return Parent_c;}
( "{" ) {lexemas=yytext(); return Llave_a;}
( "}" ) {lexemas=yytext(); return Llave_c;}
( "[" ) {lexemas=yytext(); return Corchete_a;}
( "]" ) {lexemas=yytext(); return Corchete_c;}
( ";" ) {lexemas=yytext(); return P_coma;}
( ":" ) {lexemas=yytext(); return DosPuntos;}
( "." ) {lexemas=yytext(); return Punto;}
( "," ) {lexemas=yytext(); return Coma;}
( "\"" ) {lexemas=yytext(); return Comillas;}
( "'" ) {lexemas=yytext(); return Comilla_simple;}

/* Identificador */
{L}({L}|{D})* {lexemas=yytext(); return Identificador;}

/* Error de analisis */
 . {return ERROR;}