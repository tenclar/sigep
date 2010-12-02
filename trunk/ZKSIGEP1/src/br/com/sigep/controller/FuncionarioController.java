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
import br.com.sigep.bean.Funcionario;
import br.com.sigep.bean.OutrosVinculos;
import br.com.sigep.bean.TipoDeUsuario;

import br.com.sigep.facade.Facade;

public class FuncionarioController extends GenericForwardComposer{

	private Groupbox OutrosVinculos;
	private Groupbox Formacao;
	private DataBinder binder;
	private Listbox ListagemFuncionario;
	private Listbox ListagemFormacao;
	private Listbox ListagemVinculo;
	private ListModel listModel;
	private Combobox uf;
	private Combobox ufNascimento;
	private Combobox ufOrgao;
	private Combobox necessidade;
	private Div cadastroFuncionario;
	private Div listarFuncionario;
	private Div pesquisarFuncionario;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox id;
	private Textbox nome;
	private Textbox funcao;
	private Radiogroup sexo;
	private Radio masculino;
	private Radio feminino;
	private Combobox estadoCivil;
	private Textbox ProcurarFuncionario;
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
	private Intbox rg;
	private Intbox numero;
	private Textbox cpf;
	
	private Combobox tipoDeUsuario;
	
	private Row rowId;
	
	private Tab tabFormacao;
	private Tab tabVinculo;
	private Tab tabIdentificacao;
	
	
	private Constraint c = null;
	
	
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
	Funcionario f = new Funcionario();
	OutrosVinculos vinculos = new OutrosVinculos();
	Formacao formacao = new Formacao();
			
	public Funcionario getF() {
		return f;
	}

	public void setF(Funcionario f) {
		this.f = f;
	}
	
	public OutrosVinculos getVinculos() {
		return vinculos;
	}

	public void setVinculos(OutrosVinculos vinculos) {
		this.vinculos = vinculos;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	

	public void onClick$CadastrarFuncionario(){
		pesquisarFuncionario.setVisible(false);
		listarFuncionario.setVisible(false);
		cadastroFuncionario.setVisible(true);
		tabIdentificacao.setSelected(true);
		tabFormacao.setVisible(true);
		tabVinculo.setVisible(true);
		
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		nome.setConstraint(c);
		funcao.setConstraint(c);
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
		funcao.setText("");
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
		
		nome.setConstraint("no empty");
		funcao.setConstraint("no empty");
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
		cep.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		telefone.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!"); //a máscara do js irá garantir que letras não serão aceitas
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

	public void onClick$adicionar(Event e) throws InterruptedException {
		
		if (uf.getSelectedIndex() == -1 || ufOrgao.getSelectedIndex() == -1
				|| ufNascimento.getSelectedIndex() == -1
				|| estadoCivil.getSelectedIndex() == -1
				|| necessidade.getSelectedIndex() == -1
				|| sexo.getSelectedIndex() == -1
				|| tipoDeUsuario.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		}else if(Facade.getInstance().verificarSeRGFuncionarioJaExiste(String.valueOf(rg.getValue())) == true){
			alert("Já Existe Funcionário Cadastrado com o RG: "+ rg.getValue());
		} else if(Facade.getInstance().verificarSeCpfFuncionarioJaExiste(cpf.getValue()) == true){
			alert("Já Existe Funcionário Cadastrado com o CPF: "+ cpf.getValue());
		}else {

			f.setNome(nome.getValue());
			f.setPisPasep(pisPasep.getValue());
			f.setFuncao(funcao.getValue());
			f.setNascimento(nascimento.getValue());
			f.setNaturalidade(naturalidade.getValue());
			f.setNacionalidade(nacionalidade.getValue());
			f.setMaeFunc(maeFunc.getValue());
			f.setPaiFunc(paiFunc.getValue());
			f.setRg(String.valueOf(rg.getValue()));
			f.setOrgExpedidor(orgExpedidor.getValue());
			f.setRgExpedicao(rgExpedicao.getValue());
			f.setCpf(cpf.getValue());
			f.setReservista(reservista.getValue());
			f.setSerie(serie.getValue());
			f.setCategoria(categoria.getValue());
			f.getEndereco().setLogradouro(logradouro.getValue());
			f.getEndereco().setNumero(numero.getValue());
			f.getEndereco().setReferencia(referencia.getValue());
			f.getEndereco().setBairro(bairro.getValue());
			f.getEndereco().setCidade(cidade.getValue());
			f.getEndereco().setUf(uf.getValue());
			f.getEndereco().setCep(cep.getValue());
			f.setTelefone(telefone.getValue());
			f.setRamalTelefone(ramalTelefone.getValue());
			f.setCelular(celular.getValue());
			f.setFax(fax.getValue());
			f.setEmail(email.getValue());
			f.setTituloEleitoral(tituloEleitoral.getValue());
			f.setZonaEleitoral(zona.getValue());
			f.setSecaoEleitoral(secao.getValue());
			f.getDadosBancarios().setBanco(banco.getValue());
			f.getDadosBancarios().setConta(conta.getValue());
			f.getDadosBancarios().setAgencia(agencia.getValue());
			f.getDadosBancarios().setOperacao(operacao.getValue());
			f.getUsuario().setSenha(senha.getValue());
			f.getUsuario().setUsuario(usuario.getValue());
			f.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
			f.setSexo(sexo.getSelectedItem().getValue());
			f.setEstadoCivil(estadoCivil.getValue());
			f.setUfNascimento(ufNascimento.getValue());
			f.setNecessidade(necessidade.getValue());
			f.setUfOrgao(ufOrgao.getValue());

			Facade.getInstance().salvarFuncionario(f);

			Messagebox.show("Funcionário Cadastrado com Sucesso!", "Sucesso!",
					Messagebox.OK, Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					});

			f = new Funcionario();
			cadastroFuncionario.setVisible(false);
		}
	}
	
	public void onClick$resultadoFuncionario() throws InterruptedException{
		if (ProcurarFuncionario.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarFuncionarioFiltro(ProcurarFuncionario.getText()));
			ListagemFuncionario.setModel(listModel);
		}
		
	}
	
    public void onClick$adicionarVinculo(Event e){  
    	vinculos.setStatus(true);
    	vinculos.setCargaHoraria(cargaHoraria.getValue());
    	vinculos.setCargo(cargo.getValue());
    	vinculos.setOrgao(orgao.getValue());
    	f.getOutrosVinculos().add(vinculos);
    	listModel = new ListModelList(f.getOutrosVinculos());
    	ListagemVinculo.setModel(listModel);
    	vinculos = new OutrosVinculos();    	
    	cargo.setValue("");
    	orgao.setValue("");
    	cargaHoraria.setText("");
    	binder.loadComponent(OutrosVinculos);
    }  
    
    public void onClick$adicionarFormacao(Event e){  
    	formacao.setAnoConclusao(ano.getValue());
    	formacao.setCurso(curso.getValue());
    	formacao.setInstituicao(instituicao.getValue());
    	formacao.setTitulo(titulo.getValue());
    	f.getFormacao().add(formacao);
    	listModel = new ListModelList(f.getFormacao());
		ListagemFormacao.setModel(listModel);
    	formacao = new Formacao();
    	ano.setText("");
    	curso.setValue("");
    	instituicao.setValue("");
    	titulo.setValue("");
    	binder.loadComponent(Formacao);
    } 
    
    public void onClick$EditarFuncionario(Event e) throws InterruptedException {
		if(listarFuncionario.isVisible() && ListagemFuncionario.getSelectedIndex()!=-1){
			pesquisarFuncionario.setVisible(false);
			listarFuncionario.setVisible(false);
			adicionar.setVisible(false);
			tabIdentificacao.setSelected(true);
			tabFormacao.setVisible(false);
			tabVinculo.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroFuncionario.setVisible(true);
			rowId.setVisible(true);
			f =(Funcionario) ListagemFuncionario.getModel().getElementAt(ListagemFuncionario.getSelectedIndex());	
			id.setText(String.valueOf(f.getId()));
			nome.setValue(f.getNome());
			funcao.setValue(f.getFuncao());
			nascimento.setValue(f.getNascimento());
			naturalidade.setValue(f.getNaturalidade());
			nacionalidade.setValue(f.getNacionalidade());
			maeFunc.setValue(f.getMaeFunc());
			paiFunc.setValue(f.getPaiFunc());
			pisPasep.setValue(f.getPisPasep());
			rg.setValue(Integer.parseInt(f.getRg()));
			orgExpedidor.setValue(f.getOrgExpedidor());
			rgExpedicao.setValue(f.getRgExpedicao());
			cpf.setValue(f.getCpf());
			reservista.setValue(f.getReservista());
			serie.setValue(f.getSerie());
			categoria.setValue(f.getCategoria());
			logradouro.setValue(f.getEndereco().getLogradouro());
			numero.setValue(f.getEndereco().getNumero());
			referencia.setValue(f.getEndereco().getReferencia());
			bairro.setValue(f.getEndereco().getBairro());
			cidade.setValue(f.getEndereco().getCidade());
			cep.setValue(f.getEndereco().getCep());
			telefone.setValue(f.getTelefone());
			ramalTelefone.setValue(f.getRamalTelefone());
			celular.setValue(f.getCelular());
			tituloEleitoral.setValue(f.getTituloEleitoral());
			secao.setValue(f.getSecaoEleitoral());
			zona.setValue(f.getZonaEleitoral());
			fax.setValue(f.getFax());
			email.setValue(f.getEmail());
			banco.setValue(f.getDadosBancarios().getBanco());
			conta.setValue(f.getDadosBancarios().getConta());
			agencia.setValue(f.getDadosBancarios().getAgencia());
			operacao.setValue(f.getDadosBancarios().getOperacao());
			senha.setValue(f.getUsuario().getSenha());
			usuario.setValue(f.getUsuario().getUsuario());
			necessidade.setValue(f.getNecessidade());
			estadoCivil.setValue(f.getEstadoCivil());
			
			if (f.getSexo().equals("Masculino")){
				masculino.setSelected(true);
				feminino.setSelected(false);
			}
			else{
				feminino.setSelected(true);
				masculino.setSelected(false);				
			}
			
			listModel = new ListModelList(f.getFormacao());
			ListagemFormacao.setModel(listModel);
			
			listModel = new ListModelList(f.getOutrosVinculos());
			ListagemVinculo.setModel(listModel);
			
			if (f.getSexo().equals("Masculino")){
				masculino.setSelected(true);
				feminino.setSelected(false);
			}
			else{
				feminino.setSelected(true);
				masculino.setSelected(false);				
			}
			
			
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
			}
			uf.setText(f.getEndereco().getUf());
			ufNascimento.setValue(f.getUfNascimento());
			ufOrgao.setValue(f.getUfOrgao());
			
			tipoDeUsuario.getChildren().clear();
		 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
				Comboitem comboitem = new Comboitem(tp.getDescricao());
				comboitem.setValue(tp);
				tipoDeUsuario.appendChild(comboitem);
		 	}
			
			tipoDeUsuario.setValue(f.getUsuario().getTipoDeUsuario().getDescricao());			
			
			nome.setConstraint("no empty");
			funcao.setConstraint("no empty");
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

    public void onClick$ListarFuncionario(){
		pesquisarFuncionario.setVisible(false);
		cadastroFuncionario.setVisible(false);
		listarFuncionario.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarFuncionario());
		ListagemFuncionario.setModel(listModel);
	}
	
	public void onClick$PesquisarFuncionario(){
		ProcurarFuncionario.setText("");
		cadastroFuncionario.setVisible(false);
		pesquisarFuncionario.setVisible(true);
	}
	
	public void onClick$cancelar(Event e) {	
		pesquisarFuncionario.setVisible(false);
		listarFuncionario.setVisible(false);
		cadastroFuncionario.setVisible(false);
    }
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Funcionario ff = Facade.getInstance().carregarFuncionario(((Funcionario) ListagemFuncionario.getModel().getElementAt(ListagemFuncionario.getSelectedIndex())).getId());
		
		ff.setNome(nome.getValue());
		ff.setFuncao(funcao.getValue());
		ff.setNascimento(nascimento.getValue());
		ff.setNaturalidade(naturalidade.getValue());
		ff.setNacionalidade(nacionalidade.getValue());
		ff.setMaeFunc(maeFunc.getValue());
		ff.setPaiFunc(paiFunc.getValue());
		ff.setRg(String.valueOf(rg.getValue()));
		ff.setOrgExpedidor(orgExpedidor.getValue());
		ff.setRgExpedicao(rgExpedicao.getValue());
		ff.setCpf(cpf.getValue());
		ff.setReservista(reservista.getValue());
		ff.setSerie(serie.getValue());
		ff.setCategoria(categoria.getValue());
		ff.getUsuario().setSenha(senha.getValue());
		ff.getUsuario().setUsuario(usuario.getValue());
		ff.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
		ff.getEndereco().setLogradouro(logradouro.getValue());
		ff.getEndereco().setNumero(numero.getValue());
		ff.getEndereco().setReferencia(referencia.getValue());
		ff.getEndereco().setBairro(bairro.getValue());
		ff.getEndereco().setCidade(cidade.getValue());
		ff.getEndereco().setCep(cep.getValue());
		ff.setTelefone(telefone.getValue());
		ff.setRamalTelefone(ramalTelefone.getValue());
		ff.setCelular(celular.getValue());
		ff.setFax(fax.getValue());
		ff.setEmail(email.getValue());
		ff.getDadosBancarios().setBanco(banco.getValue());
		ff.getDadosBancarios().setConta(conta.getValue());
		ff.getDadosBancarios().setAgencia(agencia.getValue());
		ff.getDadosBancarios().setOperacao(operacao.getValue());
		ff.setCategoria(f.getCategoria());
		ff.getEndereco().setUf(uf.getValue());
		ff.setSexo(sexo.getSelectedItem().getValue());
		ff.setEstadoCivil(estadoCivil.getValue());
		ff.setUfNascimento(ufNascimento.getValue());
		ff.setNecessidade(necessidade.getValue());
		ff.setUfOrgao(ufOrgao.getValue());
		ff.setTituloEleitoral(tituloEleitoral.getValue());
		ff.setSecaoEleitoral(secao.getValue());
		ff.setZonaEleitoral(zona.getValue());
		
		System.out.println("CHEGOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		Facade.getInstance().atualizarFuncionario(ff);
		
	 	ff = new Funcionario();
	 	pesquisarFuncionario.setVisible(false);
		listarFuncionario.setVisible(false);
		cadastroFuncionario.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarFuncionario());
		ListagemFuncionario.setModel(listModel);
		Messagebox.show("Funcionário Alterado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
	}
	
	public void onClick$DeletarFuncionario(Event event) throws InterruptedException {
		if(listarFuncionario.isVisible() && ListagemFuncionario.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar o Funcionário selecionado?",
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
		Facade.getInstance().removerFuncionario((Funcionario) ListagemFuncionario.getModel().getElementAt(ListagemFuncionario.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarFuncionario());
		ListagemFuncionario.setModel(listModel);
	}

}
