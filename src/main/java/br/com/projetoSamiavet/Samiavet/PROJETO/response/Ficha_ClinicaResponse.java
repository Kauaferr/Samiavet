package br.com.projetoSamiavet.Samiavet.PROJETO.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.projetoSamiavet.Samiavet.PROJETO.dto.FichaClinicaDto;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ficha_ClinicaResponse {
	 private HttpStatus status;
	 private List<FichaClinicaDto> ficha_clinica;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<FichaClinicaDto> getFicha_clinica() {
		return ficha_clinica;
	}
	public void setFicha_clinica(List<FichaClinicaDto> ficha_clinica) {
		this.ficha_clinica = ficha_clinica;
	}
	    
	public Ficha_ClinicaResponse() {
		
	}
}