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
MOzilla Public License - Parecido com GPL e BSD

```



