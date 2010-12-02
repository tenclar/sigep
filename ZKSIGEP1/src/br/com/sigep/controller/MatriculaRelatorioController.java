package br.com.sigep.controller;


import java.sql.Connection;
import java.sql.SQLException;
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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Textbox;

import org.zkoss.zul.Messagebox;


import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;

import br.com.sigep.facade.Facade;

public class MatriculaRelatorioController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;

	private Combobox anoLetivoCombo;
	private Textbox rgDoAluno;
	private Groupbox groupboxAnoLetivo;
	
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
	
	public void onClick$gerarPdfMatricula(Event e) throws InterruptedException, JRException, SQLException {
			
		if (anoLetivoCombo.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		} else {
			
			anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
			
			String caminho, saida, jasper;
		
			caminho = application.getRealPath("/Relatorios/RelatorioMatricula.jrxml");
			saida = "D:/Arquivos da Faculdade/Projeto Final/ZKSIGEP1/WebContent/Relatorios/RelatorioMatricula.pdf";
			jasper = application.getRealPath("/Relatorios/RelatorioMatricula.jasper");
		
			JasperPrint jasperPrint;

			JasperReport jasperReport;

			JasperDesign desenho = JRXmlLoader.load(caminho);

			jasperReport = JasperCompileManager.compileReport(desenho);

			Connection conexao = Facade.getInstance().getConnection();
			
			Map parametros = new HashMap();
			parametros.put("idAluno", alunoEncontrado.getId());
			parametros.put("anoletivoAluno", anoletivoObj.getId());

			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao);

			JasperExportManager.exportReportToPdfFile(jasperPrint, saida);

			JasperViewer.viewReport(jasperPrint, true);

			Messagebox.show("Relatório Gerado com Sucesso!", "Informação!",
					Messagebox.OK, Messagebox.EXCLAMATION,
					new org.zkoss.zk.ui.event.EventListener() {
						public void onEvent(Event arg1) throws Exception {
						}
					});
		}
	} 	
	
	public void  onClick$procurarDadosDoAluno(Event e) throws InterruptedException{
		
		alunoEncontrado = Facade.getInstance().procurarAlunoPorRg(rgDoAluno.getValue());
		
		if(alunoEncontrado != null){		
		
			groupboxAnoLetivo.setVisible(true);

			anoLetivoCombo.getChildren().clear();
			for (AnoLetivo ano : Facade.getInstance().listarAnoLetivoNosQuaisOAlunoFoiMatriculado(alunoEncontrado.getId())) {

  	 			Comboitem comboitem = new Comboitem();
  	 			comboitem.setLabel("Ano - " + ano.getAno());
  	 			comboitem.setValue(ano);
  	 			anoLetivoCombo.appendChild(comboitem);
  	 		
			}		    
		}else{
			
			groupboxAnoLetivo.setVisible(false);
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
	
	
}
