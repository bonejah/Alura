# Comandos Linux

* cd Área\ de\ Trabalho
* pwd = Comando para saber em qual diretório vc está.
* ls = lista os arquivos de um diretório
* ls -a
* ls -l
* ls *

* echo = comando utilizado para escrever no terminal
*  - echo "Bem vindo" > bemvindo.txt (escreve a frase Bem vindo no arquivo bemvindo.txt
*  - echo "Bem vindo2" >> bemvindo.txt (adiciona a frase Bem vindo2 no arquivo bemvindo.txt
* man = comando manual do sistema
* cd = muda para determinado diretório
* mkdir = cria um novo diretorio
* rmdir = remove um diretorio (se o mesmo estiver vazio)
* rmdir -r = remove o diretorio e os arquivos que estiverem dentro
* rm = remove arquivo

* cat = comando utilizado para ler um determinado arquivo
*  - cat bemvindo.txt
*  - cat bem*.txt
*  - cat bemvindo?.txt

* head = comando para ler o inicio de um arquivo
*  - head bemvindo.txt
*  - head -n 4 bemvindo.txt

* tail = comando para ler as ultimas linhas de um arquivo
*  - tail google.txt
*  - tail -n 3 google.txt
        
 1583 bonejah   20   0   11136    312      0 S   0,0  0,0   0:00.00 ssh-agent                       
 1586 bonejah   20   0   43596    372     12 S   0,0  0,0   0:00.00 dbus-launch                     
 1587 bonejah   20   0   43688   4096   2856 S   0,0  0,1   0:00.61 dbus-daemon                     
 1599 bonejah   20   0  274536   6384   5620 S   0,0  0,1   0:00.05 gvfsd                           
 1604 bonejah   20   0  419960   7188   6436 S   0,0  0,1   0:00.00 gvfsd-fuse                
* less = navega pelo texto do arquivo
* top = mostra a situacao dos processos
* top -u bruno = mostra somente os processos de uma determinada pessoa
* kill all -9 top / killall top = comando que mata todos os processos com determinado nome

* ps -ef I grep = mostra os processos abertos
* pstress = mostra os processos de uma maneira gráfica
* jobs = visualiza os processos que estao parado/rodando
* gedit & = abre o aplicativo e o coloca-lo em background
* gedit dorme & = cria um arquivo chamado dorme e o coloca em bg
* gedit = abre o aplicativo e trava o bash
* CRTL + Z = pausa o aplicativo aberto
* bg 1 = deixa o aplicativo em background
* fg 1 = deixa o aplicativo em foreground

* sh dorme = executa o arquivo dorme no bash
* chmod +x dorme = coloca a permissao de execucao para o arquivo dorme
* locate = localiza arquivos
* sudo updatedb = atualiza o banco de dados dos nomes dos arquivos

* which = comando utilizado para saber onde estao instalados os arquivos
* Exemplo:
* - - which firefox
* /usr/bin/firefox

* su root = troca para determinado usuario
* sudo passwd = troca a senha do usuario
* sudo [mais alguma coisa] = executa alguma coisa como super usuario 
* adduser + nome do usuario = adiciona um novo usuario no pc
* chmod o-rx nome grupo/usuario/outros = retira a permissao de leitura e escrita do usuario outros 
* env = comando que verifica as variaveis de ambientes 	 	
* PATH=$PATH:/home/bruno/workspace (adicionando o dir workspace no PATH)
* wc = conta o numero de palavras que um arquivo possui
* sudo apt-get update = atualiza lista de pacotes do ubuntu
* apt-cache search ftp = procura determinado programa na lista de pacotes
* sudo apt-get install vsftp = instala o servidor ftp
* apt-get remove vsftp = remove o programa vsftp
* sudo dpkg -i nome do pacote .deb = para instalar um pacote .deb
* sudo dpkg -r nome do programa = para desinstalar o programa
* sudo apt-get -f install = corrige erros de dependencias de pacotes
* ps -ef | grep vsftpd = comando que verifica se o servico do vsftpd está ativo
* sudo service vsftpd stop
* sudo service vsftpd start
* sudo /etc/init.d/vsftpd stop
* sudo /etc/init.d/vsftpd start
* sudo /etc/init.d/vsftpd status

## Conectando em um servidor SSH
* ssh nomeusuario@localhost (modo terminal)
* ssh -X nomeusuario@localhost (modo grafico)
* scp work.zip jose@localhost:/home/jose ou scp work.zip jose@localhost:~/

## VI (Editor de textos do terminal)
* - vi google.txt
* Setas: para navegação
* I: inclui (antes)
* A: adiciona (após)
* A+Shift: adiciona (fim da linha)
* X: remove caracteres (n X remove n caracteres)
* DD: remove uma linha (n DD remove n linhas) 

* Continuando com os comandos de navegação do VI, se quisermos ir para a última linha do texto basta apertarmos "Shift+G". Se quisermos pular para a linha n, apertamos o número correspondente e depois "Shift+G". Então se, por exemplo, quisermos ir para a linha 5, fazemos "5" e depois "Shift+G".
* Se quisermos ir para o final da linha atual usamos a tecla "$", ou seja, "Shift+4". Para a primeira, "0".
* Algo bem comum ligado à navegação de um arquivo é a procura de palavras. Para buscarmos palavras no texto usando o VI, digitamos "/" + o texto que procuramos: /texto
* Se digitarmos isso, o cursor vai para a primeira ocorrência da palavra "texto". Se apertarmos a tecla "N", ele irá para a próxima, e "N+Shift" vai para a anterior.
* Para copiarmos uma linha do texto apertamos a tecla "y" duas vezes. Para colar basta apertar a tecla "p".
* Também podemos usar a ideia de quantidade de linhas com os números. Se quisermos copiar a linha atual e mais as duas abaixo fazemos "3" e "yy" - três linhas foram copiadas.
* O mesmo serve para o comando de colar: "3" e "p" cola três vezes o conteúdo copiado anteriormente.

* cp = copia o texto de um arquivo para outro nome
*  - cp bemvindo.txt olamundo.txt
*  - cp -r projetos-java projetos-php

* mv = move um arquivo para outro (renomear)

* zip = zipa um determinado arquivo
*  - zip work.zip workspace/
*  - zip -r work.zip workspace/
*  - zip -rq work.zip workspace/

* unzip = descompacta arquivo
*  unzip -l work.zip = observa os arquivos que foram zipados
*  unzip -q work.zip

* tar = compacta arquivos
*  - tar -cz workspace > work.tar.gz (compacta um diretorio)
*  - tar -czf work.tar.gz workspace/
*  - tar -xz workspace < work.tar.gz (descompacta um diretorio)
*  - tar -xzf work.tar.gz
*  - tar -vxzf work.tar.gz

* touch = modifica apenas a data
* date = verifica a data do sistema

## Compilando a partir do código fonte: Make e Git

### Compilando a partir do código fonte: Make e Git
* Vimos, até agora, duas maneiras de instalar um programa no Linux:
* Via apt: quando o programa já está disponibilizado no repositório do Ubuntu.
* Via dpkg: quando baixamos pelo navegador da internet um pacote do programa.
* Porém, é possível que um programa não esteja disponível em nenhuma das duas formas. Nesse caso vamos ter que baixar seu código fonte, compilá-lo e instalá-lo.

* Façamos um teste baixando o código fonte de um projeto, o Git.

* Primeiro vamos entrar no site do git-scm, que é o controle de versão do Git. Na aba Tarballs encontramos as versões compactadas do código fonte do Git. Lá, baixemos a versão "git-1.8.3.1.tar.gz". O tar.gz mantém as permissões de execução.

* No Terminal, entramos no diretório de Downloads e descompactamos o arquivo:

* tar zxf git-1.8.3.1.tar.gz
* É criado um diretório com nome "git-1.8.3.1" com vários scripts que podem ser executados. Entremos nele.

* O padrão de criação para instalação de um projeto através do código fonte em C é primeiramente testarmos a configuração, ou seja, verificar se está faltando algum arquivo ou programa em nossa máquina. Para isso, em geral, é disponibilizado um script chamado "configure". Vamos rodá-lo:

* ~/Downloads/git-1.8.3.1$ ./configure
* O comando make é o padrão para rodar o build do nosso projeto C, no caso do Git:

* ~/Downloads/git-1.8.3.1$ make
* GIT_VERSION = 1.8.3.1
    * new build flags
    CC credential-store.o
* In file included from credential-store.c:1:0:
* cache.h:19:18: fatal error: zlib.h: No such file or directory
* compilation terminated.
* make: *** [credential-store.o] Error 1

* Não foi encontrada a biblioteca "zlib.h". O configure não apontou essa falta. Vamos ter que instalá-la manualmente e seu nome é "zlib1g-dev":

* sudo apt-get install zlib1g-dev
* Agora sim o make irá funcionar e gerar o Git. O proximo passo é, enfim, instalá-lo na máquina:

* ~/Downloads/git-1.8.3.1$ sudo make install
* Portanto, existem basicamente três comandos para instalar um programa a partir de seu código fonte:

* ./configure (pode haver dependências)
* make (pode haver dependências)
* sudo make install
