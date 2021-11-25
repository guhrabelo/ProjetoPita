 package com.pitaapp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.AgendamentoForm;
import com.pitaapp.repository.AgendamentoRepository;
import com.pitaapp.repository.ServicoRepository;
import com.pitaapp.repository.UsuarioRepository;


@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	AgendamentoRepository repository;
	@Autowired
	ServicoRepository servicoRepository;
	@Autowired
	UsuarioRepository userRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Agendamento>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Agendamento>> getAllAgendamentoByUser(@PathVariable int id){
		return ResponseEntity.ok(repository.findAllByUsuario(id));
	}
	
	@PostMapping
	public ResponseEntity<Agendamento> postAgendamento(@RequestBody AgendamentoForm agendamentoForm, UriComponentsBuilder uriBuilder){
		
		Agendamento agendamento = agendamentoForm.convert(userRepository, servicoRepository);
		
		repository.save(agendamento);
		
		URI uri = uriBuilder.path("/agendameto/{id}").buildAndExpand(agendamento.getIdAgendamento()).toUri();
		
		return ResponseEntity.created(uri).body(agendamento);
		
	}
	
	@PutMapping
	public ResponseEntity<Agendamento> putAgendamento(@RequestBody Agendamento agendamento){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(agendamento));
	}
	
	@DeleteMapping("/{id}")
	public String deleteAgendamento(@PathVariable int id) {
		repository.deleteById(id);
		return ("Agendamento deletado com sucesso!");
	}
}
