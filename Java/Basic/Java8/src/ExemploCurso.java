import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private Integer quantidadeAlunos;

	public Curso(String nome, Integer quantidadeAlunos) {
		this.nome = nome;
		this.quantidadeAlunos = quantidadeAlunos;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	@Override
	public String toString() {
		return "Nome curso: " + getNome() + " qtdeAlunos: " + getQuantidadeAlunos();
	}

}

public class ExemploCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Java", 100));
		cursos.add(new Curso("Ruby", 10));
		cursos.add(new Curso("C", 1));
		cursos.add(new Curso("PHP", 0));

		// cursos.sort(Comparator.comparing(c -> c.getQuantidadeAlunos()));
		// cursos.sort(Comparator.comparing(Curso::getQuantidadeAlunos));
		// cursos.forEach(c -> System.out.println(c.getNome()));

		/*
		 * cursos.stream().filter(c -> c.getQuantidadeAlunos() > 50).map(c ->
		 * c.getQuantidadeAlunos() + " " + c.getNome()) .forEach(total ->
		 * System.out.println(total));
		 * 
		 * Stream<String> nomes = cursos.stream().map(Curso::getNome);
		 */
		/*
		 * Optional<Curso> optionalCurso = cursos.stream().filter(c ->
		 * c.getQuantidadeAlunos() > 10).findAny(); Curso curso =
		 * optionalCurso.orElse(null); System.out.println(curso.getNome());
		 */

		// optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

		cursos = cursos.stream().filter(c -> c.getQuantidadeAlunos() > 1).collect(Collectors.toList());
		cursos.forEach(System.out::println);

		Map<String, Integer> map = cursos.stream().filter(c -> c.getQuantidadeAlunos() > 1)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getQuantidadeAlunos()));

		System.out.println(map);

		Double resultado = cursos.stream().collect(Collectors.averagingLong(c -> c.getQuantidadeAlunos()));
		System.out.println("Media: " + resultado);

		OptionalDouble resultado2 = cursos.stream().mapToInt(c -> c.getQuantidadeAlunos()).average();
		System.out.println("Media2: " + resultado);

	}
}
