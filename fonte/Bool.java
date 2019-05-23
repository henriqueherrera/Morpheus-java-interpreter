import java.util.HashMap;
//inicio da classe Bool

public class Bool extends Variaveis
{
	public static int leituraDaLinha;

	private Int inteiro;

	public static HashMap<String, Boolean> variaveisArmazenadas = new HashMap<String, Boolean>();
	public static HashMap<String,HashMap<Integer,Boolean>> vetoresArmazenados = new HashMap<String,HashMap<Integer,Boolean>>();

	@Override
	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{
		Int inteiro = new Int();
		boolean val= vetoresArmazenados.get(nomeVetor).get(indice);
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
	}

	@Override
	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{
		Int inteiro = new Int();
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),Boolean.valueOf(value.substring(0,value.length())));
	}

	//inicio do método indentificaValor
	protected void indentificaValor(String str, int pos)
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

	}
	//fim do método indentificaValor

	@Override
	protected void armazenarVetorNaVariavel(String id, int size)
	{
		vetoresArmazenados.put(id, new HashMap<Integer,Boolean>());
		Comparadores.tipoVariaveis.put(id, "bool");

		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i, false);
		}
		
	}

	//inicio do método armazenarValor
	@Override
	protected void armazenarValor()
	{
		variaveisArmazenadas.put(this.getBoolId(), this.getBoolValue());
		Comparadores.tipoVariaveis.put(this.getBoolId(),"bool");//quando é necessario trocar o valor
	}
	//fim do método armazenarValor
}
