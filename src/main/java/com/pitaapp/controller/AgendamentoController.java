package com.pitaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitaapp.model.Agendamento;
import com.pitaapp.repository.AgendamentoRepository;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	AgendamentoRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Agendamento>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Agendamento>> getAllAgendamentoByUser(@PathVariable int id){
		return ResponseEntity.ok(repository.findUserLike(id));
	}
	
	public ResponseEntity<Agendamento> postAgendamento(@RequestBody Agendamento agendamento){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(agendamento));
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
