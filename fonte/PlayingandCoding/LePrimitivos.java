public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();
	
	private Int vetores;

	public void idLinha(String linha)
	{
		
		Comparadores troca = new Comparadores();
		
		if (linha.substring(0,3).equals("int"))
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
