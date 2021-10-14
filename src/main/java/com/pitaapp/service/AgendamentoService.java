package com.pitaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.UsuarioRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	UsuarioRepository userRepository;
	
	public List<Agendamento> findByUser(int idUser) {
		Usuario user = new Usuario();
		
		user = userRepository.getById(idUser);
		
		if(user != null) {
			return user.getAgendamento();
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe agendamentos para este user.", null);
		}
	}
	
}
