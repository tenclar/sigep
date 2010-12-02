
package br.com.sigep.bean;

import java.util.*;


public  class ResultadoFinal  {
	private int totalFaltas;
	
	private float notaFinal;
	private float notaSemestre1;
	private float notaSemestre2;
	private float notaRecuperacaoFinal;
	private float notaResultadoAnual;
	
	private String situacao;
	private long id;
	private Aluno aluno; 
	private RegistroDeDisciplina registroDeDisciplina; 
	
	
	private Map<String, Float> notasFinais;

	public Map<String, Float> getNotasFinais() {
		return notasFinais;
	}

	public void setNotasFinais(Map<String, Float> notasFinais) {
		this.notasFinais = notasFinais;
	}


	public ResultadoFinal () {
		super();
		notasFinais = new HashMap<String, Float>();
	}
	
	public 	int getTotalFaltas () {
		return this.totalFaltas;
	}
	
	public void setTotalFaltas (int totalFaltas) {
		this.totalFaltas = totalFaltas;
	}
	
	public 	float getNotaFinal () {
		return this.notaFinal;
	}
	
	public void setNotaFinal (float notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	public 	String getSituacao () {
		return this.situacao;
	}
	
	public void setSituacao (String situacao) {
		this.situacao = situacao;
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	

	public Aluno getAluno () {
		return this.aluno;
	}
	
	public void setAluno (Aluno aluno) {
		this.aluno = aluno;
	}
	public RegistroDeDisciplina getRegistroDeDisciplina () {
		return this.registroDeDisciplina;
	}
	
	public void setRegistroDeDisciplina (RegistroDeDisciplina registroDeDisciplina) {
		this.registroDeDisciplina = registroDeDisciplina;
	}

	public float getNotaSemestre1() {
		return notaSemestre1;
	}
	
	public void setNotaSemestre1(float notaSemestre1) {
		this.notaSemestre1 = notaSemestre1;
	}

	public float getNotaSemestre2() {
		return notaSemestre2;
	}

	public void setNotaSemestre2(float notaSemestre2) {
		this.notaSemestre2 = notaSemestre2;
	}

	public float getNotaRecuperacaoFinal() {
		return notaRecuperacaoFinal;
	}

	public void setNotaRecuperacaoFinal(float notaRecuperacaoFinal) {
		this.notaRecuperacaoFinal = notaRecuperacaoFinal;
	}

	public float getNotaResultadoAnual() {
		return notaResultadoAnual;
	}

	public void setNotaResultadoAnual(float notaResultadoAnual) {
		this.notaResultadoAnual = notaResultadoAnual;
	}
	
	
	
	
	}