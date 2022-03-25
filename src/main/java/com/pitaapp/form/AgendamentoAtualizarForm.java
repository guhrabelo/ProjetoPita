package com.pitaapp.form;

import com.pitaapp.model.StatusAgendamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoAtualizarForm {
    private int id;
    private String dataAgendamento;
    private String horario;
    private StatusAgendamento statusAgendamento;
    private String[] servicos;

    public AgendamentoAtualizarForm(int id, String dataAgendamento, String horario, StatusAgendamento statusAgendamento, String[] servicos) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.statusAgendamento = statusAgendamento;
        this.servicos = servicos;
    }

    public AgendamentoAtualizarForm() {
    }
}
