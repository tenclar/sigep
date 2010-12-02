
package br.com.sigep.bean;

import java.util.*;


public  class Endereco  {
	private long id;
	private String logradouro;
	private int numero;
	private String cidade;
	private String uf;
	private String bairro;
	private String referencia;
	private String cep;

	public Endereco () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getLogradouro () {
		return this.logradouro;
	}
	
	public void setLogradouro (String logradouro) {
		this.logradouro = logradouro;
	}
	
	public 	int getNumero () {
		return this.numero;
	}
	
	public void setNumero (int numero) {
		this.numero = numero;
	}
	
	public 	String getCidade () {
		return this.cidade;
	}
	
	public void setCidade (String cidade) {
		this.cidade = cidade;
	}
	
	public 	String getUf () {
		return this.uf;
	}
	
	public void setUf (String uf) {
		this.uf = uf;
	}
	
	public 	String getBairro () {
		return this.bairro;
	}
	
	public void setBairro (String bairro) {
		this.bairro = bairro;
	}
	
	public 	String getReferencia () {
		return this.referencia;
	}
	
	public void setReferencia (String referencia) {
		this.referencia = referencia;
	}
	
	public 	String getCep () {
		return this.cep;
	}
	
	public void setCep (String cep) {
		this.cep = cep;
	}
	

	}