
package br.com.sigep.bean;

import java.util.*;


public  class Turma  {
	private long id;
	private int qtdAluno;
	private String nome;
	private String turno;
	private String modalidade;
	private AnoLetivo anoLetivo; 
	private Sala sala; 
	private Serie serie; 

	public Turma () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	int getQtdAluno () {
		return this.qtdAluno;
	}
	
	public void setQtdAluno (int qtdAluno) {
		this.qtdAluno = qtdAluno;
	}
	
	public 	String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public 	String getTurno () {
		return this.turno;
	}
	
	public void setTurno (String turno) {
		this.turno = turno;
	}
	
	public 	String getModalidade () {
		return this.modalidade;
	}
	
	public void setModalidade (String modalidade) {
		this.modalidade = modalidade;
	}
	

	public AnoLetivo getAnoLetivo () {
		return this.anoLetivo;
	}
	
	public void setAnoLetivo (AnoLetivo anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public Sala getSala () {
		return this.sala;
	}
	
	public void setSala (Sala sala) {
		this.sala = sala;
	}
	public Serie getSerie () {
		return this.serie;
	}
	
	public void setSerie (Serie serie) {
		this.serie = serie;
	}
	}