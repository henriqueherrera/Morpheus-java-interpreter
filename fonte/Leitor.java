import java.io.*;
//inicio da classe Leitor
class Leitor extends Tools
{
	private String arquivo; // Le o arquivo para ser Interpretado.

	private LePrimitivos lePrimitivos = new LePrimitivos(); // Instancia o objeto que controla a leitura dos tipos primitivos.

	public static boolean laco = true; // Enquanto tudo estiver ocorrendo de maneira prevista
																		 // o laco de repeticao continua trocando de linha.
	//Construtor
	public Leitor(String arq) // Construtor que define o caminho do arquivo.
	{
		// Aceita o arquivo se ele possuir a extensão .mp
		if(arq.contains(".mp"))
		{
			this.setArquivo(arq);
		}
		// Caso contrário, imprime uma mensagem de erro.
		else
		{
			System.out.println("Para interpretar um código é preciso colocar na extensão .mp");
		}
	}

	public Leitor() // Ajuste técnico que evita problemas quando uma condição tenta instancia-lo
	{
	}

	//inicio do método reader.
	public void reader()
	{
		// Tenta rodar os comandos seguintes:
		try
		{
			BufferedReader buffRead = new BufferedReader(new FileReader (this.getArquivo())); // Le o arquivo do código.
			String linha = ""; // Define a variável que armazena cada linha lida.
    	// Enquanto tudo estiver rodando corretamente, o laço permanece rodando.
    	while(laco)
    	{
    		linha = buffRead.readLine(); // Guarda a linha atual na variável.

		    if(linha != null) // Se a linha não for nula:
        {
          // Se a linha for diferente de zero e não estiver comentada:
			    if((linha.length() != 0 ) && (!linha.contains("//")) && (!linha.trim().equals("")))
			    {
				    linha = linha.trim(); // Limpa a identação.
				    lePrimitivos.idLinha(linha,0); // Chama o metodo para ler as variaveis primitivas.
			    }
          // Caso contrário, se a linha não possuir nem chaves, nem for comentada e seu tamanho for diferente de zero:
			    else if( !tiraEspacos(linha).contains("{") && !tiraEspacos(linha).contains("}") && (!linha.contains("//")) && !tiraEspacos(linha).equals("") && tiraEspacos(linha).length() == 0)
			    {
            // Acessa a mensagem de erro de código zero e desativa o laço.
						ErrosNaCompilacao.getLineError(0);
						laco = false;
					}
					ErrosNaCompilacao.numeroDaLinha+=1; // COMO FUNCIONA ISSO DAQUI?
				}
        // Caso contrário, termina o laço.
				else
				{
					break;
				}
			}
      // No fim do laço, fecha o buffer de leitura.
			buffRead.close();
		}
		// Caso ocorra um erro durante a execução do código, o mesmo é impresso na tela
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	//fim do método reader.

	//inicio do método getArquivo
	public String getArquivo()
	{
		return this.arquivo; // Retorna o nome do arquivo.
	}
	//fim do método getArquivo

	//inicio do método setArquivo
	public void setArquivo(String a)
	{
		this.arquivo = a; // Coloca o caminho do arquivo a ser lido na variável
	}
	//fim do método setArquivo
}
//fim da classe Leitor
