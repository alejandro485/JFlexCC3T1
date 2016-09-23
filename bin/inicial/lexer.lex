package inicial;
import java_cup.runtime.*;
import java.util.ArrayList;
%%

%init{ /* Inicializador de clase (constructor) */
	this.listaT = new ArrayList();
	this.listaD = new ArrayList();
	this.enteros = 0;
	this.reales = 0;
	this.ids = 0;
%init}

%{/* funciones y variables */
	public ArrayList listaT;
	public ArrayList listaD;
	public int enteros;
	public int reales;
	public int ids;
	private void imprimir(String descripcion, String lexema, int v) {
		System.out.println(lexema + " -> " + descripcion);
		if(v==1){
			this.ids++;
		}
		if(v==2){
			this.enteros++;
		}
		if(v==3){
			this.reales++;
		}
		listaT.add(lexema);
		listaD.add(descripcion);
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
{BLANCO} { imprimir("B/S", yytext(),0); }
{ID} { imprimir("ID", yytext(), 1); }
{ENTERO} { imprimir("NUM_ENT", yytext(), 2); }
{PUNTO_FLOTANTE} { imprimir("NUM_REAL", yytext(),3); }
{OPERADORES_MATEMATICOS} { imprimir("OP_MAT", yytext(),0); }
{OPERADORES_RELACIONALES} { imprimir("OP_REL", yytext(),0); }
{OPERADORES_LOGICOS} { imprimir("OP_LOG", yytext(),0); }
{SEPARADORES} { imprimir("SEPARADOR", yytext(),0); }