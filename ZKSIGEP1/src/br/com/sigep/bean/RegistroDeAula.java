
package br.com.sigep.bean;

import java.util.*;


public  class RegistroDeAula  {
	private long id;
	private Date data;
	private String assunto;
	private int qtdAula;
	private RegistroDeDisciplina registroDeDisciplina;

	public RegistroDeAula () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	Date getData () {
		return this.data;
	}
	
	public void setData (Date data) {
		this.data = data;
	}
	
	public 	String getAssunto () {
		return this.assunto;
	}
	
	public void setAssunto (String assunto) {
		this.assunto = assunto;
	}
	
	public 	int getQtdAula () {
		return this.qtdAula;
	}
	
	public void setQtdAula (int qtdAula) {
		this.qtdAula = qtdAula;
	}

	public RegistroDeDisciplina getRegistroDeDisciplina() {
		return registroDeDisciplina;
	}

	public void setRegistroDeDisciplina(RegistroDeDisciplina registroDeDisciplina) {
		this.registroDeDisciplina = registroDeDisciplina;
	}

}