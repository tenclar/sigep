
package br.com.sigep.bean;

import java.util.*;


public  class DadosBancarios  {
	private long id;
	private String banco;
	private String agencia;
	private String operacao;
	private String conta;

	public DadosBancarios () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getBanco () {
		return this.banco;
	}
	
	public void setBanco (String banco) {
		this.banco = banco;
	}
	
	public 	String getAgencia () {
		return this.agencia;
	}
	
	public void setAgencia (String agencia) {
		this.agencia = agencia;
	}
	
	public 	String getOperacao () {
		return this.operacao;
	}
	
	public void setOperacao (String operacao) {
		this.operacao = operacao;
	}
	
	public 	String getConta () {
		return this.conta;
	}
	
	public void setConta (String conta) {
		this.conta = conta;
	}
	

	}