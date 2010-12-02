package br.com.sigep.controller;


import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Window;

import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Professor;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class RegistroDeDisciplinaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private Listbox ListagemTurma;
	private Listbox ListagemAluno;
	private Listbox ListagemDisciplina;
	private Div janelaDisciplinaProfessor;
	private Div JanelaDisciplina;
	private Div JanelaFiltroParaListarTurma;
	private ListModel listModel;
	private ListModel listModel1;
	private Textbox nomeTurma;
	private Textbox modalidade;
	private Intbox qtdAluno;
	private Textbox disciplina;
	private Textbox nivelEscolar;
	private Combobox professor;
	private Groupbox VerRegistroDisciplinaProfessor;
	private Textbox sala;
	private Textbox serie;
	private Textbox anoLetivo;
	private Textbox turno;
	private DataBinder binder;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox anoLetivoCombo;
	private Row RowSerie;
	private Row RowNivel;
	private Window indexRegistroDeDisciplina;
	private Constraint c = null;
	
	Turma turmav = null;
	
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

	public RegistroDeDisciplina getSelectedDisciplina() {
		return selectedDisciplina;
	}
	
	public void setSelectedDisciplina(RegistroDeDisciplina selectedDisciplina) {
		this.selectedDisciplina = selectedDisciplina;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		if(professor.getSelectedIndex() == -1){
			alert("Selecione um Professor!");
		}
		else{
		
		RegistroDeDisciplina regAtualizar = Facade.getInstance().carregarRegistroDeDisciplina(((RegistroDeDisciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex())).getId());
		regAtualizar.setProfessor((Professor) professor.getSelectedItem().getValue());
		
		Facade.getInstance().atualizarRegistroDeDisciplina(regAtualizar);
		
		listModel1 = new ListModelList(Facade.getInstance().listarDisciplinaTurma(turmav.getId()));
		ListagemDisciplina.setModel(listModel1);
		
		VerRegistroDisciplinaProfessor.setVisible(false);

		Messagebox.show("Registro de Disciplina Efetuado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);		
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
  	 	
  	 	nivelCombo.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	}
	  	
	}
	
	public void onSelect$nivelCombo(Event e) {
  	 	
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

	public void onClick$listarTurmaFiltro(){
		
		if (anoLetivoCombo.getSelectedIndex() == -1 
			|| nivelCombo.getSelectedIndex() == -1
			|| serieCombo.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		} else {

			listModel = new ListModelList(Facade.getInstance().listarTurmaSerie(s.getId(), anoletivoObj.getId()));
			ListagemTurma.setModel(listModel);	

			JanelaFiltroParaListarTurma.setVisible(false);
			JanelaDisciplina.setVisible(true);

		}
	}

	//Registro de Professores
	public void  onSelect$ListagemTurma(){
			JanelaFiltroParaListarTurma.setVisible(false);
			JanelaDisciplina.setVisible(false);
			janelaDisciplinaProfessor.setVisible(true);
			VerRegistroDisciplinaProfessor.setVisible(false);
			turmav =(Turma) ListagemTurma.getModel().getElementAt(ListagemTurma.getSelectedIndex());
			nomeTurma.setText(turmav.getNome());
			turno.setText(turmav.getTurno());
			modalidade.setText(turmav.getModalidade());
			qtdAluno.setValue(turmav.getQtdAluno());
			anoLetivo.setText(String.valueOf(turmav.getAnoLetivo().getAno()));
			sala.setText(turmav.getSala().getDescricao());
			serie.setText(turmav.getSerie().getDescricao());
			nivelEscolar.setText(turmav.getSerie().getNivelEscolar().getNivel());
			
			listModel = new ListModelList(Facade.getInstance().listarRegistroDeDisciplinaTurma(turmav.getId()));
			ListagemDisciplina.setModel(listModel);
			
		   for(Aluno a : Facade.getInstance().listarAlunoTurma(turmav.getId())){
				
				Listitem li = new Listitem();
				
				for(Matricula m1 : a.getMatricula()){
					if(turmav.getId() == m1.getTurma().getId()){
						new Listcell(m1.getNumero()).setParent(li);
					}
				}
				
			    new Listcell(a.getNome()).setParent(li);
			    li.setParent(ListagemAluno);
				
			}
			
		    
	}
	
	public void  onSelect$ListagemDisciplina(){
		
		VerRegistroDisciplinaProfessor.setVisible(true);
		RegistroDeDisciplina rd = (RegistroDeDisciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex());
		disciplina.setValue(rd.getDisciplina().getNome());
		professor.getChildren().clear();
		
		if(rd.getProfessor() == null){
			professor.setValue(null);
		}else{
			professor.setValue(rd.getProfessor().getNome());
		}
		
  	 	for (br.com.sigep.bean.Professor p : br.com.sigep.facade.Facade.getInstance().listarProfessor()) {
			Comboitem comboitem = new Comboitem(p.getNome());
			comboitem.setValue(p);
			professor.appendChild(comboitem);
	 	}
	}
	
	public void onClick$voltarPaginaListaTurma(Event e) {	

		ListagemTurma.setSelectedItem(null);
		ListagemDisciplina.setSelectedItem(null);
		ListagemAluno.getItems().clear();
		
		janelaDisciplinaProfessor.setVisible(false);
		JanelaDisciplina.setVisible(false);
		binder.loadComponent(indexRegistroDeDisciplina);
		JanelaFiltroParaListarTurma.setVisible(true);
		
	}

}
