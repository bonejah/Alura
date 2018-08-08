# Course JMQ

* Para implementarmos essa solução, precisamos de um middleware e o mais famoso no mundo Java se chama ActiveMQ da Apache Foundation. Usaremos o ActiveMQ ao longo deste treinamento, um MOM da Apache.

* Primeiro passo é instalar o ActiveMQ.

* Baixamos o ActiveMQ 5.12.x (ou mais recente) em http://activemq.apache.org/download.html.
* Observação: No Windows é preciso executar o script InstallService.bat da pasta win32 ou win64 dependendo da arquitetura do computador.

* Depois de baixado, s� precisamos descompact�-lo. Como todo servidor, precisamos rodá-lo e fazemos através do terminal entrando na pasta apache-activemq-5.12.2/bin. L uma s�rie de scripts e precisamos rodar aquele que condiz com o sistema operacional que estamos usando. Por exemplo, no OSX usamos no terminal o comando

* activemq start = Windows
* sh activemq console = Unix

*** No meu caso foi nesse diret�rio: C:\Java\apache-activemq-5.12.0-bin\apache-activemq-5.12.0\bin\win32\activemq.bat console **** FUNCIONOU AQUI

* Agora sim. Além de subir nosso servidor, ele nos apresenta uma s�rie de logs. O terminal tamb�m indica o endere�o do nosso servidor: http://localhost:8161

* Visualizamos a página principal do ActiveMQ. Há um link (http://localhost:8161/admin) para o console de administrar. Ao ser clicado, precisamos um usuário e uma senha. O login e senha padrão são admin.

## Simulando a entrega
* Vamos simular essa entrega para nossa aplicaçãoo de nota fiscal que tem interesse em receber essas mensagens. 
* Para isso, preparamos um jar com código Java que consumirá a mensagem, mas ele não possui todo o protocolo possével do ActiveMQ, é por isso que da pasta do ActiveMQ que baixamos, vamos mover o activemq-all-5.12.0.jar. Resumindo: nosso aula-jms.jar depende de ativemq-all-5.12.0.jar.

* Sem fechar o terminal do ActiveMQ que está rodando, vamos abrir um novo terminal e executar:

## No Linux e Mac:
* java -cp activemq-all-5.12.0.jar:aula-jms.jar br.com.caelum.TesteMensageria consome

## No Windows:
* java -cp activemq-all-5.12.0.jar;aula-jms.jar br.com.caelum.TesteMensageria consome
* Nosso programa se conectou ao nosso MOM e recebeu as mensagens que cadastramos.
* Podemos enviar mensagens na linha de comando tamb�m usando o par�metro envia seguido com a quantidade de n�meros :

## No Linux e Mac:
* java -cp activemq-all-5.12.0.jar:aula-jms.jar br.com.caelum.TesteMensageria envia 10

## No Windows:
* java -cp activemq-all-5.12.0.jar;aula-jms.jar br.com.caelum.TesteMensageria envia 10
* Neste exemplo, estamos enviando 10 mensagens. Agora em nosso MOM, temos 10 mensagens. 
* Ao testar a consumidor (recebimento das mensagens) aparece no console:

* Os brokers são uma parte fundamental na integração de sistemas e existem vários no mercado, alguns de grandes fornecedores. 
* Exemplos populares são o RabbitMQ e o WebsphereMQ e, claro, o nosso ActiveMQ.
* Alguns até estão disponíveis na nuvem como Amazon SQS e iron.io.
* A wikipedia tem uma lista mais extensa com links de brokers disponíveis.




