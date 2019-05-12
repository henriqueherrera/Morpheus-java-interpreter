import java.util.ArrayList;

//inicio da classe OperadoresAritmeticos
public class OperadoresAritmeticos
{
	private ArrayList<String> heap = new ArrayList<String>(); //pseudo-árvore heap
	
	private Int inteiro = new Int();

	private int inicioDaExpressao; 

	private int fimDaExpressao;
	
	private String  variavelParaArmazenar;

	private Doubles doubles = new Doubles();

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
	public boolean isLeaf(int i) //se o nó for folha ele retorna true
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
	
	//inicio do método ajuste
	private void ajuste(int i)
	{
		if(heap.get(i) == "empty")
		{
			return;
		}

		ajuste(this.left(i));
		
		if( (heap.get(i).equals("#")))
		{
			heap.set(i,heap.get(left(i)));
			heap.set(left(i),"empty");
		}
		
		ajuste(this.right(i));
	}
	//fim do método ajuste
	
	//inicio do método val
	public double val(int i) //aqui acontece a mágica, as continha são realizadas
	{
		if(isLeaf(i))
		{
			double x = 0;
			doubles = new Doubles();
			if(!((48<= heap.get(i).charAt(0)) && ( heap.get(i).charAt(0) <=57)))
			{
				if((Comparadores.tipoVariaveis.get(heap.get(i))).equals("int"))
				{
					x = Int.variaveisArmazenadas.get(heap.get(i));
				}

				else if((Comparadores.tipoVariaveis.get(heap.get(i))).equals("double"))
				{
					x = Doubles.variaveisArmazenadas.get(heap.get(i));
				}
			}
			else
			{
				System.out.println(heap.get(i));
				if (heap.get(i).contains("."))
				{
					x = doubles.convertDouble(heap.get(i)+" ",0);
			
				}
				else
				{
					x = inteiro.indetificadorDeNumerosInt(heap.get(i),0);
				}
				
			}
			return x;
		}

		if( heap.get(i).equals("+"))
		{	
			return val(left(i)) + val( right(i));
		}

		else if (heap.get(i).equals("-"))
		{
			return val(left(i)) - val(right(i));
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
	public double leituraDaOperacao(String linha) // faz o cálculo da expressao
	{
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
						if(!((48<= linha.charAt(x)) && (linha.charAt(x)  <=57)) && !(linha.charAt(x) == '.'))
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
				if(value.contains("[") && value.contains("]"))
				{
					value = valorDoVetor(value);
				}
				
				heap.set(indice,value);
				value = "";
			}
		}
		
		ajuste(1); //reorganiza a árvore caso necessário
		return val(1);
	}
	//fim do método leituraDaOperacao
	//inicio do método valorDoVetor
	private String valorDoVetor(String value)
	{
		Int inteiro = new Int();
		String nomeVariavel = value.substring(value.indexOf("]")+1,value.length());
		int index = inteiro.indetificadorDeNumerosInt(value.substring(value.indexOf("[")+1, value.indexOf("]")),0);
		int valor = Int.vetoresArmazenados.get(nomeVariavel).get(index);
		return ""+valor;
	}
}
//fim da classe OperadoresAritmeticos
