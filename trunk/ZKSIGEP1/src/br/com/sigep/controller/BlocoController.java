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

import br.com.sigep.bean.Bloco;
import br.com.sigep.facade.Facade;

public class BlocoController extends GenericForwardComposer{

	private Div cadastroBloco;
	private Div listarBloco;
	private Div pesquisarBloco;
	private Listbox ListagemBloco; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox nome;
	private Intbox qtdSala;
	private Textbox id;
	private Textbox ProcurarBloco;
	private Row rowId;
	private Constraint c = null;
	
	private static final long serialVersionUID = 1L;
	
	Bloco b = new Bloco();
	
	public Bloco getB() {
		return b;
	}

	public void setB(Bloco b) {
		this.b = b;
	}

	public void onClick$adicionar(Event e) throws InterruptedException {
		b.setNome(nome.getValue());
		b.setQtdSala(qtdSala.getValue());		
		Facade.getInstance().salvarBloco(b);		
		Messagebox.show("Bloco Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		b = new Bloco();
		cadastroBloco.setVisible(false);
	}
	
	public void onClick$EditarBloco() throws InterruptedException {
		if(listarBloco.isVisible() && ListagemBloco.getSelectedIndex()!=-1){
			pesquisarBloco.setVisible(false);
			listarBloco.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroBloco.setVisible(true);
			rowId.setVisible(true);
			b =(Bloco) ListagemBloco.getModel().getElementAt(ListagemBloco.getSelectedIndex());	
			id.setText(String.valueOf(b.getId()));
			qtdSala.setValue(b.getQtdSala());
			nome.setValue(b.getNome());	
			
			nome.setConstraint("no empty");
			qtdSala.setConstraint("no empty, no zero, no negative");
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
	
	
	public void onClick$ListarBloco(){
		pesquisarBloco.setVisible(false);
		cadastroBloco.setVisible(false);
		listarBloco.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarBloco());
		ListagemBloco.setModel(listModel);
	}
	
	public void onClick$PesquisarBloco(){
		ProcurarBloco.setText("");
		cadastroBloco.setVisible(false);
		pesquisarBloco.setVisible(true);
	}
		
	
	public void onClick$CadastrarBloco(){
		pesquisarBloco.setVisible(false);
		listarBloco.setVisible(false);
		cadastroBloco.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
				
		nome.setConstraint(c);
		qtdSala.setConstraint(c);
		
		qtdSala.setText("");
		nome.setText("");
		
		nome.setConstraint("no empty");
		qtdSala.setConstraint("no empty, no zero, no negative");
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Bloco b = Facade.getInstance().carregarBloco(((Bloco) ListagemBloco.getModel().getElementAt(ListagemBloco.getSelectedIndex())).getId());
		b.setQtdSala(qtdSala.getValue());
		b.setNome(nome.getValue());
		Facade.getInstance().atualizarBloco(b);
		pesquisarBloco.setVisible(false);
		listarBloco.setVisible(false);
		cadastroBloco.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarBloco());
		ListagemBloco.setModel(listModel);
		Messagebox.show("Bloco Alterado com Sucesso!",
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
		pesquisarBloco.setVisible(false);
		listarBloco.setVisible(false);
		cadastroBloco.setVisible(false);
	}
			
	public void onClick$resultadoBloco() throws InterruptedException{
		if (ProcurarBloco.getText() == "") {
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
			listarBloco.setVisible(true);
			listModel = new ListModelList(Facade.getInstance().listarBlocoFiltro(ProcurarBloco.getText()));
			ListagemBloco.setModel(listModel);
			}
			
	}
				
	public void onClick$DeletarBloco(Event event) throws InterruptedException {  
		if(listarBloco.isVisible() && ListagemBloco.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar o Bloco selecionado?",
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
		Facade.getInstance().removerBloco((Bloco) ListagemBloco.getModel().getElementAt(ListagemBloco.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarBloco());
		ListagemBloco.setModel(listModel);
	}

}
