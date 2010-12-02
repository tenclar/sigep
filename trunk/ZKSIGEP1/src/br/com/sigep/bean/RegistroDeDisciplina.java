
package br.com.sigep.bean;

import java.util.*;


public  class RegistroDeDisciplina  {
	private long id;
	private Turma turma; 
	private Disciplina disciplina; 
	private Professor professor; 
	private int ordem; // -->>> colocar um campo no registro de disciplina para facilitar o select, ordenando por esse atributo
	
	
	public RegistroDeDisciplina () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public Turma getTurma () {
		return this.turma;
	}
	
	public void setTurma (Turma turma) {
		this.turma = turma;
	}
	
	public Disciplina getDisciplina () {
		return this.disciplina;
	}
	
	public void setDisciplina (Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Professor getProfessor () {
		return this.professor;
	}
	
	public void setProfessor (Professor professor) {
		this.professor = professor;
	}
	
}