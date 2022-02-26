package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Agendamento;
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
