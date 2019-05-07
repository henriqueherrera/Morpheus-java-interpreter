import java.util.HashMap;
public class While 
{
        public HashMap<Integer, String> txtLines = new HashMap<Integer, String>(); //vai ler cada linha dentro do while

	public LePrimitivos le; 
	public void lacoDeRepeticao(int numeroDeLinhas, String value,int comecoDaLeitura)
        {
		le = new LePrimitivos();
		System.out.println(txtLines);
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
		;
		if(tipo.equals("bool"))
		{

			LePrimitivos le = new LePrimitivos();
                	while(Bool.variaveisArmazenadas.get(value))
                	{
			
                        	
				for(int i = comecoDaLeitura; i<numeroDeLinhas;i++)
				{
						
					System.out.println(txtLines.get(i));
                                	le.idLinha(txtLines.get(i),i);
                        	}


         	       }
        	}
		else if(tipo.equals("char"))
		{
		
			LePrimitivos le = new LePrimitivos();
			while(troca.comparaChar(value))
                	{
				
                        	for(int i = comecoDaLeitura; i<numeroDeLinhas;i++)
                        	{
                                	le.idLinha(txtLines.get(i),i);
                        	}


         	       }	
		}
	}
}
