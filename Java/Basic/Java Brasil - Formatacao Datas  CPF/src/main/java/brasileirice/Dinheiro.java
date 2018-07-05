package brasileirice;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class Dinheiro {

	public static void main(String[] args) {
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");

		MonetaryAmount valorDaParcelaDolar = Money.of(75, dolar);
		System.out.println(valorDaParcelaDolar);

		MonetaryAmount valorDaParcelaReal = Money.of(75, real);
		System.out.println(valorDaParcelaReal);

		MonetaryAmount valorDaParcelaRealMultiplicadoPorDoze = valorDaParcelaReal.multiply(12);
		System.out.println(valorDaParcelaRealMultiplicadoPorDoze);
		
		MonetaryAmount desconto = valorDaParcelaRealMultiplicadoPorDoze.with(MonetaryOperators.percent(10));
		System.out.println(desconto);
		
		NumberValue descontoSemMoeda = desconto.getNumber();
		
		NumericToWordsConverter conversorReal = new NumericToWordsConverter(new FormatoDeReal());
		String valorPorExtenso = conversorReal.toWords(descontoSemMoeda.doubleValue());
		System.out.println(valorPorExtenso);
	}

}
