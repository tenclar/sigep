
package br.com.sigep.bean;

import java.util.*;


public  class Permissao  {
	private long id;
	private int nivel;
	private TipoDeUsuario tipoDeUsuario; 

	public Permissao () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	int getNivel () {
		return this.nivel;
	}
	
	public void setNivel (int nivel) {
		this.nivel = nivel;
	}
	

	public TipoDeUsuario getTipoDeUsuario () {
		return this.tipoDeUsuario;
	}
	
	public void setTipoDeUsuario (TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	}