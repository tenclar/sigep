package br.com.sigep.controller;


import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.RegistroDeAula;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class RegistroDeAulaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	
	private Div FiltroRegistroDeAula;
	private Div cadastroRegistroDeAula;
	private Div JanelaRegistroDeAula;
	private Div pesquisarRegistroDeAula; 
	private Listbox ListagemRegistroDeAula; //domain object summary list
	private ListModel listModel;
	private Label professor;
	private Label disciplina;
	private Intbox qtdAula;
	private Datebox data;
	private Textbox assunto;
	private Textbox id;
	private Textbox ProcurarRegistroDeAula;
	private Button avancar;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Button listarRegistro;
	private DataBinder binder;
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox disciplinaProfessorCombo;
	private Row RowSerie;
	private Row RowNivel;
	private Row RowTurma;
	private Row rowId;
	private Row RowDisciplinaProfessor;
		
	Constraint c = null;
	
	Turma turma = null;
	RegistroDeDisciplina selectedDisciplina = null;
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	RegistroDeAula ra = new RegistroDeAula();
			
	public RegistroDeAula getRa() {
		return ra;
	}

	public void setRa(RegistroDeAula ra) {
		this.ra = ra;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Serie getS() {
		return s;
	}

	public void setS(Serie s) {
		this.s = s;
	}
	
	public NivelEscolar getNe1() {
		return ne1;
	}

	public void setNe1(NivelEscolar ne1) {
		this.ne1 = ne1;
	}

	public AnoLetivo getAnoletivoObj() {
		return anoletivoObj;
	}

	public void setAnoletivoObj(AnoLetivo anoletivoObj) {
		this.anoletivoObj = anoletivoObj;
	}
	
	public RegistroDeDisciplina getSelectedDisciplina() {
		return selectedDisciplina;
	}
	
	public void setSelectedDisciplina(RegistroDeDisciplina selectedDisciplina) {
		this.selectedDisciplina = selectedDisciplina;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		if(nivelCombo.getSelectedIndex() == -1 || anoLetivoCombo.getSelectedIndex() == -1 || 
				serieCombo.getSelectedIndex() == -1 || turmaCombo.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{
		ra.setData(data.getValue());
		ra.setQtdAula(qtdAula.getValue());
		ra.setAssunto(assunto.getValue());
		ra.setRegistroDeDisciplina(selectedDisciplina);
		
		Facade.getInstance().salvarRegistroDeAula(ra);
		
		Messagebox.show("Registro de Aula Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		ra = new RegistroDeAula();
		cadastroRegistroDeAula.setVisible(false);
		}
	} 
	
	public void onClick$resultadoRegistroDeAula() throws InterruptedException{
		if (ProcurarRegistroDeAula.getText() == "" && JanelaRegistroDeAula.isVisible()) {
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
		
			List<RegistroDeAula> list = new ArrayList<RegistroDeAula>();
			for(RegistroDeAula ra: Facade.getInstance().listarRegistroDeAulaFiltro(ProcurarRegistroDeAula.getText())){
				if(ra.getRegistroDeDisciplina().getId() == selectedDisciplina.getId()){
								list.add(ra);
				}
			}
			
			listModel = new ListModelList(list);
			ListagemRegistroDeAula.setModel(listModel);
			JanelaRegistroDeAula.setVisible(true);
		}
		
	}
	
	public void onClick$CadastrarRegistroDeAula(Event e) {
		listarComboAnoLetivo();
		anoLetivoCombo.setValue("");
		nivelCombo.setValue("");
		serieCombo.setValue("");
		turmaCombo.setValue("");
		disciplinaProfessorCombo.setValue("");
		nivelCombo.setDisabled(true);
		serieCombo.setDisabled(true);
		turmaCombo.setDisabled(true);
		disciplinaProfessorCombo.setDisabled(true);		
	  	cadastroRegistroDeAula.setVisible(false);
	  	FiltroRegistroDeAula.setVisible(true);
	  	JanelaRegistroDeAula.setVisible(false);
	  	pesquisarRegistroDeAula.setVisible(false);
	  	listarRegistro.setVisible(false);
	  	rowId.setVisible(false);
		avancar.setVisible(true);
		avancar.setDisabled(true);
	}
	
	public void onClick$ListarRegistroDeAula(Event e) {
		listarComboAnoLetivo(); 
		anoLetivoCombo.setValue("");
		nivelCombo.setValue("");
		serieCombo.setValue("");
		turmaCombo.setValue("");
		disciplinaProfessorCombo.setValue("");
		nivelCombo.setDisabled(true);
		serieCombo.setDisabled(true);
		turmaCombo.setDisabled(true);
		disciplinaProfessorCombo.setDisabled(true);	
	  	FiltroRegistroDeAula.setVisible(true);
	  	cadastroRegistroDeAula.setVisible(false);
	  	JanelaRegistroDeAula.setVisible(false);
	  	pesquisarRegistroDeAula.setVisible(false);
	  	rowId.setVisible(false);
		avancar.setVisible(false);
		listarRegistro.setVisible(true);
		listarRegistro.setDisabled(true);
	}
	
	public void onClick$listarRegistro(Event e) {
		selectedDisciplina = ((RegistroDeDisciplina) disciplinaProfessorCombo.getSelectedItem().getValue());
		
		List<RegistroDeAula> list = new ArrayList<RegistroDeAula>();
		for(RegistroDeAula ra: Facade.getInstance().listarRegistroDeAula()){
			if(ra.getRegistroDeDisciplina().getId() == selectedDisciplina.getId()){
						list.add(ra);
			}
		}
		
		listModel = new ListModelList(list);
		ListagemRegistroDeAula.setModel(listModel);
		
		FiltroRegistroDeAula.setVisible(false);
	  	cadastroRegistroDeAula.setVisible(false);
		JanelaRegistroDeAula.setVisible(true);
		
	}
	
	public void onClick$EditarRegistroDeAula(Event e) throws InterruptedException {
		if(JanelaRegistroDeAula.isVisible() && ListagemRegistroDeAula.getSelectedIndex()!=-1){
			pesquisarRegistroDeAula.setVisible(false);
			JanelaRegistroDeAula.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroRegistroDeAula.setVisible(true);
			rowId.setVisible(true);
			RegistroDeAula ra =(RegistroDeAula) ListagemRegistroDeAula.getModel().getElementAt(ListagemRegistroDeAula.getSelectedIndex());	
			id.setText(String.valueOf(ra.getId()));
			assunto.setValue(ra.getAssunto());
			data.setValue(ra.getData());
			qtdAula.setValue(ra.getQtdAula());
			
			assunto.setConstraint("no empty");
			data.setConstraint("no empty");
			qtdAula.setConstraint("no empty, no zero, no negative");
			
			professor.setValue(ra.getRegistroDeDisciplina().getProfessor().getNome());
			disciplina.setValue(ra.getRegistroDeDisciplina().getDisciplina().getNome());
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
	
	public void onClick$salvar(Event e) throws InterruptedException {
		
		RegistroDeAula raa = Facade.getInstance().carregarRegistroDeAula(((RegistroDeAula) ListagemRegistroDeAula.getModel().getElementAt(ListagemRegistroDeAula.getSelectedIndex())).getId());
		raa.setAssunto(assunto.getValue());
		raa.setData(data.getValue());
		raa.setQtdAula(qtdAula.getValue());
		raa.setRegistroDeDisciplina(selectedDisciplina);		
		
		Facade.getInstance().atualizarRegistroDeAula(raa);
		
	 	raa = new RegistroDeAula();
	 	
	 	FiltroRegistroDeAula.setVisible(false);
	  	cadastroRegistroDeAula.setVisible(false);
	  	JanelaRegistroDeAula.setVisible(false);
	  	pesquisarRegistroDeAula.setVisible(false);
		
		Messagebox.show("Registro de Aula Alterado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
	}
	
	public void onClick$cancelar(Event e) {
		rowId.setVisible(false);
		FiltroRegistroDeAula.setVisible(false);
	  	cadastroRegistroDeAula.setVisible(false);
	  	JanelaRegistroDeAula.setVisible(false);
	  	pesquisarRegistroDeAula.setVisible(false);
    }
	
	public void onClick$PesquisarRegistroDeAula(){
		ProcurarRegistroDeAula.setText("");
		rowId.setVisible(false);
		FiltroRegistroDeAula.setVisible(false);
	  	cadastroRegistroDeAula.setVisible(false);
	  	pesquisarRegistroDeAula.setVisible(true);
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
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
			
		anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
  	 	
  	 	nivelCombo.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	 	
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivelCombo.appendChild(comboitem);
  	 	}	
  	 	nivelCombo.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	
	  	
	}
	
	public void onSelect$nivelCombo(Event e) {
  	 	
		ne1 = ((NivelEscolar) nivelCombo.getSelectedItem().getValue());
  	 	serieCombo.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne1.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(se.getDescricao());
			comboitem.setValue(se);
			serieCombo.appendChild(comboitem);
	 	}
  	 	
  	 	serieCombo.setDisabled(false);
  	 	binder.loadComponent(RowSerie); 	
  	
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
  	 	binder.loadComponent(RowTurma); 
		
	}

	public void onSelect$turmaCombo() throws InterruptedException{

		turma = ((Turma) turmaCombo.getSelectedItem().getValue());
		disciplinaProfessorCombo.getChildren().clear();

		if (Facade.getInstance().listarRegistroDeDisciplinaTurma(turma.getId()).isEmpty() == true) {
			Messagebox.show(
							"Não existem Disciplinas nem Professores associados à essa Turma!",
							"Atenção!", Messagebox.OK, Messagebox.EXCLAMATION,
							new org.zkoss.zk.ui.event.EventListener() {
								public void onEvent(Event arg1)
										throws Exception {
								}
							});
		} else {

			for (RegistroDeDisciplina rd : Facade.getInstance().listarRegistroDeDisciplinaTurma(turma.getId())) {
				Comboitem comboitem = new Comboitem();
				comboitem.setLabel(rd.getDisciplina().getNome() + " | "	+ rd.getProfessor().getNome());
				comboitem.setValue(rd);
				disciplinaProfessorCombo.appendChild(comboitem);
			}

			disciplinaProfessorCombo.setDisabled(false);
			avancar.setDisabled(false);
			listarRegistro.setDisabled(false);
			binder.loadComponent(RowDisciplinaProfessor);
		}
		
	}
	
	public void onClick$avancar(){
		
		selectedDisciplina = ((RegistroDeDisciplina) disciplinaProfessorCombo.getSelectedItem().getValue());
		FiltroRegistroDeAula.setVisible(false);
		adicionar.setVisible(true);
		cancelar.setVisible(false);
		salvar.setVisible(false);
		cadastroRegistroDeAula.setVisible(true);
		disciplina.setValue(selectedDisciplina.getDisciplina().getNome());
		professor.setValue(selectedDisciplina.getProfessor().getNome());
		
		assunto.setConstraint(c);
		data.setConstraint(c);
		qtdAula.setConstraint(c);
		
		data.setText("");
		assunto.setText("");
		qtdAula.setText("");
		
		assunto.setConstraint("no empty");
		data.setConstraint("no empty");
		qtdAula.setConstraint("no empty, no zero, no negative");
	}
	
	public void onClick$DeletarRegistroDeAula(Event event) throws InterruptedException {  
		if(JanelaRegistroDeAula.isVisible() && ListagemRegistroDeAula.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar o Registro de Aula selecionado?",
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
		Facade.getInstance().removerRegistroDeAula((RegistroDeAula) ListagemRegistroDeAula.getModel().getElementAt(ListagemRegistroDeAula.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarRegistroDeAula());
		ListagemRegistroDeAula.setModel(listModel);
	}
	
}
