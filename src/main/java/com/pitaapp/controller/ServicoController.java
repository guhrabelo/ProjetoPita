package com.pitaapp.controller;

import com.pitaapp.form.ServicoAtualizarForm;
import com.pitaapp.form.ServicoForm;
import com.pitaapp.model.Servico;
import com.pitaapp.repository.ServicoRepository;
import com.pitaapp.service.ServicoService;
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
    @Autowired
    ServicoService servicoService;

    @GetMapping("/all")
    public ResponseEntity<List<Servico>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/time")
    public ResponseEntity<List<Servico>> getByTempo(String tempo) {
        return ResponseEntity.ok(repository.findAllByTempoServicoContainingIgnoreCase(tempo));
    }

    @PostMapping
    public ResponseEntity<Servico> postServico(@RequestBody ServicoForm servicoForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.cadastroServico(servicoForm));
    }

    @PutMapping
    public ResponseEntity<Servico> putServico(@RequestBody ServicoAtualizarForm servicoAtualizarForm) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.atualizarServico(servicoAtualizarForm));
    }

    @DeleteMapping("/{id}")
    public String deleteServico(@PathVariable int id) {
        repository.deleteById(id);
        return ("Serviço deletado com sucesso!");
    }
}
