package br.com.sigep.controller;


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
import br.com.sigep.bean.Frequencia;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class FrequenciaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private Listbox ListagemDisciplina;
	private Listbox ListagemAluno;
	private Div janelaDisciplina;
	private Div janelaDisciplinaAluno;
	private Div JanelaFiltroParaListarDisciplina;
	private ListModel listModel;
	private Label nomeTurma;
	private Label modalidade;
	private Label qtdAluno;
	private Label disciplina;
	private Label nivelEscolar;
	private Label professor;
	private Textbox id;
	private Label cargaHoraria;
	private Rows rowFrequencias;
	private Label sala;
	private Label serie;
	private Label anoLetivo;
	private Label turno;
	private DataBinder binder;
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Row RowSerie;
	private Row RowNivel;
	private Row RowTurma;
	private Window indexFrequencia;
	
	Constraint c = null;
	
	private List<Row> rowss = new ArrayList<Row>();
	
	private List<Intbox> intbox = new ArrayList<Intbox>();
		
	Turma selected = null;
	Turma turmav = null;
	
	RegistroDeDisciplina di = null;
	
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	
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

	public void onClick$adicionarFrequencias(Event e) throws InterruptedException {
		
		 int id;
		 for(Aluno a : Facade.getInstance().listarAlunoTurma(turmav.getId())){
			 		 for (Intbox i: intbox) {
								id = Integer.parseInt(i.getId()); 
								 if(a.getId() == id){
									 Frequencia fr = new Frequencia();
									 fr.setQtdAula(i.getValue());
									 fr.setRegistroDeDisciplina(di);
									 fr.setAluno(a);
									 fr.setPeriodo("");
									 Facade.getInstance().salvarFrequencia(fr);									 
								 }						 
					 }
				 }

		Messagebox.show("Frequências adicionadas com Sucesso!",
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
		binder.loadComponent(indexFrequencia);
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
	
	public void onClick$listarDisciplinaFiltro(){
			if(nivelCombo.getSelectedIndex() == -1 || anoLetivoCombo.getSelectedIndex() == -1 || 
					serieCombo.getSelectedIndex() == -1 ||	turmaCombo.getSelectedIndex() == -1){
				alert("Existe(m) Campo(s) não selecionado(s)!");
			}
			else{
			turmav = ((Turma)turmaCombo.getSelectedItem().getValue());
			List<RegistroDeDisciplina> list = new ArrayList<RegistroDeDisciplina>();
			for(RegistroDeDisciplina rd: Facade.getInstance().listarRegistroDeDisciplinaTurma(turmav.getId())){
							list.add(rd);
					}
			
			listModel = new ListModelList(list);
			ListagemDisciplina.setModel(listModel);
			
			JanelaFiltroParaListarDisciplina.setVisible(false);
			janelaDisciplinaAluno.setVisible(false);
			janelaDisciplina.setVisible(true);
			}
	}

	public void  onSelect$ListagemDisciplina(){
				
		di = (RegistroDeDisciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex());
		
		disciplina.setValue(di.getDisciplina().getNome());
		professor.setValue(di.getProfessor().getNome());
		id.setValue(String.valueOf(di.getDisciplina().getId()));
		cargaHoraria.setValue(String.valueOf(di.getDisciplina().getCargaHoraria()));
		
		JanelaFiltroParaListarDisciplina.setVisible(false);
		janelaDisciplinaAluno.setVisible(true);
		janelaDisciplina.setVisible(false);
		
		nomeTurma.setValue(turmav.getNome());
		turno.setValue(turmav.getTurno());
		modalidade.setValue(turmav.getModalidade());
		qtdAluno.setValue(String.valueOf(turmav.getQtdAluno()));
		anoLetivo.setValue(String.valueOf(turmav.getAnoLetivo().getAno()));
		sala.setValue(turmav.getSala().getDescricao());
		serie.setValue(turmav.getSerie().getDescricao());
		nivelEscolar.setValue(turmav.getSerie().getNivelEscolar().getNivel());
			
		Row rows = new Row();
		rows.setAlign("center");
		new Label(di.getDisciplina().getNome() + " | " + di.getProfessor().getNome()).setParent(rows);
		new Label("Carga Horária - " + di.getDisciplina().getCargaHoraria()).setParent(rows);
		rows.setParent(rowFrequencias);
		
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
					   
					    t.setParent(row);
					    t.setConstraint("no empty, no zero, no negative");
					    
					    row.setParent(rowFrequencias);
					    rowss.add(row);
					}
				}
				
			    new Listcell(a.getNome()).setParent(li);
			    li.setParent(ListagemAluno);
				
			}		   
		
		 binder.loadComponent(indexFrequencia);
		 binder.loadComponent(rowFrequencias);
	}
	
	public void onClick$voltarPaginaListaFrequencia(Event e) {	

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
				
		ListagemDisciplina.setSelectedItem(null);
		ListagemAluno.getItems().clear();
		
		janelaDisciplinaAluno.setVisible(false);
		JanelaFiltroParaListarDisciplina.setVisible(true);
		binder.loadComponent(indexFrequencia);
		
	}

}
