import java.io.*;
import java.util.HashMap;

//inicio da classe Strings
class Strings extends Variaveis
{
	public static HashMap<String,String> variaveisArmazenadas = new HashMap<String, String>();

	protected void indentificaValor(String str, int pos)
	{
		this.valueString(str,pos);
	}
	@Override
	//armazena o nome e o valor das variaveis no hasmap
	protected void armazenarValor()
	{
		variaveisArmazenadas.put(this.getVariavelId(), this.getVariavelValue());
		Comparadores.tipoVariaveis.put(this.getVariavelId(),"string");
	}
	
	//inicio do método valueString	
	public void valueString(String str, int pos)
	{
		boolean fimDaString = false;
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
						
						fimDaString = true;
						break;
					}
					else
					{

						//seta a string que vai estar relacionada com a variavel 
						setVariavelValue(getVariavelValue()+""+str.charAt(ii));  
					}
				}
			}
			else if(fimDaString)
			{
				break;
			}
		}
	}
	//fim do método valueString
}
 

//fim da classe Strings
