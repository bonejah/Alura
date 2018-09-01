package br.com.correios.client.test;

import java.math.BigDecimal;
import java.util.List;

import br.com.correios.client.soap.CResultado;
import br.com.correios.client.soap.CServico;
import br.com.correios.client.soap.CalcPrecoPrazoWS;
import br.com.correios.client.soap.CalcPrecoPrazoWSSoap;

public class TestaCalcPrecoPrazo {
	public static void main(String[] args) {
		String codigoSedex = "40010";
		String cepOrigemCaelumSP = "04101300"; //Caelum SP
		String cepDestino = "03632010"; // Caelum RJ
		String peso3kg = "3";
		BigDecimal comprimento20cm = new BigDecimal(20);
		BigDecimal altura10cm = new BigDecimal(10);
		BigDecimal largura15cm = new BigDecimal(15);
		BigDecimal diametro10cm = new BigDecimal(10);
		int formatoEncomendaCaixa = 1; // 1 é caixa ou pacote
		BigDecimal semValorDeclarado= BigDecimal.ZERO;
		String semEntregueEmMaos = "N";
		String semAvisoRecebimento = "N";
		String semCodigoEmpresa = "";
		String semSenhaEmpresa = "";
		
		CalcPrecoPrazoWSSoap cliente = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
		
		/*cliente.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
		cliente.calcPrazoData(nCdServico, sCepOrigem, sCepDestino, sDtCalculo);
		cliente.calcPrazoRestricao(nCdServico, sCepOrigem, sCepDestino, sDtCalculo);
		cliente.calcPreco(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
		cliente.calcPrecoData(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);
		cliente.calcPrecoFAC(nCdServico, nVlPeso, strDataCalculo);
		cliente.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
		cliente.calcPrecoPrazoData(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);
		cliente.calcPrecoPrazoRestricao(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento, sDtCalculo);*/
		
		
		//fazendo a chamada do serviço
		CResultado resultado = cliente.calcPrecoPrazo(
		                semCodigoEmpresa, semSenhaEmpresa, 
		                codigoSedex, cepOrigemCaelumSP, cepDestino, 
		                peso3kg, formatoEncomendaCaixa, 
		                comprimento20cm, altura10cm, largura15cm, diametro10cm, 
		                semEntregueEmMaos, semValorDeclarado, semAvisoRecebimento);

		//recuperando o resultado
		List<CServico> servicosPesquisados = resultado.getServicos().getCServico();
		String valorFrete = servicosPesquisados.get(0).getValor();

		System.out.printf("Frete para %s eh de %s %n", cepDestino, valorFrete);
	}
}
