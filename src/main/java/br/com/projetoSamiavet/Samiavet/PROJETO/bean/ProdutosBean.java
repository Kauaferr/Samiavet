package br.com.projetoSamiavet.Samiavet.PROJETO.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ProdutosService;
import br.com.projetoSamiavet.Samiavet.PROJETO.util.JsfUtil;

@Named(value="produtosBean")
@ViewScoped
public class ProdutosBean {

	
	private Produtos produto;
	private List<Produtos> produtos;
	private Double precoCompra = Double.valueOf(0);
	private Double precoVenda = Double.valueOf(0);
	
	@Autowired
	private ProdutosService produtosService;
	
	public ProdutosBean() {
		precoCompra = 0d;
		precoVenda = 0d;
		this.produto = new Produtos();
		
	}
	
	
	
	public Produtos getProduto() {
		return produto;
	}



	public void setProduto(Produtos produto) {
		this.produto = produto;
	}



	public List<Produtos> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}



	public Double getPrecoCompra() {
		return precoCompra;
	}



	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}



	public Double getPrecoVenda() {
		return precoVenda;
	}



	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}



	public ProdutosService getProdutosService() {
		return produtosService;
	}



	public void setProdutosService(ProdutosService produtosService) {
		this.produtosService = produtosService;
	}



	@PostConstruct
	public void carregar() {
		
		
		this.produtos = new ArrayList<Produtos>(this.produtosService.listarProdutos());
		
		
	}
	public void cadastrar() {
	
		Produtos produto = this.produto;
		produto.setPreco_compra(this.precoCompra);
		produto.setPreco_venda(this.precoVenda);
		String converterData = 	String.valueOf(LocalDate.now());
		produto.setData_registro(converterData);
		
		this.produtosService.salvar(produto);
		
		carregar();
		this.produto = new Produtos();
		precoCompra = 0d;
		precoVenda = 0d;
		JsfUtil.adicionarMensagemDeSucesso("Produto salvo com sucesso. Confira na tabela abaixo!", null);

	}
	
	
	
}
