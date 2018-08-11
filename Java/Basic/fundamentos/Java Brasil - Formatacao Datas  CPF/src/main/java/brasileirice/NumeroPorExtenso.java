package brasileirice;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class NumeroPorExtenso {

	public static void main(String[] args) {
		NumericToWordsConverter conversorInteiro = new NumericToWordsConverter(new InteiroSemFormato());
		double valorDouble = 75.00;
		System.out.println("Valor de valorDouble: " + valorDouble);
		System.out.println("Valor de valorDouble por extenso: " + conversorInteiro.toWords(valorDouble) + " reais");

		BigDecimal valorBigDecimal = new BigDecimal("75.00");
		System.out.println("Valor de valorBigDecimal: " + valorBigDecimal);
		System.out.println("Valor de valorBigDecimal por extenso: "
				+ conversorInteiro.toWords(valorBigDecimal.doubleValue()) + " reais");
		
		System.out.println("-------------------------------------------------------");
		
		NumericToWordsConverter conversorReal = new NumericToWordsConverter(new FormatoDeReal());
		BigDecimal valorBigDecimalRealSingular = new BigDecimal("1");
		System.out.println("Valor de valorBigDecimalReal: " + valorBigDecimalRealSingular);
		System.out.println("Valor de valorBigDecimalReal por extenso: "
				+ conversorReal.toWords(valorBigDecimalRealSingular.doubleValue()));
		
		BigDecimal valorBigDecimalRealPlural = new BigDecimal("75.00");
		System.out.println("Valor de valorBigDecimalReal: " + valorBigDecimalRealPlural);
		System.out.println("Valor de valorBigDecimalReal por extenso: "
				+ conversorReal.toWords(valorBigDecimalRealPlural.doubleValue()));

		
	}
}
