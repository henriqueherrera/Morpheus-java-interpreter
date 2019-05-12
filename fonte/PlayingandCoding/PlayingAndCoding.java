//inicio da classe PlayingAndCoding
public class PlayingAndCoding 
{
	//inicio do método main
	public static void main(String[] args) 
	{
		try
		{
			Leitor interpretador = new Leitor(args[0]);
			interpretador.reader();
		}
		catch(Exception e)
		{
			System.out.println("algo de errado nao está certo no código");
		}
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
