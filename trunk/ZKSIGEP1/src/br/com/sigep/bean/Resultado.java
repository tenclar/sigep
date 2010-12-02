
package br.com.sigep.bean;

import java.util.*;


public  class Resultado  {
	private long id;
	private float nota;
	private Avaliacao avaliacao; 
	private Aluno aluno; 
	

	public Resultado () {
		super();
		
	}
	
	
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	float getNota () {
		return this.nota;
	}
	
	public void setNota (float nota) {
		this.nota = nota;
	}
	

	public Avaliacao getAvaliacao () {
		return this.avaliacao;
	}
	
	public void setAvaliacao (Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Aluno getAluno () {
		return this.aluno;
	}
	
	public void setAluno (Aluno aluno) {
		this.aluno = aluno;
	}
	}