package br.com.aula.junit.negocio;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Classe de negócio para realizar operações sobre as contas do banco.
 * @author 
 */
@Builder
@Getter
@AllArgsConstructor
public class GerenciadoraContas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	private List<ContaCorrente> contasDoBanco;

	/**
	 * Pesquisa por uma conta a partir do seu ID.
	 * @param idConta id da conta a ser pesquisada
	 * @return a conta pesquisada ou null, caso não seja encontrada
	 */
	public ContaCorrente pesquisaConta (int idConta) {

		return contasDoBanco.stream().filter(c -> c.getId() == idConta).findFirst().orElse(null);
		
	}
	
	/**
	 * Adiciona uma nova conta lista de contas do banco.
	 * @param novaConta nova conta a ser adicionada
	 */
	public void adicionaConta (ContaCorrente novaConta) {
		this.contasDoBanco.add(novaConta);
	}

	/**
	 * Remove conta da lista de contas do banco.
	 * @param idConta ID da conta a ser removida 
	 * @return true se a conta foi removida. False, caso contrário.
	 */
	public boolean removeConta (int idConta) {
		
		return contasDoBanco.removeIf(c -> c.getId() == idConta);
		
	}

	/**
	 * Informa se uma determinada conta está ativa ou não.
	 * @param idConta ID da conta cujo status será verificado
	 * @return true se a conta está ativa. False, caso contrário. 
	 */
	public boolean contaAtiva (int idConta) {
		
		return contasDoBanco.stream().anyMatch(c -> c.getId() == idConta && c.isAtiva());
			
	}
	
	/**
	 * Transfere um determinado valor de uma conta Origem para uma conta Destino.
	 * Caso não haja saldo suficiente, o valor não será transferido.
	 * 
	 * @param idContaOrigem conta que terá o valor deduzido
	 * @param valor valor a ser transferido
	 * @param idContaDestino conta que terá o valor acrescido
	 * @param permiteTornarSaldoNegativo Mesmo não havendo saldo suficiente, o valor será transferido, tornando a conta origem negativa.
	 * @return true, se a transferência foi realizada com sucesso.
	 */
	public boolean transfereValor (int idContaOrigem, double valor, int idContaDestino, boolean permiteTornarSaldoNegativo) {
		
		boolean sucesso = false;
		
		ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
		ContaCorrente contaDestino = pesquisaConta(idContaDestino);
		
		if(contaOrigem.getSaldo() >= valor || permiteTornarSaldoNegativo){
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			sucesso = true;
		}
	
		return sucesso;
	}
	
//	/**
//	 * Transfere um determinado valor de uma conta Origem para uma conta Destino.
//	 * Caso não haja saldo suficiente, o valor não será transferido.
//	 * 
//	 * @param idContaOrigem conta que terá o valor deduzido
//	 * @param valor valor a ser transferido
//	 * @param idContaDestino conta que terá o valor acrescido
//	 * @return true, se a transferência foi realizada com sucesso.
//	 */
//	public boolean transfereValorPermiteChequeEspecial (int idContaOrigem, double valor, int idContaDestino) {
//		
//		boolean sucesso = false;
//		
//		ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
//		ContaCorrente contaDestino = pesquisaConta(idContaDestino);
//		
//		// if(contaOrigem.getSaldo() >= valor){
//			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
//			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
//			sucesso = true;
//		//}
//	
//		return sucesso;
//	}
	
}
