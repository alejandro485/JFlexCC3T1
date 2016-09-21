package pruebas;

import java.io.IOException;
import java.io.StringReader;

import inicial.AnalizadorLexico;

public class PConsola {
	public static void main(String[] arg) throws IOException{
		String exp="12.3+6*25";
		AnalizadorLexico lex=new AnalizadorLexico(new StringReader(exp));
		lex.yylex();
	}
}
