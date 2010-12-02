package br.com.sigep.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
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

import org.zkoss.zk.ui.event.Event;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;


public class AlunoController extends GenericForwardComposer{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Listbox ListagemAluno;
	private ListModel listModel;
	private Combobox uf;
	private Combobox ufNascimento;
	private Combobox ufOrgao;
	private Combobox ufReg;
	private Combobox necessidade;
	private Div FiltroAluno;
	private Div cadastroAluno;
	private Div listarAluno;
	private Div pesquisarAluno;
	private Button adicionar;
	private Button listarAlunos;
	private Button salvar;
	private Button cancelar;
	private Textbox id;
	private Textbox nome;
	private Textbox descricao;
	private Textbox matricula;
	private Intbox codigoMec;
	private Intbox cre;
	private Radiogroup etnia;
	private Radio negra;
	private Radio branca;
	private Radio amarela;
	private Radio parda;
	private Radio indigena;
	private Radiogroup sexo;
	private Radio masculino;
	private Radio feminino;
	private Radiogroup tipoTelefone;
	private Radio residencial;
	private Radio comercial;
	private Radio celular;
	private Radio recados;
	private Textbox ProcurarAluno;
	private Textbox responsavel;
	private Datebox nascimento;
	private Datebox rgExpedicao;
	private Datebox nascPai;
	private Datebox nascMae;
	private Textbox naturalidade;
	private Textbox nacionalidade;
	private Textbox maeAluno;
	private Textbox paiAluno;
	private Textbox profissao;
	private Textbox logradouro;
	private Textbox referencia;
	private Textbox bairro;
	private Textbox cidade;
	private Textbox telefone;
	private Textbox ramalTelefone;
	private Textbox ramalResponsavel;
	private Textbox telefoneResponsavel;
	private Textbox email;
	private Textbox nomeCartorio;
	private Textbox cidadeReg;
	private Textbox orgExpedidor;
	private Textbox usuario;
	private Textbox senha;
	private Textbox cep;
	private Intbox rg;
	private Intbox numero;
	private Intbox numeroLivro;
	private Intbox numeroRegistro;
	private Textbox cpf;

	
	private Row rowId;
	private Constraint c;
	
	private Row RowFiltroSerie;
	private Row RowFiltroTurma;
	private Row RowNivel;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox anoLetivoCombo;
	private Combobox tipoDeUsuario;
	
	private Tab tabIdentificacao;
	private Tab tabMatricula;
	
	private Row RowNivel2;
	private Row RowSerie;
	private Row RowTurma;
	private Combobox anoLetivoCombo2;
	private Combobox nivelCombo2;
	private Combobox serieCombo2;
	private Combobox turmaCombo2;
	private Combobox turnoCombo2;
	private DataBinder binder;
	private Image imageVideo;
	private static final String SAVE_PATH = "d:/dados/";
	
	Aluno a = new Aluno ();
	Matricula m = new Matricula();
	NivelEscolar ne = new NivelEscolar();
	Serie s = new Serie();
	Turma t = new Turma();
	AnoLetivo anoletivoObj = new AnoLetivo();	
	
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
	
	public Aluno getA() {
		return a;
	}

	public void setA(Aluno a) {
		this.a = a;
	}
	
	public AnoLetivo getAnoletivoObj() {
		return anoletivoObj;
	}

	public void setAnoletivoObj(AnoLetivo anoletivoObj) {
		this.anoletivoObj = anoletivoObj;
	}

	public Matricula getM() {
		return m;
	}

	public void setM(Matricula m) {
		this.m = m;
	}

	public NivelEscolar getNe() {
		return ne;
	}

	public void setNe(NivelEscolar ne) {
		this.ne = ne;
	}

	public Serie getS() {
		return s;
	}

	public void setS(Serie s) {
		this.s = s;
	}

	public Turma getT() {
		return t;
	}

	public void setT(Turma t) {
		this.t = t;
	}
	
	public void onUpload$uploadImage(UploadEvent event) throws InterruptedException {
		Media media = event.getMedia();
		if (media instanceof org.zkoss.image.Image) {
			a.setFoto(media.getName());
			binder.loadAll();
			imageVideo.setContent((org.zkoss.image.Image) media);
			saveFile(media);
		}else{
			Messagebox.show("Não é uma imagem: "+media, "Error", Messagebox.OK, Messagebox.ERROR);
		}
	}

	private void saveFile(Media media) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			InputStream fin = media.getStreamData();			
			in = new BufferedInputStream(fin);
			File baseDir = new File(SAVE_PATH);
			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}
			File file = new File(SAVE_PATH + media.getName());
			OutputStream fout = new FileOutputStream(file);
			out = new BufferedOutputStream(fout);
			byte buffer[] = new byte[1024];
			int ch = in.read(buffer);
			while (ch != -1) {
				out.write(buffer, 0, ch);
				ch = in.read(buffer);
			}			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null) 
					out.close();	
				if (in != null)
					in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		
		if (uf.getSelectedIndex() == -1 
				|| ufOrgao.getSelectedIndex() == -1
				|| ufNascimento.getSelectedIndex() == -1
				|| etnia.getSelectedIndex() == -1
				|| tipoTelefone.getSelectedIndex() == -1
				|| necessidade.getSelectedIndex() == -1
				|| sexo.getSelectedIndex() == -1
				|| anoLetivoCombo2.getSelectedIndex() == -1
				|| nivelCombo2.getSelectedIndex() == -1
				|| serieCombo2.getSelectedIndex() == -1
				|| turnoCombo2.getSelectedIndex() == -1
				|| turmaCombo2.getSelectedIndex() == -1
				|| tipoDeUsuario.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		}else if(Facade.getInstance().verificarSeRGAlunoJaExiste(String.valueOf(rg.getValue())) == true){
			alert("Já Existe Aluno Cadastrado com o RG: "+ rg.getValue());
		} else if(Facade.getInstance().verificarSeCpfAlunoJaExiste(cpf.getValue()) == true){
			alert("Já Existe Aluno Cadastrado com o CPF: "+ cpf.getValue());
		}else{
			a.setNome(nome.getValue());
			a.setSexo(sexo.getSelectedItem().getValue());
			a.setNascimento(nascimento.getValue());
			a.setNaturalidade(naturalidade.getValue());
			a.setUfNascimento(ufNascimento.getValue());
			a.setNacionalidade(nacionalidade.getValue());
			a.setEtnia(etnia.getSelectedItem().getValue());
			a.setNecessidade(necessidade.getValue());
			a.getEndereco().setLogradouro(logradouro.getValue());
			a.getEndereco().setNumero(numero.getValue());
			a.getEndereco().setReferencia(referencia.getValue());
			a.getEndereco().setBairro(bairro.getValue());
			a.getEndereco().setCidade(cidade.getValue());
			a.getEndereco().setUf(uf.getValue());
			a.getEndereco().setCep(cep.getValue());
			a.setTipoTelefone(tipoTelefone.getSelectedItem().getValue());
			a.setTelefone(telefone.getValue());
			a.setRamalTelefone(ramalTelefone.getValue());
			a.setEmail(email.getValue());
			a.setMaeAluno(maeAluno.getValue());
			a.setNascMae(nascMae.getValue());
			a.setPaiAluno(paiAluno.getValue());
			a.setNascPai(nascPai.getValue());
			a.setProfissao(profissao.getValue());
			a.setResponsavel(responsavel.getValue());
			a.setTelefoneResponsavel(telefoneResponsavel.getValue());
			a.setRamalResponsavel(ramalResponsavel.getValue());
			a.getRegistro().setNumeroRegistro(numeroRegistro.getValue());
			a.getRegistro().setNumeroLivro(numeroLivro.getValue());
			a.getRegistro().setNomeCartorio(nomeCartorio.getValue());
			a.getRegistro().setCidadeReg(cidadeReg.getValue());
			a.getRegistro().setUfReg(ufReg.getValue());
			a.setRg(String.valueOf(rg.getValue()));
			a.setOrgExpedidor(orgExpedidor.getValue());
			a.setUfOrgao(ufOrgao.getValue());
			a.setRgExpedicao(rgExpedicao.getValue());
			a.setCpf(cpf.getValue());
			a.getRecomendacoesMedicas().setDescricao(descricao.getValue());
			a.getUsuario().setSenha(senha.getValue());
			a.getUsuario().setUsuario(usuario.getValue());
			a.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
			a.setDataCadastro(new Date());

			m.setNumero(matricula.getValue());
			m.setCodigoMec(codigoMec.getValue());
			m.setCre(cre.getValue());

			m.setTurma((Turma) turmaCombo2.getSelectedItem().getValue());

			a.getMatricula().add(m);
			Facade.getInstance().salvarAluno(a);
			Messagebox.show("Aluno Cadastrado com Sucesso!", "Sucesso!",
					Messagebox.OK, Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					});
			a = new Aluno();
			m = new Matricula();
			cadastroAluno.setVisible(false);

		}
	}
	
	public void onSelect$nivelCombo2(Event e) {
		serieCombo2.setDisabled(false);
	
		ne = ((NivelEscolar) nivelCombo2.getSelectedItem().getValue());
		  serieCombo2.getChildren().clear();	  	  
	  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne.getId())) {
				Comboitem comboitem = new Comboitem(se.getDescricao());
				comboitem.setValue(se);
				serieCombo2.appendChild(comboitem);
		 	}
	  	 	nivelCombo2.setDisabled(false);
		binder.loadComponent(RowSerie);	
		
		
	}
	
	public void onSelect$serieCombo2(Event e) {
	turnoCombo2.setDisabled(false);
	}
	
	public void onSelect$turnoCombo2(Event e) {
		s = ((Serie) serieCombo2.getSelectedItem().getValue());
		String turnoo = ((String) turnoCombo2.getSelectedItem().getValue());
		turmaCombo2.setDisabled(false);
	    turmaCombo2.getChildren().clear();
	 	for (Turma tu : Facade.getInstance().listarTurmaSerieTurno(s.getId(), turnoo)) {
			Comboitem comboitem = new Comboitem(tu.getNome());
			comboitem.setValue(tu);
			turmaCombo2.appendChild(comboitem);
	 	}
	 	binder.loadComponent(RowTurma);
	}
	
	public void onClick$resultadoAluno() throws InterruptedException{
		if (ProcurarAluno.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarAlunoFiltro(ProcurarAluno.getText()));
			ListagemAluno.setModel(listModel);
			listarAluno.setVisible(true);
		}
		
	}
	
	public void onClick$ListarAluno(){		
		listarComboAnoLetivo();
		anoLetivoCombo.setText("");
		nivelCombo.setText("");
		serieCombo.setText("");
		turmaCombo.setText("");
		nivelCombo.setDisabled(true);
		serieCombo.setDisabled(true);
		turmaCombo.setDisabled(true);
		pesquisarAluno.setVisible(false);
		cadastroAluno.setVisible(false);
		listarAluno.setVisible(false);
		listarAlunos.setDisabled(true);
		listarAlunos.setVisible(true);
		FiltroAluno.setVisible(true);
	}
	
	public void onClick$PesquisarAluno(){
		ProcurarAluno.setText("");
		FiltroAluno.setVisible(false);
		listarAlunos.setVisible(false);
		cadastroAluno.setVisible(false);
		pesquisarAluno.setVisible(true);
	}
		
	 public void onClick$EditarAluno(Event e) throws InterruptedException {
			if(listarAluno.isVisible() && ListagemAluno.getSelectedIndex()!=-1){
				pesquisarAluno.setVisible(false);
				listarAlunos.setVisible(false);
				listarAluno.setVisible(false);
				adicionar.setVisible(false);
				FiltroAluno.setVisible(false);
				salvar.setVisible(true);
				cancelar.setVisible(true);			
				cadastroAluno.setVisible(true);
				rowId.setVisible(true);
				tabIdentificacao.setSelected(true);
				tabMatricula.setVisible(false);
				
				a =(Aluno) ListagemAluno.getModel().getElementAt(ListagemAluno.getSelectedIndex());
								
				id.setText(String.valueOf(a.getId()));
				nome.setValue(a.getNome());
				nascimento.setValue(a.getNascimento());
				naturalidade.setValue(a.getNaturalidade());
				nacionalidade.setValue(a.getNacionalidade());
				responsavel.setValue(a.getResponsavel());
				maeAluno.setValue(a.getMaeAluno());
				paiAluno.setValue(a.getPaiAluno());
				nascMae.setValue(a.getNascMae());
				nascPai.setValue(a.getNascPai());
				profissao.setValue(a.getProfissao());
				rg.setValue(Integer.parseInt(a.getRg()));
				orgExpedidor.setValue(a.getOrgExpedidor());
				rgExpedicao.setValue(a.getRgExpedicao());
				numeroRegistro.setValue(a.getRegistro().getNumeroRegistro());
				numeroLivro.setValue(a.getRegistro().getNumeroLivro());
				nomeCartorio.setValue(a.getRegistro().getNomeCartorio());
				cidadeReg.setValue(a.getRegistro().getCidadeReg());
				telefoneResponsavel.setValue(a.getTelefoneResponsavel());
				ramalResponsavel.setValue(a.getRamalResponsavel());				
				descricao.setValue(a.getRecomendacoesMedicas().getDescricao());
				cpf.setValue(a.getCpf());
				logradouro.setValue(a.getEndereco().getLogradouro());
				numero.setValue(a.getEndereco().getNumero());
				referencia.setValue(a.getEndereco().getReferencia());
				bairro.setValue(a.getEndereco().getBairro());
				cidade.setValue(a.getEndereco().getCidade());
				cep.setValue(String.valueOf(a.getEndereco().getCep()));
				telefone.setValue(a.getTelefone());
				ramalTelefone.setValue(a.getRamalTelefone());
				email.setValue(a.getEmail());
				senha.setValue(a.getUsuario().getSenha());
				usuario.setValue(a.getUsuario().getUsuario());
				necessidade.setValue(a.getNecessidade());
				
				for(Matricula m : a.getMatricula()){
					matricula.setValue(m.getNumero());
					codigoMec.setValue(m.getCodigoMec());
					cre.setValue(m.getCre());
				}
						
				//Sexo
				if (a.getSexo() != ""){					
					if (a.getSexo().equals("Masculino")){
						masculino.setSelected(true);
						feminino.setSelected(false);
					}
					else{
						feminino.setSelected(true);
						masculino.setSelected(false);				
					}
				}
				
				else{
					feminino.setSelected(false);
					masculino.setSelected(false);
				}
				
				//Etnia
				if (a.getEtnia() != ""){
				if (a.getEtnia().equals("Negra")){
						negra.setSelected(true);
						branca.setSelected(false);
						amarela.setSelected(false);
						parda.setSelected(false);
						indigena.setSelected(false);
					}
				if (a.getEtnia().equals("Branca")){
						branca.setSelected(true);
						negra.setSelected(false);
						amarela.setSelected(false);
						parda.setSelected(false);
						indigena.setSelected(false);
					}
				if (a.getEtnia().equals("Amarela")){
						amarela.setSelected(true);
						negra.setSelected(false);
						branca.setSelected(false);
						parda.setSelected(false);
						indigena.setSelected(false);
					}
				if (a.getEtnia().equals("Parda")){
						parda.setSelected(true);
						negra.setSelected(false);
						branca.setSelected(false);
						amarela.setSelected(false);
						indigena.setSelected(false);
					}
				if (a.getEtnia().equals("Indígena")){
						indigena.setSelected(true);
						negra.setSelected(false);
						branca.setSelected(false);
						amarela.setSelected(false);
						parda.setSelected(false);
				}	
					
				}
				else{
					negra.setSelected(false);
					branca.setSelected(false);
					amarela.setSelected(false);
					parda.setSelected(false);
					indigena.setSelected(false);
				}
				
				//Tipo de Telefone
				if (a.getTipoTelefone()!=""){
					if (a.getTipoTelefone().equals("Residencial")){
						residencial.setSelected(true);
						comercial.setSelected(false);
						celular.setSelected(false);
						recados.setSelected(false);
					}
					if (a.getTipoTelefone().equals("Comercial")){
						comercial.setSelected(true);
						residencial.setSelected(false);
						celular.setSelected(false);
						recados.setSelected(false);
					}
					if (a.getTipoTelefone().equals("Celular")){
						celular.setSelected(true);
						residencial.setSelected(false);
						comercial.setSelected(false);
						recados.setSelected(false);
					}
					if (a.getTipoTelefone().equals("Recados")){
						recados.setSelected(true);
						residencial.setSelected(false);
						comercial.setSelected(false);
						celular.setSelected(false);
					}	
					
				}
				else{
					recados.setSelected(false);
					residencial.setSelected(false);
					comercial.setSelected(false);
					celular.setSelected(false);
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
					
					Comboitem comboitemRegistro = new Comboitem(estadosv[i]);
					comboitemRegistro.setValue(estadosv[i]);
					ufReg.appendChild(comboitemRegistro);
				}
				
				uf.setText(a.getEndereco().getUf());
				ufNascimento.setValue(a.getUfNascimento());
				ufOrgao.setValue(a.getUfOrgao());
				ufReg.setValue(a.getRegistro().getUfReg());
				
				tipoDeUsuario.getChildren().clear();
			 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
					Comboitem comboitem = new Comboitem(tp.getDescricao());
					comboitem.setValue(tp);
					tipoDeUsuario.appendChild(comboitem);
			 	}
				
				tipoDeUsuario.setValue(a.getUsuario().getTipoDeUsuario().getDescricao());
				
				nome.setConstraint("no empty");
				responsavel.setConstraint("no empty");
				nascimento.setConstraint("no empty");
				rgExpedicao.setConstraint("no empty");
				naturalidade.setConstraint("no empty");
				nacionalidade.setConstraint("no empty");
				logradouro.setConstraint("no empty");
				bairro.setConstraint("no empty");
				cidade.setConstraint("no empty");
				telefoneResponsavel.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
				nomeCartorio.setConstraint("no empty");
				cidadeReg.setConstraint("no empty");
				orgExpedidor.setConstraint("no empty");
				usuario.setConstraint("no empty");
				senha.setConstraint("no empty");
				cep.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
				rg.setConstraint("no empty, no negative, no zero");
				numero.setConstraint("no empty, no negative, no zero");
				numeroLivro.setConstraint("no empty, no negative, no zero");
				numeroRegistro.setConstraint("no empty, no negative, no zero");
				cpf.setConstraint(ctt);
				cre.setConstraint("no empty, no zero, no negative");
				codigoMec.setConstraint("no empty, no zero, no negative");
				
				
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
	
	public void onClick$CadastrarAluno(){
		pesquisarAluno.setVisible(false);
		listarAlunos.setVisible(false);
		listarAluno.setVisible(false);
		FiltroAluno.setVisible(false);
		cadastroAluno.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		tabMatricula.setVisible(true);
		
		tabIdentificacao.setSelected(true);
		
		uf.setConstraint(c);
		ufNascimento.setConstraint(c);
		ufOrgao.setConstraint(c);
		ufReg.setConstraint(c);
		necessidade.setConstraint(c);
		nome.setConstraint(c);
		responsavel.setConstraint(c);
		nascimento.setConstraint(c);
		rgExpedicao.setConstraint(c);
		naturalidade.setConstraint(c);
		nacionalidade.setConstraint(c);
		logradouro.setConstraint(c);
		bairro.setConstraint(c);
		cidade.setConstraint(c);
		telefoneResponsavel.setConstraint(c);
		nomeCartorio.setConstraint(c);
		cidadeReg.setConstraint(c);
		orgExpedidor.setConstraint(c);
		usuario.setConstraint(c);
		senha.setConstraint(c);
		cep.setConstraint(c);
		rg.setConstraint(c);
		numero.setConstraint(c);
		numeroLivro.setConstraint(c);
		numeroRegistro.setConstraint(c);
		cpf.setConstraint(c);
		cre.setConstraint(c);
		codigoMec.setConstraint(c);
		nivelCombo2.setConstraint(c);
		turmaCombo2.setConstraint(c);
		serieCombo2.setConstraint(c);
		turnoCombo2.setConstraint(c);
		
		nome.setText("");
		nascimento.setText("");
		naturalidade.setText("");
		ufNascimento.setText("");
		nacionalidade.setText("");
		necessidade.setText("");
		logradouro.setText("");
		numero.setText("");
		referencia.setText("");
		bairro.setText("");
		cidade.setText("");
		uf.setText("");
		cep.setText("");		
		telefone.setText("");
		ramalTelefone.setText("");
		email.setText("");
		maeAluno.setText("");
		nascMae.setText("");
		paiAluno.setText("");
		nascPai.setText("");
		profissao.setText("");
		responsavel.setText("");
		telefoneResponsavel.setText("");
		ramalResponsavel.setText("");
		numeroRegistro.setText("");
		numeroLivro.setText("");
		nomeCartorio.setText("");
		cidadeReg.setText("");
		ufReg.setText("");
		rg.setText("");
		orgExpedidor.setText("");
		ufOrgao.setText("");
		rgExpedicao.setText("");
		cpf.setText("");
		descricao.setText("");
		senha.setText("");
		usuario.setText("");
		necessidade.setText("");
		matricula.setText("");
		codigoMec.setText("");
		cre.setText("");
		turmaCombo2.setText("");
		anoLetivoCombo2.setText("");
		
		listarComboAnoLetivo2();
		
		nivelCombo2.getChildren().clear();		
		nivelCombo2.setDisabled(true);
		nivelCombo2.setText("");
		
		serieCombo2.setDisabled(true);
		serieCombo2.getChildren().clear();
		serieCombo2.setText("");
		
		turnoCombo2.setDisabled(true);
		turnoCombo2.setText("");
		
		turmaCombo2.setDisabled(true);
		turmaCombo2.getChildren().clear();
		turmaCombo2.setText("");
		  	 
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
			
			Comboitem comboitemRegistro = new Comboitem(estadosv[i]);
			comboitemRegistro.setValue(estadosv[i]);
			ufReg.appendChild(comboitemRegistro);
		}
		
		tipoDeUsuario.getChildren().clear();
	 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
			Comboitem comboitem = new Comboitem(tp.getDescricao());
			comboitem.setValue(tp);
			tipoDeUsuario.appendChild(comboitem);
	 	}
		
		uf.setText("");
		ufNascimento.setText("");
		ufOrgao.setText("");
		ufReg.setText("");
		
		feminino.setSelected(false);
		masculino.setSelected(false);
		
		recados.setSelected(false);
		residencial.setSelected(false);
		comercial.setSelected(false);
		celular.setSelected(false);
		
		negra.setSelected(false);
		branca.setSelected(false);
		amarela.setSelected(false);
		parda.setSelected(false);
		indigena.setSelected(false);
		
		uf.setConstraint("no empty");
		ufNascimento.setConstraint("no empty");
		ufOrgao.setConstraint("no empty");
		ufReg.setConstraint("no empty");
		necessidade.setConstraint("no empty");
		nome.setConstraint("no empty");
		responsavel.setConstraint("no empty");
		nascimento.setConstraint("no empty");
		rgExpedicao.setConstraint("no empty");
		naturalidade.setConstraint("no empty");
		nacionalidade.setConstraint("no empty");
		logradouro.setConstraint("no empty");
		bairro.setConstraint("no empty");
		cidade.setConstraint("no empty");
		telefoneResponsavel.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		nomeCartorio.setConstraint("no empty");
		cidadeReg.setConstraint("no empty");
		orgExpedidor.setConstraint("no empty");
		usuario.setConstraint("no empty");
		senha.setConstraint("no empty");
		cep.setConstraint("no empty, /[0-9]+/: Este campo não pode ser vazio! Preencha-o somente com números!");
		rg.setConstraint("no empty, no negative, no zero");
		numero.setConstraint("no empty, no negative, no zero");
		numeroLivro.setConstraint("no empty, no negative, no zero");
		numeroRegistro.setConstraint("no empty, no negative, no zero");
		cpf.setConstraint(ctt);
		cre.setConstraint("no empty, no zero, no negative");
		codigoMec.setConstraint("no empty, no zero, no negative");
		nivelCombo2.setConstraint("no empty");
		turmaCombo2.setConstraint("no empty");
		serieCombo2.setConstraint("no empty");
		turnoCombo2.setConstraint("no empty");
		
	}
	
	public void onClick$cancelar(Event e) {	
		pesquisarAluno.setVisible(false);
		listarAluno.setVisible(false);
		cadastroAluno.setVisible(false);
		FiltroAluno.setVisible(false);
    }
	
	public void onClick$salvar(Event e) throws InterruptedException {
		
		Aluno aa = Facade.getInstance().carregarAluno(((Aluno) ListagemAluno.getModel().getElementAt(ListagemAluno.getSelectedIndex())).getId());
				
		aa.setNome(nome.getValue());
		aa.setNascimento(nascimento.getValue());
		aa.setNaturalidade(naturalidade.getValue());
		aa.setNacionalidade(nacionalidade.getValue());
		aa.setMaeAluno(maeAluno.getValue());
		aa.setPaiAluno(paiAluno.getValue());
		aa.setRg(String.valueOf(rg.getValue()));
		aa.setOrgExpedidor(orgExpedidor.getValue());
		aa.setRgExpedicao(rgExpedicao.getValue());
		aa.setCpf(cpf.getValue());
		aa.getUsuario().setSenha(senha.getValue());
		aa.getUsuario().setUsuario(usuario.getValue());
		aa.getUsuario().setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
		aa.getEndereco().setLogradouro(logradouro.getValue());
		aa.getEndereco().setNumero(numero.getValue());
		aa.getEndereco().setReferencia(referencia.getValue());
		aa.getEndereco().setBairro(bairro.getValue());
		aa.getEndereco().setCidade(cidade.getValue());
		aa.getEndereco().setCep(String.valueOf(cep.getValue()));
		aa.setTelefone(telefone.getValue());
		aa.setRamalTelefone(ramalTelefone.getValue());
		aa.setEmail(email.getValue());
		aa.getEndereco().setUf(uf.getValue());
		aa.setSexo(sexo.getSelectedItem().getValue());
		aa.setUfNascimento(ufNascimento.getValue());
		aa.setNecessidade(necessidade.getValue());
		aa.setUfOrgao(ufOrgao.getValue());
		
		Facade.getInstance().atualizarAluno(aa);
		
		aa = new Aluno();
	 	pesquisarAluno.setVisible(false);
		listarAluno.setVisible(false);
		cadastroAluno.setVisible(false);
		FiltroAluno.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarAluno());
		ListagemAluno.setModel(listModel);
		Messagebox.show("Aluno Alterado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		
	}
	
	public void onClick$DeletarAluno(Event event) throws InterruptedException {  
		if(listarAluno.isVisible() && ListagemAluno.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar o Aluno selecionado?",
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
		Facade.getInstance().removerAluno((Aluno) ListagemAluno.getModel().getElementAt(ListagemAluno.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarAluno());
		ListagemAluno.setModel(listModel);
	}
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
		
		anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
  	  	nivelCombo.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	  			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivelCombo.appendChild(comboitem);
  	
  	 	nivelCombo.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	}
  	
	}
	
	public void onSelect$anoLetivoCombo2(Event e) throws InterruptedException {
		
		anoletivoObj = (AnoLetivo) anoLetivoCombo2.getSelectedItem().getValue();
  	  	 		
  	 	nivelCombo2.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivelCombo2.appendChild(comboitem);
	 	}
  	 	
  	 	nivelCombo2.setDisabled(false);
  	 	binder.loadComponent(RowNivel2); 
  	
	}

	public void onSelect$nivelCombo(Event e) {
	 	
		ne = ((NivelEscolar) nivelCombo.getSelectedItem().getValue());
	 	serieCombo.getChildren().clear();
	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne.getId())) {
		Comboitem comboitem = new Comboitem();
		comboitem.setLabel(se.getDescricao());
		comboitem.setValue(se);
		serieCombo.appendChild(comboitem);
	 	}
	 	
	 	serieCombo.setDisabled(false);
	 	binder.loadComponent(RowFiltroSerie); 	
	
	}

	public void onSelect$serieCombo(){

	s = ((Serie) serieCombo.getSelectedItem().getValue());
	turmaCombo.getChildren().clear();
	 	for (Turma t : Facade.getInstance().listarTurmaSerie(s.getId(), anoletivoObj.getId())) {
		Comboitem comboitem = new Comboitem();
		comboitem.setLabel(t.getNome());
		comboitem.setValue(t);
		turmaCombo.appendChild(comboitem);
 	}
	 	
	 	turmaCombo.setDisabled(false);
	 	binder.loadComponent(RowFiltroTurma); 
	
	}

	public void onSelect$turmaCombo(){

	t = ((Turma) turmaCombo.getSelectedItem().getValue());
	listarAlunos.setDisabled(false); 
	
	}

	public void onClick$listarAlunos(){
	pesquisarAluno.setVisible(false);
	cadastroAluno.setVisible(false);
	FiltroAluno.setVisible(false);
	listarAluno.setVisible(true);	
	listModel = new ListModelList(Facade.getInstance().listarAlunoTurma(t.getId()));
	ListagemAluno.setModel(listModel);
	}

	public void listarComboAnoLetivo(){
	anoLetivoCombo.getChildren().clear();
	 	for (br.com.sigep.bean.AnoLetivo ano : br.com.sigep.facade.Facade.getInstance().listarAnoLetivo()) {
		Comboitem comboitem = new Comboitem();
		comboitem.setLabel("Ano - " + ano.getAno());
		comboitem.setValue(ano);
		anoLetivoCombo.appendChild(comboitem);
	 	}
	}
	
	public void listarComboAnoLetivo2(){
		anoLetivoCombo2.getChildren().clear();
		 	for (br.com.sigep.bean.AnoLetivo ano : br.com.sigep.facade.Facade.getInstance().listarAnoLetivo()) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel("Ano - " + ano.getAno());
			comboitem.setValue(ano);
			anoLetivoCombo2.appendChild(comboitem);
		 	}
		}
	
		
}
