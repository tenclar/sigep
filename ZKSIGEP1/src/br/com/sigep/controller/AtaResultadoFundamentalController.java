package br.com.sigep.controller;


import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Row;

import org.zkoss.zul.Messagebox;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;
import br.com.sigep.bean.Turma;
import br.com.sigep.facade.Facade;

public class AtaResultadoFundamentalController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;

	private DataBinder binder;
	private Combobox anoLetivoCombo;
	private Combobox nivelCombo;
	private Combobox serieCombo;
	private Combobox turmaCombo;
	private Button gerarPdf;
	private Row RowSerie;
	private Row RowNivel;
	private Row RowTurma;
				
	Turma turma = null;
	NivelEscolar ne1 = null;
	Serie s = null;
	AnoLetivo anoletivoObj = null;
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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
	
	public void onClick$gerarPdf(Event e) throws InterruptedException, JRException {
			
		String caminho, saida, jasper;
		
		caminho = application.getRealPath("/Relatorios/AtaResultadoEnsinoFundamental.jrxml");
		saida = "D:/Arquivos da Faculdade/Projeto Final/ZKSIGEP1/WebContent/Relatorios/AtaResultadoEnsinoFundamental.pdf";
		jasper = application.getRealPath("/Relatorios/AtaResultadoEnsinoFundamental.jasper");
		
		JasperPrint jasperPrint;
		
		JasperReport jasperReport;
					
		JasperDesign desenho = JRXmlLoader.load(caminho);
		
		jasperReport = JasperCompileManager.compileReport(desenho);
		
		Connection conexao = Facade.getInstance().getConnection();
		
		Map parametros = new HashMap();
		parametros.put("idTurma", turma.getId());
					
		jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao);
		
		JasperExportManager.exportReportToPdfFile(jasperPrint, saida);
		//JasperManager.printReportToPdfFile(jasperPrint, saida);
		
		JasperViewer.viewReport(jasperPrint, true);
		
		//JasperViewer viewer = new JasperViewer( jasperPrint , true );
		//viewer.show();
		
		//report.setParameters(parametros);
		//report.setSrc(jasper);
		//report.setDatasource(null);
		
		Messagebox.show("Relatório Gerado com Sucesso!",
		        "Informação!",
		        Messagebox.OK,
		        Messagebox.EXCLAMATION,
		        new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event arg1) throws Exception {
					}
				}
		);
		
	} 	
	
	public void onSelect$anoLetivoCombo(Event e) throws InterruptedException {
			
		anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
  	 	long idNivelEscolarComparar = 0;
  	 	if(Facade.getInstance().listarNivelPorAnoLetivo(anoletivoObj.getId()).isEmpty() == true){
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
  	 	
		ne1 = ((NivelEscolar) nivelCombo.getSelectedItem().getValue());
  	 	serieCombo.getChildren().clear();
  	 	for (Serie se : Facade.getInstance().listarSerieNivel(ne1.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(se.getDescricao());
			comboitem.setValue(se);
			serieCombo.appendChild(comboitem);
	 	}
  	 	
  	 	serieCombo.setDisabled(false);
  	 	binder.loadComponent(RowSerie); 	
  	
}

	public void onSelect$serieCombo(){

		s = ((Serie) serieCombo.getSelectedItem().getValue());
		turmaCombo.getChildren().clear();
  	 	for (Turma t : Facade.getInstance().listarTurmaSerie(s.getId(), anoletivoObj.getId())) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(t.getNome());
			comboitem.setValue(t);
			turmaCombo.appendChild(comboitem);
	 	}
  	 	
  	 	turmaCombo.setDisabled(false);
  	 	binder.loadComponent(RowTurma); 
		
	}

	public void onSelect$turmaCombo(){

		turma = ((Turma) turmaCombo.getSelectedItem().getValue());
		gerarPdf.setDisabled(false); 
				
	}
	
}
