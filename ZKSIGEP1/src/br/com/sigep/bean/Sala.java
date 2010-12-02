
package br.com.sigep.bean;

import java.util.*;


public  class Sala  {
	private long id;
	private int numero;
	private String descricao;
	private Bloco bloco; 

	public Sala () {
		super();
	}
	
	public Sala(int numero, String descricao, Bloco bloco){
		this.numero = numero;
		this.descricao = descricao;
		this.bloco = bloco;
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	int getNumero () {
		return this.numero;
	}
	
	public void setNumero (int numero) {
		this.numero = numero;
	}
	
	public 	String getDescricao () {
		return this.descricao;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	

	public Bloco getBloco () {
		return this.bloco;
	}
	
	public void setBloco (Bloco bloco) {
		this.bloco = bloco;
	}
	}