package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.model.Produto;

@Controller
public class ProdutoController {
	
	@Path("/")
	public void inicio() {
		
	}
	
	@Path("/produto/lista")
	public List<Produto> lista() {
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		return dao.lista();
	}
	
	@Path("/produto/sobre")
	public void sobre() {
		
	}
}
