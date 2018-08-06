# Course LPI 

## SO: Linux, OSX, Windows

## Componentes
- Kernel: coração do Linux (https://www.kernel.org/)
- Bibliotecas
- Utilitários (programas)
- User Interface: Microfone, camera, monitor, terminal, mouse, etc.


## Links 
Richard Stallman criou a licença GPL (https://en.wikipedia.org/wiki/GNU_General_Public_License)
Link prova Certificação Linux: http://www.lpi.org/our-certifications/exam-010-objectives/
Lista de Distribuições: https://en.wikipedia.org/wiki/Comparison_of_Linux_distributions

## Instalando o Ubuntu:
* http://www.ubuntu.com/

## Instalando VirtualBox:
* https://www.virtualbox.org/


## Programas
```
LibreOffice
ThunderBird
Gimp
IbnkScape
Blender
Audacity
Vlc
```

## Servidores
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

## Comandos
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
``` 

## Debian
``` 
Pacotes com extensão .deb podem ser instalados via comando: 
dpkg -i mysql-client_5.6.30-0ubuntu0.15.10.1_all.deb (Melhor utilizar o apt-get ao invés do dpkg)
Lista todos os pacotes da maquina: dpkg --list
``` 

## Fedora (https://getfedora.org/)
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

## CentoOS (https://www.centos.org/ )
``` 
Instalando um pacote: $ sudo yum install lynx
Configurando a placa de rede ethernet: execute nmcli d, depois nmtui, e por fim systemctl restart network
Testando a rede: ping www.google.com
``` 

## Licenças
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

## Cloud
```
https://registro.br/
https://wordpress.org/
https://dnsimple.com/
https://www.locaweb.com.br/
https://br.godaddy.com/
https://pt.wikipedia.org/wiki/Computa%C3%A7%C3%A3o_em_nuvem
https://aws.amazon.com/pt/free/?sc_channel=PS&sc_campaign=acquisition_BR&sc_publisher=google&sc_medium=english_cloud_computing_hv_b&sc_content=aws_cloud_e&sc_detail=amazon%20cloud&sc_category=cloud_computing&sc_segment=89108831308&sc_matchtype=e&sc_country=BR&s_kwcid=AL!4422!3!89108831308!e!!g!!amazon%20cloud&ef_id=Vyo8jQAABEV16-GY:20160504181645:s

```

## Command Line Basics
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

pwd: descobre o diretório atual  

date: fornece a data e o horário, inclusive com o time zone, o BRT, Brazilian Time





```




