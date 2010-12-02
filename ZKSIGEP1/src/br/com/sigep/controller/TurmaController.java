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
import org.zkoss.zul.Row;

import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Sala;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class TurmaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;

	private Listbox ListagemTurma;
	private int descricao;
	private ListModel listModel;
	private Textbox nome;
	private Textbox ProcurarTurma;
	private Textbox modalidade;
	private Intbox qtdAluno;
	private Div cadastroTurma;
	private Div listarTurma;
	private Div pesquisarTurma;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox id;
	private Combobox sala;
	private Combobox serie;
	private Combobox anoLetivo;
	private Combobox turno;
	private Row rowId;
	
	Constraint c = null;
	
	Turma t = new Turma();
	
	RegistroDeDisciplina reg = new RegistroDeDisciplina();
	
	Disciplina disciplinas = null;
	
	public Turma getT() {
		return t;
	}

	public void setT(Turma t) {
		this.t = t;
	}

	public RegistroDeDisciplina getReg() {
		return reg;
	}

	public void setReg(RegistroDeDisciplina reg) {
		this.reg = reg;
	}

	public int getDescricao() {
		return descricao;
	}

	public void setDescricao(int descricao) {
		this.descricao = descricao;
	}
	
	public Disciplina getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplina disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		if(sala.getSelectedIndex() == -1 || turno.getSelectedIndex() == -1 
				|| anoLetivo.getSelectedIndex()==-1 || serie.getSelectedIndex()==-1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{		
		t.setModalidade(modalidade.getValue());
		t.setNome(nome.getValue());
		t.setQtdAluno(qtdAluno.getValue());
		t.setAnoLetivo((AnoLetivo) anoLetivo.getSelectedItem().getValue());
		t.setTurno(turno.getValue());
		t.setSala((Sala) sala.getSelectedItem().getValue());
		t.setSerie((Serie) serie.getSelectedItem().getValue());
		Facade.getInstance().salvarTurma(t);
		
		//Salvar RegistroDeDisciplina
		for(Disciplina di : Facade.getInstance().listarDisciplinaSerie(t.getSerie().getId())){
			reg.setTurma(t);
			reg.setDisciplina(di);
			reg.setProfessor(null);
			Facade.getInstance().salvarRegistroDeDisciplina(reg);
			
			reg = new RegistroDeDisciplina();
		}
		
		Messagebox.show("Turma Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);		
		t = new Turma();
		cadastroTurma.setVisible(false);
		}
	}
	
	public void onClick$resultadoTurma() throws InterruptedException{
		if (ProcurarTurma.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarTurmaFiltro(ProcurarTurma.getText()));
			ListagemTurma.setModel(listModel);
		}
		
	}
	
	public void onClick$EditarTurma(Event e) throws InterruptedException {
		if(listarTurma.isVisible() && ListagemTurma.getSelectedIndex()!=-1){
			pesquisarTurma.setVisible(false);
			listarTurma.setVisible(false);
			adicionar.setVisible(false);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroTurma.setVisible(true);
			rowId.setVisible(true);
			t =(Turma) ListagemTurma.getModel().getElementAt(ListagemTurma.getSelectedIndex());	
			id.setText(String.valueOf(t.getId()));
			nome.setValue(t.getNome());
			modalidade.setValue(t.getModalidade());
			qtdAluno.setValue(t.getQtdAluno());
			
			nome.setConstraint("no empty");
			modalidade.setConstraint("no empty");
			qtdAluno.setConstraint("no empty, no zero, no negative");
						
			turno.setValue(t.getTurno());
			
			anoLetivo.getChildren().clear();
	  	 	for (AnoLetivo al : Facade.getInstance().listarAnoLetivo()) {
	  	 			Comboitem comboitem = new Comboitem();
					comboitem.setLabel("Ano - " + al.getAno());
					comboitem.setValue(al);
					anoLetivo.appendChild(comboitem);
		 	}
	  	 	anoLetivo.setValue("Ano - " + t.getAnoLetivo().getAno());
	  	 	
            sala.getChildren().clear();
	  	 	for (Sala sa : Facade.getInstance().listarSala()) {
	  	 		Comboitem comboitem = new Comboitem(sa.getDescricao());
				comboitem.setValue(sa);
				sala.appendChild(comboitem);
		 	}
	  	 	sala.setValue(t.getSala().getDescricao());
			         
            serie.getChildren().clear();
	  	 	for (Serie se : Facade.getInstance().listarSerie()) {
				Comboitem comboitem = new Comboitem(se.getDescricao() + " - " + se.getNivelEscolar().getNivel());
				comboitem.setValue(se);
				serie.appendChild(comboitem);
		 	}
	  	 	serie.setValue(t.getSerie().getDescricao()+ " - " + t.getSerie().getNivelEscolar().getNivel());
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
	
	public void onClick$ListarTurma(){
		pesquisarTurma.setVisible(false);
		cadastroTurma.setVisible(false);
		listarTurma.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarTurma());
		ListagemTurma.setModel(listModel);
	}
	
	public void onClick$PesquisarTurma(){
		ProcurarTurma.setText("");
		cadastroTurma.setVisible(false);
		pesquisarTurma.setVisible(true);
	}
		
	
	public void onClick$CadastrarTurma(){
		pesquisarTurma.setVisible(false);
		listarTurma.setVisible(false);
		cadastroTurma.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		
		nome.setConstraint(c);
		modalidade.setConstraint(c);
		qtdAluno.setConstraint(c);
		
		nome.setText("");
		modalidade.setText("");
		qtdAluno.setText("");
		
		nome.setConstraint("no empty");
		modalidade.setConstraint("no empty");
		qtdAluno.setConstraint("no empty, no zero, no negative");
		
		turno.setText("");
		anoLetivo.setText("");
		sala.setText("");
		serie.setText("");
		
		anoLetivo.setDisabled(true);
		sala.setDisabled(true);
		serie.setDisabled(true);
		
		      
	}
	
	public void onSelect$turno(Event e){
	anoLetivo.getChildren().clear();
	 	for (AnoLetivo al : Facade.getInstance().listarAnoLetivo()) {
	 			Comboitem comboitem = new Comboitem();
			comboitem.setLabel("Ano - " + al.getAno());
			comboitem.setValue(al);
			anoLetivo.appendChild(comboitem);
	 	}
	 	anoLetivo.setDisabled(false);
	}
	
	public void onSelect$anoLetivo(Event e){
		AnoLetivo ano = (AnoLetivo) anoLetivo.getSelectedItem().getValue();
		sala.getChildren().clear();
  	 	for (Sala sa : Facade.getInstance().listarSala()) {
  	 		Comboitem comboitem = new Comboitem(sa.getDescricao());
			comboitem.setValue(sa);
			sala.appendChild(comboitem);
	 	}
  	 	sala.setDisabled(false);
	}
	
	public void onSelect$sala(Event e){
		
		serie.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerie()) {
  	 		Comboitem comboitem = new Comboitem(se.getDescricao() + " - " + se.getNivelEscolar().getNivel());
			comboitem.setValue(se);
			serie.appendChild(comboitem);
	 	}
  	 	serie.setDisabled(false);
	}
	
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Turma tt = Facade.getInstance().carregarTurma(((Turma) ListagemTurma.getModel().getElementAt(ListagemTurma.getSelectedIndex())).getId());
		tt.setNome(nome.getValue());
		tt.setModalidade(modalidade.getValue());
		tt.setQtdAluno(qtdAluno.getValue());
		tt.setAnoLetivo((AnoLetivo) anoLetivo.getSelectedItem().getValue());
		tt.setTurno(turno.getValue());
		tt.setSala((Sala) sala.getSelectedItem().getValue());
		tt.setSerie((Serie) serie.getSelectedItem().getValue());
	 	Facade.getInstance().atualizarTurma(tt);
	 	t = new Turma();
	 	pesquisarTurma.setVisible(false);
		listarTurma.setVisible(false);
		cadastroTurma.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarTurma());
		ListagemTurma.setModel(listModel);
		Messagebox.show("Turma Alterada com Sucesso!",
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
		pesquisarTurma.setVisible(false);
		listarTurma.setVisible(false);
		cadastroTurma.setVisible(false);
    }
	
	public void onClick$DeletarTurma(Event event) throws InterruptedException {  
		if(listarTurma.isVisible() && ListagemTurma.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Turma selecionada?",
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
		Facade.getInstance().removerTurma((Turma) ListagemTurma.getModel().getElementAt(ListagemTurma.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarTurma());
		ListagemTurma.setModel(listModel);
	}
	
}
