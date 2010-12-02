
package br.com.sigep.bean;

import java.util.*;


public  class Serie  {
	private long id;
	private String descricao;
	private NivelEscolar nivelEscolar; 

	public Serie () {
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
	

	public NivelEscolar getNivelEscolar () {
		return this.nivelEscolar;
	}
	
	public void setNivelEscolar (NivelEscolar nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}
	}