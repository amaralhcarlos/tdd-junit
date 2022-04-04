package br.com.alura.tdd.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

	@Test
	public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {

		BonusService bonusService = new BonusService();

		Funcionario funcionario = new Funcionario("Carlos", LocalDate.of(2021, 05, 10), new BigDecimal(12000.0));


		BigDecimal bonus = new BigDecimal(0.0);
		
		try {
			
			bonus = bonusService.calcularBonus(funcionario);
			
			fail("Não deu a exceção.");
			
		}catch(Exception e) {
			
		}
		
		/* Pode ser feito assim também: 
		// assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
		*/
	}

	@Test
	public void bonusDeveriaSer10PorCentoDoSalario() {

		BonusService bonusService = new BonusService();

		Funcionario funcionario = new Funcionario("Carlos", LocalDate.of(2021, 05, 10), new BigDecimal(2500.0));

		BigDecimal bonus = bonusService.calcularBonus(funcionario);

		assertEquals(new BigDecimal("250.0"), bonus);

	}

	@Test
	public void bonusDeveriaSer10PorCentoDoSalarioParaSalarioDeExatamente10000() {

		BonusService bonusService = new BonusService();

		Funcionario funcionario = new Funcionario("Carlos", LocalDate.of(2021, 05, 10), new BigDecimal(10000.0));

		BigDecimal bonus = bonusService.calcularBonus(funcionario);

		assertEquals(new BigDecimal("1000.0"), bonus);

	}

	@Test
	public void bonusDeveriaSerMaiorQueZeroParaFuncionariosComSalarioBaixo() {

		BonusService bonusService = new BonusService();

		Funcionario funcionario = new Funcionario("Carlos", LocalDate.now(), new BigDecimal(5000.0));

		BigDecimal bonus = bonusService.calcularBonus(funcionario);

		assertNotEquals(BigDecimal.ZERO, bonus);

	}

}
