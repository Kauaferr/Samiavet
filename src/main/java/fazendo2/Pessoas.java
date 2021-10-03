package fazendo2;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;





@ManagedBean(name="pessoas")
@RequestScoped
@Entity
@Table(name="Pessoas2")
public class Pessoas {
	

	

	
	@Id
	private String cpf;
	
	
	private String senha;
	private String nome;
	private String email;
	
	
	@Transient
	private String confereSenha;
	@Transient
	private String cadastraCategoria;
	
	@Transient
	private String nomeMudanca;
	@Transient
	private String senhaValor;
	@Transient
	private String valorCpf;
	
	
	
	
	public String getValorCpf() {
		return valorCpf;
	}
	public void setValorCpf(String valorCpf) {
		this.valorCpf = valorCpf;
	}
	public String getSenhaValor() {
		return senhaValor;
	}
	public void setSenhaValor(String senhaValor) {
		this.senhaValor = senhaValor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfereSenha() {
		return confereSenha;
	}
	public void setConfereSenha(String confereSenha) {
		this.confereSenha = confereSenha;
	}
	public String getNomeMudanca() {
		return nomeMudanca;
	}
	public void setNomeMudanca(String nomeMudanca) {
		this.nomeMudanca = nomeMudanca;
	}

	public CATEGORIAS getCategoria() {
		return categoria;
	}
	public void setCategoria(CATEGORIAS categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String retornaNomeeCpf() {
		System.out.println("SEU NOME É: " + getNome());
		System.out.println("SEU CPF É: " + getSenha());
		return null;
	}
	public String cadastrar()   {

	
	this.senha = getSenhaValor();
	this.cpf = getValorCpf();
	
	System.out.println("SENHA: " + getSenha());
	System.out.println("SENHA: " + getConfereSenha());
	System.out.println("CPF: " + getCpf());
	try {
	if(getSenha().equals(getConfereSenha())) {
		Pessoas P = new Pessoas();
		
		
		
		P.setSenha(getSenha());
		P.setNome(getNome());
		P.setEmail(getEmail());
		
		P.setCpf(getCpf());
		System.out.println("VOCÊ FOI CADASTRADO");
		//	
		//
		//
	
		PessoasDAO.cadastrarPessoas(P);
		
		
		this.nome="";
		this.cpf = "";
		this.email = "";
		this.senha = "";
		this.confereSenha = "";
		this.valorCpf="";
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("SUCESSO", "Cadastro realizado!!"));
		return null;
	}else {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "AS SENHAS NÃO CONFEREM"));		

		return null;
	}
	}catch( Exception erro) {
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "ESSE CPF JA EXISTE"));		
	}
	return null;
	
	}


	public String retornaNome() {
		String nome = getNome();

		
		List<Pessoas> lista = PessoasDAO.buscarNome(nome);
		
		
		for (Pessoas nomes:lista) {
			System.out.println("CPF: " + nomes.getSenha());
			System.out.println("NOMES: " + nomes.getNome());
			
			
			
			
			if(getNome().isEmpty()||getNomeMudanca().isEmpty()) {
				nomes.setNome(nomes.getNome());
				
			}else {
				nomes.setNome(getNomeMudanca());
				
			}
			if(getSenha().isEmpty()) {
				nomes.setSenha(nomes.getSenha());
				
				
			}else {
				nomes.setSenha(getSenha());
				
			}
			
			
			
			PessoasDAO.consultar(nomes);
			
		}
		
			
		
		
		
		return null;
	}
		
	
	
	
	
public String  cadastraFora(Pessoas p) {
		
		
		try {
			
			
			
		if(getSenha().equals(getConfereSenha())) {
				Pessoas P = new Pessoas();
				
				
				P.setSenha(getSenha());
				P.setNome(getNome());
				P.setEmail(getEmail());
				P.setCpf(getCpf());
				System.out.println("VOCÊ FOI CADASTRADO");
				//	
			
			
			
			PessoasDAO.cadastrarPessoas(p);
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO REALIZADO", ""));


			return null;
		}
		}catch( Exception erro) {
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("ERRO", "ESSE CPF JA EXISTE"));
			System.out.println("errado");
		
		
		
		}
		

		return null;
	}
		
		
	
	
	
	
	
	
	
	
	public String anula() {
		
		
		return null;
	}

}

