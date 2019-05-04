import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.Scanner;

//inicio da classe Float
public class Float extends Floats
{
	//dicionario que armazena as váriaveis criadas
	public static int leituraDaLinha;
	public static HashMap< String,List<Double>> variaveisArmazenadas = new HashMap<String, List<Double>>();
	
	//inicio do método verificacao
	protected boolean verificacao(String str)
	{
		int negativo = 1;
		Scanner input = new Scanner(System.in);
			
		String variavelId ="";
		String variavelValue = "";
		
		boolean verificacaoDoNomeVariavel = false;
		
		int pos=0;
		
		//laco de repetição que lê a linha
		for( int i = 0; i< str.length()-1; i++)
		{
			
			
			if ( str.charAt(i)  == '=' )
			{
				pos = i+1; //marca onde vai começar a leitura dos números

				for( int ii = 6; ii < i; ii++)
				{
					if (str.charAt(ii) == ' ')
					{
						continue;
					}
					
					else
					{
						variavelId = variavelId+ ""+str.charAt(ii);
					}
				}
				verificacaoDoNomeVariavel =  true;

			}
			else if( verificacaoDoNomeVariavel ) //quando a verificação do nome da váriavel é realizada ela passa por essa condicional
			{
				//laço de repetição que lê o inteiro a ser armazenado
				for(int iii = pos; iii<str.length(); iii++)
				{
					if( (str.charAt(iii) == '-') && (variavelValue.length() == 0))
					{
						negativo = -1;
					}

				    // se estiver entre 0 ou 9, ou se tiver ponto
					if ((48<= str.charAt(iii)) && (str.charAt(iii)  <=57) || (str.charAt(iii) == '.'))
					{
						variavelValue= variavelValue+""+str.charAt(iii);	
					}

					else if ( (str.charAt(iii)) != ';' && (str.charAt(iii) != ' '))
					{
						ErrosNaCompilacao.caractere = str.charAt(iii);

						ErrosNaCompilacao.getLineError(2);
					}
				}
                // converte a string variavelValue para double
				double[] valueArray = this.ConvertStringParaDouble(variavelValue);
				double value = valueArray[0];
				this.setValue1(valueArray[0]*negativo);
				this.setValue2(valueArray[1]);
				this.setId(variavelId);
                //System.out.println(variavelId);
				if (variavelValue.length() == 0)
				{
					return false;
				}
				
				else 
				{
					return true;
				}
			}
		}
		return false;
	}
	//fim do método verificador

	//inicio do método ConvertStringParaDouble
	public static double[] ConvertStringParaDouble(String str)
  	{
        int aux = 0;
        double[] value = {0.0,0.0};
        boolean flag = true; // flag a ser modificado ao encontrar ponto 
        // duas variaveis: uma para antes da virgula, outra para depois
	String ad[] = {"",""};

        for(int i = 0; i < str.length(); i++) {
          //System.out.println("Convertendo "+str.charAt(i));

          // se achar ponto: muda a flag, pula o ponto e pega todos os valores após ele
          if(str.charAt(i) == '.') {
            //System.out.println("Passou o .");            
            flag = false;
            i+=1;
            ad[1] = str.substring(i);
          }
          // // isso provavelmente é desnecessário
          // else if(str.charAt(i) == ';') {
          //       break;            
          //   }
          // se não encontrar ponto, adiciona o caractere na variavel
          else if(flag) {
            //System.out.println("Ta aqui");
            ad[0] += str.charAt(i);
          }
        }
        //System.out.println(antes);
        //System.out.println(depois);

        // retorna o valor antes da virgula somado com o valor depois da virgula
        // o depois sofre divisão para ter os decimais após a virgula
				//value = ((Double.parseDouble(ad[1]) / Math.pow(10,ad[1].length())) + Double.parseDouble(ad[0]));
				//System.out.println(value);
				value[0] = Double.parseDouble(ad[0]);
				value[1] = Double.parseDouble(ad[1]);
				return value; // retorna o valor
	}
	//fim do método ConvertStringParaDouble

	//inicio do método armazenarValor
	protected void armazenarValor ()
	{
		List<Double> lista = new ArrayList<Double>();
		lista.add(this.getValue1());
		lista.add(this.getValue2());

		this.variaveisArmazenadas.put(this.getId(), lista);

		Comparadores.tipoVariaveis.put(this.getId(), "float");
	}
	//fim do método armazenarValor
	
	//inicio do método verificador
	public void verificador(String lineText)
	{
		
		if( verificacao(lineText))
		{
	 		this.armazenarValor();
		}
		
		else
		{
			
			//ErrosNaCompilacao.getLineError(1);
		}
	}
	//fim do método verificador
	
}


//fim da classe float
