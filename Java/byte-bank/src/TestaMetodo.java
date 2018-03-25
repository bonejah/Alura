public class TestaMetodo {
	public static void main(String[] args) {
		Conta contaDoBruno = new Conta();
		contaDoBruno.saldo = 100;
		contaDoBruno.deposita(50);
		System.out.println("Valor conta Bruno " + contaDoBruno.saldo);
		
		boolean conseguiuSacar = contaDoBruno.saca(15);
		System.out.println("Valor conta Bruno depois do saque " + contaDoBruno.saldo);
		System.out.println("Bruno Conseguiu sacar? " + conseguiuSacar);
		
		Conta contaDaLeticia = new Conta();
		contaDaLeticia.deposita(1000);
		System.out.println("Valor conta Leticia " + contaDaLeticia.saldo);
		
		contaDaLeticia.transfere(300, contaDoBruno);
		System.out.println("Valor conta Leticia depois da transferência para conta Bruno: " + contaDaLeticia.saldo);
		System.out.println("Valor conta Bruno " + contaDoBruno.saldo);
		
		contaDoBruno.titular = "Bruno";
		System.out.println(contaDoBruno.titular);
	}
}
