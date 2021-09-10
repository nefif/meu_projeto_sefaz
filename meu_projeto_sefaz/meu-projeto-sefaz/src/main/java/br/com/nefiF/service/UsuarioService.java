package br.com.nefiF.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.nefiF.dao.DAO;
import br.com.nefiF.model.Pessoa;
import br.com.nefiF.utility.NegocioException;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Pessoa> dao;
	
	public void salvar(Pessoa p) throws NegocioException {
		
		if(p.getSenha().length() < 8) {
			throw new NegocioException("A senha não pode ter menos que 8 caracteres.");
		}
		
		dao.salvar(p);
	}
	
	public void remover(Pessoa p) throws NegocioException {
		dao.remover(Pessoa.class, p.getId());
	}
	
	public List<Pessoa> todosOsUsuarios() {
		return dao.buscarTodos("select p from Pessoa p order by m.nome");
	}

}
