package com.pitaapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoForm {

    private String dataAgendamento;

    private String horario;

    private String[] servicos;

    private String usuario;

    public AgendamentoForm(String dataAgendamento, String horario, String[] servico, String usuario) {
        super();
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.servicos = servico;
        this.usuario = usuario;
    }

}
