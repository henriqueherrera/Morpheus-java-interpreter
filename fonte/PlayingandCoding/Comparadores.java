import java.util.HashMap;

public class Comparadores
{
	public static HashMap<String,String> tipoVariaveis = new HashMap<String,String>(); //armazena os tipos das variaveis

	//inicio do método getVariaveis
	public void getVariaveis( String line )
	{
		String v1 = "", v2 = "", cleanLine = tiraEspacos(line);
		
		for(int i = 0; i < cleanLine.length(); i++)
		{
			if( cleanLine.charAt(i) == '=')
			{
				for(int ii = i+1; ii< cleanLine.length()-1; ii++)
				{	
					v2=v2+""+cleanLine.charAt(ii);
				}//laço que pega o nome da variavel dps do =
				break;
			}
			else
			{
				v1=v1+""+cleanLine.charAt(i);
			}//nome antes do igual
		}
		this.trocaDeVariaveis(v1,v2);
	}
	//fim do método getVariaveis
	
	//inicio do método trocaDeVariaveis
	public void trocaDeVariaveis( String v1, String v2 )
	{
		if( tipoVariaveis.get(v1).equals("int") && tipoVariaveis.get(v2).equals("int"))
		{
			Int.variaveisArmazenadas.put(v1,Int.variaveisArmazenadas.get(v2));
		}

		else if( tipoVariaveis.get(v1).equals("float") && tipoVariaveis.get(v2).equals("float"))
		{
			Float.variaveisArmazenadas.put(v1,Float.variaveisArmazenadas.get(v2));
		
		}
		else if( tipoVariaveis.get(v1).equals("char") && tipoVariaveis.get(v2).equals("char"))
		{
			Char.variaveisArmazenadas.put(v1,Char.variaveisArmazenadas.get(v2));
		}
	}
	//fim do método trocaDeVariaveis
	
	public String tiraEspacos(String line)
	{
		String cleanLine= "";
		for(int i = 0; i < line.length(); i++)
		{
			if( line.charAt(i) != ' ')
			{
				cleanLine= cleanLine+""+line.charAt(i);
			}
		}//esse laço tira os espaços da linha
		return cleanLine;
		
	}
}
