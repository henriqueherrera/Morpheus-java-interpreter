import java.util.HashMap;
//inicio da classe Double
public class Doubles extends Variaveis
{
    //dicionario que armazena as váriaveis criadas
    public static HashMap< String, Double> variaveisArmazenadas = new HashMap<String, Double>();
    
    Int conversor = new Int();
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
}
//fim do método armazenarValor