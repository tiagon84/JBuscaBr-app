package br.com.caelum.vraptor.controller;


import java.util.List;

import com.google.gson.JsonArray;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.dao.ClienteDao;
import br.com.caelum.vraptor.util.*;
import br.com.caelum.vraptor.view.Results;
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
		
	@Get
	@Path("/clientes/cadastrar")
	public void cadastrar(){
	}
	
	@Get
	@Path("/clientes/buscar")
	public void buscar(){
	}
	
	@Post
	@Path("/clientes/cliente")
	public void salvar(Cliente cliente){
		cliente.setNomeCodFonetico(BuscaBr.buscaBr(cliente.getNome()));
		dao.add(cliente);
		result.include("msg", "Cadastrado com Sucesso!").redirectTo(ClienteController.class).cadastrar();
		
	}
	@Path("/clientes/{cliente.id}")
	@Get
	public void show(Cliente cliente){
		result.include("cliente", cliente);
	}
	
	@Path("/clientes/procura-normal")
	@Get
	public void procurar(Cliente cliente) {
        if (cliente.getNome() == null) {
            result.redirectTo(ClienteController.class).buscar();
        }
        
        List<Cliente> clientesEncontrados = dao.procurar(cliente.getNome());

        //result.include("clientes", this.dao.procurar(nome));
        result.use(Results.json()).withoutRoot().from(clientesEncontrados).serialize();
    }
}
