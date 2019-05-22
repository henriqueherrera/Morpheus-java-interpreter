 ![Image of Logo](https://raw.githubusercontent.com/Lokens/Vergonhas-Secretas/master/Imagens%20do%20Mopheus/logo.png?token=AHOOZHHCRZSYRJXE434D4K244XIKK)
   
      
         
# **Documentação do Morpheus Language**
    
      
### Criadores :
```
Henrique Herrera (https://github.com/henriqueherrera  ||  henriqueherrera9@gmail.com) 
Matheus Slama (https://github.com/Lokens  ||  matheus_slama@hotmail.com)
Pablo Lodi (https://github.com/PabloLodi  || lodiricardopablo@gmail.com)
```

## **Usando o Morpheus**
     
1. Você deve possuir o Java Development Kit 8 ou OpenJDK 8 instalado.
2. Escreva o código a ser interpretado no seu editor favorito e salve com a extensão .mp
3. Execute o Interpretador no terminal com o comando: 
```
				    java -jar Morpheus.jar nomedoarquivo.mp
```
        
                 

## **Introdução a linguagem**
    
       
Criada por alunos de Ciência da computação da Universidade Federal da Fronteira Sul. Morpheus é uma linguagem com sintaxe flexível, podendo o usuário utilizar o espaçamento e a endentação desejada.
É possível declarar variáveis, atribuir valores a variáveis, usar laços dentro de laços, dar comandos de entrada e saídas para o usuário, usar vetores e criar funções com escopo.
É necessário utilizar ; (ponto e vírgula) no final de cada linha. No caso de funções, laços e condicionais, o uso no início não é necessário. nesses casos utilizasse {} (chaves).
    
      

### **1. Comentários**
       
Para fazer comentários no Morpheus utiliza-se // (duas barras juntas) no início da linha. Desse modo, tudo que tiver escrito depois dela não será executado pelo interpretador.  
     
         
*Exemplo:*
```
	//linha de teste que não será executada
  
	//print ("io")
	print("oi")
	
	tela:
	 oi
```
     
         
### **2. Tipos e operadores**
    
        
                         **Tipos de variáveis**

|**Tipo** |    **Descrição**         | Exemplo     |
|---------|--------------------------|-------------|
|  int    | Inteiro de 32 bits       |  -1,0,1     |
| double  |Número com ponto flutuante|-0.59        |
|bool     |Booleano                  | true, false |
|string   |Sequência de caracteres   |“Hello World”|
|char     |Caractere único           |'z'          |

    
       
                         **Sinais Aritiméticos**


|**Operador**|**Operação** |
|------------|-------------|
|			+      | Adição      |
|			-			 | Subtração   |
|			/			 | Divisão     |
|			*			 | Multplicação|
|			%			 | Resto       |

    
       
                         **Sinais de comparações (condições)**

| **Sinal** |      **Ação**    							 |
|-----------|--------------------------------|
|			==		|Comparação de valores iguais    |
|			!=		|Comparação de valores diferentes|
|			>>		|				Maior										 |
|			>=		|		Maior ou igual							 |
|     <<		|  Menor												 |
|			<=		|  Menor ou igual								 |

       
                         **Sinais Utilizados**

|**Sinal**|**Função**         |
|---------|-------------------|
|//				|Comentário         |
| = 			|Atribuição de Valor|



      
          
### **3.Declarar variáveis**

A declaração de variáveis funciona na ordem “tipo nome = valor;”, ou seja, primeiro deve ser escrito o tipo dela, seu nome (é obrigatório uma variável de nome) e o valor a ser iniciado.
As variáveis também podem ser declaradas sem nenhuma atribuição de valor.
```          
					       tipo variável = valor
```

Se nenhum valor for atribuído a variável iniciará com


|Valores iniciais|	      |             |
|----------------|------------|-------------|
|int = 0         |double = 0.0|string = null|
|bool = false    |char = ' '  |             |

     
        
*Certos nomes não podem ser usados como nome de variável pois eles são reservados para o sistema. 


*Exemplo de declaração de variável:*

```          
	Int numero = 10;
	double valor = 10.25;

	char a;
	a = ‘a’; 

	string frase;
	frase = “hello world”;
```

### **4.Usando expressões**
    
       
No Morpheus realiza operações com números, variáveis e vetores.
*as operaçoes podem ser feitas com tipos diferente de primitivos, ex.: int e double

*Cada expressão deve ficar entre () (parênteses) 
 
```		
					Variável = (((x+2) *0.5) + [3] vetor)
```

    
       
### **5.Comandos de entrada**
    
      
O comando input () pode ser utilizado para adquirir um valor de entrada digitado pelo usuário.

```
					input (variável)
					input (“frase”, variável)	
```

*Pode-se utilizar frases dentro do input que aparecerá para o usuário.

*Exemplo:*
```
	int numero;	
	input(numero); 

	//com frase

	string nome;
	input (“digite seu nome”, nome);
```
        
	      
### **6.Comandos de saída**
      
            
Usar o comando print () gera uma saída permite o usuário visualizar na tela.
```
					print ()  //*pode utilizar para pular linha
					print (“string”=>variável=>[]vetor)
```
Exemplo:
```
	print (“Morpheus”);

	No terminal aparecerá:
	Morpheus
```
*Para utilizar variáveis utiliza-se o =>

```
	print(“nome ”=>a=>”sobrenome”=>b); 
	print(“idade “=>c);

	No terminal aparecerá:
	nome Morpheus Language 
	idade 1
```
      
            
### **7.Usando condicionais** 
      
          
Ao usar condicionais usamos {} (chaves) que estiver entre chaves será executado. No Morpheus as condicionais podem ser usadas com aninhamento (if dentro de ifs).
Condição: As condições é o que define se o if será executado, ao usar uma comparação é necessário definir seu tipo. As condições podem ser int, double, string, bool, vetor.
*Operações matemáticas não podem ser usadas como condição

if: O código entre as chaves é executado apenas se a condição comparada for **VERDADEIRA**.

```
				if tipo da condição | condição {Instruções para condição verdadeira}
```
Exemplo: 
```
	int a = 10;
	int b = 10;

	if int a == b
	{
		print (“A é igual a B”);
	}

	Saída no terminal:
	A é igual a B
```


else:Se a condição do if for falsa o else será acionado, executando o código que está entre as {} (chaves).

*Não é possível haver mais do que um else para cada if.  
*O else deve ser colocado após com a chave de fechamento do seu respectivo if.

```
					}else {Instruções se os ifs forem falsos}
```
```
	int a = 10;
	int b = 5;

	if int | a <= b
	{
		print (“menor ou igual”);
		if int | a = b  
		{
	        	print (“if dentro de if”);
		}
	}else 
	{
	       print (“nenhum dos ifs”); 
	}
```
      
            
### **8.laços de repetição**
      
            


No Morpheus o while () é utilizado para laços, rodando ciclos de repetição no código dentro das {} (chaves) enquanto a condição dentro dos parênteses for verdadeira.
Assim como no if ao utilizar uma variável como condição de parada deve-se colocar o tipo | variável em seguida a condição.
* Uma condição de parada é importante para que o while não execute para sempre e/ou utilize toda a memória do sistema no qual está sendo executado.


```
					while tipo | condição {código do loop}
```

*Exemplo:* 
```
	int a = 0;

	while int |a << 3
	{
		print (a);
		a=(a+1);
	} 
	
	Saída no terminal:
	0
	1
	2

```
      
          
### **9. Vetores**
      
          
Vetores são atribuídos com [] (colchetes) um vetor poder ter vários valores dentro dele e podem ser acessados pelo índice.
Para criar um vetor, a seguinte expressão é utilizada:  
```
			       vetor tipo do vetor | [quantidade de posições] variável do vetor.
```
*Exemplo:*
```
	vetor int | [3] numeros;

	//Atribuir valores: 
	[0] numeros =10; 
	[1] numeros = 20;
	[2] numeros = 30;
	
	
	//vetor de booleano 
	
	vetor bool | [2] boleanos;
	[0] boleanos  = true;
	[1] boleano = false;
	
	
	if  bool | [0]boleanos
	{
		print ("\o/ vetor de booleanos");	
	}
```

*Pode-se usar, modificar, acrescentar quaisquer valores do tipo do vetor pelos índices.
 

    
        
### **10.Funçoes** 
      
          
O Morpheus reconhece como funções o código feito com a seguinte sintaxe:
```
					def variável (escopo) {código return valor;}
					variável = call variável da função (escopo);
```
**Escopo:** ter o escopo preenchido não é obrigatório, para utilizá-lo deve-se escrever o tipo e uma variável, pode-se usar quantos valores quiser no escopo, os valores recebidos no escopo da função poderão ser usados na função.

**Return:** O uso de return na função é obrigatório, porém é flexível e pode retornar qualquer tipo de variável, não necessitando uma atribuição fixa.
*A função deve ser escrita antes de sua chamada

```
	def soma (int y,int x) 
	{ 
		int total; 
		total= (y+x); 
		return total;
	}
	
	int a = 5; 
	int b = 2; 
	
	b = call soma(a,b); 
	print(b);

```
