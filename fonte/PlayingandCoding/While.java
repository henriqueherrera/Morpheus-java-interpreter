import java.util.HashMap;
public class While 
{
        public static HashMap<Integer, String> txtLines = new HashMap<Integer, String>(); //vai ler cada linha dentro do whil
	
	
        public  static void lacoDeRepeticao(int numeroDeLinhas, String value)
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
		System.out.println();
		LePrimitivos le = new LePrimitivos();
		if(tipo.equals("bool"))
		{
                	while(Bool.variaveisArmazenadas.get(value))
                	{
                        	for(int i = 0; i<numeroDeLinhas;i++)
                        	{
                                	le.idLinha(txtLines.get(i));
                        	}


         	       }
        	}
		else if(tipo.equals("char"))
		{
			while(troca.comparaChar(value))
                	{
                        	for(int i = 0; i<numeroDeLinhas;i++)
                        	{
                                	le.idLinha(txtLines.get(i));
                        	}


         	       }	
		}
	}
}
