package pruebas;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import inicial.AnalizadorLexico;

public class PConsola {
	private static Scanner sn;

	public static void main(String[] arg) throws IOException{
		sn = new Scanner(System.in);
		String exp=sn.nextLine();
		AnalizadorLexico lex=new AnalizadorLexico(new StringReader(exp));
		lex.yylex();
		System.out.println("IDS: "+lex.ids);
		System.out.println("Enteros: "+lex.enteros);
		System.out.println("Reales: "+lex.reales);
	}
}
