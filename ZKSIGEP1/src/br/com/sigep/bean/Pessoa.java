
package br.com.sigep.bean;

import java.util.*;


public  class Pessoa  {
	private long id;//
	private String nome;//
	private Date nascimento;//
	private String rg;//
	private String telefone;//
	private String ramalTelefone;//
	private String email;//
	private String orgExpedidor;//
	private String sexo;//
	private String ufOrgao;//
	private Date rgExpedicao;//
	private String nacionalidade;//
	private String naturalidade;//
	private String necessidade;//
	private String ufNascimento;//
	private String cpf;
	private Usuario usuario;//
	private Endereco endereco;

	public Pessoa () {
		super();
	}
	
	public 	long getId () {
		return this.id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public 	String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public 	String getRg () {
		return this.rg;
	}
	
	public void setRg (String rg) {
		this.rg = rg;
	}
	
	public 	String getTelefone () {
		return this.telefone;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
	}
	
	public String getRamalTelefone() {
		return ramalTelefone;
	}

	public void setRamalTelefone(String ramalTelefone) {
		this.ramalTelefone = ramalTelefone;
	}

	public 	String getEmail () {
		return this.email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public 	String getOrgExpedidor () {
		return this.orgExpedidor;
	}
	
	public void setOrgExpedidor (String orgExpedidor) {
		this.orgExpedidor = orgExpedidor;
	}
	
	public 	String getSexo () {
		return this.sexo;
	}
	
	public void setSexo (String sexo) {
		this.sexo = sexo;
	}
	
	public 	String getUfOrgao () {
		return this.ufOrgao;
	}
	
	public void setUfOrgao (String ufOrgao) {
		this.ufOrgao = ufOrgao;
	}
	
	public Date getRgExpedicao() {
		return rgExpedicao;
	}

	public void setRgExpedicao(Date rgExpedicao) {
		this.rgExpedicao = rgExpedicao;
	}

	public 	String getNacionalidade () {
		return this.nacionalidade;
	}
	
	public void setNacionalidade (String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public 	String getNaturalidade () {
		return this.naturalidade;
	}
	
	public void setNaturalidade (String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public 	String getNecessidade () {
		return this.necessidade;
	}
	
	public void setNecessidade (String necessidade) {
		this.necessidade = necessidade;
	}
	
	public 	String getUfNascimento () {
		return this.ufNascimento;
	}
	
	public void setUfNascimento (String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Usuario getUsuario () {
		return this.usuario;
	}
	
	public void setUsuario (Usuario usuario) {
		this.usuario = usuario;
	}
	public Endereco getEndereco () {
		return this.endereco;
	}
	
	public void setEndereco (Endereco endereco) {
		this.endereco = endereco;
	}
	}