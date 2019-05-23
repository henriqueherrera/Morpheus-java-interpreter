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
	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{
		Int inteiro = new Int();
		String val= vetoresArmazenados.get(nomeVetor).get(indice);
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
	}

	@Override
	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{
		Int inteiro = new Int();
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),value.substring(1,value.length()-1));
		//o substring é para tirar os "" da string
	}

	@Override
	protected void armazenarVetorNaVariavel(String id, int size)
	{
		vetoresArmazenados.put(id, new HashMap<Integer,String>());
		Comparadores.tipoVariaveis.put(id, "string");

		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i," ");
		}

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
