package brasileirice;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

public class Cep {

	public static void main(String[] args) throws Exception {
		ViaCEPClient viaCEPClient = new ViaCEPClient();
		ViaCEPEndereco endereco = viaCEPClient.getEndereco("01512010");
		System.out.println(endereco.getLogradouro());
	}
}
