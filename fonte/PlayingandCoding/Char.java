import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Char
public class Char extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	public static HashMap< String,Character> variaveisArmazenadas = new HashMap<String, Character>();
	
	//inicio do método verificacao
	@Override
	protected boolean verificacao(String str)
	{		
		boolean verificacaoDoNomeVariavel = false;
		
		int pos=0;
		
		//laco de repetição que lê a linha
		for( int i = 0; i< str.length()-1; i++)
		{
			
			
			if ( str.charAt(i)  == '=' )
			{
				pos = i+1; //marca onde vai começar a leitura do char

				for( int ii = 4; ii < i; ii++)
				{
					if (str.charAt(ii) == ' ')
					{
						continue;
					}
					
					else
					{
						setVariavelId(getVariavelId()+ ""+str.charAt(ii));
					}
				}
				
				verificacaoDoNomeVariavel =  tamanhoDaVariavelId();

			}
			else if( verificacaoDoNomeVariavel ) //quando a verificação do nome da váriavel é realizada ela passa por essa condicional
			{
				//laço de repetição que lê o char a ser armazenado
				for(int iii = pos; iii<str.length(); iii++)
				{
					if ( (str.charAt(iii) == 39) && !(iii+2 == str.length()-1))
					{

						if(str.charAt(iii+2) == 39)
						{
						
							this.setCharValue(str.charAt(iii+1));
							setVariavelValue(""+this.getCharValue());
							break;
						}
					}

				}
				
				this.setCharId(getVariavelId());
				
				if (getVariavelValue().length() == 0)
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
	
	//inicio do método armazenarValor
	@Override
	protected void armazenarValor ()
	{
		variaveisArmazenadas.put(this.getCharId(), this.getCharValue());
	}
	//fim do método armazenarValor
}

//fim da classe Char
