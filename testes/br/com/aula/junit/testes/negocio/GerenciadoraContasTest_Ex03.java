package br.com.aula.junit.testes.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.aula.junit.negocio.ContaCorrente;
import br.com.aula.junit.negocio.GerenciadoraContas;

public class GerenciadoraContasTest_Ex03 {

	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		ContaCorrente conta01 = ContaCorrente.builder()
				.id(1)
				.saldo(200)
				.ativa(true)
				.build();
		ContaCorrente conta02 = ContaCorrente.builder()
				.id(2)
				.saldo(0)
				.ativa(true)
				.build();
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execução ========== */
		gerContas.transfereValor(1, 100, 2, false);
		
		/* ========== Verificações ========== */
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
		
	}

}
