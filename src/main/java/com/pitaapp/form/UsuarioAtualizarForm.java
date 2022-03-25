package com.pitaapp.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAtualizarForm {

    private int id;
    private String nome;
    private String userName;
    private String telefone;
    private String token;


    public UsuarioAtualizarForm(String nome, String userName, String senha, String telefone) {
        super();
        this.nome = nome;
        this.userName = userName;
        this.telefone = telefone;
    }


    public UsuarioAtualizarForm() {
        super();
    }


}
