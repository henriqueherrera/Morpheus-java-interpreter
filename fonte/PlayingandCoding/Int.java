import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Int
public class Int extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static HashMap< String,Integer> variaveisArmazenadas = new HashMap<String, Integer>();
	
	@Override
	protected void indentificaValor(String str,int pos)
	{
		setIntId(getVariavelId());
		
		setIntValue( indetificadorDeNumerosInt(str,pos));
	}

	//inicio do método armazenarValor
	@Override
	protected void armazenarValor ()
	{
		variaveisArmazenadas.put(getIntId(), getIntValue());
		Comparadores.tipoVariaveis.put(getIntId(), "int");
	}
	//fim do método armazenarValor
	
	//inicio do método indenrificadorDeNumerosInt
	public int indetificadorDeNumerosInt(String str,int pos)
	{

		int negativo = 1;
		
		for(int iii = pos; iii<str.length(); iii++)
		{
			if( (str.charAt(iii) == '-') && (getVariavelValue().length() == 0))
			{
				negativo = -1;
			}

				
			if ((48<= str.charAt(iii)) && (str.charAt(iii)  <=57))
			{
				setVariavelValue(getVariavelValue()+""+str.charAt(iii));	
			}

			else if ( (str.charAt(iii)) != ';' && (str.charAt(iii) != ' '))
			{
				ErrosNaCompilacao.caractere = str.charAt(iii);

				ErrosNaCompilacao.getLineError(2);
			}
		}

		return this.ConvertStringParaInt(this.getVariavelValue());
	}
	//fim do método indentificadorDeNumerosInt

}
//fim da classe Int
