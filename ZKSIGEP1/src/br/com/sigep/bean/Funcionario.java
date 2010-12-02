
package br.com.sigep.bean;

import java.util.*;


public  class Funcionario extends Pessoa {
	private String reservista;
	private String serie;
	private String categoria;
	private String estadoCivil;
	private String maeFunc;
	private String paiFunc;
	private String fax;
	private String celular;
	private String funcao;
	private String pisPasep;
	private int tituloEleitoral;
	private int zonaEleitoral;
	private int secaoEleitoral;
	private DadosBancarios dadosBancarios; 	 
	 
	private List<Formacao> formacao; 
	private List<OutrosVinculos> outrosVinculos; 

	public Funcionario () {
		setUsuario(new Usuario());
		setEndereco(new Endereco());
		setDadosBancarios(new DadosBancarios());
		setFormacao(new ArrayList<Formacao>());
		setOutrosVinculos(new ArrayList<OutrosVinculos>());
	}
	
	public 	String getReservista () {
		return this.reservista;
	}
	
	public void setReservista (String reservista) {
		this.reservista = reservista;
	}
	
	public 	String getSerie () {
		return this.serie;
	}
	
	public void setSerie (String serie) {
		this.serie = serie;
	}
	
	public 	String getCategoria () {
		return this.categoria;
	}
	
	public void setCategoria (String categoria) {
		this.categoria = categoria;
	}
	
	public 	String getEstadoCivil () {
		return this.estadoCivil;
	}
	
	public void setEstadoCivil (String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public 	String getMaeFunc () {
		return this.maeFunc;
	}
	
	public void setMaeFunc (String maeFunc) {
		this.maeFunc = maeFunc;
	}
	
	public 	String getPaiFunc () {
		return this.paiFunc;
	}
	
	public void setPaiFunc (String paiFunc) {
		this.paiFunc = paiFunc;
	}
	
	public 	String getFax () {
		return this.fax;
	}
	
	public void setFax (String fax) {
		this.fax = fax;
	}
	
	public 	String getCelular () {
		return this.celular;
	}
	
	public void setCelular (String celular) {
		this.celular = celular;
	}
	
	public 	String getFuncao () {
		return this.funcao;
	}
	
	public void setFuncao (String funcao) {
		this.funcao = funcao;
	}
	
	public 	String getPisPasep () {
		return this.pisPasep;
	}
	
	public void setPisPasep (String pisPasep) {
		this.pisPasep = pisPasep;
	}

	
	public 	int getTituloEleitoral () {
		return this.tituloEleitoral;
	}
	
	public void setTituloEleitoral (int tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}
	
	public 	int getZonaEleitoral () {
		return this.zonaEleitoral;
	}
	
	public void setZonaEleitoral (int zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}
	
	public 	int getSecaoEleitoral () {
		return this.secaoEleitoral;
	}
	
	public void setSecaoEleitoral (int secaoEleitoral) {
		this.secaoEleitoral = secaoEleitoral;
	}
	

	public DadosBancarios getDadosBancarios () {
		return this.dadosBancarios;
	}
	
	public void setDadosBancarios (DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
	
	public  List<Formacao>  getFormacao () {
		return this.formacao;
	}
	
	public void setFormacao ( List<Formacao>  formacao) {
		this.formacao = formacao;
	}
	public  List<OutrosVinculos>  getOutrosVinculos () {
		return this.outrosVinculos;
	}
	
	public void setOutrosVinculos ( List<OutrosVinculos>  outrosVinculos) {
		this.outrosVinculos = outrosVinculos;
	}
	}