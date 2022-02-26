package br.com.projetoSamiavet.Samiavet.PROJETO.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.projetoSamiavet.Samiavet.PROJETO.dto.ProdutosDTO;

public class ProdutoResponse {

	
	private HttpStatus status;
	private List<ProdutosDTO> produtos;
	  
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<ProdutosDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosDTO> produtos) {
		this.produtos = produtos;
	}

	public ProdutoResponse() {
		
	}
}
