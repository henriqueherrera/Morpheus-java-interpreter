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
	
	private Strings string;

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
                        
				if(linha != null)
                        	{
				
					if ( ( linha.length() != 0 ) && (!linha.contains("}")) && (!linha.contains("{")) && (linha.charAt(linha.length()-1) == 59) ) //verifica se tem um ponto e virgula no final
					{ 
						linha = linha.trim();
						//chama as funções aqui para armazenamento
						if (linha.substring(0,2).equals("wh")) {
							while (troca.comparaInt(tiraEspacos(linha))) 
							{
									linha = buffRead.readLine();
									while (!tiraEspacos(linha).contains("}"))
									{
										linha = buffRead.readLine();
									}
									buffRead = new BufferedReader(new FileReader (this.getArquivo()));
									for(int x = 0; x < ErrosNaCompilacao.numeroDaLinha; x++){
										buffRead.readLine();
									}
									linha = buffRead.readLine();
							}
						}
						else if (linha.substring(0,2).equals("if"))
						{
							if (!troca.comparaInt(linha)) 
							{
								while (!tiraEspacos(linha).contains("}"))
								{
									linha = buffRead.readLine();
								}
							}
						}
						else
						{
							idLinha(linha); //chama o metodo para ler as variaveis primitivas
						}
							
					}	

					else if ( !tiraEspacos(linha).contains("{") && !tiraEspacos(linha).contains("}") && tiraEspacos(linha).length() != 0 ) 
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
	
	public void idLinha(String linha)
	{
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
						
		//verifica se foi escrito algo com 6 letras se e igual a string
		else if (linha.substring(0,6).equals("string")) 
		{
							
			string = new Strings();
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
						
				
		else
		{
			troca.getVariaveis(linha);
		}
	}
}
//fim da classe Leitor
//fim da classe Leitor
