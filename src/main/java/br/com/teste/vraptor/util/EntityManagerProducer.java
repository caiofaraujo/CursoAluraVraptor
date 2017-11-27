package br.com.teste.vraptor.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;

public class EntityManagerProducer {
	
	@Produces @RequestScoped
	public EntityManager criaEM() {
		return JPAUtil.criaEntityManager();
	}
}