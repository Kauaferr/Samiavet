package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.dto.FichaClinicaDto;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.Ficha_ClinicaRepository;
import br.com.projetoSamiavet.Samiavet.PROJETO.response.Ficha_ClinicaResponse;

@Service
public class Ficha_ClinicaService {
	@Autowired
	private Ficha_ClinicaRepository ficha_clinica_repository;

	public Ficha_ClinicaRepository getFicha_clinica_repository() {
		return ficha_clinica_repository;
	}
	
	public Boolean salvarFicha(FichaClinicaDto ficha, String email) {
		
		String emailEncontrado = buscarEmail(email);
		
		String emailDigitado = ficha.getEmail();
		
		Boolean validacao = false;
		if(emailEncontrado == null ) {
			this.ficha_clinica_repository.save(ficha.transformaParaObjeto());
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
	
	public void excluir(Integer id) {
		
		this.ficha_clinica_repository.deleteById(id);
	}
	
	public Boolean editarFicha(FichaClinicaDto ficha, String email) {
		
			this.ficha_clinica_repository.save(ficha.transformaParaObjeto());
			return true;
	
	}
	
public  ResponseEntity<Ficha_ClinicaResponse> listarFichas(){
		
		
		List<FichaClinica> listaTodos  = this.ficha_clinica_repository.findAll();
        List<FichaClinicaDto> fichasDTO = new ArrayList<FichaClinicaDto>();

		for(int cont = 0; cont< listaTodos.size(); cont++ ) {
			FichaClinicaDto ficha = new FichaClinicaDto();
			
			ficha.setId(listaTodos.get(cont).getId());
			ficha.setNome_proprietario(listaTodos.get(cont).getNome_proprietario());
			ficha.setTelefone(listaTodos.get(cont).getTelefone());
			ficha.setEmail(listaTodos.get(cont).getEmail());
			ficha.setEndereco(listaTodos.get(cont).getEndereco());
			ficha.setCpf(listaTodos.get(cont).getCpf());
			ficha.setNomeAnimal(listaTodos.get(cont).getNomeAnimal());
			ficha.setEspecie_animal(listaTodos.get(cont).getEspecie_animal());
			ficha.setRaca_animal(listaTodos.get(cont).getRaca_animal());
			ficha.setSexo_animal(listaTodos.get(cont).getSexo_animal());
			ficha.setHistorico_animal(listaTodos.get(cont).getHistorico_animal());
			ficha.setFc_animal(listaTodos.get(cont).getFc_animal());
			ficha.setFr_animal(listaTodos.get(cont).getFr_animal());
			ficha.setP_animal(listaTodos.get(cont).getP_animal());
			ficha.setT_animal(listaTodos.get(cont).getT_animal());
			ficha.setData_nascimento_animal(listaTodos.get(cont).getData_nascimento_animal());
			ficha.setPelugem_animal(listaTodos.get(cont).getPelugem_animal());
			ficha.setPeso_animal(listaTodos.get(cont).getPeso_animal());
			ficha.setData_registro_animal(listaTodos.get(cont).getData_registro_animal());

			fichasDTO.add(ficha);

		}
		
		Ficha_ClinicaResponse fichaResponse = new Ficha_ClinicaResponse();
		fichaResponse.setStatus(HttpStatus.OK);
		fichaResponse.setFicha_clinica(fichasDTO);
        return new  ResponseEntity<Ficha_ClinicaResponse>(fichaResponse, fichaResponse.getStatus());

	}

public  ResponseEntity<Ficha_ClinicaResponse> listarFichasPorNomeAnimal(@PathVariable String nomeAnimal){
	
	
	List<FichaClinica> listaTodos  = this.ficha_clinica_repository.findByNomeAnimal(nomeAnimal);
    List<FichaClinicaDto> fichasDTO = new ArrayList<FichaClinicaDto>();

	for(int cont = 0; cont< listaTodos.size(); cont++ ) {
		FichaClinicaDto ficha = new FichaClinicaDto();
		
		ficha.setId(listaTodos.get(cont).getId());
		ficha.setNome_proprietario(listaTodos.get(cont).getNome_proprietario());
		ficha.setTelefone(listaTodos.get(cont).getTelefone());
		ficha.setEmail(listaTodos.get(cont).getEmail());
		ficha.setEndereco(listaTodos.get(cont).getEndereco());
		ficha.setCpf(listaTodos.get(cont).getCpf());
		ficha.setNomeAnimal(listaTodos.get(cont).getNomeAnimal());			
		ficha.setEspecie_animal(listaTodos.get(cont).getEspecie_animal());
		ficha.setRaca_animal(listaTodos.get(cont).getRaca_animal());
		ficha.setSexo_animal(listaTodos.get(cont).getSexo_animal());
		ficha.setHistorico_animal(listaTodos.get(cont).getHistorico_animal());
		ficha.setFc_animal(listaTodos.get(cont).getFc_animal());
		ficha.setFr_animal(listaTodos.get(cont).getFr_animal());
		ficha.setP_animal(listaTodos.get(cont).getP_animal());
		ficha.setT_animal(listaTodos.get(cont).getT_animal());
		ficha.setData_nascimento_animal(listaTodos.get(cont).getData_nascimento_animal());
		ficha.setPelugem_animal(listaTodos.get(cont).getPelugem_animal());
		ficha.setPeso_animal(listaTodos.get(cont).getPeso_animal());
		ficha.setData_registro_animal(listaTodos.get(cont).getData_registro_animal());

		fichasDTO.add(ficha);

	}
	
	Ficha_ClinicaResponse fichaResponse = new Ficha_ClinicaResponse();
	fichaResponse.setStatus(HttpStatus.OK);
	fichaResponse.setFicha_clinica(fichasDTO);
    return new  ResponseEntity<Ficha_ClinicaResponse>(fichaResponse, fichaResponse.getStatus());

}
	public List<FichaClinica> listar(){
		return this.ficha_clinica_repository.findAll();
	}
	
}
