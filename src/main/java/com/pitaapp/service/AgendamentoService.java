package com.pitaapp.service;

import com.pitaapp.form.AgendamentoForm;
import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Servico;
import com.pitaapp.model.StatusAgendamento;
import com.pitaapp.model.Usuario;
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

    public Agendamento convert(AgendamentoForm agendamentoForm) {

        Usuario user = usuarioRepository.findByUserNameContainingIgnoreCase(agendamentoForm.getUsuario()).get();

        List<Servico> services = new ArrayList<>();

        for (String servico : agendamentoForm.getServicos()) {

            Servico service = servicoRepository.findByNomeServico(servico);

            if (service != null) {
                services.add(service);
            }
        }

        StatusAgendamento statusAgendamento = StatusAgendamento.AGENDAMENTO_OK;
        Agendamento agendamento = new Agendamento(agendamentoForm.getDataAgendamento(), agendamentoForm.getHorario(), services, user, statusAgendamento);

        List<Agendamento> agendamentosUser = user.getAgendamento();

        agendamentosUser.add(agendamento);

        return agendamento;

    }

}
