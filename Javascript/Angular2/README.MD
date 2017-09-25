Curse Angular2 by Alura


Download: https://s3.amazonaws.com/caelum-online-public/angular2/stages/01-alurapic.zip

Install Node
brew update
brew install node

To start server, run the command npm start inside folder 'server'

To install JQuery: 
npm install jquery@3.1.1 --save
node ./node_modules/typings/dist/bin install dt~jquery --global --save

npm install jqueryui-browser@1.10.2-1 --save
npm install jquery-migrate@3.0.0 --save
node ./node_modules/typings/dist/bin install dt~jqueryui --global --save


Angular CLI
npm install -g angular-cli@1.0.0-beta.19-3
ng new projeto-teste
ng serve

ng g component tabela
installing component
  create src/app/tabela/tabela.component.css
  create src/app/tabela/tabela.component.html
  create src/app/tabela/tabela.component.spec.ts
  create src/app/tabela/tabela.component.ts

ng g module papagaio

ng build --prod
ng serve --prod