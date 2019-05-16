import java.util.HashMap;
import com.sun.glass.ui.Size;
//inicio da classe Char
public class Char extends Variaveis
{
	Int inteiro;
	//dicionario que armazena as váriaveis criadas
	public static HashMap< String,Character> variaveisArmazenadas = new HashMap<String, Character>();
	
	public static HashMap< String, HashMap<Integer,Character>> vetoresArmazenados = new HashMap<String, HashMap<Integer,Character>>();
	@Override
	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{		
		char val= vetoresArmazenados.get(nomeVetor).get(indice);
		Int inteiro = new Int();
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),val);
	}
	@Override
	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{
		Int inteiro = new Int();
		vetoresArmazenados.get(id).put(inteiro.indetificadorDeNumerosInt(index,0),value.charAt(1));
	}
	@Override
	protected void armazenarVetorNaVariavel(String id, int size)
	{
		vetoresArmazenados.put(id, new HashMap<Integer,Character>());
		Comparadores.tipoVariaveis.put(id, "char");
		for(int i = 0; i < size ;i++)
		{
			vetoresArmazenados.get(id).put(i,' ');
		}
	}	
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
