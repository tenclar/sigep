package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import org.zkoss.zul.Button;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.facade.Facade;

public class TipoDeUsuarioController extends GenericForwardComposer{
	
	private Div cadastroTipoDeUsuario;
	private Div listarTipoDeUsuario;
	private Div pesquisarTipoDeUsuario;
	private Listbox ListagemTipoDeUsuario; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox descricao;
	private Textbox id;
	private Textbox ProcurarTipoDeUsuario;
	private Row rowId;
	
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	TipoDeUsuario tp = new TipoDeUsuario();
		
	public TipoDeUsuario getTp() {
		return tp;
	}

	public void setTp(TipoDeUsuario tp) {
		this.tp = tp;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		tp.setDescricao(descricao.getValue());		
		Facade.getInstance().salvarTipoDeUsuario(tp);		
		Messagebox.show("Tipo de Usuário Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		tp = new TipoDeUsuario();
		cadastroTipoDeUsuario.setVisible(false);
	}
	
	public void onClick$EditarTipoDeUsuario() throws InterruptedException {
		if(listarTipoDeUsuario.isVisible() && ListagemTipoDeUsuario.getSelectedIndex()!=-1){
			pesquisarTipoDeUsuario.setVisible(false);
			listarTipoDeUsuario.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroTipoDeUsuario.setVisible(true);
			rowId.setVisible(true);
			tp =(TipoDeUsuario) ListagemTipoDeUsuario.getModel().getElementAt(ListagemTipoDeUsuario.getSelectedIndex());	
			id.setText(String.valueOf(tp.getId()));
			descricao.setValue(tp.getDescricao());
			descricao.setConstraint("no empty");
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
	
	
	public void onClick$ListarTipoDeUsuario(){
		pesquisarTipoDeUsuario.setVisible(false);
		cadastroTipoDeUsuario.setVisible(false);
		listarTipoDeUsuario.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarTipoDeUsuario());
		ListagemTipoDeUsuario.setModel(listModel);
	}
	
	public void onClick$PesquisarTipoDeUsuario(){
		ProcurarTipoDeUsuario.setText("");
		cadastroTipoDeUsuario.setVisible(false);
		pesquisarTipoDeUsuario.setVisible(true);
	}
		
	
	public void onClick$CadastrarTipoDeUsuario(){
		pesquisarTipoDeUsuario.setVisible(false);
		listarTipoDeUsuario.setVisible(false);
		cadastroTipoDeUsuario.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		descricao.setConstraint(c);
		
		descricao.setText("");
		
		descricao.setConstraint("no empty");
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		TipoDeUsuario tp = Facade.getInstance().carregarTipoDeUsuario(((TipoDeUsuario) ListagemTipoDeUsuario.getModel().getElementAt(ListagemTipoDeUsuario.getSelectedIndex())).getId());
		tp.setDescricao(descricao.getValue());
		Facade.getInstance().atualizarTipoDeUsuario(tp);
		pesquisarTipoDeUsuario.setVisible(false);
		listarTipoDeUsuario.setVisible(false);
		cadastroTipoDeUsuario.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarTipoDeUsuario());
		ListagemTipoDeUsuario.setModel(listModel);
		Messagebox.show("Tipo De Usuário Alterado com Sucesso!",
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
		pesquisarTipoDeUsuario.setVisible(false);
		listarTipoDeUsuario.setVisible(false);
		cadastroTipoDeUsuario.setVisible(false);
	}
			
	public void onClick$resultadoTipoDeUsuario() throws InterruptedException{
		if (ProcurarTipoDeUsuario.getText() == "") {
			Messagebox.show("Digite uma Descrição!",
			        "Nome Não Digitado!",
			        Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg0) throws Exception {
								}
						}
					);
		} else {
			listarTipoDeUsuario.setVisible(true);
			listModel = new ListModelList(Facade.getInstance().listarTipoDeUsuarioFiltro(ProcurarTipoDeUsuario.getText()));
			ListagemTipoDeUsuario.setModel(listModel);
			}
			
	}
				
	public void onClick$DeletarTipoDeUsuario(Event event) throws InterruptedException {  
		if(listarTipoDeUsuario.isVisible() && ListagemTipoDeUsuario.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar o Tipo de Usuário selecionado?",
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
		Facade.getInstance().removerTipoDeUsuario((TipoDeUsuario) ListagemTipoDeUsuario.getModel().getElementAt(ListagemTipoDeUsuario.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarTipoDeUsuario());
		ListagemTipoDeUsuario.setModel(listModel);
	}

}