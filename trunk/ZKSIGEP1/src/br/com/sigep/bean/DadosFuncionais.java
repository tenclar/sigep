
package br.com.sigep.bean;

import java.util.*;


public  class DadosFuncionais  {
	private long id;
	private String disciplinas;
	private String series;
	private String nivel;
	private String matricula1;
	private Date dataAdmi1;
	private String matricula2;
	private Date dataAdmi2;
	private String unidade;
	private Endereco endereco;
	
	public DadosFuncionais () {
		setEndereco(new Endereco());
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
		
	public 	String getDisciplinas () {
		return this.disciplinas;
	}
	
	public void setDisciplinas (String disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public 	String getSeries () {
		return this.series;
	}
	
	public void setSeries (String series) {
		this.series = series;
	}
	
	public 	String getNivel () {
		return this.nivel;
	}
	
	public void setNivel (String nivel) {
		this.nivel = nivel;
	}
	
	public 	String getMatricula1 () {
		return this.matricula1;
	}
	
	public void setMatricula1 (String matricula1) {
		this.matricula1 = matricula1;
	}
	
	public 	Date getDataAdmi1 () {
		return this.dataAdmi1;
	}
	
	public void setDataAdmi1 (Date dataAdmi1) {
		this.dataAdmi1 = dataAdmi1;
	}
	
	public 	String getMatricula2 () {
		return this.matricula2;
	}
	
	public void setMatricula2 (String matricula2) {
		this.matricula2 = matricula2;
	}
	
	public 	Date getDataAdmi2 () {
		return this.dataAdmi2;
	}
	
	public void setDataAdmi2 (Date dataAdmi2) {
		this.dataAdmi2 = dataAdmi2;
	}
	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	}