//Inicio da classe Condiconais
public class Else extends Condicional
{
    //inicio do método laco

	public void condicionalElse(int numeroDeLinhas, String value)
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
		
		le = new LePrimitivos();
				
		for(int i = 1; i<=numeroDeLinhas;i++)
		{
			le.idLinha(txtLines.get(i),i);
        }
	}
	//fim do método lacoDeRepeticao

}
//Fim da classe Condicionais
