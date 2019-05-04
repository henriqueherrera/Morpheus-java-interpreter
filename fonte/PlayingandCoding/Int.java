import java.util.HashMap;
import java.lang.*;

//inicio da classe Int
public class Int extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static HashMap< String,Integer> variaveisArmazenadas = new HashMap<String, Integer>();
	public static HashMap< String, HashMap<Integer,Integer>> vetoresArmazenados = new HashMap<String, HashMap<Integer,Integer>>();
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
	
	//inicio do método armazenaVetor
	public void armazenaVetor(String linha)
	{
		String value = "";
		String id = "";
		int pos = 0;
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

		vetoresArmazenados.put(id, new HashMap<Integer,Integer>());
		for(int i = 0; i<this.indetificadorDeNumerosInt(value,0);i++)
		{
			vetoresArmazenados.get(id).put(i,0);
		}
	}
	//fim do método armazenaVetor
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

				
			else if ((48<= str.charAt(iii)) && (str.charAt(iii)  <=57))
			{
				setVariavelValue(getVariavelValue()+""+str.charAt(iii));	
			}

			else if ( (str.charAt(iii)) != ';' && (str.charAt(iii) != ' '))
			{
				ErrosNaCompilacao.caractere = str.charAt(iii);

				ErrosNaCompilacao.getLineError(2);
			}
		}

		return this.ConvertStringParaInt(this.getVariavelValue())*negativo;
	}
	//fim do método indentificadorDeNumerosInt
}
//fim da classe Int
