# Course MongoDB

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
Para iniciar o mongodb em um diretorio especifico digite: mongod --dbpath <nome do diretorio>
Para iniciar o client do mongodb (local padrão /data/db) digite no terminal: mongod
Para iniciar o client do mongodb execute: mongo
```

## Collections
```
Criando colecao: db.createCollection("alunos");

```

## Commands

* Inserindo
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
```

* Removendo
```
Removendo: 
db.alunos.remove({
   "_id": ObjectId("5af1c8c46217e525e9577932")
})
```

* Consultando
```
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

* Atualizando
```
db.alunos.insert(
  {
    "nome" : "Julio",
    "data_nascimento" : new Date(2018, 05, 10),
    "notas" : [10, 4.5, 7],
    "curso" : 
      { "nome" : "Sistema de informação" }
  }
)

db.alunos.find(
  { "nome" :  "Tadeu"}
)

db.alunos.find(
  { "curso.nome" :  "Sistemas de informação"}
)

// Perigo update abaixo
db.alunos.update(
  {"curso.nome" :  "Sistema de informação"},
  {
    "curso.nome" : "Sistemas de informação"
  }
)

db.alunos.update(
  { "curso.nome" : "Sistema de informação" },
  {
    $set : {
      "curso.nome" : "Sistemas de informação"
    }
  }
)

db.alunos.update(
    {"curso.nome" : "Sistema de informação"},
    {
        $set : {
            "curso.nome" : "Sistemas De Informação"
        }
    }    
)

// Por padrao o update executa apenas um comando para o primeiro documento que ele encontra
db.alunos.update(
    {"curso.nome" : "Sistemas de informação"},
    {
        $set : {
            "curso.nome" : "Sistemas De Informação"
        }
    }    
)

// Executando o comando abaixo ele atualiza todos os registros
db.alunos.update(
    {"curso.nome" : "Sistemas de informação"},
    {
        $set : 
           {"curso.nome" : "Sistemas de Informação"}  
        }, 
      {
        multi : true 
      }
)

db.alunos.find(
  { "_id" : ObjectId("5af1cbcb25036cdd29554e76") }
)

// Atualizando as notas
db.alunos.update(
  { "_id" : ObjectId("5af1cbcb25036cdd29554e76") },
  { $set : 
    {
      {
        "notas" : [10, 9, 4.5, 8.5]
      }    
    }
  }
)

db.alunos.update(
  { _id : ObjectId("5af1cbcb25036cdd29554e76") },
  { $push : 
    {
      {
        "notas" : 8.5
      }    
    }
  }
)

db.alunos.update(
    { _id : ObjectId("5af1cbcb25036cdd29554e76") },
    {
      $push : {
          "notas" : {$each : [8.5, 3] }
      }
    }
)

```

* Ordenando os dados
```
// Pesquisa pela nota 8.5
db.alunos.find(
  { "notas" : 8.5 }
)

// Pesquisa por alunos com nota maior que 5
db.alunos.find(
  { "notas" : { $gt : 5 } }
)

// Pesquisa por alunos com nota menor que 5
db.alunos.find({"notas":{$lt:5}})

// Inserindo novos alunos
db.alunos.insert({
    nome : "André",
    data_nascimento : new Date(1991,01,25),
    curso : {
        nome : "Matemática"
        },
        notas : [ 7, 5, 9, 4.5 ]
})

db.alunos.insert({
    nome : "Lúcia",
    data_nascimento : new Date(1984,07,17),
    curso : {
        nome : "Matemática"
        },
        notas : [ 8, 9.5,  10 ]
})

// Pesquisando por notas maior que 5 mas trazendo apenas um registro
db.alunos.findOne(
  { notas : { $gt : 5 }}
)

// Pesquisando por ordem alfabetica crescente
db.alunos.find().sort({"nome" : 1})

// Pesquisando por ordem alfabetica decrescente
db.alunos.find().sort({"nome" : -1})

// Pesquisando por ordem alfabetica crescente e limitando a 3 registros
db.alunos.find().sort({"nome" : 1}).limit(3)

```

* Busca por proximidade 
```
// Comando para importar um json para o mongo
mongoimport -c <nome_da_colecao> --jspnArray < <nome_do_arquivo.json>
mongoimport -c alunos --jsonArray < alunos.json
// db.alunos.aggregate([
  {
    $geoNear : {
      near : {
        coordinates : [-23.5640265, -46.6527128],
        type : "Point"
      },
      distanceField : "distancia.calculada",
      spherical : true,
      num : 4
    }
  },
  {
    skip : 1
  }
])


// criando um indice
db.alunos.createIndex({
  localizacao : "2dsphere"
})

// buscando alunos proximos ao Marcelo
db.alunos.aggregate([{
    $geoNear:{
        "near": {
            "coordinates":[-23.588055, -46.632403],
            "type":"Point"
},
"distanceField": "distancia.calculada",
"spherical": true
}
}])

```
