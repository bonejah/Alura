# Project Contas using Spring MVC


* Setup
```
http://www.springsource.org/

web.xml add content below:

<servlet>
  <servlet-name>Spring MVC Dispatcher Servlet</servlet-name>
  <servlet-class>
    org.springframework.web.servlet.DispatcherServlet
  </servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
      /WEB-INF/spring-context.xml
    </param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
  <servlet-name>Spring MVC Dispatcher Servlet</servlet-name>
  <url-pattern>/</url-pattern>
</servlet-mapping>

enable annotation Spring on Project add content below on spring-context.xml:

<mvc:annotation-driven />
<context:component-scan base-package="br.com.caelum.contas" />

the configuration below tells Spring where it should fetch the jsp files:

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix" value="/WEB-INF/views/"/>
	<property name="suffix" value=".jsp"/>
</bean>

to create the schema, access this url: http://localhost:8080/contas/tabelas
```


* Links
```
http://vard-lokkur.blogspot.com.br/2012/02/spring-mvc-flash-attributes.html
http://blog.caelum.com.br/java-ee-6-comecando-com-bean-validation/
http://docs.spring.io/spring/docs/4.3.0.RC2/spring-framework-reference/htmlsingle/#beans-stereotype-annotations
http://docs.spring.io/spring/docs/4.3.0.RC2/spring-framework-reference/htmlsingle/#orm-exception-translation

```
