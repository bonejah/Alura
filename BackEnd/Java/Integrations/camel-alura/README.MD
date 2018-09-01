# Curso Apache Camel
* Camel significa: Concise Application Message Exchange Language. Essa linguagem é a Camel DSL!

## Links
* http://camel.apache.org/file2.html
* http://www.enterpriseintegrationpatterns.com/
* http://camel.apache.org/exchange-pattern.html
* http://camel.apache.org/message.html
* http://camel.apache.org/event-message.html
* http://www.enterpriseintegrationpatterns.com/patterns/messaging/FileTransferIntegration.html
* http://www.enterpriseintegrationpatterns.com/patterns/messaging/IntegrationStylesIntro.html
* http://camel.apache.org/http4.html
* http://camel.apache.org/constant.html
* http://camel.apache.org/simple.html
* https://www.caelum.com.br/apostila-java-testes-jsf-web-services-design-patterns/
* http://velocity.apache.org/

## O que é um framework de integração?
* O Apache Camel, como framework de integração, implementa a maioria dos padrões de integração. Um framework de integraçãoo ajuda a diminuir a complexidade e o impacto dessas integrações. Em vez de escrever código de integração na m�o, usamos componentes para isso. Com um framework de integração seguimos boas práticas que foram identificadas e amadurecidas ao longo do tempo. Apache Camel é o framework de integrção mais famoso no mundo Java, mas não é a única opção. O Spring Integration é uma outra alternativa popular.

## Roteamento entre endpoints com Apache Camel
* Essencialmente, Camel é um roteador (routing engine), ou seja o Camel roteia os dados entre dois endpoints. Um endpoint é um serviço web, ou um banco de dados, pode ser um arquivo ou fila JMS. Em geral, é um ponto onde pegamos ou enviamos dados. A tarefa do desenvolvedor é configurar, através de um Builder, os endpoints e as regras de roteamento. O desenvolvedor decide de onde vem as mensagens (from()), para onde enviar (to()) e o que fazer com a mensagem no meio desse processo (mediation engine).

## A rota de pedidos
* No curso vamos implementar uma rota de pedidos. A ideia é que uma loja virtual gere um pedido quando uma compra for efetuada. Esse pedido precisa ser entregue para outros sistemas que recebam os dados em formatos diferentes. Nessa rota, vamos trabalhar com JMS, SOAP, HTTP e v�rias transformações!
* Usamos a versão 2.16.0. Outras vers�es do Apache Camel podem ser encontradas no reposit�rio central do Maven: http://mvnrepository.com/

## Database e tabela utilizadas no exercicio:
* create database camel;
* create table negociacao (id BIGINT NOT NULL AUTO_INCREMENT, preco DECIMAL(5,2), quantidade MEDIUMINT, data DATETIME, primary key (id));





