package br.com.caelum.collections;

import java.util.Comparator;

public class OrdenaPorIdade implements Comparator<Funcionario>{
	public int compare(Funcionario funcionario, Funcionario outroFuncionario) {
        return funcionario.getIdade() - outroFuncionario.getIdade();
    }
}
