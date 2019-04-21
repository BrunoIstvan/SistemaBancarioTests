package br.com.aula.junit.testes.negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

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
public class GerenciadoraClientesTest_Ex05 {

	private GerenciadoraClientes gerClientes;

	/**
	 * Teste básico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author 
	 * @date 21/01/2035
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
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

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		int idCliente01 = 1;
		int idCliente02 = 2;
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
		
		/* ========== Execução ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
		
	}
	
}
