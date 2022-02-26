package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long>  {

	List<Vendas> findByIdVenda(Long id);
}
