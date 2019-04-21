import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class Leitor
{

	private String arquivo; //Lê o arquivo para ser Interpretado

	private Bool bool = new Bool();
	private Int inteiros = new Int();
    	
	private Float floats = new Float(); // Instancia os floats? Comentário lixo
	
	private Char chars = new Char();

	public static boolean laco = true;
	//Construtor
	public Leitor(String arq)
	{
		this.setArquivo(arq);
	}

	public void reader() 
	{
		try{
		BufferedReader buffRead = new BufferedReader(new FileReader (this.getArquivo()));

                String linha = "";

                while(laco)
                {
			
                        linha = buffRead.readLine();
                        if(linha !=  null)
                        {
				if (linha.charAt(linha.length()-1) == 59)
				{
					//chama as funções aqui para armazenamento
					
					if (linha.substring(0,3).equals("int"))
					{
						inteiros.verificador(linha);
                                		//System.out.println(linha);
					}
                    //se encontrar float no inicio da linha, chama o verificador de floats
                    			else if (linha.substring(0,5).equals("float"))
					{
						floats.verificador(linha);
                                		//System.out.println(linha);
					}
					else if (linha.substring(0,4).equals("char"))
					{

						chars.verificador(linha);
					}

					else if (linha.substring(0,4).equals("bool"))
					{
						bool.verificador(linha);
					}
				}
				else 
				{
					ErrosNaCompilacao.getLineError(0);

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
	
	public String getArquivo()
	{
		return this.arquivo;
	}

	public void setArquivo(String a)
	{
		this.arquivo = a;	
	}
}

