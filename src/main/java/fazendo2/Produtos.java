package fazendo2;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@ManagedBean(name="produtos")
@ViewScoped
@Entity
@Table(name="Produtos")
public class Produtos {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
private long id;
private String nome;
private String descricao;
private String preco;
private String laboratorio;

@Transient
private String valorNome;
@Transient
private String valorDescricao;
@Transient 
private String valorPreco;
@Transient
private String valorLaboratorio;



public String getValorNome() {
	return valorNome;
}
public void setValorNome(String valorNome) {
	this.valorNome = valorNome;
}
public String getValorDescricao() {
	return valorDescricao;
}
public void setValorDescricao(String valorDescricao) {
	this.valorDescricao = valorDescricao;
}
public String getValorPreco() {
	return valorPreco;
}
public void setValorPreco(String valorPreco) {
	this.valorPreco = valorPreco;
}
public String getValorLaboratorio() {
	return valorLaboratorio;
}
public void setValorLaboratorio(String valorLaboratorio) {
	this.valorLaboratorio = valorLaboratorio;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getPreco() {
	return preco;
}
public void setPreco(String preco) {
	this.preco = preco;
}



public String getLaboratorio() {
	return laboratorio;
}
public void setLaboratorio(String laboratorio) {
	this.laboratorio = laboratorio;
}
public String cadastrar()  {


	
	
	String valorNome = getValorNome();
	String valorDescricao = getValorDescricao();
	String valorPreco = getValorPreco();
	String valorLaboratorio = getValorLaboratorio();
	
	try {
		Produtos P = new Produtos();
		
		
		
		
		P.setNome(valorNome);
		P.setDescricao(valorDescricao);
		P.setLaboratorio(valorLaboratorio);
		P.setPreco(valorPreco + "R$");
		
		System.out.println("VOCÊ FOI CADASTRADO");
		//	
		//
		//
		
		ProdutosDAO.cadastrarProdutos(P);
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO REALIZADO", ""));


		return null;
	
	}catch( Exception erro) {
		
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("ERRO", "ESSE CPF JA EXISTE"));
		System.out.println("errado");
	
	
	
	}
	

	return null;
}


public String  cadastraFora(Produtos p) {
	
	String valorNome = getValorNome();
	String valorDescricao = getValorDescricao();
	String valorPreco = getValorPreco();
	String valorLaboratorio = getValorLaboratorio();
	
		try {
			
			
			
			
			
			p.setNome(valorNome);
			p.setDescricao(valorDescricao);
			p.setLaboratorio(valorLaboratorio);
			p.setPreco(valorPreco + "R$");
			
			System.out.println("VOCÊ FOI CADASTRADO");
			//	
			//
			//
			
			ProdutosDAO.cadastrarProdutos(p);
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO REALIZADO", ""));


			return null;
		
		}catch( Exception erro) {
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("ERRO", "ESSE CPF JA EXISTE"));
			System.out.println("errado");
		
		
		
		}
	
	
	

	return null;
}
	
	
	
	

	
	
	
public void achandoId(Long p) {
	ProdutosDAO.buscarId(p);
	FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO REMOVIDO", ""));

}
	


}
