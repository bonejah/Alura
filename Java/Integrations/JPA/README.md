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
JPA: √â uma especifica√ß√£o presente no JavaEE respons√°vel em minimizar a dist√¢ncia entre o mundo OO e relacional.
Hibernate: O Hibernate √© uma das implementa√ß√µes que seguem a especifica√ß√£o JPA. Existem outras implementa√ß√µes como o OpenJPA e o EclipseLink.

Dialeto: Serve como forma de escolhermos recursos do banco que ser√£o usados como por exemplo no MySQL onde podemos utilizar o MyISAM (storage strategy) que n√£o possuem transa√ß√µes e integridade referencial (foreign key constraint).

Estados JPA
 - Transient: Dados n√£o existem no banco e nem s√£o sincronizados com o banco. A n√£o ser que utilizemos o m√©todo persist (que transforma o estado do objeto em Managed).
 
 - Managed: Dados s√£o automaticamente sincronizados com o banco enquanto o EntityManager estiver aberto (m√©todo persist).
 
 - Detached: Dados existem no banco de dados por√©m o objeto n√£o √© mais gerenciado pela JPA (m√©todo merge).
 
 - Remove: Remove um objeto do banco de dados (m√©todo remove) por√©m ele continua existindo na mem√≥ria. 
 
Cardinalidades:
 - @ManyToOne: JPA cria um id na tabela que utiliza esse relacionamento
 - @ManyToMany: JPA Cria uma tabela de relacionamento entre as entidades
 - @OneToOne: √â necess√°rio utilizar a anota√ß√£o @JoinColumn(unique=true) para garantir a unicidade
 - @OneToMany: Reflete a entidade que possui a anotacao @ManyToOne, se faz necessario o uso de mappedBy (espelho) na entidade fraca para indicar a JPA que trata-se de um mesmo relacionamento

Lazy Loading
	Por padr√£o todos os relacionamentos [...]ToMany s√£o Lazy;
	Torna mais f√°cil o problema do N + 1 (Aten√ß√£o: tamb√©m √© poss√≠vel ter N + 1 com Eager!);
	Usamos o join fetch para carregar o relacionamento de forma Eager (em uma mesma query) ao usarmos JPQL.

Join e produto cartesiano
	Ao usarmos join fetch, os resultados aparecem duplicados devido ao produto cartesiano. Para evit√°-los, utilizamos a palavra-chave distinct;
	O join fetch dispara um inner join no banco, o que acaba trazendo apenas as contas com movimenta√ß√£o. Por isso usamos left join fetch, que trar√° todos os dados da entidade que se encontram ao lado esquerdo do join (no caso,
 
 https://github.com/uaihebert/uaicriteria 
 
 
C3PO (http://www.mchange.com/projects/c3p0/): 
 O Hibernate j· possui um pool nativo de conexıes com o banco, que n„o deve ser usado em produÁ„o. Existem diversas implementaÁıes no mercado alÈm de servidores de AplicaÁ„o (JBoss WildFly) e Servlet Containers (Apache Tomcat) que possuem implementaÁıes sofisticadas de pool de conexıes. No nosso caso, vamos utilizar o C3P0 que È [indicado pela prÛpria documentaÁ„o do Hibernate][1].
 
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
 O EntityManager possui um mÈtodo lock para usar o Lock Pessimista;]
 Lock otimista n„o trava o registro mas verifica se a atualizaÁ„o È possÌvel;
 Lock otimista joga uma exceÁ„o no caso de alteraÁ„o concorrente; 
 O que fazemos È colocar um atributo de versionamento no modelo . Qualquer alteraÁ„o feita gerar·, automaticamente, o  incremento deste atributo. Caso alguÈm tente enviar um valor inferior ao que est· salvo no banco, receber· uma javax.persistence.OptimisticLockException. 
 
Cache (http://www.ehcache.org/documentation/2.8/configuration/configuration.html):
 O cache de primeiro nÌvel È o cache que vem por padr„o nos EntityManagers. Ele nos impede de carregar duas vezes a mesma entidade do banco e, dessa forma, evita um acesso desnecess·rio.

 O problema de utilizarmos o cache de primeiro nÌvel da nossa aplicaÁ„o È que nÛs j· configuramos que seja criado um novo EntityManager a cada requisiÁ„o. Ou seja, como cada requisiÁ„o possuÌ o seu prÛprio EntityManager e cada um destes o seu prÛprio cache, os dados do cache acabam se perdendo quando a requisiÁ„o termina, alÈm de, n„o serem reaproveitados entre requisiÁıes. 
 
Statistics:
 http://blog.caelum.com.br/cacando-seus-gargalos-com-o-hibernate-statistics/
 http://docs.jboss.org/hibernate/core/4.3/javadocs/org/hibernate/stat/Statistics.html
 http://blog.caelum.com.br/os-7-habitos-dos-desenvolvedores-hibernate-e-jpa-altamente-eficazes/
  

``