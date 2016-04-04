package ClassesCompilador;

import java.util.LinkedList;
import java.util.List;

public class FilaTokens {
	
	private List<String> Values = new LinkedList<String>();
	private List<String> Classes = new LinkedList<String>();
	
	/**
	 * @author 			Rafael Souza
	 * @param  Class 	String que informa qual � a classe do token
	 * @param  Value 	String que informa qual � o valor do token
	 */
	public void SetToken (String Class, String Value)
	{
		Values.add(Value);
		Classes.add(Class);
	}
	
	/**
	 * @author	Rafael Souza
	 * @see 	Deve ser utilizado juntamente com o m�todo GetClass()
	 * @return  Retorna a string que est� no topo da pilha de Valores do token
	 */
	public String GetValue ()
	{
		if(this.Contains())
			return Values.remove(0);
		else
			return "";
	}
	
	/**
	 * @author	Rafael Souza
	 * @see 	Deve ser utilizado juntamente com o m�todo GetValue()
	 * @return  Retorna a string que est� no topo da pilha de Classe do token
	 */
	public String GetClass ()
	{
		if(this.Contains())
			return Classes.remove(0);
		else
			return "";
	}
	
	/**
	 * @author	Rafael Souza
	 * @return	Retorna true se cont�m Tokens, retorna false caso contr�rio  	
	 */
	public boolean Contains()
	{
		return Values.size() != 0;
	}
}
