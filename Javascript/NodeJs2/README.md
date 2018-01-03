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

## Links
* https://nodejs.org/.


