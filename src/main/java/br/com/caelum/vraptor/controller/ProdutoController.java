package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;
import br.com.caelum.vraptor.model.Produto;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	
	@Inject
	public ProdutoController (Result result, ProdutoDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Deprecated
	public ProdutoController () {
		this(null, null);
	}
	
	@Path("/") @Get
	public void inicio() {
		
	}
	
	@Path("/produto/lista") @Get
	public void lista() {
		List<Produto> lista = dao.lista();
		result.include("produtoList", lista);
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
	public void adiciona(Produto produto) {
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
}
