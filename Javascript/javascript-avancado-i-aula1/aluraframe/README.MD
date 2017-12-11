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

