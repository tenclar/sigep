
package br.com.sigep.bean;

import java.util.*;


public  class Professor extends Funcionario {
	private boolean status;
	private DadosFuncionais dadosFuncionais;

	public Professor () {
		setDadosFuncionais(new DadosFuncionais());
	}
	
	public 	boolean getStatus () {
		return this.status;
	}
	
	public void setStatus (boolean status) {
		this.status = status;
	}

	public DadosFuncionais getDadosFuncionais () {
		return this.dadosFuncionais;
	}
	
	public void setDadosFuncionais (DadosFuncionais dadosFuncionais) {
		this.dadosFuncionais = dadosFuncionais;
	}

	}