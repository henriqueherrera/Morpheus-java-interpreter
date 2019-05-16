public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();
	
	private Int vetores;

	private Int inteiros;

	private Bool bool;

	private Strings string;

	private Condicional ifCondicional;

	private While lacoDeRepeticao;

	private Char chars;

	private boolean controladorDeLaco = false;//quando true so passa pelo primeiro while
	
	private boolean controladorIf = false;

	private Doubles doubles;
	
	private String ifExpressao = "";

	private String expressao = "";

	private Comparadores troca;
	
	//inicio do método idLinha
	public void idLinha(String linha,int whilis)
	{
		linha.trim(); //tira a indentaçao	
		
		troca = new Comparadores();
		
		if (controladorIf) //enquanto o controlador do If for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim();
			
			if(this.tiraEspacos(linha).equals("{"))
			{
				ifCondicional.countAbreChave();	
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha);
			}

			else if(this.tiraEspacos(linha).equals("}"))
			{
				ifCondicional.countFechaChave();
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha);
			}

			else
			{
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha);
			}

			if(ifCondicional.igualdadeDeChave())
			{
				ifCondicional.condicionalIf(ifCondicional.getNumeroDeLinhas(), this.getIfExpressao());
				controladorIf = false;
			}
		}
		else if (controladorDeLaco) // enquanto for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim();
			
			if(this.tiraEspacos(linha).equals("{"))
			{
				lacoDeRepeticao.countAbreChave();	
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
			}

			else if(this.tiraEspacos(linha).equals("}"))
			{

				lacoDeRepeticao.countFechaChave();
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
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
		
		else if(linha.contains("}") || linha.contains("{"))
		{
			//artificio tecnico para ignorar as chaves
		}

		else if(linha.substring(0,6).equals("double"))
		{
			this.doubles = new Doubles();
			doubles.verificador(linha);
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
			lacoDeRepeticao = new While();
			setExpressao(this.tiraEspacos(linha.substring(5, linha.length()))); //expressao do while
			this.controladorDeLaco = true;
		
		}
		
		else if (linha.substring(0,5).equals("print"))
		{
			this.print(this.tiraEspacos(linha));
		}
						
		else if (linha.substring(0,5).equals("vetor"))
		{
			linha = this.tiraEspacos(linha);
			if(linha.substring(5,linha.indexOf("|")).equals("string"))
			{
				this.string = new Strings();
				string.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}
			
			else if(linha.substring(5,linha.indexOf("|")).equals("double"))
			{
				this.doubles = new Doubles();
				doubles.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("char"))
			{
				this.chars = new Char();
				chars.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}
			
			else if(linha.substring(5,linha.indexOf("|")).equals("bool"))
			{
				this.bool = new Bool();
				bool.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("int"))
			{
				this.vetores = new Int();
				vetores.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}
			
		}

		else if (linha.substring(0,6).equals("string")) 
		{
			this.string = new Strings();
			string.verificador(linha);
		}
	    else if( operacoes.analisadorLexicoDeOperacoes(this.tiraEspacos(linha))) //verifica se tem continha para fazer
		{

           	if(this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("[") && this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("]"))
            {
                String aux =  this.tiraEspacos(linha);
                if(Comparadores.tipoVariaveis.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).equals("double"))
                {
                    this.inteiros =new Int();
                    int index = inteiros.indetificadorDeNumerosInt(aux.substring(aux.indexOf('[')+1,aux.indexOf(']')),0);
	                Doubles.vetoresArmazenados.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).put(index, operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
                }
                else
                {

                    this.inteiros =new Int();
                    int index = inteiros.indetificadorDeNumerosInt(aux.substring(aux.indexOf('[')+1,aux.indexOf(']')),0);
	                Int.vetoresArmazenados.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).put(index, (int)operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
                }
            }

            else if (Comparadores.tipoVariaveis.get(tiraEspacos(linha).substring(0, this.tiraEspacos(linha).indexOf("="))).equals("int"))
			{
			    Int.variaveisArmazenadas.put(operacoes.getVariavelParaArmazenar(),(int)operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
			}
			else
			{
				Doubles.variaveisArmazenadas.put(operacoes.getVariavelParaArmazenar(),operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
			}
        }

		else if ((this.tiraEspacos(linha).charAt(0) == '[') && linha.contains("]"))
		{
			linha = this.tiraEspacos(linha);

			if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("string"))
			{
				this.string = new Strings();
				string.inseriValorNoVetor(linha.substring(0, linha.length()-1));
			}
			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("double"))
			{
				this.doubles = new Doubles();
				doubles.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("char"))
			{
				this.chars = new Char();
				chars.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("bool"))
			{
				this.bool = new Bool();
				bool.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("int"))
			{
				this.vetores = new Int();
				vetores.inseriValorNoVetor(linha.substring(0, linha.length()-1));
			}
		}

		else if (linha.substring(0,2).equals("if") || this.controladorIf)
		{
			ifCondicional = new Condicional();
			setIfExpressao(this.tiraEspacos(linha.substring(2,linha.length())));
			this.controladorIf = true;
		}
	

		else
		{
			troca.getVariaveis(linha);
		}
	}
	
	/* os métodos de expressao é oq vai pegar a expressão
	booleana que tem depois do if ou do while*/

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
	//fim do método getIfExpressao
	public void setIfExpressao(String exp)
	{
		this.ifExpressao = exp;
	}
	//fim do método setIfExpressao
	
	//inicio do método getIfExpressao
	public String getIfExpressao() 
	{
		return this.ifExpressao;
	}
	//fim do método getIfExpressao
}
