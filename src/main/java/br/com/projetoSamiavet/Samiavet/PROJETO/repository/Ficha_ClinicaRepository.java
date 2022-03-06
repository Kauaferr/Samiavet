package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;


@Repository
public interface Ficha_ClinicaRepository extends JpaRepository<FichaClinica, Long>  {

	List<FichaClinica> findByEmail(String email);
	List<FichaClinica> findByNomeAnimal(String nomeAnimal);
	
}
