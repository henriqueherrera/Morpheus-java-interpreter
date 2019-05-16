/* na classe tools será coloca ferramentas básicas para linguagem, sendo elas, respectivamente, o print e o input*/
import java.util.Scanner;
import java.util.HashMap;

//inicio da classe Tools
public class Tools
{
	public HashMap<Integer, String> txtLines = new HashMap<Integer, String>();

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

	//inicio do método resetChaves
	public void resetChaves()
	{
		this.abreChave = 0;
		this.fechaChave = 0;
	}
	//fim do método reserChaves
	//inicio do método tiraEspacos
	public String tiraEspacos(String line)
    {
        String cleanLine= "";

		boolean achoString = true;
		
		for(int i = 0; i < line.length(); i++)
        {
			if( line.charAt(i) == '"' && achoString) //aqui é pra ele nao tira os espacos dentro de uma string
			{
				cleanLine = cleanLine+""+line.charAt(i);

				for(int ii = i+1; ii< line.length(); ii++)
				{
					if(line.charAt(ii) == '"')
					{

						cleanLine= cleanLine+""+line.charAt(ii);
						achoString = false;
						i = ii+1;
						break;
					}
					else
					{
						cleanLine= cleanLine+""+line.charAt(ii);
					}
				}
			}

            if( line.charAt(i) != ' ')
            {
                cleanLine= cleanLine+""+line.charAt(i);
            }
        }//esse laço tira os espaços da linha
		
		return cleanLine;
    }
	//fim do método tiraEspacos

	//inicio do método print
	public void print(String line)
	{
		int inicioStr = 6;

		int fimStr= 0;

		if( line.charAt(5) == '(')
		{
			for(int i = inicioStr; i< line.length(); i++)
			{
				if( line.charAt(i) == ')')
				{
					fimStr = i;
					break;
				}
			}
		}

		String[] prints = line.substring(inicioStr,fimStr).split("=>");

		Strings strings = new Strings();

		for( String str:prints)
		{
			if(str.charAt(0) == '"')
			{
				str = str+" "; //esse " " é para passar na funcao valueString sem excluir o ultimo caractere
				strings.valueString(str,0);
				System.out.print(strings.getVariavelValue()+" ");
				strings.setVariavelValue("");
			}
			else if(str.contains("[") && str.contains("]"))
			{
				str = this.tiraEspacos(str);
				Int inteiro = new Int();
				if( Comparadores.tipoVariaveis.get(str.substring(str.indexOf("]")+1,str.length())).equals("string"))
				{
					System.out.print(Strings.vetoresArmazenados.get(str.substring(str.indexOf("]")+1,str.length())).get(inteiro.indetificadorDeNumerosInt(str.substring(str.indexOf("[")+1,str.indexOf("]")),0)));
				}
				
				else if(Comparadores.tipoVariaveis.get(str.substring(str.indexOf("]")+1,str.length())).equals("char"))
				{
					System.out.print(Char.vetoresArmazenados.get(str.substring(str.indexOf("]")+1,str.length())).get(inteiro.indetificadorDeNumerosInt(str.substring(str.indexOf("[")+1,str.indexOf("]")),0)));
				}
				else if(Comparadores.tipoVariaveis.get(str.substring(str.indexOf("]")+1,str.length())).equals("int"))
				{
					System.out.print(Int.vetoresArmazenados.get(str.substring(str.indexOf("]")+1,str.length())).get(inteiro.indetificadorDeNumerosInt(str.substring(str.indexOf("[")+1,str.indexOf("]")),0)));
				}
			}
			else if(Comparadores.tipoVariaveis.get(str).equals("int"))
			{
				System.out.print(Int.variaveisArmazenadas.get(str)+" ");
			}

			else if(Comparadores.tipoVariaveis.get(str).equals("char"))
			{
				System.out.print(Char.variaveisArmazenadas.get(str)+" ");
			}

			else if(Comparadores.tipoVariaveis.get(str).equals("string"))
			{
				System.out.print(Strings.variaveisArmazenadas.get(str)+" ");

			}

			else if(Comparadores.tipoVariaveis.get(str).equals("bool"))
			{
				System.out.print(Bool.variaveisArmazenadas.get(str)+" ");
			}

			else if(Comparadores.tipoVariaveis.get(str).equals("double"))
			{
				System.out.printf("%f",Doubles.variaveisArmazenadas.get(str));
			}
		}
		System.out.println();
	}
	//fim do método print

	//inicio do método input
	public void input(String line)
	{
		Scanner scan = new Scanner(System.in);

		Strings str = new Strings();

		String id = "";

		int leValue = 6;
		if( line.charAt(5) == '(' )
		{
			if(line.charAt(leValue) == '"')//se tiver um " ele pega a frase que tem dentro da string para mostrar na tela para o usuario
			{
				str.valueString(line,leValue);
				leValue+=str.getVariavelValue().length()+3;// o +3 é para considerar os dois " e ,
			}

			for(int i = leValue; i< line.length(); i++)
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

			if(str.getVariavelValue().length() > 0)
			{
				System.out.print(str.getVariavelValue());
			}
			
			if(id.contains("[") && id.contains("]")) //por enquanto ta generico so para int
			{
				Int inteiro = new Int();
				
				if(Comparadores.tipoVariaveis.get(id.substring(id.indexOf("]")+1,id.length())).equals("string"))
				{
					String vl = "";
					vl = scan.nextLine();
					Strings.vetoresArmazenados.get(id.substring(id.indexOf("]")+1,id.length())).put(inteiro.indetificadorDeNumerosInt(id.substring(id.indexOf("[")+1,id.indexOf("]")),0),vl);
				}
				else if(Comparadores.tipoVariaveis.get(id.substring(id.indexOf("]")+1,id.length())).equals("char"))	
				{
					char vl;
					vl = scan.next().charAt(0);
					Char.vetoresArmazenados.get(id.substring(id.indexOf("]")+1,id.length())).put(inteiro.indetificadorDeNumerosInt(id.substring(id.indexOf("[")+1,id.indexOf("]")),0),vl);
				}
				else if(Comparadores.tipoVariaveis.get(id.substring(id.indexOf("]")+1,id.length())).equals("int"))	
				{
					int vl;
					vl = scan.nextInt();
					Int.vetoresArmazenados.get(id.substring(id.indexOf("]")+1,id.length())).put(inteiro.indetificadorDeNumerosInt(id.substring(id.indexOf("[")+1,id.indexOf("]")),0),vl);
				}
			}
			else if((Comparadores.tipoVariaveis.get(id)).equals("int"))
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
			else if((Comparadores.tipoVariaveis.get(id)).equals("char"))
			{
				char value;
				value = scan.next().charAt(0);
				Char.variaveisArmazenadas.put(id,value);
			}

			else if((Comparadores.tipoVariaveis.get(id)).equals("bool"))
			{
				boolean value;
				value = scan.nextBoolean();
				Bool.variaveisArmazenadas.put(id,value);
			}
			else if((Comparadores.tipoVariaveis.get(id)).equals("double"))
			{
				double value;
				value = Double.parseDouble(scan.nextLine());
				Doubles.variaveisArmazenadas.put(id,value);
			}
		}
	}
	//fim do método input
}
//fim da classe Tools
