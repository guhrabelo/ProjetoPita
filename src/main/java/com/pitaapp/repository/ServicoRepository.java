package com.pitaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pitaapp.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	public List<Servico> findAllByNomeServicoContainingIgnoreCase(String nomeServico);
	
	public List<Servico> findAllByTempoServicoContainingIgnoreCase(String tempoServico);
	
	public List<Servico> findAllByPrecoServicoContainingIgnoreCase(Double precoServico);
}
