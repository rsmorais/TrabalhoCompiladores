package ClassesCompilador;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnaliseLexica teste = new AnaliseLexica();
		teste.Init("teste.txt");
		teste.Print();
	}

}
