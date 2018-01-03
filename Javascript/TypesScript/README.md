# Course TypesScript by Alura

* 1 - Inside folder alurabank execute: npm init
* 2 - Run: npm install typescript@2.3.2 --save-dev
* 3 - Rename folder 'js' to 'ts'
* 4 - Create a new file 'tsconfig.ts' inside folder 'alurabank'
* 5 - In file package.json add this line "compile": "tsc" and "start": "tsc -w" on tag "scripts"
* 6 - Run: npm run compile
* 7 - In file tsconfig.json add this line "noEmitOnError": true on tag "compilerOptions"
* 8 - Run: npm start
* 9 - Run: npm install @types/jquery@2.0.42 --save-dev
* 10 - Run: npm install lite-server@2.3.0 --save-dev
* 11 - Run: npm install concurrently@3.4.0 --save-dev

* TypeScript não é uma linguagem exclusiva para frontend, ela pode ser usada também no backend com Node.js. Contudo,como existem milhares (sem exagero) de módulos criados no repositório do npm (um dos maiores do mundo), as chances dos módulos da sua aplicação não terem seu respectivo TypeScript Definition file são gigantes. A única garantia que você terá são as definições dos módulos padrões do Node.js: npm install @types/node --save-dev

* Outro ponto importante, aliás, uma dica, é evitarmos o uso do strictNullChecks e do noImplicityAny. Caso estejam presentes no arquivo tsconfig.js seus valores devem ser false. A ativação dessas configurações geraram inúmeros problemas com possíveis definições que você venha a baixar.

## Links
* http://underscorejs.org/
* https://www.npmjs.com/package/@types/jquery
* https://www.npmjs.com/package/@types/lodash
* https://www.npmjs.com/package/@types/underscore