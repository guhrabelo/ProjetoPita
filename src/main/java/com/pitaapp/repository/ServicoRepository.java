package com.pitaapp.repository;

import com.pitaapp.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    List<Servico> findAllByTempoServicoContainingIgnoreCase(String tempoServico);

    Servico findByNomeServico(String servico);
}
