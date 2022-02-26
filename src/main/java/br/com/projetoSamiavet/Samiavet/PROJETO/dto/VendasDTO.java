package br.com.projetoSamiavet.Samiavet.PROJETO.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendasDTO {

	private Long id_venda;
	private Double valor;
	private Double taxa;
	private int parcelas;
	private String data_venda;
	private String nome_cliente;
	private String cpf;
	private String forma_pagamento;

	private List<Produtos> produtos;


	public VendasDTO(Long id_venda, int quantidade_produto, Double valor, Double taxa, int parcelas, String data_venda,
			String nome_cliente, String cpf, String forma_pagamento, List<Produtos> produtos) {
		this.id_venda = id_venda;
		this.valor = valor;
		this.taxa = taxa;
		this.parcelas = parcelas;
		this.data_venda = data_venda;
		this.nome_cliente = nome_cliente;
		this.cpf = cpf;
		this.forma_pagamento = forma_pagamento;
		this.produtos = produtos;
	}


	
	public VendasDTO() {
		
		
	}



	public Long getId_venda() {
		return id_venda;
	}

	public void setId_venda(Long id_venda) {
		this.id_venda = id_venda;
	}



	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	
	public List<Produtos> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}



	public Vendas transformarParaObjeto() {
		return new Vendas(this.id_venda, this.valor, this.taxa, this.parcelas,
				this.data_venda, this.nome_cliente, this.cpf, this.forma_pagamento, this.produtos);
	}


}
