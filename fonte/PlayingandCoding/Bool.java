import java.util.HashMap;
//inicio da classe Bool 
public class Bool extends Variaveis
{
	public static int leituraDaLinha;
	private Int inteiro;
	public static HashMap<String, Boolean> variaveisArmazenadas = new HashMap<String, Boolean>();
	public static HashMap<String,HashMap<Integer,Boolean>> vetoresArmazenados = new HashMap<String,HashMap<Integer,Boolean>>();
	
	//inicio do método indentificaValor
	protected void indentificaValor(String str, int pos)
	{
		for(int iii = pos; iii < str.length(); iii++)
		{
			if( (str.charAt(iii) != ' ') && (str.charAt(iii)  != ';'))
			{

				setVariavelValue(getVariavelValue()+""+str.charAt(iii));
			}
		}

		setBoolId(getVariavelId());
		setBoolValue(Boolean.valueOf(this.getVariavelValue()));
	}
	//fim do método indentificaValor

	//inicio do método armazenarValor
	@Override
	protected void armazenarValor()
	{	
		variaveisArmazenadas.put(this.getBoolId(), this.getBoolValue());
		Comparadores.tipoVariaveis.put(this.getBoolId(),"bool");//quando é necessario trocar o valor
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
		
		vetoresArmazenados.put(id, new HashMap<Integer,Boolean>());
			
		int size = inteiro.indetificadorDeNumerosInt(value,0);
			
		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i,true);
		}
		Comparadores.tipoVariaveis.put(id, "bool");
	}
	//fim do método armazenaVetor

	//inicio do método inseriValorNoVetor
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

			boolean val= vetoresArmazenados.get(nomeVetor).get(indice);
			
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
		}
		else
		{
			value = linha.substring(pos,linha.length());
			vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),Boolean.valueOf(value.substring(0,value.length())));
		}
	}
	//fim do método inseriValorNoVetor
}
