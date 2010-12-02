
package br.com.sigep.bean;

import java.util.*;


public  class Disciplina  {
	private long id;
	private String nome;
	private int cargaHoraria;
	private Serie serie; 

	public Disciplina () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public 	int getCargaHoraria () {
		return this.cargaHoraria;
	}
	
	public void setCargaHoraria (int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	

	public Serie getSerie () {
		return this.serie;
	}
	
	public void setSerie (Serie serie) {
		this.serie = serie;
	}
	}