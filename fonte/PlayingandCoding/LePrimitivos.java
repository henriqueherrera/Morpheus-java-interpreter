public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();
	
	private Int vetores;

	private Int inteiros;

	private Bool bool;

	private Strings string;

	private While lacoDeRepeticao = new While();

	private Char chars;

	private boolean controladorDeLaco = false;//quando true so passa pelo primeiro while
	
	private Float floats;

	private String expressao ="";

	private Comparadores troca;
	
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
	
	//inicio do método idLinha
	public void idLinha(String linha,int whilis)
	{
		linha.trim(); //tira a indentaçao	
		
		troca = new Comparadores();
		
		if (controladorDeLaco)
		{
			linha.trim();
			
			if(this.tiraEspacos(linha).equals("{"))
			{
				lacoDeRepeticao.countAbreChave();	
			}

			else if(this.tiraEspacos(linha).equals("}"))
			{

				lacoDeRepeticao.countFechaChave();
			}

			else
			{
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
			}

			if(lacoDeRepeticao.igualdadeDeChave())
			{
				lacoDeRepeticao.laco(lacoDeRepeticao.getNumeroDeLinhas(), this.getExpressao());
				controladorDeLaco = false;
			}
		}
		else if (linha.substring(0,3).equals("int"))
		{		
			this.inteiros = new Int();
			inteiros.verificador(linha);
		}
                   	
               	else if (linha.substring(0,4).equals("char"))
		{
			this.chars = new Char();
			chars.verificador(linha);
		}

		else if (linha.substring(0,4).equals("bool"))
		{
			this.bool = new Bool();
			bool.verificador(linha);
		}
						
		else if (linha.substring(0,5).equals("input"))
		{
			this.input(this.tiraEspacos(linha));
		}
		
		else if (linha.substring(0,5).equals("while") || this.controladorDeLaco)
		{
			setExpressao(this.tiraEspacos(linha.substring(5, linha.length()))); //expressao do while
			this.controladorDeLaco = true;
		}
		else if (linha.substring(0,5).equals("print"))
		{
			this.print(this.tiraEspacos(linha));
		}
						
		else if (linha.substring(0,5).equals("vetor"))
		{
			this.vetores = new Int();
			vetores.armazenaVetor(this.tiraEspacos(linha.substring(5,linha.length()-1)));
		}
		//verifica se foi escrito algo com 6 letras se e igual a string
		else if (linha.substring(0,6).equals("string")) 
		{
							
			this.string = new Strings();
			string.verificador(linha);
		}

		else if ((this.tiraEspacos(linha).charAt(0) == '[') && linha.contains("]"))
		{
			this.vetores = new Int();
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
