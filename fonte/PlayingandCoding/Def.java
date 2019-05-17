import java.util.ArrayList;
import java.util.HashMap;

//Inicio da classe Def
public class Def extends Tools
{
    public HashMap<String,String> strArmazenadas = new HashMap<String, String>();
    public HashMap<String,HashMap<Integer,String>> strVetArmazenados = new HashMap<String,HashMap<Integer,String>>();
    
    public HashMap<String,Boolean> boolArmazenadas = new HashMap<String, Boolean>();
    public HashMap<String,HashMap<Integer,Boolean>> boolVetArmazenados = new HashMap<String,HashMap<Integer,Boolean>>();
    
    public HashMap<String, Integer> intArmazenadas = new HashMap<String, Integer>();
    public HashMap<String,HashMap<Integer,Integer>> intVetArmazenados = new HashMap<String,HashMap<Integer,Integer>>();
    
    public HashMap<String,Character> charArmazenadas = new HashMap<String, Character>();
    public HashMap<String,HashMap<Integer,Character>> charVetArmazenados = new HashMap<String,HashMap<Integer,Character>>();
    
    public HashMap<String,Double> doubleArmazenadas = new HashMap<String, Double>();
    public HashMap<String,HashMap<Integer,Double>> doubleVetArmazenados = new HashMap<String,HashMap<Integer,Double>>();
    
    private String escopo;

    private Int conversor;
    private LePrimitivos leitor = new LePrimitivos();
    //Inicio do método saveVariaveis
    public void saveVariaveis() //salva as variaveis para alternar apenas a que vai retornar
    {
        //salva as variaveis do codigo principal
        this.doubleArmazenadas.putAll(Doubles.variaveisArmazenadas);
        this.intArmazenadas.putAll(Int.variaveisArmazenadas);
        this.charArmazenadas.putAll(Char.variaveisArmazenadas);
        this.strArmazenadas.putAll(Strings.variaveisArmazenadas);
        this.boolArmazenadas.putAll(Bool.variaveisArmazenadas);

        //salva os vetores do codigo principal
        this.doubleVetArmazenados.putAll(Doubles.vetoresArmazenados);
        this.intVetArmazenados.putAll(Int.vetoresArmazenados);
        this.charVetArmazenados.putAll(Char.vetoresArmazenados);
        this.strVetArmazenados.putAll(Strings.vetoresArmazenados);
        this.boolVetArmazenados.putAll(Bool.vetoresArmazenados);
    }
    //Fim do método saveVariaveis
    
    //Inicio do método clearVariaveis
    public void clearVariaveis() //limpa todas as variaveis modificadas na funcao
    {
        Doubles.variaveisArmazenadas.clear();
        Doubles.vetoresArmazenados.clear();

        Int.variaveisArmazenadas.clear();
        Int.vetoresArmazenados.clear();

        Char.variaveisArmazenadas.clear();
        Char.vetoresArmazenados.clear();

        Strings.variaveisArmazenadas.clear();
        Strings.vetoresArmazenados.clear();

        Bool.variaveisArmazenadas.clear();
        Bool.vetoresArmazenados.clear();
    }
    //fim do método clearVariaveis

     //Inicio do método setVariaveis
    public void setVariaveis() //seta as variaveis modificando apenas a que vai retornar
    {
        //salva as variaveis no codigo principal
        Doubles.variaveisArmazenadas.putAll( this.doubleArmazenadas);
        Int.variaveisArmazenadas.putAll(this.intArmazenadas);
        Char.variaveisArmazenadas.putAll(this.charArmazenadas);
        Strings.variaveisArmazenadas.putAll(this.strArmazenadas);
        Bool.variaveisArmazenadas.putAll(this.boolArmazenadas);
          
        //salva os vetores no codigo principal
        Doubles.vetoresArmazenados.putAll(this.doubleVetArmazenados);
        Int.vetoresArmazenados.putAll(this.intVetArmazenados);
        Char.vetoresArmazenados.putAll(this.charVetArmazenados);
        Strings.vetoresArmazenados.putAll(this.strVetArmazenados);
        Bool.vetoresArmazenados.putAll(this.boolVetArmazenados);
    }
    //Fim do método setVariaveis
     
    //Inicio do método getEscopo
    public String getEscopo() //pega o escopo da funcao
    {
        return this.escopo;
    }
    //Fim do método getEscopo

    //Inicio do método setEscopo
    public void setEscopo(String escopo) //seta o escopo da fruncao
    {
        this.escopo = escopo;
    }
    //Fim do método setEscopo

    //Inicio do método runParametros
    public void runParametros(String value)//armazena as variveis do escopo com os valores passados
    {
        this.saveVariaveis();
        String[] list = getEscopo().split(","); //variaveis do escopo
        String[] valores = value.split(","); //valores passados como parametro
        
        int count = 0;
        for(String str: list)
        {
            String aux;
            if(valores[count].contains("["))
            {
                conversor = new Int();
                aux  = str+"="+Int.vetoresArmazenados
                .get(valores[count]
                .substring(valores[count]
                .indexOf("]")+1,valores[count].length()))
                .get(conversor.indetificadorDeNumerosInt(valores[count]
                .substring(valores[count]
                .indexOf("[")+1,valores[count]
                .indexOf("]")),0))+";";
            }
            else
            {
                aux = str+"="+Int.variaveisArmazenadas.get(valores[count])+";";
            }
            leitor.idLinha(aux,1);
            count++;
        }
    }
    //Fim do método runParametros
    
    //Inicio do método chamadaDef
    public void chamadaDef(String linha) //chama a funcao
    {
        String linhaDeComando;
        
        String variavel = linha.substring(0,linha.indexOf("="));
        
        for(int i = 1; i< this.txtLines.size();i++)
        {
            //le as linha da funcao
            linhaDeComando = txtLines.get(i); 
            
            if(linhaDeComando.contains("return"))
            {
                
                conversor = new Int();
                
                String valorParaRetornar = this.tiraEspacos(linhaDeComando.substring( 6,linhaDeComando.indexOf(";")));
                
                if(variavel.contains("[") && variavel.contains("]"))//armazena o valor no vetor
                {
                    
                    String variavelDoVetor = linha.substring(linha.indexOf("]")+1,linha.indexOf("="));
                    
                    int indice = conversor.indetificadorDeNumerosInt(variavel.substring(variavel.indexOf("[")+1,variavel.indexOf("]")),0);
                    
                    if(Comparadores.tipoVariaveis.get(variavelDoVetor).equals("int"))
                    {
                        intVetArmazenados.get(variavelDoVetor).put(indice,Int.vetoresArmazenados.get(valorParaRetornar).get(indice));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelDoVetor).equals("double"))
                    {
                        doubleVetArmazenados.get(variavelDoVetor).put(indice,Doubles.vetoresArmazenados.get(valorParaRetornar).get(indice));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelDoVetor).equals("char"))
                    {
                        charVetArmazenados.get(variavelDoVetor).put(indice,Char.vetoresArmazenados.get(valorParaRetornar).get(indice));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelDoVetor).equals("string"))
                    {
                        strVetArmazenados.get(variavelDoVetor).put(indice,Strings.vetoresArmazenados.get(valorParaRetornar).get(indice));
                    }

                    else if(Comparadores.tipoVariaveis.get(variavelDoVetor).equals("bool"))
                    {
                        boolVetArmazenados.get(variavelDoVetor).put(indice,Bool.vetoresArmazenados.get(valorParaRetornar).get(indice));
                    }
                }
                
                else
                {
                   
                    String variavelId = linha.substring(0,linha.indexOf("="));
                    
                    if(Comparadores.tipoVariaveis.get(variavelId).equals("int"))
                    {
                        intArmazenadas.put(variavelId,Int.variaveisArmazenadas.get(valorParaRetornar));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelId).equals("double"))
                    {
                        doubleArmazenadas.put(valorParaRetornar,Doubles.variaveisArmazenadas.get(valorParaRetornar));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelId).equals("char"))
                    {
                        charArmazenadas.put(valorParaRetornar,Char.variaveisArmazenadas.get(valorParaRetornar));
                    }
                    
                    else if(Comparadores.tipoVariaveis.get(variavelId).equals("string"))
                    {
                        strArmazenadas.put(valorParaRetornar,Strings.variaveisArmazenadas.get(valorParaRetornar));
                    }

                    else if(Comparadores.tipoVariaveis.get(variavelId).equals("bool"))
                    {
                        boolArmazenadas.put(valorParaRetornar,Bool.variaveisArmazenadas.get(valorParaRetornar));
                    }
                }
                break; // encerra a funcao
            }

            else
            {
                leitor.idLinha(this.txtLines.get(i), i);
            }
        }
        this.clearVariaveis();
        this.setVariaveis();
    }
    //Fim do método chamadaDef
}
//Fim da classe Def