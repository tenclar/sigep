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

public class NotasPorPeriodoController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
		
	private Label login;
	private Div FiltroAnoLetivo;
	private Groupbox groupboxTabelaNota;
	
	private Rows rowNotasPeriodo;
		
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
			new Label("1º Periodo ").setParent(rows);
			new Label("2º Periodo ").setParent(rows);
			new Label("Total ").setParent(rows);
			rows.setParent(rowNotasPeriodo);			
			rowss.add(rows);
					
			for(Matricula m1 : alunoEncontrado.getMatricula()){
				if(m1.getTurma().getAnoLetivo().getId() == anoletivoObj.getId()){
					for (ResultadoFinal rf: Facade.getInstance().listarNotasPorPeriodo
							(alunoEncontrado.getId(), m1.getTurma().getId())){
						
						Row rows1 = new Row();
						rows1.setAlign("left");
						new Label(rf.getRegistroDeDisciplina().getDisciplina().getNome()).setParent(rows1);
						new Label(""+rf.getNotaSemestre1()).setParent(rows1);
						new Label(""+rf.getNotaSemestre2()).setParent(rows1);
						new Label(""+rf.getNotaFinal()).setParent(rows1);
						rows1.setParent(rowNotasPeriodo);
						rowss.add(rows1);	
						
					}
					
				}
			}
									
			FiltroAnoLetivo.setVisible(false);
			groupboxTabelaNota.setVisible(true);
		}			
		
	}
	
}
