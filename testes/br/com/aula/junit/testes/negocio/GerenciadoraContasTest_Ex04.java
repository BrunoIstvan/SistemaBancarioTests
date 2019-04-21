package br.com.aula.junit.testes.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.aula.junit.negocio.ContaCorrente;
import br.com.aula.junit.negocio.GerenciadoraContas;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}.
 * 
 * @author 
 * @date 21/01/2035 
 */
public class GerenciadoraContasTest_Ex04 {

	private GerenciadoraContas gerContas;
	
	/**
	 * Teste básico da transferência de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transferência
	 * ocorrer com sucesso.
	 * 
	 * @author 
	 * @date 21/01/2035
	 */
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
		boolean sucesso = gerContas.transfereValor(1, 100, 2, false);
		
		/* ========== Verificações ========== */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
	}

}

// Documentação e comentários