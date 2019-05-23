//Inicio da classe Condiconais
public class Condicional extends Tools
{
	//inicio do método laco
	public int linhaDoElse = -1; // Se for diferente de -1 é porque existe um else

	public void condicionalIf(int numeroDeLinhas, String value)
  	{
		int end = numeroDeLinhas;
		String tipo = "";

		if(linhaDoElse != -1) // se nao tiver else o if le todas as linhas se tiver ele le ate o ponto em que esta o else
		//que seria o linhaDoElse
		{
			end = linhaDoElse;
		}

		Comparadores testBooleano = new Comparadores(); // Instancia o objeto de comparação

		for(int i = 0; i < value.length(); i++)
		{
			if(value.charAt(i) == '|')
			{
				value = value.substring(i+1,value.length()); // Le a expressao ou variavel
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
				for(int i = 1; i<=end;i++)
				{
					le.idLinha(txtLines.get(i),i);
	       		}
			}

			else if(this.linhaDoElse > -1)
			{
				le = new LePrimitivos();
				for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
				{
					le.idLinha(txtLines.get(i),i);
				}
			}

		}

		else if(tipo.equals("bool"))
		{

			if (value.contains("[") && value.contains("]"))
			{
				value = testBooleano.valorDoVetor(value);

				if( Boolean.parseBoolean(value))
				{
					le = new LePrimitivos();
					for(int i = 1; i<=end;i++)
					{
						le.idLinha(txtLines.get(i),i);
	        		}
				}

				else if(this.linhaDoElse > -1)
				{
					le = new LePrimitivos();
					for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
					{
						le.idLinha(txtLines.get(i),i);
					}
				}

			}
    		else
     		{
				if( Bool.variaveisArmazenadas.get(value))
				{
					le = new LePrimitivos();
					for(int i = 1; i<=end;i++)
					{
						le.idLinha(txtLines.get(i),i);
	        		}
				}

				else if(this.linhaDoElse > -1)
				{
					le = new LePrimitivos();
					for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
					{
						le.idLinha(txtLines.get(i),i);
					}
				}
			}
		}
		
		else if(tipo.equals("char"))
		{

			if(testBooleano.comparaChar(value))
	    	{
				le = new LePrimitivos();

				for(int i = 1; i<=end;i++)
				{
					le.idLinha(txtLines.get(i),i);
	      		}

			}
			else if(this.linhaDoElse > -1)
			{
				le = new LePrimitivos();

				for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
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

				for(int i = 1; i<=end;i++)
				{
					le.idLinha(txtLines.get(i),i);
	      		}
			}
			
			else if(this.linhaDoElse > -1)
			{
				le = new LePrimitivos();

				for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
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

				for(int i = 1; i<=end;i++)
				{
					le.idLinha(txtLines.get(i),i);
	      		}
			}
			else if(this.linhaDoElse > -1)
			{
				le = new LePrimitivos();

				for(int i = this.linhaDoElse; i<= numeroDeLinhas; i++)
				{
					le.idLinha(txtLines.get(i),i);
				}

			}
		}
	}
	//fim do método lacoDeRepeticao
}
//Fim da classe Condicional
