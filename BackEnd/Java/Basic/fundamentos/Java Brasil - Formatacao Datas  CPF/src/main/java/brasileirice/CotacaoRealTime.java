package brasileirice;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.convert.ExchangeRateType;

public class CotacaoRealTime {

	public static void main(String[] args) {
		// Criando as moedas
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");

		MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
		MonetaryAmount valorImpostoReal = FastMoney.of(30, real);

		// Agora vamor usar o provider para pegar a cotação
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);

		// Vamos pegar a cotação atual do dia
		CurrencyConversion conversaoAtualDolar = provider.getCurrencyConversion(dolar);

		// Agora vamos transformar o valor do imposto em Real para dólar
		MonetaryAmount valorImpostoDolar = conversaoAtualDolar.apply(valorImpostoReal);

		// Agora que o valor do imposto está em dólar, podemos somar com o valor inicial
		// do produto
		MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);
		
		System.out.println("Valor do dolar: " + valorProdutoDolar);
		System.out.println("Valor do dolar com impostp: " + valorFinalProdutoDolar);
	}

}
