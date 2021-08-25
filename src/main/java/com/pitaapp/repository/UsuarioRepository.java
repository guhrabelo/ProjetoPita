package com.pitaapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pitaapp.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	public Optional <Usuario> findAllByCpfContainigIgnoreCase(String cpf);
	
	public Optional <Usuario> findByUserName(String userName);
}
