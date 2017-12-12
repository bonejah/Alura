Alura course - Advanced Javascript - ES6

Command to set hour pt-BR: exec defaults write com.google.Chrome AppleLanguages
'(pt-BR)'

You need install nodejs: https://nodejs.org/

https://kangax.github.io/compat-table/es6/.

=================================================================================================================================
Exemplo: Reflect.apply

let objeto1 = { nome: 'Bob'}; let objeto2 = { nome: 'Leo'};

function exibeNome() { alert(this.nome); }

Reflect.apply(exibeNome, objeto1, []); // exibe 'Bob' Reflect.apply(exibeNome,
objeto2, []); // exibe 'Bob'

Como Reflect.apply funciona? O primeiro parâmetro é o método ou função que
desejamos invocar. O segundo parâmetro é o contexto que o método ou função
adotará, ou seja, o valor que será assumido pelo this. Por fim, o último
parâmetro é um array que contém todos os parâmetros que o método passado como
primeiro parâmetro receberá. Como ele não recebe parâmetro nenhum, passamos um
array vazio.

=================================================================================================================================
Padrão Observer: Utilizado para notificar partes do sistema interessadas quando
um evento importante for disparado em nosso sistema. No contexto da nossa
aplicação, entendemos um evento como o ato de adicionar ou esvaziar nossa lista
de negociações. É a view que está interessada em observar esse evento e tomar
uma ação, no caso, se atualizar com base no estado mais atual do modelo.

=================================================================================================================================
Padrão Proxy: O padrão de projeto Proxy nada mais é do que um objeto "falso",
"mentiroso", que envolve e encapsula o objeto real que queremos interagir. É
como se fosse uma interface, entre o objeto real e o resto do código.
Conseguimos assim controlar o acesso aos seus atributos e métodos. Nele também
podemos pendurar códigos que não cabem de estar alocados nos nossos modelos, mas
que necessitam ser executados no caso de uma alteração ou atualização do mesmo.

Target é o objeto real que é encapsulado pela proxy. É este objeto que não
queremos "sujar" com armadilhas ou qualquer código que não diga respeito ao
modelo.

Prop é a propriedade em si, que está sendo lida naquele momento.

Receiver é a referência ao próprio proxy. É na configuração do handler do Proxy
que colocamos armadilhas.

=================================================================================================================================
Padrão Factory: Ele é utilizado quando precisamos facilitar a criação de um
objeto. É ideal quando queremos criar objetos similares, com apenas seus
detalhes diferentes, que podemos passar nos argumentos da Factory. É bom para
abstrair a criação de um objeto complexo, já que o programador que utilizar a
Factory não precisa necessariamente saber como é feita esta operação.

=================================================================================================================================
Padrão Promisse: Promises (promessas) agora fazem parte da linguagem JavaScript
a partir do ES6. Elas representam o resultado futuro de uma ação, que pode ser
de sucesso ou fracasso. Elas visam tornar códigos assíncronos mais legíveis e
fáceis de manter, evitando o Callback Hell. Uma ou outra chamada assíncrona não
é problemática, o problema é quando temos uma sucessão de chamadas assíncronas e
o modo tradicional de lidar com elas, aninhando callbacks, torna o código
difícil de ler e manter, principalmente o tratamento de erros.

=================================================================================================================================
Padrão ConnectionFactory: Classe responsável por encapsular todo os métodos
relacionados a conexão da aplicação

=================================================================================================================================
Module Pattern. É uma unidade de código confinada, mas que não exporta qualquer
funcionalidade.

=================================================================================================================================
A propriedade onreadystatechange guarda uma função para ser executada
automaticamente cada vez que há uma alteração no estado da requisição.

Cada status é representado através de um inteiro. Os estados possíveis são: 0:
requisição ainda não iniciada. 1: conexão com o servidor estabelecida. 2:
requisição recebida. 3: processando requisição. 4: requisição concluída e a
resposta esta pronta.

O Error-first Callback, ou errorback, é um padrão que foi adotado no mundo
Node.js. Como você já aprendeu, o callback é uma função chamada quando uma
tarefa for executada, como uma requisição Ajax ou o acesso ao banco de dados. No
entanto, a qualquer momento pode acontecer um erro no processamento e aí vem a
questão de como lidar com isso. A convenção é que cada callback receba sempre o
erro no primeiro parâmetro. Na função callback, basta então verificar esse
parâmetro para saber se ocorreu um erro ou não!

Um transpiler é um compilador de código fonte para código fonte. Ou seja, em
linguagens como C, compilamos o código fonte para um código binário para que
esse rode em nosso sistema operacional. Já um transpiler poderia converter o
código escrito em C para JavaScript, ou seja, é um compilador que traduz o
código fonte de uma linguagem para outra.

No caso do JavaScript, o truque é compilar o código fonte (nossos arquivos JS)
para JavaScript. Mas espera aí Flávio, não faz sentido algum converter código
JavaScript para código JavaScript. Faz sim, porque no caso estaríamos
convertendo um código em ES6 para ES5! Nesse contexto, o programador organiza
seu código em ES6 para ajudar na manutenção e legibilidade, mas na hora que esse
código for entrar em produção ele é todo convertido para ES5, ou seja, toda
feature do ES6 é implementada (muitas vezes verbosamente) usando ES5! Com isso,
qualquer navegador do mercado será capaz de compreender nosso código.

Vejamos um exemplo de código em ES6:

class Pessoa {

    constructor(nome, sobrenome = '') {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    obterNomeCompleto() {
        return `${this.nome} ${this.sobrenome}`;
    }

    static imprimePessoas(pessoas) {
        pessoas.forEach((pessoa) => console.log(pessoa.nome));
    }

} O mesmo código, convertido para ES5 através de um transpiler ficaria assim:

function Pessoa(nome, sobrenome) {

    this.nome = nome;
    this.sobrenome = sobrenome || ''

}

Pessoa.prototype.obterNomeCompleto = function() { return this.nome + ' ' +
this.sobrenome }

Pessoa.imprimePessoa(pessoas) { pessoas.forEach(function(pessoa) {
console.log(pessoa.nome); }); } O mais importante nessa abordagem, é nunca
editarmos os arquivos em ES5, editamos sempre os que estão em ES6 que a cada
modificação devem ser convertidos para ES5.

=================================================================================================================================
Cada browser define um limite de tamanho para os dados armazenados no IndexedDB
sem que seja necessário autorização do usuário. Se esse limite for excedido, uma
caixa de diálogo pedirá a confirmação do usuário. Caso ele negue, o evento
onerror será executado. O cálculo do limite disponível muitas vezes é calculado
dinamicamente e varia de browser para browser, como está escrito na
documentação: The process by which the browser works out how much space to
allocate to web data storage and what to delete when that limit is reached is
not simple, and differs between browsers. Fonte:
https://developer.mozilla.org/en-US/docs/Web/API/IndexedDB_API

http://dexie.org/
http://aaronpowell.github.io/db.js/


Se você já trabalhou com algum banco de dados relacional deve ter reparado que
em nenhum momento chamamos métodos como commit ou rollback para consolidar a
transação ou abortá-la. Por mais que isso possa lhe causar certo espanto, o
IndexedDB trabalha um pouquinho diferente. Transações do IndexedDB são auto
commited É por meio de uma transação que temos acesso a uma store e dela podemos
realizar operações como a inclusão de um objeto. Quando essa operação é
realizada com sucesso, ou seja, quando o evento onsuccess é chamado a transação
é fechada, ou seja, as transações do IndexedDB são auto commited. É por isso que
cada método do nosso NegociacaoDao solicita uma transação toda vez que é
chamado.

Podemos cancelar uma transação através do método abort Ótimo, já sabemos quando
uma transação é efetivada e que este é um processo automático, no entanto nem
sempre queremos efetivá-la, ou seja, queremos abortá-la. Fazendo uma alusão aos
bancos de dados relacionais, queremos ser capazes de realizar um rollback.

Para cancelarmos (rollback) uma transação podemos chamar o método abort:

ConnectionFactory. .getConnection() .then(connection => {

            let transaction = connection.transaction(['negociacoes'], 'readwrite');

            let store = transaction.objectStore('negociacoes');

            let negociacao = new Negociacao(new Date(), 1, 200);

            let request = store.add(negociacao);

            // #### VAI CANCELAR A TRANSAÇÃO. O evento onerror será chamado.
            transaction.abort();

            request.onsuccess = e => {

                console.log('Negociação incluida com sucesso');
            };

            request.onerror = e => {

                console.log('Não foi possível incluir a negociação');
            };


    })

Ao executar o código a seguinte mensagem de erro será exibida no console:

DOMException: The transaction was aborted, so the request cannot be fulfilled.
Não foi possível incluir a negociação Trate o cancelamento de uma transação no
evento onabort de transaction Contudo, podemos tratar os erros de uma transação
abortada no evento onabort da transação, ao invés de lidarmos com ele em
onerror.

ConnectionFactory. .getConnection() .then(connection => {

            let transaction = connection.transaction(['negociacoes'], 'readwrite');

            let store = transaction.objectStore('negociacoes');

            let negociacao = new Negociacao(new Date(), 1, 200);

            let request = store.add(negociacao);

            // #### VAI CANCELAR A TRANSAÇÃO. O evento onerror será chamado.

            transaction.abort();
            transaction.onabort = e => {
                console.log(e);
                console.log('Transação abortada');
            };

            request.onsuccess = e => {

                console.log('Negociação incluida com sucesso');
            };

            request.onerror = e => {

                console.log('Não foi possível incluir a negociação');
            };


    })

=================================================================================================================================
Babel: transpiler JS ES6 to ES5
Install: 
npm install babel-cli@6.10.1 --save-dev
npm install babel-preset-es2015@6.9.0  --save-dev
npm install babel-plugin-transform-es2015-modules-systemjs@6.9.0 --save-dev
npm install systemjs@0.19.31 --save

In file package.json insert the code below: 
 "build": "babel js/app-es6 -d js/app" 
 "watch": "babel js/app-es6 -d js/app --source-maps --watch" 

In terminal run: 
npm run build inside folder 'client'
npm run watch inside folder 'client'




