
public class TesteContas {
	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente(111, 111);
		contaCorrente.deposita(100.00);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(222, 222);
		contaPoupanca.deposita(100.00);
		
		contaCorrente.transfere(10.0, contaPoupanca);
		
		System.out.println("CC: " + contaCorrente.getSaldo());
		System.out.println("CP: " + contaPoupanca.getSaldo());
		
		contaCorrente.saca(10.0);
		System.out.println("CC: " + contaCorrente.getSaldo());
	}
}
