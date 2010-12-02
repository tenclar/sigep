package br.com.sigep.controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.zkoss.zul.Window;

import org.zkoss.zul.Messagebox;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.AnoLetivo;

import br.com.sigep.facade.Facade;

public class FichaIndividualEnsinoMedioController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private Window indexFichaIndividualEnsinoMedio;

	private Combobox anoLetivoCombo;
	private Textbox rgDoAluno;
	private Groupbox groupboxAnoLetivo;
	
	private long idSerie;
	private long idNivelEscolar;
	
	//INICIO: Carga Horária da tabela freqüência
	private int cargaHorariaPortugues;
	private int cargaHorariaMatematica;
	private int cargaHorariaHistoria;
	private int cargaHorariaGeografia;
	private int cargaHorariaBiologia;
	private int cargaHorariaFisica;
	private int cargaHorariaQuimica;
	private int cargaHorariaArte;
	private int cargaHorariaEducacaoFisica;
	private int cargaHorariaSociologia;
	private int cargaHorariaFilosofia;
	private int cargaHorariaLEM;
	
	// INICIO: Notas para preencher tabela DESEMPENHO
	private float notasemestre1Portugues;
	private float notasemestre2Portugues;
	private float notafinalPortugues;
	private float notasemestre1Matematica;
	private float notasemestre2Matematica;
	private float notafinalMatematica;
	private float notasemestre1Historia;
	private float notasemestre2Historia;
	private float notafinalHistoria;
	private float notasemestre1Geografia;
	private float notasemestre2Geografia;
	private float notafinalGeografia;
	private float notasemestre1Biologia;
	private float notasemestre2Biologia;
	private float notafinalBiologia;
	private float notasemestre1Fisica;
	private float notasemestre2Fisica;
	private float notafinalFisica;
	private float notasemestre1Quimica;
	private float notasemestre2Quimica;
	private float notafinalQuimica;
	private float notasemestre1Arte;
	private float notasemestre2Arte;
	private float notafinalArte;
	private float notasemestre1EducacaoFisica;
	private float notasemestre2EducacaoFisica;
	private float notafinalEducacaoFisica;
	private float notasemestre1Sociologia;
	private float notasemestre2Sociologia;
	private float notafinalSociologia;
	private float notasemestre1Filosofia;
	private float notasemestre2Filosofia;
	private float notafinalFilosofia;
	private float notasemestre1LEM;
	private float notasemestre2LEM;
	private float notafinalLEM;
	// FINAL: Notas para preencher tabela DESEMPENHO
	
	
	
	
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
	
	public void onClick$gerarPdfMedio(Event e) throws InterruptedException, JRException, SQLException {
			
		if (anoLetivoCombo.getSelectedIndex() == -1) {
			alert("Existem campos ainda não selecionados! Preencha-os!");
		} else {
			
			anoletivoObj = (AnoLetivo) anoLetivoCombo.getSelectedItem().getValue();
			
			Connection conexao = Facade.getInstance().getConnection();
			
			String selectInicial = "SELECT s.id AS serieId, ne.id AS nivelId FROM matricula m, turma t, aluno a, anoletivo al, serie s, pessoa p, nivelescolar ne WHERE ne.id = s.nivelescolar and s.id = t.serie and t.id = m.turma and t.anoletivo = al.id and m.idaluno = a.pessoa_id and a.pessoa_id = p.id and m.idaluno = " + alunoEncontrado.getId() +" and t.anoletivo = "+ anoletivoObj.getId();
			Statement stmt0 = conexao.createStatement();
			ResultSet rs0 = stmt0.executeQuery(selectInicial);
			while(rs0.next()){
				idSerie = rs0.getLong("serieId");
				idNivelEscolar = rs0.getLong("nivelId");
			}
			stmt0.close();

			Statement stmt1 = conexao.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+ idNivelEscolar +" and al.id = "+ anoletivoObj.getId()+ " and s.id =" + idSerie +" and d.nome ='Português' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs1.next()){
				notasemestre1Portugues = rs1.getFloat("notasemestre1");
				notasemestre2Portugues = rs1.getFloat("notasemestre2");
				notafinalPortugues = rs1.getFloat("notafinal");
			}
			stmt1.close();
			
			Statement stmt2 = conexao.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+ idNivelEscolar +" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+ idSerie +" and d.nome ='Matemática' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs2.next()){
				notasemestre1Matematica = rs2.getFloat("notasemestre1");
				notasemestre2Matematica = rs2.getFloat("notasemestre2");
				notafinalMatematica = rs2.getFloat("notafinal");
			}
			stmt2.close();
			
			Statement stmt3 = conexao.createStatement();
			ResultSet rs3 = stmt3.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+ idNivelEscolar +" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+ idSerie+" and d.nome ='História' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs3.next()){
				notasemestre1Historia = rs3.getFloat("notasemestre1");
				notasemestre2Historia = rs3.getFloat("notasemestre2");
				notafinalHistoria = rs3.getFloat("notafinal");
			}
			stmt3.close();
			
			Statement stmt4 = conexao.createStatement();
			ResultSet rs4 = stmt4.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Geografia' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs4.next()){
				notasemestre1Geografia = rs4.getFloat("notasemestre1");
				notasemestre2Geografia = rs4.getFloat("notasemestre2");
				notafinalGeografia = rs4.getFloat("notafinal");
			}
			stmt4.close();
			
			Statement stmt5 = conexao.createStatement();
			ResultSet rs5 = stmt5.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Biologia' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs5.next()){
				notasemestre1Biologia = rs5.getFloat("notasemestre1");
				notasemestre2Biologia = rs5.getFloat("notasemestre2");
				notafinalBiologia = rs5.getFloat("notafinal");
			}
			stmt5.close();
			
			Statement stmt6 = conexao.createStatement();
			ResultSet rs6 = stmt6.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Física' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs6.next()){
				notasemestre1Fisica = rs6.getFloat("notasemestre1");
				notasemestre2Fisica = rs6.getFloat("notasemestre2");
				notafinalFisica = rs6.getFloat("notafinal");
			}
			stmt6.close();
			
			Statement stmt7 = conexao.createStatement();
			ResultSet rs7 = stmt7.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Química' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs7.next()){
				notasemestre1Quimica = rs7.getFloat("notasemestre1");
				notasemestre2Quimica = rs7.getFloat("notasemestre2");
				notafinalQuimica = rs7.getFloat("notafinal");
			}
			stmt7.close();
			
			Statement stmt8 = conexao.createStatement();
			ResultSet rs8 = stmt8.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Arte' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs8.next()){
				notasemestre1Arte = rs8.getFloat("notasemestre1");
				notasemestre2Arte = rs8.getFloat("notasemestre2");
				notafinalArte = rs8.getFloat("notafinal");
			}
			stmt8.close();
			
			Statement stmt9 = conexao.createStatement();
			ResultSet rs9 = stmt9.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Educação Física' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs9.next()){
				notasemestre1EducacaoFisica = rs9.getFloat("notasemestre1");
				notasemestre2EducacaoFisica = rs9.getFloat("notasemestre2");
				notafinalEducacaoFisica = rs9.getFloat("notafinal");
			}
			stmt9.close();
			
			Statement stmt10 = conexao.createStatement();
			ResultSet rs10 = stmt10.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Sociologia' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs10.next()){
				notasemestre1Sociologia = rs10.getFloat("notasemestre1");
				notasemestre2Sociologia = rs10.getFloat("notasemestre2");
				notafinalSociologia = rs10.getFloat("notafinal");
			}
			stmt10.close();
			
			Statement stmt11 = conexao.createStatement();
			ResultSet rs11 = stmt11.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='Filosofia' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs11.next()){
				notasemestre1Filosofia = rs11.getFloat("notasemestre1");
				notasemestre2Filosofia = rs11.getFloat("notasemestre2");
				notafinalFilosofia = rs11.getFloat("notafinal");
			}
			stmt11.close();
			
			Statement stmt12 = conexao.createStatement();
			ResultSet rs12 = stmt12.executeQuery("SELECT rf.notasemestre1, rf.notasemestre2, rf.notafinal FROM  disciplina d, aluno a, pessoa p, resultadofinal rf, registrodedisciplina rdd, turma t, serie s, nivelescolar ne, anoletivo al, matricula m WHERE rf.aluno = a.pessoa_id and p.id = a.pessoa_id and rdd.id = rf.registrodedisciplina and rdd.disciplina = d.id and rdd.turma = t.id and t.serie = s.id and s.nivelescolar = ne.id and t.anoletivo = al.id and m.turma = t.id and rf.aluno = "+ alunoEncontrado.getId() + "and s.nivelescolar = "+idNivelEscolar+" and al.id = "+ anoletivoObj.getId()+ " and s.id = "+idSerie+" and d.nome ='L.E.M.' GROUP BY rf.notasemestre1, rf.notasemestre2, rf.notafinal");
			while(rs12.next()){
				notasemestre1LEM = rs12.getFloat("notasemestre1");
				notasemestre2LEM = rs12.getFloat("notasemestre2");
				notafinalLEM = rs12.getFloat("notafinal");
			}
			stmt12.close();

			System.out.println(notasemestre1LEM + " - " + notasemestre2Fisica + " - " + notafinalGeografia);
			
			//>>>>>>>>>>>>>>>>>>> INICIO DOS SELECTS CARGAHORARIA
			
			Statement stmtCH1 = conexao.createStatement();
			ResultSet rsCH1 = stmtCH1.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Português' and s.id = "+ idSerie);
			while(rsCH1.next()){
				cargaHorariaPortugues = rsCH1.getInt("cargahoraria");
			}
			stmtCH1.close();
			
			Statement stmtCH2 = conexao.createStatement();
			ResultSet rsCH2 = stmtCH2.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Matemática' and s.id = "+ idSerie);
			while(rsCH2.next()){
				cargaHorariaMatematica = rsCH2.getInt("cargahoraria");
			}
			stmtCH2.close();
			
			Statement stmtCH3 = conexao.createStatement();
			ResultSet rsCH3 = stmtCH3.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'História' and s.id = "+ idSerie);
			while(rsCH3.next()){
				cargaHorariaHistoria = rsCH3.getInt("cargahoraria");
			}
			stmtCH3.close();
			
			Statement stmtCH4 = conexao.createStatement();
			ResultSet rsCH4 = stmtCH4.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Geografia' and s.id = "+ idSerie);
			while(rsCH4.next()){
				cargaHorariaGeografia = rsCH4.getInt("cargahoraria");
			}
			stmtCH4.close();
			
			Statement stmtCH5 = conexao.createStatement();
			ResultSet rsCH5 = stmtCH5.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Biologia' and s.id = "+ idSerie);
			while(rsCH5.next()){
				cargaHorariaBiologia = rsCH5.getInt("cargahoraria");
			}
			stmtCH5.close();
			
			Statement stmtCH6 = conexao.createStatement();
			ResultSet rsCH6 = stmtCH6.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Física' and s.id = "+ idSerie);
			while(rsCH6.next()){
				cargaHorariaFisica = rsCH6.getInt("cargahoraria");
			}
			stmtCH6.close();
			
			Statement stmtCH7 = conexao.createStatement();
			ResultSet rsCH7 = stmtCH7.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Química' and s.id = "+ idSerie);
			while(rsCH7.next()){
				cargaHorariaQuimica = rsCH7.getInt("cargahoraria");
			}
			stmtCH7.close();
			
			Statement stmtCH8 = conexao.createStatement();
			ResultSet rsCH8 = stmtCH8.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Arte' and s.id = "+ idSerie);
			while(rsCH8.next()){
				cargaHorariaArte = rsCH8.getInt("cargahoraria");
			}
			stmtCH8.close();
			
			Statement stmtCH9 = conexao.createStatement();
			ResultSet rsCH9 = stmtCH9.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Educação Física' and s.id = "+ idSerie);
			while(rsCH9.next()){
				cargaHorariaEducacaoFisica = rsCH9.getInt("cargahoraria");
			}
			stmtCH9.close();
			
			Statement stmtCH10 = conexao.createStatement();
			ResultSet rsCH10 = stmtCH10.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Sociologia' and s.id = "+ idSerie);
			while(rsCH10.next()){
				cargaHorariaSociologia = rsCH10.getInt("cargahoraria");
			}
			stmtCH10.close();
			
			Statement stmtCH11 = conexao.createStatement();
			ResultSet rsCH11 = stmtCH11.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'Filosofia' and s.id = "+ idSerie);
			while(rsCH11.next()){
				cargaHorariaFilosofia = rsCH11.getInt("cargahoraria");
			}
			stmtCH11.close();
			
			Statement stmtCH12 = conexao.createStatement();
			ResultSet rsCH12 = stmtCH12.executeQuery("SELECT d.cargahoraria FROM disciplina d, serie s, turma t WHERE t.serie = s.id and d.serie = s.id and d.nome = 'L.E.M.' and s.id = "+ idSerie);
			while(rsCH12.next()){
				cargaHorariaLEM = rsCH12.getInt("cargahoraria");
			}
			stmtCH12.close();
			
			String caminho, saida, jasper;
			
			caminho = application.getRealPath("/Relatorios/Ficha Individual Ensino Médio.jrxml");
			saida = "D:/Arquivos da Faculdade/Projeto Final/ZKSIGEP1/WebContent/Relatorios/Ficha Individual Ensino Médio.pdf";
			jasper = application.getRealPath("/Relatorios/Ficha Individual Ensino Médio.jasper");
			
			JasperPrint jasperPrint;
			JasperReport jasperReport;
			JasperDesign desenho = JRXmlLoader.load(caminho);
			jasperReport = JasperCompileManager.compileReport(desenho);
			
			Map parametros = new HashMap();
			parametros.put("idAluno", alunoEncontrado.getId());
			parametros.put("idAnoLetivo", anoletivoObj.getId());
			parametros.put("notaSemestre1Portugues", notasemestre1Portugues);
			parametros.put("notaSemestre2Portugues", notasemestre2Portugues);
			parametros.put("notaFinalPortugues", notafinalPortugues);
			parametros.put("notaSemestre1MATEMATICA", notasemestre1Matematica);
			parametros.put("notaSemestre2MATEMATICA", notasemestre2Matematica);
			parametros.put("notaFinalMATEMATICA", notafinalMatematica);
			parametros.put("notaSemestre1HISTORIA", notasemestre1Historia);
			parametros.put("notaSemestre2HISTORIA", notasemestre2Historia);
			parametros.put("notaFinalHISTORIA", notafinalHistoria);
			parametros.put("notaSemestre1GEOGRAFIA", notasemestre1Geografia);
			parametros.put("notaSemestre2GEOGRAFIA", notasemestre2Geografia);
			parametros.put("notaFinalGEOGRAFIA", notafinalGeografia);
			parametros.put("notaSemestre1BIOLOGIA", notasemestre1Biologia);
			parametros.put("notaSemestre2BIOLOGIA", notasemestre2Biologia);
			parametros.put("notaFinalBIOLOGIA", notafinalBiologia);
			parametros.put("notaSemestre1FISICA", notasemestre1Fisica);
			parametros.put("notaSemestre2FISICA", notasemestre2Fisica);
			parametros.put("notaFinalFISICA", notafinalFisica);
			parametros.put("notaSemestre1QUIMICA", notasemestre1Quimica);
			parametros.put("notaSemestre2QUIMICA", notasemestre2Quimica);
			parametros.put("notaFinalQUIMICA", notafinalQuimica);
			parametros.put("notaSemestre1ARTE", notasemestre1Arte);
			parametros.put("notaSemestre2ARTE", notasemestre2Arte);
			parametros.put("notaFinalARTE", notafinalArte);
			parametros.put("notaSemestre1EDUCACAOFISICA", notasemestre1EducacaoFisica);
			parametros.put("notaSemestre2EDUCACAOFISICA", notasemestre2EducacaoFisica);
			parametros.put("notaFinalEDUCACAOFISICA", notafinalEducacaoFisica);
			parametros.put("notaSemestre1SOCIOLOGIA", notasemestre1Sociologia);
			parametros.put("notaSemestre2SOCIOLOGIA", notasemestre2Sociologia);
			parametros.put("notaFinalSOCIOLOGIA", notafinalSociologia);
			parametros.put("notaSemestre1FILOSOFIA", notasemestre1Filosofia);
			parametros.put("notaSemestre2FILOSOFIA", notasemestre2Filosofia);
			parametros.put("notaFinalFILOSOFIA", notafinalFilosofia);
			parametros.put("notaSemestre1LEM", notasemestre1LEM);
			parametros.put("notaSemestre2LEM", notasemestre2LEM);
			parametros.put("notaFinalLEM", notafinalLEM);
			parametros.put("cargaHorariaPORTUGUES", cargaHorariaPortugues);
			parametros.put("cargaHorariaMATEMATICA", cargaHorariaMatematica);
			parametros.put("cargaHorariaHISTORIA", cargaHorariaHistoria);
			parametros.put("cargaHorariaGEOGRAFIA", cargaHorariaGeografia);
			parametros.put("cargaHorariaBIOLOGIA", cargaHorariaBiologia);
			parametros.put("cargaHorariaFISICA", cargaHorariaFisica);
			parametros.put("cargaHorariaQUIMICA", cargaHorariaQuimica);
			parametros.put("cargaHorariaARTE", cargaHorariaArte);
			parametros.put("cargaHorariaEDUCACAOFISICA", cargaHorariaEducacaoFisica);
			parametros.put("cargaHorariaSOCIOLOGIA", cargaHorariaSociologia);
			parametros.put("cargaHorariaFILOSOFIA", cargaHorariaFilosofia);
			parametros.put("cargaHorariaLEM", cargaHorariaLEM);
			
			
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
