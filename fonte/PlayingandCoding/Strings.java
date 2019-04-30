import java.io.*;
import java.util.HashMap;

//inicio da classe Strings
class Strings extends Variaveis
{
	public static HashMap<String,String> variaveisArmazenadas = new HashMap<String, String>();

	protected boolean verificacao(String str)
	{
		boolean verificacaoDoNomeVariavel = false;
		int pos = 0;
		
		//laco de repetição que lê a linha
		for( int i = 0; i< str.length()-1; i++)
		{
				
			if(str.charAt(i) == '=') 
			{
				pos = i+1;
				
				//laco pra ler o nome da variavel
				for(int ii = 6; ii < i; ii++)//ii=6 por causa do "string"
				{
					//se toiver espaço ele ignora e continua
					if(str.charAt(ii) == ' ')
					{
						continue;
					}

					else
					{
						//adiciona o nome da variavel no setVariavelId
						setVariavelId(this.getVariavelId()+""+str.charAt(ii));
					}
				}
				//verifica se o nome da variavel ta ok na classe variavel e retorna true pu um erro 
				verificacaoDoNomeVariavel = tamanhoDaVariavelId();

			}
		
			//entra nesse elseif se o verificacaoDoNomeVariavel for = true
			else if( verificacaoDoNomeVariavel)
			{
				this.valueString(str,pos);
				
				if(getVariavelId().length() == 0)
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

	@Override
	//armazena o nome e o valor das variaveis no hasmap
	protected void armazenarValor()
	{
		variaveisArmazenadas.put(this.getVariavelId(), this.getVariavelValue());
		Comparadores.tipoVariaveis.put(this.getVariavelId(),"string");
	}
	
	
	public void valueString(String str, int pos)
	{
		//laco para ver o que vai ser armazenado dentro da variavel
		for(int i = pos; i<str.length();i++)
		{
			//verifica se se tem aspas e continua a partir delas
			if( str.charAt(i) == '"')
			{
				//laco para ler oque esta dentro das aspas	
				for(int ii = i+1; ii< str.length()-1; ii++)
				{
					//verifica as aspas finais e para a verificação
					if(str.charAt(ii) == '"')
					{
						break;
					}
					else
					{
						//seta a string que vai estar relacionada com a variavel 
						setVariavelValue(getVariavelValue()+""+str.charAt(ii));  
					}
				}
			}
		}
	}
}
 

//fim da classe Strings
