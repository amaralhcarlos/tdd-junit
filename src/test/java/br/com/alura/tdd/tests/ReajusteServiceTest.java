package br.com.alura.tdd.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Provider.Service;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {

	private Funcionario funcionario;
	private ReajusteService reajusteService;

	@BeforeEach
	public void inicializar() {

		this.funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal(1000.00));
		this.reajusteService = new ReajusteService();

	}

	@Test
	public void reajusteDeveSerDeTresPorcentoParaDesempenhoADesejar() {
		reajusteService.calcularReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal(1030.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());

	}

	@Test
	public void reajusteDeveSerDeQuinzePorcentoParaDesempenhoBom() {
		reajusteService.calcularReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal(1150.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveSerDeVintePorcentoParaDesempenhoOtimo() {
		reajusteService.calcularReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal(1200.00).setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());

	}

}
