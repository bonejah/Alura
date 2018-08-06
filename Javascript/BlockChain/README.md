# COURSE BLOCKCHAIN

* Double Spending
```
Double spending representa o ato de enviar o mesmo item de valor mais de uma vez para um ou mais destinos.
Esse é um problema muito mais complicado de resolver no mundo digital. Como você vai saber se, por exemplo, um arquivo que você recebeu não é uma cópia? No mundo real, o mesmo problema existe, mas já existem mecanismos de proteção. Por exemplo, toda cédula no Brasil possui uma marca d'água que é verificada por quem está recebendo o dinheiro.

Quando o destinatário não confia na origem, uma terceira entidade é acionada para aumentar a confiança na transação e deixar as partes mais tranquilas. É exatamente o que acontece nas soluções tradicionais. Bancos e cartórios representam estes tipos de approaches.
```

* BlockChain
```
Uma rede privada, em geral, tira a necessidade de mineração remunerada de cada transação. Esse é um dos motivos para a utilização de tal rede. Um grupo de pessoas ou empresas quer adicionar confiança em informações trocadas entre eles, mas não querem ter que ficar pagando pelo processamento.

Uma rede privada, geralmente, te da possibilidade de explorar novas soluções baseadas em blockchain. Sim! Os exemplos que citamos, registro médico e votos, corroboram essa ideia.

Exemplo: Os compradores de joias não confiam nas informações fornecidas pelos produtores sobre a cadeia de produção.

Confiança:

- Acesso as informações registradas.
- Adicionar uma solução de consenso distribuído.
- Deixa o código deployado disponível para análise.
```

## Installation
```
JDK1.8 (Obrigatório o uso): 
  https://sdkman.io/install
  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

MYSQL: 
  http://mysql.com/downloads/mysql

DOWNLOAD PROJECT: 
https://github.com/alberto-alura/curso-introducao-blockchain/raw/master/eleicoesonline.war
https://github.com/alberto-alura/curso-introducao-blockchain/raw/master/webapp-runner.jar

Uma vez baixados, deixe os dois na mesma pasta. Agora, você precisa abrir seu terminal, navegar até a pasta onde se encontram os dois arquivos e executar o comando abaixo:

java -Dspring.datasource.username=root -Dspring.datasource.password=  -jar webapp-runner.jar --port 8080 --expand-war eleicoesonline.war

(caso tenha senha no MYSQL)
java -Dspring.datasource.username=root -Dspring.datasource.password=SUASENHAAQUI  -jar webapp-runner.jar --port 8080 --expand-war 
eleicoesonline.war

GERANDO OS DADOS INICIAIS:
Se tudo deu certo até aqui, você já pode acessar alguns endereço referentes a aplicação Java. Nesse momento, vamos acessar dois endereços para a geração dos dados mínimos para a utilização.

O primeiro deve ser http://localhost:8080/magic/generate/roles. 
O segundo vai ser http://localhost:8080/magic/generate/owner/.

O primeiro endereço gera os perfis de acesso da nossa aplicação. O segundo gera um usuário capaz de criar eleições, aprovar candidatos etc.

NODE:
Instale a versão 8

DOCKER:
Para o windows, acesse o endereço:
  https://store.docker.com/editions/community/docker-ce-desktop-windows
  https://download.docker.com/win/stable/DockerToolbox.exe


Para instalar no macOS, você pode acessar o endereço:
  https://cursos.alura.com.br/course/docker-e-docker-compose/task/29235.

Para instalar no ubuntu, execute os comandos abaixo: 
  Remova versões antigas:
  sudo apt-get remove docker docker-engine docker.io

  Atualiza os pacotes:
  sudo apt-get update

  Adicione ao sistema a chave GPG oficial do repositório do Docker:
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add - 

  Adicione o repositório do Docker às fontes do APT:
  sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) \
  stable"

  Atualize o banco de dados de pacotes:
  sudo apt-get update

  Instale o docker:
  sudo apt-get install docker-ce

  E para executar o Docker sem precisar de sudo, adicione o seu usuário ao grupo docker
  sudo usermod -aG docker $(whoami)

DOCKER COMPOSE:
  https://docs.docker.com/compose/install/#install-compose

EXECUTANDO O SAWTOOTH:
  Crie um novo arquivo (sawtoothdefault.yml) e cole o conteudo do link abaixo 
  no arquivo que acabou de criar:
  https://raw.githubusercontent.com/alberto-alura/curso-introducao-blockchain/master/sawtooth-default.yaml

SUBINDO O SAWTOOTH:
  docker-compose -f sawtooth-default.yaml up

APLICAÇÃO NODEJS:
  https://github.com/alberto-alura/curso-introducao-blockchain/releases/tag/versao_inicial    

  Uma vez que você fez o download, siga os seguintes passos:

  Faça a extração dos arquivos do zip para uma pasta do seu gosto.
  Abra uma outra aba no seu terminal ou abra outro terminal mesmo.
  Navegue até a pasta de download do projeto.
  Uma vez na pasta, navegue para a pasta blockchain-api.
  
  Como esse é o primeiro acesso, é necessário instalar as dependências do projeto. Execute o comando npm install.

  Agora execute o comando node index.js.

  Você deve ver uma saída parecida com essa:
  restify listening at http://[::]:8084

```



