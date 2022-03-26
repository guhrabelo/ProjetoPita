package com.pitaapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoForm {
    private String nomeServico;
    private double precoServico;
    private String tempoServico;

    public ServicoForm(String nomeServico, double precoServico, String tempoServico) {
        this.nomeServico = nomeServico;
        this.precoServico = precoServico;
        this.tempoServico = tempoServico;
    }

    public ServicoForm() {
    }
}
