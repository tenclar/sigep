package br.com.sigep.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Formacao;
import br.com.sigep.bean.OutrosVinculos;
import br.com.sigep.bean.Professor;
import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.facade.Facade;

public class ProfessorController extends GenericForwardComposer{
	
	private Listbox ListagemProfessor;
	private Listbox ListagemFormacao;
	private Listbox ListagemVinculo;
	private ListModel listModel;
	private Combobox uf;
	private Combobox ufNascimento;
	private Combobox ufUnidade;
	private Combobox ufOrgao;
	private Combobox necessidade;
	private Div cadastroProfessor;
	private Div listarProfessor;
	private Div pesquisarProfessor;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox id;
	private Textbox nome;
	private Radiogroup sexo;
	private Radio masculino;
	private Radio feminino;
	private Combobox estadoCivil;
	private Textbox ProcurarProfessor;
	private Datebox nascimento;
	private Datebox rgExpedicao;
	private Textbox naturalidade;
	private Textbox nacionalidade;
	private Textbox maeFunc;
	private Textbox paiFunc;
	private Textbox reservista;
	private Textbox logradouro;
	private Textbox serie;
	private Textbox categoria;
	private Textbox referencia;
	private Textbox bairro;
	private Textbox cidade;
	private Textbox telefone;
	private Textbox ramalTelefone;
	private Textbox celular;
	private Textbox fax;
	private Textbox email;
	private Textbox banco;
	private Textbox conta;
	private Textbox agencia;
	private Textbox operacao;
	private Textbox titulo;
	private Textbox curso;
	private Textbox orgExpedidor;
	private Textbox especializacao;
	private Textbox instituicao;
	private Textbox cargo;
	private Textbox orgao;
	private Intbox cargaHoraria;
	private Textbox usuario;
	private Textbox senha;
	private Textbox pisPasep;
	private Intbox ano;
	private Intbox tituloEleitoral;
	private Intbox secao;
	private Intbox zona;
	private Textbox cep;
	private Textbox cepUnidade;
	private Intbox rg;
	private Intbox numero;
	private Datebox dataAdmi1;
	private Textbox matricula1;
	private Datebox dataAdmi2;
	private Textbox matricula2;
	private Textbox unidade;
	private Textbox logradouroUnidade;
	private Textbox referenciaUnidade;
	private Textbox bairroUnidade;
	private Textbox cidadeUnidade;	
	private Intbox numeroUnidade;
	private Textbox cpf;
	private Row rowId;
	private Groupbox OutrosVinculos;
	private Groupbox Formacao;
	private DataBinder binder;
	
	private Combobox tipoDeUsuario;
	
	private Tab tabIdentificacao;
	private Tab tabFormacao;
	private Tab tabVinculo;
	

	private Constraint c = null;
	
	//Constraint para verificar se o campo está vazia, se contém apenas números e se o CPF é válido 
	//(solução encontrada já que n é possível setar uma constraint (ctt) e uma String (no empty) no mesmo setConstraint
	Constraint ctt = new Constraint() {
	    public void validate(Component comp, Object value) throws WrongValueException {
	    	if(value == ""){
	    		 throw new WrongValueException(comp, "Preencha o Campo!");
	    	}else if (Facade.getInstance().verificarSeENumero((String) value) == false){
	    		throw new WrongValueException(comp, "Digite Somente Números!");
	    	} else {
	    		if(Facade.getInstance().validacaoCPF((String) value) == false){
	    			 throw new WrongValueException(comp, "CPF Inválido!");
	    		}
	    	}
	        
	    } 
	};
	
	
	private static final long serialVersionUID = 1L;
	
	Professor pp = new Professor();
	OutrosVinculos vinculos = new OutrosVinculos();
	Formacao formacao = new Formacao();
		
	public Formacao getFormacao() {
		return formacao;
	}

	public OutrosVinculos getVinculos() {
		return vinculos;
	}

	public void setVinculos(OutrosVinculos vinculos) {
		this.vinculos = vinculos;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	
	public Professor getPro() {
		return pp;
	}

	public void setPro(Professor pro) {
		this.pp = pro;
	}
		
	public void onClick$adicionar(Event e) throws InterruptedException {

		if (uf.getSelectedIndex() == -1 || ufOrgao.getSelectedIndex() == -1
				|| ufNascimento.getSelectedIndex() == -1
				|| estadoCivil.getSelectedIndex() == -1
				|| necessidade.getSelectedIndex() == -1
				|| sexo.getSelectedIndex() == -1
				|| tipoDeUsuario.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		}else if(Facade.getInstance().verificarSeRGProfessorJaExiste(String.valueOf(rg.getValue())) == true){
			alert("Já Existe Professor Cadastrado com o RG: "+ rg.getValue());
		} else if(Facade.getInstance().verificarSeCpfProfessorJaExiste(cpf.getValue()) == true){
			alert("Já Existe Professor Cadastrado com o CPF: "+ cpf.getValue());
		} else {

			pp.setNome(nome.getValue());
			pp.setPisPasep(pisPasep.getValue());
			pp.setFuncao("Professor");
			pp.setNascimento(nascimento.getValue());
			pp.setNaturalidade(naturalidade.getValue());
			pp.setNacionalidade(nacionalidade.getValue());
			pp.setMaeFunc(maeFunc.getValue());
			pp.setPaiFunc(paiFunc.getValue());
			pp.setRg(String.valueOf(rg.getValue()));
			pp.setOrgExpedidor(orgExpedidor.getValue());
			pp.setRgExpedicao(rgExpedicao.getValue());
			pp.setCpf(cpf.getValue());
			pp.setReservista(reservista.getValue());
			pp.setSerie(serie.getValue());
			pp.setCategoria(categoria.getValue());
			pp.getEndereco().setLogradouro(logradouro.getValue());
			pp.getEndereco().setNumero(numero.getValue());
			pp.getEndereco().setReferencia(referencia.getValue());
			pp.getEndereco().setBairro(bairro.getValue());
			pp.getEndereco().setCidade(cidade.getValue());
			pp.getEndereco().setUf(uf.getValue());
			pp.getEndereco().setCep(cep.getValue());
			pp.setTelefone(telefone.getValue());
			pp.setRamalTelefone(ramalTelefone.getValue());
			pp.setCelular(celular.getValue());
			pp.setFax(fax.getValue());
			pp.setEmail(email.getValue());
			pp.setTituloEleitoral(tituloEleitoral.getValue());
			pp.setZonaEleitoral(zona.getValue());
			pp.setSecaoEleitoral(secao.getValue());
			pp.getDadosBancarios().setBanco(banco.getValue());
			pp.getDadosBancarios().setConta(conta.getValue());
			pp.getDadosBancarios().setAgencia(agencia.getValue());
			pp.getDadosBancarios().setOperacao(operacao.getValue());
			pp.getUsuario().setSenha(senha.getValue());
			pp.getUsuario().setUsuario(usuario.getValue());
			pp.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
			pp.setSexo(sexo.getSelectedItem().getValue());
			pp.setEstadoCivil(estadoCivil.getValue());
			pp.setUfNascimento(ufNascimento.getValue());
			pp.setNecessidade(necessidade.getValue());
			pp.setUfOrgao(ufOrgao.getValue());
			pp.getDadosFuncionais().setDataAdmi1(dataAdmi1.getValue());
			pp.getDadosFuncionais().setDataAdmi2(dataAdmi2.getValue());
			pp.getDadosFuncionais().setMatricula1(matricula1.getValue());
			pp.getDadosFuncionais().setMatricula2(matricula2.getValue());
			pp.getDadosFuncionais().setUnidade(unidade.getValue());
			pp.getDadosFuncionais().setDisciplinas("");
			pp.getDadosFuncionais().getEndereco().setLogradouro(logradouroUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setNumero(numeroUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setReferencia(referenciaUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setBairro(bairroUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setCep(cepUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setCidade(cidadeUnidade.getValue());
			pp.getDadosFuncionais().getEndereco().setUf(ufUnidade.getValue());

			Facade.getInstance().salvarProfessor(pp);

			Messagebox.show("Professor Cadastrado com Sucesso!", "Sucesso!",
					Messagebox.OK, Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					});

			pp = new Professor();
			cadastroProfessor.setVisible(false);

		}
	}
	
	public void onClick$resultadoProfessor() throws InterruptedException{
		if (ProcurarProfessor.getText() == "") {
			Messagebox.show("Digite um Nome!",
			        "Nome Não Digitado!",
			        Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg0) throws Exception {
								
						}
					}
				);
		} else {
			listModel = new ListModelList(Facade.getInstance().listarProfessorFiltro(ProcurarProfessor.getText()));
			ListagemProfessor.setModel(listModel);
		}
		
	}
	

	public void onClick$adicionarVinculoProfessor(Event e){  
    	vinculos.setStatus(true);
    	vinculos.setCargaHoraria(cargaHoraria.getValue());
    	vinculos.setCargo(cargo.getValue());
    	vinculos.setOrgao(orgao.getValue());
    	pp.getOutrosVinculos().add(vinculos);
    	listModel = new ListModelList(pp.getOutrosVinculos());
		ListagemVinculo.setModel(listModel);
    	vinculos = new OutrosVinculos(); 
    	cargo.setValue("");
    	orgao.setValue("");
    	cargaHoraria.setValue(0);
    	binder.loadComponent(OutrosVinculos);    	
    }  
    
    public void onClick$adicionarFormacaoProfessor(Event e){  
    	formacao.setAnoConclusao(ano.getValue());
    	formacao.setCurso(curso.getValue());
    	formacao.setInstituicao(instituicao.getValue());
    	formacao.setTitulo(titulo.getValue());
    	formacao.setEspecializacao(especializacao.getValue());
    	pp.getFormacao().add(formacao);
    	listModel = new ListModelList(pp.getFormacao());
		ListagemFormacao.setModel(listModel);
    	formacao = new Formacao(); 
    	ano.setValue(0);
    	curso.setValue("");
    	instituicao.setValue("");
    	titulo.setValue("");
    	especializacao.setValue("");
    	binder.loadComponent(Formacao);    	
    }
    
    public void onClick$EditarProfessor(Event e) throws InterruptedException {
		if(listarProfessor.isVisible() && ListagemProfessor.getSelectedIndex()!=-1){
			pesquisarProfessor.setVisible(false);
			listarProfessor.setVisible(false);
			adicionar.setVisible(false);
			tabIdentificacao.setSelected(true);
			tabFormacao.setVisible(false);
			tabVinculo.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroProfessor.setVisible(true);
			rowId.setVisible(true);
			pp =(Professor) ListagemProfessor.getModel().getElementAt(ListagemProfessor.getSelectedIndex());	
			id.setText(String.valueOf(pp.getId()));
			nome.setValue(pp.getNome());
			nascimento.setValue(pp.getNascimento());
			naturalidade.setValue(pp.getNaturalidade());
			nacionalidade.setValue(pp.getNacionalidade());
			maeFunc.setValue(pp.getMaeFunc());
			paiFunc.setValue(pp.getPaiFunc());
			pisPasep.setValue(pp.getPisPasep());
			rg.setValue(Integer.parseInt(pp.getRg()));
			orgExpedidor.setValue(pp.getOrgExpedidor());
			rgExpedicao.setValue(pp.getRgExpedicao());
			cpf.setValue(pp.getCpf());
			reservista.setValue(pp.getReservista());
			serie.setValue(pp.getSerie());
			categoria.setValue(pp.getCategoria());
			logradouro.setValue(pp.getEndereco().getLogradouro());
			numero.setValue(pp.getEndereco().getNumero());
			referencia.setValue(pp.getEndereco().getReferencia());
			bairro.setValue(pp.getEndereco().getBairro());
			cidade.setValue(pp.getEndereco().getCidade());
			cep.setValue(pp.getEndereco().getCep());
			telefone.setValue(pp.getTelefone());
			ramalTelefone.setValue(pp.getRamalTelefone());
			celular.setValue(pp.getCelular());
			tituloEleitoral.setValue(pp.getTituloEleitoral());
			secao.setValue(pp.getSecaoEleitoral());
			zona.setValue(pp.getZonaEleitoral());
			fax.setValue(pp.getFax());
			email.setValue(pp.getEmail());
			banco.setValue(pp.getDadosBancarios().getBanco());
			conta.setValue(pp.getDadosBancarios().getConta());
			agencia.setValue(pp.getDadosBancarios().getAgencia());
			operacao.setValue(pp.getDadosBancarios().getOperacao());
			senha.setValue(pp.getUsuario().getSenha());
			usuario.setValue(pp.getUsuario().getUsuario());
			necessidade.setValue(pp.getNecessidade());
			estadoCivil.setValue(pp.getEstadoCivil());
			
			dataAdmi1.setValue(pp.getDadosFuncionais().getDataAdmi1());
			dataAdmi2.setValue(pp.getDadosFuncionais().getDataAdmi2());
			matricula1.setValue(pp.getDadosFuncionais().getMatricula1());
			matricula2.setValue(pp.getDadosFuncionais().getMatricula2());
			unidade.setValue(pp.getDadosFuncionais().getUnidade());
			logradouroUnidade.setValue(pp.getDadosFuncionais().getEndereco().getLogradouro());
			numeroUnidade.setValue(pp.getDadosFuncionais().getEndereco().getNumero());
			referenciaUnidade.setValue(pp.getDadosFuncionais().getEndereco().getReferencia());		
			bairroUnidade.setValue(pp.getDadosFuncionais().getEndereco().getBairro());		
			cepUnidade.setText(pp.getDadosFuncionais().getEndereco().getCep());
			cidadeUnidade.setValue(pp.getDadosFuncionais().getEndereco().getCidade());
			
			if (pp.getSexo().equals("Masculino")){
				masculino.setSelected(true);
				feminino.setSelected(false);
			}
			else{
				feminino.setSelected(true);
				masculino.setSelected(false);				
			}
				
			listModel = new ListModelList(pp.getFormacao());
			ListagemFormacao.setModel(listModel);
			
			listModel = new ListModelList(pp.getOutrosVinculos());
			ListagemVinculo.setModel(listModel);
			
			String[] estadosv = new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE",
					"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
					"PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" };
			for (int i = 0; i < estadosv.length; i++) {
				Comboitem comboitemUfNascimento = new Comboitem(estadosv[i]);
				comboitemUfNascimento.setValue(estadosv[i]);
				ufNascimento.appendChild(comboitemUfNascimento);
				
				Comboitem comboitemUf = new Comboitem(estadosv[i]);
				comboitemUf.setValue(estadosv[i]);
				uf.appendChild(comboitemUf);
				
				Comboitem comboitemOrgao = new Comboitem(estadosv[i]);
				comboitemOrgao.setValue(estadosv[i]);
				ufOrgao.appendChild(comboitemOrgao);
				
				Comboitem comboitemUfUnidade = new Comboitem(estadosv[i]);
				comboitemUfUnidade.setValue(estadosv[i]);
				ufUnidade.appendChild(comboitemUfUnidade);
			}
			
			uf.setText(pp.getEndereco().getUf());
			ufNascimento.setValue(pp.getUfNascimento());
			ufOrgao.setValue(pp.getUfOrgao());
			ufUnidade.setValue(pp.getDadosFuncionais().getEndereco().getUf());
			
			tipoDeUsuario.getChildren().clear();
		 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
				Comboitem comboitem = new Comboitem(tp.getDescricao());
				comboitem.setValue(tp);
				tipoDeUsuario.appendChild(comboitem);
		 	}
			
			tipoDeUsuario.setValue(pp.getUsuario().getTipoDeUsuario().getDescricao());
			
			nome.setConstraint("no empty");
			nascimento.setConstraint("no empty");
			naturalidade.setConstraint("no empty");
			nacionalidade.setConstraint("no empty");
			//NOME DO PAI - SEM CONSTRAINT
			//NOME DA MÃE - SEM CONSTRAINT
			rg.setConstraint("no empty, no negative");
			orgExpedidor.setConstraint("no empty");
			rgExpedicao.setConstraint("no empty");
			cpf.setConstraint(ctt);
			tituloEleitoral.setConstraint("no empty, no negative");
			zona.setConstraint("no empty, no negative");
			secao.setConstraint("no empty, no negative");
			reservista.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
			serie.setConstraint("no empty");
			categoria.setConstraint("no empty");
			logradouro.setConstraint("no empty");
			numero.setConstraint("no empty, no negative");
			bairro.setConstraint("no empty");
			cidade.setConstraint("no empty");
			uf.setConstraint("no empty");
			cep.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
			telefone.setConstraint("no empty"); //a máscara do js irá garantir que letras não serão aceitas
			banco.setConstraint("no empty");
			conta.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
			agencia.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
			operacao.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
			usuario.setConstraint("no empty");
			senha.setConstraint("no empty");
			
		}
		else{
			Messagebox.show("Selecione um Item!",
		        "Item Não Selecionado!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg0) throws Exception {						
					}
				}
			);
			
		}
	}
    
    public void onClick$ListarProfessor(){
		pesquisarProfessor.setVisible(false);
		cadastroProfessor.setVisible(false);
		listarProfessor.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarProfessor());
		ListagemProfessor.setModel(listModel);
	}
	
	public void onClick$PesquisarProfessor(){
		ProcurarProfessor.setText("");
		cadastroProfessor.setVisible(false);
		pesquisarProfessor.setVisible(true);
	}
	
	public void onClick$CadastrarProfessor(){
		pesquisarProfessor.setVisible(false);
		listarProfessor.setVisible(false);
		cadastroProfessor.setVisible(true);
		tabIdentificacao.setSelected(true);
		tabFormacao.setVisible(true);
		tabVinculo.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		nome.setConstraint(c);
		estadoCivil.setConstraint(c);
		nascimento.setConstraint(c);
		naturalidade.setConstraint(c);
		ufNascimento.setConstraint(c);
		nacionalidade.setConstraint(c);
		necessidade.setConstraint(c);
		//NOME DO PAI - SEM CONSTRAINT
		//NOME DA MÃE - SEM CONSTRAINT
		rg.setConstraint(c);
		orgExpedidor.setConstraint(c);
		ufOrgao.setConstraint(c);
		rgExpedicao.setConstraint(c);
		cpf.setConstraint(c);
		tituloEleitoral.setConstraint(c);
		zona.setConstraint(c);
		secao.setConstraint(c);
		reservista.setConstraint(c);
		serie.setConstraint(c);
		categoria.setConstraint(c);
		logradouro.setConstraint(c);
		numero.setConstraint(c);
		bairro.setConstraint(c);
		cidade.setConstraint(c);
		uf.setConstraint(c);
		cep.setConstraint(c);
		telefone.setConstraint(c); //a máscara do js irá garantir que letras não serão aceitas
		banco.setConstraint(c);
		conta.setConstraint(c);
		agencia.setConstraint(c);
		operacao.setConstraint(c);
		usuario.setConstraint(c);
		senha.setConstraint(c);
		
		uf.setText("");
		ufNascimento.setText("");
		ufOrgao.setText("");
		nome.setText("");
		nascimento.setText("");
		naturalidade.setText("");
		nacionalidade.setText("");
		maeFunc.setText("");
		paiFunc.setText("");
		rg.setText("");
		orgExpedidor.setText("");
		rgExpedicao.setText("");
		cpf.setText("");
		reservista.setText("");
		serie.setText("");
		categoria.setText("");
		tituloEleitoral.setText("");
		secao.setText("");
		zona.setText("");
		logradouro.setText("");
		numero.setText("");
		referencia.setText("");
		bairro.setText("");
		cidade.setText("");
		cep.setText("");
		pisPasep.setText("");
		telefone.setText("");
		ramalTelefone.setText("");
		celular.setText("");
		fax.setText("");
		email.setText("");
		banco.setText("");
		conta.setText("");
		agencia.setText("");
		operacao.setText("");
		senha.setText("");
		usuario.setText("");
		estadoCivil.setText("");
		necessidade.setText("");
		
		dataAdmi1.setText("");
		dataAdmi2.setText("");
		matricula1.setText("");
		matricula2.setText("");
		unidade.setText("");
		logradouroUnidade.setText("");
		numeroUnidade.setText("");
		referenciaUnidade.setText("");		
		bairroUnidade.setValue("");		
		cepUnidade.setText("");
		cidadeUnidade.setValue("");
		ufUnidade.setValue("");
		
		nome.setConstraint("no empty");
		estadoCivil.setConstraint("no empty");
		nascimento.setConstraint("no empty");
		naturalidade.setConstraint("no empty");
		ufNascimento.setConstraint("no empty");
		nacionalidade.setConstraint("no empty");
		necessidade.setConstraint("no empty");
		//NOME DO PAI - SEM CONSTRAINT
		//NOME DA MÃE - SEM CONSTRAINT
		rg.setConstraint("no empty, no negative");
		orgExpedidor.setConstraint("no empty");
		ufOrgao.setConstraint("no empty");
		rgExpedicao.setConstraint("no empty");
		cpf.setConstraint(ctt);
		tituloEleitoral.setConstraint("no empty, no negative");
		zona.setConstraint("no empty, no negative");
		secao.setConstraint("no empty, no negative");
		reservista.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		serie.setConstraint("no empty");
		categoria.setConstraint("no empty");
		logradouro.setConstraint("no empty");
		numero.setConstraint("no empty, no negative");
		bairro.setConstraint("no empty");
		cidade.setConstraint("no empty");
		uf.setConstraint("no empty");
		cep.setConstraint("no empty");
		telefone.setConstraint("no empty"); //a máscara do js irá garantir que letras não serão aceitas
		banco.setConstraint("no empty");
		conta.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		agencia.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		operacao.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		usuario.setConstraint("no empty");
		senha.setConstraint("no empty");
		
		String[] estadosv = new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE",
				"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
				"PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" };
		for (int i = 0; i < estadosv.length; i++) {
			Comboitem comboitemUfNascimento = new Comboitem(estadosv[i]);
			comboitemUfNascimento.setValue(estadosv[i]);
			ufNascimento.appendChild(comboitemUfNascimento);
			
			Comboitem comboitemUf = new Comboitem(estadosv[i]);
			comboitemUf.setValue(estadosv[i]);
			uf.appendChild(comboitemUf);
			
			Comboitem comboitemOrgao = new Comboitem(estadosv[i]);
			comboitemOrgao.setValue(estadosv[i]);
			ufOrgao.appendChild(comboitemOrgao);
			
			Comboitem comboitemUfUnidade = new Comboitem(estadosv[i]);
			comboitemUfUnidade.setValue(estadosv[i]);
			ufUnidade.appendChild(comboitemUfUnidade);
		}
		
		tipoDeUsuario.getChildren().clear();
	 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
			Comboitem comboitem = new Comboitem(tp.getDescricao());
			comboitem.setValue(tp);
			tipoDeUsuario.appendChild(comboitem);
	 	}
		
		feminino.setSelected(false);
		masculino.setSelected(false);
		
		listModel = null;
		ListagemVinculo.setModel(listModel);		
		ListagemFormacao.setModel(listModel);
		
	}
	
	public void onClick$cancelar(Event e) {	
		pesquisarProfessor.setVisible(false);
		listarProfessor.setVisible(false);
		cadastroProfessor.setVisible(false);
    }
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Professor pp = Facade.getInstance().carregarProfessor(((Professor) ListagemProfessor.getModel().getElementAt(ListagemProfessor.getSelectedIndex())).getId());
		
		pp.setNome(nome.getValue());
		pp.setNascimento(nascimento.getValue());
		pp.setNaturalidade(naturalidade.getValue());
		pp.setNacionalidade(nacionalidade.getValue());
		pp.setMaeFunc(maeFunc.getValue());
		pp.setPaiFunc(paiFunc.getValue());
		pp.setRg(String.valueOf(rg.getValue()));
		pp.setOrgExpedidor(orgExpedidor.getValue());
		pp.setRgExpedicao(rgExpedicao.getValue());
		pp.setCpf(cpf.getValue());
		pp.setReservista(reservista.getValue());
		pp.setSerie(serie.getValue());
		pp.setCategoria(categoria.getValue());
		pp.getEndereco().setLogradouro(logradouro.getValue());
		pp.getEndereco().setNumero(numero.getValue());
		pp.getEndereco().setReferencia(referencia.getValue());
		pp.getEndereco().setBairro(bairro.getValue());
		pp.getEndereco().setCidade(cidade.getValue());
		pp.getEndereco().setCep(cep.getValue());
		pp.setTelefone(telefone.getValue());
		pp.setRamalTelefone(ramalTelefone.getValue());
		pp.setCelular(celular.getValue());
		pp.setFax(fax.getValue());
		pp.setEmail(email.getValue());
		pp.getDadosBancarios().setBanco(banco.getValue());
		pp.getDadosBancarios().setConta(conta.getValue());
		pp.getDadosBancarios().setAgencia(agencia.getValue());
		pp.getDadosBancarios().setOperacao(operacao.getValue());
		pp.getUsuario().setSenha(senha.getValue());
		pp.getUsuario().setUsuario(usuario.getValue());
		pp.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
		pp.getEndereco().setUf(uf.getValue());
		pp.setSexo(sexo.getSelectedItem().getValue());
		pp.setEstadoCivil(estadoCivil.getValue());
		pp.setUfNascimento(ufNascimento.getValue());
		pp.setNecessidade(necessidade.getValue());
		pp.setUfOrgao(ufOrgao.getValue());
		pp.setTituloEleitoral(tituloEleitoral.getValue());
		pp.setSecaoEleitoral(secao.getValue());
		pp.setZonaEleitoral(zona.getValue());
		
		pp.getDadosFuncionais().setDataAdmi1(dataAdmi1.getValue());
		pp.getDadosFuncionais().setDataAdmi2(dataAdmi2.getValue());
		pp.getDadosFuncionais().setMatricula1(matricula1.getValue());
		pp.getDadosFuncionais().setMatricula2(matricula2.getValue());
		pp.getDadosFuncionais().setUnidade(unidade.getValue());
		pp.getDadosFuncionais().setDisciplinas("");
		pp.getDadosFuncionais().getEndereco().setLogradouro(logradouroUnidade.getValue());
		pp.getDadosFuncionais().getEndereco().setNumero(numeroUnidade.getValue());
		pp.getDadosFuncionais().getEndereco().setReferencia(referenciaUnidade.getValue());		
		pp.getDadosFuncionais().getEndereco().setBairro(bairroUnidade.getValue());		
		pp.getDadosFuncionais().getEndereco().setCep(cepUnidade.getValue());
		pp.getDadosFuncionais().getEndereco().setCidade(cidadeUnidade.getValue());
		pp.getDadosFuncionais().getEndereco().setUf(ufUnidade.getValue());
		
		System.out.println("VEIO ATÉ AQUI!!!!!!!!!!!!!!!!!!");
		Facade.getInstance().atualizarProfessor(pp);
		System.out.println("VEIO ATÉ AQUI TAMBÉM!!!!!!!!!!!!!!!!!!");
		
	 	pp = new Professor();
	 	pesquisarProfessor.setVisible(false);
		listarProfessor.setVisible(false);
		cadastroProfessor.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarProfessor());
		ListagemProfessor.setModel(listModel);
		Messagebox.show("Professor Alterado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
	}
	
	public void onClick$DeletarProfessor(Event event) throws InterruptedException {  
		if(listarProfessor.isVisible() && ListagemProfessor.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar o Professor selecionado?",
			        "Você tem Certeza?",
			        Messagebox.YES+Messagebox.NO,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event event) {
							if ("onYes".equals(event.getName())) {
								doYes();
							}
						}
					}
				);
		} catch (InterruptedException ex) {
		} 
		}
		else{
			Messagebox.show("Selecione um Item!",
			        "Item Não Selecionado!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg0) throws Exception {			
					}
				}
			);
			
		}
    } 
	
	public void doYes() {
		Facade.getInstance().removerProfessor((Professor) ListagemProfessor.getModel().getElementAt(ListagemProfessor.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarProfessor());
		ListagemProfessor.setModel(listModel);
	}
    

}
