import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

public class Int extends Inteiros
{
	public static HashMap< String,Integer> variaveisArmazenadas = new HashMap<String, Integer>();


	protected boolean verificacao(String str)
	{
		Scanner input = new Scanner(System.in);
		String variavelId ="";
		String variavelValue = "";
		boolean verificacaoDoNomeVariavel = false;
		int pos=0;
		for( int i = 0; i< str.length()-1; i++)
		{
			if ( str.charAt(i)  == '=' )
			{
				pos = i+1;
				for( int ii = 4; ii < i; ii++)
				{
					variavelId = variavelId+ ""+str.charAt(ii);
					//System.out.println(variavelId);
				}
				verificacaoDoNomeVariavel =  true;
			}
			else if( verificacaoDoNomeVariavel )
			{
				for(int iii = pos; iii<str.length(); iii++)
				{
					//System.out.println(iii);
					if ((48<= str.charAt(iii)) && (str.charAt(iii)  <=57))
					{
						variavelValue= variavelValue+""+str.charAt(iii);	
					}
				}
				
				int value = this.ConvertStringParaInt(variavelValue);
				this.setValue(value);
				this.setId(variavelId);
				return true;
			}
		}
		return false;
	}

	private int ConvertStringParaInt(String str)
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

	protected void armazenarValor ()
	{
		this.variaveisArmazenadas.put(this.getId(), this.getValue());
	}
	public void verificador(String linetext)
	{
		if( verificacao(linetext))
		{
	 		this.armazenarValor();
		}
	}
}
