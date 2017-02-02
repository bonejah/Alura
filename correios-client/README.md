Projetos de estudo do SOA utilizando Java, consomre um serviço dos correios

Tecnologias utilizadas
- Java8
- JBossWildFly 10 - Implementacao JAX-WS que incorpora chama-se CFX
- SOAP
- WSDL de exemplo: https://s3.amazonaws.com/caelum-online-public/soap/EstoqueWSServiceCap5.wsdl
- wsdl2java: ferramenta que cria as classes a partir do wsdl

- comando que gera as classes (executar o comando abaixo dentro da pasta bin do JBossWildFly): 
wsconsume.bat -k -n -o C:\Users\Bruno\Desktop\Projects\ProjetosAlura\estoquews-web\src C:\Users\Bruno\Desktop\Projects\ProjetosAlura\estoquews-web\src\EstoqueWSServiceCap5.wsdl
-k - keep, para manter o código fonte
-o - para definir a pasta de saida
-n - não compilar (pois o Eclipse vai compilar)

- comando para gerar as classes do client
wsimport -s src -p br.com.caelum.estoque.client http://localhost:8080/estoquews-web/EstoqueWS?wsdl
-s - diretório dos arquivos .java gerados
-p - pacote das classes geradas

- comando para gerar o wsdl na linha de comando:
C:\Users\Bruno\Desktop\Projects\ProjetosAlura\estoquews>wsgen -cp bin br.com.caelum.estoque.ws.EstoqueWS -wsdl -inlineSchemas

O Port é nada mais do que o objeto que se comunica com o serviço! Ele abstrai todos os detalhes como estabelecer a conexão HTTP 
e gerar a mensagem SOAP. Em alguns casos ele também é chamado de stub. De qualquer forma, no mundo de padrões de projeto esse 
objeto também é chamado de proxy ou remote proxy. 3 nomes para a mesma coisa: Port, Stub ou Remote Proxy!

Implementacoes JAX-WS:
https://metro.java.net/ 
http://axis.apache.org/axis2/java/core/index.html

