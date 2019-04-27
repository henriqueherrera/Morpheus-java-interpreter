//inicio da classe Floats
public abstract class Floats extends Variaveis
{
	//pega o nome da variável
	protected String indentificador;

	//pega o valor da variável
	protected double value;
	
	//inicio do método setValue
	protected void setValue( double value )
	{
		this. value = value;
	}
	//fim do método setValue
	
	//inicio do método getValue
	protected double getValue()
	{
		return this.value;
	}
	//fim do método getValur
	
	//inicio do método setId
	protected void setId( String id )
	{
		this.indentificador = id;
	}
	//fim do método setId

	//inicio do método getId
	protected String getId()
	{
		return this.indentificador; 
	}
	//fim do método getId
}
//fim da classe Floats

