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

import br.com.sigep.bean.Bloco;
import br.com.sigep.bean.Sala;
import br.com.sigep.facade.Facade;

public class SalaController extends GenericForwardComposer{

	private Div cadastroSala;
	private Div listarSala;
	private Div pesquisarSala;
	private Listbox ListagemSala; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox descricao;
	private Intbox numero;
	private Textbox id;
	private Combobox bloco;
	private Textbox ProcurarSala;
	private Row rowId;
	private Constraint c = null;
	
	private static final long serialVersionUID = 1L;
	
	Sala s = new Sala();
	
	public Sala getS() {
		return s;
	}

	public void setS(Sala s) {
		this.s = s;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		
		if(bloco.getSelectedIndex() == -1){
			alert("Selecione um Bloco!");
		}else{
			s.setNumero(numero.getValue());
			s.setDescricao(descricao.getValue());
			s.setBloco((Bloco) bloco.getSelectedItem().getValue());
			
			Facade.getInstance().salvarSala(s);		
			Messagebox.show("Sala Cadastrada com Sucesso!",
					"Sucesso!",
					Messagebox.OK,
					Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					}
			);
			s = new Sala();
			cadastroSala.setVisible(false);
		}
	}
	
	public void onClick$resultadoSala() throws InterruptedException{
		if (ProcurarSala.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarSalaFiltro((ProcurarSala.getText())));
			ListagemSala.setModel(listModel);
			listarSala.setVisible(true);
		}
		
	}
	
		
	public void onClick$EditarSala(Event e) throws InterruptedException {
		if(listarSala.isVisible() && ListagemSala.getSelectedIndex()!=-1){
			pesquisarSala.setVisible(false);
			listarSala.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroSala.setVisible(true);
			rowId.setVisible(true);
			s =(Sala) ListagemSala.getModel().getElementAt(ListagemSala.getSelectedIndex());	
			id.setText(String.valueOf(s.getId()));
			numero.setValue(s.getNumero());
			descricao.setValue(s.getDescricao());
			
			numero.setConstraint("no empty, no zero, no negative");
			descricao.setConstraint("no empty");
						
			bloco.getChildren().clear();
			for (Bloco b : Facade.getInstance().listarBloco()) {
	  	 		Comboitem comboitem = new Comboitem(b.getNome());
	  	 		comboitem.setValue(b);
	  	 		bloco.appendChild(comboitem);
	  	 	}
			bloco.setValue(s.getBloco().getNome());
			
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
	
	public void onClick$ListarSala(){
		pesquisarSala.setVisible(false);
		cadastroSala.setVisible(false);
		listarSala.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarSala());
		ListagemSala.setModel(listModel);
	}
	
	public void onClick$PesquisarSala(){
		ProcurarSala.setText("");
		cadastroSala.setVisible(false);
		pesquisarSala.setVisible(true);
	}
		
	public void onClick$CadastrarSala(){
		pesquisarSala.setVisible(false);
		listarSala.setVisible(false);
		cadastroSala.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		descricao.setConstraint(c);
		numero.setConstraint(c);
		
		descricao.setText("");
		numero.setText("");
		bloco.setText("");
		
		descricao.setConstraint("no empty");
		numero.setConstraint("no empty, no zero, no negative");
		
		
		bloco.getChildren().clear();
  	 	for (Bloco b : Facade.getInstance().listarBloco()) {
			Comboitem comboitem = new Comboitem(b.getNome());
			comboitem.setValue(b);
			bloco.appendChild(comboitem);
	 	}
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {	
			Sala ss = Facade.getInstance().carregarSala(((Sala) ListagemSala.getModel().getElementAt(ListagemSala.getSelectedIndex())).getId());
			ss.setDescricao(descricao.getValue());
			ss.setNumero(numero.getValue());
			ss.setBloco((Bloco) bloco.getSelectedItem().getValue());
			Facade.getInstance().atualizarSala(ss);
			s = new Sala();
			pesquisarSala.setVisible(false);
			listarSala.setVisible(false);
			cadastroSala.setVisible(false);
			listModel = new ListModelList(Facade.getInstance().listarSala());
			ListagemSala.setModel(listModel);
			Messagebox.show("Sala Alterada com Sucesso!",
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
		pesquisarSala.setVisible(false);
		listarSala.setVisible(false);
		cadastroSala.setVisible(false);
    }
	
	public void onClick$DeletarSala(Event event) throws InterruptedException {  
		if(listarSala.isVisible() && ListagemSala.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Sala selecionada?",
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
		Facade.getInstance().removerSala((Sala) ListagemSala.getModel().getElementAt(ListagemSala.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarSala());
		ListagemSala.setModel(listModel);
	}
	
}
