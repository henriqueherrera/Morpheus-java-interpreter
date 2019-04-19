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
		
		System.out.println("Variaveis armazenadas "+Int.variaveisArmazenadas);
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
