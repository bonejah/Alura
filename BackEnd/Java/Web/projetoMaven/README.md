# Course Maven3

## Criando um projeto no MAVEN
* mvn archetype:generate -DartifactId=produtos -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart

## Compilando classes
* mvn compile

## Rodando os testes do projeto
* mvn test

# Limpando o diretorio target
* mvn clean

## Gerando o package
* mvn package

##Gerar relatorio HTML 
* mvn surefire-report:report
* va no diretorio target/site

## Comando para executar uma classe do .jar gerado no diretorio target
* java -cp produtos-1.0-SNAPSHOT.jar br.com.alura.maven.App

## Executar um comando offline (nao baixa nada da Internet)
* mvn -o test

## Gerando relatorio PMD (Estatistica do codigo)
* mvn pmd:pmd
* mvn pmd:check

## Plugin para cobertura de testes
* mvn jacoco:help

## Comando para atualizar as versoes das dependencias (atualiza o pom)
* mvn versions:use-latest-versions

## Comando que verifica as atualizacoes das dependencias mas nao atualiza o pom.xml
* mvn versions:display-dependency-updates

## Comando que instala o jar no repositorio
* mvn install

## Comando para verificar a hierarquia de dependencias
* mvn dependency:tree
