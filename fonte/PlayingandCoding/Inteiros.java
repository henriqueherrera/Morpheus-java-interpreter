public abstract class Inteiros
{
	protected String indentificador;

	protected int value;
	
		
	/*protected boolean verificacao(String str)
	{
	}
	protected void armazenarValor()
	{
	}*/
	
	protected void setValue( int value )
	{
		this. value = value;
	}
	
	protected int getValue()
	{
		return this.value;
	}

	protected void setId( String id )
	{
		this.indentificador = id;
	}

	protected String getId()
	{
		return this.indentificador; 
	}
}

