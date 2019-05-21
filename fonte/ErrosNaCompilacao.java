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
                		System.out.println("(001) Erro na linha "+numeroDaLinha+" Falta colocar ';'" );
				Leitor.laco = false;
				break;
			
			case 1:
				
                		System.out.println("(002) Erro na linha "+numeroDaLinha+" nenhum '"+tipo+"' identificado" );
				Leitor.laco = false;
				break;

			case 2:
                		System.out.println("(Game over) Erro na linha "+numeroDaLinha+" caractere '"+caractere+"' não é um inteiro");
				Leitor.laco = false;
				break;
			case 3:
				System.out.println("(Game over) Nenhum nome de várivel encontrada na linha "+numeroDaLinha);
				Leitor.laco = false;
				break;
				
			default:
				break;
		}
	}
}
//fim da classe ErrosNaCompilacao
