// Casos de Teste:

// Olá Mundo
print("Ola mundo!");

// Declarações e atribuições
int a;
a = 2;
print(a);

// Laço
int i;
i = 0;
while int|i<<10
{
  print(i);
  i=(i+1);
}

// Expressões
int a;
int b;
a =  (1  + 1);
b =  (3  + a);
print(a);
print(b);

// Ifs
int a;
a = 1;
if int|a>>1
{
  print("Maior");
}else{
  print("Menor");
}

// Aninhamento
//int i;
int j;
i = 0;
j = i;
while int|i<<3
{
  if int|i == 0
  {
    print("Zero");
  }else
  {
    print("Outro");
  }

  i=(i+1);
}

if int|i == 3
{
  if int|j == 0
  {
    print("Ok!");
  }else
  {
    print("Erro");
  }
}




vetor int|[10]vetorInt;
vetor int|[10]vetorInt2;
vetor string|[10]vetorStr;
vetor string|[10]vetorStr2;
vetor char|[10]vetorchar;
vetor bool|[12]vetorbool;
vetor double|[10]vetordouble;

[5]vetorInt = 78;
[6]vetorInt = 79;
[2]vetorInt2 = 78;
[6]vetorInt2 = 76;
[9]vetorStr = "nine";
[8]vetorStr2 = "nines";
[1]vetorchar = 'x';

int test = 2;
int b = 0;

def fuc(int t,int base)
{
    int x = 1;
    while int|x<<base
    {
        t = (t*2);
        x = (x+1);
    }
    return t;
}
input("2 em qual base: ",[2]vetorInt);
test = call fuc(test,[2]vetorInt);
print("2 **"=>[2]vetorInt=>" é: "=>test);
