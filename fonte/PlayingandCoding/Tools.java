/* na classe tools será coloca ferramentas básicas para linguagem, sendo elas, respectivamente, o print e o input*/
import java.util.Scanner;
//inicio da classe Tools
public class Tools 
{
	//inicio do método tiraEspacos
	public String tiraEspacos(String line)
        {
                String cleanLine= "";
                for(int i = 0; i < line.length(); i++)
                {
                        if( line.charAt(i) != ' ')
                        {
                                cleanLine= cleanLine+""+line.charAt(i);
                        }
                }//esse laço tira os espaços da linha
                return cleanLine;
        }
	//fim do método tiraEspacos
	
	//inicio do método input
	public void input(String line)
	{
		Scanner scan = new Scanner(System.in);	
		
		String id = "";
		if( line.charAt(5) == '(' )
		{
			for(int i = 6; i< line.length(); i++)
			{

				if( line.charAt(i) == ')')
				{
					break;
				}
				else
				{
					id = id+""+line.charAt(i);
				}
			}

			if((Comparadores.tipoVariaveis.get(id)).equals("int"))
			{
				
				
				int value = 0;
				value = scan.nextInt();
				Int.variaveisArmazenadas.put(id,value);
			}
			else if((Comparadores.tipoVariaveis.get(id)).equals("string"))
			{
				String value = "";
				value = scan.nextLine();
				Strings.variaveisArmazenadas.put(id,value);
			}
		}
	}
	//fim do método input
}
//fim da classe Tools
