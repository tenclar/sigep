package br.com.sigep.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;



public class IndexController  extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Div divCenter;
	private Window indexBloco;
	private Window indexSala;
	private Window indexSerie;
	private Window indexDisciplina;
	private Window indexTurma;
	private Window indexFuncionario;
	private Window indexProfessor;
	private Window indexNivelEscolar;
	private Window indexAnoLetivo;
	private Window indexTipoDeUsuario;
	private Window indexPermissao;
	private Window indexOcorrencia;
	private Window indexAfastamento;
	private Window indexAluno;
	private Window indexAvaliacao;
	private Window indexRegistroDeDisciplina;
	private Window indexRegistroDeAula;
	private Window indexResultado;
	private Window indexResultadoFinal;
	private Window indexFrequencia;
	private Window indexRenovacaoDeMatricula;
	private Window indexOutrosVinculos;
	private Window indexFormacao;
	private Window indexAtaResultadoFundamental;
	private Window indexAtaResultadoMedio;
	private Window indexFichaIndividualEnsinoMedio;
	private Window indexRelatorioMatricula;
	private Window indexRelatorioHistorico;
	private Window indexSobre;
	private Window indexAjuda;
	
	//Main Aluno
	private Window indexNotasPorPeriodo;
	private Window indexNotasPorEtapa;
	
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void  onClick$blocoMenuItem(){
		if(indexBloco == null)
			indexBloco = (Window)Executions.createComponents("Bloco.zul",divCenter , null);	
		if(indexBloco.isVisible()){
		}else{
			indexBloco.setVisible(true);
		}
	}	
	
	public void  onClick$salaMenuItem(){
		if(indexSala == null)
			indexSala = (Window)Executions.createComponents("Sala.zul",divCenter , null);	
		if(indexSala.isVisible()){
		}else{
			indexSala.setVisible(true);
		}
	}
	
	public void  onClick$serieMenuItem(){
		if(indexSerie == null)
			indexSerie = (Window)Executions.createComponents("Serie.zul",divCenter , null);	
		if(indexSerie.isVisible()){
		}else{
			indexSerie.setVisible(true);
		}
	}
	
	public void  onClick$disciplinaMenuItem(){
		if(indexDisciplina == null)
			indexDisciplina = (Window)Executions.createComponents("Disciplina.zul",divCenter , null);	
		if(indexDisciplina.isVisible()){
		}else{
			indexDisciplina.setVisible(true);
		}
	}
	
	public void  onClick$turmaMenuItem(){
		if(indexTurma == null)
			indexTurma = (Window)Executions.createComponents("Turma.zul",divCenter , null);	
		if(indexTurma.isVisible()){
		}else{
			indexTurma.setVisible(true);
		}
	}
	
	public void  onClick$funcionarioMenuItem(){
		if(indexFuncionario == null)
			indexFuncionario = (Window)Executions.createComponents("Funcionario.zul",divCenter , null);	
		if(indexFuncionario.isVisible()){
		}else{
			indexFuncionario.setVisible(true);
		}
	}
	
	public void  onClick$professorMenuItem(){
		if(indexProfessor == null)
			indexProfessor = (Window)Executions.createComponents("Professor.zul",divCenter , null);	
		if(indexProfessor.isVisible()){
		}else{
			indexProfessor.setVisible(true);
		}
	}
	
	public void  onClick$nivelMenuItem(){
		if(indexNivelEscolar == null)
			indexNivelEscolar = (Window)Executions.createComponents("NivelEscolar.zul",divCenter , null);	
		if(indexNivelEscolar.isVisible()){
		}else{
			indexNivelEscolar.setVisible(true);
		}
	}
	
	public void  onClick$anoLetivoMenuItem(){
		if(indexAnoLetivo == null)
			indexAnoLetivo = (Window)Executions.createComponents("AnoLetivo.zul",divCenter , null);	
		if(indexAnoLetivo.isVisible()){
		}else{
			indexAnoLetivo.setVisible(true);
		}
	}
	
	public void  onClick$tiposUsuarioMenuItem(){
		if(indexTipoDeUsuario == null)
			indexTipoDeUsuario = (Window)Executions.createComponents("TipoDeUsuario.zul",divCenter , null);	
		if(indexTipoDeUsuario.isVisible()){
		}else{
			indexTipoDeUsuario.setVisible(true);
		}
	}
	
	public void  onClick$permissaoMenuItem(){
		if(indexPermissao == null)
			indexPermissao = (Window)Executions.createComponents("Permissao.zul",divCenter , null);
		if(indexPermissao.isVisible()){
		}else{
			indexPermissao.setVisible(true);
		}
	}
	
	public void  onClick$ocorrenciaMenuItem(){
		if(indexOcorrencia == null)
			indexOcorrencia = (Window)Executions.createComponents("Ocorrencia.zul",divCenter , null);	
		if(indexOcorrencia.isVisible()){
		}else{
			indexOcorrencia.setVisible(true);
		}
	}
	
	public void  onClick$afastamentoMenuItem(){
		if(indexAfastamento == null)
			indexAfastamento = (Window)Executions.createComponents("Afastamento.zul",divCenter , null);	
		if(indexAfastamento.isVisible()){
		}else{
			indexAfastamento.setVisible(true);
		}
	}
	
	public void  onClick$alunoMenuItem(){
		if(indexAluno == null)
			indexAluno = (Window)Executions.createComponents("Aluno.zul",divCenter , null);	
		if(indexAluno.isVisible()){
		}else{
			indexAluno.setVisible(true);
		}
	}
	
	public void onClick$registroDeDisciplinaMenuItem(){
		if(indexRegistroDeDisciplina == null)
			indexRegistroDeDisciplina = (Window)Executions.createComponents("RegistroDeDisciplina.zul",divCenter , null);	
		if(indexRegistroDeDisciplina.isVisible()){
		}else{
			indexRegistroDeDisciplina.setVisible(true);
		}
	}
	
	public void onClick$notasMenuItem(){
		if(indexResultado == null)
			indexResultado = (Window)Executions.createComponents("Resultado.zul",divCenter , null);	
		if(indexResultado.isVisible()){
		}else{
			indexResultado.setVisible(true);
		}
	}
	
	public void onClick$resultadoFinalMenuItem(){
		if(indexResultadoFinal == null)
			indexResultadoFinal = (Window)Executions.createComponents("ResultadoFinal.zul",divCenter , null);	
		if(indexResultadoFinal.isVisible()){
		}else{
			indexResultadoFinal.setVisible(true);
		}
	}

	public void onClick$registroDeAulaMenuItem(){
		if(indexRegistroDeAula == null)
			indexRegistroDeAula = (Window)Executions.createComponents("RegistroDeAula.zul",divCenter , null);	
		if(indexRegistroDeAula.isVisible()){
		}else{
			indexRegistroDeAula.setVisible(true);
		}
	}
	
	public void onClick$frequenciaMenuItem(){
		if(indexFrequencia == null)
			indexFrequencia = (Window)Executions.createComponents("Frequencia.zul",divCenter , null);	
		if(indexFrequencia.isVisible()){
		}else{
			indexFrequencia.setVisible(true);
		}
	}
	
	public void onClick$avaliacaoMenuItem(){
		if(indexAvaliacao == null)
			indexAvaliacao = (Window)Executions.createComponents("Avaliacao.zul",divCenter , null);	
		if(indexAvaliacao.isVisible()){
		}else{
			indexAvaliacao.setVisible(true);
		}
	}
	
	public void onClick$renovacaoDeMatriculaMenuItem(){
		if(indexRenovacaoDeMatricula == null)
			indexRenovacaoDeMatricula = (Window)Executions.createComponents("RenovacaoDeMatricula.zul",divCenter , null);	
		if(indexRenovacaoDeMatricula.isVisible()){
		}else{
			indexRenovacaoDeMatricula.setVisible(true);
		}
	}
	
	public void onClick$outrosVinculosMenuItem(){
		if(indexOutrosVinculos == null)
			indexOutrosVinculos = (Window)Executions.createComponents("OutrosVinculos.zul",divCenter , null);	
		if(indexOutrosVinculos.isVisible()){
		}else{
			indexOutrosVinculos.setVisible(true);
		}
	}
	
	public void onClick$formacaoMenuItem(){
		if(indexFormacao == null)
			indexFormacao = (Window)Executions.createComponents("Formacao.zul",divCenter , null);	
		if(indexFormacao.isVisible()){
		}else{
			indexFormacao.setVisible(true);
		}
	}
	
	public void onClick$EnsinoFundamentalItem(){
		if(indexAtaResultadoFundamental == null)
			indexAtaResultadoFundamental = (Window)Executions.createComponents("AtaResultadoEnsinoFundamental.zul",divCenter , null);	
		if(indexAtaResultadoFundamental.isVisible()){
		}else{
			indexAtaResultadoFundamental.setVisible(true);
		}
	}
	
	public void onClick$EnsinoMedioItem(){
		if(indexAtaResultadoMedio == null)
			indexAtaResultadoMedio = (Window)Executions.createComponents("AtaResultadoEnsinoMedio.zul",divCenter , null);	
		if(indexAtaResultadoMedio.isVisible()){
		}else{
			indexAtaResultadoMedio.setVisible(true);
		}
	}
	
	public void onClick$FichaEnsinoMedioItem(){
		if(indexFichaIndividualEnsinoMedio == null)
			indexFichaIndividualEnsinoMedio = (Window)Executions.createComponents("FichaIndividualEnsinoMedio.zul",divCenter , null);	
		if(indexFichaIndividualEnsinoMedio.isVisible()){
		}else{
			indexFichaIndividualEnsinoMedio.setVisible(true);
		}
	}
	
	public void onClick$NotasPorEtapaMenuItem(){
		if(indexNotasPorEtapa == null)
			indexNotasPorEtapa = (Window)Executions.createComponents("NotasPorEtapa.zul",divCenter , null);
		if(indexNotasPorEtapa.isVisible()){
		}else{
			indexNotasPorEtapa.setVisible(true);
		}
	}
	
	public void onClick$NotasPorPeriodoMenuItem(){
		if(indexNotasPorPeriodo == null)
			indexNotasPorPeriodo = (Window)Executions.createComponents("NotasPorPeriodo.zul",divCenter , null);	
		if(indexNotasPorPeriodo.isVisible()){
		}else{
			indexNotasPorPeriodo.setVisible(true);
		}
	}

	public void onClick$matriculaMenuItem(){
		if(indexRelatorioMatricula == null)
			indexRelatorioMatricula = (Window)Executions.createComponents("MatriculaRelatorio.zul",divCenter , null);	
		if(indexRelatorioMatricula.isVisible()){
		}else{
			indexRelatorioMatricula.setVisible(true);
		}
	}
	
	public void onClick$historicoMenuItem(){
		if(indexRelatorioHistorico == null)
			indexRelatorioHistorico = (Window)Executions.createComponents("HistoricoRelatorio.zul",divCenter , null);	
		if(indexRelatorioHistorico.isVisible()){
		}else{
			indexRelatorioHistorico.setVisible(true);
		}
	}

	public void onClick$ajudaMenuItem(){
		if(indexAjuda == null)
			indexAjuda = (Window)Executions.createComponents("Ajuda.zul",divCenter , null);	
		if(indexAjuda.isVisible()){
		}else{
			indexAjuda.setVisible(true);
		}
	}
	
	public void onClick$sobreMenuItem(){
		if(indexSobre == null)
			indexSobre = (Window)Executions.createComponents("Sobre.zul",divCenter , null);	
		if(indexSobre.isVisible()){
		}else{
			indexSobre.setVisible(true);
		}
	}

}
