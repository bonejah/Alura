Course Alura - REGEX

META CHARS
. o "ponto" que significa qualquer char
* o asterisco que serve para definir uma quantidade de chars, zero ou mais vezes
{e } as chaves que servem para definir uma quantidade de caracteres específicas que é desejado encontrar
? caracter opcional
[.-]* - ponto ou hífen zero, uma ou mais vezes.
[.-]{1} - ponto ou hífen uma vez.
[.-]?- ponto ou hífen zero ou uma vez
\s significa whitespace
? - zero ou uma vez.
* - zero ou mais vezes.
+ - uma ou mais vezes.
{n} - exatamente n vezes.
{n,} - no mínimo n vezes.
{n,m} - no mínimo n vezes, no máximo m vezes.
[A-Z] significa de A até Z, sempre maiúscula.
[a-z] significa de a até z, sempre minúscula,
[A-Za-z] significa A-Z ou a-z.
[abc] significa a, b ou c.


Expressão regular:
CPF => \d{3}\.\d{3}\.\d{3}\-\d{2}
CNPJ => \d{2}\.\d{3}\.\d{3}/\d{4}-\d{2}
CEP => \d{5}\-\d{3}
TELEFONE => \(\d{2}\) \d{4}\-\d{4}
19h32min16s => \d{2}h\d{2}min\d{2}s ou [0-9]{2}h[0-9]{2}min[0-9]{2}s
KMG-8089 => [A-Z]{3}-\d{4} ou [A-Z]{3}-[0-9]{4}

Pega notas maiores que 7.2 até 7.9
9.8 - Robson, 7.1 - Teresa, 4.5 - Armênio, 6.5 - Zulu, 7.7 - Stefania, 7.8, 5.0 - Romeu, 7.2 - Pompilho, 3.1 - Reinaldo, 7.3 - Bernadete, 4.7 - Cinério => 7\.[2-9]\s+-\s+\w+

Pega notas até média 8
10 - Bruce, 9.5 - Miranda, 7.9    - Bob, 10 - Zimbabue, 7.5 - Bety => [7]\.[5-9]\s+-\s+\w+



Find <code> or </code> : Use </?code>
Find 1 a 3 e 6 a 9: Use [1-36-9]
