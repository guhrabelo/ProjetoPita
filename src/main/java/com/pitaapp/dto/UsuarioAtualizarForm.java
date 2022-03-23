package com.pitaapp.dto;

import java.util.Optional;

import com.pitaapp.model.Usuario;
import com.pitaapp.repository.UsuarioRepository;

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


	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}


	public Usuario converter(UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.findById(id).get();
		
		if(this.nome != null) {
			usuario.setNome(nome);
		}
		if(this.telefone != null) {
			usuario.setTelefone(telefone);
		}
		if(this.userName != null) {
			usuario.setUserName(userName);
		}
		
		return usuario;
	}

	
	
	
}
