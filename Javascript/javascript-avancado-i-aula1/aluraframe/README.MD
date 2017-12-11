Alura course - Advanced Javascript - ES6

Command to set hour pt-BR:
exec defaults write com.google.Chrome AppleLanguages '(pt-BR)'


You need install nodejs: https://nodejs.org/

https://kangax.github.io/compat-table/es6/.

=================================================================================================================================
Exemplo: Reflect.apply 

let objeto1 = { nome: 'Bob'};
let objeto2 = { nome: 'Leo'};

function exibeNome() {
    alert(this.nome);
}

Reflect.apply(exibeNome, objeto1, []); // exibe 'Bob'
Reflect.apply(exibeNome, objeto2, []); // exibe 'Bob'

Como Reflect.apply funciona? O primeiro parâmetro é o método ou função que desejamos invocar. O segundo parâmetro é o contexto que o método ou função adotará, ou seja, o valor que será assumido pelo this. Por fim, o último parâmetro é um array que contém todos os parâmetros que o método passado como primeiro parâmetro receberá. Como ele não recebe parâmetro nenhum, passamos um array vazio.

=================================================================================================================================
Padrão Observer: Utilizado para notificar partes do sistema interessadas quando um evento importante for disparado em nosso sistema. No contexto da nossa aplicação, entendemos um evento como o ato de adicionar ou esvaziar nossa lista de negociações. É a view que está interessada em observar esse evento e tomar uma ação, no caso, se atualizar com base no estado mais atual do modelo.

=================================================================================================================================
Padrão Proxy: O padrão de projeto Proxy nada mais é do que um objeto "falso", "mentiroso", que envolve e encapsula o objeto real que queremos interagir. É como se fosse uma interface, entre o objeto real e o resto do código. Conseguimos assim controlar o acesso aos seus atributos e métodos. Nele também podemos pendurar códigos que não cabem de estar alocados nos nossos modelos, mas que necessitam ser executados no caso de uma alteração ou atualização do mesmo.

Target é o objeto real que é encapsulado pela proxy. É este objeto que não queremos "sujar" com armadilhas ou qualquer código que não diga respeito ao modelo.

Prop é a propriedade em si, que está sendo lida naquele momento.

Receiver é a referência ao próprio proxy. É na configuração do handler do Proxy que colocamos armadilhas.

=================================================================================================================================
Padrão Factory: Ele é utilizado quando precisamos facilitar a criação de um objeto. É ideal quando queremos criar objetos similares, com apenas seus detalhes diferentes, que podemos passar nos argumentos da Factory. É bom para abstrair a criação de um objeto complexo, já que o programador que utilizar a Factory não precisa necessariamente saber como é feita esta operação.

=================================================================================================================================
Padrão Promisse: Promises (promessas) agora fazem parte da linguagem JavaScript a partir do ES6. Elas representam o resultado futuro de uma ação, que pode ser de sucesso ou fracasso. Elas visam tornar códigos assíncronos mais legíveis e fáceis de manter, evitando o Callback Hell. Uma ou outra chamada assíncrona não é problemática, o problema é quando temos uma sucessão de chamadas assíncronas e o modo tradicional de lidar com elas, aninhando callbacks, torna o código difícil de ler e manter, principalmente o tratamento de erros.


=================================================================================================================================
A propriedade onreadystatechange guarda uma função para ser executada automaticamente cada vez que há uma alteração no estado da requisição.

Cada status é representado através de um inteiro. Os estados possíveis são:
0: requisição ainda não iniciada.
1: conexão com o servidor estabelecida.
2: requisição recebida.
3: processando requisição.
4: requisição concluída e a resposta esta pronta.

O Error-first Callback, ou errorback, é um padrão que foi adotado no mundo Node.js. Como você já aprendeu, o callback é uma função chamada quando uma tarefa for executada, como uma requisição Ajax ou o acesso ao banco de dados. No entanto, a qualquer momento pode acontecer um erro no processamento e aí vem a questão de como lidar com isso.
A convenção é que cada callback receba sempre o erro no primeiro parâmetro. Na função callback, basta então verificar esse parâmetro para saber se ocorreu um erro ou não!