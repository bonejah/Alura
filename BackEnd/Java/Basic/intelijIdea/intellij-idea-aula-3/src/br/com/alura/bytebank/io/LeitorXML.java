package br.com.alura.bytebank.io;

import br.com.alura.bytebank.model.Pagamento;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class LeitorXML extends Leitor implements LeitorPagamento {
    @Override
    public List<Pagamento> ler(int codigo) throws IOException {
        // implementação para ler XML
        return null;
    }

    public Iterator<Path> lista() throws IOException {
        return super.lista();
    }
}
