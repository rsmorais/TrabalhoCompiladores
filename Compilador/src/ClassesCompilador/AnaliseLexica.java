package ClassesCompilador;

//import java.util.Collection;
//import java.util.ArrayList;
import java.io.*;

public class AnaliseLexica {
	//Atributos
	private String newString = "";
	private int LengthString;
	private String FileCode;
	private String Code = " "; //"if(2+5 = 6)";
	private FilaTokens Tokens;
	private Tipos tipos;
	private InputStreamReader entradaFormatada;
	FileInputStream entrada = null;
	private int line;
	
	public int Init(String asFileCode)
	{
		this.line = 1; 
		this.FileCode = asFileCode;
		LengthString =  Code.length();
		if(LengthString <= 0)
			return 0;
		Tokens = new FilaTokens();
		tipos = new Tipos();
		try {
			entrada = new FileInputStream(FileCode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    entradaFormatada = new InputStreamReader(entrada);
		Estado0(NextChar());
		return 1;
	}
	
	public void Print()
	{
		if(Tokens.Contains())
		{
			for(;Tokens.Contains();)
			{
				System.out.println("CLASS: "+ Tokens.GetClass() + "\nVALUE: " + Tokens.GetValue() + "\n");
			}	
		}
	}
	
	private int NextChar()
	{	
		int Char = 0; 
		try {
			Char = (char)entradaFormatada.read();
		} catch (IOException e) {
			e.printStackTrace();
	    }
		if(Char == 10)
			this.line++;
		return Char ;
	}
	
	private void empilha(String token)
	{
		this.Tokens.SetToken(token, newString);
		newString = new String();
	}
	
	private void Estado0(int Char)
	{
		if( this.tipos.equalUnderline(Char))
		{
			newString += (char)Char;
			this.Estado1(NextChar());
		}
		else if (this.tipos.equalLetter(Char))
		{
			newString += (char)Char;
			this.Estado2(NextChar());
		}
		else if (this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado4(NextChar());
		}
		else if (this.tipos.equalLogicOperator(Char))
		{
			newString += (char)Char;
			this.Estado7(Char);
		}
		else if (this.tipos.equalEquality(Char))
		{
			newString += (char)Char;
			this.Estado7(Char);
		}
		else if (this.tipos.equalExclamation(Char))
		{
			newString += (char)Char;
			this.Estado7(Char);
		}
		else if (this.tipos.equalArithmeticOperator(Char))
		{
			newString += (char)Char;
			this.Estado8(NextChar());
		}
		else if (this.tipos.equalOpenBrackets(Char))
		{
			newString += (char)Char;
			this.empilha("OpenBrackets");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalCloseBrackets(Char))
		{
			newString += (char)Char;
			this.empilha("CloseBrackets");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalOpenParentheses(Char))
		{
			newString += (char)Char;
			this.empilha("OpenParentheses");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalCloseParentheses(Char))
		{
			newString += (char)Char;
			this.empilha("CloseParentheses");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalOpenKeys(Char))
		{
			newString += (char)Char;
			this.empilha("OpenKeys");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalCloseKeys(Char))
		{
			newString += (char)Char;
			this.empilha("CloseKeys");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalSemicolon(Char))
		{
			newString += (char)Char;
			this.empilha("Semicolon");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalComma(Char))
		{
			newString += (char)Char;
			this.empilha("Comma");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalSigma(Char))
		{	
			Estado0(NextChar());
		}
		else if (this.tipos.equalFinal(Char))
		{
			return;
		}
		else 
		{
			newString += (char)Char;
			int C = NextChar();
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroChar");
			
			this.Estado0(C);
		}
	}
	
	private void Estado1(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalUnderline(Char))
		{
			newString += (char)Char;
			this.Estado1(NextChar());
		}
		else if (this.tipos.equalLetter(Char))
		{
			newString += (char)Char;
			this.Estado2(NextChar());
		}
		else if (this.tipos.equalSigma(Char) || this.tipos.equalChars(str))
		{	
			this.empilha("ErroVar");
			Estado0(Char);
		}
		else if (this.tipos.equalFinal(Char))
		{
			if(!newString.isEmpty())
				this.empilha("ErroChar");
			Estado0(Char);
		}
		else 
		{
			newString += (char)Char;
			int C = NextChar();
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroChar");
			this.Estado0(C);
		}		
	}
	
	private void Estado2(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalUnderline(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalLetter(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalSigma(Char) || this.tipos.equalChars(str) || this.tipos.equalFinal(Char))
		{				
			if(this.tipos.equalKeyWord(newString))
				this.empilha("KW");
			else
				this.empilha("Var");
			Estado0(Char);
		}
		else 
		{
			newString += (char)Char;
			int C = NextChar();
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroChar");
			this.Estado0(C);
		}
	}
	
	private void Estado3(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalUnderline(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalLetter(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado3(NextChar());
		}
		else if (this.tipos.equalSigma(Char) || this.tipos.equalChars(str) || this.tipos.equalFinal(Char))
		{				
			if(this.tipos.equalKeyWord(newString))
				this.empilha("KW");
			else
				this.empilha("Var");
			Estado0(Char);
		}
		else
		{
			newString += (char)Char;
			int C = NextChar();
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroChar");
			this.Estado0(C);
		}
	}
	
	private void Estado4(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado4(NextChar());
		}
		else if(this.tipos.equalDot(Char))
		{
			newString += (char)Char;
			this.Estado5(NextChar());
		}
		else if (this.tipos.equalSigma(Char) || this.tipos.equalChars(str) || this.tipos.equalFinal(Char))
		{
			this.empilha("Int");
			Estado0(Char);
		}
		else
		{
			newString += (char)Char;
			int C = NextChar();
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroNumberInt");
			this.Estado0(C);
		}
	}

	private void Estado5(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado6(NextChar());
		}
		else
		{		
			int C = Char;
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroNumberFloat");
			this.Estado0(C);
		}
	}
	
	private void Estado6(int Char)
	{
		String str = Character.toString((char) Char);
		if( this.tipos.equalNumber(Char))
		{
			newString += (char)Char;
			this.Estado6(NextChar());
		}
		else if(this.tipos.equalSigma(Char) || this.tipos.equalChars(str) || this.tipos.equalFinal(Char))
		{
			this.empilha("Float");
			Estado0(Char);
		}
		else
		{		
			int C = Char;
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroNumberFloat");
			this.Estado0(C);
		}
	}
	
	private void Estado7(int Char)
	{
		int C = NextChar();
		String str = Character.toString((char)C);
		if (this.tipos.equalEquality(C))
		{
			newString += (char)C;
			this.empilha("OpLogic");
			this.Estado0(NextChar());
		}
		else if (this.tipos.equalSigma(C) || this.tipos.equalChars(str) ||this.tipos.equalFinal(C))
		{
			if(this.tipos.equalLogicOperator(Char))
			{
				this.empilha("OpLogic");
				this.Estado0(C);
			}else if (this.tipos.equalEquality(Char))
			{
				this.empilha("Equality");
				this.Estado0(C);
			}else
			{
				this.empilha("Exclamation");
				this.Estado0(C);
			}
		}
		else
		{
			while(!this.tipos.equalSigma(C) && !this.tipos.equalFinal(C) && !this.tipos.equalChars(str))
			{
				newString += (char)C;
				C = NextChar();
			}
			if(!newString.isEmpty())
				this.empilha("ErroOpLogic");
			this.Estado0(C);
		}
	}
	
	private void Estado8(int Char)
	{
		this.empilha("Arithmetic");
		this.Estado0(Char);
	}
	
}
