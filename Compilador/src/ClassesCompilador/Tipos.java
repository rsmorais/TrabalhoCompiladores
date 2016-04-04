package ClassesCompilador;

import java.util.LinkedList;
import java.util.List;

public class Tipos {
	/***************************************LISTA DE ATRIBUTOS**********************************************/
	//private List<String> letters = new LinkedList<String>();
	//private List<String> numbers = new LinkedList<String>();
	//private List<String> opArithmetics = new LinkedList<String>();
	//private List<String> opLogics = new LinkedList<String>();
	private List<String> BEblocks = new LinkedList<String>();
	private List<String> KW = new LinkedList<String>();
	private List<String> Chars = new LinkedList<String>();
	
	
	/****************************************MÉTODOS DE TESTE***********************************************/
	
	/**
	 * @author 		Rafael Souza
	 * @param  
	 * @return 
	 */
	/**
	 * @author 		Rafael Souza
	 * @param Char 	Caracter a ser usado para verivicar se é um underline
	 * @return 		Retorna true caso o Char seja um underline, retorna false caso contrário. Ex:{'_'}
	 */
	public boolean equalUnderline (int Char)
	{
		if(Char == 95)
			return true;
		return false;
	}

	/**
	 * @author 		Rafael Souza
	 * @param Char 	Caracter a ser usado para verivicar se é ums letra
	 * @return 		Retorna true caso o Char seja uma letra, retorna false caso contrário. Ex:{[a-z][A-Z]}
	 */
	public boolean equalLetter (int Char)
	{
		if((Char >= 97 && Char <= 122) || (Char >= 65 && Char <= 90))
			return true;
		return false;
	}

	/**
	 * @author 		Rafael Souza
	 * @param Char 	Caracter a ser usado para verivicar se é um número
	 * @return 		Retorna true caso o Char seja um número, retorna false caso contrário. Ex:{[0-9]}
	 */
	public boolean equalNumber (int Char)
	{
		if(Char >= 48 && Char <= 57)
			return true;
		return false;

	}
	
	/**
	 * @author 		Rafael Souza
	 * @param Char	Caracter a ser usado para verivicar se é um operador aritimético
	 * @return 		Retorna true caso o Char seja  um operador aritimético, retorna false caso contrário. Ex:{'+','-','/','*'}
	 */
	public boolean equalArithmeticOperator (int Char)
	{
		if(Char == 42 || Char == 43 || Char ==  45 || Char == 47)
			return true;
		return false;
	}
	
	/**
	 * @author 		Rafael Souza
	 * @param Char	Caracter a ser usado para verivicar se é um operador lógico
	 * @return 		Retorna true caso o Char seja um operador lógico, retorna false caso contrário. Ex:{'<','>'}
	 */
	public boolean equalLogicOperator (int Char)
	{
		if(Char == 60 || Char == 62)
			return true;
		return false;
	}
		
	/**
	 * @author 		Rafael Souza
	 * @param Char 	Caracter a ser usado para verivicar se é um BEBlocks
	 * @return 		Retorna true caso o Char seja um BEBlocks, retorna false caso contrário. Ex:{'(',')','{','}','[',']'}
	 */
	public boolean equalBEBlocks (String Char)
	{
		if(BEblocks.size() == 0)
			PopullateBEblocks();
	
		if(BEblocks.contains(Char))
			return true;
		return false;
	}
	
	/**
	 * @author    	Rafael Souza
	 * @param  Char	Caracter a ser usado para verivicar se é uma exclamação
	 * @return      Retorna true caso o Char seja uma exclamação, retorna false caso contrário. Ex:{'!'}
	 */
	public boolean equalExclamation (int Char)
	{
		if(Char == 33)
			return true;
		return false;
	}
	
	/**
	 * @author 		Rafael Souza
	 * @param Char	Caracter a ser usado para verivicar se é uma igualdade
	 * @return 		Retorna true caso o Char seja uma igualdade, retorna false caso contrário. Ex:{'='}
	 */
	public boolean equalEquality (int Char)
	{
		if(Char == 61)
			return true;
		return false;
	}
	
	/**
	 * @author 		Rafael Souza
	 * @param Char	Caracter a ser usado para verivicar se é um Dot
	 * @return 		Retorna true caso o Char seja um Dot, retorna false caso contrário. Ex:{'.'}
	 */
	public boolean equalDot (int Char)
	{
		if(Char == 46)
			return true;
		return false;
	}
	
	public boolean equalPipe (int Char)
	{
		if(Char == 124)
			return true;
		return false;
	}
	
	public boolean equalAmpersand (int Char)
	{
		if(Char == 38)
			return true;
		return false;
	}
	
	public boolean equalSemicolon (int Char)
	{
		if(Char == 59)
			return true;
		return false;
	}
	
	public boolean equalComma (int Char)
	{
		if(Char == 44)
			return true;
		return false;
	}
	
	public boolean equalOpenParentheses (int Char)
	{
		if(Char == 40)
			return true;
		return false;
	}
	
	public boolean equalCloseParentheses (int Char)
	{
		if(Char == 41)
			return true;
		return false;
	}
	
	public boolean equalOpenBrackets (int Char)
	{
		if(Char == 91)
			return true;
		return false;
	}
	
	public boolean equalCloseBrackets (int Char)
	{
		if(Char == 93)
			return true;
		return false;
	}
	
	public boolean equalOpenKeys (int Char)
	{
		if(Char == 123)
			return true;
		return false;
	}
	
	public boolean equalCloseKeys (int Char)
	{
		if(Char == 125)
			return true;
		return false;
	}
	
	public boolean equalKeyWord (String Char)
	{
		if(KW.size() == 0)
			PopullateKW();
		
		if(KW.contains(Char))
			return true;
		return false;
	}
	
	public boolean equalChars (String Char)
	{
		if(Chars.size() == 0)
			PopullateChars();
		
		if(Chars.contains(Char))
			return true;
		return false;
	}
	
	public boolean equalSigma (int Char)
	{
		if (Char == 8 || Char == 9 || Char == 10 || Char == 32)
			return true;
		return false;
	}
	
	public boolean equalFinal (int Char)
	{
		if (Char == 65535)
			return true;
		return false;
	}
	
	/******************************************POPULATES****************************************************/
	//Popula a lista do alfabeto
 	/*private void PopullateLatters ()
	{
		letters.add("a");letters.add("A");
		letters.add("b");letters.add("B");
		letters.add("c");letters.add("C");
		letters.add("d");letters.add("D");
		letters.add("e");letters.add("E");
		letters.add("f");letters.add("F");
		letters.add("g");letters.add("G");
		letters.add("h");letters.add("H");
		letters.add("i");letters.add("I");
		letters.add("j");letters.add("J");
		letters.add("k");letters.add("K");
		letters.add("l");letters.add("L");
		letters.add("m");letters.add("M");
		letters.add("n");letters.add("N");
		letters.add("o");letters.add("O");
		letters.add("p");letters.add("P");
		letters.add("q");letters.add("Q");
		letters.add("r");letters.add("R");
		letters.add("s");letters.add("S");
		letters.add("t");letters.add("T");
		letters.add("u");letters.add("U");
		letters.add("v");letters.add("V");
		letters.add("w");letters.add("W");
		letters.add("x");letters.add("X");
		letters.add("y");letters.add("Y");
		letters.add("z");letters.add("Z");
	}
	
	//Popula a lista dos números
	/private void PopullateNumbers ()
	{
		numbers.add("0");numbers.add("1");
		numbers.add("2");numbers.add("3");
		numbers.add("4");numbers.add("5");
		numbers.add("6");numbers.add("7");
		numbers.add("8");numbers.add("9");
	}
	
	//Popula a lista dos operadores aritméticoss
	private void PopullateOpArthmetics ()
	{
		opArithmetics.add("/");opArithmetics.add("*");
		opArithmetics.add("-");opArithmetics.add("+");
	}
	
	//Popula a lista dos operadores lógicos
	private void PopullateOpLogics ()
	{
		opLogics.add(">");opLogics.add("<");
	}*/
	
	//Popula os (Begin e End blocks)
	private void PopullateBEblocks ()
	{
		BEblocks.add("{");BEblocks.add("}");
		BEblocks.add("(");BEblocks.add(")");
		BEblocks.add("[");BEblocks.add("]");
	}
	
	//Popula os KWs
	private void PopullateKW ()
	{
		KW.add("if"); 		KW.add("else");
		KW.add("for"); 		KW.add("int");
		KW.add("float");	KW.add("return");
		KW.add("void"); 	KW.add("while");		                     
	}

	private void PopullateChars ()
	{
		Chars.add("+");Chars.add("-");
		Chars.add("*");Chars.add("/");
		Chars.add("<");Chars.add(">");
		Chars.add("=");Chars.add("(");
		Chars.add(")");Chars.add(";");
		Chars.add(",");Chars.add("!");
		Chars.add("{");Chars.add("}");
		Chars.add("&");Chars.add("|");
	}
}
