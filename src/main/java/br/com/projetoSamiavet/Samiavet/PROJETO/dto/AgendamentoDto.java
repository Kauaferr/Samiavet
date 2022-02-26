package br.com.projetoSamiavet.Samiavet.PROJETO.dto;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Agendamento;

public class AgendamentoDto {

	private Long id;
	private String titulo;
	private String nomeProprietario; 
	private String nomeAnimal;
	private String atendimento; 
	private String dataInicio;
	private String dataTermino;
	private String observacao;
	
	
	
	
	
	
	public AgendamentoDto(Long id, String titulo, String nomeProprietario, String nomeAnimal, String atendimento,
			String dataInicio, String dataTermino, String observacao) {
		this.id = id;
		this.titulo = titulo;
		this.nomeProprietario = nomeProprietario;
		this.nomeAnimal = nomeAnimal;
		this.atendimento = atendimento;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.observacao = observacao;
	}
	
	
	public AgendamentoDto() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Agendamento transformaParaObjeto() {
		
		return new Agendamento(this.id, this.titulo, this.nomeProprietario, this.nomeAnimal, this.atendimento,
								this.dataInicio, this.dataTermino, this.observacao
				
				);
	}
	
}
