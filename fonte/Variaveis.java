//inicio da classe Variaveis
public abstract class Variaveis extends Primitivos
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;

	public String variavelId ="";

	public String variavelValue="";

	//inicio do método TamanhoDaVariavelId
	protected boolean tamanhoDaVariavelId()
	{
		if(this.getVariavelId().length() > 0)
		{
			return true;
		}
		else
		{
			ErrosNaCompilacao.getLineError(3);
			return false;
		}
	}
	//fim do método tamanhoDaVariavelId

	//inicio do método setVariavelValue
	public void setVariavelValue(String vl)
	{
		this.variavelValue = vl;
	}
	//fim do método setVariavelValue
	
	//inicio do método getVariavelValue
	public String getVariavelValue()
	{
		return this.variavelValue;
	}
	//fim do método getVaruavelValue

	//inicio do método setVariavelId
	public void setVariavelId(String id)
	{
		this.variavelId = id;
	}
	//fim do método setVariavelId
	
	//inicio do método getVariavelId
	public String getVariavelId()
	{
		return this.variavelId;
	}
	//fim do método getVariavelId
	
	//inicio do método verificacao
    protected boolean verificacao(String str) //verifica se tem uma varivel e um valor para ser armazenado
    {               
        
        boolean verificacaoDoNomeVariavel = false;
                
        int pos=0, inicializaLeitura = 0;
       
		if( str.substring(0,3).equals("int"))
		{
			inicializaLeitura = 4;
			if (analisadorLexicoDeVariaveis(str,inicializaLeitura))
			{

				setVariavelValue("0");
				indentificaValor(getVariavelValue(),0);
				return true;
			}

		}
		else if( str.substring(0,6).equals("double"))
		{
			inicializaLeitura = 6;
			if (analisadorLexicoDeVariaveis(str,inicializaLeitura))
			{

				setVariavelValue("0.0");
				indentificaValor(getVariavelValue(),0);
				return true;
			}

		}
		else if(str.substring(0,4).equals("char"))
		{
			inicializaLeitura = 5;
			if (analisadorLexicoDeVariaveis(str,inicializaLeitura))
			{
				setVariavelValue("' ' ");
				indentificaValor(getVariavelValue(),0);
				return true;
			}
		}
	
		else if(str.substring(0,4).equals("bool"))
		{
			inicializaLeitura = 5;
			if (analisadorLexicoDeVariaveis(str,inicializaLeitura))
			{
				setVariavelValue("true ");
				indentificaValor(getVariavelValue(),0);
				return true;
			}
		}
		
		else if(str.substring(0,6).equals("string"))
		{
			inicializaLeitura = 7;
			if (analisadorLexicoDeVariaveis(str,inicializaLeitura))
			{
				setVariavelValue("null");
				indentificaValor(getVariavelValue(),0);
				return true;
			}
		}
        //laco de repetição que lê a linha
		
		for( int i = 0; i< str.length()-1; i++)
        {
			if ( str.charAt(i)  == '=' )
            {                       
                pos = i+1; //marca onde vai começar a leitura da variavel

                for( int ii = inicializaLeitura; ii < i; ii++)
                {
                    if (str.charAt(ii) == ' ')
                    {
                        continue;
                    }
                                        
                    else
                    {
                        setVariavelId(getVariavelId()+ ""+str.charAt(ii));
                    }
                }
                                
                verificacaoDoNomeVariavel =  tamanhoDaVariavelId();

            }
            else if( verificacaoDoNomeVariavel ) //quando a verificação do nome da váriavel é realizada ela passa por essa condicional
            {
                //laço de repetição que lê o char a ser armazenado

                indentificaValor(str,pos);
				
				if (getVariavelValue().length() == 0)
                {
                    return false;
                }

                else
                {
                    return true;
                }
            }
        }
        return false;
    }
	//fim do método verificacao

	//inicio do método ConvertStringParaInt
	protected int ConvertStringParaInt(String str)
	{
		int aux = 0,base10 = 1, value  = 0;
		
		for( int i = str.length()-1; i>= 0; i--)
		{
			aux = Integer.parseInt(String.valueOf(str.charAt(i)));//converter para string
			value+= aux*base10;
			base10*=10;
        }
		return (int)value;
	}
	//fim do método ConvertStringParaInt

	//inicio do método armazenarValor
	protected abstract void armazenarValor ();
	//fim do método armazenarValor
	
	//inicio do método indentificaValor
	protected void indentificaValor(String str, int pos) //seta as variaveis id e value
	{
	}
	//fim do método indentificaValor
	
	//inicio do método verificador
	public void verificador(String lineText) //verifica se tem variavel para armazenar
	{
		
		if( verificacao(lineText)) 
		{
	 		this.armazenarValor();
		}
		
		else
		{
			ErrosNaCompilacao.tipo = lineText;
			ErrosNaCompilacao.getLineError(1);
		}
	}
	//fim do método verificador
	
	//inicio do método analisadorLexicoDeVariaveis
	public boolean analisadorLexicoDeVariaveis(String str, int inicializaLeitura) //verifica se é possivel add o valor de uma variavel
	{
		
		char igual = '?';
		for(int i = inicializaLeitura ; i < str.length(); i++)//verifica se tem algum valor a ser armazenado
		{
			if(str.charAt(i) == ';' && igual != '=')
			{
				for(int ii = inicializaLeitura; ii< str.length()-1; ii++)
				{
					if( str.charAt(ii) != ' ')
					{
						setVariavelId(getVariavelId()+""+str.charAt(ii));
					}
					
				}
				return true;
			}
			if(str.charAt(i) == '=')
			{
				igual = '=';
			}
		
		}
		return false;
	}
	//fim do método analisadorLexicoDeVariaveis

	//Inicio do método armazenarVetorNaVariavel
	protected void armazenarVetorNaVariavel(String id,int size)
	{

	}
	//Fim do método armazenarVetorNaVariavel

	//Inicio do método inserirValor
	protected void inserirValor(String id,String index,String value) //inseri valor no vetor
	{

	}
	//Fim do método inserirValor

	//Inicio do método inserirVariavel
	protected void inserirVariavel(String nomeVetor, int indice, String id, String index) //inseri variavel no vetor
	{

	}
	//Fim do método inserirVariavel

	//inicio do método armazenaVetor
	public void armazenaVetor(String linha)
	{
		Int inteiro = new Int();
		String value = "";
		String id = "";
		int pos = 0;
		for(int i = 0; i< linha.length(); i++)
		{
			if( linha.charAt(i) == '[')
			{
				for(int ii = i+1; ii<= linha.length(); ii++)
				{
					if(linha.charAt(ii) == ']') //tamanho do vetor
					{
						pos = ii+1;//onde começa leitura da variavel
						break;
					}
		
					else
					{
						value = value+""+linha.charAt(ii);
					}
				}
			}
			break;
		}
	
		for(int i = pos; i< linha.length();i++)
		{
			id = id+""+linha.charAt(i);
		}
		int size = inteiro.indetificadorDeNumerosInt(value,0);
		armazenarVetorNaVariavel(id,size);
	}
	//Fim do método armazenaVetor

	//inicio do método inseriValorNoVetor
	public void inseriValorNoVetor(String linha)
	{
		Int inteiros = new Int();
		String value = "",id="",index = "";
		int pos=0;
		
		for(int i = 1; i < linha.length(); i++) // o 0 vai ser [
		{
			if(linha.charAt(i) == ']')
			{
				pos = i+1;
				break;
			}
			else
			{
				index = index+""+linha.charAt(i);
			}
		} //indice do vetor do qual será armazanado a variável
	
		for(int i = pos; i < linha.length(); i++)
		{
			if(linha.charAt(i) == '=')
			{
				pos = i+1;
				break;
			}
			else
			{
				id = id+""+linha.charAt(i);
			}
		} //variavel encontrada
	
		if(linha.substring(pos,linha.length()).contains("[") && linha.substring(pos,linha.length()).contains("]"))
		{
			setVariavelValue(linha.substring(pos,linha.length()));
			int indice = inteiros.indetificadorDeNumerosInt(getVariavelValue().substring(getVariavelValue().indexOf("[")+1,getVariavelValue().indexOf("]")),0);
			setVariavelValue(linha.substring(pos,linha.length()));
			String nomeVetor = getVariavelValue().substring(getVariavelValue().indexOf("]")+1,getVariavelValue().length());
			inserirVariavel(nomeVetor,indice,id,index);
		}
		else
		{
			value = linha.substring(pos,linha.length());
			setVariavelId(value);
			inserirValor(id,index,value);
			setVariavelId("");
				
		}
	}
	//fim do método inseriValorNoVetor
}
//fim da classe Variaveis
