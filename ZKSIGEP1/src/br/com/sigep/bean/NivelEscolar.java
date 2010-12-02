
package br.com.sigep.bean;

import java.util.*;


public  class NivelEscolar  {
	private long id;
	private String nivel;
	private int etapas;

	public NivelEscolar () {
		super();
	}
	
	public NivelEscolar(String nivel, int etapas){
		this.nivel = nivel;
		this.etapas = etapas;
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getNivel () {
		return this.nivel;
	}
	
	public void setNivel (String nivel) {
		this.nivel = nivel;
	}
	
	public 	int getEtapas () {
		return this.etapas;
	}
	
	public void setEtapas (int etapas) {
		this.etapas = etapas;
	}
	

	}