
import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Int
public class Char extends Chars
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	public static HashMap< String,Character> variaveisArmazenadas = new HashMap<String, Character>();
	
	//inicio do método verificacao
	protected boolean verificacao(String str)
	{
		
		String variavelId ="";
		String variavelValue = "";
		
		boolean verificacaoDoNomeVariavel = false;
		
		int pos=0;
		
		//laco de repetição que lê a linha
		for( int i = 0; i< str.length()-1; i++)
		{
			
			
			if ( str.charAt(i)  == '=' )
			{
				pos = i+1; //marca onde vai começar a leitura dos números

				for( int ii = 4; ii < i; ii++)
				{
					if (str.charAt(ii) == ' ')
					{
						continue;
					}
					
					else
					{
						variavelId = variavelId+ ""+str.charAt(ii);
					}
				}
				
				verificacaoDoNomeVariavel =  true;

			}
			else if( verificacaoDoNomeVariavel ) //quando a verificação do nome da váriavel é realizada ela passa por essa condicional
			{
				//laço de repetição que lê o inteiro a ser armazenado
				for(int iii = pos; iii<str.length(); iii++)
				{
					if ( (str.charAt(iii) == 34) && !(iii+2 == str.length()-1))
					{

						if(str.charAt(iii+2) == 34)
						{
						
							this.setCharValue(str.charAt(iii));
							variavelValue = ""+this.getCharValue();
							break;
						}
					}

				}
				
				this.setCharId(variavelId);
				if (variavelValue.length() == 0)
				{
					return false;
				}
				
				else 
				{
					return true;
				}
			}
		}
		return false;
	}
	//fim do método verificador

	//inicio do método ConvertStringParaInt
	private int ConvertStringParaInt(String str)
	{
		int aux = 0, value = 0, count = 0;
		
		for( int i = str.length()-1; i>= 0; i--)
		{
			aux = Integer.parseInt(String.valueOf(str.charAt(i)));//converter para string
                        value+= aux*Math.pow(10,count);
                        count++;
         	}
		return value;
	}
	//fim do método ConvertStringParaInt

	//inicio do método armazenarValor
	protected void armazenarValor ()
	{
		this.variaveisArmazenadas.put(this.getCharId(), this.getCharValue());
	}
	//fim do método armazenarValor
	
	//inicio do método verificador
	public void verificador(String lineText)
	{
		
		if( verificacao(lineText))
		{
	 		this.armazenarValor();
		}
		
		else
		{
			ErrosNaCompilacao.getLineError(1);
		}
	}
	//fim do método verificador
	
}
//fim da classe Int
