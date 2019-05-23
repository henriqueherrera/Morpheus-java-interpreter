import java.util.HashMap;

//inicio da classe Comparadores
public class Comparadores extends Tools
{

	public static HashMap<String,String> tipoVariaveis = new HashMap<String,String>(); //armazena os tipos das variaveis

	public Int ints = new Int();

	public Doubles  conversorDouble = new Doubles();

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
				}// Laço que pega o nome da variavel dps do =
				break;

			}
			else
			{
				v1=v1+""+cleanLine.charAt(i);
			} // Nome antes do igual

		}
		this.trocaDeVariaveis(v1,v2,cleanLine,pos); //troca o valor da variavel

	}
	//fim do método getVariaveis

	public String valorDoVetor(String value)
	{
		Int inteiro = new Int();
		String nomeVariavel = value.substring(value.indexOf("]")+1,value.length()); //pega o nome da variavel

		if (Comparadores.tipoVariaveis.containsKey(nomeVariavel))
		{
			int index = inteiro.indetificadorDeNumerosInt(value.substring(value.indexOf("[")+1, value.indexOf("]")),0);

			if(Comparadores.tipoVariaveis.get(nomeVariavel).equals("int"))
			{
				return ""+Int.vetoresArmazenados.get(nomeVariavel).get(index);
			}

			else if(Comparadores.tipoVariaveis.get(nomeVariavel).equals("double"))
			{
	 			return ""+Doubles.vetoresArmazenados.get(nomeVariavel).get(index);
			}

			else if(Comparadores.tipoVariaveis.get(nomeVariavel).equals("char"))
			{
		   		return ""+Char.vetoresArmazenados.get(nomeVariavel).get(index);
	    }

			else if(Comparadores.tipoVariaveis.get(nomeVariavel).equals("string"))
			{
				return ""+Strings.vetoresArmazenados.get(nomeVariavel).get(index);
			}

			else if(Comparadores.tipoVariaveis.get(nomeVariavel).equals("bool"))
			{
				return ""+Bool.vetoresArmazenados.get(nomeVariavel).get(index);
			}

		}
		else
		{
			return nomeVariavel;
		}
		return "";
	}

	//inicio do método comparaChar
	public boolean comparaChar(String expressao)
	{
		String var1,var2;
		char v1 = '?', v2 = '?';
		String comparacao = "";

		for(int i = 0; i< expressao.length(); i++)
		{
			if((expressao.charAt(i) == '=' || expressao.charAt(i) == '!') && expressao.charAt(i+1) == '=')
			{
				comparacao =  expressao.substring(i,i+2);
				var1 = expressao.substring(0,i);
				var2 = expressao.substring(i+2,expressao.length());

				if(var1.contains("[") && var1.contains("]")) //se a variavel for vetor
				{
					v1 = valorDoVetor(var1).charAt(0);
				}

				else if (var1.contains("'")) //se for uma string normal
        {
          v1 = var1.replaceAll("'", "").charAt(0);
				}

				else //se for uma variavel
        {
					v1 = Char.variaveisArmazenadas.get(var1);
				}

				if(var2.contains("[") && var2.contains("]")) //se a variavel for vetor
				{
					v2 = valorDoVetor(var2).charAt(0);
				}

				else if (var2.contains("'")) //se for uma string normal
        {
          v2 = var2.replaceAll("'", "").charAt(0);
				}

				else //se for uma variavel
        {
					v2 = Char.variaveisArmazenadas.get(var2);
				}

			}

		}
		return valorBooleanoDaExpressaoAlfabetica(comparacao, ""+v1, ""+v2);

	}
	//fim do método comparaChar;

	// inicio do método comparaInt
	public boolean comparaInt(String expressao)
	{
		int v1 = 0, v2 = 0; //so para inicializar
		String comparacao ="",var1 = "", var2 = "";
		for(int i = 0; i< expressao.length(); i++)
		{
			if((expressao.charAt(i) == '='||expressao.charAt(i) == '>'||expressao.charAt(i) == '<'||expressao.charAt(i) == '!') && (expressao.charAt(i+1) == '=' ||expressao.charAt(i+1) == '<' ||expressao.charAt(i+1) == '>' ))
			{
				comparacao = expressao.substring(i,i+2);

				var1 = expressao.substring(0,i);

				var2 = expressao.substring(i+2, expressao.length());

				if(var1.contains("[") && var1.contains("]"))
				{
					v1 =  (int)Double.parseDouble(valorDoVetor(var1));
				}

				else
				{
					try{v1 = (int)Double.parseDouble(var1);}
					catch(Exception e){v1 = Int.variaveisArmazenadas.get(var1);}
				}

				if(var2.contains("[") && var2.contains("]"))
				{
					v2 = (int)Double.parseDouble(valorDoVetor(var2));
				}

				else
				{
					try{v2 = (int)Double.parseDouble(var2);}
					catch(Exception e){v2 = Int.variaveisArmazenadas.get(var2);}
				}

			}
		}
		return valorBooleanoDaExpressao(comparacao,v1,v2);
	}

	// fim do método comparaInt

	// inicio do método comparaDouble
	public boolean comparaDouble(String expressao)
	{
		double v1 = 0, v2 = 0; //so para inicializar
		String comparacao ="",var1 = "", var2 = "";
		for(int i = 0; i< expressao.length(); i++)
		{
			if((expressao.charAt(i) == '='||expressao.charAt(i) == '>'||expressao.charAt(i) == '<'||expressao.charAt(i) == '!') && (expressao.charAt(i+1) == '=' ||expressao.charAt(i+1) == '<' ||expressao.charAt(i+1) == '>' ))
			{
				comparacao = expressao.substring(i,i+2);

				var1 = expressao.substring(0,i);

				var2 = expressao.substring(i+2, expressao.length());

				if(var1.contains("[") && var1.contains("]"))
				{
					v1 =  Double.parseDouble(valorDoVetor(var1));
				}

				else
				{
					try{v1 = Double.parseDouble(var1);}
					catch(Exception e){v1 = Doubles.variaveisArmazenadas.get(var1);}
				}

				if(var2.contains("[") && var2.contains("]"))
				{
					v2 = Double.parseDouble(valorDoVetor(var2));
				}

				else
				{
					try{v2 = Double.parseDouble(var2);}
					catch(Exception e){v2 = Doubles.variaveisArmazenadas.get(var2);}
				}

			}

		}
		return valorBooleanoDaExpressao(comparacao,v1,v2);

	}
	// fim do método comparaDouble

	// inicio do método comparaStr
	public boolean comparaStr(String expressao) //esse metodo vai ler o nome das variaveis usadas e vai comparar com o conteudo delas e retornar true se forem iguals
	{
		String v1 = "",v2 = "";
		String var1, var2, comparacao = "";
		for(int i = 0; i< expressao.length(); i++)
		{
			if((expressao.charAt(i) == '=' || expressao.charAt(i) == '!') && expressao.charAt(i+1) == '=')
			{
				comparacao =  expressao.substring(i,i+2);
				var1 = expressao.substring(0,i);
				var2 = expressao.substring(i+2,expressao.length());

				if(var1.contains("[") && var1.contains("]")) //se a variavel for vetor
				{
					v1 = valorDoVetor(var1);
				}

				else if (var1.charAt(0) == '"') //se for uma string normal
        {
					char aux =  '"';
                    v1 = var1.replaceAll(""+aux, ""); //artificio tecnico para ajustar a string
				}

				else //se for uma variavel
        {
				    v1 = Strings.variaveisArmazenadas.get(var1);
				}


				if(var2.contains("[") && var2.contains("]"))
				{
					v2 = valorDoVetor(var2);
				}

				else if (var2.charAt(0) == '"')
        {
					char aux =  '"';
                    v2 = var2.replaceAll(""+aux, ""); //artificio tecnico para ajustar a string
				}

				else
        {
				    v2 = Strings.variaveisArmazenadas.get(var2);
				}

			}

		}

		return valorBooleanoDaExpressaoAlfabetica(comparacao, v1, v2);
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

		else if( tipoVariaveis.get(v1).equals("double"))
		{
			System.out.println(tipoVariaveis.get(v1).equals("double"));

			Doubles.variaveisArmazenadas.put(v1,Doubles.variaveisArmazenadas.get(v2));
			if (48<= v2.charAt(0) && v2.charAt(0) <= 57)
			{
				Doubles.variaveisArmazenadas.put(v1,conversorDouble.convertDouble(line,pos)); // se o primeiro caractere deposi do = for
				// um numero entre 0 e 9 ele reconhece como se fosse um numero a ser armazenado
			}

			else
			{
				Doubles.variaveisArmazenadas.put(v1,Doubles.variaveisArmazenadas.get(v2));// troca uma variavel pela outra
			}

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

	//inicio do método valorBooleanoDaExpressao
	public boolean valorBooleanoDaExpressao(String comparacao,double v1, double v2)
	{
		if(comparacao.equals(">="))
		{
			return v1 >= v2 ? true:false;
		}

		else if(comparacao.equals(">>"))
		{
			return v1 > v2 ? true:false;
		}

		else if(comparacao.equals("<<"))
		{
			return v1 < v2 ? true:false;
		}

		else if(comparacao.equals("<="))
		{
			return v1 <= v2 ? true:false;
		}
		else if(comparacao.equals("=="))
		{
			return v1 == v2 ? true:false;
		}
		else if(comparacao.equals("!="))
		{
			return v1 == v2 ? false:true;
		}
		return false;
	}
	//fim do método valorBooleanoDaExpressao

    public boolean valorBooleanoDaExpressaoAlfabetica(String comparacao,String v1, String v2)
	{
		if(comparacao.equals("=="))
		{
			return v1.equals(v2);
		}
		else if(comparacao.equals("!="))
		{
			return (!(v1.equals(v2)));
		}
		return false;
    }
}
//fim da classe Comparadores
