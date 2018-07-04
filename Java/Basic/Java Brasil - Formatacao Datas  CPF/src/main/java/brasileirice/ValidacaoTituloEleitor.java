package brasileirice;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.Validator;

public class ValidacaoTituloEleitor {
	
	public static void main(String[] args) {
		String tituloEleitor = "417453530116";
		
//		TituloEleitoralValidator validador = new TituloEleitoralValidator();
		Validator validador = new TituloEleitoralValidator();
		
		try {
			validador.assertValid(tituloEleitor);
			System.out.println("TITULO VÁLIDO");
		} catch (InvalidStateException e) {
			System.out.println("TITULO INVÁLIDO: " + e);
		}
		
	}

}
