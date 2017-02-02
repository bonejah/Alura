import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		System.out.println("Antes da ordenação: " + palavras);
		// Collections.sort(palavras, comparador);
		// Java 8
		// Exemplo Lambda
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		Function<String, Integer> funcao = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparator = Comparator.comparing(funcao);
		palavras.sort(comparator);

		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		palavras.sort(String.CASE_INSENSITIVE_ORDER);

		System.out.println("Depois da ordenação: " + palavras);

		for (

		String palavra : palavras)

		{
			System.out.println(palavra);
		}

		// Java8
		/*
		 * palavras.forEach(new Consumer<String>() {
		 * 
		 * @Override public void accept(String t) { System.out.println(t); } });
		 */

		// Exemplo Lambda
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
	}
}
