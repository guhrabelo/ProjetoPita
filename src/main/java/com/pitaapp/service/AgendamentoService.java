package com.pitaapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.UsuarioRepository;

/*Atribuição dos agendamentos no user*/

@Service
public class AgendamentoService {
	
	@Autowired
	UsuarioRepository userRepository;
	@Autowired
	UsuarioService userService;
	
	public List<Agendamento> findByUser(int idUser /*receber o agendamento como parametro tbm*/) {
		Usuario usuario = new Usuario();
		
		Optional<Usuario> user = userRepository.findById(idUser);
		
		usuario = user.get();
		System.out.println(usuario.getAgendamento());
		
		return usuario.getAgendamento();

		
		
	}
	
//	public void atribui(Agendamento agendamento) {
//		userService.atribuiAgendamento(agendamento);
//	}
	
}
