import java.util.HashMap;

//inicio da classe Comparadores
public class Comparadores extends Tools
{
		public static int vl = 2; //se for if o valor tem que ser trocado para 2 se d
		// a limpeza de linha agora é feita antes de chamar comparaInt
	
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
		
		for(int i = 0; i < cleanLine.length(); i++)
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
	public boolean comparaInt( String s ) 
	{
		String[] v = getDuasVar(s);
		int t1 = 0, t2 = 0;
		int c = checaComparador(s);
		
		if (v[0].chars().allMatch(Character::isLetter)) 
		{
			t1 = Int.variaveisArmazenadas.get(v[0]);
		}
		
		else
		{
			t1 = Integer.parseInt(v[0]);
		}
		if (v[1].chars().allMatch(Character::isLetter)) 
		{
			t2 = Int.variaveisArmazenadas.get(v[1]);
		} 
		
		else
		{
			t2 = Integer.parseInt(v[1]);
		}

		switch(c) 
		{
			// 1 - ==
			// 2 - !=
			// 3 - >=
			// 4 - <=
			// 5 - >
			// 6 - <
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
	
	//inicio do método comparaChar
	public boolean comparaChar(String expressao)
	{
		char v1='-',v2='+';//so para inicializar
		for(int i = 0; i< expressao.length(); i++)
		{
			if(expressao.charAt(i) == '=' && expressao.charAt(i+1) == '=')
			{
				
				if(tipoVariaveis.get(expressao.substring(0,i)).equals("char"))
				{
					v1 = Char.variaveisArmazenadas.get(expressao.substring(0,i));
				}

				if(tipoVariaveis.get(expressao.substring(i+2,expressao.length())).equals("char"))
				{
					v2 = Char.variaveisArmazenadas.get(expressao.substring(i+2,expressao.length()));
				}
			}
		}
		if( v1 == v2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//fim do método comparaChar;


	// inicio do método comparaStr 
	public boolean comparaStr(String line) //esse metodo vai ler o nome das variaveis usadas e vai comparar com o conteudo delas e retornar true se forem iguals 
	{
		String cleanLine = tiraEspacos(line);
		String str1 = "", str2 = "";
		
		for(int i = 2; i < cleanLine.length()-1; i++) //le a linha toda ignorando o if 
		{
			
			if(cleanLine.charAt(i) == '=' && cleanLine.charAt(i+1) == '=') //ve se é == e começa a ler a variavel depois dele 
			{
				
				for(int ii = i+2; ii< cleanLine.length(); ii++)//laço que le toda a variavel depois do == até o ;
				{
					
					
					if (cleanLine.charAt(ii) == '=') //se o caractere for = ele continua e não adiciona no str
					{
						continue;
					}
					
					else if (cleanLine.charAt(ii) == ';' ) //se o caractere for = ele para o for e não adiciona mais nada 
					{
						break;
					}		
					
					else  //se não for = ou ; ele adiciona os caracteres na variavel
					{
						str2=str2+""+cleanLine.charAt(ii);//adiciona todos os caracteres da variavel na str2
						
					}
					
				}
				break;
			}
			
			else//le toda variavel depois do if e antes do ==
			{
				
				str1=str1+""+cleanLine.charAt(i);//adiciona todos os caracteres da variavel antes do == na str1
				
			}
			
		}
		
		//busca o valor referente ao nome da variavel
		str1 = Strings.variaveisArmazenadas.get(str1);
		str2 = Strings.variaveisArmazenadas.get(str2);
	
		if (str1.equals(str2)) //compara se são iguais e retorna true 
		{
			return true;
		}
		
		else  //se forem diferentes retorna false
		{
			return false;
		}
		

	
	}
	//fim do método comparaStr;


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
