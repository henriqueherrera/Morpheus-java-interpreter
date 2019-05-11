//inicio da classe PlayingAndCoding

public class PlayingAndCoding 
{
	//inicio do método main
	public static void main(String[] args) 
	{
		Leitor interpretador = new Leitor(args[0]);
		interpretador.reader();
		System.out.println(Doubles.variaveisArmazenadas);
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
