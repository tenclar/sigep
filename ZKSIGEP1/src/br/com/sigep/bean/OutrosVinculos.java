
package br.com.sigep.bean;

import java.util.*;


public  class OutrosVinculos  {
	private long id;
	private boolean status;
	private int cargaHoraria;
	private String cargo;
	private String orgao;

	public OutrosVinculos () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	boolean getStatus () {
		return this.status;
	}
	
	public void setStatus (boolean status) {
		this.status = status;
	}
	
	public 	int getCargaHoraria () {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria (int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public 	String getCargo () {
		return this.cargo;
	}
	
	public void setCargo (String cargo) {
		this.cargo = cargo;
	}
	
	public 	String getOrgao () {
		return this.orgao;
	}
	
	public void setOrgao (String orgao) {
		this.orgao = orgao;
	}
	

	}