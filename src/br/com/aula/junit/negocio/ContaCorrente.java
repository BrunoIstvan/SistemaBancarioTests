package br.com.aula.junit.negocio;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe {@link ContaCorrente} que representa uma conta corrente real
 * e que poderá ser associada a um cliente.
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double saldo;
	private boolean ativa;
	
	/**
	 * Método que retorna a representação textual de uma conta corrente. 
	 * @return representação textual da conta corrente
	 */
	@Override
	public String toString() {
		
		String str = "=========================\n"
					+ "Id: " + this.id + "\n"
					+ "Saldo: " + this.saldo + "\n"
					+ "Status: " + (ativa?"Ativa":"Inativa") + "\n"
					+ "=========================\n";
		return str;
	}
	
}
