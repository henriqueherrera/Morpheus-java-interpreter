import java.util.HashMap;

//inicio da classe Comparadores
public class Comparadores extends Tools
{
	public static HashMap<String,String> tipoVariaveis = new HashMap<String,String>(); //armazena os tipos das variaveis
	public Int ints = new Int();

	//inicio do método getVariaveis
	public void getVariaveis( String line )
	{
		String v1 = "", v2 = "", cleanLine = tiraEspacos(line);
		
		int pos=0;

		for(int i = 0; i < cleanLine.length(); i++)
		{
			if( cleanLine.charAt(i) == '=')
			{
				pos = (i+1);
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
		this.trocaDeVariaveis(v1,v2,cleanLine,pos); //troca o valor da variavel
	}
	//fim do método getVariaveis
	
		//inicio do método getDuasVar
	public String[] getDuasVar( String line )
	{
		String cleanLine = tiraEspacos(line);
		String[] v = {"",""};
		
		for(int i = 2; i < cleanLine.length(); i++)
		{
			if( ( cleanLine.charAt(i) == '=' ) && ( cleanLine.charAt(i+1) == '=' )  
			|| ( ( cleanLine.charAt(i) == '!' ) && ( cleanLine.charAt(i+1) == '=' ) 
			|| ( ( cleanLine.charAt(i) == '>' ) && ( cleanLine.charAt(i+1) == '=' ) 
			|| ( ( cleanLine.charAt(i) == '<' ) && ( cleanLine.charAt(i+1) == '=' ) ) ) ) )
			{
				for(int ii = i+2; ii< cleanLine.length()-1; ii++)
				{
					v[1]=v[1]+""+cleanLine.charAt(ii);
				}//laço que pega o nome da variavel dps de ==, !=, >= e <=
				
				break;
			}
			else if( ( cleanLine.charAt(i) == '>' ) )  {
				for(int ii = i+1; ii< cleanLine.length()-1; ii++)
				{
					v[1]=v[1]+""+cleanLine.charAt(ii);
				}//laço que pega o nome da variavel dps de >
				
				break;
			}
			else if( ( cleanLine.charAt(i) == '<' ) )  {
				for(int ii = i+1; ii< cleanLine.length()-1; ii++)
				{
					v[1]=v[1]+""+cleanLine.charAt(ii);
				}//laço que pega o nome da variavel dps de <
				
				break;
			}
			
			else
			{
				v[0]=v[0]+""+cleanLine.charAt(i);
			}//nome antes do igual
		}
		
		return v;
	}
	//fim do método getDuasVar

	//inicio do método checaComparador
	public int checaComparador( String line )
	{
		// 1 - ==
		// 2 - !=
		// 3 - >=
		// 4 - <=
		// 5 - >
		// 6 - <
		
		String cleanLine = tiraEspacos(line);
		
		for(int i = 0; i < cleanLine.length(); i++)
		{
			if( ( cleanLine.charAt(i) == '=') && ( cleanLine.charAt(i+1) == '=' ) ) {
				return 1;
			}
			
			else if( ( cleanLine.charAt(i) == '!') && ( ( cleanLine.charAt(i+1) == '=') ) ) {
				return 2;
			}
			
			else if( ( cleanLine.charAt(i) == '>') && ( cleanLine.charAt(i+1) == '=' ) ) {
				return 3;
			}
			
			else if( ( cleanLine.charAt(i) == '<') && ( cleanLine.charAt(i+1) == '=' ) ) {
				return 4;
			}
			
			else if( ( cleanLine.charAt(i) == '>') ) {
				return 5;
			}
			
			else if( ( cleanLine.charAt(i) == '<') ) {
				return 6;
			}
		}
		
		return 0;
	}
	//fim do método checaComparador
	
	//inicio do método comparaInt
	// comparação de igual --- EX: if a == b
	public boolean comparaInt( String s ) 
	{
		// 1 - ==
		// 2 - !=
		// 3 - >=
		// 4 - <=
		// 5 - >
		// 6 - <
		String cleanLine = tiraEspacos(s);
		String[] v = getDuasVar(s);
		int t1 = 0, t2 = 0;
		// 1 = igual, 2 = maior, 3 = menor
		int condicao = checaComparador(s);

		if (v[0].chars().allMatch(Character::isLetterOrDigit)) 
		{
			t1 = Int.variaveisArmazenadas.get(v[0]);
		}
		
		else
		{
			t1 = Integer.parseInt(v[0]);
		}
		
		if (v[1].chars().allMatch(Character::isLetterOrDigit)) 
		{
			t2 = Int.variaveisArmazenadas.get(v[1]);
		} 
		
		else
		{
			t2 = Integer.parseInt(v[1]);
		}

		int c = checaComparador(s);

		switch(c) 
		{
			case 1:
				if (t1 == t2) return true;
				else return false;
			
			case 2:
				if (t1 != t2) return true;
				else return false;
			
			case 3:
				if (t1 >= t2) return true;
				else return false;
			case 4:
				if (t1 <= t2) return true;
				else return false;
			case 5:
				if (t1 > t2) return true;
				else return false;
			
			case 6:
				if (t1 < t2) return true;
				else return false;
			
			default:
				return false;
			}
	}
	//fim do método comparaInt

	//inicio do método trocaDeVariaveis
	public void trocaDeVariaveis( String v1, String v2,String line, int pos )
	{		
		if( tipoVariaveis.get(v1).equals("int"))
		{
				if (48<= v2.charAt(0) && v2.charAt(0) <= 57)
				{
					Int.variaveisArmazenadas.put(v1,ints.indetificadorDeNumerosInt(line,pos)); // se o primeiro caractere deposi do = for
														// um numero entre 0 e 9 ele reconhece como se fosse um numero a ser armazenado
				}
				
				else
				{
					Int.variaveisArmazenadas.put(v1,Int.variaveisArmazenadas.get(v2));// troca uma variavel pela outra
				}

		}

		else if( tipoVariaveis.get(v1).equals("float") && tipoVariaveis.get(v2).equals("float"))
		{
			Float.variaveisArmazenadas.put(v1,Float.variaveisArmazenadas.get(v2));

		}

		else if( tipoVariaveis.get(v1).equals("bool"))
		{
			if(v2.equals("false") || v2.equals("true"))
			{
				Bool.variaveisArmazenadas.put(v1,Boolean.valueOf(v2));
			}
			else if(tipoVariaveis.get(v2).equals("bool"))
			{
				Bool.variaveisArmazenadas.put(v1,Bool.variaveisArmazenadas.get(v2));
		
			}
		}

		else if( tipoVariaveis.get(v1).equals("char"))
		{
			if(v2.charAt(0) == 39 && v2.charAt(2)== 39)
			{
				Char.variaveisArmazenadas.put(v1,v2.charAt(1));
			}
			else if(tipoVariaveis.get(v2).equals("char"))
			{
				Char.variaveisArmazenadas.put(v1,Char.variaveisArmazenadas.get(v2));
			}
		}
		else if( tipoVariaveis.get(v1).equals("string"))
		{
			if(v2.charAt(0) == '"')
			{
				Strings.variaveisArmazenadas.put(v1, v2.substring(1, v2.length()-1));
			}
			else if (tipoVariaveis.get(v2).equals("string"))
			{
				Strings.variaveisArmazenadas.put(v1, Strings.variaveisArmazenadas.get(v2));
			}
		}


	}
	//fim do método trocaDeVariaveis

}
//fim da classe Comparadores
