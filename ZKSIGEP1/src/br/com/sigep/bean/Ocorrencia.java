
package br.com.sigep.bean;

import java.util.*;


public  class Ocorrencia  {
	private long id;
	private Date data;
	private String descricao;
	private String punicao;
	private Aluno aluno; 

	public Ocorrencia () {
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
	
	public 	String getDescricao () {
		return this.descricao;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public 	String getPunicao () {
		return this.punicao;
	}
	
	public void setPunicao (String punicao) {
		this.punicao = punicao;
	}
	

	public Aluno getAluno () {
		return this.aluno;
	}
	
	public void setAluno (Aluno aluno) {
		this.aluno = aluno;
	}
	}