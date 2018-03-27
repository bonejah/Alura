public class TesteTributaveis {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(122, 233);
		cc.deposita(1000);
		
		SeguroDeVida seguroDeVida = new SeguroDeVida();
		
		CalculadorDeImposto calculadorDeImposto = new CalculadorDeImposto();
		calculadorDeImposto.registra(cc);
		calculadorDeImposto.registra(seguroDeVida);
		
		System.out.println(calculadorDeImposto.getTotalImposto());
	}
}
