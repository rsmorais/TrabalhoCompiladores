package ClassesCompilador;

import java.util.LinkedList;
import java.util.List;

public class FilaTokens {
	
	private List<String> Values = new LinkedList<String>();
	private List<String> Classes = new LinkedList<String>();
	
	/**
	 * @author 			Rafael Souza
	 * @param  Class 	String que informa qual é a classe do token
	 * @param  Value 	String que informa qual é o valor do token
	 */
	public void SetToken (String Class, String Value)
	{
		Values.add(Value);
		Classes.add(Class);
	}
	
	/**
	 * @author	Rafael Souza
	 * @see 	Deve ser utilizado juntamente com o método GetClass()
	 * @return  Retorna a string que está no topo da pilha de Valores do token
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
	 * @see 	Deve ser utilizado juntamente com o método GetValue()
	 * @return  Retorna a string que está no topo da pilha de Classe do token
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
	 * @return	Retorna true se contém Tokens, retorna false caso contrário  	
	 */
	public boolean Contains()
	{
		return Values.size() != 0;
	}
}
