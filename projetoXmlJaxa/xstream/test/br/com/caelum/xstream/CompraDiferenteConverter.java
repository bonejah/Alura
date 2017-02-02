package br.com.caelum.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CompraDiferenteConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.isAssignableFrom(Compra.class);
	}

	@Override
	public void marshal(Object valor, HierarchicalStreamWriter writer, MarshallingContext context) {
		Compra compra = (Compra) valor;
		writer.addAttribute("estilo", "novo");

		writer.startNode("id");
		writer.setValue(String.valueOf(compra.getId()));
		writer.endNode();

		writer.startNode("fornecedor");
		writer.setValue("bruno lima");
		writer.endNode();

		writer.startNode("produtos");
		context.convertAnother(compra.getProdutos());
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		String estilo = reader.getAttribute("estilo");

		reader.moveDown();
		String nomeId = reader.getNodeName();
		String valorId = reader.getValue();
		reader.moveUp();

		reader.moveDown();
		String fornecedor = reader.getValue();
		reader.moveUp();

		List<Produto> produtos = new ArrayList<>();
		int id = Integer.parseInt(valorId);
		Compra compra = new Compra(id, produtos);

		reader.moveDown();
		List<Produto> produtosConvertidos = (List<Produto>) context.convertAnother(compra, List.class);
		produtos.addAll(produtosConvertidos);
		reader.moveUp();

		return compra;
	}

}
