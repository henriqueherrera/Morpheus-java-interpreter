import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Int
public abstract class Variaveis extends Primitivos
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	public String variavelId ="";
	public String variavelValue="";

	//inicio do método setVariavelValue
	
	public void setVariavelValue(String vl)
	{
		this.variavelValue = vl;
	}
	//fim do método setVariavelValue
	
	//inicio do método getVariavelValue
	public String getVariavelValue()
	{
		return this.variavelValue;
	}
	//fim do método getVaruavelValue

	//inicio do método setVariavelId
	public void setVariavelId(String id)
	{
		this.variavelId = id;
	}
	//fim do método setVariavelId
	
	//inicio do método getVariavelId
	public String getVariavelId()
	{
		return this.variavelId;
	}
	//inicio do método verificacao
	
	protected abstract boolean verificacao(String str);
	//fim do método verificacao

	//inicio do método ConvertStringParaInt
	protected int ConvertStringParaInt(String str)
	{
		int aux = 0, value = 0, count = 0;
		
		for( int i = str.length()-1; i>= 0; i--)
		{
			aux = Integer.parseInt(String.valueOf(str.charAt(i)));//converter para string
                        value+= aux*Math.pow(10,count);
                        count++;
         	}
		return value;
	}
	//fim do método ConvertStringParaInt

	//inicio do método armazenarValor
	protected abstract void armazenarValor ();
	//fim do método armazenarValor
	
	//inicio do método verificador
	public void verificador(String lineText)
	{
		
		if( verificacao(lineText))
		{
	 		this.armazenarValor();
		}
		
		else
		{
			ErrosNaCompilacao.getLineError(1);
		}
	}
	//fim do método verificador
	
}
//fim da classe Inti
