import java.io.*;
import java.util.Scanner;

public class PlayingAndCoding 
{
	public static void main(String[] args) 
	{
		Leitor interpretador = new Leitor(args[0]);
		
		interpretador.reader();
		
		System.out.println("Variaveis armazenadas "+Int.variaveisArmazenadas);
	}
	
}	
