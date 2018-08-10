# Projects using JPA

*Installation
```
JDK1.8
http://www.oracle.com/technetwork/java/javase/downloads/index.html

Eclipse
http://www.eclipse.org/downloads/

Persistence XML
https://s3.amazonaws.com/caelum-online-public/jpa-v2/files/persistence.xml

Hibernate
http://hibernate.org/

Driver MYSQL
http://dev.mysql.com/downloads/connector/j/
```

*Concepts
```
JPA: É uma especificação presente no JavaEE responsável em minimizar a distância entre o mundo OO e relacional.
Hibernate: O Hibernate é uma das implementações que seguem a especificação JPA. Existem outras implementações como o OpenJPA e o EclipseLink.

Dialeto: Serve como forma de escolhermos recursos do banco que serão usados como por exemplo no MySQL onde podemos utilizar o MyISAM (storage strategy) que não possuem transações e integridade referencial (foreign key constraint).

Estados JPA
 - Transient: Dados não existem no banco e nem são sincronizados com o banco. A não ser que utilizemos o método persist (que transforma o estado do objeto em Managed).
 
 - Managed: Dados são automaticamente sincronizados com o banco enquanto o EntityManager estiver aberto (método persist).
 
 - Detached: Dados existem no banco de dados porém o objeto não é mais gerenciado pela JPA (método merge).
 
 - Remove: Remove um objeto do banco de dados (método remove) porém ele continua existindo na memória. 
 
Cardinalidades:
 - @ManyToOne: JPA cria um id na tabela que utiliza esse relacionamento
 - @ManyToMany: JPA Cria uma tabela de relacionamento entre as entidades
 - @OneToOne: É necessário utilizar a anotação @JoinColumn(unique=true) para garantir a unicidade
 - @OneToMany: Reflete a entidade que possui a anotacao @ManyToOne, se faz necessario o uso de mappedBy (espelho) na entidade fraca para indicar a JPA que trata-se de um mesmo relacionamento

Lazy Loading
	Por padrão todos os relacionamentos [...]ToMany são Lazy;
	Torna mais fácil o problema do N + 1 (Atenção: também é possível ter N + 1 com Eager!);
	Usamos o join fetch para carregar o relacionamento de forma Eager (em uma mesma query) ao usarmos JPQL.

Join e produto cartesiano
	Ao usarmos join fetch, os resultados aparecem duplicados devido ao produto cartesiano. Para evitá-los, utilizamos a palavra-chave distinct;
	O join fetch dispara um inner join no banco, o que acaba trazendo apenas as contas com movimentação. Por isso usamos left join fetch, que trará todos os dados da entidade que se encontram ao lado esquerdo do join (no caso,
 

``