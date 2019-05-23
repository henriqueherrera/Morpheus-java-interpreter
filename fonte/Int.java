import java.util.HashMap;
//inicio da classe Int
public class Int extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static HashMap< String,Integer> variaveisArmazenadas = new HashMap<String, Integer>();
	public static HashMap< String, HashMap<Integer,Integer>> vetoresArmazenados = new HashMap<String, HashMap<Integer,Integer>>();


	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{
		Int inteiro = new Int();
		int val= vetoresArmazenados.get(nomeVetor).get(indice);
		vetoresArmazenados.get(id).put(indetificadorDeNumerosInt(index,0),val);
	}

	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{
		Int inteiro = new Int();
		vetoresArmazenados.get(id).put(indetificadorDeNumerosInt(index,0),indetificadorDeNumerosInt(value,0));
	}

	@Override
	protected void armazenarVetorNaVariavel(String id, int size)
	{
		vetoresArmazenados.put(id, new HashMap<Integer,Integer>());
		Comparadores.tipoVariaveis.put(id, "int");

		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i,0);
		}

	}

	@Override
	protected void indentificaValor(String str,int pos)
	{
		setIntId( getVariavelId());
		setIntValue( indetificadorDeNumerosInt(str,pos));
	}

	@Override
	protected void armazenarValor ()
	{
		variaveisArmazenadas.put(getIntId(), getIntValue());
		Comparadores.tipoVariaveis.put(getIntId(), "int");
	}

	//inicio do método indenrificadorDeNumerosInt
	public int indetificadorDeNumerosInt(String str,int pos)
	{
		setVariavelValue(""); //ajuste tecnico para funcionar numeros negativos em vetores
		int negativo = 1;

		for(int iii = pos; iii<str.length(); iii++)
		{

			if( (str.charAt(iii) == '-') && (getVariavelValue().length() == 0))
			{
				negativo = -1;
			}

			else if ((48<= str.charAt(iii)) && (str.charAt(iii)  <=57))
			{
				setVariavelValue(getVariavelValue()+""+str.charAt(iii));
			}

			else if ( (str.charAt(iii)) != ';' && (str.charAt(iii) != ' '))
			{
				ErrosNaCompilacao.caractere = str.charAt(iii);

				ErrosNaCompilacao.getLineError(2);
			}

		}
		return this.ConvertStringParaInt(this.getVariavelValue())*negativo;

	}
	//fim do método indentificadorDeNumerosInt
}
//fim da classe Int
