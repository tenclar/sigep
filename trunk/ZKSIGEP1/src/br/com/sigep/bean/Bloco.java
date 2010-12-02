
package br.com.sigep.bean;

import java.util.*;


public  class Bloco  {
	private long id;
	private int qtdSala;
	private String nome;

	public Bloco () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	int getQtdSala () {
		return this.qtdSala;
	}
	
	public void setQtdSala (int qtdSala) {
		this.qtdSala = qtdSala;
	}
	
	public 	String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	

	}