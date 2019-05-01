import java.io.*;
import java.lang.*;

//inicio da classe Leitor
class Leitor extends Tools
{
	private String arquivo; //Lê o arquivo para ser Interpretado

	private Comparadores troca = new Comparadores();
	
	private LePrimitivos lePrimitivos = new LePrimitivos();	
	public static boolean laco = true; //enquanto tudo estiver ocorrendo de maneira prevista
					//o laco de repeticao continua trocando de linha
	
	//Construtor
	public Leitor(String arq)
	{
		this.setArquivo(arq);
	}

	public Leitor()
	{
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
						if (linha.substring(0,2).equals("wi")) {
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
							Comparadores.vl =2;
							if (!troca.comparaInt(linha)) 
							{
								while (!tiraEspacos(linha).contains("}"))
								{
									linha = buffRead.readLine();
								}
							}
						}

				   		else if (linha.substring(0,5).equals("while"))
                                                {
                                                        
                                                        String idValue = tiraEspacos(linha.substring(5,linha.length()-1)); //pega a expressão do while
							linha = buffRead.readLine(); //pula o }
							int count = 0; //conta o numero de linhas dentro do while
                                                        
							if(linha.contains("{"))
                                                        {
                                                                linha = buffRead.readLine();
                                                                while(true)
                                                                {
                                                                        if(linha.contains("}"))
                                                                        {
                                                                                break;
                                                                        }
                                                                        else
                                                                        {
                                                                                While.txtLines.put(count,linha);
                                                                                count++;
                                                                        }
                                                                        linha = buffRead.readLine();
                                                                }
                                                        }
                                                        
							While.lacoDeRepeticao(count,idValue);//chama o laco de repeticao while
                                                       
                                                }
						else
						{
							lePrimitivos.idLinha(linha); //chama o metodo para ler as variaveis primitivas
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
	

}
//fim da classe Leitor
