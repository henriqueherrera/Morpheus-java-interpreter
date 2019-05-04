import java.util.ArrayList;

//inicio da classe OperadoresAritmeticos
public class OperadoresAritmeticos
{
	private ArrayList<String> heap = new ArrayList<String>();
	
	private Int inteiro = new Int();

	private int inicioDaExpressao;

	private int fimDaExpressao;
	
	private String  variavelParaArmazenar;

	//inicio do método setVariavelParaArmazenar
	public void setVariavelParaArmazenar(String str)
	{
		this.variavelParaArmazenar = str;
	}
	//fim do método setVariavelParaArmazenar
	
	//inicio do método getVariavelParaArmazenar
	public String getVariavelParaArmazenar()
	{
		return this.variavelParaArmazenar;
	}
	//fim do método getVariavelParaArmazenar
	
	//inicio do método setInicioDaExpressao
	public void setInicioDaExpressao(int i)
	{
		this.inicioDaExpressao = i;
	}
	//fim do método setInicioDaExpressao
	
	//inicio do método getInicioDaExpressao
	public int getInicioDaExpressao()
	{
		return this.inicioDaExpressao;
	}
	//fim do método getInicioDaExpressao
	
	//inicio do método setFimDaExpressao
	public void setFimDaExpressao(int i)
	{
		this.fimDaExpressao = i;
	}
	//fim do método setFimDaExpressao
	
	//inicio do método getFimDaExpressao
	public int getFimDaExpressao()
	{
		return this.fimDaExpressao;
	}
	//fim do método getFimDaExpressao
	
	//inicio do método left
	private int left(int i)
	{
		return 2*i;
	}
	//fim do método left
	
	//inicio do método right
	private int right(int i)
	{
		return 2*i+1;
	}
	//fim do método right
	
	//inicio do método dad
	private int dad(int i)
	{
		return i/2;
	}
	//fim do método dad
	
	//inicio do método isLeaf
	public boolean isLeaf(int i)
	{
		if(heap.get(left(i)).equals("empty") && heap.get(right(i)).equals("empty"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//fim do método isLeaf
	
	//inicio do método val
	public int val(int i)
	{
		if(isLeaf(i))
		{
			int x = 0;
			inteiro = new Int();
			if(!((48<= heap.get(i).charAt(0)) && ( heap.get(i).charAt(0) <=57)))
			{
				if((Comparadores.tipoVariaveis.get(heap.get(i))).equals("int"))
				{
					x = Int.variaveisArmazenadas.get(heap.get(i));
				}
			}
			else
			{
				x = inteiro.indetificadorDeNumerosInt(heap.get(i),0);
			}
			return x;
		}
		if( heap.get(i).equals("+"))
		{	
			return val(left(i)) + val( right(i));
		}
		else if (heap.get(i).equals("-"))
		{
			return val(left(i))-  val(right(i));
		}
		else if(heap.get(i).equals("*"))
		{
			return val(left(i)) * val(right(i));
		}
		else if(heap.get(i).equals("/"))
		{
			return val(left(i)) / val(right(i));
		}
		else
		{
			return 0;
		}
	}
	//fim do método val
	
	//inicio do analisadorLexicoDeOperacoes
	public boolean analisadorLexicoDeOperacoes(String linha) //verifica se tem alguma expressao aritmetica
	{
		int total1 = linha.replaceAll("[^(]", "").length();
		int total2 = linha.replaceAll("[^)]", "").length();
		
		if(( linha.contains("+") || linha.contains("-") || linha.contains("*") || linha.contains("/")) && (total1 == total2))
		{
			for(int i = 0; i<linha.length(); i++)
			{
				if (linha.charAt(i) == '(')
				{
					setInicioDaExpressao(i);
					break;
				}
			}
			setFimDaExpressao(linha.indexOf(";"));
			setVariavelParaArmazenar(linha.substring(0,linha.indexOf("=")));
			
			return true;
		}
		else
		{
			return false;
		}
	}
	//fim do método analisadorLexicoDeOperacoes
	
	//inicio do método leituraDaOperacao
	public int leituraDaOperacao(String linha) // faz o cálculo da expressao
	{
	
		
		Int inteiro = new Int();

		int indice = 1; //indice

		String value = "";
		
		heap.add("x");

		for(int i = 1; i< linha.length()*2; i++)
		{
			heap.add("empty");
		}
		for(int i = 0; i < linha.length() ; i++)
		{
			
			if(linha.charAt(i) == '(')
			{
				heap.set(indice,"#");
				indice = this.left(indice);
			}
			
			else if(linha.charAt(i) == ')')
			{
				indice  = this.dad(indice);
			}
			
			else if((linha.charAt(i) == '*') || (linha.charAt(i) == '-') || (linha.charAt(i) == '+') || (linha.charAt(i) == '/'))
			{	
				indice = this.dad(indice);
				heap.set(indice,linha.substring(i,i+1));
				indice = this.right(indice);
			}
			else
			{
				if((48<= linha.charAt(i)) && (linha.charAt(i)  <=57)) //se for numero
				{
					for(int x = i; x<linha.length(); x++)
					{
						if(!((48<= linha.charAt(x)) && (linha.charAt(x)  <=57)))
						{
							i = x-1;
							break;
						}
						else
						{
							value = value+""+linha.charAt(x);
						}
					}
				}
				
				else //se for variavel
				{
					for(int x = i; x<linha.length();x++)
					{
						if((linha.charAt(x) == '*') || (linha.charAt(x) == '-') || (linha.charAt(x) == '+') || (linha.charAt(x) == '/') || (linha.charAt(x) == '(') || (linha.charAt(x) == ')'))
						{
							i = x-1;
							break;
						}
						else
						{
							value = value+""+linha.charAt(x);
						}
					}
				}
				heap.set(indice,value);
				value = "";
			}
		}
		return val(1);
	}
	//fim do método leituraDaOperacao
}
//fim da classe OperadoresAritmeticos
