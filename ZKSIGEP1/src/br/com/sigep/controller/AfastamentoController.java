package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Afastamento;
import br.com.sigep.bean.Professor;
import br.com.sigep.facade.Facade;

public class AfastamentoController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	
	private Div cadastroAfastamento;
	private Div listarAfastamento;
	private Div pesquisarAfastamento;
	private Listbox ListagemAfastamento; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox descricao;
	private Datebox dataSaida;
	private Datebox dataVolta;
	private Textbox id;
	private Combobox professor;
	private Textbox ProcurarAfastamento;
	private Row rowId;
	private Constraint c = null;
	
	Afastamento af = new Afastamento();
	
	public Afastamento getAf() {
		return af;
	}

	public void setAf(Afastamento af) {
		this.af = af;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		
		if(professor.getSelectedIndex() == -1){
			alert("Selecione um Professor!");
		}else{
			af.setProfessor((Professor) professor.getSelectedItem().getValue());
			af.setProfessor(Facade.getInstance().carregarProfessor(af.getProfessor().getId()));
			af.getProfessor().setStatus(false);
			Facade.getInstance().atualizarProfessor(af.getProfessor());
			
			af.setDescricao(descricao.getValue());
			af.setDataSaida(dataSaida.getValue());
			af.setDataVolta(dataVolta.getValue());
				
			Facade.getInstance().salvarAfastamento(af);
		
			Messagebox.show("Afastamento Cadastrado com Sucesso!",
					"Sucesso!",
					Messagebox.OK,
					Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					}
			);
			
			af = new Afastamento();
			cadastroAfastamento.setVisible(false);
		}
	}
	
	public void onClick$resultadoAfastamento() throws InterruptedException{
		if (ProcurarAfastamento.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarAfastamentoFiltro((ProcurarAfastamento.getText())));
			ListagemAfastamento.setModel(listModel);
			listarAfastamento.setVisible(true);
		}
		
	}
	
		
	public void onClick$EditarAfastamento(Event e) throws InterruptedException {
		if(listarAfastamento.isVisible() && ListagemAfastamento.getSelectedIndex()!=-1){
			pesquisarAfastamento.setVisible(false);
			listarAfastamento.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroAfastamento.setVisible(true);
			rowId.setVisible(true);
			af =(Afastamento) ListagemAfastamento.getModel().getElementAt(ListagemAfastamento.getSelectedIndex());	
			id.setText(String.valueOf(af.getId()));
			dataSaida.setValue(af.getDataSaida());
			dataVolta.setValue(af.getDataVolta());
			descricao.setValue(af.getDescricao());
			
			descricao.setConstraint("no empty");
			dataSaida.setConstraint("no empty");
			dataVolta.setConstraint("no empty");
			
			professor.getChildren().clear();
	  	 	for (Professor p : Facade.getInstance().listarProfessor()) {
	  	 			Comboitem comboitem = new Comboitem(p.getNome());
					comboitem.setValue(p);
					professor.appendChild(comboitem);
	  	 	}
	  	 	professor.setValue(af.getProfessor().getNome());
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
	
	public void onClick$ListarAfastamento(){
		pesquisarAfastamento.setVisible(false);
		cadastroAfastamento.setVisible(false);
		listarAfastamento.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarAfastamento());
		ListagemAfastamento.setModel(listModel);
	}
	
	public void onClick$PesquisarAfastamento(){
		ProcurarAfastamento.setText("");
		cadastroAfastamento.setVisible(false);
		pesquisarAfastamento.setVisible(true);
	}
		
	
	public void onClick$CadastrarAfastamento(){
		pesquisarAfastamento.setVisible(false);
		listarAfastamento.setVisible(false);
		cadastroAfastamento.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		descricao.setConstraint(c);
		dataSaida.setConstraint(c);
		dataVolta.setConstraint(c);
		
		descricao.setText("");
		dataSaida.setText("");
		dataVolta.setText("");
		professor.setText("");
		
		descricao.setConstraint("no empty");
		dataSaida.setConstraint("no empty");
		dataVolta.setConstraint("no empty");
				
		professor.getChildren().clear();
  	 	for (Professor p : Facade.getInstance().listarProfessor()) {
			Comboitem comboitem = new Comboitem(p.getNome());
			comboitem.setValue(p);
			professor.appendChild(comboitem);
	 	}
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Afastamento aa = Facade.getInstance().carregarAfastamento(((Afastamento) ListagemAfastamento.getModel().getElementAt(ListagemAfastamento.getSelectedIndex())).getId());
		aa.setProfessor((Professor) professor.getSelectedItem().getValue());
		aa.setDescricao(descricao.getValue());
		aa.setDataSaida(dataSaida.getValue());
		aa.setDataVolta(dataVolta.getValue());
		Facade.getInstance().atualizarAfastamento(aa);
	 	af = new Afastamento();
	 	pesquisarAfastamento.setVisible(false);
		listarAfastamento.setVisible(false);
		cadastroAfastamento.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarAfastamento());
		ListagemAfastamento.setModel(listModel);
		Messagebox.show("Afastamento Alterado com Sucesso!",
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
		pesquisarAfastamento.setVisible(false);
		listarAfastamento.setVisible(false);
		cadastroAfastamento.setVisible(false);
    }
	
	public void onClick$DeletarAfastamento(Event event) throws InterruptedException {  
		if(listarAfastamento.isVisible() && ListagemAfastamento.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar o Afastamento selecionado?",
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
		Facade.getInstance().removerAfastamento((Afastamento) ListagemAfastamento.getModel().getElementAt(ListagemAfastamento.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarAfastamento());
		ListagemAfastamento.setModel(listModel);
	}
	
}
