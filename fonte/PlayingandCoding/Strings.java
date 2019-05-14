import java.util.HashMap;
//inicio da classe Strings
class Strings extends Variaveis
{
	private Int inteiro;

	public static HashMap<String,String> variaveisArmazenadas = new HashMap<String, String>();

	public static HashMap<String,HashMap<Integer,String>> vetoresArmazenados = new HashMap<String,HashMap<Integer,String>>();
	
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
	
	//inicio do método armazenaVetor
	public void armazenaVetor(String linha)
	{
		inteiro = new Int();
		String value = "";
		String id = "";
		int pos = 0;
		for(int i = 0; i< linha.length(); i++)
		{
			if( linha.charAt(i) == '[')
			{
				for(int ii = i+1; ii<= linha.length(); ii++)
				{
					if(linha.charAt(ii) == ']') //tamanho do vetor
					{
						pos = ii+1;//onde começa leitura da variavel
						break;
					}
		
					else
					{
						value = value+""+linha.charAt(ii);
					}
				}
			}
			break;
		}
	
		for(int i = pos; i< linha.length();i++)
		{
			id = id+""+linha.charAt(i);
		}
		
		vetoresArmazenados.put(id, new HashMap<Integer,String>());
			
		int size = inteiro.indetificadorDeNumerosInt(value,0);
			
		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i," ");
		}
		Comparadores.tipoVariaveis.put(id, "string");
	}
	//fim do método armazenaVetor

	//inicio do método inseriValorNoVetor
	public void inseriValorNoVetor(String linha)
	{
		inteiro = new Int();

		String value = "",id="",index = "";
		
		int pos=0;
		
		for(int i = 1; i < linha.length(); i++) // o 0 vai ser [
		{
			if(linha.charAt(i) == ']')
			{
				pos = i+1;
				break;
			}
			else
			{
				index = index+""+linha.charAt(i);
			}
		} //indice do vetor do qual será armazanado a variável

		for(int i = pos; i < linha.length(); i++)
		{
			if(linha.charAt(i) == '=')
			{
				pos = i+1;
				break;
			}
			else
			{
				id = id+""+linha.charAt(i);
			}
		} //variavel encontrada

		if(linha.substring(pos,linha.length()).contains("[") && linha.substring(pos,linha.length()).contains("]"))
		{
			this.setVariavelValue(linha.substring(pos,linha.length()));
			
			int indice = inteiro.indetificadorDeNumerosInt(getVariavelValue().substring(getVariavelValue().indexOf("[")+1,getVariavelValue().indexOf("]")),0);
				
			this.setVariavelValue(linha.substring(pos,linha.length()));
			
			String nomeVetor = getVariavelValue().substring(getVariavelValue().indexOf("]")+1,getVariavelValue().length());

			String val= vetoresArmazenados.get(nomeVetor).get(indice);
			
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
		}
		
		else
		{
			value = linha.substring(pos,linha.length());
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),value.substring(1,value.length()-1));
			//o substring é para tirar os "" da string
		}
	}
	//fim do método inseriValorNoVetor
	
}
 //fim da classe Strings
