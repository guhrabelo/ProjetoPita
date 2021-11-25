package com.pitaapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JoinTable(name="agendamento_servico", joinColumns = {
			@JoinColumn(name="fk_agendamento")
	}, inverseJoinColumns = { @JoinColumn(name="fk_servico") })
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


	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

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

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public List<Servico> getServico() {
		return servicos;
	}

	public void setServico(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
