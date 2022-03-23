package com.pitaapp.controller;

import com.pitaapp.model.Servico;
import com.pitaapp.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ServicoController {

    @Autowired
    ServicoRepository repository;


    @GetMapping("/all")
    public ResponseEntity<List<Servico>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/time")
    public ResponseEntity<List<Servico>> getByTempo(String tempo) {
        return ResponseEntity.ok(repository.findAllByTempoServicoContainingIgnoreCase(tempo));
    }

    @PostMapping
    public ResponseEntity<Servico> postServico(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(servico));
    }

    @PutMapping
    public ResponseEntity<Servico> putServico(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(servico));
    }

    @DeleteMapping("/{id}")
    public String deleteServico(@PathVariable int id) {
        repository.deleteById(id);
        return ("Serviço deletado com sucesso!");
    }
}
