package brasileirice;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;

public class FormataDocumentos {

	public static void main(String[] args) {
		String cpf = "86288366757";
		String cnpj = "82588641000173";
		String tituloEleitor = "417453530116";

		System.out.println("CPF formatado: " + formataDocumentos(new CPFFormatter(), cpf));
		System.out.println("CNPJ formatado: " + formataDocumentos(new CNPJFormatter(), cnpj));
		System.out.println(
				"Titulo Eleitor formatado: " + formataDocumentos(new TituloEleitoralFormatter(), tituloEleitor));

		System.out.println("---------------------------------------------------");

		System.out.println("CPF unformatado: " + unFormataDocumentos(new CPFFormatter(), cpf));
		System.out.println("CNPJ unformatado: " + unFormataDocumentos(new CNPJFormatter(), cnpj));
		System.out.println(
				"Titulo Eleitor unformatado: " + unFormataDocumentos(new TituloEleitoralFormatter(), tituloEleitor));

	}

	private static String formataDocumentos(Formatter formatter, String documento) {
		String documentoFormatado = formatter.format(documento);
		return documentoFormatado;
	}

	private static String unFormataDocumentos(Formatter formatter, String documento) {
		String documentoUnFormatado = formatter.unformat(documento);
		return documentoUnFormatado;
	}

}
