import java.util.HashMap;
//inicio da classe Double
public class Doubles extends Variaveis
{
    //dicionario que armazena as váriaveis criadas
    public static HashMap< String, Double> variaveisArmazenadas = new HashMap<String, Double>();
    
    public static HashMap< String, HashMap<Integer, Double>> vetoresArmazenados = new HashMap<String, HashMap<Integer, Double>>();
	
    Int conversor = new Int();
	
	Tools espaco = new Tools();

    Int inteiros;

	@Override
	protected void indentificaValor(String str,int pos)
	{
		double value = convertDouble(str,pos);
		setDoubleValue(value);
		setVariavelValue(""+getDoubleValue());
	}

	@Override
	protected void armazenarVetorNaVariavel(String id, int size) 
	{
		vetoresArmazenados.put(id, new HashMap<Integer,Double>());
		Comparadores.tipoVariaveis.put(id, "double");
		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i,0.0);
		}
	}
	
	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{		
		double val= vetoresArmazenados.get(nomeVetor).get(indice);
		vetoresArmazenados.get(id).put(inteiros.indetificadorDeNumerosInt(index,0),val);
	}

	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{
		inteiros = new Int();
		vetoresArmazenados.get(id).put(inteiros.indetificadorDeNumerosInt(index,0),convertDouble(value+" ",0)); //esse +" " é um ajuste para converter certinho para double
	}	
	//inicio do metodo convertDouble
	public double convertDouble(String str, int pos)
	{
		setDoubleId(getVariavelId());
		str = espaco.tiraEspacos(str);
		if(str.contains(";"))
		{
		
			str = str.replace(";","");
		}
		return Double.parseDouble(str.substring(str.indexOf("=")+1,str.length()));
	}
	//fim do método convertDouble
	@Override
	protected void armazenarValor()
	{
        variaveisArmazenadas.put(getDoubleId(), getDoubleValue());
		Comparadores.tipoVariaveis.put(getDoubleId(),"double");
	}
}
//fim do método armazenarValor
