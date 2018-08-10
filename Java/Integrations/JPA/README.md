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
 
 https://github.com/uaihebert/uaicriteria 
 
 
C3PO (http://www.mchange.com/projects/c3p0/): 
 O Hibernate j� possui um pool nativo de conex�es com o banco, que n�o deve ser usado em produ��o. Existem diversas implementa��es no mercado al�m de servidores de Aplica��o (JBoss WildFly) e Servlet Containers (Apache Tomcat) que possuem implementa��es sofisticadas de pool de conex�es. No nosso caso, vamos utilizar o C3P0 que � [indicado pela pr�pria documenta��o do Hibernate][1].
 
 Configurando no persistence.xml:
 Hibernate 3:
 <property name="hibernate.connection.provider_class"   value="org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider">
 <property name="hibernate.c3p0.min_size" value="5" />
 <property name="hibernate.c3p0.max_size" value="20" />
 <property name="hibernate.c3p0.timeout" value="180" />
 
 Hibernate 4:
 <property name="hibernate.connection.provider_class" value="org.hibernate.c3p0.internal.C3P0ConnectionProvider">
 <property name="hibernate.c3p0.min_size" value="5" /> 
 <property name="hibernate.c3p0.max_size" value="20" />
 <property name="hibernate.c3p0.timeout" value="180" />
 
 Pom.xml
 <dependency>
    <groupId>c3p0</groupId>
    <artifactId>c3p0</artifactId>
    <version>x.x.x</version>
</dependency>
 
Locks Otimista/Pessimista: 
 Lock pessimista trava o registro impedindo acesso concorrente;
 O EntityManager possui um m�todo lock para usar o Lock Pessimista;]
 Lock otimista n�o trava o registro mas verifica se a atualiza��o � poss�vel;
 Lock otimista joga uma exce��o no caso de altera��o concorrente; 
 O que fazemos � colocar um atributo de versionamento no modelo . Qualquer altera��o feita gerar�, automaticamente, o  incremento deste atributo. Caso algu�m tente enviar um valor inferior ao que est� salvo no banco, receber� uma javax.persistence.OptimisticLockException. 
 
Cache (http://www.ehcache.org/documentation/2.8/configuration/configuration.html):
 O cache de primeiro n�vel � o cache que vem por padr�o nos EntityManagers. Ele nos impede de carregar duas vezes a mesma entidade do banco e, dessa forma, evita um acesso desnecess�rio.

 O problema de utilizarmos o cache de primeiro n�vel da nossa aplica��o � que n�s j� configuramos que seja criado um novo EntityManager a cada requisi��o. Ou seja, como cada requisi��o possu� o seu pr�prio EntityManager e cada um destes o seu pr�prio cache, os dados do cache acabam se perdendo quando a requisi��o termina, al�m de, n�o serem reaproveitados entre requisi��es. 
 
Statistics:
 http://blog.caelum.com.br/cacando-seus-gargalos-com-o-hibernate-statistics/
 http://docs.jboss.org/hibernate/core/4.3/javadocs/org/hibernate/stat/Statistics.html
 http://blog.caelum.com.br/os-7-habitos-dos-desenvolvedores-hibernate-e-jpa-altamente-eficazes/
  

``