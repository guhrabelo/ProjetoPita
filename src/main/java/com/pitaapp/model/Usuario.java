package com.pitaapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String nome;
	
	
	private String dataNascimento;
	
	
	private String telefone;
	
	@NotNull
	@Email(message = "O atributo deve ser um e-mail")
	private String userName;
	
	@NotNull
	@NotBlank
	private String senha;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "usuario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List <Agendamento> agendamentos;
	
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, @NotNull String cpf, @NotNull String nome, @NotNull String dataNascimento, String telefone, String userName) {
		this.idUsuario = idUsuario;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.userName = userName;
	}


	public List<Agendamento> getAgendamento() {
		return agendamentos;
	}

}
