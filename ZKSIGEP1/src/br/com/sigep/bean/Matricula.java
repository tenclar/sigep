
package br.com.sigep.bean;

import java.util.*;


public  class Matricula  {
	private long id;
	private String numero;
	private int codigoMec;
	private int cre;
	private Turma turma; 

	public Matricula () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getNumero () {
		return this.numero;
	}
	
	public void setNumero (String numero) {
		this.numero = numero;
	}
	
	public 	int getCodigoMec () {
		return this.codigoMec;
	}
	
	public void setCodigoMec (int codigoMec) {
		this.codigoMec = codigoMec;
	}
	
	public 	int getCre () {
		return this.cre;
	}
	
	public void setCre (int cre) {
		this.cre = cre;
	}
	

	public Turma getTurma () {
		return this.turma;
	}
	
	public void setTurma (Turma turma) {
		this.turma = turma;
	}
	}