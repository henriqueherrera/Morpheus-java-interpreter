import java.util.HashMap;
//Inicio da classe Condiconais
public class Condicional
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
	public void condicionalIf(int numeroDeLinhas, String value)
        {
		String tipo = "";

		Comparadores testBooleano = new Comparadores();

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

            if(Bool.variaveisArmazenadas.get(value))
            {
				le = new LePrimitivos();
				
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
			}
		}
		
		else if(tipo.equals("char"))
		{
			if(testBooleano.comparaChar(value))
            
				le = new LePrimitivos();
				
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
		}

		else if(tipo.equals("string"))
		{
			if(testBooleano.comparaStr(value))
            {
				le = new LePrimitivos();
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
			}
		}
		else if (tipo.equals("int"))
		{
			if(testBooleano.comparaInt(value))
            {
				le = new LePrimitivos();
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
			}
		}
		else if (tipo.equals("double"))
		{
			if(testBooleano.comparaDouble(value))
			{
				le = new LePrimitivos();
				for(int i = 1; i<=numeroDeLinhas; i++)
				{
					le.idLinha(txtLines.get(i), i);
				}
			}
		}
	}
	//fim do método lacoDeRepeticao

}
//Fim da classe Condicionais