package com.pitaapp.service;

import com.pitaapp.form.AgendamentoAtualizarForm;
import com.pitaapp.form.AgendamentoForm;
import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Servico;
import com.pitaapp.model.StatusAgendamento;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.AgendamentoRepository;
import com.pitaapp.repository.ServicoRepository;
import com.pitaapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    AgendamentoRepository agendamentoRepository;

    public Agendamento convert(AgendamentoForm agendamentoForm) {

        Usuario user = usuarioRepository.findByUserNameContainingIgnoreCase(agendamentoForm.getUsuario()).get();
        List<Servico> servicos = new ArrayList<>();
        for (String servico : agendamentoForm.getServicos()) {
            servicos.add(servicoRepository.findByNomeServico(servico));
        }

        StatusAgendamento statusAgendamento = StatusAgendamento.AGENDAMENTO_OK;
        Agendamento agendamento = new Agendamento(agendamentoForm.getDataAgendamento(), agendamentoForm.getHorario(), servicos, user, statusAgendamento);
        List<Agendamento> agendamentosUser = user.getAgendamento();
        agendamentosUser.add(agendamento);

        return agendamento;
    }

    public Agendamento alterarAgendamento(AgendamentoAtualizarForm agendamentoAtualizarForm) {

        Agendamento agendamento = agendamentoRepository.getById(agendamentoAtualizarForm.getId());

        agendamento.setDataAgendamento(agendamentoAtualizarForm.getDataAgendamento());
        agendamento.setStatusAgendamento(agendamentoAtualizarForm.getStatusAgendamento());
        agendamento.setHorario(agendamentoAtualizarForm.getHorario());
        if (agendamentoAtualizarForm.getServicos().length != 0) {
            List<Servico> servicos = new ArrayList<>();
            for (String servico : agendamentoAtualizarForm.getServicos()) {
                servicos.add(servicoRepository.findByNomeServico(servico));
            }
            agendamento.setServicos(servicos);
        }
        return agendamento;
    }

}
