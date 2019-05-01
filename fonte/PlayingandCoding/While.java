import java.util.HashMap;
public class While 
{
        public static HashMap<Integer, String> txtLines = new HashMap<Integer, String>(); //vai ler cada linha dentro do whil
	
	
        public  static void lacoDeRepeticao(int numeroDeLinhas, String value)
        {
		LePrimitivos le = new LePrimitivos();
                while(Bool.variaveisArmazenadas.get(value))
                {
                        for(int i = 0; i<numeroDeLinhas;i++)
                        {
                                le.idLinha(txtLines.get(i));
                        }


                }
        }
}
