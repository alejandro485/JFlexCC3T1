package inicial;

import java.io.File;

public class Inicial {
	
	static String path="src/inicial/lexer.lex";
	
	public static void main(String[] arg){
		generarLexer(path);
	}
	
	private static void generarLexer(String path){
		File f=new File(path);
		jflex.Main.generate(f);
	}
	
}
