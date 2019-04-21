package br.com.aula.junit.testes.negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.aula.junit.negocio.Cliente;
import br.com.aula.junit.negocio.GerenciadoraClientes;

public class GerenciadoraClientesTest_Ex03 {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cenário ========== */

		// criando alguns clientes
		Cliente cliente01 = Cliente.builder()
				.id(1)
				.nome("Gustavo Farias")
				.idade(31)
				.email("gugafarias@gmail.com")
				.idContaCorrente(1)
				.ativo(true)
				.build();
		Cliente cliente02 = Cliente.builder()
				.id(2)
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
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/* ========== Verificações ========== */
		assertThat(cliente.getId(), is(1));
		
	}
	
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		Cliente cliente01 = Cliente.builder()
				.id(1)
				.nome("Gustavo Farias")
				.idade(31)
				.email("gugafarias@gmail.com")
				.idContaCorrente(1)
				.ativo(true)
				.build();
		Cliente cliente02 = Cliente.builder()
				.id(2)
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
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
	
}
