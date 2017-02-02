package br.com.caelum.xstream;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.SingleValueConverter;

public class PrecoSimplesConverter implements SingleValueConverter {

	@Override
	public boolean canConvert(Class type) {
		return type.isAssignableFrom(Double.class);
	}

	@Override
	public Object fromString(String valor) {
		NumberFormat formatter = getFormatador();
		try {
			return formatter.parse(valor);
		} catch (ParseException e) {
			throw new ConversionException("não consegui converter", e);
		}
	}

	private NumberFormat getFormatador() {
		Locale brasil = new Locale("pt", "br");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(brasil);
		return formatter;
	}

	@Override
	public String toString(Object value) {
		return getFormatador().format(value);
	}

}
