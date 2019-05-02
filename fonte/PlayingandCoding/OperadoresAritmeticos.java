import java.util.ArrayList;

//inicio da classe OperadoresAritmeticos
public class OperadoresAritmeticos
{
	public int value;

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

	//inicio do método operacao
	public void leituraDaOperacao(String linha)
	{
		ArrayList<String> heap = new ArrayList<String>(linha.length());
		
		Int inteiro = new Int();

		int indice = 1; //indice

		String value = "";
		
		for(int i = 0; i< linha.length(); i++)
		{
			heap.add("");
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
				System.out.println(linha.charAt(i)+"aqui carai");
				heap.set(indice,value);
				value = "";
			}
	
		}
		for(int i = 0; i<linha.length();i++)
		{
			System.out.println(heap.get(i));
		}
	}
	//fim do método operacao
}
//fim da classe OperadoresAritmeticos
