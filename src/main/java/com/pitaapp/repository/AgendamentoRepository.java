package com.pitaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Usuario;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
	public List<Agendamento> findAllByDataContainingIgnoreCase(String data);
	
	public List<Agendamento> findAllByUsuarioContainingIgnoreCase(Usuario usuario);
}
