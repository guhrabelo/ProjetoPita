package com.pitaapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoAtualizarForm {

    private int id;
    private String nome;
    private double preco;
    private String tempo;

    public ServicoAtualizarForm(int id, String nome, double preco, String tempo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tempo = tempo;
    }

    public ServicoAtualizarForm() {
    }
}
