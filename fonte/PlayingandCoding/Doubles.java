import java.util.HashMap;
//inicio da classe Double
public class Doubles extends Variaveis
{
    //dicionario que armazena as váriaveis criadas
    public static HashMap< String, Double> variaveisArmazenadas = new HashMap<String, Double>();
    public static HashMap< String, HashMap<Integer, Double>> vetoresArmazenados = new HashMap<String, HashMap<Integer, Double>>();
	Int conversor = new Int();
	Int inteiros;
	@Override
	protected void indentificaValor(String str,int pos)
	{
		double value = convertDouble(str,pos);
		setDoubleValue(value);
		setVariavelValue(""+getDoubleValue());
	}
	//inicio do metodo convertDouble
	public double convertDouble(String str, int pos)
	{
		setDoubleId(getVariavelId());
        int numerosDpsDaVirgula = str.substring(str.indexOf("."),str.length()).length();
        double x = 1;
        for (int i = 1; i<numerosDpsDaVirgula; i++)
        {
            x = x*10;
		}
		x= 10/x;
		str = str.replace(".","");

		return conversor.indetificadorDeNumerosInt(str,pos)*x;
	}
	//fim do metodo convertDouble
	//inicio do método armazenarValor
	@Override
	protected void armazenarValor()
	{
        variaveisArmazenadas.put(getDoubleId(), getDoubleValue());
		Comparadores.tipoVariaveis.put(getDoubleId(),"double");
	}
	//inicio do método armazenaVetor
	public void armazenaVetor(String linha)
	{
		String value = "";
		String id = "";
		int pos = 0;
		this.inteiros = new Int();
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

		vetoresArmazenados.put(id, new HashMap<Integer,Double>());
		
		int size = inteiros.indetificadorDeNumerosInt(value,0);
		
		for(int i = 0; i < size ;i++)
		{

			vetoresArmazenados.get(id).put(i,0.0);

		}
		Comparadores.tipoVariaveis.put(id, "double");
	}
	//fim do método armazenaVetor
	
	//inicio do método inseriValorNoVetor
	public void inseriValorNoVetor(String linha)
	{
		
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
			setVariavelValue(linha.substring(pos,linha.length()));
			
			
			int indice = inteiros.indetificadorDeNumerosInt(getVariavelValue().substring(getVariavelValue().indexOf("[")+1,getVariavelValue().indexOf("]")),0);
				
			setVariavelValue(linha.substring(pos,linha.length()));
			
			String nomeVetor = getVariavelValue().substring(getVariavelValue().indexOf("]")+1,getVariavelValue().length());

			double val= vetoresArmazenados.get(nomeVetor).get(indice);
			vetoresArmazenados.get(id).put(inteiros.indetificadorDeNumerosInt(index,0),val);
			
		}
		
		else
		{
			value = linha.substring(pos,linha.length());
			setVariavelId(value);
			inteiros = new Int();
			vetoresArmazenados.get(id).put(inteiros.indetificadorDeNumerosInt(index,0),convertDouble(value+" ",0)); //esse +" " é um ajuste para converter certinho para double
		}
	}
	//fim do método inseriValorNoVetor
}
//fim do método armazenarValor