package fazendo2;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name="MBpessoas")
@ViewScoped
public class MBPesoas {
	private Pessoas pessoas;
	private CATEGORIAS categorias;
	private ArrayList<Pessoas> itens;

	private ArrayList<Pessoas> itensFiltrados;

	
	private ArrayList<CATEGORIAS> comboCategorias;
	

	
	
	
	

public ArrayList<CATEGORIAS> getComboCategorias() {
		return comboCategorias;
	}



	public void setComboCategorias(ArrayList<CATEGORIAS> comboCategorias) {
		this.comboCategorias = comboCategorias;
	}



public Pessoas getPessoas() {
		return pessoas;
	}



	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}



public CATEGORIAS getCategorias() {
		return categorias;
	}



	public void setCategorias(CATEGORIAS categorias) {
		this.categorias = categorias;
	}


	public ArrayList<Pessoas> getItens() {
		return itens;
	}


	public void setItens(ArrayList<Pessoas> itens) {
		this.itens = itens;
	}



	public ArrayList<Pessoas> getItensFiltrados() {
		return itensFiltrados;
	}



	public void setItensFiltrados(ArrayList<Pessoas> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


@PostConstruct
public void prepararPesquisa() {
	try {
	
	ArrayList<Pessoas> lista = (ArrayList<Pessoas>) PessoasDAO.buscarTodos();
	itens =  lista;
	}catch(Exception erro) {
		erro.printStackTrace();
	}
	
}

public void prepararNovo() {
	
	
	
	
	
	
	try {
		pessoas = new Pessoas();
		comboCategorias = (ArrayList<CATEGORIAS>) CATEGORIASDAO.buscarTodos();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 


public void adicionar() {
	
	try {
		this.pessoas.cadastraFora(pessoas);
		ArrayList<Pessoas> lista = (ArrayList<Pessoas>) PessoasDAO.buscarTodos();
		itens = lista;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void excluir() {
	try {
		
		PessoasDAO.removendo(this.pessoas);
		prepararPesquisa();
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO EXCLUÍDO", ""));


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void editar() {

	
try {
		
		PessoasDAO.consultar(this.pessoas);
		prepararPesquisa();
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("CADASTRO EDITADO", ""));


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
