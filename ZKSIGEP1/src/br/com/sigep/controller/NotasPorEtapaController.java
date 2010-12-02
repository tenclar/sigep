package br.com.sigep.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Avaliacao;
import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.bean.Resultado;
import br.com.sigep.bean.ResultadoFinal;
import br.com.sigep.facade.Facade;

public class NotasPorEtapaController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
		
	private Label login;
	private Div FiltroAnoLetivo;
	private Groupbox groupboxTabelaNotaPeriodo1;
	private Groupbox groupboxTabelaNotaPeriodo2;
	
	private Rows rowNotasPrimeiroPeriodo;
	private Rows rowNotasSegundoPeriodo;
		
	private Combobox anoLetivoCombo;
	private Groupbox groupboxAnoLetivo;
	
	private List<Row> rowss = new ArrayList<Row>();
	private List<Label> label = new ArrayList<Label>();
		
	AnoLetivo anoletivoObj = null;
	Aluno alunoEncontrado = null;

	public Aluno getAlunoEncontrado() {
		return alunoEncontrado;
	}

	public void setAlunoEncontrado(Aluno alunoEncontrado) {
		this.alunoEncontrado = alunoEncontrado;
	}

	public AnoLetivo getAnoletivoObj() {
		return anoletivoObj;
	}

	public void setAnoletivoObj(AnoLetivo anoletivoObj) {
		this.anoletivoObj = anoletivoObj;
	}
	
	public void  onClick$filtrarAnoLetivo(Event e) throws InterruptedException{
					
		if (anoLetivoCombo.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		} else {
			
			anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
			
			Row rows = new Row();
			rows.setAlign("center");
			rows.setWidth("275px");
			new Label("Disciplina ").setParent(rows);
			new Label("1ª Etapa ").setParent(rows);
			new Label("2ª Etapa ").setParent(rows);
			new Label("3ª Etapa ").setParent(rows);
			new Label("4ª Etapa ").setParent(rows);
			rows.setParent(rowNotasPrimeiroPeriodo);			
			rowss.add(rows);
			
			Row rows1 = new Row();
			rows1.setAlign("center");
			rows1.setWidth("275px");
			new Label("Disciplina ").setParent(rows1);
			new Label("1ª Etapa ").setParent(rows1);
			new Label("2ª Etapa ").setParent(rows1);
			new Label("3ª Etapa ").setParent(rows1);
			new Label("4ª Etapa ").setParent(rows1);
			rows1.setParent(rowNotasSegundoPeriodo);			
			rowss.add(rows1);
			
			for(Matricula m1 : alunoEncontrado.getMatricula()){
				if(m1.getTurma().getAnoLetivo().getId() == anoletivoObj.getId()){
					
					for (ResultadoFinal rf: Facade.getInstance().listarNotasPorPeriodo
							(alunoEncontrado.getId(), m1.getTurma().getId())){
						
						Row rows2 = new Row();
						rows2.setAlign("left");
						new Label(rf.getRegistroDeDisciplina().getDisciplina().getNome()).setParent(rows2);
						new Label(""+rf.getNotasFinais().get("1º Período:1ª Etapa")).setParent(rows2);
						new Label(""+rf.getNotasFinais().get("1º Período:2ª Etapa")).setParent(rows2);
						new Label(""+rf.getNotasFinais().get("1º Período:3ª Etapa")).setParent(rows2);
						new Label(""+rf.getNotasFinais().get("1º Período:4ª Etapa")).setParent(rows2);
						rows2.setParent(rowNotasPrimeiroPeriodo);
						rowss.add(rows1);
						
						Row rows3 = new Row();
						rows3.setAlign("left");
						new Label(rf.getRegistroDeDisciplina().getDisciplina().getNome()).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:1ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:2ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:3ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:4ª Etapa")).setParent(rows3);
						rows3.setParent(rowNotasSegundoPeriodo);
						rowss.add(rows1);
						
					}
					
					/*for (ResultadoFinal rf: Facade.getInstance().listarNotasPorPeriodo
							(alunoEncontrado.getId(), m1.getTurma().getId())){
						
						Row rows3 = new Row();
						rows3.setAlign("left");
						new Label(rf.getRegistroDeDisciplina().getDisciplina().getNome()).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:1ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:2ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:3ª Etapa")).setParent(rows3);
						new Label(""+rf.getNotasFinais().get("2º Período:4ª Etapa")).setParent(rows3);
						rows3.setParent(rowNotasSegundoPeriodo);
						rowss.add(rows1);
						
					}*/
					
				}
			}
									
			FiltroAnoLetivo.setVisible(false);
			groupboxTabelaNotaPeriodo1.setVisible(true);
			groupboxTabelaNotaPeriodo2.setVisible(true);
			
		}			
		
	}
	
}
