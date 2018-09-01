package brasileirice;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoDocumentoCNPJ {
	
	public static void main(String[] args) {
		String cnpj = "82588641000173";
		
		CNPJValidator validador = new CNPJValidator();
		
		try {
			validador.assertValid(cnpj);
			System.out.println("CNPJ VÁLIDO");
		} catch (InvalidStateException e) {
			System.out.println("CNPJ INVÁLIDO: " + e);
		}
		
	}

}
