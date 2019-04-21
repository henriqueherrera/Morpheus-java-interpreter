import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Bool 
public class Bool extends Variaveis
{
	public static int leituraDaLinha;
	public static HashMap<String, Boolean> variaveisArmazenadas = new HashMap<String, Boolean>(); 

	//inicio do método verificacao
	@Override
	protected boolean verificacao(String str)
	{
		boolean verificacaoDoNomeVariavel = false;

		int pos = 0;

		//laço de repetição que lê a linha
		for( int i = 0; i < str.length()-1; i++)
		{
			if ( str.charAt(i)  == '=')
			{
				pos = i+1;

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
				verificacaoDoNomeVariavel = tamanhoDaVariavelId();
			}

			else if( verificacaoDoNomeVariavel)
			{
				for(int iii = pos; iii < str.length(); iii++)
				{
					if( (str.charAt(iii) != ' ') && (str.charAt(iii)  != ';'))
					{

						setVariavelValue(getVariavelValue()+""+str.charAt(iii));
					}
				}

				setBoolId(getVariavelId());
				setBoolValue(Boolean.valueOf(this.getVariavelValue()));

				
				if(this.getVariavelId().length() == 0)
				{
					return false;
				}

				else if ( (this.getVariavelValue().equals("true")) || (this.getVariavelValue().equals("false")))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
		
	}
	//fim do método verificacao

	//inicio do método armazenarValor
	@Override
	protected void armazenarValor()
	{	
		variaveisArmazenadas.put(this.getBoolId(), this.getBoolValue());
	}
	//fim do método armazenarValor
}
