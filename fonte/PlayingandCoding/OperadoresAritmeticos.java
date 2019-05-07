import java.util.ArrayList;

//inicio da classe OperadoresAritmeticos
public class OperadoresAritmeticos
{
	public int value;
	
	private int count = 0;
	
	private int conta = 0;
	
	private char simbolo = '#';
	
	private boolean passa = false;
	
	private ArrayList<String> heap = new ArrayList<String>();
	
	private Int inteiro = new Int();

	//inicio do método setValue
	public void setValue(int value)
	{
		this.value = value;
	}
	//fim do método setValue
	
	//inicio do método getValue
	public int getValue()
	{
		return this.value;
	}
	//fim do método getValue
	
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
	
	//inicio do método multiplicao
	private int multiplicacao(int x, int y)
	{
		return x*y;
	}
	//fim do método multiplicacao
	
	//inicio do método divisao
	private int divisao(int x, int y)
	{
		return x*y;
	}
	//fim do método divisao
	
	//inicio do método subtracao
	private int subtracao(int x, int y)
	{
		return x-y;
	}
	//fim do método subtracao
	
	//inicio do método soma
	private int soma(int x, int y)
	{
		return x+y;
	}
	
	public void inOrder(int i)
	{

		
		if( heap.get(i).equals("empty"))
		{
			inteiro = new Int();
			if (conta ==0)
			{
				conta = inteiro.indetificadorDeNumerosInt(heap.get(dad(i)),0);
			}
		
			
			
			return;		
		}	
		
			
		inOrder(this.left(i));	
		if((48<=heap.get(i).charAt(0) && heap.get(i).charAt(0) <= 57 )) 
		{
			inteiro = new Int();
			System.out.println(conta+""+'-'+""+inteiro.indetificadorDeNumerosInt(heap.get(i),0));

			inteiro = new Int();
			
		
	
			if(simbolo == '+')
			{
				conta+= inteiro.indetificadorDeNumerosInt(heap.get(i),0)+conta;
			
			}
			else if(simbolo == '-')
			{
				conta= inteiro.indetificadorDeNumerosInt(heap.get(i),0)-conta;
			}
			else if(simbolo == '*')
			{
				conta= inteiro.indetificadorDeNumerosInt(heap.get(i),0) *conta;
			}
		}
	 	if( heap.get(i).charAt(0) == '-' ||  heap.get(i).charAt(0) == '+' ||  heap.get(i).charAt(0) == '*')
		{
			simbolo = heap.get(i).charAt(0);
		}
	
			
		inOrder(this.right(i));
	}

	//inicio do método operacao
	public void leituraDaOperacao(String linha)
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
						//	System.out.println(linha.charAt(x)+" aqui");
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
		this.inOrder(1);
		System.out.println(conta);
	}
	//fim do método operacao
}
//fim da classe OperadoresAritmeticos
