
package br.com.sigep.bean;

import java.util.*;


public  class Registro  {
	private long id;
	private int numeroRegistro;//Nome da variável foi alterado de numero para numeroRegistro
	private int numeroLivro;//
	private String nomeCartorio;//
	private String cidadeReg;//
	private String ufReg;//

	public Registro () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	
	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	public int getNumeroLivro() {
		return numeroLivro;
	}

	public void setNumeroLivro(int numeroLivro) {
		this.numeroLivro = numeroLivro;
	}

	public 	String getNomeCartorio () {
		return this.nomeCartorio;
	}
	
	public void setNomeCartorio (String nomeCartorio) {
		this.nomeCartorio = nomeCartorio;
	}
	
	public 	String getCidadeReg () {
		return this.cidadeReg;
	}
	
	public void setCidadeReg (String cidadeReg) {
		this.cidadeReg = cidadeReg;
	}
	
	public 	String getUfReg () {
		return this.ufReg;
	}
	
	public void setUfReg (String ufReg) {
		this.ufReg = ufReg;
	}
	

	}