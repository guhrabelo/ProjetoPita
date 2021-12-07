package com.pitaapp.model;

public class UserLogin {

	private int id;
	
	private String nome;
	
	private String telefone;
	
	private String userName;
	
	private String senha;
	
	private String token;
	
	

	public UserLogin(int id, String nome, String telefone, String userName, String senha) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.userName = userName;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
