package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		
		Conta conta = new Conta();
		conta.setId(2);
		
//		String jpql = "select m from Movimentacao m where m.conta = :pConta "
//				+ "and m.tipo = :pTipo order by m.valor desc";
		
//		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta "
//				+ "and m.tipo = :pTipo order by m.valor desc";
		
//		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta "
//				+ "and m.tipo = :pTipo order by m.valor desc";
		
//		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta "
//				+ "and m.tipo = :pTipo order by m.valor desc";
		
		String jpql = "select count(m) from Movimentacao m where m.conta = :pConta "
				+ "and m.tipo = :pTipo order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
//		List<Movimentacao> movimentacoes = query.getResultList();
//
//		for (Movimentacao movimentacao : movimentacoes) {
//			System.out.println("Descricao: " + movimentacao.getDescricao());
//			System.out.println("Conta.id: " + movimentacao.getConta().getId());
//		}
		
//		BigDecimal somaMediaMax = (BigDecimal) query.getSingleResult();
//		System.out.println("A soma é: " + somaMediaMax);
		
//		Double somaMediaMax = (Double) query.getSingleResult();
//		System.out.println("A media é: " + somaMediaMax);
		
//		BigDecimal somaMediaMax = (BigDecimal) query.getSingleResult();
//		System.out.println("O valor máximo é: " + somaMediaMax);
		
		Long qtde = (Long) query.getSingleResult();
		System.out.println("O quantidade é: " + qtde);

		em.getTransaction().commit();
		em.close();
	}

}
