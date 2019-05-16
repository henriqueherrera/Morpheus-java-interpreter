import java.util.HashMap;
//inicio da classe Char
public class Char extends Variaveis
{
	Int inteiro;
	//dicionario que armazena as váriaveis criadas
	public static HashMap< String,Character> variaveisArmazenadas = new HashMap<String, Character>();
	
	public static HashMap< String, HashMap<Integer,Character>> vetoresArmazenados = new HashMap<String, HashMap<Integer,Character>>();
	
	//inicio do método indentificaValor
	@Override
	protected void indentificaValor (String str,int pos) 
	{
		for(int iii = pos; iii<str.length(); iii++)
		{
			if ( (str.charAt(iii) == 39) && !(iii+2 == str.length()-1))
				{

				if(str.charAt(iii+2) == 39)
				{
						
					this.setCharValue(str.charAt(iii+1));
					setVariavelValue(""+this.getCharValue());
					break;
				}
			}

		}
				
		this.setCharId(getVariavelId());
	}
	//fim do método indentificaValor
	
	//inicio do método armazenarValor
	@Override
	protected void armazenarValor ()
	{
		variaveisArmazenadas.put(this.getCharId(), this.getCharValue());
		Comparadores.tipoVariaveis.put(this.getCharId(), "char");
	}
	//fim do método armazenarValor

	//inicio do método armazenaVetor
	public void armazenaVetor(String linha)
	{
		inteiro = new Int();
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
		
		vetoresArmazenados.put(id, new HashMap<Integer,Character>());
			
		int size = inteiro.indetificadorDeNumerosInt(value,0);
			
		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i,' ');
		}
		Comparadores.tipoVariaveis.put(id, "char");
	}
	//fim do método armazenaVetor
	public void inseriValorNoVetor(String linha)
	{
		inteiro = new Int();

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
			this.setVariavelValue(linha.substring(pos,linha.length()));
			
			int indice = inteiro.indetificadorDeNumerosInt(getVariavelValue().substring(getVariavelValue().indexOf("[")+1,getVariavelValue().indexOf("]")),0);
				
			this.setVariavelValue(linha.substring(pos,linha.length()));
			
			String nomeVetor = getVariavelValue().substring(getVariavelValue().indexOf("]")+1,getVariavelValue().length());

			char val= vetoresArmazenados.get(nomeVetor).get(indice);
			
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
		}
		
		else
		{
			value = linha.substring(pos,linha.length());
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),value.charAt(1));
			//o substring é para tirar os ''do char
		}
	}
	//fim do método inseriValorNoVetor
}
//fim da classe Char
