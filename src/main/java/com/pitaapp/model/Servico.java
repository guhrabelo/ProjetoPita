package com.pitaapp.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	public int getId() {
		return idServico;
	}

	public void setId(int id) {
		this.idServico = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public double getPrecoServico() {
		return precoServico;
	}

	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}

	public String getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(String tempoServico) {
		this.tempoServico = tempoServico;
	}
}
