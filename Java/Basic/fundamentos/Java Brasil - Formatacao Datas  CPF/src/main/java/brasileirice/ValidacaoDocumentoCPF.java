package brasileirice;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoDocumentoCPF {
	
	public static void main(String[] args) {
		String cpfValido = "86288366757";
		String cpfInvalido = "98745366797";
		String cpfValido2 = "22222222222";
		
		CPFValidator validador = new CPFValidator();
		
		try {
			validador.assertValid(cpfValido);
//			validador.assertValid(cpfValido2);
//			validador.assertValid(cpfInvalido);
			System.out.println("CPF VÁLIDO");
		} catch (InvalidStateException e) {
			System.out.println("CPF INVÁLIDO: " + e);
		}
		
	}

}
