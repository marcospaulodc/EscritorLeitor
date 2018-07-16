package implementacao3;

public class Main 
{
	public static void main(String[] args) 
	{
		Livro mensagem = new Livro();
		new Escritor(mensagem).start();
		new Leitor(mensagem);
	}
}
