//Inicio da classe Condiconais
public class Condicional extends Tools
{
    //inicio do método laco
	public boolean condicionalIf(int numeroDeLinhas, String value)
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
		
		if(tipo.equals("string"))
		{
			if(testBooleano.comparaStr(value))
            {
				le = new LePrimitivos();
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
			}
            return true;
		}

		else if(tipo.equals("bool"))
		{
			if (value.contains("[") && value.contains("]"))
			{	
				value = testBooleano.valorDoVetor(value);
				if( Boolean.parseBoolean(value))
				{
					le = new LePrimitivos();
				
					for(int i = 1; i<=numeroDeLinhas;i++)
					{
						le.idLinha(txtLines.get(i),i);
                	}	
				}
                return true;
			}
            else if(Bool.variaveisArmazenadas.get(value))
            {
				le = new LePrimitivos();
				
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
                }
                return true;
			}
		}
		
		else if(tipo.equals("char"))
		{
			if(testBooleano.comparaChar(value))
            {
				le = new LePrimitivos();
				
				for(int i = 1; i<=numeroDeLinhas;i++)
				{
					le.idLinha(txtLines.get(i),i);
				}
                return true;
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
                return true;
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
                return true;
			}
		}
        return false;
	}
	//fim do método lacoDeRepeticao
}
//Fim da classe Condicional
