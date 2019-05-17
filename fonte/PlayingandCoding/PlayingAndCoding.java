import java.util.HashMap;
//inicio da classe PlayingAndCoding
public class PlayingAndCoding 
{
	//inicio do método main
	public static void main(String[] args) 
	{
<<<<<<< HEAD
		try
		{
			Leitor interpretador = new Leitor(args[0]);
			long tempoInicial = System.currentTimeMillis();
			interpretador.reader();
			System.out.println("tempo de execução: " + (System.currentTimeMillis() - tempoInicial)*0.001f +" segundos");
			//System.out.println(Int.variaveisArmazenadas);
		}
		catch(Exception e)
		{
			System.out.println("algo de errado nao está certo no código "+e);
		}
=======
		//try
		//{
		Leitor interpretador = new Leitor(args[0]);
		interpretador.reader();
			//System.out.println(Int.vetoresArmazenados);
		//}
		//catch(Exception e)
		//{
		//	System.out.println("algo de errado nao está certo no código "+e);
		//}
>>>>>>> 7a1aca48440b3e0039fed5faca3ff7e5e957a9bd
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
