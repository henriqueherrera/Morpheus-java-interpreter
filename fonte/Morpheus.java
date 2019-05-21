//inicio da classe PlayingAndCoding
public class Morpheus
{
	//inicio do método main
	public static void main(String[] args) 
	{
		// Tenta executar os comandos seguintes
		try
		{
			Leitor interpretador = new Leitor(args[0]); // Instancia o Leitor
			long tempoInicial = System.currentTimeMillis(); // Grava o tempo do início do programa na variável
			interpretador.reader(); // Inicia a leitura do arquivo
			// Imprime o tempo de execução ao finalizar o código com sucesso
			System.out.println("tempo de execução: " + (System.currentTimeMillis() - tempoInicial)*0.001f +" segundos");
		}
		// Caso ocorra um erro
		catch(Exception e)
		{
			// É impresso o erro na tela
			System.out.println("Error: na linha ("+ErrosNaCompilacao.numeroDaLinha+") verifique se desta linha para trás, está tudo de acordo com a sintaxe de Morpheus");
		}
	}
	//fim do método main
}
//fim da classe PlayingAndCoding
