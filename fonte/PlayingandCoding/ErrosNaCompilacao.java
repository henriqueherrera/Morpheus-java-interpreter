class ErrosNaCompilacao
{
	public static int numeroDaLinha = 1;
	public static char caractere;
	public static void getLineError(int x)
	{
		switch(x)
		{
			case 0:
                		System.out.println("Erro na linha "+numeroDaLinha+" Falta colocar ';'" );
				break;
			
			case 1:
				
                		System.out.println("Erro na linha "+numeroDaLinha+" nenhum 'int' identificado" );
			case 2:
                		System.out.println("Erro na linha "+numeroDaLinha+" caractere '"+caractere+"' não é um inteiro");
			default:
				break;
		}
	}
}
