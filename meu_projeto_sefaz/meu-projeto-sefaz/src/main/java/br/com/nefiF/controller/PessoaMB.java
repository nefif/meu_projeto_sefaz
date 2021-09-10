package br.com.nefiF.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.nefiF.model.Pessoa;
import br.com.nefiF.service.UsuarioService;
import br.com.nefiF.utility.Message;
import br.com.nefiF.utility.NegocioException;

@Named("bean")
@SessionScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;

	@Inject
	private UsuarioService service;

	private List<Pessoa> pessoas = new ArrayList<>();

	@PostConstruct
	public void carregar() {
		pessoas = service.todosOsUsuarios();
	}

	public void adicionar() {

		try {
			service.salvar(pessoa);
			pessoa = new Pessoa();
			carregar();

			Message.info("Salvo com Sucesso!");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {

		try {

			service.remover(pessoa);
			carregar();

			Message.info(pessoa.getNome() + "foi removido");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
