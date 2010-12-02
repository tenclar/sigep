package br.com.sigep.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import org.zkoss.zul.Messagebox;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Avaliacao;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Resultado;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class ResultadoController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private Listbox ListagemAvaliacao;
	private Listbox ListagemAluno;
	private Div janelaAvaliacao;
	private Div janelaAvaliacaoAluno;
	private Div JanelaFiltroParaListarAvaliacao;
	private ListModel listModel;
	private Label nomeTurma;
	private Label modalidade;
	private Label qtdAluno;
	private Label disciplina;
	private Label nivelEscolar;
	private Label professor;
	private Label avaliacao;
	private Textbox id;
	private Label data;
	private Label valorTotal;
	private Label peso;
	private Label periodo;
	private Label etapa;	
	private Rows rowNotas;
	private Label sala;
	private Label serie;
	private Label anoLetivo;
	private Label turno;
	private DataBinder binder;
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox disciplinaProfessorCombo;
	private Combobox periodoCombo;
	private Combobox etapaCombo;
	private Row RowSerie;
	private Row RowPeriodo;
	private Row RowEtapa;
	private Row RowNivel;
	private Row RowTurma;
	private Row RowDisciplinaProfessor;
	private Window indexResultado;
	
	Constraint c = null;
	
	private List<Row> rowss = new ArrayList<Row>();
	
	private List<Intbox> intbox = new ArrayList<Intbox>();
		
	Turma selected = null;
	Turma turmav = null;
	
	Avaliacao av = null;
	
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
		
	RegistroDeDisciplina selectedDisciplina = null;
	
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
	
	public Turma getSelected() {
		return selected;
	}
	
	public void setSelected(Turma selected) {
		this.selected = selected;
	}
	
	public RegistroDeDisciplina getSelectedDisciplina() {
		return selectedDisciplina;
	}
	
	public void setSelectedDisciplina(RegistroDeDisciplina selectedDisciplina) {
		this.selectedDisciplina = selectedDisciplina;
	}
	
	public void onClick$adicionarNotas(Event e) throws InterruptedException {
		
		int id;
		 for(Aluno a : Facade.getInstance().listarAlunoTurma(turmav.getId())){
			 for (Resultado rr : Facade.getInstance().listarResultado()){
				 if(rr.getAluno().getId() == a.getId()){
					 if(rr.getAvaliacao().getId() == av.getId()){
						 for (Intbox i: intbox) {
								id = Integer.parseInt(i.getId()); 
								 if(a.getId() == id){
									 Resultado res = Facade.getInstance().carregarResultado(rr.getId());
									 res.setNota((i.getValue()));
									 Facade.getInstance().atualizarResultado(res);
								 }
						 
					 }
				 }
			 
			 }
			 }
				
		 }

		Messagebox.show("Resultado Efetuado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		for (Intbox i: intbox) {
			i.setId(null);
			i.setVisible(false);
		}
		
		for (Row r: rowss) {
			r.setId(null);
			r.setVisible(false);
		}
		
		rowss.clear();
		rowss = new ArrayList<Row>();
		
		intbox.clear();
		intbox = new ArrayList<Intbox>();
		binder.loadComponent(indexResultado);
	} 
	
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
			
		anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
  	 	long idNivelEscolarComparar = 0;
  	 	if(Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId()).isEmpty() == true){
  	 		Messagebox.show("Não existem Níveis Escolares cadastrados para este ano! Favor cadastrá-los!",
  			        "Atenção!",
  			        Messagebox.OK,
  			        Messagebox.EXCLAMATION,
  			        new org.zkoss.zk.ui.event.EventListener() {
  						public void onEvent(Event arg1) throws Exception {
  						}
  					}
  			);
  	 	}else{
  	 		
  	 	nivelCombo.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId())) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	 		if(idNivelEscolarComparar != ne.getId()){
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivelCombo.appendChild(comboitem);
  	 		}
  	 		idNivelEscolarComparar = ne.getId();
	 	}
  	 	
  	 	nivelCombo.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	}	
	  	
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

		turmav = ((Turma) turmaCombo.getSelectedItem().getValue());
		disciplinaProfessorCombo.getChildren().clear();
  	 	for (RegistroDeDisciplina rd : Facade.getInstance().listarRegistroDeDisciplinaTurma(turmav.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(rd.getDisciplina().getNome() + " | "+ rd.getProfessor().getNome());
			comboitem.setValue(rd);
			disciplinaProfessorCombo.appendChild(comboitem);
	 	}
  	 	
		disciplinaProfessorCombo.setDisabled(false);
		binder.loadComponent(RowDisciplinaProfessor);
	}
	
	public void onSelect$disciplinaProfessorCombo(Event e) {
  	 	
		selectedDisciplina = ((RegistroDeDisciplina) disciplinaProfessorCombo.getSelectedItem().getValue());
  	 	periodoCombo.setDisabled(false);
  	 	periodoCombo.getChildren().clear();
		
		Comboitem comboitem0 = new Comboitem();
		comboitem0.setLabel("1º Período");
		comboitem0.setValue(1);
		periodoCombo.appendChild(comboitem0);
		
		Comboitem comboitem4 = new Comboitem();
		comboitem4.setLabel("2º Período");
		comboitem4.setValue(2);
		periodoCombo.appendChild(comboitem4);
		
  	 	binder.loadComponent(RowPeriodo); 	
  	
	}
	
	public void onSelect$periodoCombo(Event e) {
  	 	
  	 	etapaCombo.setDisabled(false);
  	 	etapaCombo.getChildren().clear();
		
		Comboitem comboitem = new Comboitem();
		comboitem.setLabel("1ª Etapa");
		comboitem.setValue(1);
		etapaCombo.appendChild(comboitem);
		
		Comboitem comboitem1 = new Comboitem();
		comboitem1.setLabel("2ª Etapa");
		comboitem1.setValue(2);
		etapaCombo.appendChild(comboitem1);

		Comboitem comboitem2 = new Comboitem();
		comboitem2.setLabel("3ª Etapa");
		comboitem2.setValue(3);
		etapaCombo.appendChild(comboitem2);
		
		Comboitem comboitem3 = new Comboitem();
		comboitem3.setLabel("4ª Etapa");
		comboitem3.setValue(4);
		etapaCombo.appendChild(comboitem3);
		
  	 	binder.loadComponent(RowEtapa); 	
  	
	}

	public void onClick$listarAvaliacaoFiltro(){
		if(nivelCombo.getSelectedIndex() == -1 || anoLetivoCombo.getSelectedIndex() == -1 || 
				serieCombo.getSelectedIndex() == -1 ||	turmaCombo.getSelectedIndex() == -1
				||	disciplinaProfessorCombo.getSelectedIndex() == -1 || periodoCombo.getSelectedIndex() == -1
				|| etapaCombo.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{
			List<Avaliacao> list = new ArrayList<Avaliacao>();
			for(Avaliacao ava: Facade.getInstance().listarAvaliacao()){
				if(ava.getRegistroDeDisciplina().getId() == selectedDisciplina.getId()){
					if(ava.getPeriodo().equals(periodoCombo.getValue())){
						if(ava.getEtapa().equals(etapaCombo.getValue())){
							list.add(ava);
						}
					}
				}
			}
			
			listModel = new ListModelList(list);
			ListagemAvaliacao.setModel(listModel);
			
			JanelaFiltroParaListarAvaliacao.setVisible(false);
			janelaAvaliacaoAluno.setVisible(false);
			janelaAvaliacao.setVisible(true);
		}
		
	}

	public void  onSelect$ListagemAvaliacao(){
						
		binder.loadComponent(janelaAvaliacaoAluno);
		binder.loadComponent(rowNotas);
		
		av = (Avaliacao) ListagemAvaliacao.getModel().getElementAt(ListagemAvaliacao.getSelectedIndex());
		
		disciplina.setValue(av.getRegistroDeDisciplina().getDisciplina().getNome());
		professor.setValue(av.getRegistroDeDisciplina().getProfessor().getNome());
		avaliacao.setValue(av.getDescricao());
		String dat = (SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM).format(av.getData()));
		data.setValue(dat);
		peso.setValue(String.valueOf(av.getPeso()));
		id.setValue(String.valueOf(av.getId()));
		valorTotal.setValue(String.valueOf(av.getValorTotal()));
		periodo.setValue(av.getPeriodo());
		etapa.setValue(av.getEtapa());		
		
		JanelaFiltroParaListarAvaliacao.setVisible(false);
		janelaAvaliacaoAluno.setVisible(true);
		janelaAvaliacao.setVisible(false);
		
		nomeTurma.setValue(turmav.getNome());
		turno.setValue(turmav.getTurno());
		modalidade.setValue(turmav.getModalidade());
		qtdAluno.setValue(String.valueOf(turmav.getQtdAluno()));
		anoLetivo.setValue(String.valueOf(turmav.getAnoLetivo().getAno()));
		sala.setValue(turmav.getSala().getDescricao());
		serie.setValue(turmav.getSerie().getDescricao());
		nivelEscolar.setValue(turmav.getSerie().getNivelEscolar().getNivel());
		
		Row rows = new Row();
		rows.setId(String.valueOf(av.getId()));
		rows.setAlign("center");
		new Label("Descrição - " + av.getDescricao()).setParent(rows);
		new Label("Disciplina - " + selectedDisciplina.getDisciplina().getNome() 
				+ " | Professor - " + selectedDisciplina.getProfessor().getNome()).setParent(rows);
		rows.setParent(rowNotas);
		
		rowss.add(rows);
		
		 for(Aluno a : Facade.getInstance().listarAlunoTurma(turmav.getId())){
				
				Listitem li = new Listitem();
									
				for(Matricula m1 : a.getMatricula()){
					if(turmav.getId() == m1.getTurma().getId()){
						
						new Listcell(m1.getNumero()).setParent(li);
						
						Row row = new Row();
					   
						new Label(m1.getNumero() + " | " + a.getNome()).setParent(row);
					    			
						Intbox t = new Intbox();
						
						t.setConstraint(c);
						
					    t.setId(String.valueOf(a.getId()));
					    
					    intbox.add(t);
					    
					    t.setConstraint("no empty, no zero, no negative");
					   
					    t.setParent(row);						    						    
					    row.setParent(rowNotas);
					    rowss.add(row);
					    
					}
				}
				
			    new Listcell(a.getNome()).setParent(li);
			    li.setParent(ListagemAluno);
				
			}		   
		 
		 binder.loadComponent(indexResultado);
		 binder.loadComponent(rowNotas);
	}
	
	public void onClick$voltarPaginaListaAvaliacao(Event e) {	

		for (Intbox i: intbox) {
			i.setId(null);
			i.setVisible(false);
		}
		
		for (Row r: rowss) {
			r.setId(null);
			r.setVisible(false);
		}
		
		rowss.clear();
		rowss = new ArrayList<Row>();
		
		intbox.clear();
		intbox = new ArrayList<Intbox>();
				
		ListagemAvaliacao.setSelectedItem(null);
		ListagemAluno.getItems().clear();
		
		janelaAvaliacaoAluno.setVisible(false);
		JanelaFiltroParaListarAvaliacao.setVisible(true);
		binder.loadComponent(indexResultado);
		
	}

}
