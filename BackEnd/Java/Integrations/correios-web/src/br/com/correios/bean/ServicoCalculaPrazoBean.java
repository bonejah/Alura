package br.com.correios.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.correios.model.TipoServico;
import br.com.correios.soap.CResultado;
import br.com.correios.soap.CServico;
import br.com.correios.soap.CalcPrazo;
import br.com.correios.soap.CalcPrecoPrazoWS;
import br.com.correios.soap.CalcPrecoPrazoWSSoap;

@ManagedBean
public class ServicoCalculaPrazoBean {
	private CalcPrazo calcPrazo;
	private CalcPrecoPrazoWSSoap wsSoap;
	private List<CServico> listServicos;

	public ServicoCalculaPrazoBean() {
		this.calcPrazo = new CalcPrazo();
		this.wsSoap = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
		this.listServicos = new ArrayList<CServico>();
	}
	
	public List<CServico> calculaPrazo() {
		System.out.println("Chamando o serviço calculaPrazo");
		CResultado resultado = wsSoap.calcPrazo(calcPrazo.getNCdServico(), calcPrazo.getSCepOrigem(), calcPrazo.getSCepDestino());
		listServicos = resultado.getServicos().getCServico();
		System.out.println(listServicos);
		return listServicos;
	}
	
	public List<TipoServico> getTiposCdServico(){
		List<TipoServico> listaServicos = new ArrayList<TipoServico>();
		TipoServico tipoServico1 = new TipoServico(new Long(40010), "SEDEX Varejo");
		TipoServico tipoServico2 = new TipoServico(new Long(40045), "SEDEX a Cobrar Varejo");
		TipoServico tipoServico3 = new TipoServico(new Long(40215), "SEDEX 10 Varejo");
		TipoServico tipoServico4 = new TipoServico(new Long(40290), "SEDEX Hoje Varejo");
		TipoServico tipoServico5 = new TipoServico(new Long(41106), "PAC Varejo");
		
		listaServicos.add(tipoServico1);
		listaServicos.add(tipoServico2);
		listaServicos.add(tipoServico3);
		listaServicos.add(tipoServico4);
		listaServicos.add(tipoServico5);
		
		return listaServicos;
	}

	public CalcPrazo getCalcPrazo() {
		return calcPrazo;
	}
	
	public void setCalcPrazo(CalcPrazo calcPrazo) {
		this.calcPrazo = calcPrazo;
	}

	public CalcPrecoPrazoWSSoap getWsSoap() {
		return wsSoap;
	}

	public void setWsSoap(CalcPrecoPrazoWSSoap wsSoap) {
		this.wsSoap = wsSoap;
	}

	public List<CServico> getListServicos() {
		return listServicos;
	}

	public void setListServicos(List<CServico> listServicos) {
		this.listServicos = listServicos;
	}
}
