package br.com.alura.bytebank.model;

import java.time.LocalDate;

public class Gerente extends  Funcionario{
    private double bonus;

    public Gerente(String nome, int matricula, LocalDate dataNascimento, double bonus, String usuario, String senha) {
        super(nome, matricula, dataNascimento, senha, usuario);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
