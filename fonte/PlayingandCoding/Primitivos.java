//inicio da classe abstrada Primitivos
public abstract class Primitivos
{
	protected String charId;
	protected char charValue;
	
	protected String intId;
	protected int intValue;
	
	protected String floatId;
	protected double floatValue;
	
	protected String boolId;
	protected boolean boolValue;

	protected String StrId;
	protected String StrValue;
	
	//inicio do método setBoolValue
	protected void setBoolValue(boolean v)
	{
		this.boolValue = v;
	}
	//fim do método setBoolValue
	
	//inicio do método getBoolValue
	protected boolean getBoolValue()
	{
 		return this.boolValue;
	}
	//fim do método getBoolValue

	//inicio do método setBoolId
	protected void setBoolId( String str)
	{
		this.boolId = str;
	}
	//fim do método setBoolId

	//inicio do método getBoolId
	protected String getBoolId()
	{
		return this.boolId;
	}
	//fim do método getBoolId

	//inicio do método setCharValue
	protected void setCharValue(char c)
	{
		this.charValue = c;
	}
	//fim do método setCharValue
	
	//inivio do método getCharValue
	protected char getCharValue()
	{
		return this.charValue;
	}
	//fim do método getCharValue
	
	//inicio do método setCharId
	protected void setCharId(String str)
	{
		this.charId = str;
	}
	//fim do método serCharId
	
	//inicio do método getCharId
	protected String getCharId()
	{
		return this.charId;
	}
		
	//inicio do método setIntValue
	protected void setIntValue(int i)
	{
		this.intValue = i;
	}
	//fim do método setIntValue
	
	//inicio do método getIntValue
	protected int getIntValue()
	{
		return this.intValue;
	}
	//fim do método getIntValue
	
	//inicio do método setIntId
	protected void setIntId(String str)
	{
		this.intId = str;
	}
	//fim do método serIntId
	
	//inicio do método getIntId
	protected String getIntId()
	{
		return this.intId;
	}
	//fim do método getIntId
	
	//inicio do método setFloatValue
	protected void setFloatValue(double i)
	{
		this.floatValue = i;
	}
	//fim do método setFloatValue
	
	//inicio do método getFloatValue
	protected double getFloatValue()
	{
		return this.floatValue;
	}
	//fim do método getFloatValue
	
	//inicio do método setFloatId
	protected void setFloatId(String str)
	{
		this.floatId = str;
	}
	//fim do método serFloatId
	
	//inicio do método getFloatId
	protected String getFloatId()
	{
		return this.floatId;
	}
	//fim do método getFloatId

	//inicio do método setStrValue
	protected void setStrValue(String str)
	{
		this.StrValue = str;
	}
	//fim do método setStrValue


//METODOS GETTERS E SETTERS DA STRING
	
	//inicio do método getStrValue
	protected String getStrValue()
	{
		return this.StrValue;
	}
	//fim do método getStrValue
	
	//inicio do método setStrId
	protected void setStrId(String str)
	{
		this.StrId = str;
	}
	//fim do método serStrId
	
	//inicio do método getStrId
	protected String getStrId()
	{
		return this.StrId;
	}
	//fim do método getStrId


}
//fim da classe abstrada Primitivos
