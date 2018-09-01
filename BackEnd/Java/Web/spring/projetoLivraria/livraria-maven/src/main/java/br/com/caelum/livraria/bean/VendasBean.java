package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;
import br.com.caelum.livraria.tx.Log;

@Named
@SessionScoped
public class VendasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@Log
	public List<Venda> getVendas(){
		List<Venda> vendas = this.manager.createQuery("select v from Venda v", Venda.class).getResultList();		
		return vendas;
	}
	
	@Log
	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		model.setAnimate(true);

	    ChartSeries vendaSerie = new ChartSeries();
	    vendaSerie.setLabel("Vendas 2016");

	    List<Venda> vendas = getVendas();

	    for (Venda venda : vendas) {
	        vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
	    }

	    model.addSeries(vendaSerie);

	    ChartSeries vendaSerie2015 = new ChartSeries();
	    vendaSerie2015.setLabel("Vendas 2015");

	    vendas = getVendas();

	    for (Venda venda : vendas) {
	        vendaSerie2015.set(venda.getLivro().getTitulo(),
	                venda.getQuantidade());
	    }

	    model.addSeries(vendaSerie2015);

	    return model;
	}
}
