package br.com.aula.junit.negocio;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * Classe de negócio para realizar operações sobre os clientes do banco.
 * @author 
 */
@Data
@Builder
@AllArgsConstructor
public class GerenciadoraClientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private List<Cliente> clientesDoBanco;
	
	/**
	 * Pesquisa por um cliente a partir do seu ID.
	 * @param idCliente id do cliente a ser pesquisado
	 * @return o cliente pesquisado ou null, caso não seja encontrado
	 */
	public Cliente pesquisaCliente (int idCliente) {

		return clientesDoBanco.stream().filter(c -> c.getId() == idCliente).findFirst().orElse(null);
		
	}
	
	/**
	 * Adiciona um novo cliente lista de clientes do banco.
	 * @param novoCliente novo cliente a ser adicionado
	 */
	public void adicionaCliente (Cliente novoCliente) {
		clientesDoBanco.add(novoCliente);
	}

	/**
	 * Remove cliente da lista de clientes do banco.
	 * @param idCliente ID do cliente a ser removido 
	 * @return true se o cliente foi removido. False, caso contrário.
	 */
	public boolean removeCliente (int idCliente) {
		
		return clientesDoBanco.removeIf( c -> c.getId() == idCliente);
		
	}

	/**
	 * Informa se um determinado cliente está ativo ou não.
	 * @param idCliente ID do cliente cujo status será verificado
	 * @return true se o cliente está ativo. False, caso contrário. 
	 */
	public boolean clienteAtivo (int idCliente) {
		
		return clientesDoBanco.stream().anyMatch(c -> c.getId() == idCliente && c.isAtivo());
		
	}

	/**
	 * Limpa a lista de clientes, ou seja, remove todos eles. 
	 */
	public void limpa() {
		this.clientesDoBanco.clear();
	}
	
	/**
	 * Valida se a idade do cliente está dentro do intervalo permitido (18 - 65).
	 * @param idade a idade do possível novo cliente
	 */
	public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
	
		if(idade < 18 || idade > 65)
			throw new IdadeNaoPermitidaException(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		
		return true;
	}
	
}
