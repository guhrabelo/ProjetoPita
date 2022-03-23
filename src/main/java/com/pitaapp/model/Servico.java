package com.pitaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;

    @NotNull
    private String nomeServico;

    @NotNull
    @Min(0)
    private double precoServico;

    @NotNull
    private String tempoServico;

    @ManyToMany(mappedBy = "servicos", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Agendamento> agendamento;
}
