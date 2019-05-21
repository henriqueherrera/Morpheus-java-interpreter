//inicio da classe abstrada Primitivos
public abstract class Primitivos
{
	protected String charId;
	protected char charValue;
	
	protected String intId;
	protected int intValue;
	
	protected String doubleId;
	protected double doubleValue;
	
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
	
	//inicio do método setDoubleValue
	protected void setDoubleValue(double i)
	{
		this.doubleValue = i;
	}
	//fim do método setDoubleValue
	
	//inicio do método getDoubleValue
	protected double getDoubleValue()
	{
		return this.doubleValue;
	}
	//fim do método getDoubleValue
	
	//inicio do método setDoubleId
	protected void setDoubleId(String str)
	{
		this.doubleId = str;
	}
	//fim do método setDoubleId
	
	//inicio do método getDoubleId
	protected String getDoubleId()
	{
		return this.doubleId;
	}
	//fim do método getDoubleId

	//inicio do método setStrValue
	protected void setStrValue(String str)
	{
		this.StrValue = str;
	}
	//fim do método setStrValue

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
