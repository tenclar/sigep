
package br.com.sigep.bean;

import java.util.*;


public  class Afastamento  {
	private long id;
	private String descricao;
	private Date dataSaida;
	private Date dataVolta;
	private Professor professor; 

	public Afastamento () {
		setProfessor(new Professor());
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
	
	public 	Date getDataSaida () {
		return this.dataSaida;
	}
	
	public void setDataSaida (Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public 	Date getDataVolta () {
		return this.dataVolta;
	}
	
	public void setDataVolta (Date dataVolta) {
		this.dataVolta = dataVolta;
	}
	
	public Professor getProfessor () {
		return this.professor;
	}
	
	public void setProfessor (Professor professor) {
		this.professor = professor;
	}
	}