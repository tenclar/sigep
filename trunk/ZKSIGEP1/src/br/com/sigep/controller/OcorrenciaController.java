package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
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

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Ocorrencia;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class OcorrenciaController extends GenericForwardComposer{

	private Row RowSerie;
	private Row RowTurma;
	private Row RowAluno;
	private Row RowNivel;
	private Row RowAnoLetivo;
	private Combobox serie;
	private Combobox anoLetivo;
	private Combobox turma;
	private Combobox aluno;
	private Combobox nivel;
	private DataBinder binder;
	private Div cadastroOcorrencia;
	private Div listarOcorrencia;
	private Div pesquisarOcorrencia;
	private Listbox ListagemOcorrencia; //domain object summary list
	private ListModel listModel;
	private Button adicionar;
	private Button salvar;
	private Button cancelar;
	private Textbox descricao;
	private Textbox punicao;
	private Datebox data;
	private Textbox id;
	private Textbox ProcurarOcorrencia;
	private Row rowId;
		
	private static final long serialVersionUID = 1L;
	
	Constraint c = null;
	
	Ocorrencia o = new Ocorrencia();
	NivelEscolar ne = new NivelEscolar();
	Serie s = new Serie();
	Turma t = new Turma();
	AnoLetivo ano = new AnoLetivo();
	Aluno a = new Aluno();
	
	public Ocorrencia getO() {
		return o;
	}

	public void setO(Ocorrencia o) {
		this.o = o;
	}
	
	public NivelEscolar getNe() {
		return ne;
	}

	public void setNe(NivelEscolar ne) {
		this.ne = ne;
	}

	public Serie getS() {
		return s;
	}

	public void setS(Serie s) {
		this.s = s;
	}

	public Turma getT() {
		return t;
	}

	public void setT(Turma t) {
		this.t = t;
	}

	public AnoLetivo getAno() {
		return ano;
	}

	public void setAno(AnoLetivo ano) {
		this.ano = ano;
	}
	
	public void onClick$adicionar(Event e) throws InterruptedException {
		if(nivel.getSelectedIndex() == -1 || anoLetivo.getSelectedIndex() == -1 || serie.getSelectedIndex() == -1 ||
				turma.getSelectedIndex() == -1 || aluno.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{
		o.setData(data.getValue());
		o.setDescricao(descricao.getValue());
		o.setPunicao(punicao.getValue());
		o.setAluno((Aluno) aluno.getSelectedItem().getValue());
		Facade.getInstance().salvarOcorrencia(o);
		Messagebox.show("Ocorrência Cadastrada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		o = new Ocorrencia();
		cadastroOcorrencia.setVisible(false);
		}
	}
	
	public void onSelect$anoLetivo(Event e) throws InterruptedException {
		ano = (AnoLetivo) anoLetivo.getSelectedItem().getValue();
  	 	
  	 	nivel.getChildren().clear();
  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelEscolar()) {
  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel(ne.getNivel());
  	 			comboitem.setValue(ne);
  	 			nivel.appendChild(comboitem);
  	 	}
  	 	nivel.setDisabled(false);
  	 	binder.loadComponent(RowNivel); 
  	 	
		
	}
	
	public void onSelect$nivel(Event e) {
  	 	
		ne = ((NivelEscolar) nivel.getSelectedItem().getValue());
  	 	serie.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(se.getDescricao());
			comboitem.setValue(se);
			serie.appendChild(comboitem);
	 	}
  	 	
  	 	serie.setDisabled(false);
  	 	binder.loadComponent(RowSerie); 	
  	
	}
	
	public void onSelect$serie(Event e) {
		turma.setDisabled(false);
		s = ((Serie) serie.getSelectedItem().getValue());
		ano = ((AnoLetivo) anoLetivo.getSelectedItem().getValue());		
		turma.getChildren().clear();
	 	for (Turma t : Facade.getInstance().listarTurmaSerie(s.getId(), ano.getId())) {
			Comboitem comboitem = new Comboitem(t.getNome()+" | " + t.getTurno());
			comboitem.setValue(t);
			turma.appendChild(comboitem);
	 	}
	 	binder.loadComponent(RowTurma);
	}
		
	public void onSelect$turma(Event e) throws InterruptedException {
		t = ((Turma) turma.getSelectedItem().getValue());
		
		
		
  	 	if(Facade.getInstance().listarAlunoTurma(t.getId()).isEmpty() == true){
  	 		aluno.setValue("");
  	 		Messagebox.show("Não existem Alunos cadastrados para esta turma! Favor cadastrá-los!",
  			        "Atenção!",
  			        Messagebox.OK,
  			        Messagebox.EXCLAMATION,
  			        new org.zkoss.zk.ui.event.EventListener() {
  						public void onEvent(Event arg1) throws Exception {
  						}
  					}
  			);
  	 	}else{
  	 		//long idAluno = 0;
  	 		aluno.setDisabled(false);
  	 		aluno.getChildren().clear();
  	 		for (Aluno a : Facade.getInstance().listarAlunoTurma(t.getId())) {
	 				Comboitem comboitem = new Comboitem(a.getNome());
	 				comboitem.setValue(a);
	 				aluno.appendChild(comboitem);
  	 		}
  	 		//idAluno = a.getId();
  	 		binder.loadComponent(RowAluno);
	 	
  	 	}
	}
	
	public void onClick$resultadoOcorrencia() throws InterruptedException{
		if (ProcurarOcorrencia.getText() == "") {
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
			listModel = new ListModelList(Facade.getInstance().listarOcorrenciaFiltro((ProcurarOcorrencia.getText())));
			ListagemOcorrencia.setModel(listModel);
			listarOcorrencia.setVisible(true);
		}
		
	}
	
		
	public void onClick$EditarOcorrencia(Event e) throws InterruptedException {
		if(listarOcorrencia.isVisible() && ListagemOcorrencia.getSelectedIndex()!=-1){
			pesquisarOcorrencia.setVisible(false);
			listarOcorrencia.setVisible(false);
			RowAnoLetivo.setVisible(false);
			RowSerie.setVisible(false);
			RowNivel.setVisible(false);
			RowTurma.setVisible(false);
			adicionar.setVisible(false);
			RowAluno.setVisible(true);
			salvar.setVisible(true);
			cancelar.setVisible(true);			
			cadastroOcorrencia.setVisible(true);
			rowId.setVisible(true);
			o =(Ocorrencia) ListagemOcorrencia.getModel().getElementAt(ListagemOcorrencia.getSelectedIndex());	
			id.setText(String.valueOf(o.getId()));
			data.setValue(o.getData());
			punicao.setValue(o.getPunicao());			
			descricao.setValue(o.getDescricao());
			
			data.setConstraint("no empty");
			punicao.setConstraint("no empty");
			descricao.setConstraint("no empty");
			
			aluno.getChildren().clear();
	  	 	for (Aluno a : Facade.getInstance().listarAluno()) {
	  	 			Comboitem comboitem = new Comboitem(a.getNome());
					comboitem.setValue(a);
					aluno.appendChild(comboitem);
	  	 	}
	  	 	aluno.setValue(o.getAluno().getNome());
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
	
	public void onClick$ListarOcorrencia(){
		pesquisarOcorrencia.setVisible(false);
		cadastroOcorrencia.setVisible(false);
		listarOcorrencia.setVisible(true);
		listModel = new ListModelList(Facade.getInstance().listarOcorrencia());
		ListagemOcorrencia.setModel(listModel);
	}
	
	public void onClick$PesquisarOcorrencia(){
		ProcurarOcorrencia.setText("");
		cadastroOcorrencia.setVisible(false);
		pesquisarOcorrencia.setVisible(true);
	}
		
	
	public void onClick$CadastrarOcorrencia(){
		pesquisarOcorrencia.setVisible(false);
		listarOcorrencia.setVisible(false);
		cadastroOcorrencia.setVisible(true);
		adicionar.setVisible(true);
		rowId.setVisible(false);
		salvar.setVisible(false);
		cancelar.setVisible(false);
		RowAnoLetivo.setVisible(true);
		RowSerie.setVisible(true);
		RowNivel.setVisible(true);
		RowTurma.setVisible(true);
		
		data.setConstraint(c);
		punicao.setConstraint(c);
		descricao.setConstraint(c);
		
		descricao.setText("");
		punicao.setText("");
		data.setText("");
		nivel.setText("");
		serie.setText("");
		anoLetivo.setText("");
		turma.setText("");
		aluno.setText("");
		
		data.setConstraint("no empty");
		punicao.setConstraint("no empty");
		descricao.setConstraint("no empty");
		
		serie.setDisabled(true);
		nivel.setDisabled(true);
		turma.setDisabled(true);
		aluno.setDisabled(true);
		
		anoLetivo.getChildren().clear();
  	 	for (br.com.sigep.bean.AnoLetivo al : br.com.sigep.facade.Facade.getInstance().listarAnoLetivo()) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel("Ano - " + al.getAno());
			comboitem.setValue(al);
			anoLetivo.appendChild(comboitem);
	 	}
		
	}
	
	public void onClick$salvar(Event e) throws InterruptedException {		
		Ocorrencia oo = Facade.getInstance().carregarOcorrencia(((Ocorrencia) ListagemOcorrencia.getModel().getElementAt(ListagemOcorrencia.getSelectedIndex())).getId());
		oo.setAluno((Aluno) aluno.getSelectedItem().getValue());
		oo.setDescricao(descricao.getValue());
		oo.setData(data.getValue());
		oo.setPunicao(punicao.getValue());
		Facade.getInstance().atualizarOcorrencia(oo);
	 	o = new Ocorrencia();
	 	pesquisarOcorrencia.setVisible(false);
		listarOcorrencia.setVisible(false);
		cadastroOcorrencia.setVisible(false);
		listModel = new ListModelList(Facade.getInstance().listarOcorrencia());
		ListagemOcorrencia.setModel(listModel);
		Messagebox.show("Ocorrência Alterada com Sucesso!",
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
		pesquisarOcorrencia.setVisible(false);
		listarOcorrencia.setVisible(false);
		cadastroOcorrencia.setVisible(false);
    }
	
	public void onClick$DeletarOcorrencia(Event event) throws InterruptedException {  
		if(listarOcorrencia.isVisible() && ListagemOcorrencia.getSelectedIndex()!=-1){
		try {
			Messagebox.show("Você tem certeza que deseja Deletar a Ocorrência selecionado?",
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
		Facade.getInstance().removerOcorrencia((Ocorrencia) ListagemOcorrencia.getModel().getElementAt(ListagemOcorrencia.getSelectedIndex()));
		listModel = new ListModelList(Facade.getInstance().listarOcorrencia());
		ListagemOcorrencia.setModel(listModel);
	}
	
}
