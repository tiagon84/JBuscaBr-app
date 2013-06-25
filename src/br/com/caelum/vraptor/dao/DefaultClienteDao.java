package br.com.caelum.vraptor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.entidade.Cliente;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DefaultClienteDao implements ClienteDao {

	private final Session session;

	public DefaultClienteDao(Session session) {
		this.session = session;
	}

	public void add(Cliente cliente) {
		session.save(cliente);

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> procurar(String nome) {

		return session.createCriteria(Cliente.class)
				.add(Restrictions.like("nome", "%" + nome + "%")).list();

	}
	@SuppressWarnings("unchecked")
	public List<Cliente> procuraJBuscaBr(String nomeCodFonetico) {
		
		return session.createCriteria(Cliente.class)
				.add(Restrictions.ilike("nomeCodFonetico","%"+ nomeCodFonetico+"%")).list();
		
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos() {
		return session.createCriteria(Cliente.class).list();
	}

}
