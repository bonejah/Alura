package br.com.alura.bytebank;

import br.com.alura.bytebank.model.Funcionario;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Seja bem-vindo ao ByteBank...");
        Funcionario bruno = new Funcionario("Bruno", 1, LocalDate.of(1981, 11,17));
        Funcionario leticia = new Funcionario("Leticia", 2, LocalDate.of(1984, 6,17));
        System.out.println(bruno);
        System.out.println(leticia);
    }
}
