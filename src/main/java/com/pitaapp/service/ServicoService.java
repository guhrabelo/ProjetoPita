package com.pitaapp.service;

import com.pitaapp.form.ServicoAtualizarForm;
import com.pitaapp.form.ServicoForm;
import com.pitaapp.model.Servico;
import com.pitaapp.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository repository;

    public Servico cadastroServico(ServicoForm servicoForm){
        Servico servico = new Servico();
        servico.setTempoServico(servicoForm.getTempoServico());
        servico.setPrecoServico(servicoForm.getPrecoServico());
        servico.setNomeServico(servicoForm.getNomeServico());
        repository.save(servico);

        return servico;
    }

    public Servico atualizarServico(ServicoAtualizarForm servicoAtualizarForm){
        Servico servico = repository.getById(servicoAtualizarForm.getId());
        if (servicoAtualizarForm.getNome()!=null){
            servico.setNomeServico(servicoAtualizarForm.getNome());
        }
        if (servicoAtualizarForm.getPreco()!=servico.getPrecoServico()){
            servico.setPrecoServico(servicoAtualizarForm.getPreco());
        }
        if (servicoAtualizarForm.getTempo()!=null){
            servico.setTempoServico(servico.getTempoServico());
        }
        repository.save(servico);
        return servico;
    }


}
