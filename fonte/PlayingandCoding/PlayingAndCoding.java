//inicio da classe PlayingAndCoding
public class PlayingAndCoding 
{
	//inicio do método main
	public static void main(String[] args) 
	{
		try
		{
			Leitor interpretador = new Leitor(args[0]);
			long tempoInicial = System.currentTimeMillis();
			interpretador.reader();
			System.out.println("tempo de execução: " + (System.currentTimeMillis() - tempoInicial)*0.001f +" segundos");
		}
		catch(Exception e)
		{
			System.out.println("algo de errado nao está certo no código "+e);
		}
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
