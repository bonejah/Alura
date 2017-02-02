import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);

		Period periodo = Period.between(hoje, olimpiadasRio);
		System.out.println("Diferença meses: " + periodo.getMonths() + " dias: " + periodo.getDays());

		System.out.println(olimpiadasRio);
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatter.format(proximasOlimpiadas));

		DateTimeFormatter formatterComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatterComHoras));
		System.out.println(formatterComHoras.format(agora));

		LocalTime intervalo = LocalTime.of(13, 39);
		System.out.println(intervalo);
	}

}
