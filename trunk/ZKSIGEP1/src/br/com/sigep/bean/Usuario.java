
package br.com.sigep.bean;

import java.util.*;


public  class Usuario  {
	private long id;
	private String usuario;
	private String senha;
	private TipoDeUsuario tipoDeUsuario;

	public Usuario () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getUsuario () {
		return this.usuario;
	}
	
	public void setUsuario (String usuario) {
		this.usuario = usuario;
	}
	
	public 	String getSenha () {
		return this.senha;
	}
	
	public void setSenha (String senha) {
		this.senha = senha;
	}
	
	public TipoDeUsuario getTipoDeUsuario () {
		return this.tipoDeUsuario;
	}
	
	public void setTipoDeUsuario (TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	}