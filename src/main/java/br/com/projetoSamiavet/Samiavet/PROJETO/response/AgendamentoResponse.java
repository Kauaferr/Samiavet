package br.com.projetoSamiavet.Samiavet.PROJETO.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.projetoSamiavet.Samiavet.PROJETO.dto.AgendamentoDto;

public class AgendamentoResponse {

	
	private HttpStatus status;
	private List<AgendamentoDto> agendamento;
	 
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	    
	public List<AgendamentoDto>getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(List<AgendamentoDto> Agendamento) {
		this.agendamento = Agendamento;
	}
	public AgendamentoResponse() {
		
	}
}
