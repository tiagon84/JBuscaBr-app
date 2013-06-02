package br.com.caelum.vraptor.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String nomeCodFonetico;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeCodFonetico() {
		return nomeCodFonetico;
	}
	public void setNomeCodFonetico(String nomeCodFonetico) {
		this.nomeCodFonetico = nomeCodFonetico;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
