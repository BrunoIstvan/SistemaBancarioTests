package br.com.aula.junit.testes.negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.aula.junit.negocio.Cliente;
import br.com.aula.junit.negocio.GerenciadoraClientes;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author 
 * @date 21/01/2035 
 */
public class GerenciadoraClientesTest_Ex07 {

	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private	int idCliente02 = 2;
	
	@Before
	public void setUp() {
	
		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		Cliente cliente01 = Cliente.builder()
				.id(idCliente01)
				.nome("Gustavo Farias")
				.idade(31)
				.email("gugafarias@gmail.com")
				.idContaCorrente(1)
				.ativo(true)
				.build();
		Cliente cliente02 = Cliente.builder()
				.id(idCliente02)
				.nome("Felipe Augusto")
				.idade(34)
				.email("felipeaugusto@gmail.com")
				.idContaCorrente(2)
				.ativo(true)
				.build();
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	
//		System.out.println("Before foi executado");
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
		
//		System.out.println("After foi executado");
	}
	
	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author 
	 * @date 21/01/2035
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Execução ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		/* ========== Verificações ========== */
		assertThat(cliente.getId(), is(idCliente01));
		
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 * @author 
	 * @date 21/01/2035
	 */
	@Test
	public void testRemoveCliente() {
		
		/* ========== Execução ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
	
}
// Como Ganhar Tempo e Otimizar Testes com cenários Parecidos