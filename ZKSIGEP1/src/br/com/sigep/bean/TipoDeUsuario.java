
package br.com.sigep.bean;

import java.util.*;


public  class TipoDeUsuario  {
	private long id;
	private String descricao;

	public TipoDeUsuario () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getDescricao () {
		return this.descricao;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	

	}