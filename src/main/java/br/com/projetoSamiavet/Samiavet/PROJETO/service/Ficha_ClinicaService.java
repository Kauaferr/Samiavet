package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.Ficha_ClinicaRepository;

@Service
public class Ficha_ClinicaService {
	@Autowired
	private Ficha_ClinicaRepository ficha_clinica_repository;

	public Ficha_ClinicaRepository getFicha_clinica_repository() {
		return ficha_clinica_repository;
	}
	
	public Boolean salvarFicha(FichaClinica ficha, String email) {
		
		String emailEncontrado = buscarEmail(email);
		
		String emailDigitado = ficha.getEmail();
		
		Boolean validacao = false;
		if(emailEncontrado == null ) {
			this.ficha_clinica_repository.save(ficha);
			validacao = true;
		}else if(emailEncontrado.equals(emailDigitado)) {
			validacao = false;
		}
		return validacao;
	}
	
	public String buscarEmail(String email) {
		List<FichaClinica> listaFichas = this.ficha_clinica_repository.findByEmail(email);
		
		String emailEncontrado = null;
		for(FichaClinica x : listaFichas) {
			emailEncontrado = x.getEmail();
		}
		return emailEncontrado;
	}
	
	public void excluir(Long id) {
		
		this.ficha_clinica_repository.deleteById(id);
	}
	
	public Boolean editarFicha(FichaClinica ficha, String email) {
		
			this.ficha_clinica_repository.save(ficha);
			return true;
	
	}

	public List<FichaClinica> listar(){
		return this.ficha_clinica_repository.findAll();
	}
	
	public List<FichaClinica> listarPorNome(String nome){
		return this.ficha_clinica_repository.findByNomeAnimal(nome);
	}

}
