package br.com.caelum.vraptor.dao;

import java.util.List;

import br.com.caelum.vraptor.entidade.Cliente;


public interface ClienteDao{
	
	
	void add(Cliente cliente);
	
	List<Cliente> procurar(String nome);

	List<Cliente> listarTodos();
	
	List<Cliente> procuraJBuscaBr(String nome);

}