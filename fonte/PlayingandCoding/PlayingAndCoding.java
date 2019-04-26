import java.io.*;
import java.util.Scanner;

//inicio da classe PlayingAndCoding

public class PlayingAndCoding 
{
	//inicio do método main
	public static void main(String[] args) 
	{
		Leitor interpretador = new Leitor(args[0]);
		
		interpretador.reader();
			
		System.out.println("Ints armazenados "+Int.variaveisArmazenadas);
        	System.out.println("Floats armazenados "+Float.variaveisArmazenadas);
        	System.out.println("Chars armazenados "+Char.variaveisArmazenadas);
		System.out.println("Boolean"+Bool.variaveisArmazenadas);
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
