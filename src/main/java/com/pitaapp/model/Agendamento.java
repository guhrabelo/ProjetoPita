package com.pitaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;

    @NotNull
    private String dataAgendamento;

    @NotNull
    private String horario;

    @NotNull
    private String statusAgendamento;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "agendamento_servico", joinColumns = {
            @JoinColumn(name = "fk_agendamento")
    }, inverseJoinColumns = {@JoinColumn(name = "fk_servico")})
    @JsonIgnore
    private List<Servico> servicos;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;


    public Agendamento(String dataAgendamento, String horario, List<Servico> servico, Usuario user) {
        this.dataAgendamento = dataAgendamento;
        this.horario = horario;
        this.servicos = servico;
        this.usuario = user;
        this.statusAgendamento = "Aguardando";
    }


    public Agendamento() {
        super();
    }
}
