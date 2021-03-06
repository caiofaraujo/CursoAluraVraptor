package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.simplemail.Mailer;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private final Mailer mailer;
	
	@Inject
	public ProdutoController (Result result, ProdutoDao dao, Validator validator, Mailer mailer) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	@Deprecated
	public ProdutoController () {
		this(null, null, null, null);
	}
	
	@Path("/") @Get
	public void inicio() {
		
	}
	
	@Path("/produto/lista") @Get
	public void lista() {
		result.include("produtoList", dao.lista());
	}
	
	@Get
	public void listaXML() {
		result.use(Results.xml()).from(dao.lista()).serialize();
	}
	
	@Get
	public void listaJSON() {
		result.use(Results.json()).from(dao.lista()).serialize();
	}
	
	@Path("/produto/sobre")
	public void sobre() {
		
	}
	
	@Path("/produto/formulario") @Get
	public void formulario() {
		
	}
	
	@Path("/produto/adiciona") @Post
	public void adiciona(@Valid Produto produto) {
		
		validator.onErrorForwardTo(this).formulario();
		
		dao.adiciona(produto);
		// Redefine fluxo padrão de uma request
		result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	@Path("/produto/remove")
	public void remove(Produto produto) {
		dao.remove(produto);
		
		// Redefine fluxo padrão de uma request
		result.include("mensagem", "Produto removido com sucesso!");
		result.redirectTo(this).lista();
	}
	
	@Get
	public void enviaPedidoDeNovosItens(Produto produto) throws EmailException {
		Email email = new SimpleEmail();
		email.setSubject("Precisamos de mais estoque");
		email.setMsg("O produto " + produto.getNome() + " está sem estoque");
		email.addTo("caiozin.preto@gmail.com");
		mailer.send(email);
		result.redirectTo(this).lista();
	}
}
