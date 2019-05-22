# **Documentação do Morpheus Language**


### Criadores 
```
Henrique Herrera (https://github.com/henriqueherrera)
Matheus Slama (https://github.com/Lokens)
Pablo Lodi (https://github.com/PabloLodi)
```

## **Usando o Morpheus** 
		                        
1. Você deve possuir o Java Development Kit xxx instalado
2. Escreva o código a ser interpretado no seu editor favorito e salve com a extensão .mp
3. Execute o Interpretador no terminal com o comando: 

		Java -jar Morpheus.jar nomedoarquivo.mp

        
                 

## **Introdução a linguagem**
          
                 

Morpheus é um interpretador compilado utilizando a Java Development Kit xxx e é utilizado no terminal com o comando:  		

```
                                        java Morpheus nomedoarquivo.mp 
```

Morpheus é uma linguagem com sintaxe flexível, podendo o usuário utilizar o espaçamento e a endentação desejada.
É possível declarar variáveis, atribuir valores a variáveis, usar laços dentro de laços, dar comandos de entrada para o usuário, usar vetores e criar funções com escopo.
É necessário utilizar o ; (ponto e vírgula) no final de cada linha. No caso de funções, laços e condicionais, o uso no início não é necessário. nesses casos utilizasse {} (chaves).

```          
```

### **1. Comentários**
       
Para fazer comentários no Morpheus utiliza-se // (duas barras juntas) no início da linha. Desse modo, tudo que tiver escrito depois dela não será executado pelo interpretador.  
```          
```
*Exemplo:*
```
	//linha de teste que não será executada
  
	//print ("io")
	print("oi")
	
	tela:
	 oi
```
```          
```
### **2. Tipos e operadores**
```          
```
                         **Tipos de variáveis**

|**Tipo** |    **Descrição**         | Exemplo     |
|---------|--------------------------|-------------|
|  int    | Inteiro de 32 bits       |  -1,0,1     |
| double  |Número com ponto flutuante|-0.59        |
|bool     |Booleano                  | true, false |
|string   |Sequência de caracteres   |“Hello World”|
|char     |Caractere único           |'z'          |

```          
```
                         **Sinais Aritiméticos**


|**Operador**|**Operação** |
|------------|-------------|
|			+      | Adição      |
|			-			 | Subtração   |
|			/			 | Divisão     |
|			*			 | Multplicação|
|			%			 | Resto       |

```          
```
                         **Sinais de comparações (condições)**

| **Sinal** |      **Ação**    							 |
|-----------|--------------------------------|
|			==		|Comparação de valores iguais    |
|			!=		|Comparação de valores diferentes|
|			>>		|				Maior										 |
|			>=		|		Maior ou igual							 |
|     <<		|  Menor												 |
|			<=		|  Menor ou igual								 |

```          
```
                         **Sinais Utilizados**

|**Sinal**|**Função**         |
|---------|-------------------|
|//				|Comentário         |
| = 			|Atribuição de Valor|



```          
```
### **3.Declarar variáveis**

A declaração de variáveis funciona na ordem “tipo nome = valor”, ou seja, primeiro deve ser escrito o tipo dela, seu nome (é obrigatório uma variável de nome) e o valor a ser iniciado.
As variáveis também podem ser declaradas sem nenhuma atribuição de valor,
```          
				
                                        tipo variável = valor
          
```

Se nenhum valor for atribuído a variável iniciará com


|Valores iniciais|	      |             |
|----------------|------------|-------------|
|int = 0         |double = 0.0|string = null|
|bool = false    |char = ' '  |             |

```          
```
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
```          
```
No Morpheus realiza operações com números, variáveis e vetores.
*as operaçoes podem ser feitas com tipos diferente de primitivos, ex.: int e double

*Cada expressão deve ficar entre () (parênteses) 
 
		
```
                                        Variável = (((x+2) *0.5) + [3] vetor)
```	

```          
```
### **5.Comandos de entrada**
```          
```
O comando input () pode ser utilizado para adquirir um valor de entrada digitado pelo usuário.

```

                                       input (variável)
                                       input (“frase”, variável)

```
*Pode-se utilizar frases dentro do input que aparecerá para o usuário.

*Exemplo:*
```
	Int numero;	
	input(numero); 

	//com frase

	string nome;
	input (“digite seu nome”, nome);
```
```          
```
### **6.Comandos de saída**
```          
```
Usar o comando print () gera uma saída permite o usuário visualizar na tela.
```

                                       print ()
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

```          
```
### **7.Usando condicionais** 
```          
```
Ao usar condicionais usamos {} (chaves) que estiver entre chaves será executado.
As condicionais são usadas igual se usa no Java. 
*As condicionais podem ser usadas com aninhamento (if dentro de ifs)   
*operações matemáticas não podem ser usadas como condição
As condicionais São: 
```

                                       If condição {Instruções para condição verdadeira}

```
Exemplo: 
```
	int a = 10;
	int b = 10;

	if a == b
	{
		print (“A é igual a B”);
	}

	Saída no terminal:
	A é igual a B
```
else if : Essa condição é usada igual ao if, quando há vários comandos if use o else if que só será executado se os outros ifs ou else ifs forem falsos, isso deixa o código mais rápido. 
```          
                                        else If condição {Instruções para condição verdadeira}
          
```

*Exemplo:*

```
	int a = 10;
	int b = 20

	if a == b
	{
		print (“é Igual”);
	}

	else if a != b
	{
		print (“é diferente”);
	}


	Saída no terminal:
	é diferente 

```

else : Usado se a condição if ou a else if não for verdadeira o else será executado.
```

                                        else {Instruções se os ifs e else if forem falsos}

```
```
	int a = 10;
	int b = 5

	if a <= b
	{
		print (“menor ou igual”);
		if a/2 != b  
	{
	print (“if dentro de if”)
	}
	}
	else if b >> a
	{
		print (“b é maior que a”);
	}
	else {
	 print (“nenhum dos ifs”) }
```


```          
```
### **8.laços de repetição**
```          
```


No Morpheus usamos o while (), então enquanto a condição dentro dos parênteses for verdadeira o while ficar fazendo ciclos executando os códigos dentro das {} (chaves). 
*É importante botar uma condição de parada ou o while ficará executando para sempre ou até usa memoria durar.

```
                                       while (condição de parada) {código}
```

*Exemplo:* 
```
	Int a = 0;

	while (a < 3)
	{
		print (a);
		a=(a+1);
	} 
	
	Saída no terminal:
	0
	1
	2

```
```          
```
### **9. Vetores**
```          
```
Vetores são atribuídos com [] (colchetes) um vetor poder ter vários valores dentro dele e podem ser acessados pelo índice.
Para criar um vetor você escreve: 
```

                                       vetor tipo do vetor | [quantidade de posições] variável.

```
*Exemplo:*
```
	vetor int | [3] números 

	//Atribuir valores: 
	[0] números =10; 
	[1] números = 20;
	[2] números = 30;

```

*Pode usar, modificar, acrescentar quaisquer valores do tipo do vetor pelos índices.
 

```          
```
### **10.Funçoes** 
```          
```
No Morpheus usamos funções 
def variável (escopo) {código return valor; },
variável = call variável da função (escopo);

Escopo: ter o escopo preenchido não é obrigatório, para utilizá-lo deve-se escrever o tipo e uma variável, pode-se usar quantos valores quiser no escopo, os valores recebidos no escopo da função poderão ser usados na função.

Return: é obrigatório utilizar o return na função ele pode ser de qualquer tipo.
*deve ser escrita antes de sua chamada

```
	int a= 5; 
	int b=2; 
	def soma (int y,int x) 
	{ 
		int total; 
		total= (y+x); return total;
	}
	b = call soma(a,b); 
	print(b);


```
