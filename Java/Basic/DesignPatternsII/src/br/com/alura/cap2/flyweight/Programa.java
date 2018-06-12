package br.com.alura.cap2.flyweight;

import java.util.Arrays;
import java.util.List;

public class Programa {
	
	// http://www.jfugue.org/download.html
	
	public static void main(String[] args) {
		NotasMusicais notasMusicais = new NotasMusicais();
		
		List<Nota> doReMiFaFaFa = Arrays.asList(
			notasMusicais.pega("do"),
			notasMusicais.pega("re"),
			notasMusicais.pega("mi"),
			notasMusicais.pega("fa"),
			notasMusicais.pega("fa"),
			notasMusicais.pega("fa"),
			
			notasMusicais.pega("do"),
			notasMusicais.pega("re"),
			notasMusicais.pega("do"),
			notasMusicais.pega("re"),
			notasMusicais.pega("re"),
			notasMusicais.pega("re"),
			
			notasMusicais.pega("do"),    
            notasMusicais.pega("sol"),    
            notasMusicais.pega("fa"),    
            notasMusicais.pega("mi"),    
            notasMusicais.pega("mi"),    
            notasMusicais.pega("mi"),

            notasMusicais.pega("do"),    
            notasMusicais.pega("re"),    
            notasMusicais.pega("mi"),    
            notasMusicais.pega("fa"),    
            notasMusicais.pega("fa"),    
            notasMusicais.pega("fa"));
		
		
		Piano piano = new Piano();
		piano.toca(doReMiFaFaFa);
	}	
}
