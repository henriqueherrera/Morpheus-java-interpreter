import java.util.HashMap;

public class LePrimitivos extends Tools
{
	private Int inteiros;

	private Doubles doubles;

	private Bool bool;

	private Strings string;

	private Char chars;

	private Int vetores;

	private Condicional ifCondicional;
	private String ifExpressao = "";

	private While lacoDeRepeticao;

	private Comparadores compara;

	private String expressao = "";

	private Def def;
	private HashMap<String,Def> funcoes = new HashMap<String,Def>(); //armazena as funcoes

	private boolean controladorDeLaco = false;//quando true so passa pelo primeiro while

	private boolean controladorIf = false;

	private boolean controladorDef = false;

	private OperadoresAritmeticos operacoes = new OperadoresAritmeticos();

	//inicio do método idLinha
	public void idLinha(String linha,int whilis)
	{
		linha.trim(); // Remove a indentaçao.
		compara = new Comparadores(); // Instancia o objeto

		if (controladorIf) // Enquanto o controlador do If for true toda linha passará por aqui e será armazenado em um hashmap.
		{
			linha.trim();

			if(this.tiraEspacos(linha).equals("{")) // Se encontrar chaves após limpar os espaços da linha
			{
				ifCondicional.countAbreChave(); // Conta uma chave aberta
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha); // Coloca a linha na lista a ser lida
			}

			else if(this.tiraEspacos(linha).equals("}") || this.tiraEspacos(linha).equals("}else")) // Se encontrar chaves ou else após limpar os espaços da linha
			{
				int aux1 = ifCondicional.countLines(); // Numera as linhas do if.
				ifCondicional.countFechaChave(); // Conta uma chave fechada
				if(this.tiraEspacos(linha).equals("}else") && ifCondicional.igualdadeDeChave()) // Se encontrar else e a contagem de chaves abertas for iguais as fechadas
				{
					ifCondicional.linhaDoElse = aux1; // Pega a linha que o else se encontra
				}
				ifCondicional.txtLines.put(aux1,linha); // Adiciona ela a lista
			}
			// Caso contrário
			else
			{
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha); // Coloca a linha atual na lista
			}

			if(ifCondicional.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else"))) // Se existir igualdade de chaves e não encontrar else
			{
				ifCondicional.condicionalIf(ifCondicional.getNumeroDeLinhas(), this.getIfExpressao()); // Roda o If
				controladorIf = false; // Desativa o if
			}
		}
		else if (controladorDeLaco) // Enquanto for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim(); // Limpa a identação
			if(this.tiraEspacos(linha).equals("{")) // Se encontrar uma chave aberta
			{
				lacoDeRepeticao.countAbreChave(); // Conta uma chave aberta
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha); // Coloca a linha na lista a ser lida
			}

			else if(this.tiraEspacos(linha).charAt(0) == '}') // Se encontrar chave fechada
			{
				lacoDeRepeticao.countFechaChave(); // Conta uma chave fechada
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha); // Coloca a linha na lista a ser lida
			}
			else // Caso contrário
			{
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha); // Coloca a linha atual na lista
			}
			if(lacoDeRepeticao.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else"))) // Se a contagem de chaves abertas for igual a de chaves fechadas e não existir else
			{
				lacoDeRepeticao.laco(lacoDeRepeticao.getNumeroDeLinhas(), this.getExpressao()); // Roda o laço
				controladorDeLaco = false; // Desativa o laço
			}
		}
		else if (controladorDef) // Enquanto for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim(); // Limpa identação

			if(this.tiraEspacos(linha).equals("{")) // Se encontrar chaves abertas
			{
				def.countAbreChave(); // Conta uma chave aberta
				def.txtLines.put(def.countLines(),linha); // Coloca a linha na lista a ser lida pela função
			}

			else if(this.tiraEspacos(linha).charAt(0) == '}') // Se encontrar chaves fechadas
			{
				def.countFechaChave(); // Conta uma chave fechada
				def.txtLines.put(def.countLines(),linha); // Coloca a linha na lista a ser lida pela função
			}
			// Caso contrário
			else
			{
				def.txtLines.put(def.countLines(),linha); // Coloca a linha atual na lista a ser lida pela função
			}

			if(def.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else"))) // Se a contagem de chaves abertas e fechadas for igual e não existir else
			{
				controladorDef = false; // Desativa a função
			}
		}

		else if(linha.contains("}") || linha.contains("{"))
		{
			//artificio tecnico para ignorar as chaves
		}

		else if (linha.substring(0,2).equals("if") || this.controladorIf) // Se encontrar um if na linha
		{
			ifCondicional = new Condicional();
			setIfExpressao(this.tiraEspacos(linha.substring(2,linha.length())+" "));
			this.controladorIf = true;
		}

		else if (linha.substring(0,3).equals("int")) // Se encontrar um inteiro na linha
		{
			this.inteiros = new Int();
			if(linha.contains(";"))
			{
				inteiros.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
			}
		}

		else if (linha.substring(0,3).equals("def")) // Se encontrar uma função na linha
		{
			String aux = this.tiraEspacos(linha);
			def = new Def();
			def.setEscopo(linha.substring(linha.indexOf("(")+1,linha.indexOf(")")));

			funcoes.put(aux.substring(3,aux.indexOf("(")),def);
			this.controladorDef = true;
		}

    else if (linha.substring(0,4).equals("char")) // Se encontrar um char na linha
		{
			this.chars = new Char();
			if(linha.contains(";"))
			{
				chars.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		  }
    }
		else if (linha.substring(0,4).equals("bool")) // Se encontrar um booleano na linha
		{
			this.bool = new Bool();
			if(linha.contains(";"))
			{
				bool.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		  }
		}
		else if (linha.substring(0,5).equals("print")) // Se encontrar um print na linha
		{
			this.print(this.tiraEspacos(linha));
		}

		else if (linha.substring(0,5).equals("vetor")) // Se encontrar um vetor na linha
		{
      if (!linha.contains(";"))
      {
          ErrosNaCompilacao.getLineError(0);
      }
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

		else if (linha.substring(0,5).equals("input")) // Se encontrar um input na linha
		{
			this.input(this.tiraEspacos(linha)); // Tira os espaços da linha e roda o método de input
		}

		else if (linha.substring(0,5).equals("while") || this.controladorDeLaco) // Se encontrar um while no início da linha ou o controlador de laço for verdadeiro
		{
			lacoDeRepeticao = new While();
			setExpressao(this.tiraEspacos(linha.substring(5, linha.length()))); // Expressao do while
			this.controladorDeLaco = true;
		}

		else if(linha.substring(0,6).equals("double")) // Se encontrar double no início da linha
		{
			this.doubles = new Doubles(); // Instancia o objeto
			if(linha.contains(";")) // Se encontrar ponto e vírgula na linha
			{
			    doubles.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0); // Retorna o erro de código zero
		  }
		}

		else if (linha.substring(0,6).equals("string")) // Se encontrar string no inicio da linha
		{
			this.string = new Strings(); // Instancia o objeto
			if(linha.contains(";")) // Se encontrar ponto e vírgula na linha
			{
			    string.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0); // Retorna o erro de código zero
		  }
		}

		else if(linha.contains("call")) // Se encontrar a palavra call na linha
		{
			String aux =  this.tiraEspacos(linha); // Tira os espaços da linha
			String var = aux.substring(aux.indexOf("call")+4,aux.indexOf("(")); // Pega o nome da função
			String parametros = aux.substring(aux.indexOf("(")+1,aux.indexOf(")")); // Pega os parametros
			funcoes.get(var).runParametros(parametros);
			funcoes.get(var).chamadaDef(this.tiraEspacos(linha));
		}

	  else if( operacoes.analisadorLexicoDeOperacoes(this.tiraEspacos(linha))) // Verifica se existe uma operação aritmética para ser calculada
		{
			String aux =  this.tiraEspacos(linha);
      if(!linha.contains(";"))
      {
      	ErrosNaCompilacao.getLineError(0);
      }

      else if(this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("[") && this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("]"))
      {
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
      if(!linha.contains(";"))
      {
          ErrosNaCompilacao.getLineError(0);
      }
      else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("string"))
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
		else
		{
	    if(linha.contains(";"))
	    {
	  		compara.getVariaveis(linha);
	    }
	    else
	    {
	      ErrosNaCompilacao.getLineError(0);
	    }
		}
	}

	/* Os métodos de expressão são os que pegam a expressão
	booleana existente depois do if ou do while */

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
