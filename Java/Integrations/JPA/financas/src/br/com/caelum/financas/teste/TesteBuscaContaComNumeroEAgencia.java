package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.ContaComNumeroEAgencia;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaContaComNumeroEAgencia {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String jpql = "select new br.com.caelum.financas.modelo.ContaComNumeroEAgencia(c.numero, c.agencia) from Conta c";
		Query query = em.createQuery(jpql, ContaComNumeroEAgencia.class);

		List<ContaComNumeroEAgencia> contas = query.getResultList();

		for (ContaComNumeroEAgencia conta : contas) {
			System.out.println(conta.getAgencia());
			System.out.println(conta.getNumero());
		}

		em.getTransaction().commit();
		em.close();

	}

}
