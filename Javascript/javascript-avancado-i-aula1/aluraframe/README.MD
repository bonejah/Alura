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
