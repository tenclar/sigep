package br.com.sigep.controller;

import org.zkoss.zul.Constraint;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.Serie;
import br.com.sigep.facade.Facade;

public class DisciplinaController extends GenericForwardComposer{

	private Div cadastroDisciplina;
	private Div listarDisciplina;
	private Div pesquisarDisciplina;
	private Listbox ListagemDisciplina; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox nome;
	private Intbox cargaHoraria;
	private Textbox id;
	private Combobox serie;
	private Textbox ProcurarDisciplina;
	private Row rowId;
	private Constraint c = null;
	
	private static final long serialVersionUID = 1L;

	Disciplina d = new Disciplina();
		
	public Disciplina getD() {
		return d;
	}

	public void setD(Disciplina d) {
		this.d = d;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		
		if(serie.getSelectedIndex() == -1){
			alert("Selecione uma Série!");
		}else{
			d.setCargaHoraria(cargaHoraria.getValue());
			d.setNome(nome.getValue());
			d.setSerie((Serie) serie.getSelectedItem().getValue());
			Facade.getInstance().salvarDisciplina(d);
			Messagebox.show("Disciplina Cadastrada com Sucesso!",
					"Sucesso!",
					Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					}
			);
			d = new Disciplina();
			cadastroDisciplina.setVisible(false);
		}
	}
	
	public void onClick$resultadoDisciplina() throws InterruptedException{
		if (ProcurarDisciplina.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarDisciplinaFiltro((ProcurarDisciplina.getText())));
			ListagemDisciplina.setModel(listModel);
			listarDisciplina.setVisible(true);
		}
		
	}
	
	public void onClick$EditarDisciplina(Event e) throws InterruptedException {
		if(listarDisciplina.isVisible() && ListagemDisciplina.getSelectedIndex()!=-1){
			pesquisarDisciplina.setVisible(false);
			listarDisciplina.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);
			cadastroDisciplina.setVisible(true);
			rowId.setVisible(true);
			d =(Disciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex());	
			id.setText(String.valueOf(d.getId()));
			nome.setValue(d.getNome());
			cargaHoraria.setValue(d.getCargaHoraria());
			
			nome.setConstraint("no empty");
			cargaHoraria.setConstraint("no empty, no zero, no negative");
			
			serie.getChildren().clear();
	  	 	for (Serie se : Facade.getInstance().listarSerie()) {
	  	 			Comboitem comboitem = new Comboitem(se.getDescricao() + " - " + se.getNivelEscolar().getNivel());
	  	 			comboitem.setValue(se);
					serie.appendChild(comboitem);
	  	  	 	}
	  	 	serie.setValue(d.getSerie().getDescricao()+ " - " + d.getSerie().getNivelEscolar().getNivel());
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
	
	public void onClick$ListarDisciplina(){
		pesquisarDisciplina.setVisible(false);
		cadastroDisciplina.setVisible(false);
		listarDisciplina.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarDisciplina());
		ListagemDisciplina.setModel(listModel);
	}
	
	public void onClick$PesquisarDisciplina(){
		ProcurarDisciplina.setText("");
		cadastroDisciplina.setVisible(false);
		pesquisarDisciplina.setVisible(true);
	}
		
	
	public void onClick$CadastrarDisciplina(){
		pesquisarDisciplina.setVisible(false);
		listarDisciplina.setVisible(false);
		cadastroDisciplina.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		nome.setConstraint(c);
		cargaHoraria.setConstraint(c);
		
		nome.setText("");
		cargaHoraria.setText("");
		serie.setText("");
		
		nome.setConstraint("no empty");
		cargaHoraria.setConstraint("no empty, no zero, no negative");
		
		serie.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerie()) {
			Comboitem comboitem = new Comboitem(se.getDescricao());
			comboitem.setLabel(se.getDescricao() + " - " + se.getNivelEscolar().getNivel());
			comboitem.setValue(se);
			serie.appendChild(comboitem);
	 	}
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Disciplina dd = Facade.getInstance().carregarDisciplina(((Disciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex())).getId());
		dd.setNome(nome.getValue());
		dd.setSerie((Serie) serie.getSelectedItem().getValue());
		dd.setCargaHoraria(cargaHoraria.getValue());
	 	Facade.getInstance().atualizarDisciplina(dd);
	 	d = new Disciplina();
	 	pesquisarDisciplina.setVisible(false);
		listarDisciplina.setVisible(false);
		cadastroDisciplina.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarDisciplina());
		ListagemDisciplina.setModel(listModel);
		Messagebox.show("Disciplina Alterada com Sucesso!",
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
		pesquisarDisciplina.setVisible(false);
		listarDisciplina.setVisible(false);
		cadastroDisciplina.setVisible(false);
    }
	
	public void onClick$DeletarDisciplina(Event event) throws InterruptedException {  
		if(listarDisciplina.isVisible() && ListagemDisciplina.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Disciplina selecionada?",
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
		Facade.getInstance().removerDisciplina((Disciplina) ListagemDisciplina.getModel().getElementAt(ListagemDisciplina.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarDisciplina());
		ListagemDisciplina.setModel(listModel);
	}
	
}
