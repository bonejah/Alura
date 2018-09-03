package br.com.caelum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
//		return em.createQuery("from Produto", Produto.class).getResultList();
		
		// A solução abaixo resolve o problema do Lazy Load, pois o join fetch carrega os relacionamentos
		 return em.createQuery("select distinct p from Produto p join fetch p.categorias", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id); 
//		Produto produto = em.find(Produto.class, id, LockModeType.PESSIMISTIC_READ); // Trava o registro
		return produto;
	}

	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);

		Path<String> nomePath = root.<String> get("nome");
		Path<Integer> lojaPath = root.<Loja> get("loja").<Integer> get("id");
		Path<Integer> categoriaPath = root.join("categorias").<Integer> get("id");

		//List<Predicate> predicates = new ArrayList<>();
		Predicate conjuncao = criteriaBuilder.conjunction();

		if (!nome.isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, "%" + nome + "%");
			//predicates.add(nomeIgual);
			conjuncao = criteriaBuilder.and(nomeIgual);
		}
		if (categoriaId != null) {
			Predicate categoriaIgual = criteriaBuilder.equal(categoriaPath, categoriaId);
			//predicates.add(categoriaIgual);
			conjuncao = criteriaBuilder.and(conjuncao, criteriaBuilder.equal(categoriaPath, categoriaId));
		}
		if (lojaId != null) {
			Predicate lojaIgual = criteriaBuilder.equal(lojaPath, lojaId);
			//predicates.add(lojaIgual);
			conjuncao = criteriaBuilder.and(conjuncao, criteriaBuilder.equal(lojaPath, lojaId));
		}

		//query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		
		//TypedQuery<Produto> typedQuery = em.createQuery(query);
		TypedQuery<Produto> typedQuery = em.createQuery(query.where(conjuncao));
		typedQuery.setHint("org.hibernate.cacheable", "true");
		return typedQuery.getResultList();

	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
