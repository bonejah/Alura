# Curso NodeJS 2

## Create project
* mkdir payfast && cd payfast
* execute the command: npm init -y (to generate package.json)
* install express: npm i --save express
* execute file index.js: node index.js
* install nodemon: npm i --save nodemon (HotDeploy))
* execute node: nodemon index.js 
* install consign: npm i --save consign (helper to routes)
* install body-parser: npm i --save body-parser
* install mysql: npm i --save mysql
* install express-validator: npm i --save express-validator
* install restify: npm i --save restify
* install soap: npm i --save soap
* install memcached: npm i --save memcached
* execute command: memcached -vv

## Install Curl on Windows
```
Para obter o cURL você pode...

Instalador para Windows: Instalar a distribuição para Windows disponível aqui.
Chocolatey: Utilizar o Chocolatey para instalar com o comando choco install curl.
Cygwin: Obter o cURL por meio do Cygwin, lembre de selecionar o pacote durante a instalação.
Bash on Ubuntu on Windows se você estiver utilizando o Windows 10 após a atualização de aniversário, uma opção é utilizar o Bash do Ubuntu no Linux (louco, eu sei...) com ele você pode usar o cURL ou executar apt-get install curl caso ele não esteja instalado.
Outras alternativas...

Postman: Comumente desenvolvedores costumam usar o Postman como alternativa ou substituto do cURL.
HttpRequester e Advanced REST client: Extensões para navegadores menos populares do que o Postman, mas cumprem o que prometem.
SoapUI: Esta vejo mais comumente usada para testar serviços SOAP, mas vou deixar aqui registrada por que pode ser usada para REST e segundo a propaganda muito mais.
Bônus point: Descobri recentemente o Insomnia, ainda não testei mas admito estar curiosa. Farei testes muito em breve.
```

* curl http://localhost:3000/pagamentos/pagamento -X POST -v -H "Content-type: application/json" -d '
{
  "forma_de_pagamento":"payfast",
  "valor":10,
  "moeda":"BRL",
  "descricao":"criando um pagamento"
}'

* curl http://localhost:3000/pagamentos/pagamento -X POST -v -H "Content-type: application/json" -d @files/pagamento.json

* curl http://localhost:3000/correios/calculo-prazo -H "Content-type: application/json" -d 
@files/dados-entrega.json

* curl -X POST http://localhost:3000/upload/imagem --data-binary @imagem.jpg -H "Content-type: application/octet-stream" -v -H "filename: imagem.jpg"

* curl -X POST http://localhost:3000/upload/imagem -v 
          -H "filename: imagem.jpg" 
          -H "Content-Type: application/octet-stream" 
          --data-binary @imagem.jpg

* curl -X GET http://localhost:3000/pagamentos/pagamento/2 -v
         

## Criando o banco de dados e a tabela
```
create database payfast;

CREATE TABLE `pagamentos` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
  `forma_de_pagamento` varchar(255) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `moeda` varchar(3) NOT NULL,
  `status` varchar(255) NOT NULL,
  `data` DATE,
  `descricao` text,
   PRIMARY KEY (id)
  );
```

## Status Code
* 100 Continue: o servidor recebeu a solicitação e o cliente pode continuar a comunicação.
* 200 Ok: tudo ocorreu como esperado.
* 201 Created: um novo recurso foi criado no servidor.
* 301 Moved: a url solicitada foi movida.
* 400 Bad Request: problemas na requisição do cliente.
* 404 Not Found: a url solicitada não foi encontrada.
* 500 Internal Server Error: algo inesperado aconteceu do lado do servidor

## REST
* A sigla REST vêm de Representational State Transfer e surgiu da tese de doutorado de Roy Fielding, descrevendo as ideias que levaram à criação do protocolo HTTP. A Web é o maior exemplo de uso de uma arquitetura REST, onde os verbos são as operações disponíveis no protocolo (GET, POST, DELETE, PUT, OPTION...), os recursos são identificados pelas URLs e as representações podem ser definidas com o uso de Mime Types(texto, XML, JSON e outros).

* REST não é uma especificação nem uma tecnologia, é um modelo arquitetural. Neste modelo, o pensamento da aplicação gira em torno dos recursos. Depois de definir os recursos, usamos os verbos disponíveis (no HTTP temos o GET, POST, PUT e outros) para manipular estes recursos.

* Uma das ideias da arquitetura REST é aproveitar ao máximo o protocolo de comunicação (HTTP) usando-o direito. Nesse escopo, um dos princípios que o REST prega é a utilização das URIs de acordo com sua denominação, URI é a sigla para Uniform Resource Identifier (Identificador Uniforme de Recurso). Pensando voltado a recursos, podemos imaginar que cada recurso tem um identificador único perante os usúarios.

* Casando com a ideia de manipular os recursos usando os verbos do protocolo, se cada recurso tem um único endereço, basta fazer uma requisição do tipo POST para criar um novo recurso ou fazer uma requisição GET para buscar o recurso. Tudo gira em torno do recurso.

* Os recursos em geral estarão "guardados" ou gerados no servidor, então o cliente da aplicação não pode simplesmente pegá-lo, no máximo ele pode vizualizá-lo. Porém, essa visualização pode ocorrer de várias maneiras, por meio de uma página HTML, uma interface desktop, mobile e etc.

* Parte da ideia REST foca que em cada recurso pode ter suas representações. Cada representação pode ter seu formato específico, por exemplo, via XML, HTML, JSON

## METODOS HTTP
* Ao desenhar aplicações REST, pensamos nos recursos a serem disponibilizados pela aplicação e em seus formatos, em vez de pensar nas operações. As operações disponíveis para cada um dos recursos no protocolo HTTP são:

* GET: retorna uma representação do recurso
* POST: cria ou altera o recurso
* PUT: cria ou altera o recurso
* DELETE: remove o recurso outras menos comuns, como HEAD e OPTIONS
* Os quatro principais verbos do protocolo HTTP são comumente associados às operações de CRUD em sistemas Restful (POST -> INSERT, GET -> SELECT, PUT -> UPDATE, DELETE -> DELETE). Há uma grande discussão dos motivos pelos quais usamos POST para criação (INSERT) e PUT para alteração (UPDATE). A razão principal é que o protocolo HTTP especifica que a operação PUT deve ser idempotente, já POST não.

### Idempotência e SAFE
* Operações idempotentes são operações que podem ser chamadas uma ou mais vezes, sempre com o mesmo resultado final.
* Uma operação é chamada SAFE se ela não altera nenhuma representação.
* Idempotência e SAFE são propriedades das operações e fundamentais para a escalabilidade da Web.

## HATEOAS
* Hypermedia
* As
* The
* Engine
* Of
* Application
* State
* http://blog.caelum.com.br/hipermidia-e-contratos-dinamicos-menor-acoplamento/

## Links
* https://nodejs.org/.
* https://www.getpostman.com/


