package com.pitaapp.dto;

import com.pitaapp.model.Agendamento;
import com.pitaapp.model.Servico;
import com.pitaapp.model.Usuario;
import com.pitaapp.repository.ServicoRepository;
import com.pitaapp.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoForm {

    private String dataAgendamento;

    private String horario;

    private String[] servicos;

    private String usuario;

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String[] getServico() {
        return servicos;
    }

    public void setServico(String[] servico) {
        this.servicos = servico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public AgendamentoForm(String dataAgendamento, String horario, String[] servico, String usuario) {
        super();
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.servicos = servico;
        this.usuario = usuario;
    }


    public Agendamento convert(UsuarioRepository repository, ServicoRepository serviceRepository) {

        Usuario user = repository.findByUserNameContainingIgnoreCase(usuario).get();

        List<Servico> services = new ArrayList<>();

        for (String servico : servicos) {

            Servico service = serviceRepository.findByNomeServico(servico);

            if (service != null) {
                services.add(service);
            }
        }

        Agendamento agendamento = new Agendamento(dataAgendamento, horario, services, user);

        List<Agendamento> agendamentosUser = user.getAgendamento();

        agendamentosUser.add(agendamento);

        return agendamento;

    }
}
