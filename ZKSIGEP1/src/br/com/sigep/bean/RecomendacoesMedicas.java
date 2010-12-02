
package br.com.sigep.bean;

import java.util.*;


public  class RecomendacoesMedicas  {
	private long id;
	private String descricao;

	public RecomendacoesMedicas () {
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