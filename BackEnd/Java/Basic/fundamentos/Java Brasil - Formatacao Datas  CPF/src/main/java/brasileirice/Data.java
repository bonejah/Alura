package brasileirice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Data {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println("Data: " + hoje);
		
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Data com formatação: " + hoje.format(dtFormatter));
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println("Agora: " + agora);
		
		DateTimeFormatter agoraFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println("Agora com formatação: " + agora.format(agoraFormatter));
		
		DateTimeFormatter dtFormatterCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println("Agora com formatação curta: " + agora.format(dtFormatterCurto));
		
		DateTimeFormatter dtFormatterMedioSemLocale = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println("Agora com formatação média sem Locale: " + agora.format(dtFormatterMedioSemLocale));

		DateTimeFormatter dtFormatterMedioComLocaleBR = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt", "br"));
		System.out.println("Agora com formatação média com Locale: " + agora.format(dtFormatterMedioComLocaleBR));
		
		System.out.println("Agora removendo 2 horas: " + agora.minusHours(2).format(dtFormatterMedioComLocaleBR));
		System.out.println("Agora adicionando 7 horas: " + agora.plusHours(7).format(dtFormatterMedioComLocaleBR));
		
		
	} 
}
