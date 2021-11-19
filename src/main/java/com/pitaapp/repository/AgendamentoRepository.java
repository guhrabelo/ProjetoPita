package com.pitaapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pitaapp.model.Agendamento;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

	@Query("select a from Agendamento a join a.usuario u where u.idUsuario = :id") 
	List<Agendamento> findAllByUsuario(@Param("id")int id);
	
	//List<Agendamento> findByUsuario_IdUsuario(int id);
}
