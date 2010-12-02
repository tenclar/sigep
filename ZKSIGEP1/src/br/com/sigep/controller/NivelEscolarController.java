package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import org.zkoss.zul.Button;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.facade.Facade;


public class NivelEscolarController extends GenericForwardComposer{
	
	private Div cadastroNivelEscolar;
	private Div listarNivelEscolar;
	private Div pesquisarNivelEscolar;
	private Listbox ListagemNivelEscolar; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox nivel;
	private Intbox etapas;
	private Textbox id;
	private Textbox ProcurarNivelEscolar;
	private Row rowId;
	
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	NivelEscolar ne = new NivelEscolar();
		
	public NivelEscolar getNe() {
		return ne;
	}

	public void setNe(NivelEscolar ne) {
		this.ne = ne;
	}

	public void onClick$adicionar(Event e) throws InterruptedException {
		ne.setNivel(nivel.getValue());
		ne.setEtapas(etapas.getValue());		
		Facade.getInstance().salvarNivelEscolar(ne);		
		Messagebox.show("Nível Escolar Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		ne = new NivelEscolar();
		cadastroNivelEscolar.setVisible(false);
	}
	
	public void onClick$EditarNivelEscolar() throws InterruptedException {
		if(listarNivelEscolar.isVisible() && ListagemNivelEscolar.getSelectedIndex()!=-1){
			pesquisarNivelEscolar.setVisible(false);
			listarNivelEscolar.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroNivelEscolar.setVisible(true);
			rowId.setVisible(true);
			ne =(NivelEscolar) ListagemNivelEscolar.getModel().getElementAt(ListagemNivelEscolar.getSelectedIndex());	
			id.setText(String.valueOf(ne.getId()));
			etapas.setValue(ne.getEtapas());
			nivel.setValue(ne.getNivel());	
		
			etapas.setConstraint("no empty, no zero, no negative");
			nivel.setConstraint("no empty");
		}
		else{
			Messagebox.show("Selecione um Item!",
		        "Item Não Selecionado!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg0) throws Exception {
						//refreshModel();						
					}
				}
			);
			
		}
	}
	
	
	public void onClick$ListarNivelEscolar(){
		pesquisarNivelEscolar.setVisible(false);
		cadastroNivelEscolar.setVisible(false);
		listarNivelEscolar.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarNivelEscolar());
		ListagemNivelEscolar.setModel(listModel);
	}
	
	public void onClick$PesquisarNivelEscolar(){
		ProcurarNivelEscolar.setText("");
		cadastroNivelEscolar.setVisible(false);
		pesquisarNivelEscolar.setVisible(true);
	}
		
	
	public void onClick$CadastrarNivelEscolar(){
		pesquisarNivelEscolar.setVisible(false);
		listarNivelEscolar.setVisible(false);
		cadastroNivelEscolar.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		etapas.setConstraint(c);
		nivel.setConstraint(c);
		
		etapas.setText("");
		nivel.setText("");
		
		etapas.setConstraint("no empty, no zero, no negative");
		nivel.setConstraint("no empty");
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		NivelEscolar ne = Facade.getInstance().carregarNivelEscolar(((NivelEscolar) ListagemNivelEscolar.getModel().getElementAt(ListagemNivelEscolar.getSelectedIndex())).getId());
		ne.setEtapas(etapas.getValue());
		ne.setNivel(nivel.getValue());
		Facade.getInstance().atualizarNivelEscolar(ne);
		pesquisarNivelEscolar.setVisible(false);
		listarNivelEscolar.setVisible(false);
		cadastroNivelEscolar.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarNivelEscolar());
		ListagemNivelEscolar.setModel(listModel);
		Messagebox.show("Nível Escolar Alterado com Sucesso!",
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
		pesquisarNivelEscolar.setVisible(false);
		listarNivelEscolar.setVisible(false);
		cadastroNivelEscolar.setVisible(false);
	}
			
	public void onClick$resultadoNivelEscolar() throws InterruptedException{
		if (ProcurarNivelEscolar.getText() == "") {
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
			listarNivelEscolar.setVisible(true);
			listModel = new ListModelList(Facade.getInstance().listarNivelFiltro(ProcurarNivelEscolar.getText()));
			ListagemNivelEscolar.setModel(listModel);
			}
			
	}
				
	public void onClick$DeletarNivelEscolar(Event event) throws InterruptedException {  
		if(listarNivelEscolar.isVisible() && ListagemNivelEscolar.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar o Nível Escolar selecionado?",
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
							//refreshModel();			
						}
					}
				);
				
			}
	 } 
		
	public void doYes() {
		Facade.getInstance().removerNivelEscolar((NivelEscolar) ListagemNivelEscolar.getModel().getElementAt(ListagemNivelEscolar.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarNivelEscolar());
		ListagemNivelEscolar.setModel(listModel);
	}

}
