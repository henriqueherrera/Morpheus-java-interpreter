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
		
		//imprime os ints armazenados
		System.out.println("Ints armazenados "+Int.variaveisArmazenadas);
       
		//imprime os floats armazenados	
		System.out.println("Floats armazenados "+Float.variaveisArmazenadas);
        
		//imprime os chars armazenados	
		System.out.println("Chars armazenados "+Char.variaveisArmazenadas);
		
		//imprime os boleanos armazenados
		System.out.println("Boolean "+Bool.variaveisArmazenadas);
		
		//imprime as strings armazenados
		System.out.println("Strings "+Strings.variaveisArmazenadas); 
		
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
