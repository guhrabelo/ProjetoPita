package com.pitaapp.controller;

import com.pitaapp.form.AgendamentoForm;
import com.pitaapp.model.Agendamento;
import com.pitaapp.repository.AgendamentoRepository;
import com.pitaapp.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/agendamento")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class AgendamentoController {

    @Autowired
    AgendamentoRepository repository;
    @Autowired
    AgendamentoService agendamentoService;


    @GetMapping("/all")
    public ResponseEntity<List<Agendamento>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Agendamento>> getAllAgendamentoByUser(@PathVariable int id) {
        return ResponseEntity.ok(repository.findAllByUsuario(id));
    }

    @PostMapping
    public ResponseEntity<Agendamento> postAgendamento(@RequestBody AgendamentoForm agendamentoForm, UriComponentsBuilder uriBuilder) {

        Agendamento agendamento = agendamentoService.convert(agendamentoForm);

        repository.save(agendamento);

        URI uri = uriBuilder.path("/agendameto/{id}").buildAndExpand(agendamento.getIdAgendamento()).toUri();

        return ResponseEntity.created(uri).body(agendamento);

    }

    @PutMapping
    public ResponseEntity<Agendamento> putAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(agendamento));
    }

    @DeleteMapping("/{id}")
    public String deleteAgendamento(@PathVariable int id) {
        repository.deleteById(id);
        return ("Agendamento deletado com sucesso!");
    }
}
