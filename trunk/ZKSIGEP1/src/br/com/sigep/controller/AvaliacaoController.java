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
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;

import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Avaliacao;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Resultado;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class AvaliacaoController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
		
	private Div pesquisarAvaliacao; 		
	private Div JanelaAvaliacao;
	private Div FiltroAvaliacao;
	private Div cadastroAvaliacao;
	private ListModel listModel;
	private Listbox ListagemAvaliacao; //domain object summary list	
	private Label professor;
	private Label disciplina;
	private Textbox ProcurarAvaliacao;
	private Textbox valorTotal;
	private Textbox peso;
	private Datebox data;
	private Textbox descricao;
	private Textbox id;	
	private DataBinder binder;
	private Combobox etapa;
	private Combobox periodo;
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox disciplinaProfessorCombo;
	private Button avancar;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Button listarRegistro;
	private Row rowId;
	private Row RowSerie;
	private Row RowNivel;
	private Row RowTurma;
	private Row RowDisciplinaProfessor;
			
	Constraint c = null;
	
	Turma turma = null;
	RegistroDeDisciplina selectedDisciplina = null;
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	Avaliacao a = new Avaliacao();
	Resultado rr = new Resultado();
	
	public Avaliacao getA() {
		return a;
	}

	public void setA(Avaliacao a) {
		this.a = a;
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
		if(etapa.getSelectedIndex() == -1 || periodo.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{		
		a.setData(data.getValue());
		a.setValorTotal(Float.parseFloat(valorTotal.getValue()));
		a.setPeso(Float.parseFloat(peso.getValue()));
		a.setDescricao(descricao.getValue());
		a.setEtapa(etapa.getValue());
		a.setPeriodo(periodo.getValue());
		a.setRegistroDeDisciplina(selectedDisciplina);
		
		Facade.getInstance().salvarAvaliacao(a);
		
		for(Aluno al : Facade.getInstance().listarAlunoTurma(selectedDisciplina.getTurma().getId())){
			
			rr.setAluno(al);
			rr.setAvaliacao(a);
			rr.setNota(0);
			
			Facade.getInstance().salvarResultado(rr);			
			
			rr = new Resultado();
		}
		
		Messagebox.show("Avaliação Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		a = new Avaliacao();
		cadastroAvaliacao.setVisible(false);
		}
	} 	
	
	public void onClick$resultadoAvaliacao() throws InterruptedException{
		if (ProcurarAvaliacao.getText() == "" && JanelaAvaliacao.isVisible()) {
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
		
			List<Avaliacao> list = new ArrayList<Avaliacao>();
			for(Avaliacao av: Facade.getInstance().listarAvaliacaoFiltro(ProcurarAvaliacao.getText())){
				if(av.getRegistroDeDisciplina().getId() == selectedDisciplina.getId()){
								list.add(av);
				}
			}
			
			listModel = new ListModelList(list);
			ListagemAvaliacao.setModel(listModel);
			JanelaAvaliacao.setVisible(true);
		}
		
	}
	
	public void onClick$CadastrarAvaliacao(Event e) {
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
	  	cadastroAvaliacao.setVisible(false);
	  	FiltroAvaliacao.setVisible(true);
	  	JanelaAvaliacao.setVisible(false);
	  	pesquisarAvaliacao.setVisible(false);
	  	listarRegistro.setVisible(false);
	  	rowId.setVisible(false);
		avancar.setVisible(true);
		avancar.setDisabled(true);
	}
	
	public void onClick$ListarAvaliacao(Event e) {
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
	  	FiltroAvaliacao.setVisible(true);
	  	cadastroAvaliacao.setVisible(false);
	  	JanelaAvaliacao.setVisible(false);
	  	pesquisarAvaliacao.setVisible(false);
	  	rowId.setVisible(false);
		avancar.setVisible(false);
		listarRegistro.setVisible(true);
		listarRegistro.setDisabled(true);
	}
	
	public void onClick$listarRegistro(Event e) {
		selectedDisciplina = ((RegistroDeDisciplina) disciplinaProfessorCombo.getSelectedItem().getValue());
		
		List<Avaliacao> list = new ArrayList<Avaliacao>();
		for(Avaliacao avv: Facade.getInstance().listarAvaliacao()){
			if(avv.getRegistroDeDisciplina().getId() == selectedDisciplina.getId()){
						list.add(avv);
			}
		}
		
		listModel = new ListModelList(list);
		ListagemAvaliacao.setModel(listModel);
		
		FiltroAvaliacao.setVisible(false);
	  	cadastroAvaliacao.setVisible(false);
		JanelaAvaliacao.setVisible(true);
		
	}
	
	public void onClick$EditarAvaliacao(Event e) throws InterruptedException {
		if(JanelaAvaliacao.isVisible() && ListagemAvaliacao.getSelectedIndex()!=-1){
			pesquisarAvaliacao.setVisible(false);
			JanelaAvaliacao.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroAvaliacao.setVisible(true);
			rowId.setVisible(true);
			Avaliacao av =(Avaliacao) ListagemAvaliacao.getModel().getElementAt(ListagemAvaliacao.getSelectedIndex());	
			id.setText(String.valueOf(av.getId()));
			descricao.setValue(av.getDescricao());
			data.setValue(av.getData());
			peso.setValue(String.valueOf(av.getPeso()));
			valorTotal.setValue(String.valueOf(av.getValorTotal()));
			
			descricao.setConstraint("no empty");
			data.setConstraint("no empty");
			peso.setConstraint("no empty, no zero, no negative");
			valorTotal.setConstraint("no empty, no zero, no negative");
			
			professor.setValue(av.getRegistroDeDisciplina().getProfessor().getNome());
			disciplina.setValue(av.getRegistroDeDisciplina().getDisciplina().getNome());
			
			periodo.getChildren().clear();
			
			Comboitem comboitem0 = new Comboitem();
			comboitem0.setLabel("1º Período");
			comboitem0.setValue(1);
			periodo.appendChild(comboitem0);
			
			Comboitem comboitem4 = new Comboitem();
			comboitem4.setLabel("2º Período");
			comboitem4.setValue(2);
			periodo.appendChild(comboitem4);
			
			periodo.setValue(av.getPeriodo());
			
			etapa.getChildren().clear();
			
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel("1ª Etapa");
			comboitem.setValue(1);
			etapa.appendChild(comboitem);
			
			Comboitem comboitem1 = new Comboitem();
			comboitem1.setLabel("2ª Etapa");
			comboitem1.setValue(2);
			etapa.appendChild(comboitem1);

			Comboitem comboitem2 = new Comboitem();
			comboitem2.setLabel("3ª Etapa");
			comboitem2.setValue(3);
			etapa.appendChild(comboitem2);
			
			Comboitem comboitem3 = new Comboitem();
			comboitem3.setLabel("4ª Etapa");
			comboitem3.setValue(4);
			etapa.appendChild(comboitem3);
			
			etapa.setValue(av.getEtapa());
			
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
		
		Avaliacao avv = Facade.getInstance().carregarAvaliacao(((Avaliacao) ListagemAvaliacao.getModel().getElementAt(ListagemAvaliacao.getSelectedIndex())).getId());
		
		avv.setDescricao(descricao.getValue());
		avv.setPeso(Float.parseFloat(peso.getValue()));
		avv.setValorTotal(Float.parseFloat(valorTotal.getValue()));
		avv.setData(data.getValue());
		avv.setEtapa(etapa.getValue());
		avv.setPeriodo(periodo.getValue());		
		avv.setRegistroDeDisciplina(selectedDisciplina);
		
		Facade.getInstance().atualizarAvaliacao(avv);
		
	 	avv = new Avaliacao();
	 	
	 	FiltroAvaliacao.setVisible(false);
	  	cadastroAvaliacao.setVisible(false);
	  	JanelaAvaliacao.setVisible(false);
	  	pesquisarAvaliacao.setVisible(false);
		
		Messagebox.show("Avalição Alterada com Sucesso!",
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
		FiltroAvaliacao.setVisible(false);
	  	cadastroAvaliacao.setVisible(false);
	  	JanelaAvaliacao.setVisible(false);
	  	pesquisarAvaliacao.setVisible(false);
    }
	
	public void onClick$PesquisarAvaliacao(){
		ProcurarAvaliacao.setText("");
		rowId.setVisible(false);
		FiltroAvaliacao.setVisible(false);
	  	cadastroAvaliacao.setVisible(false);
	  	pesquisarAvaliacao.setVisible(true);
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

	public void onSelect$turmaCombo(){

		turma = ((Turma) turmaCombo.getSelectedItem().getValue());
		disciplinaProfessorCombo.getChildren().clear();
  	 	for (RegistroDeDisciplina rd : Facade.getInstance().listarRegistroDeDisciplinaTurma(turma.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(rd.getDisciplina().getNome() + " | "+ rd.getProfessor().getNome());
			comboitem.setValue(rd);
			disciplinaProfessorCombo.appendChild(comboitem);
	 	}
  	 	
  	 	disciplinaProfessorCombo.setDisabled(false);
  	 	avancar.setDisabled(false);
  	 	listarRegistro.setDisabled(false);
  	 	binder.loadComponent(RowDisciplinaProfessor); 
		
	}

	
	public void onClick$avancar(){
		
		selectedDisciplina = ((RegistroDeDisciplina) disciplinaProfessorCombo.getSelectedItem().getValue());
		
		FiltroAvaliacao.setVisible(false);
		adicionar.setVisible(true);
		cancelar.setVisible(false);
		salvar.setVisible(false);
		cadastroAvaliacao.setVisible(true);
		disciplina.setValue(selectedDisciplina.getDisciplina().getNome());
		professor.setValue(selectedDisciplina.getProfessor().getNome());
		
		descricao.setConstraint(c);
		data.setConstraint(c);
		peso.setConstraint(c);
		valorTotal.setConstraint(c);
		
		data.setText("");
		peso.setText("");
		valorTotal.setText("");
		descricao.setText("");
		
		descricao.setConstraint("no empty");
		data.setConstraint("no empty");
		peso.setConstraint("no empty, no zero, no negative");
		valorTotal.setConstraint("no empty, no zero, no negative");
		
		periodo.getChildren().clear();
		
		Comboitem comboitem0 = new Comboitem();
		comboitem0.setLabel("1º Período");
		comboitem0.setValue(1);
		periodo.appendChild(comboitem0);
		
		Comboitem comboitem4 = new Comboitem();
		comboitem4.setLabel("2º Período");
		comboitem4.setValue(2);
		periodo.appendChild(comboitem4);
		
		periodo.setText("");
		
		etapa.getChildren().clear();
		
		Comboitem comboitem = new Comboitem();
		comboitem.setLabel("1ª Etapa");
		comboitem.setValue(1);
		etapa.appendChild(comboitem);
		
		Comboitem comboitem1 = new Comboitem();
		comboitem1.setLabel("2ª Etapa");
		comboitem1.setValue(2);
		etapa.appendChild(comboitem1);

		Comboitem comboitem2 = new Comboitem();
		comboitem2.setLabel("3ª Etapa");
		comboitem2.setValue(3);
		etapa.appendChild(comboitem2);
		
		Comboitem comboitem3 = new Comboitem();
		comboitem3.setLabel("4ª Etapa");
		comboitem3.setValue(4);
		etapa.appendChild(comboitem3);
		
		etapa.setText("");
	}
	
	public void onClick$DeletarAvaliacao(Event event) throws InterruptedException {  
		if(JanelaAvaliacao.isVisible() && ListagemAvaliacao.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Avaliação selecionada?",
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
		Facade.getInstance().removerAvaliacao((Avaliacao) ListagemAvaliacao.getModel().getElementAt(ListagemAvaliacao.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarAvaliacao());
		ListagemAvaliacao.setModel(listModel);
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
	
}
