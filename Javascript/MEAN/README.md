Course MEAN by Alura

-------------------------------------------------------------------------------------------------------------------------------
INFRASTRUCTURE

https://www.mongodb.org/
http://expressjs.com/en/index.html
https://nodejs.org/
http://meanjs.org/
http://mean.io/


NodeJS versão 4.X
Linux: sudo apt-get install -y nodejs
Windows: https://nodejs.org/dist/v4.2.3/node-v4.2.3-x86.msi ou https://nodejs.org/dist/v4.2.3/node-v4.2.3-x64.msi
Mac: brew update e depois brew search node e depois brew install homebrew/versions/node4-lts

MongoDB
Linux: https://docs.mongodb.org/manual/administration/install-on-linux/
Mac: brew install mongodb
Windows: https://www.mongodb.org/downloads

In Windows
Create a folder in: C:/data/db
Execute the comand using Power Shell: 
C:\Program Files\MongoDB\Server\3.6\bin>mongod.exe
C:\Program Files\MongoDB\Server\3.6\bin>mongo.exe
mongo
use alurapic
db 
db.fotos.find();
db.usuarios.insert({login: 'flavio', senha: '123'});

About MongoDB:
A) Um documento é uma estrutura muito semelhante ao JSON, com a diferença de que possui mais tipos.
B) Para agrupar documentos, é utilizado coleções (collections), que são análogas as tabelas de um banco de dados relacional.
C) Dentro de uma collection, podemos salvar documentos com estrutura diferentes.
D) Documentos são gravados na estrutura BSON

--------------------------------------------------------------------------------------------------------------------------------
PROJECT
#Create a new file in folder alurapic: server.js
#To run server: node server.js
#npm init
#To run server: npm start
#To install express: npm install express@4.13.3 --save-dev
#Create a folder 'config/express.js' inside alurapic
#Install: npm install consign@0.1.2 --save-dev
#Install: npm install body-parser@1.14.1 --save-dev
#Install: npm install mongoose@4.3.1 --save -dev
#Install: npm install jsonwebtoken@5.4.1 --save-dev


