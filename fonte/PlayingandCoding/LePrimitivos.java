public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();
	
	private Int vetores;

	private While repeti = new While();
	
	private int count = 0;

	private boolean controladorLaco = false;//quando true so passa pelo primeiro if
	
	private String expressao ="";

	private String inicio ="           ";
	
	//inicio do método setExpressao
	public void setExpressao(String exp)
	{
		this.expressao = exp;
	}
	//fim do método setExpressao
	
	//inicio do método getExpressao
	public String getExpressao()
	{
		return this.expressao;
	}
	//fim do método getExpressao
	public void idLinha(String linha,int whilis)
	{
		linha.trim();	
		Comparadores troca = new Comparadores();

		if(linha.substring(0,5).equals("while") || controladorLaco)
		{

			
			if(linha.substring(0,5).equals("while"))
			{
				
				repeti.txtLines.put(count,linha.trim());
				count++;
				While repeti = new While();
				controladorLaco = true;
				setExpressao(this.tiraEspacos(linha).substring(5,this.tiraEspacos(linha).length())); //pega a expressão do while
			}
			
			else if(tiraEspacos(linha).substring(0,6).equals("inicio"))
			{
				inicio = linha;
			
			}
			else if(tiraEspacos(linha).substring(0,5).equals("final") && tiraEspacos(linha).substring(5,this.tiraEspacos(linha).length()).equals(inicio.substring(6,inicio.length())))
			{
				System.out.println(count);
				
				controladorLaco = false;

				
				repeti.lacoDeRepeticao(count,getExpressao(),whilis+1);
			}
			
			else
			{
				repeti.txtLines.put(count,linha.trim());
				count++;
			}
			
		}
		else if (linha.substring(0,3).equals("int"))
		{		
			Int inteiros = new Int();
			inteiros.verificador(linha);
		}
                   	
                else if (linha.substring(0,5).equals("float"))
		
		{
			Float floats = new Float();
			floats.verificador(linha);
                }
			
		else if (linha.substring(0,4).equals("char"))
		{
			Char chars = new Char();
			chars.verificador(linha);
		}

		else if (linha.substring(0,4).equals("bool"))
		{
			Bool bool = new Bool();
			bool.verificador(linha);
		}
						
		//verifica se foi escrito algo com 6 letras se e igual a string
		else if (linha.substring(0,6).equals("string")) 
		{
							
			Strings string = new Strings();
			string.verificador(linha);
		}
					
		else if (linha.substring(0,5).equals("input"))
		{
			this.input(this.tiraEspacos(linha));
		}
						
		else if (linha.substring(0,5).equals("print"))
		{
			this.print(this.tiraEspacos(linha));
		}
						
		else if (linha.substring(0,5).equals("vetor"))
		{
			vetores = new Int();
			vetores.armazenaVetor(this.tiraEspacos(linha.substring(5,linha.length()-1)));
		}
		else if ((this.tiraEspacos(linha).charAt(0) == '[') && linha.contains("]"))
		{
			vetores = new Int();
			vetores.inseriValorNoVetor( this.tiraEspacos(linha).substring(0,this.tiraEspacos(linha).length()-1)); // o -1 é para ignorar o ; 
		}
		else if( operacoes.analisadorLexicoDeOperacoes(this.tiraEspacos(linha))) //verifica se tem continha para fazer
		
		{

			String str = this.tiraEspacos(linha);
			Int.variaveisArmazenadas.put(operacoes.getVariavelParaArmazenar(),operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
		}

		else
		{
			troca.getVariaveis(linha);
		}
	}
}
