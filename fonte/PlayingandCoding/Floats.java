//inicio da classe Floats
public abstract class Floats extends Variaveis
{
	//pega o nome da variável
	protected String indentificador;

	//pega o valor da variável
	protected double value1;
	protected double value2;
	
	//inicio do método setValue
	protected void setValue1( double value )
	{
		this. value1 = value;
	}
	//fim do método setValue

	//inicio do método setValue
	protected void setValue2( double value )
	{
		this. value2 = value;
	}
	//fim do método setValue
	
	//inicio do método getValue
	protected double getValue1()
	{
		return this.value1;
	}
	//fim do método getValur
	//inicio do método getValue
	protected double getValue2()
	{
		return this.value2;
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

