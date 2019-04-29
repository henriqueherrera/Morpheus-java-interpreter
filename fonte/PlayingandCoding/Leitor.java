import java.io.*;
import java.lang.*;

//inicio da classe Leitor
class Leitor extends Tools
{
	private String arquivo; //Lê o arquivo para ser Interpretado

	private Bool bool;

	private Int inteiros;
    	
	private Float floats; 
	
	private Char chars;

	private Comparadores troca = new Comparadores();
	
	public static boolean laco = true; //enquanto tudo estiver ocorrendo de maneira prevista
					//o laco de repeticao continua trocando de linha
	
	//Construtor
	public Leitor(String arq)
	{
		this.setArquivo(arq);
	}

	//inicio do método reader
	public void reader() 
	{
		try
		{
			BufferedReader buffRead = new BufferedReader(new FileReader (this.getArquivo()));

                	String linha = "";

                	while(laco)
                	{
			
                        	linha = buffRead.readLine();
                        
				if(linha !=  null)
                        	{
				
					if (linha.charAt(linha.length()-1) == 59) //verifica se tem um ponto e virgula no final
					{
						//chama as funções aqui para armazenamento
					
						if (linha.substring(0,3).equals("int"))
						{		
							inteiros = new Int();
							inteiros.verificador(linha);
						}
                   	
                        else if (linha.substring(0,5).equals("float"))
						{
							floats = new Float();
							floats.verificador(linha);
                        }
					
						else if (linha.substring(0,4).equals("char"))
						{
							chars = new Char();
							chars.verificador(linha);
						}

						else if (linha.substring(0,4).equals("bool"))
						{
							bool = new Bool();
							bool.verificador(linha);
						}

						else if (linha.substring(0,5).equals("input"))
						{
							this.input(this.tiraEspacos(linha));
						}
						else if (linha.substring(0,2).equals("if"))
						{
							System.out.println(troca.comparaInt(linha));
						}
						else
						{
							troca.getVariaveis(linha);
						}
					}	

					else 
					{
						ErrosNaCompilacao.getLineError(0);
						laco = false;
					}
					
					ErrosNaCompilacao.numeroDaLinha+=1;
                        	}
				else 
				{
					break;
				}

                	}

                	buffRead.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	//fim do método reader
	
	//inicio do método getArquivo
	public String getArquivo()
	{
		return this.arquivo;
	}
	//fim do método getArquivo
	
	//inicio do método setArquivo
	public void setArquivo(String a)
	{
		this.arquivo = a;	
	}
	//fim do método setArquivo
}
//fim da classe Leitor
//fim da classe Leitor
