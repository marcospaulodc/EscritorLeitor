package implementacao3;

public class Leitor extends Thread
{
	Livro livro = new Livro();
		
	public Leitor(Livro livro)
	{
		this.livro = livro;
		this.start();
	}
	
	public void mLer()
	{
		synchronized (this.livro) 
		{	
			System.out.println(livro.getMensagem());
			this.livro.notify();
			try
			{
				this.sleep(1000);
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
			mLer();
		}
	}
}