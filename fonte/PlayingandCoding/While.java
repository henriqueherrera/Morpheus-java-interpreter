import java.util.HashMap;

//inicio da classe While
public class While
{
        public HashMap<Integer, String> txtLines = new HashMap<Integer, String>(); //vai ler cada linha dentro do while

	public LePrimitivos le;

	private int abreChave;

	private int fechaChave;

	private int numeroDeLinhas;

	//inicio do método countLines
	public int countLines()
	{
		numeroDeLinhas++;
		return numeroDeLinhas;
	}
	//fim do método countLines
	
	//inicio do método getNumeroDelinhas
	public int getNumeroDeLinhas()
	{
		return numeroDeLinhas;
	}
	//fim do método getNumeroDeLinhas
	
	//inicio do método countAbreChave
	public void countAbreChave()
	{
		this.abreChave++;
	}
	//fim do método countAbreChave
	
	//inicio do método countFechaChave
	public void countFechaChave()
	{
		this.fechaChave++;
	}
	//fim do método countFechaChave
	
	//inicio do método igualdadeDeChave
	public boolean igualdadeDeChave()
	{
		return this.abreChave == this.fechaChave ? true:false;
	}
	//fim do método igualdadeDeChave
	
	//inicio do método laco
	public void laco(int numeroDeLinhas, String value)
        {
		String tipo = "";

		Comparadores troca = new Comparadores();

		for(int i = 0; i<value.length(); i++)
		{
			if(value.charAt(i) == '|')
			{
				value = value.substring(i+1,value.length()); //le a expressao ou variavel
				break;
			}

			else
			{
				tipo = tipo+""+value.charAt(i);
			}
		}

		if(tipo.equals("bool"))
		{

                	while(Bool.variaveisArmazenadas.get(value))
                	{
			
                        	
				le = new LePrimitivos();
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
						
                                	le.idLinha(txtLines.get(i),i);
                        	}
			}
        	}
	}
	//fim do método lacoDeRepeticao
}
//fim da classe  while
