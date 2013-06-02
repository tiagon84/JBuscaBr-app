package br.com.caelum.vraptor.controller;


import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.dao.ClienteDao;
import br.com.caelum.vraptor.util.*;
import br.com.caelum.vraptor.entidade.Cliente;

@Resource
public class ClienteController {
	
	private final ClienteDao dao;
	
	private final Result result;
	
	private final Validator validator;

		

	public ClienteController(ClienteDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get
	@Path("/clientes")
	public List<Cliente> listarClientes(){
		return dao.listarTodos();
	}
	
	public void form(){
		
	}
	
	@Post
	@Path("/cliente")
	public void adicionar(Cliente cliente){

		cliente.setNomeCodFonetico(BuscaBr.buscaBr(cliente.getNome()));
		dao.add(cliente);
		result.redirectTo(ClienteController.class).listarClientes();
	}
	@Path("/clientes/{cliente.id}")
	@Get
	public void show(Cliente cliente){
		result.include("cliente", cliente);
	}
	
	@Path("/clientes/procurar")
	@Get
	public void procurar(Cliente cliente) {
        if (cliente.getNome() == null) {
            cliente.setNome("");
        }

        result.include("clientes", this.dao.procurar(cliente.getNome()));
    }
}
