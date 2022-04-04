package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {

			throw new IllegalArgumentException("Funcion�rios com sal�rio maior que R$ 10000,00 n�o podem receber b�nus.");
		}
		return valor;
	}

}
