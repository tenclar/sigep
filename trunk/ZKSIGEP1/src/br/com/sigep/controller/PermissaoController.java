package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.Permissao;
import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.facade.Facade;

public class PermissaoController extends GenericForwardComposer{
	
	private Div cadastroPermissao;
	private Div listarPermissao;
	private Div pesquisarPermissao;
	private Listbox ListagemPermissao; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Intbox nivel;
	private Textbox id;
	private Combobox tipoDeUsuario;
	private Intbox ProcurarPermissao;
	private Row rowId;
	
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	Permissao p = new Permissao();
		
	public Permissao getP() {
		return p;
	}

	public void setP(Permissao p) {
		this.p = p;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		if(tipoDeUsuario.getSelectedIndex() == -1){
			alert("Selecione um Tipo de Usuário!");
		}
		else{
		p.setNivel(nivel.getValue());
		p.setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());		
		Facade.getInstance().salvarPermissao(p);		
		Messagebox.show("Permissão Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		p = new Permissao();
		cadastroPermissao.setVisible(false);
		}
	}
		
	public void onClick$EditarPermissao() throws InterruptedException {
		if(listarPermissao.isVisible() && ListagemPermissao.getSelectedIndex()!=-1){
			pesquisarPermissao.setVisible(false);
			listarPermissao.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroPermissao.setVisible(true);
			rowId.setVisible(true);
			p =(Permissao) ListagemPermissao.getModel().getElementAt(ListagemPermissao.getSelectedIndex());	
			id.setText(String.valueOf(p.getId()));
			nivel.setValue(p.getNivel());
			
			nivel.setConstraint("no empty, no zero, no negative");
			
			tipoDeUsuario.getChildren().clear();
	  	 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
	  	 			Comboitem comboitem = new Comboitem(tp.getDescricao());
					comboitem.setValue(tp);
					tipoDeUsuario.appendChild(comboitem);
	  	 	}
	  	 	tipoDeUsuario.setValue(p.getTipoDeUsuario().getDescricao());
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
	
	
	public void onClick$ListarPermissao(){
		pesquisarPermissao.setVisible(false);
		cadastroPermissao.setVisible(false);
		listarPermissao.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarPermissao());
		ListagemPermissao.setModel(listModel);
	}
	
	public void onClick$PesquisarPermissao(){
		ProcurarPermissao.setText("");
		cadastroPermissao.setVisible(false);
		pesquisarPermissao.setVisible(true);
	}
		
	
	public void onClick$CadastrarPermissao(){
		pesquisarPermissao.setVisible(false);
		listarPermissao.setVisible(false);
		cadastroPermissao.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		nivel.setConstraint(c);		
		nivel.setText("");		
		nivel.setConstraint("no empty");
		
		tipoDeUsuario.setValue("");	
		tipoDeUsuario.getChildren().clear();
  	 	for (TipoDeUsuario tp : Facade.getInstance().listarTipoDeUsuario()) {
  	 			Comboitem comboitem = new Comboitem(tp.getDescricao());
				comboitem.setValue(tp);
				tipoDeUsuario.appendChild(comboitem);
  	 		
  	 	}
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Permissao p = Facade.getInstance().carregarPermissao(((Permissao) ListagemPermissao.getModel().getElementAt(ListagemPermissao.getSelectedIndex())).getId());
		p.setNivel(nivel.getValue());
		p.setTipoDeUsuario((TipoDeUsuario) tipoDeUsuario.getSelectedItem().getValue());
		Facade.getInstance().atualizarPermissao(p);
		pesquisarPermissao.setVisible(false);
		listarPermissao.setVisible(false);
		cadastroPermissao.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarPermissao());
		ListagemPermissao.setModel(listModel);
		Messagebox.show("Permissão Alterada com Sucesso!",
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
		pesquisarPermissao.setVisible(false);
		listarPermissao.setVisible(false);
		cadastroPermissao.setVisible(false);
	}
			
	public void onClick$resultadoPermissao() throws InterruptedException{
		if (ProcurarPermissao.getText() == "") {
			Messagebox.show("Digite um Nível!",
			        "Informação!",
			        Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg0) throws Exception {
								}
						}
					);
		} else {
			listarPermissao.setVisible(true);
			listModel = new ListModelList(Facade.getInstance().listarPermissaoFiltro(ProcurarPermissao.getValue()));
			ListagemPermissao.setModel(listModel);
			}
			
	}
				
	public void onClick$DeletarPermissao(Event event) throws InterruptedException {  
		if(listarPermissao.isVisible() && ListagemPermissao.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar a Permissão selecionada?",
				        "Informação!",
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
		Facade.getInstance().removerPermissao((Permissao) ListagemPermissao.getModel().getElementAt(ListagemPermissao.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarPermissao());
		ListagemPermissao.setModel(listModel);
	}

}
