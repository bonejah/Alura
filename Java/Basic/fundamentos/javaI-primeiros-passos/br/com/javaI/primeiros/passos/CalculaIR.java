package br.com.javaI.primeiros.passos;

public class CalculaIR {
	public static void main(String[] args) {
		double salario = 3751.1;

		if (salario >= 1900.0 && salario <= 2800.0) {
			System.out.println("O IR será de 7.5% e o valor a deduzir será de R$142,00");
		} else if (salario >= 2800.01 && salario <= 3751.0) {
			System.out.println("O IR será de 15% e o valor a deduzir será de R$350,00");
		} else if (salario >= 3751.01 && salario <= 4664.00) {
			System.out.println("O IR será de 22.5% e o valor a deduzir será de R$636,00");
		}
	}
}
