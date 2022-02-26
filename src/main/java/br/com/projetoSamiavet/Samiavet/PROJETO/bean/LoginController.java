package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Usuario;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.UsuarioService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@ManagedBean(value="user")
@SessionScoped
public class LoginController {

	private Usuario logar;
	
	@Autowired
	private UsuarioService userService;
	
	
	public Usuario getLogar() {
		return logar;
	}

	public void setLogar(Usuario logar) {
		this.logar = logar;
	}

	public LoginController() {
		
		this.logar = new Usuario();
	}
	
	@PostConstruct
	public void carregar() {
		Usuario user = new Usuario();
		user.setLogin("samia");
		user.setSenha("admin");
		
		
		this.userService.cadastrar(user);
	}
	
	public void  Logar() throws IOException  {
		
		
		
		
		String valorLogin = this.userService.buscaPorLogin(this.logar.getLogin());
		
		String valorSenha = this.userService.buscaPorSenha(this.logar.getSenha());
		
		
		if(valorLogin == null || valorSenha == null) {
        	JsfUtil.adicionarMensagemDeErro("Usuario e/ou senha incorreta", null);

		}else if(this.logar.getSenha().equals(valorSenha)&&this.logar.getLogin().equals(valorLogin)) {
			
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", logar);
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		        ec.redirect(ec.getRequestContextPath() + "/pages/cadastro.xhtml");	
		}
		
		
		
		
		
		
	}
	
	public void Sair() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/seguranca/login.xhtml");	
	}
}
