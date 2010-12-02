
package br.com.sigep.bean;

import java.util.*;


public  class Formacao  {
	private long id;
	private String titulo;
	private String curso;
	private int anoConclusao;
	private String instituicao;
	private String especializacao;

	public Formacao () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getTitulo () {
		return this.titulo;
	}
	
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	
	public 	String getCurso () {
		return this.curso;
	}
	
	public void setCurso (String curso) {
		this.curso = curso;
	}
	
	public 	int getAnoConclusao () {
		return this.anoConclusao;
	}
	
	public void setAnoConclusao (int anoConclusao) {
		this.anoConclusao = anoConclusao;
	}
	
	public 	String getInstituicao () {
		return this.instituicao;
	}
	
	public void setInstituicao (String instituicao) {
		this.instituicao = instituicao;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	

	}