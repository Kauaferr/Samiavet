package fazendo2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name="pesquisar")
@ViewScoped
public class Pesquisa {

	private String pesquisa;

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
	
	public String fazerPesquisa() {
		if(this.pesquisa.equals("INÍCIO")||this.pesquisa.equals("início")||this.pesquisa.equals("inicio")||this.pesquisa.equals("Inicio")||this.pesquisa.equals("HOME")||this.pesquisa.equals("home")){
			return "principal.xhtml?faces-redirect=true";		}else {
			if(this.pesquisa.equals("produtos")||this.pesquisa.equals("Produtos")||this.pesquisa.equals("PRODUTOS")) {
				return "produtos.xhtml";
			}
		}
		return "";
	}
	
	
	
	
	
	
	
	
	
}
