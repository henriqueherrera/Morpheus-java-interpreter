import java.util.HashMap;
//inicio da classe Bool 
public class Bool extends Variaveis
{
	public static int leituraDaLinha;
	
	public static HashMap<String, Boolean> variaveisArmazenadas = new HashMap<String, Boolean>(); 
	
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
}
