import java.util.ArrayList;
import java.util.HashMap;

//Inicio da classe Def
public class Def extends Tools
{
    private String escopo;

    private LePrimitivos leitor = new LePrimitivos();
    //Inicio do método getEscopo
    public String getEscopo()
    {
        return this.escopo;
    }
    //Fim do método getEscopo

    //Inicio do método setEscopo
    public void setEscopo(String escopo)
    {
        this.escopo = escopo;
    }
    //Fim do método setEscopo

    //Inicio do método runParametros
    public void runParametros(String value)//armazena as variveis do escopo
    {
        String[] list = getEscopo().split(","); //variaveis do escopo
        String[] valores = value.split(","); //valores passados como parametro
        int count = 0;
        for(String str: list)
        {
            leitor.idLinha(str+"="+valores[count]+";",0);
            count++;
        }
    }
    //Fim do método runParametros
}
//Fim da classe Def