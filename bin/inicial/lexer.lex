package inicial;
import java_cup.runtime.*;
%%
%{
/* funciones y variables */
private void imprimir(String descripcion, String lexema) {
System.out.println(lexema + " -> " + descripcion);
}
%}
/* Información sobre la clase generada */
%public
%class AnalizadorLexico
%type void
/* Ajustes regulares */
BLANCO = [\n| |\t]
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]*
ENTERO = 0|[1-9][0-9]*
PUNTO_FLOTANTE = [0-9][0-9]*"."[0-9]+
OPERADORES_MATEMATICOS = ("+" | "-" | "*" | "/" | "%")
OPERADORES_RELACIONALES = ("<" | ">" | "==" | "!="| ">=" | "<=" | "<<" | ">>")
OPERADORES_LOGICOS = ("&&" | "||" | "!" | "&" | "|")
SEPARADORES = ("(" | ")" | "{" | "}" | "[" | "]" | ";" | "," | "\"")
%%
{BLANCO} { imprimir("B/S", yytext()); }
{ID} { imprimir("ID", yytext()); }
{ENTERO} { imprimir("NUM_ENT", yytext()); }
{PUNTO_FLOTANTE} { imprimir("NUM_REAL", yytext()); }
{OPERADORES_MATEMATICOS} { imprimir("OP_MAT", yytext()); }
{OPERADORES_RELACIONALES} { imprimir("OP_REL", yytext()); }
{OPERADORES_LOGICOS} { imprimir("OP_LOG", yytext()); }
{SEPARADORES} { imprimir("SEPARADOR", yytext()); }