Curso JAX-RS e Jersey : Domine a criação de webservices REST
Grizzly = Servidor

http://curl.haxx.se/download.html
curl -v -d "<br.com.alura.loja.modelo.Projeto><id>2</id><nome>JAVA PUNK</nome><anoDeInicio>2016</anoDeInicio></br.com.alura.loja.modelo.Projeto>" http://localhost:8080/projetos
curl -v -H "Content-Type: application/xml" -d "<br.com.alura.loja.modelo.Projeto><id>2</id><nome>JAVA PUNK</nome><anoDeInicio>2016</anoDeInicio></br.com.alura.loja.modelo.Projeto>" http://localhost:8080/projetos
curl -v -X DELETE http://localhost:8080/carrinhos/1/produtos/6237
curl -v -X PUT -H "Content-Type: application/xml" -d "<br.com.alura.loja.modelo.Produto>      <preco>60.0</preco>      <id>3467</id>      <nome>Jogo de esporte</nome>      <quantidade>1</quantidade>    </br.com.alura.loja.modelo.Produto>" http://localhost:8080/carrinhos/1/produtos/3467
curl -v -X PUT -H "Content-Type: application/xml" -d "<br.com.alura.loja.modelo.Produto> <id>3467</id> <quantidade>1</quantidade>    </br.com.alura.loja.modelo.Produto>" http://localhost:8080/carrinhos/1/produtos/3467/quantidade

curl -v = mostra o que vc envia e o que vc recebe do servidor
curl --help

Metodos HTTP:
- patch: atualiza um pedaço de um recurso
- options: mostra quais são os métodos HTTP que o recurso suporta
curl -v -X OPTIONS http://localhost:8080/carrinhos
- trace
- connect
- head

http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html