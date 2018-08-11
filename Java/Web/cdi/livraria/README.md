# Project CDI 

```
Weld
O CDI é uma especificação, e por isso precisamos de alguém que implemente essa especificação para que seja possível utilizá-lo. 
A implementação de referência do CDI é o Weld. Portanto, vamos procurar a dependência do Weld.

http://www.mvnrepository.com/
dependência Weld Web: org.jboss.weld.servlet

http://docs.jboss.org/cdi/spec/1.2/cdi-spec-with-assertions.html#bean_archive

CDI
http://docs.jboss.org/cdi/spec/1.2/cdi-spec-with-assertions.html#builtin_scopes
Escoppos: AplicationScoped, SessionScoped, RequestScoped, ConversationScoped e Dependent
http://docs.jboss.org/cdi/spec/1.2/cdi-spec.html#dependent_context

A anotação @Named indica que conseguimos acessar nossos objetos através do nome. 
E usamos ela para podermos referenciar nossos objetos via Expression Language.
http://docs.jboss.org/cdi/spec/1.2/cdi-spec-with-assertions.html#names





```