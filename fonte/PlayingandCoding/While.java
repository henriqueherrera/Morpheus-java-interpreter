//inicio da classe While
public class While extends Tools
{
	//inicio do método laco
	public void laco(int numeroDeLinhas, String value)
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
			System.out.println(value);
			if(value.contains("[") && value.contains("]"))
			{
				while(Boolean.parseBoolean(testBooleano.valorDoVetor(value)))
            	{
					le = new LePrimitivos();
					
					for(int i = 1; i<=numeroDeLinhas;i++)
					{
						le.idLinha(txtLines.get(i),i);
                	}
				}	
			}
			else
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
		else if(tipo.equals("char"))
		{
			while(testBooleano.comparaChar(value))
            {
				le = new LePrimitivos();
				
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
			}
		}

		else if(tipo.equals("string"))
		{
			while(testBooleano.comparaStr(value))
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
			while(testBooleano.comparaInt(value))
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
			while(testBooleano.comparaDouble(value))
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
//fim da classe  while