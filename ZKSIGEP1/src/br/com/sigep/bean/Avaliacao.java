
package br.com.sigep.bean;

import java.util.*;


public  class Avaliacao  {
	private long id;
	private Date data;
	private float valorTotal;
	private float peso;
	private String descricao;
	private String periodo;
	private String etapa;
	private RegistroDeDisciplina registroDeDisciplina;
	
	public Avaliacao () {
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
	
	public 	float getValorTotal () {
		return this.valorTotal;
	}
	
	public void setValorTotal (float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public 	float getPeso () {
		return this.peso;
	}
	
	public void setPeso (float peso) {
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public RegistroDeDisciplina getRegistroDeDisciplina() {
		return registroDeDisciplina;
	}

	public void setRegistroDeDisciplina(RegistroDeDisciplina registroDeDisciplina) {
		this.registroDeDisciplina = registroDeDisciplina;
	}
	
}