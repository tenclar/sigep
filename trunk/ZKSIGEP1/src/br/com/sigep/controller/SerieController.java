package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;
import br.com.sigep.facade.Facade;

public class SerieController extends GenericForwardComposer{

	private Div cadastroSerie;
	private Div listarSerie;
	private Div pesquisarSerie;
	private Listbox ListagemSerie; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox descricao;
	private Textbox id;
	private Combobox nivelEscolar;
	private Textbox ProcurarSerie;
	private Row rowId;
	
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	Serie se = new Serie();
		
	public Serie getSe() {
		return se;
	}

	public void setSe(Serie se) {
		this.se = se;
	}

	public void onClick$adicionar(Event e) throws InterruptedException {
		if(nivelEscolar.getSelectedIndex() == -1){
			alert("Selecione um Nível Escolar!");
		}
		else{		
		se.setDescricao(descricao.getValue());
		se.setNivelEscolar((NivelEscolar) nivelEscolar.getSelectedItem().getValue());
		Facade.getInstance().salvarSerie(se);
		Messagebox.show("Série Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		cadastroSerie.setVisible(false);
		se = new Serie();
		}
	}
	
	public void onClick$resultadoSerie() throws InterruptedException{
		if (ProcurarSerie.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarSerieFiltro((ProcurarSerie.getText())));
			ListagemSerie.setModel(listModel);
			listarSerie.setVisible(true);
		}
		
	}

	public void onClick$EditarSerie(Event e) throws InterruptedException {
		if(listarSerie.isVisible() && ListagemSerie.getSelectedIndex()!=-1){
			pesquisarSerie.setVisible(false);
			listarSerie.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroSerie.setVisible(true);
			rowId.setVisible(true);
			se =(Serie) ListagemSerie.getModel().getElementAt(ListagemSerie.getSelectedIndex());	
			id.setText(String.valueOf(se.getId()));
			descricao.setValue(se.getDescricao());
			
			descricao.setConstraint("no empty");
			
			nivelEscolar.getChildren().clear();
	  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
	  	 			Comboitem comboitem = new Comboitem(ne.getNivel());
					comboitem.setValue(ne);
					nivelEscolar.appendChild(comboitem);
	  	 	}
	  	 	nivelEscolar.setValue(se.getNivelEscolar().getNivel());
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
	
	public void onClick$ListarSerie(){
		pesquisarSerie.setVisible(false);
		cadastroSerie.setVisible(false);
		listarSerie.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarSerie());
		ListagemSerie.setModel(listModel);
	}
	
	public void onClick$PesquisarSerie(){
		ProcurarSerie.setText("");
		cadastroSerie.setVisible(false);
		pesquisarSerie.setVisible(true);
	}
		
	
	public void onClick$CadastrarSerie(){
		pesquisarSerie.setVisible(false);
		listarSerie.setVisible(false);
		cadastroSerie.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		descricao.setConstraint(c);
		descricao.setText("");
		descricao.setConstraint("no empty");
		nivelEscolar.setText("");
		nivelEscolar.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
  	 			Comboitem comboitem = new Comboitem(ne.getNivel());
				comboitem.setValue(ne);
				nivelEscolar.appendChild(comboitem);
  	 		}
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Serie s = Facade.getInstance().carregarSerie(((Serie) ListagemSerie.getModel().getElementAt(ListagemSerie.getSelectedIndex())).getId());
		s.setNivelEscolar(se.getNivelEscolar());
		s.setDescricao(descricao.getValue());
		s.setNivelEscolar((NivelEscolar) nivelEscolar.getSelectedItem().getValue());
		Facade.getInstance().atualizarSerie(s);
	 	se = new Serie();
	 	pesquisarSerie.setVisible(false);
		listarSerie.setVisible(false);
		cadastroSerie.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarSerie());
		ListagemSerie.setModel(listModel);
		Messagebox.show("Série Alterada com Sucesso!",
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
		pesquisarSerie.setVisible(false);
		listarSerie.setVisible(false);
		cadastroSerie.setVisible(false);
		
    }
	
	public void onClick$DeletarSerie(Event event) throws InterruptedException {  
		if(listarSerie.isVisible() && ListagemSerie.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Série selecionada?",
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
		Facade.getInstance().removerSerie((Serie) ListagemSerie.getModel().getElementAt(ListagemSerie.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarSerie());
		ListagemSerie.setModel(listModel);	
	}
	
}
