# Course LPI 

## Part 1 - Evolution and Distributions

### Componentes
- Kernel: coração do Linux (https://www.kernel.org/)
- Bibliotecas
- Utilitários (programas)
- User Interface: Microfone, camera, monitor, terminal, mouse, etc.


### Links 
Richard Stallman criou a licença GPL (https://en.wikipedia.org/wiki/GNU_General_Public_License)
Link prova Certificação Linux: http://www.lpi.org/our-certifications/exam-010-objectives/
Lista de Distribuições: https://en.wikipedia.org/wiki/Comparison_of_Linux_distributions

### Instalando o Ubuntu:
* http://www.ubuntu.com/

### Instalando VirtualBox:
* https://www.virtualbox.org/


### Programas
```
LibreOffice
ThunderBird
Gimp
IbnkScape
Blender
Audacity
Vlc
```

### Servidores
``` 
NFS (Network File System) = Protocolo de comunicação utilizado para compartilhamento de arquivos, muito
utilizando em Unix e Linux.
Samba = Programa utilizado no Windows para compartilhamento de arquivos em servidores Unix e Linux.
Cups = Servidor de impressão Linu, suporta Windows.
Postfix = Servidor de e-mail Linux.
OpenLDAP (implementação do LDAP) = Servidor de réplica de dados
Bind = Servidores de nomes de dominios DNS (Domain Name Server)
Dnsmasq = Servidor de IP (DHCP Server)
Nginx ou Apache = Servidor Web
``` 

### Debian
``` 
Pacotes com extensão .deb podem ser instalados via comando: 
dpkg -i mysql-client_5.6.30-0ubuntu0.15.10.1_all.deb (Melhor utilizar o apt-get ao invés do dpkg)
Lista todos os pacotes da maquina: dpkg --list
``` 

### Fedora (https://getfedora.org/)
``` 
Suportam pacotes do tipo rpm.
Gerenciador de pacotes: yum (antigo) / dnf(novo)
Comando para listar pacotes instalados: rpm --query --all ou rpm -qa
Comando para instalar um pacote: sudo rpm -i lynx-2.8.9-0.8.dev5.fc23.x86_64.rpm
Comando para remover um pacote: sudo rpm -e lynx
Comando para procurar um pacote: yum search mariadb (antigo mysql)
Comando para verificar informações detalhadas do pacote: yum info mariadb-server
Manual rpm: man rpm
``` 

### CentoOS (https://www.centos.org/ )
``` 
Instalando um pacote: $ sudo yum install lynx
Configurando a placa de rede ethernet: execute nmcli d, depois nmtui, e por fim systemctl restart network
Testando a rede: ping www.google.com
``` 


## Part 2 - Open Source Software and Licensing

###Licenses
```
GPL (Escrita por Richar Stallman) - Pode ser utilizado/reescrito porém sempre será GPL

BSD - Pode ser utilizado/reescrito e pode ter o tipo da licença modificado

Apache - Parecido com a BSD

Mozilla Public License - Parecido com GPL e BSD

FOSS e FLOSS não são especificamente licenças, mas termos utilizados para os softwares que são livres e open source (Free/Libre and Open Source Software).

Licença CC BY (Creative Commons)- Com eta licença podemos distribuir, remixar, adaptar e criar variações, mesmo para fins comerciais, desde
que a atribuição do crédito pela criação original esteja inclusa. O artista abdcou-se de ganhar royalties, de vender a criação
como produto, mas o autor se deseja tornar reconhecido.
Domínio Público - Significa que a obra não tem mais uma copyright de um indivíduo ou instituição determinada. Por lei, tudo tem copyright, ou seja, os direitos intelectuais pertencem a alguém. Depois de um determinado período de tempo, o conteúdo cai em domínio público e qualquer um pode utilizá-lo, sem pagar pelos direitos autorais. Quantos anos demora para que isto aconteça? A resposta depende da lei de cada país e do tipo de obra ou criação. Em geral existe uma regra (o que não significa que ela não está propensa a mudanças): atualmente, obras datadas de até 1930, por exemplo livros e fotos, estão em domínio público. Criações anteriores a esta data ainda não estão em domínio público e têm os direitos intelectuais preservados.

Licença CC BY-NC (NC = NonCommercial) significa que podemos distribuir e adpatar uma obra, para fins não comerciais e desde que o crédito seja devidamente atribuído para o autor.

Dual-Licensing: Permite utilizar duas licenças diferentes (uma opne-source e outra não), exemplo: Framework VRaptor, MYSQL ferramentas
Free, mas existem empresas que disponibilizam treinamentos e certificados e cobram por tais

Selling of branded merchandise: Vendem produtos (camisetas, canecas), há a opção de criarmos produtos físicos, merchandising, etiquetas, adesivos, cadernos com o logotipo, ou que estejam de alguma maneira relacionados com a marca

Selling of certificates and trademark use: Se você quiser citar a utilização de um produto para demonstrar a boa base de um projeto, precisará conhecer a licença de uso do autor. Algumas pessoas irão lançar um licença que diz "vocês vão lançar meu código mas não podem falar que ele está sendo usado. Para poder citá-lo, é preciso pagar". Se o produto tem fama no mercado por sua qualidade, pode ser interessante citá-lo, mas este é outro modelo.

Saas (Software as a service): Estou pagando para que o software esteja disponível já configurado, que é uma preocupação a menos. É uma abordagem comum, e o MySQL é um exemplo dentre os disponíveis no mercado.

Partnership with funding organizations: que funciona a partir de parceria com organizações que irão pagar pelo seu projeto. 
Mas este é um produto que depende de grande sucesso.

Voluntary donations possui projetos open source que se mantêm com doações.

Bounty driven development, um desenvolvimento baseado em "prêmio" (bounty), em que se recebe uma recompensa por desenvolver em código aberto.

Crowdfunding: Digo que vou desenvolver uma ferramenta que suporte todos os boletos de todos os bancos do Brasil. Para isto coleto doações e, dependendo da quantia que cada pessoa oferecer, darei algo em retribuição. Por exemplo, a pessoa que doar R$1 receberá um "parabéns!", quem doar R$5 receberá um adesivo do projeto, quem doar R$100, uma funcionalidade a mais, e quem oferecer R$500 ganhará suporte por um ano. Com isto, gero comoção no mercado, as pessoas mobilizarão uma quantia - talvez dê certo ou não - e com a verba criarei meu projeto open source. Em geral, a arrecadação é feita antes da criação do projeto, porém o dinheiro pode estar sendo arrecadado para modificar um código aberto já existente.

Advertising-supported software: Softwares com propagandas.

Advertising-supported software: Desenvolve-se um software livre sob determinada licença, e as pessoas podem usá-lo. Caso elas queiram certas extensões, terão que pagar por elas
```

### Cloud
```
https://registro.br/
https://wordpress.org/
https://dnsimple.com/
https://www.locaweb.com.br/
https://br.godaddy.com/
https://pt.wikipedia.org/wiki/Computa%C3%A7%C3%A3o_em_nuvem
https://aws.amazon.com/pt/free/?sc_channel=PS&sc_campaign=acquisition_BR&sc_publisher=google&sc_medium=english_cloud_computing_hv_b&sc_content=aws_cloud_e&sc_detail=amazon%20cloud&sc_category=cloud_computing&sc_segment=89108831308&sc_matchtype=e&sc_country=BR&s_kwcid=AL!4422!3!89108831308!e!!g!!amazon%20cloud&ef_id=Vyo8jQAABEV16-GY:20160504181645:s

```

## Part 3 - Command Line Basics

### Command Line Basics
``` 
Apt (Advanced Packaging Tool)
Busca por um pacote: apt-cache search gcc
Instala um pacote: apt-get install gcc
Remove um pacote: apt-get remove gcc
Consulta comandos apt: man apt-get
Atualiza a lista de pacotes: sudo apt-get update
Atualizando pacotes especificos: sudo apt-get install ffmpeg / sudo apt-get install --only-upgrade ffmpeg 
Corrigindo dependências: sudo apt-get -f install

Diretório de pacotes Ubuntu: http://packages.ubuntu.com

Arquivo sourcess.list
Diretório: /etc/apt/sources.list
Comando para ler o conteudo: cat /etc/apt/sources.list

pwd: descobre o diretório atual  

date: fornece a data e o horário, inclusive com o time zone,o BRT, Brazilian Time
```

### Shell
```
Shell: É um interpretador capaz de receber comandos e traduzi-los para tarefas que o sistema irá executar. Bash é o tipo mais
comum de Shell.

Bash: https://en.wikipedia.org/wiki/Bash_%28Unix_shell

ls: lista arquivos 

echo: devolve coisas, exemplo: echo Bruno -> Bruno

type: verifica se o comando digitado é um programa/comando: 
  type ls -> ls is aliased to `ls --color=auto``
  type echo -> echo is a shell builtin (interno do shell).
  type zip -> zip is hashed (/usr/bin/zip)

type if: é uma palavra chave do shell, podemos executar, ainda, um type -t ife ele mostrará apenas a palavra keyword

Executando o comando no terminal: echo Bruno, bem vindo!
Saida: Bruno, bem vindo!

Criando variaveis no shell: idade=36 (nome da variavel não pode ter espaços depois do símbolo de =)
Executando o comando no terminal: echo Bruno tem $idade anos!
Saida: Bruno tem 36 anos!

O comando export exporta uma variavel para o ambiente:
echo $nome
Bruno
echo $idade
36
export nome
export idade
bash mostra_idadeexport nome

Comando para mostrar as varíaveis de ambiente: env

Commando para fazer com que a variável nome passe a ser apenas uma variável local do shell: export -n nome

A variável que armazena a configuração do prompt de comandos é a variável PS1. 


http://bashrcgenerator.com/

A variável de ambiente que é utilizada pelo Linux para buscar os executáveis quando executamos um comando no shell: PATH

Adicionando um diretório no PATH: PATH=$PATH:/home/bruno

Comando para descobrir qual o caminho do executável que será executado ao executarmos um comando: $ which zip

Para descobrir o exit status do último comando que foi executado no shell basta fazer: $ echo $?

Código de retorno de um programa que foi executado com sucesso: 0 (ZERO)

Comando para listar todos os arquivos com extensão *.txt de um diretóriio: ls *.txt

Executando echo \* Bem vindo \*. a saida será: * Bem vindo *
, pois o caractere \ escapa o "*"

Para executar dois comandos em sequência, podemos utilizar o ; (ponto e vírgula).Os comandos serão executados independente do resultado do anterior. Exemplo:

$ comando_qualquer ; echo "Bom dia"
comando_qualquer: command not found
Bom dia

```

## Part 4 - Using the command line to get help

### Help
```
O comando help mostra ajuda para os comandos integrados (builtin) do Shell

Ex.: help pwd

Para comandos que não são integrados (builtin) ao shell.

Ex.: ls --help

Alguns comandos podem fornecer a opção -h e -? como atalhos para o --help, mas, como no caso do ls, os atalhos nem sempre funcionam.

$ ls --help
# mostra ajuda

$ ls -h
# apresenta comportamento inesperado

$ ls -?
ls: invalid option -- '?'
Try 'ls --help' for more information.
```
### Man
```
http://linuxcommand.org/man_pages/ls1.html

Comando para acessar o manual do comando ls:
Ex.: man ls

Para realizar uma busca dentro de um manual basta utilizar a /(barra), e em seguida digitar o termo da pesquisa.
Ex.: /-l + ENTER

Para navegar entre as ocorrências devemos pressionar a tecla "n".

Para realizar buscas nos nomes das páginas de manual e em suas descrições utilizamos:
Ex.: $ man -k compiler
```

### Info e o tex
```
Ex.: $ info echo

O info utiliza o editor emacs para exibir suas páginas.
```

### HOWTOs
```
http://www.tldp.org/

Os HOWTOs geralmente trazem formas de como fazer determinadas atividades que nem sempre se restringem a um único comando. Os HOWTOs vão funcionar como guias, com os quais poderemos resolver alguns problemas do dia a dia.

Diretório onde encontram-se a documentação de diversas coisas.
ls /usr/share/doc
```

### Localizando arquivos com o locate
```
Locate: comando utilizado para localizar arquivos 

Comando para atualizar a base de dados onde o locate procura os arquivos: $ sudo updatedb

Comando "$ locate -e" só retorna os arquivos que existem no momento em que o comando foi executado.
```

## Part 5 - Directories and Listing Files and managing files

```
Representação do diretório raiz no Linux: /

Linux é case sensite em relação aos nomes dos arquivos e diretórios, - bem como em relação ao que é feito no shell (LS, por exemplo, não funciona) - é possível criar os dois arquivos citados no mesmo diretório. Se apenas um letra fosse maiúscula já seria possível.

Caminho absoluto: 
começam com /, indicando que estamos iniciando na raiz. Um exemplo de caminho absoluto seria /home/lucas/curriculo.txt.

Caminho relativo: 
Indicam que estamos iniciando no diretório atual,ou seja, o caminho é relativo ao diretório atual. Um Exemplo de caminho relativo seria Documents/curriculo.txt.

Diretório atual é representado por .(ponto)

O caractere ~ (til) representa o diretório pessoal do usuário.

Comando "$ ls -laSr" lista os arquivos com informações detalhadas, incluindo ocultos, ordenados pelo tamanho, do menor para o maior.

Comando "mkdir" cria um diretório
Comando "mkdir -p" cria e garante que todos os demais diretórios irão existir.
Exe.: $ mkdir -p curriculos/2013/janeiro
Exe.: $ mkdir -p ferias/201{3,4,5}/{julho,dezembro}

Comando "rmdir" remove apenas diretórios vazios

Comando para excluir esses três diretórios de uma só vez (desde que estejam vazios).
Exe.: $ rmdir -p curriculos/2015/trimestre01/

Comando "touch" altera a data de modificação de um arquivo para a data e hora atuais do sistema. O conteúdo do arquivo em si não é modificado, é como se apenas "tocássemos" no arquivo. Caso o arquivo não exista, o comportamento padrão é criar o arquivo.

Comando "rm" remove diretórios por padrão, o comando "rm -r" removerá o diretório com seus arquivos e subdiretórios.
```

## Part 6 -Archiving Files on the Command Line


### TAR
```
Arquivar com o tar vamos utilizar as seguintes opções:

-c: indica que estamos criando um novo arquivo
-v: verbose, para exibir detalhes sobre o que o comando está fazendo
-f: para indicarmos o arquivo que desejamos criar

Considerando que estamos no diretório loja, e que possui apenas os três arquivos citados anteriormente, para evitar problemas futuros, vamos criar o arquivo .tar no diretório anterior:

$ tar -cvf ../loja.tar *
bemvindo2.html
bemvindo.html
contato.html
Quando utilizamos o -v podemos ver quais arquivos estão sendo incluídos no arquivo criado.

Outra opção seria, considerando que o diretório loja está dentro do diretório atual, arquivarmos o diretório loja:

$ tar -cvf loja.tar loja/
O arquivo final pode ficar maior que a soma dos tamanhos dos arquivos que incluímos:

$ ls -l loja.tar loja/
-rw-rw-r-- 1 lucas lucas 10240 Jul 22 11:21 loja.tar

loja/:
total 8
-rw-rw-r-- 1 lucas lucas 41 Jul 22 10:21 bemvindo2.html
-rw-rw-r-- 1 lucas lucas 45 Jul 22 10:51 bemvindo.html
-rw-rw-r-- 1 lucas lucas  0 Jul 22 10:19 contato.html
Isso ocorre porque o tar mantem dados como permissões dos arquivos e datas de modificação.

Para listar os arquivos utilizamos a opção -t do comando tar. Como sempre devemos utilizar o -f para indicar qual é o arquivo.

$ tar -tf loja.tar 
bemvindo2.html
bemvindo.html
contato.html
Podemos também combinar o-t com o -v (verbose) e obter uma lista ainda mais detalhada.

Lembre-se que o tar arquiva mantendo as permissões dos arquivos e datas de acesso:

$ tar -tvf loja.tar 
-rw-rw-r-- lucas/lucas      41 2016-07-22 10:21 bemvindo2.html
-rw-rw-r-- lucas/lucas      45 2016-07-22 10:51 bemvindo.html
-rw-rw-r-- lucas/lucas       0 2016-07-22 10:19 contato.html


Para extrair os arquivos do .tar:
$ tar -xvf loja.tar

Para adicionar arquivos ao tar criado:
$ tar -uvf ../loja.tar *

Listando para ver a mudança:
$ tar -tf ../loja.tar
bemvindo2.html
bemvindo.html
contato.html
bemvindo.html

Para descompactar um arquivo comprimido com gzip:
$ tar -xvzf loja.tar.gz 

Para descompactar um arquivo comprimido com bzip2:
$ tar -xvjf loja.tar.bz

```

### FIND
```
Comando utilizado para encontrar algo, exemplo para encontrar arquivos que comecem com log no dir atual:
$ find -name "log*"

Buscando apenas pelos links simbólicos no diretório /etc e que contenham a palavra "language" em qualquer parte do seu nome:
$ find /etc -type l -name "*language*"

Encontrando os arquivos que contém "log" ou "2016" em qualquer parte do nome. E que, além disso, foram acessados na última semana:
$ find -name "*log*" -o -name "*2016*" -atime -7

Utilize o find para buscar todos os arquivos que tem em seu nome as palavras "log" e "2016" e em seguida crie um zip com esses arquivos:
$ find -name "*log*" -name "*2016*" | zip -@ logs.zip

```

## Part 7 -  Searching and Extracting Data from Files

## WC
```
O wc (word count) exibe o número de linhas, o número de palavras e o número de bytes que um arquivo possui: 

$ wc post-do-blog.txt 
 110  851 5517 post-do-blog.txt

Imprimindo a qtde. de caracteres mais longa do arquivo:
$ wc -wlL post-do-blog.txt

Imprimindo a quantidade de palavras, temos o -w, e para a quantidade de linhas o -l:
$ wc -wlL post-do-blog.txt 
 110  851  341 post-do-blog.txt

Imprimindo os contadores em uma ordem pré-definida:
$ wc -Llw post-do-blog.txt 
110  851  341 post-do-blog.txt
```

## MORE and LESS
```
Comando utilizado para navegar no arquivo
MORE -> ENTER: para avançar uma linha no arquivo.
MORE -> Barra de espaços: para navegar entre as páginas
MORE -> Tecla b: para voltar as páginas
```

## CAT
```
Comando utilizado para concatenar arquivos

Exemplo concatenando 2 arquivos  e salvando em outro arquivo:
$ cat post-do-blog.txt programa.c > arquivos-concatenados.txt

Adicionando o texto "Operação concluida com sucesso" no arquivo criado anteriormente:
$ echo "Operação concluída com sucesso" >> arquivos-concatenados.txt
```

## CUT and SORT
```
O comando cut no arquivo /etc/passwd para exibir o nome dos usuários e seus diretórios home, separados por ponto e vírgula:
$ cut -f 1,6 -d: --output-delimiter=";" /etc/passwd

Para ordenar, basta utilizar o sort. Podemos combinar todas essas saídas utilizando o | (pipe):
$ cut -f 1 -d: /etc/passwd | sort | less
```

## GREP 
```
Para buscar por ocorrências de um termo em um arquivo com o grep é muito simples:
$ grep palavra_a_ser_encontrada arquivo

O grep leva em considerações maiúsculas e minúsculas. Então se buscarmos por "alura" e no texto existir "Alura", a palavra não será encontrada. Para ignorar isso (ignorar o case), utilizamos a opção -i:
$ grep -n -i alura post-do-blog.txt
```
