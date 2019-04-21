package br.com.aula.junit.negocio;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe {@link Cliente} que representa um cliente real do banco.
 * @author 
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private int idade;
	private String email;
	private int idContaCorrente;
	private boolean ativo;

	/**
	 * Método que retorna a representação textual de um cliente. 
	 * @return representação textual de um cliente
	 */
	@Override
	public String toString() {
		
		String str ="=========================\n" 
					+"Id: " + this.id + "\n"
					+ "Nome: " + this.nome + "\n"
					+ "Email: " + this.email + "\n"
					+ "Idade: " + this.idade + "\n"
					+ "Status: " + (ativo?"Ativo":"Inativo") + "\n"
					+ "=========================\n";
		return str;
	}
	
}
