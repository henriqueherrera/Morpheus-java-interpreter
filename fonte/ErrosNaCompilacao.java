//inicio da classe ErrosNaCompilacao
class ErrosNaCompilacao
{
	public static int numeroDaLinha = 1;

	public static String tipo;

	public static char caractere;

	public static void getLineError(int x)
	{
		switch(x)
		{
			case 0:
                		System.out.println("(001) Tudo que tem um começo tem um fim.(Oráculo) \n Erro na linha "+numeroDaLinha+" Falta colocar ';' \n" );
										Leitor.laco = false;
				break;

			case 1:

                		System.out.println("(002) Eles são todos e não são ninguém.(Morpheus) \n Erro na linha "+numeroDaLinha+" nenhum '"+tipo+"' identificado\n" );
										Leitor.laco = false;
				break;

			case 2:
                		System.out.println("(003) Há uma grande diferença entre saber o caminho e percorrer o caminho.(Morpheus) \n Erro na linha "+numeroDaLinha+" caractere '"+caractere+"' não é um inteiro\n");
				Leitor.laco = false;
				break;
			case 3:
				System.out.println("(004) Não pense que é , Saiba que é .(Morpheus) \n Nenhum nome de várivel encontrada na linha "+numeroDaLinha+"\n");
				Leitor.laco = false;
				break;

			default:
				break;
		}
	}
}
//fim da classe ErrosNaCompilacao
