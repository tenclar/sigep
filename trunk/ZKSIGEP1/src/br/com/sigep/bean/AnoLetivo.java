
package br.com.sigep.bean;

import java.util.*;


public  class AnoLetivo  {
	private int ano;
	private Date dataInicio;
	private Date dataFim;
	private long id;

	public AnoLetivo () {
		super();
	}
	
		
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public 	Date getDataInicio () {
		return this.dataInicio;
	}
	
	public void setDataInicio (Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public 	Date getDataFim () {
		return this.dataFim;
	}
	
	public void setDataFim (Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	

	}