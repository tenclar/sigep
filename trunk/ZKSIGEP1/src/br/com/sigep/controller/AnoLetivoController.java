package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.facade.Facade;

public class AnoLetivoController extends GenericForwardComposer{

	private Div cadastroAnoLetivo;
	private Div listarAnoLetivo;
	private Div pesquisarAnoLetivo;
	private Listbox ListagemAnoLetivo; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Intbox ano;
	private Textbox id;
	private Datebox dataInicio;
	private Datebox dataFim;
	private Intbox ProcurarAnoLetivo;
	private Row rowId;
	
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	AnoLetivo al = new AnoLetivo();
		
	public AnoLetivo getAl() {
		return al;
	}

	public void setAl(AnoLetivo al) {
		this.al = al;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		al.setAno(ano.getValue());
		al.setDataInicio(dataInicio.getValue());
		al.setDataFim(dataFim.getValue());
		Facade.getInstance().salvarAnoLetivo(al);		
		Messagebox.show("Ano Letivo Cadastrado com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		al = new AnoLetivo();
		cadastroAnoLetivo.setVisible(false);
	}
	
	public void onClick$EditarAnoLetivo() throws InterruptedException {
		if(listarAnoLetivo.isVisible() && ListagemAnoLetivo.getSelectedIndex()!=-1){
			pesquisarAnoLetivo.setVisible(false);
			listarAnoLetivo.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroAnoLetivo.setVisible(true);
			rowId.setVisible(true);
			al =(AnoLetivo) ListagemAnoLetivo.getModel().getElementAt(ListagemAnoLetivo.getSelectedIndex());	
			id.setText(String.valueOf(al.getId()));
			
			ano.setValue(al.getAno());
			dataInicio.setValue(al.getDataInicio());	
			dataFim.setValue(al.getDataFim());
			
			ano.setConstraint("no empty, no zero, no negative");
			dataInicio.setConstraint("no empty");
			dataFim.setConstraint("no empty");
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
	
	
	public void onClick$ListarAnoLetivo(){
		pesquisarAnoLetivo.setVisible(false);
		cadastroAnoLetivo.setVisible(false);
		listarAnoLetivo.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarAnoLetivo());
		ListagemAnoLetivo.setModel(listModel);
	}
	
	public void onClick$PesquisarAnoLetivo(){
		ProcurarAnoLetivo.setText("");
		cadastroAnoLetivo.setVisible(false);
		pesquisarAnoLetivo.setVisible(true);
	}
		
	
	public void onClick$CadastrarAnoLetivo(){
		pesquisarAnoLetivo.setVisible(false);
		listarAnoLetivo.setVisible(false);
		cadastroAnoLetivo.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		ano.setConstraint(c);
		dataInicio.setConstraint(c);
		dataFim.setConstraint(c);
		
		ano.setText("");
		dataInicio.setText("");		
		dataFim.setText("");
		
		ano.setConstraint("no empty, no zero, no negative");
		dataInicio.setConstraint("no empty");
		dataFim.setConstraint("no empty");
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		AnoLetivo al = Facade.getInstance().carregarAnoLetivo(((AnoLetivo) ListagemAnoLetivo.getModel().getElementAt(ListagemAnoLetivo.getSelectedIndex())).getId());
		al.setAno(ano.getValue());
		al.setDataInicio(dataInicio.getValue());
		al.setDataFim(dataFim.getValue());
		Facade.getInstance().atualizarAnoLetivo(al);
		pesquisarAnoLetivo.setVisible(false);
		listarAnoLetivo.setVisible(false);
		cadastroAnoLetivo.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarAnoLetivo());
		ListagemAnoLetivo.setModel(listModel);
		Messagebox.show("Ano Letivo Alterado com Sucesso!",
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
		pesquisarAnoLetivo.setVisible(false);
		listarAnoLetivo.setVisible(false);
		cadastroAnoLetivo.setVisible(false);
	}
			
	public void onClick$resultadoAnoLetivo() throws InterruptedException{
		if (ProcurarAnoLetivo.getText() == "") {
			Messagebox.show("Digite um Ano!",
			        "Ano Não Digitado!",
			        Messagebox.OK,
			        Messagebox.EXCLAMATION,
			        new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg0) throws Exception {
								}
						}
					);
		} else {
			listarAnoLetivo.setVisible(true);
			listModel = new ListModelList(Facade.getInstance().listarAnoLetivoFiltro(ProcurarAnoLetivo.getValue()));
			ListagemAnoLetivo.setModel(listModel);
			}
			
	}
				
	public void onClick$DeletarAnoLetivo(Event event) throws InterruptedException {  
		if(listarAnoLetivo.isVisible() && ListagemAnoLetivo.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar o Ano Letivo selecionado?",
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
		Facade.getInstance().removerAnoLetivo((AnoLetivo) ListagemAnoLetivo.getModel().getElementAt(ListagemAnoLetivo.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarAnoLetivo());
		ListagemAnoLetivo.setModel(listModel);
	}
	
}
