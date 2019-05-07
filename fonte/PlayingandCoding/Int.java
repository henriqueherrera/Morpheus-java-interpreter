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
		
		int size = this.indetificadorDeNumerosInt(value,0);
		
		for(int i = 0; i < size ;i++)
		{

			vetoresArmazenados.get(id).put(i,0);

		}
		Comparadores.tipoVariaveis.put(id, "int");
	}
	//fim do método armazenaVetor
	
	//inicio do método inseriValorNoVetor
	public void inseriValorNoVetor(String linha)
	{
		
		String value = "",id="",index = "";
		
		int pos=0;
		
		for(int i = 1; i < linha.length(); i++) // o 0 vai ser [
		{
			if(linha.charAt(i) == ']')
			{
				pos = i+1;
				break;
			}
			else
			{
				index = index+""+linha.charAt(i);
			}
		} //indice do vetor do qual será armazanado a variável

		for(int i = pos; i < linha.length(); i++)
		{
			if(linha.charAt(i) == '=')
			{
				pos = i+1;
				break;
			}
			else
			{
				id = id+""+linha.charAt(i);
			}
		} //variavel encontrada

		if(linha.substring(pos,linha.length()).contains("[") && linha.substring(pos,linha.length()).contains("]"))
		{
			setVariavelValue(linha.substring(pos,linha.length()));
			
			
			int indice = this.indetificadorDeNumerosInt(getVariavelValue().substring(getVariavelValue().indexOf("[")+1,getVariavelValue().indexOf("]")),0);
				
			setVariavelValue(linha.substring(pos,linha.length()));
			
			String nomeVetor = getVariavelValue().substring(getVariavelValue().indexOf("]")+1,getVariavelValue().length());

			int val= vetoresArmazenados.get(nomeVetor).get(indice);
			vetoresArmazenados.get(id).put(indetificadorDeNumerosInt(index,0),val);
			
		}
		else
		{
			value = linha.substring(pos,linha.length());
			vetoresArmazenados.get(id).put(indetificadorDeNumerosInt(index,0),indetificadorDeNumerosInt(value,0));
		}
	}
	//fim do método inseriValorNoVetor
	
	//inicio do método indenrificadorDeNumerosInt
	public int indetificadorDeNumerosInt(String str,int pos)
	{
		setVariavelValue(""); //ajuste tecnico para funcionar numeros negativos em vetores
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
