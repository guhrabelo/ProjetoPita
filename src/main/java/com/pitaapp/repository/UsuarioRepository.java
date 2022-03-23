package com.pitaapp.repository;

import com.pitaapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

    Optional<Usuario> findAllByCpfContainingIgnoreCase(String cpf);

    Optional<Usuario> findByUserNameContainingIgnoreCase(String userName);

}
