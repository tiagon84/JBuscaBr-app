package br.com.caelum.vraptor.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.dao.ClienteDao;
import br.com.caelum.vraptor.entidade.Cliente;
import br.com.caelum.vraptor.util.JBuscaBr;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ClienteController {
	
	private final ClienteDao dao;
	
	private final Result result;
	

	public ClienteController(ClienteDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
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
		cliente.setNomeCodFonetico(JBuscaBr.buscaBr(cliente.getNome()));
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
        String textoTraduzido = decoderText(cliente.getNome());
        
        List<Cliente> clientesEncontrados = dao.procurar(textoTraduzido);

        result.use(Results.json()).withoutRoot().from(clientesEncontrados).serialize();
    }
	@Path("/clientes/procura-buscabr")
	@Get
	public void procurarComBuscaBr(Cliente cliente) {
		if (cliente.getNome() == null) {
			result.redirectTo(ClienteController.class).buscar();
		}
		String textoTraduzido = decoderText(cliente.getNome());
		cliente.setNomeCodFonetico(JBuscaBr.buscaBr(textoTraduzido));
		List<Cliente> clientesEncontrados = dao.procuraJBuscaBr(cliente.getNomeCodFonetico());
		
		result.use(Results.json()).withoutRoot().from(clientesEncontrados).serialize();
	}
	
	private String decoderText(String texto) {
	    try {
	        byte[] bytes = texto.getBytes("ISO-8859-1");
	        texto = new String(bytes, "UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return texto;
	    }

	    return texto;
	}
}
