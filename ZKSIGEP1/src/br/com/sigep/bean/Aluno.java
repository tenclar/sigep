
package br.com.sigep.bean;

import java.util.*;


public  class Aluno extends Pessoa {
	private String paiAluno;//
	private String maeAluno;//
	private String tipoTelefone;//
	private String ramalResponsavel;//
	private Date nascMae;//
	private Date nascPai;//
	private String profissao;//
	private String responsavel;//
	private String telefoneResponsavel;//
	private String situacao;
	private String etnia;//
	private Date dataCadastro;//
	private String foto;//
	private RecomendacoesMedicas recomendacoesMedicas;// 
	private Registro registro;//
	private List<Matricula> matricula;


	public Aluno () {
		setUsuario(new Usuario());
		setEndereco(new Endereco());
		setRecomendacoesMedicas(new RecomendacoesMedicas());
		setRegistro(new Registro());
		setDataCadastro(new Date());
		setMatricula(new ArrayList<Matricula>());
	}
	
	public 	String getPaiAluno () {
		return this.paiAluno;
	}
	
	public void setPaiAluno (String paiAluno) {
		this.paiAluno = paiAluno;
	}
	
	public 	String getMaeAluno () {
		return this.maeAluno;
	}
	
	public void setMaeAluno (String maeAluno) {
		this.maeAluno = maeAluno;
	}
	
	public 	String getTipoTelefone () {
		return this.tipoTelefone;
	}
	
	public void setTipoTelefone (String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
		
	public String getRamalResponsavel() {
		return ramalResponsavel;
	}

	public void setRamalResponsavel(String ramalResponsavel) {
		this.ramalResponsavel = ramalResponsavel;
	}

	public 	Date getNascMae () {
		return this.nascMae;
	}
	
	public void setNascMae (Date nascMae) {
		this.nascMae = nascMae;
	}
	
	public 	Date getNascPai () {
		return this.nascPai;
	}
	
	public void setNascPai (Date nascPai) {
		this.nascPai = nascPai;
	}
	
	public 	String getProfissao () {
		return this.profissao;
	}
	
	public void setProfissao (String profissao) {
		this.profissao = profissao;
	}
	
	public 	String getResponsavel () {
		return this.responsavel;
	}
	
	public void setResponsavel (String responsavel) {
		this.responsavel = responsavel;
	}
	
	public 	String getTelefoneResponsavel () {
		return this.telefoneResponsavel;
	}
	
	public void setTelefoneResponsavel (String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}
	
	public 	String getSituacao () {
		return this.situacao;
	}
	
	public void setSituacao (String situacao) {
		this.situacao = situacao;
	}
	
	public 	String getEtnia () {
		return this.etnia;
	}
	
	public void setEtnia (String etnia) {
		this.etnia = etnia;
	}
	
	public 	Date getDataCadastro () {
		return this.dataCadastro;
	}
	
	public void setDataCadastro (Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public 	String getFoto () {
		return this.foto;
	}
	
	public void setFoto (String foto) {
		this.foto = foto;
	}
	

	public RecomendacoesMedicas getRecomendacoesMedicas () {
		return this.recomendacoesMedicas;
	}
	
	public void setRecomendacoesMedicas (RecomendacoesMedicas recomendacoesMedicas) {
		this.recomendacoesMedicas = recomendacoesMedicas;
	}
	public Registro getRegistro () {
		return this.registro;
	}
	
	public void setRegistro (Registro registro) {
		this.registro = registro;
	}

	public  List<Matricula>  getMatricula () {
		return this.matricula;
	}
	
	public void setMatricula ( List<Matricula>  matricula) {
		this.matricula = matricula;
	}
	}