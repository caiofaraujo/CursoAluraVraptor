package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {
	
	// Injeções de depêndencias
	@Inject private UsuarioLogado usuarioLogado;
	@Inject private Result result;
	@Inject private ControllerMethod controllerMethod;
	
	@Accepts // Define quem ou não interceptar
	public boolean accepts() {
		return !controllerMethod.containsAnnotation(Public.class); // Interceptar todas requisições que não contenham anotações @Public
	}
	
	@AroundCall
	public void Intercepta(SimpleInterceptorStack stack) {
		// Código a ser executa antes de continuar com o código principal
		if(usuarioLogado.getUsuario() == null) {
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		
		// Concede a permissão de continuação para o código princiapl (controllers)
		stack.next();
		
		// Código a ser executado depois da continuação do código principal
	}
	
	@BeforeCall
	public void before() {
		// antes
	}
	
	@AfterCall
	public void after() {
		// depois
	}
}
