Projeto de Estudo do NodeJS

Node JS
O Node.js é uma plataforma, ou um ambiente de execução para códigos javascript escrita em cima da engine de Javascript do Chrome, a V8. Ele é todo baseado em eventos e suas operações são não-bloqueantes, o que lhe confere bastante eficiência e leveza.
https://nodejs.org/en/download/


node -v (verifica a versao do node instalada)
node nomedoarquivo.js: comando para executar o arquivo

npm -v (verifica a versao do node package manager)
npm init (inicializa um projeto)
npm install express --save // utilizamos --save para registrar no arquivo package.json como uma referência
npm install ejs --save

nodemom.io: deploy automaticos
npm install -g nodemon
nodemon app (subir a aplicação)

npm install mysql --save
npm install express-load --save

npm install body-parser --save
npm install express-validator --save
npm install mocha --save-dev (comando para rodar no windows: node node_modules/mocha/bin/mocha)
npm install supertest --save-dev (biblioteca de testes)
SET NODE_ENV=test node node_modules/mocha/bin/mocha
npm install socket.io --save
npm install 


Biblioteca Express Node Js
EmbebeddJS - EJS
require('http'): função javascript que importa tudo no NodeJS

CommonJS é uma convenção para carregamentos de módulos javascript em aplicações server-side. O objeto que o node disponibiliza é o module e a função é passada para o atributo exports desse objeto.

REST
Os verbos HTTP definem as possíveis operações que podem ser feitas sobre o protocolo HTTP. Eles formam um conjunto pequeno de interfaces bem definidas, que facilita a bastante a maneira como dois recursos trocam informações utilizando o HTTP, visto que eles precisam apenas utilizar esses métodos de acordo com a semântica de cada operação, sem que precisem sempre implementar tudo do zero. Essa padronização cria uma uniformidade muito importante para o protocolo HTTP.
Se você quiser aprofundar um pouco mais nesse assunto (o que parece uma excelente ideia para quem pretende trabalhar com serviços web), você pode começar dando uma olhada nesse post da Caelum, que traz um apanhado bem legal de características do padrão REST (que é todo baseado no funcionamento do HTTP):
https://www.caelum.com.br/apostila-vraptor-hibernate/rest/#11-3-o-triangulo-do-rest

Content Negotiation é um mecanismo definido no HTTP que torna possível servir diferentes formatos de um mesmo conteúdo a partir da mesma url. Evitando assim que se precisasse criar novas urls para cada formato necessário para exibir a lista de produtos, por exemplo.
Ele funciona através do Header Accept, em que o cliente que está consumindo a url informa qual tipo de dados, ele aceita receber no response de sua requisição. Os navegadores tradicionais, por exemplo, utilizam por default o valor “text/html” em seu Accept.

DigitalOcean (empresa para disponibilizar uma aplicação)
Heroku - https://www.heroku.com - Plataforma PAAS (Plataform as a Service)
Heroku toolbelt - https://devcenter.heroku.com/articles/heroku-command-line
www.cleardb.com

heroku --version
heroku login
heroku apps
heroku apps —help

heroku apps:create casadocodigoblima
https://casadocodigoblima.herokuapp.com/ | https://git.heroku.com/casadocodigoblima.git

heroku addons:create cleardb:ignite (O ClearDB é o serviço usado pelo Heroku para criação de Bancos de Dados MySQL.)
heroku config - para saber os dados de acesso e etc.