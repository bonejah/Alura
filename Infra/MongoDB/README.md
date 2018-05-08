# Course MongDB

* www.mongodb.org
* http://docs.mongodb.org/v3.0/reference/method/db.collection.find

## Download 
```
Mac
https://docs.mongodb.org/manual/tutorial/install-mongodb-on-os-x/

Linux (ubuntu)
https://docs.mongodb.org/manual/tutorial/install-mongodb-on-ubuntu/

Windows
https://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/
```


## Start MongoDB
```
Para iniciar o mongobd (local padrão /data/db) digite no terminal: mongod
Para iniciar o mongodb em um diretorio especifico digite: mongod --dbpath <nome do diretorio>
Para iniciar o client do mongodb execute: mongo
```

## Collections
```
Criando colecao: db.createCollection("alunos");

```

## Commands
```
Inserindo na colecao alunos: 
db.alunos.insert(
  {
    "nome" : "bruno",
    "data_nascimento" : new Date(1981, 11, 17),
    "curso" : {
      "nome" : "Sistemas de informação"
    },
    "notas" : [10.0, 9.0, 4.5],
    "habilidades" : [
      {
        "nome" : "inglês",
        "nível" : "avançado"   
      },
      {
        "nome" : "taekondo",
        "nivel" : "basico"
      }
    ]
  }
);

db.alunos.insert(
  {
    "nome" : "bruno",
    "data_nascimento" : new Date(1981, 11, 17),
    "curso" : {
      "nome" : "Sistemas de informação"
    },
    "notas" : [10.0, 9.0, 4.5],
    "habilidades" : [
      {
        "nome" : "inglês",
        "nível" : "avançado"   
      }
    ]
  }
)

Removendo: 
db.alunos.remove({
   "_id": ObjectId("5af1c8c46217e525e9577932")
})

Consultando: 
db.alunos.find();
db.alunos.find().pretty(); // apresenta os dados de uma forma mais amigavel
db.alunos.find({ "nome": "bruno" }); 
db.alunos.find({ "habilidades.nome" : "inglês"}).pretty();
db.alunos.find({ "curso.nome" : "Sistemas de informação"})
db.alunos.find({ "curso.nome" : "Engenharia"})

Consulta com or
db.alunos.find({
  $or : [
    {"curso.nome" : "Fisica"},
    {"curso.nome" : "Engenharia"},
  ]
})

Consulta com or e and
db.alunos.find({
  $or : [
    {"curso.nome" : "Fisica"},
    {"curso.nome" : "Engenharia"},
  ],
  "nome" : "matheus"
})

Consulta com in
db.alunos.find({
  "curso.nome" : { 
    $in : ["Sistemas de informação", "Fisica"] 
  }
})

```
