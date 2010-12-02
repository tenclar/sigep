
package br.com.sigep.bean;

import java.util.*;


public  class Frequencia  {
	private long id;
	private int qtdAula;
	private String periodo;
	private RegistroDeDisciplina registroDeDisciplina;
	private Aluno aluno;

	public Frequencia () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public 	int getQtdAula () {
		return this.qtdAula;
	}
	
	public void setQtdAula (int qtdAula) {
		this.qtdAula = qtdAula;
	}
	
	public RegistroDeDisciplina getRegistroDeDisciplina() {
		return registroDeDisciplina;
	}

	public void setRegistroDeDisciplina(RegistroDeDisciplina registroDeDisciplina) {
		this.registroDeDisciplina = registroDeDisciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}