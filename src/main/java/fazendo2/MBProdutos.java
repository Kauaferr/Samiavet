package fazendo2;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name="MBprodutos")
@ViewScoped
public class MBProdutos {
	
private Produtos produtos;
private ArrayList<Produtos> itens;

private ArrayList<Produtos> itensFiltrados;
 private String nomeBusca;


 
 
 
 
public String getNomeBusca() {
	return nomeBusca;
}

public void setNomeBusca(String nomeBusca) {
	this.nomeBusca = nomeBusca;
}

public Produtos getProdutos() {
	return produtos;
}

public void setProdutos(Produtos produtos) {
	this.produtos = produtos;
}




public ArrayList<Produtos> getItens() {
	return itens;
}

public void setItens(ArrayList<Produtos> itens) {
	this.itens = itens;
}

public ArrayList<Produtos> getItensFiltrados() {
	return itensFiltrados;
}

public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
	this.itensFiltrados = itensFiltrados;
}

@PostConstruct
public void prepararPesquisa() {
	try {
		ArrayList<Produtos> lista = (ArrayList<Produtos>) ProdutosDAO.buscarTodos();
		itens = lista;
	}catch(Exception erro) {
		erro.printStackTrace();
	}
	
}
public void prepararNovo() {
	
	produtos = new Produtos();
}


public boolean adicionar() {
	
	try {
		if(produtos.getValorNome().contains("´")||produtos.getValorNome().contains("^")||produtos.getValorNome().contains("`")||produtos.getValorNome().contains("~")) {

			System.out.println("pode acento n man");
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("ERRO", "NÃO É POSSÍVEL TER ACENTOS NOS NOMES DOS PRODUTOS"));
			return false;
		}else {
		
		this.produtos.cadastraFora(produtos);
		ArrayList<Produtos> lista = (ArrayList<Produtos>) ProdutosDAO.buscarTodos();
		itens = lista;
		return true;
		}} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
}


public void excluir() {
	try {
		
		ProdutosDAO produto = new ProdutosDAO();
		produto.removendo(produtos);
		prepararPesquisa();
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO EXCLUÍDO", ""));


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



public void editar() {

	
try {
		
		ProdutosDAO produto = new ProdutosDAO();
		produto.consultar(produtos);
		prepararPesquisa();
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO EDITADO", ""));


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void pesquisarNome() {
	try {
		ArrayList<Produtos> lista = (ArrayList<Produtos>) ProdutosDAO.buscarNome(this.nomeBusca);
		itens = lista;
	}catch(Exception erro) {
		erro.printStackTrace();
	}
	
}


public void pesquisarTodos() {
	try {
		ArrayList<Produtos> lista = (ArrayList<Produtos>) ProdutosDAO.buscarTodos();
		itens = lista;
	}catch(Exception erro) {
		erro.printStackTrace();
	}
	
}
public void limpar() {
	setNomeBusca(null);
}
}