public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();
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
