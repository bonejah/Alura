# Course Alura - REGEX

## Links
* http://regexr.com/
* https://regex101.com/

## META CHARS
* . o "ponto" que significa qualquer char
* * o asterisco que serve para definir uma quantidade de chars, zero ou mais vezes
* {e } as chaves que servem para definir uma quantidade de caracteres específicas que é desejado encontrar
* ? caracter opcional
* [.-]* - ponto ou hífen zero, uma ou mais vezes.
* [.-]{1} - ponto ou hífen uma vez.
* [.-]?- ponto ou hífen zero ou uma vez
* \s significa whitespace
* ? - zero ou uma vez.
* * - zero ou mais vezes.
* + - uma ou mais vezes.
* {n} - exatamente n vezes.
* {n,} - no mínimo n vezes.
* {n,m} - no mínimo n vezes, no máximo m vezes.
* [A-Z] significa de A até Z, sempre maiúscula.
* [a-z] significa de a até z, sempre minúscula,
* [A-Za-z] significa A-Z ou a-z.
* [abc] significa a, b ou c.
* (^) significa negação dentro dos colchetes
* \s significa whitespace e é um atalho para [ \t\r\n\f]
* \w significa word char e é uma atalho para [A-Za-z0-9_]
* \b (word boundary) para selecionar a posição antes ou depois de uma palavra.
* \B (non-word-boundary) inverso do de cima.
* ^ - é uma âncora que seleciona o início da string alvo.
* $ - é uma âncora que seleciona o fim do alvo
* Declaramos um grupo com ()
* Através do ?; dizemos que não queremos ver esse grupo na resposta


## Expressão regular:
* CPF => \d{3}\.\d{3}\.\d{3}\-\d{2}
* CNPJ => \d{2}\.\d{3}\.\d{3}/\d{4}-\d{2}
* CEP => \d{5}\-\d{3}
* TELEFONE => \(\d{2}\) \d{4}\-\d{4}
* 19h32min16s => \d{2}h\d{2}min\d{2}s ou [0-9]{2}h[0-9]{2}min[0-9]{2}s
* KMG-8089 => [A-Z]{3}-\d{4} ou [A-Z]{3}-[0-9]{4}

## Pega notas maiores que 7.2 até 7.9
* 9.8 - Robson, 7.1 - Teresa, 4.5 - Armênio, 6.5 - Zulu, 7.7 - Stefania, 7.8, 5.0 - Romeu, 7.2 - Pompilho, 3.1 - Reinaldo, 7.3 - Bernadete, 4.7 - Cinério => 7\.[2-9]\s+-\s+\w+

## Pega notas até média 8
* 10 - Bruce, 9.5 - Miranda, 7.9 - Bob, 10 - Zimbabue, 7.5 - Bety => [7]\.[5-9]\s+-\s+\w+

* BALEIRO GARROTE SERROTE GOLEIRO ROTEIRO => [A-Z]*ROT[A-Z]+

* ?classes+poderosas* => [a-z?*+]+

* Expressao para data => [0123]?\d\s+de\s+[A-Z][a-zç]{1,8}\s+de\s+[12]\d{3}
* var DIA  = "[0123]?\d"; 
* var _DE_ = "\s+de\s+";
* var MES  = "[A-Za-z][a-zç]{1,8}";
* var ANO  = "[12]\d{3}";
* var stringRegex = DIA + _DE_ +  MES + _DE_ + ANO;
* var objetoRegex  = new RegExp(stringRegex, 'g');

* Find <code> or </code> : Use </?code>
* Find 1 a 3 e 6 a 9: Use [1-36-9]

* Selecionando somente a palavra "de" no texto abaixo
```
denise teste, 987.654.321-00,28 de Dezembro de 1991,(31)45562712,SCS Qd. 8 Bl. B-50,11,70333-900,Rio Grande
Regex: 
    - \sde\s (Este seleciona os espaços também)
    - \bde\b (Este seleciona somente a palavra "de")
```

* Selecionado somente a sequencia com 3 "a"
```
aaa aaaa aaa aaaa aaa
Regex: 
    - a{3} (Este seleciona 3 "a" no inicio de cada palavra)
    - a{3}\b (Este seleciona 3 "a" no final de cada palavra)
    - \ba{3}\b (Este seleciona somente as palavras que contem 3 "a")
```

* Avaliando o caminho de uma arquivo
```
file:///Users/nico/Downloads/regex/index.html
Regex:
    - ^file.+html$ (Garante que nada vem antes e depois do texto)
```

* Capturando o text0 "Caused by"
```
Caused by: com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure
Regex:
    - ^Caused.+by:.
```

* Capturando Data: 02/09/1964 ou Data:02/09/1964
```
Regex:
    - ^Data:[\s]?[0-9]{2}\/[0-9]{2}\/[1-9]{4}$

```

* Adivinhando msg secreta 
```
Z171PZ7AZ23PZ7819AZ78GZ1AZ99IZ34O
Regex: 
    - Z\d+(\w)
    - Selecione a opção "Mostrar grupos" da pagina index.html
    - [^Z\d]
```

* Separando a mensagem de erro abaixo:
```
Caused by: com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure
Regex: 
    - Caused[\s\w:.-]+:[\w\s]+ (Seleciona a excecao por completo)
    - (Caused[\s\w:.-]+):([\w\s]+) (Divide a excecao em dois grupos)
```

* Filtro de emails:
```
super.mario@caelum.com.br extrai super.mario
donkey.kong@alura.com.br extrai donkey.kong
bowser1@alura.com.br extrai bowser1
Regex: 
    - ([a-z.]{4,14}[a-z\d])@(?:caelum.com.br|alura.com.br)
    - ^([\w-]\.?)+@([\w-]+\.)+([A-Za-z]{2,4})+$ (Valida qualquer email)
```

* Extraindo conteudo do H1
```
<h1 class="text-left">Expressões regulares</h1>
Regex:
    - <h1.+> (Seleciona todo o conteudo)
    - <h1.+?> (Seleciona somente a 1ª parte da tag H1)
    - <h1.+?>([\w\sõãí.]+) (Selection a 1ª parter da tag H1 e mais o conteudo)
    - <h1.+?>([\w\sõãí.]+)</h1> (Seleciona todo o conteudo)
    

<h1 id="regex" class="form">Expressões regulares não são tão difíceis.</h2>
Regex:
    - <(h1|h2).+?>([\w\sõãí.]+)</(h1|h2)> (Funciona porem temos que validar as tags de abertura e fechamento).
    - <(h1|h2).+?>([\w\sõãí.]+)<\/\1> (Esta regex valida as tags de abertura e fechamento)
```

*  Exemplo Javascritp usando Regex:
```
    var target = "11a22b33c";
    var exp = new RegExp('(\\d\\d)(\\w)', 'g');
    exp.test(target);
    exp.exec(target);
    Resultado: ["11a", "11", "a"]

    var anoMesDia = '2007-12-31';
    var exp = /-/g
    anoMesDia = anoMesDia.replace(exp, '/');
    Resultado: '2007/12/31';

    var arquivo = '100,200-150,200;20';
    var valores = arquivo.split(',');
    Resultado: ["100", "200-150", "200;20"]
    var exp = /[,;-]/;
    var valores = arquivo.split(exp);
    Resultado: ["100", "200", "150", "200", "20"]

    var codigos = 'A121B12112C12212F12G01';
    var exp = /[A-Za-z]\d+/g
    var codigosExtraidos = codigos.match(exp);
    Resultado: ["A121", "B12112", "C12212", "F12", "G01"]
```

* Exemplo Java usando Regex:
```
   public class TesteRegex {
        private static Pattern pattern = Pattern.compile("(\\d\\d)(\\w)");

        public static void main(String[] args) {
            Matcher matcher = pattern.matcher("11a22b33c");
            while(matcher.find()) {
                String match = matcher.group();
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);

                int start = matcher.start();
                int end = matcher.end();

                System.out.printf("%s | %s |  %s [%d,%d] %n", match, group1, group2, start, end);
            }
        }
    }
```
