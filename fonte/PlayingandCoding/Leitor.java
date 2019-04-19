import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class Leitor
{

	private String arquivo; //Lê o arquivo para ser Interpretado

	private Int inteiros = new Int(); 
	
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

                while(true)
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
				}
				else 
				{
					ErrosNaCompilacao.getLineError(0);
				}
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

