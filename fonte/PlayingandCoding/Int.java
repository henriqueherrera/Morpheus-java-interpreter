import java.util.HashMap;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Int
public class Int extends Variaveis
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	public static HashMap< String,Integer> variaveisArmazenadas = new HashMap<String, Integer>();
	
	//inicio do método verificacao
	
	@Override
	protected boolean verificacao(String str)
	{
		int negativo = 1;
		
		boolean verificacaoDoNomeVariavel = false;
		
		int pos=0;
		
		//laco de repetição que lê a linha
		for( int i = 0; i< str.length()-1; i++)
		{
			
			
			if ( str.charAt(i)  == '=' )
			{
				pos = i+1; //marca onde vai começar a leitura dos números

				for( int ii = 4; ii < i; ii++)
				{
					if (str.charAt(ii) == ' ')
					{
						continue;
					}
					
					else
					{
						setVariavelId(getVariavelId()+ ""+str.charAt(ii));
					}
				}
		
				
				verificacaoDoNomeVariavel =  tamanhoDaVariavelId();

			}
			else if( verificacaoDoNomeVariavel ) //quando a verificação do nome da váriavel é realizada ela passa por essa condicional
			{
				//laço de repetição que lê o inteiro a ser armazenado
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
				int value = this.ConvertStringParaInt(getVariavelValue());
				setIntId(getVariavelId());
				setIntValue(value);
				if (getVariavelValue().length() == 0)
				{
					return false;
				}
				
				else 
				{
					return true;
				}
			}
		}
		return false;
	}
	//fim do método verificador

	//inicio do método armazenarValor
	@Override
	protected void armazenarValor ()
	{
		variaveisArmazenadas.put(getIntId(), getIntValue());
	}
	//fim do método armazenarValor
}
//fim da classe Int
