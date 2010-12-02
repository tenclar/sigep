package br.com.sigep.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Intbox;

import org.zkoss.zul.Button;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;


import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class RenovacaoDeMatriculaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	
	private ListModel listModel;
	private ListModel listModel1;
	private Listcell listcell;
	
	private Listbox ListagemDadosDoAluno;
	private Textbox rgDoAluno;
	private Groupbox groupboxDadosDoAluno;
	private Groupbox groupboxRenovarMatricula;
	private Groupbox groupboxProcurarAluno;
	private Button renovarMatricula;
	private Button salvarButton;
	private Button cancelarButton;
	
	private Listbox ListagemDadosDoAluno2;
	private Textbox rgDoAluno2;
	private Groupbox groupboxDadosDoAluno2;

	private DataBinder binder;
	private Div JanelaRenovarMatricula;
	private Div JanelaProcurarMatricula;
	
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Combobox turnoCombo;
	
	private Row RowTurma;
	private Row RowSerie;
	private Row RowTurno;
	private Row RowNivel;

	private Textbox matricula;
	private Intbox codigoMec;
	private Intbox cre;
	
	private long i;
	
	Constraint c = null;
	
	Turma turmav = null;
	
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	Matricula m = new Matricula();
	Matricula matriculaAnterior = null;
	Aluno alunoEncontrado = null;

	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}
	
	public Matricula getMatriculaAnterior() {
		return matriculaAnterior;
	}

	public void setMatriculaAnterior(Matricula matriculaAnterior) {
		this.matriculaAnterior = matriculaAnterior;
	}

	public Aluno getAlunoEncontrado() {
		return alunoEncontrado;
	}

	public void setAlunoEncontrado(Aluno alunoEncontrado) {
		this.alunoEncontrado = alunoEncontrado;
	}

	public Matricula getM() {
		return m;
	}

	public void setM(Matricula m) {
		this.m = m;
	}

	public Serie getS() {
		return s;
	}

	public void setS(Serie s) {
		this.s = s;
	}

	public NivelEscolar getNe1() {
		return ne1;
	}

	public void setNe1(NivelEscolar ne1) {
		this.ne1 = ne1;
	}

	public AnoLetivo getAnoletivoObj() {
		return anoletivoObj;
	}

	public void setAnoletivoObj(AnoLetivo anoletivoObj) {
		this.anoletivoObj = anoletivoObj;
	}
	
	public void onClick$RenovarMatricula(){
		
		salvarButton.setVisible(false);
		cancelarButton.setVisible(false);
		
		ListagemDadosDoAluno.getItems().clear();
		rgDoAluno.setText("");
		binder.loadComponent(anoLetivoCombo);
		binder.loadComponent(nivelCombo);
		binder.loadComponent(serieCombo);
		turnoCombo.setValue("");
		binder.loadComponent(turmaCombo);
		
		anoLetivoCombo.setDisabled(false);
		nivelCombo.setDisabled(true);
		serieCombo.setDisabled(true);
		turnoCombo.setDisabled(true);
		turmaCombo.setDisabled(true);
		
		matricula.setConstraint(c);
		codigoMec.setConstraint(c);
		cre.setConstraint(c);
		
		matricula.setText("");
		codigoMec.setText("");
		cre.setText("");
		
		matricula.setConstraint("no empty");
		codigoMec.setConstraint("no empty, no zero, no negative");
		cre.setConstraint("no empty, no zero, no negative");
		
		JanelaProcurarMatricula.setVisible(false);
		groupboxDadosDoAluno.setVisible(false);
		groupboxRenovarMatricula.setVisible(false);
		groupboxProcurarAluno.setVisible(true);
	  	
	  	JanelaRenovarMatricula.setVisible(true);
	}
	
	public void onClick$ListarMatricula(){
		JanelaRenovarMatricula.setVisible(false);
		rgDoAluno2.setText("");
		JanelaProcurarMatricula.setVisible(true);
		groupboxDadosDoAluno2.setVisible(false);
		
	}
	
	
	public void  onClick$procurarDadosDoAluno(Event e) throws InterruptedException{
		
		ListagemDadosDoAluno.getItems().clear();
				
		groupboxDadosDoAluno.setVisible(false);
		groupboxRenovarMatricula.setVisible(false);
		
		alunoEncontrado = Facade.getInstance().procurarAlunoPorRg(rgDoAluno.getValue());
		
		if(alunoEncontrado != null){		
		
		Listitem li = new Listitem();
				
		String idDoAluno = String.valueOf(alunoEncontrado.getId());
		
	    new Listcell(idDoAluno).setParent(li);
	    new Listcell(alunoEncontrado.getNome()).setParent(li);
	    //Recebe a última matrícula do aluno
	    System.out.println("ATENÇÃO: " + alunoEncontrado.getNome() + " -- " + alunoEncontrado.getId());
	    for(Matricula m1 : Facade.getInstance().listarMatriculaAluno(alunoEncontrado.getId())){	
	    	setMatriculaAnterior(m1);
		}
	    
	    System.out.println("ATENÇÃO: " + getMatriculaAnterior().getNumero() + " -- " + getMatriculaAnterior().getTurma().getNome());
	    
	    String ultimoAnoLetivo = String.valueOf(getMatriculaAnterior().getTurma().getAnoLetivo().getAno());
	    new Listcell(ultimoAnoLetivo).setParent(li);
	    new Listcell(getMatriculaAnterior().getTurma().getSerie().getNivelEscolar().getNivel()).setParent(li);
	    new Listcell(getMatriculaAnterior().getTurma().getSerie().getDescricao()).setParent(li);
	    new Listcell(getMatriculaAnterior().getTurma().getTurno()).setParent(li);
	    new Listcell(getMatriculaAnterior().getTurma().getNome()).setParent(li);
	    li.setParent(ListagemDadosDoAluno);
	    
	    groupboxDadosDoAluno.setVisible(true);

	  	anoLetivoCombo.getChildren().clear();
  	 	for (AnoLetivo ano : Facade.getInstance().listarAnoLetivo()) {
  	 		//Somente exibe no combobox os anos que forem posteriores ao ano da última matrícula
  	 		if(ano.getAno() > getMatriculaAnterior().getTurma().getAnoLetivo().getAno()){
  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel("Ano - " + ano.getAno());
  	 			comboitem.setValue(ano);
  	 			anoLetivoCombo.appendChild(comboitem);
  	 		}
	 	}		
  	 	
	    groupboxRenovarMatricula.setVisible(true);
	    
		}else{
			Messagebox.show("Não existe Aluno com este RG!",
  			        "Atenção!",
  			        Messagebox.OK,
  			        Messagebox.EXCLAMATION,
  			        new org.zkoss.zk.ui.event.EventListener() {
  						public void onEvent(Event arg1) throws Exception {
  						}
  					}
  			);
			
		}
	}
	
	public void  onClick$procurarDadosDoAluno2(Event e) throws InterruptedException{

		alunoEncontrado = Facade.getInstance().procurarAlunoPorRg(rgDoAluno2.getValue());
	
		if(alunoEncontrado != null){
		
		groupboxDadosDoAluno2.setVisible(true);
		listcell.setLabel(alunoEncontrado.getNome());
	    listModel = new ListModelList(Facade.getInstance().listarMatriculaAluno(alunoEncontrado.getId()));
	    ListagemDadosDoAluno2.setModel(listModel);
	    
		}else{
			Messagebox.show("Não existe Aluno com este RG!",
  			        "Atenção!",
  			        Messagebox.OK,
  			        Messagebox.EXCLAMATION,
  			        new org.zkoss.zk.ui.event.EventListener() {
  						public void onEvent(Event arg1) throws Exception {
  						}
  					}
  			);
			
		}
  	
	}
	
	public void onClick$renovarMatricula(Event e) throws InterruptedException {
		if(nivelCombo.getSelectedIndex() == -1 || anoLetivoCombo.getSelectedIndex() == -1 || serieCombo.getSelectedIndex() == -1 ||
				turnoCombo.getSelectedIndex() == -1 || turmaCombo.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{
		m.setNumero(matricula.getValue());
		m.setCodigoMec(codigoMec.getValue());
		m.setCre(cre.getValue());
		
		m.setTurma((Turma) turmaCombo.getSelectedItem().getValue());
				
		alunoEncontrado.getMatricula().add(m);
		
		Facade.getInstance().atualizarAluno(alunoEncontrado);
		
		Messagebox.show("Renovação de Matrícula Efetuada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		
		m = new Matricula();
		}
	} 
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
				  	 	
	  	 	anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
	  	 	long idNivelEscolarComparar = 0;
	  	 	if(Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId()).isEmpty() == true){
	  	 		nivelCombo.setDisabled(true);
	  	 		Messagebox.show("Não existem Níveis Escolares cadastrados para este ano! Favor cadastrá-los!",
	  			        "Atenção!",
	  			        Messagebox.OK,
	  			        Messagebox.EXCLAMATION,
	  			        new org.zkoss.zk.ui.event.EventListener() {
	  						public void onEvent(Event arg1) throws Exception {
	  						}
	  					}
	  			);
	  	 	}else{
	  	 		
	  	 	nivelCombo.getChildren().clear();
	  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId())) {
	  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
	  	 		if(idNivelEscolarComparar != ne.getId()){
	  	 			Comboitem comboitem = new Comboitem();
	  	 			comboitem.setLabel(ne.getNivel());
	  	 			comboitem.setValue(ne);
	  	 			nivelCombo.appendChild(comboitem);
	  	 		}
	  	 		idNivelEscolarComparar = ne.getId();
		 	}
	  	 	
	  	 	nivelCombo.setDisabled(false);
	  	 	binder.loadComponent(RowNivel); 
	  	 	}
	  	
	}
	
	public void onSelect$nivelCombo(Event e) {
		serieCombo.setDisabled(false);
		
		ne1 = ((NivelEscolar) nivelCombo.getSelectedItem().getValue());
		  serieCombo.getChildren().clear();	  	  
	  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne1.getId())) {
				Comboitem comboitem = new Comboitem(se.getDescricao());
				comboitem.setValue(se);
				serieCombo.appendChild(comboitem);
		 	}
	  	 	
	  	 	binder.loadComponent(RowSerie);		
		
	}
	
	public void onSelect$serieCombo(Event e) {
		
			turnoCombo.setDisabled(false);
			binder.loadComponent(RowTurno);
		
	}
	
	public void onSelect$turnoCombo(Event e) {
		
		s = ((Serie) serieCombo.getSelectedItem().getValue());
		String turno = ((String) turnoCombo.getSelectedItem().getValue());
		turmaCombo.setDisabled(false);
	    turmaCombo.getChildren().clear();
	 	for (Turma tu : Facade.getInstance().listarTurmaSerieTurno(s.getId(), turno)) {
			Comboitem comboitem = new Comboitem(tu.getNome());
			comboitem.setValue(tu);
			turmaCombo.appendChild(comboitem);
	 	}
	 	binder.loadComponent(RowTurma);
	}
	
	public void onClick$DeletarMatricula(Event e) throws InterruptedException {  
		if(groupboxDadosDoAluno2.isVisible() && ListagemDadosDoAluno2.getSelectedIndex()!=-1){
			try {
				Messagebox.show("Você tem certeza que deseja Deletar a Matrícula selecionada?",
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
		Facade.getInstance().removerMatricula( (Matricula) ListagemDadosDoAluno2.getModel().getElementAt(ListagemDadosDoAluno2.getSelectedIndex()));
				
		listModel1 = new ListModelList(Facade.getInstance().listarMatriculaAluno(alunoEncontrado.getId()));
		ListagemDadosDoAluno2.setModel(listModel1);
	}
	
	
	public void onClick$EditarMatricula(Event e) throws InterruptedException {
		if(groupboxDadosDoAluno2.isVisible() && ListagemDadosDoAluno2.getSelectedIndex()!=-1){
			JanelaRenovarMatricula.setVisible(true);
			groupboxDadosDoAluno.setVisible(false);
			groupboxProcurarAluno.setVisible(false);
			groupboxRenovarMatricula.setVisible(true);
			JanelaProcurarMatricula.setVisible(false);
			
			renovarMatricula.setVisible(false);
			salvarButton.setVisible(true);
			cancelarButton.setVisible(true);
			
			m = (Matricula) ListagemDadosDoAluno2.getModel().getElementAt(ListagemDadosDoAluno2.getSelectedIndex());

	  	 	anoLetivoCombo.setDisabled(true);
			anoLetivoCombo.setValue("Ano - " + m.getTurma().getAnoLetivo().getAno());
			
			long idNivelEscolarComparar = 0;
			nivelCombo.getChildren().clear();
	  	 	for (NivelEscolar ne : Facade.getInstance().listarNivelPorAnoLetivo(m.getTurma().getAnoLetivo().getId())) {
	  	 		//funciona como um GROUP BY para que não sejam repetidos os mesmos níveis no combobox
	  	 		if(idNivelEscolarComparar != ne.getId()){
	  	 			Comboitem comboitem = new Comboitem();
	  	 			comboitem.setLabel(ne.getNivel());
	  	 			comboitem.setValue(ne);
	  	 			nivelCombo.appendChild(comboitem);
	  	 		}
	  	 		idNivelEscolarComparar = ne.getId();
		 	}
	  	 	
	  	 	nivelCombo.setDisabled(false);
			nivelCombo.setValue(m.getTurma().getSerie().getNivelEscolar().getNivel());
			
			serieCombo.getChildren().clear();	  	  
		  	for (Serie se : Facade.getInstance().listarSerieNivel(m.getTurma().getSerie().getNivelEscolar().getId())) {
		  		Comboitem comboitem = new Comboitem(se.getDescricao());
				comboitem.setValue(se);
				serieCombo.appendChild(comboitem);
			}
			serieCombo.setValue(m.getTurma().getSerie().getDescricao());
			serieCombo.setDisabled(false);
			
			
			turnoCombo.setValue(m.getTurma().getTurno());
			turnoCombo.setDisabled(false);
			
			turmaCombo.getChildren().clear();
		 	for (Turma tu : Facade.getInstance().listarTurmaSerieTurno(m.getTurma().getSerie().getId(), m.getTurma().getTurno())) {
				Comboitem comboitem = new Comboitem(tu.getNome());
				comboitem.setValue(tu);
				turmaCombo.appendChild(comboitem);
		 	}
			turmaCombo.setValue(m.getTurma().getNome());
			turmaCombo.setDisabled(false);
			
			matricula.setValue(m.getNumero());
			codigoMec.setValue(m.getCodigoMec());
			cre.setValue(m.getCre());
			
			matricula.setConstraint("no empty");
			codigoMec.setConstraint("no empty, no zero, no negative");
			cre.setConstraint("no empty, no zero, no negative");
			
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
		
		listModel1 = new ListModelList(Facade.getInstance().listarMatriculaAluno(alunoEncontrado.getId()));
		ListagemDadosDoAluno2.setModel(listModel);
	}
	
	public void onClick$salvarButton(Event e) throws InterruptedException {	
		if(nivelCombo.getSelectedIndex() == -1 || anoLetivoCombo.getSelectedIndex() == -1 || serieCombo.getSelectedIndex() == -1 ||
				turnoCombo.getSelectedIndex() == -1 || turmaCombo.getSelectedIndex() == -1){
			alert("Existe(m) Campo(s) não selecionado(s)!");
		}
		else{		
		Matricula mm = Facade.getInstance().carregarMatricula(m.getId());
		
		mm.setCodigoMec(codigoMec.getValue());
		mm.setCre(cre.getValue());
		mm.setNumero(matricula.getValue());
		mm.setTurma((Turma) turmaCombo.getSelectedItem().getValue());
		
	 	Facade.getInstance().atualizarMatricula(mm);
	 	m = new Matricula();
	 	
	 	JanelaRenovarMatricula.setVisible(false);
	 	JanelaProcurarMatricula.setVisible(false);

		listModel = new ListModelList(Facade.getInstance().listarMatriculaAluno(alunoEncontrado.getId()));
		ListagemDadosDoAluno2.setModel(listModel);
		
		Messagebox.show("Matrícula Alterada com Sucesso!",
		        "Sucesso!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
			);
		}
	}
	
	public void onClick$cancelarButton(Event e) {	
		JanelaProcurarMatricula.setVisible(false);
		JanelaRenovarMatricula.setVisible(false);
	}
	
}
