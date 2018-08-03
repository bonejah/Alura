package br.com.listavipspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(value = "br.com.listavipspringboot.models")
public class Configuration {

	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}
	
//	@Bean
//	public DataSource dataSource(){
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("");
//	    
//	    return dataSource;
//	}
	
//	@Bean
//	public DataSource dataSource(){
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//	    return dataSource;
//	}
	
}
