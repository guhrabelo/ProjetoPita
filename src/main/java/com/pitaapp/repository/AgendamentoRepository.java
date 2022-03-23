package com.pitaapp.repository;


import com.pitaapp.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Component
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("select a from Agendamento a join a.usuario u where u.idUsuario = :id")
    List<Agendamento> findAllByUsuario(@Param("id") int id);

}
