import java.util.HashMap;
//inicio da classe Char
public class Char extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	
	public static HashMap< String,Character> variaveisArmazenadas = new HashMap<String, Character>();
	
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
}
//fim da classe Char
