package implementacao3;

import java.util.Random;

public class Escritor extends Thread
{
	Livro livro = new Livro();
	private Random randomico = new Random();
	
	public Escritor(Livro livro)
	{
		this.livro = livro;
	}
	
	public void mEscrever()
	{
		synchronized (this.livro) 
		{
			char letra = (char)(randomico.nextInt(26) + 'a');
			this.livro.setMensagem(letra);
			this.livro.notify();
			
			try
			{
				this.livro.wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public void run()
	{
		while(true)
		{
			mEscrever();
		}
	}
}