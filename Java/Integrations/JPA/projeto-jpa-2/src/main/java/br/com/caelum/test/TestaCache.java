package br.com.caelum.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TestaCache {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager(); // criando o segundo EntityManager
		
		Produto produto = em.find(Produto.class, 6);
        System.out.println("Nome: " + produto.getNome());
        
        Produto outroProduto = em2.find(Produto.class, 6);
        System.out.println("Nome: " + outroProduto.getNome());
        
        em.close();
        em2.close();
        emf.close();
        
        
	}
}
