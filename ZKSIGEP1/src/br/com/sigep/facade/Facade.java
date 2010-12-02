package br.com.sigep.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zk.ui.util.GenericForwardComposer;


import br.com.sigep.bean.*;
import br.com.sigep.blo.*;

public class Facade extends GenericForwardComposer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Facade instance;
	
	public static Facade getInstance() {
		if(instance == null) {
		    ApplicationContext ctx = null;
		    ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		    instance = (Facade) ctx.getBean("Facade");
		}
		return instance;
	}

	//ResultadoFinal--------------------------------------------------------------
	private ResultadoFinalBloInterface  resultadoFinalBlo;
	public void setResultadoFinalBlo(ResultadoFinalBloInterface blo) {
		this.resultadoFinalBlo = blo;
	}
	public ResultadoFinalBloInterface getResultadoFinalBlo() {
		return this.resultadoFinalBlo;
	}
	
	public void salvarResultadoFinal(ResultadoFinal newInstance) {
		resultadoFinalBlo.salvarResultadoFinal(newInstance);
	}

	public void atualizarResultadoFinal(ResultadoFinal transientObject) {
		resultadoFinalBlo.atualizarResultadoFinal(transientObject);
	}

	public ResultadoFinal carregarResultadoFinal(long id) {
		return resultadoFinalBlo.carregarResultadoFinal(id);
	}

	public List<ResultadoFinal> listarResultadoFinal() {
		return resultadoFinalBlo.listarResultadoFinal();
	}
	
	public List<ResultadoFinal> listarNotasPorPeriodo(long idAluno, long idTurma) {
		return resultadoFinalBlo.listarNotasPorPeriodo(idAluno, idTurma);
	}
	
	public void removerResultadoFinal(ResultadoFinal persistentObject) {
		resultadoFinalBlo.removerResultadoFinal(persistentObject);
	}

	public void removerResultadoFinal(long id) {
		resultadoFinalBlo.removerResultadoFinal(id);
	}
	

	//OutrosVinculos--------------------------------------------------------------
	private OutrosVinculosBloInterface  outrosVinculosBlo;
	public void setOutrosVinculosBlo(OutrosVinculosBloInterface blo) {
		this.outrosVinculosBlo = blo;
	}
	public OutrosVinculosBloInterface getOutrosVinculosBlo() {
		return this.outrosVinculosBlo;
	}
	
	public void salvarOutrosVinculos(OutrosVinculos newInstance) {
		outrosVinculosBlo.salvarOutrosVinculos(newInstance);
	}

	public void atualizarOutrosVinculos(OutrosVinculos transientObject) {
		outrosVinculosBlo.atualizarOutrosVinculos(transientObject);
	}

	public OutrosVinculos carregarOutrosVinculos(long id) {
		return outrosVinculosBlo.carregarOutrosVinculos(id);
	}

	public List<OutrosVinculos> listarOutrosVinculos() {
		return outrosVinculosBlo.listarOutrosVinculos();
	}
	
	public List<OutrosVinculos> listarOutrosVinculosFuncionario(
			long idFuncionario) {
		return outrosVinculosBlo.listarOutrosVinculosFuncionario(idFuncionario);
	}
	public void removerOutrosVinculos(OutrosVinculos persistentObject) {
		outrosVinculosBlo.removerOutrosVinculos(persistentObject);
	}

	public void removerOutrosVinculos(long id) {
		outrosVinculosBlo.removerOutrosVinculos(id);
	}
	

	//Avaliacao--------------------------------------------------------------
	private AvaliacaoBloInterface  avaliacaoBlo;
	public void setAvaliacaoBlo(AvaliacaoBloInterface blo) {
		this.avaliacaoBlo = blo;
	}
	public AvaliacaoBloInterface getAvaliacaoBlo() {
		return this.avaliacaoBlo;
	}
	
	public void salvarAvaliacao(Avaliacao newInstance) {
		avaliacaoBlo.salvarAvaliacao(newInstance);
	}

	public void atualizarAvaliacao(Avaliacao transientObject) {
		avaliacaoBlo.atualizarAvaliacao(transientObject);
	}

	public Avaliacao carregarAvaliacao(long id) {
		return avaliacaoBlo.carregarAvaliacao(id);
	}

	public List<Avaliacao> listarAvaliacao() {
		return avaliacaoBlo.listarAvaliacao();
	}	

	public List<Avaliacao> listarAvaliacaoFiltro(String descricao) {
		return avaliacaoBlo.listarAvaliacaoFiltro(descricao);
	}
	
	public void removerAvaliacao(Avaliacao persistentObject) {
		avaliacaoBlo.removerAvaliacao(persistentObject);
	}

	public void removerAvaliacao(long id) {
		avaliacaoBlo.removerAvaliacao(id);
	}
	

	//Aluno--------------------------------------------------------------
	private AlunoBloInterface  alunoBlo;
	public void setAlunoBlo(AlunoBloInterface blo) {
		this.alunoBlo = blo;
	}
	public AlunoBloInterface getAlunoBlo() {
		return this.alunoBlo;
	}
	
	public void salvarAluno(Aluno newInstance) {
		alunoBlo.salvarAluno(newInstance);
	}

	public void atualizarAluno(Aluno transientObject) {
		alunoBlo.atualizarAluno(transientObject);
	}

	public Aluno carregarAluno(long id) {
		return alunoBlo.carregarAluno(id);
	}

	public List<Aluno> listarAluno() {
		return alunoBlo.listarAluno();
	}
	
	
	public Aluno procurarAlunoPorRg(String rg) {
		return alunoBlo.procurarAlunoPorRg(rg);
	}	
	
	public Aluno procurarAlunoPorLogin(String login) {
		return alunoBlo.procurarAlunoPorLogin(login);
	}

	public Aluno procurarAlunoPorCPF(String cpf) {
		return alunoBlo.procurarAlunoPorCPF(cpf);
	}
	
	public List<Aluno> listarAlunoFiltro(String nome) {
		return alunoBlo.listarAlunoFiltro(nome);
	}
	
	public void removerAluno(Aluno persistentObject) {
		alunoBlo.removerAluno(persistentObject);
	}

	public void removerAluno(long id) {
		alunoBlo.removerAluno(id);
	}
	

	//Bloco--------------------------------------------------------------
	private BlocoBloInterface  blocoBlo;
	public void setBlocoBlo(BlocoBloInterface blo) {
		this.blocoBlo = blo;
	}
	public BlocoBloInterface getBlocoBlo() {
		return this.blocoBlo;
	}
	
	public void salvarBloco(Bloco newInstance) {
		blocoBlo.salvarBloco(newInstance);
	}

	public void atualizarBloco(Bloco transientObject) {
		blocoBlo.atualizarBloco(transientObject);
	}

	public Bloco carregarBloco(long id) {
		return blocoBlo.carregarBloco(id);
	}

	public List<Bloco> listarBloco() {
		return blocoBlo.listarBloco();
	}
	
	public List<Bloco> listarBlocoFiltro(String descricao){
		return blocoBlo.listarBlocoFiltro(descricao);
	}
	
	public void removerBloco(Bloco persistentObject) {
		blocoBlo.removerBloco(persistentObject);
	}

	public void removerBloco(long id) {
		blocoBlo.removerBloco(id);
	}
	

	//Permissao--------------------------------------------------------------
	private PermissaoBloInterface  permissaoBlo;
	public void setPermissaoBlo(PermissaoBloInterface blo) {
		this.permissaoBlo = blo;
	}
	public PermissaoBloInterface getPermissaoBlo() {
		return this.permissaoBlo;
	}
	
	public void salvarPermissao(Permissao newInstance) {
		permissaoBlo.salvarPermissao(newInstance);
	}

	public void atualizarPermissao(Permissao transientObject) {
		permissaoBlo.atualizarPermissao(transientObject);
	}

	public Permissao carregarPermissao(long id) {
		return permissaoBlo.carregarPermissao(id);
	}

	public List<Permissao> listarPermissao() {
		return permissaoBlo.listarPermissao();
	}

	public void removerPermissao(Permissao persistentObject) {
		permissaoBlo.removerPermissao(persistentObject);
	}
	
	public List<Permissao> listarPermissaoFiltro(int descricao) {
		return permissaoBlo.listarPermissaoFiltro(descricao);
	}
	
	public void removerPermissao(long id) {
		permissaoBlo.removerPermissao(id);
	}
	

	//Ocorrencia--------------------------------------------------------------
	private OcorrenciaBloInterface  ocorrenciaBlo;
	public void setOcorrenciaBlo(OcorrenciaBloInterface blo) {
		this.ocorrenciaBlo = blo;
	}
	public OcorrenciaBloInterface getOcorrenciaBlo() {
		return this.ocorrenciaBlo;
	}
	
	public void salvarOcorrencia(Ocorrencia newInstance) {
		ocorrenciaBlo.salvarOcorrencia(newInstance);
	}

	public void atualizarOcorrencia(Ocorrencia transientObject) {
		ocorrenciaBlo.atualizarOcorrencia(transientObject);
	}

	public Ocorrencia carregarOcorrencia(long id) {
		return ocorrenciaBlo.carregarOcorrencia(id);
	}

	public List<Ocorrencia> listarOcorrencia() {
		return ocorrenciaBlo.listarOcorrencia();
	}
	
	public List<Ocorrencia> listarOcorrenciaFiltro(String descricao) {
		return ocorrenciaBlo.listarOcorrenciaFiltro(descricao);
	}
	
	public void removerOcorrencia(Ocorrencia persistentObject) {
		ocorrenciaBlo.removerOcorrencia(persistentObject);
	}

	public void removerOcorrencia(long id) {
		ocorrenciaBlo.removerOcorrencia(id);
	}
	

	//Serie--------------------------------------------------------------
	private SerieBloInterface  serieBlo;
	public void setSerieBlo(SerieBloInterface blo) {
		this.serieBlo = blo;
	}
	public SerieBloInterface getSerieBlo() {
		return this.serieBlo;
	}
	
	public void salvarSerie(Serie newInstance) {
		serieBlo.salvarSerie(newInstance);
	}

	public void atualizarSerie(Serie transientObject) {
		serieBlo.atualizarSerie(transientObject);
	}

	public Serie carregarSerie(long id) {
		return serieBlo.carregarSerie(id);
	}

	public List<Serie> listarSerie() {
		return serieBlo.listarSerie();
	}
	
	public List<Serie> listarSerieNivel(long id) {
		return serieBlo.listarSerieNivel(id);
	}
	
	public List<Serie> listarSerieFiltro(String descricao) {
		return serieBlo.listarSerieFiltro(descricao);
	}
	
	public void removerSerie(Serie persistentObject) {
		serieBlo.removerSerie(persistentObject);
	}

	public void removerSerie(long id) {
		serieBlo.removerSerie(id);
	}
	

	//Disciplina--------------------------------------------------------------
	private DisciplinaBloInterface  disciplinaBlo;
	public void setDisciplinaBlo(DisciplinaBloInterface blo) {
		this.disciplinaBlo = blo;
	}
	public DisciplinaBloInterface getDisciplinaBlo() {
		return this.disciplinaBlo;
	}
	
	public void salvarDisciplina(Disciplina newInstance) {
		disciplinaBlo.salvarDisciplina(newInstance);
	}

	public void atualizarDisciplina(Disciplina transientObject) {
		disciplinaBlo.atualizarDisciplina(transientObject);
	}

	public Disciplina carregarDisciplina(long id) {
		return disciplinaBlo.carregarDisciplina(id);
	}

	public List<Disciplina> listarDisciplina() {
		return disciplinaBlo.listarDisciplina();
	}

	public List<Disciplina> listarDisciplinaSerie(long serie) {
		return disciplinaBlo.listarDisciplinaSerie(serie);
	}
		
	public List<Disciplina> listarDisciplinaFiltro(String nome) {
		return disciplinaBlo.listarDisciplinaFiltro(nome);
	}
	
	public void removerDisciplina(Disciplina persistentObject) {
		disciplinaBlo.removerDisciplina(persistentObject);
	}

	public void removerDisciplina(long id) {
		disciplinaBlo.removerDisciplina(id);
	}
	

	//AnoLetivo--------------------------------------------------------------
	private AnoLetivoBloInterface  anoLetivoBlo;
	public void setAnoLetivoBlo(AnoLetivoBloInterface blo) {
		this.anoLetivoBlo = blo;
	}
	public AnoLetivoBloInterface getAnoLetivoBlo() {
		return this.anoLetivoBlo;
	}
	
	public void salvarAnoLetivo(AnoLetivo newInstance) {
		anoLetivoBlo.salvarAnoLetivo(newInstance);
	}

	public void atualizarAnoLetivo(AnoLetivo transientObject) {
		anoLetivoBlo.atualizarAnoLetivo(transientObject);
	}

	public AnoLetivo carregarAnoLetivo(long id) {
		return anoLetivoBlo.carregarAnoLetivo(id);
	}

	public List<AnoLetivo> listarAnoLetivo() {
		return anoLetivoBlo.listarAnoLetivo();
	}
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(long idAluno) {
		return anoLetivoBlo.listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(idAluno);
	}
	
	public List<AnoLetivo> listarAnoLetivoPorMatriculaAluno(long idAluno) {
		return anoLetivoBlo.listarAnoLetivoPorMatriculaAluno(idAluno);
	}
	
	public List<AnoLetivo> listarAnoLetivoFiltro(int descricao) {
		return anoLetivoBlo.listarAnoLetivoFiltro(descricao);
	}
	
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoFoiMatriculado(
			long idAluno) {
		return anoLetivoBlo.listarAnoLetivoNosQuaisOAlunoFoiMatriculado(idAluno);
	}
	public void removerAnoLetivo(AnoLetivo persistentObject) {
		anoLetivoBlo.removerAnoLetivo(persistentObject);
	}

	public void removerAnoLetivo(long id) {
		anoLetivoBlo.removerAnoLetivo(id);
	}
	

	//Professor--------------------------------------------------------------
	private ProfessorBloInterface  professorBlo;
	public void setProfessorBlo(ProfessorBloInterface blo) {
		this.professorBlo = blo;
	}
	public ProfessorBloInterface getProfessorBlo() {
		return this.professorBlo;
	}
	
	public void salvarProfessor(Professor newInstance) {
		professorBlo.salvarProfessor(newInstance);
	}

	public void atualizarProfessor(Professor transientObject) {
		professorBlo.atualizarProfessor(transientObject);
	}

	public Professor carregarProfessor(long id) {
		return professorBlo.carregarProfessor(id);
	}

	public List<Professor> listarProfessor() {
		return professorBlo.listarProfessor();
	}
	
	public List<Professor> listarProfessorFiltro(String nome) {
		return professorBlo.listarProfessorFiltro(nome);
	}
		
	public Professor procurarProfessorPorCPF(String cpf) {
		return professorBlo.procurarProfessorPorCPF(cpf);
	}
	
	public Professor procurarProfessorPorRg(String rg) {
		return professorBlo.procurarProfessorPorRg(rg);
	}
	
	public void removerProfessor(Professor persistentObject) {
		professorBlo.removerProfessor(persistentObject);
	}

	public void removerProfessor(long id) {
		professorBlo.removerProfessor(id);
	}
	

	//Matricula--------------------------------------------------------------
	private MatriculaBloInterface  matriculaBlo;
	public void setMatriculaBlo(MatriculaBloInterface blo) {
		this.matriculaBlo = blo;
	}
	public MatriculaBloInterface getMatriculaBlo() {
		return this.matriculaBlo;
	}
	
	public void salvarMatricula(Matricula newInstance) {
		matriculaBlo.salvarMatricula(newInstance);
	}

	public void atualizarMatricula(Matricula transientObject) {
		matriculaBlo.atualizarMatricula(transientObject);
	}

	public Matricula carregarMatricula(long id) {
		return matriculaBlo.carregarMatricula(id);
	}

	public List<Matricula> listarMatricula() {
		return matriculaBlo.listarMatricula();
	}
	
	
	
	public List<Matricula> listarMatriculaAlunoRG(String rg) {
		return matriculaBlo.listarMatriculaAlunoRG(rg);
	}
	public List<Matricula> listarMatriculaAluno(long id) {
		return matriculaBlo.listarMatriculaAluno(id);
	}
	
	public Matricula procurarMatriculaPorAlunoEAno(long aluno, long ano) {
		return matriculaBlo.procurarMatriculaPorAlunoEAno(aluno, ano);
	}

	public void removerMatricula(Matricula persistentObject) {
		matriculaBlo.removerMatricula(persistentObject);
	}

	public void removerMatricula(long id) {
		matriculaBlo.removerMatricula(id);
	}

	//Resultado--------------------------------------------------------------
	private ResultadoBloInterface  resultadoBlo;
	public void setResultadoBlo(ResultadoBloInterface blo) {
		this.resultadoBlo = blo;
	}
	public ResultadoBloInterface getResultadoBlo() {
		return this.resultadoBlo;
	}
	
	public void salvarResultado(Resultado newInstance) {
		resultadoBlo.salvarResultado(newInstance);
	}

	public void atualizarResultado(Resultado transientObject) {
		resultadoBlo.atualizarResultado(transientObject);
	}

	public Resultado carregarResultado(long id) {
		return resultadoBlo.carregarResultado(id);
	}

	public List<Resultado> listarResultado() {
		return resultadoBlo.listarResultado();
	}
	
	public List<Resultado> listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(
			long idAluno, long idRegistro, String periodo, String etapa) {
		return resultadoBlo
				.listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(
						idAluno, idRegistro, periodo, etapa);
	}
	
	public void removerResultado(Resultado persistentObject) {
		resultadoBlo.removerResultado(persistentObject);
	}

	public void removerResultado(long id) {
		resultadoBlo.removerResultado(id);
	}
	

	//Registro--------------------------------------------------------------
	private RegistroBloInterface  registroBlo;
	public void setRegistroBlo(RegistroBloInterface blo) {
		this.registroBlo = blo;
	}
	public RegistroBloInterface getRegistroBlo() {
		return this.registroBlo;
	}
	
	public void salvarRegistro(Registro newInstance) {
		registroBlo.salvarRegistro(newInstance);
	}

	public void atualizarRegistro(Registro transientObject) {
		registroBlo.atualizarRegistro(transientObject);
	}

	public Registro carregarRegistro(long id) {
		return registroBlo.carregarRegistro(id);
	}

	public List<Registro> listarRegistro() {
		return registroBlo.listarRegistro();
	}

	public void removerRegistro(Registro persistentObject) {
		registroBlo.removerRegistro(persistentObject);
	}

	public void removerRegistro(long id) {
		registroBlo.removerRegistro(id);
	}
	

	//Afastamento--------------------------------------------------------------
	private AfastamentoBloInterface  afastamentoBlo;
	public void setAfastamentoBlo(AfastamentoBloInterface blo) {
		this.afastamentoBlo = blo;
	}
	public AfastamentoBloInterface getAfastamentoBlo() {
		return this.afastamentoBlo;
	}
	
	public void salvarAfastamento(Afastamento newInstance) {
		afastamentoBlo.salvarAfastamento(newInstance);
	}

	public void atualizarAfastamento(Afastamento transientObject) {
		afastamentoBlo.atualizarAfastamento(transientObject);
	}

	public Afastamento carregarAfastamento(long id) {
		return afastamentoBlo.carregarAfastamento(id);
	}

	public List<Afastamento> listarAfastamento() {
		return afastamentoBlo.listarAfastamento();
	}
	
	public List<Afastamento> listarAfastamentoFiltro(String descricao) {
		return afastamentoBlo.listarAfastamentoFiltro(descricao);
	}
	
	public void removerAfastamento(Afastamento persistentObject) {
		afastamentoBlo.removerAfastamento(persistentObject);
	}

	public void removerAfastamento(long id) {
		afastamentoBlo.removerAfastamento(id);
	}
	

	//NivelEscolar--------------------------------------------------------------
	private NivelEscolarBloInterface  nivelEscolarBlo;
	public void setNivelEscolarBlo(NivelEscolarBloInterface blo) {
		this.nivelEscolarBlo = blo;
	}
	public NivelEscolarBloInterface getNivelEscolarBlo() {
		return this.nivelEscolarBlo;
	}
	
	public void salvarNivelEscolar(NivelEscolar newInstance) {
		nivelEscolarBlo.salvarNivelEscolar(newInstance);
	}

	public void atualizarNivelEscolar(NivelEscolar transientObject) {
		nivelEscolarBlo.atualizarNivelEscolar(transientObject);
	}

	public NivelEscolar carregarNivelEscolar(long id) {
		return nivelEscolarBlo.carregarNivelEscolar(id);
	}
	
	public List<NivelEscolar> listarNivelFiltro(String descricao) {
		return nivelEscolarBlo.listarNivelFiltro(descricao);
	}
	
	public List<NivelEscolar> listarNivelPorAnoLetivo(long idAno) {
		return nivelEscolarBlo.listarNivelPorAnoLetivo(idAno);
	}
	public List<NivelEscolar> listarNivelEscolar() {
		return nivelEscolarBlo.listarNivelEscolar();
	}

	public void removerNivelEscolar(NivelEscolar persistentObject) {
		nivelEscolarBlo.removerNivelEscolar(persistentObject);
	}

	public void removerNivelEscolar(long id) {
		nivelEscolarBlo.removerNivelEscolar(id);
	}
	

	//Sala--------------------------------------------------------------
	private SalaBloInterface  salaBlo;
	public void setSalaBlo(SalaBloInterface blo) {
		this.salaBlo = blo;
	}
	public SalaBloInterface getSalaBlo() {
		return this.salaBlo;
	}
	
	public void salvarSala(Sala newInstance) {
		salaBlo.salvarSala(newInstance);
	}

	public void atualizarSala(Sala transientObject) {
		salaBlo.atualizarSala(transientObject);
	}

	public Sala carregarSala(long id) {
		return salaBlo.carregarSala(id);
	}

	public List<Sala> listarSala() {
		return salaBlo.listarSala();
	}
	
	public List<Sala> listarSalaFiltro(String descricao) {
		return salaBlo.listarSalaFiltro(descricao);
	}
	
	
	public List<Sala> listarSalaPorAnoETurno(long idAno, String turno) {
		List <Sala>  listaSala= new ArrayList<Sala>();
		long idSala = 0;
		for (Sala s : Facade.getInstance().listarSala()){
			for(Turma t : Facade.getInstance().listarTurma()){
				if(s.getId() != t.getSala().getId() && t.getTurno().equalsIgnoreCase(turno) && t.getAnoLetivo().getId() == idAno && idSala != s.getId()){
					 listaSala.add(s);
				}
				idSala = s.getId();
			}
			
		}
		return listaSala;
	}
	
	public void removerSala(Sala persistentObject) {
		salaBlo.removerSala(persistentObject);
	}

	public void removerSala(long id) {
		salaBlo.removerSala(id);
	}
	

	//Turma--------------------------------------------------------------
	private TurmaBloInterface  turmaBlo;
	public void setTurmaBlo(TurmaBloInterface blo) {
		this.turmaBlo = blo;
	}
	public TurmaBloInterface getTurmaBlo() {
		return this.turmaBlo;
	}
	
	public void salvarTurma(Turma newInstance) {
		turmaBlo.salvarTurma(newInstance);
	}

	public void atualizarTurma(Turma transientObject) {
		turmaBlo.atualizarTurma(transientObject);
	}

	public Turma carregarTurma(long id) {
		return turmaBlo.carregarTurma(id);
	}

	public List<Turma> listarTurma() {
		return turmaBlo.listarTurma();
	}	

	public List<Turma> listarTurmaSerie(long id, long idAno) {
		return turmaBlo.listarTurmaSerie(id, idAno);
	}	
		
	public List<Turma> listarTurmaSerieTurno(long id, String turno) {
		return turmaBlo.listarTurmaSerieTurno(id, turno);
	}
	public void removerTurma(Turma persistentObject) {
		turmaBlo.removerTurma(persistentObject);
	}

	public void removerTurma(long id) {
		turmaBlo.removerTurma(id);
	}
		
	public List<Turma> listarTurmaFiltro(String nome) {
		return turmaBlo.listarTurmaFiltro(nome);
	}
	
	public List<Aluno> listarAlunoTurma(long turma){
		
		List<Aluno> listaDeAluno = new ArrayList<Aluno>();
		
		for(Aluno a1: Facade.getInstance().listarAluno()){
			for(Matricula m1 : a1.getMatricula()){
				if(turma == m1.getTurma().getId()){
					listaDeAluno.add(a1);
				}
			}
		}
		return listaDeAluno;
	}

	//Formacao--------------------------------------------------------------
	private FormacaoBloInterface  formacaoBlo;
	public void setFormacaoBlo(FormacaoBloInterface blo) {
		this.formacaoBlo = blo;
	}
	public FormacaoBloInterface getFormacaoBlo() {
		return this.formacaoBlo;
	}
	
	public void salvarFormacao(Formacao newInstance) {
		formacaoBlo.salvarFormacao(newInstance);
	}

	public void atualizarFormacao(Formacao transientObject) {
		formacaoBlo.atualizarFormacao(transientObject);
	}

	public Formacao carregarFormacao(long id) {
		return formacaoBlo.carregarFormacao(id);
	}

	public List<Formacao> listarFormacao() {
		return formacaoBlo.listarFormacao();
	}
	

	public List<Formacao> listarFormacaoFuncionario(long idFuncionario) {
		return formacaoBlo.listarFormacaoFuncionario(idFuncionario);
	}
	public void removerFormacao(Formacao persistentObject) {
		formacaoBlo.removerFormacao(persistentObject);
	}

	public void removerFormacao(long id) {
		formacaoBlo.removerFormacao(id);
	}
	

	//RecomendacoesMedicas--------------------------------------------------------------
	private RecomendacoesMedicasBloInterface  recomendacoesMedicasBlo;
	public void setRecomendacoesMedicasBlo(RecomendacoesMedicasBloInterface blo) {
		this.recomendacoesMedicasBlo = blo;
	}
	public RecomendacoesMedicasBloInterface getRecomendacoesMedicasBlo() {
		return this.recomendacoesMedicasBlo;
	}
	
	public void salvarRecomendacoesMedicas(RecomendacoesMedicas newInstance) {
		recomendacoesMedicasBlo.salvarRecomendacoesMedicas(newInstance);
	}

	public void atualizarRecomendacoesMedicas(RecomendacoesMedicas transientObject) {
		recomendacoesMedicasBlo.atualizarRecomendacoesMedicas(transientObject);
	}

	public RecomendacoesMedicas carregarRecomendacoesMedicas(long id) {
		return recomendacoesMedicasBlo.carregarRecomendacoesMedicas(id);
	}

	public List<RecomendacoesMedicas> listarRecomendacoesMedicas() {
		return recomendacoesMedicasBlo.listarRecomendacoesMedicas();
	}

	public void removerRecomendacoesMedicas(RecomendacoesMedicas persistentObject) {
		recomendacoesMedicasBlo.removerRecomendacoesMedicas(persistentObject);
	}

	public void removerRecomendacoesMedicas(long id) {
		recomendacoesMedicasBlo.removerRecomendacoesMedicas(id);
	}
	

	//Frequencia--------------------------------------------------------------
	private FrequenciaBloInterface  frequenciaBlo;
	public void setFrequenciaBlo(FrequenciaBloInterface blo) {
		this.frequenciaBlo = blo;
	}
	public FrequenciaBloInterface getFrequenciaBlo() {
		return this.frequenciaBlo;
	}
	
	public void salvarFrequencia(Frequencia newInstance) {
		frequenciaBlo.salvarFrequencia(newInstance);
	}

	public void atualizarFrequencia(Frequencia transientObject) {
		frequenciaBlo.atualizarFrequencia(transientObject);
	}

	public Frequencia carregarFrequencia(long id) {
		return frequenciaBlo.carregarFrequencia(id);
	}

	public List<Frequencia> listarFrequencia() {
		return frequenciaBlo.listarFrequencia();
	}

	public void removerFrequencia(Frequencia persistentObject) {
		frequenciaBlo.removerFrequencia(persistentObject);
	}

	public void removerFrequencia(long id) {
		frequenciaBlo.removerFrequencia(id);
	}
	

	//Usuario--------------------------------------------------------------
	private UsuarioBloInterface  usuarioBlo;
	public void setUsuarioBlo(UsuarioBloInterface blo) {
		this.usuarioBlo = blo;
	}
	public UsuarioBloInterface getUsuarioBlo() {
		return this.usuarioBlo;
	}
	
	public void salvarUsuario(Usuario newInstance) {
		usuarioBlo.salvarUsuario(newInstance);
	}

	public void atualizarUsuario(Usuario transientObject) {
		usuarioBlo.atualizarUsuario(transientObject);
	}

	public Usuario carregarUsuario(long id) {
		return usuarioBlo.carregarUsuario(id);
	}

	public List<Usuario> listarUsuario() {
		return usuarioBlo.listarUsuario();
	}

	public void removerUsuario(Usuario persistentObject) {
		usuarioBlo.removerUsuario(persistentObject);
	}

	public void removerUsuario(long id) {
		usuarioBlo.removerUsuario(id);
	}
	

	//DadosFuncionais--------------------------------------------------------------
	private DadosFuncionaisBloInterface  dadosFuncionaisBlo;
	public void setDadosFuncionaisBlo(DadosFuncionaisBloInterface blo) {
		this.dadosFuncionaisBlo = blo;
	}
	public DadosFuncionaisBloInterface getDadosFuncionaisBlo() {
		return this.dadosFuncionaisBlo;
	}
	
	public void salvarDadosFuncionais(DadosFuncionais newInstance) {
		dadosFuncionaisBlo.salvarDadosFuncionais(newInstance);
	}

	public void atualizarDadosFuncionais(DadosFuncionais transientObject) {
		dadosFuncionaisBlo.atualizarDadosFuncionais(transientObject);
	}

	public DadosFuncionais carregarDadosFuncionais(long id) {
		return dadosFuncionaisBlo.carregarDadosFuncionais(id);
	}

	public List<DadosFuncionais> listarDadosFuncionais() {
		return dadosFuncionaisBlo.listarDadosFuncionais();
	}

	public void removerDadosFuncionais(DadosFuncionais persistentObject) {
		dadosFuncionaisBlo.removerDadosFuncionais(persistentObject);
	}

	public void removerDadosFuncionais(long id) {
		dadosFuncionaisBlo.removerDadosFuncionais(id);
	}
	

	//Funcionario--------------------------------------------------------------
	private FuncionarioBloInterface  funcionarioBlo;
	public void setFuncionarioBlo(FuncionarioBloInterface blo) {
		this.funcionarioBlo = blo;
	}
	
	public FuncionarioBloInterface getFuncionarioBlo() {
		return this.funcionarioBlo;
	}
	
	public void salvarFuncionario(Funcionario newInstance) {
		funcionarioBlo.salvarFuncionario(newInstance);
	}

	public void atualizarFuncionario(Funcionario transientObject) {
		funcionarioBlo.atualizarFuncionario(transientObject);
	}

	public Funcionario carregarFuncionario(long id) {
		return funcionarioBlo.carregarFuncionario(id);
	}
	
	public Funcionario procurarFuncionarioPorRg(String rg) {
		return funcionarioBlo.procurarFuncionarioPorRg(rg);
	}
	
	public Funcionario procurarFuncionarioPorCPF(String cpf) {
		return funcionarioBlo.procurarFuncionarioPorCPF(cpf);
	}
	
	public List<Funcionario> listarFuncionario() {
		return funcionarioBlo.listarFuncionario();
	}
	
	public List<Funcionario> listarFuncionarioFiltro(String nome) {
		return funcionarioBlo.listarFuncionarioFiltro(nome);
	}
	
	public void removerFuncionario(Funcionario persistentObject) {
		funcionarioBlo.removerFuncionario(persistentObject);
	}

	public void removerFuncionario(long id) {
		funcionarioBlo.removerFuncionario(id);
	}
	

	//TipoDeUsuario--------------------------------------------------------------
	private TipoDeUsuarioBloInterface  tipoDeUsuarioBlo;
	public void setTipoDeUsuarioBlo(TipoDeUsuarioBloInterface blo) {
		this.tipoDeUsuarioBlo = blo;
	}
	public TipoDeUsuarioBloInterface getTipoDeUsuarioBlo() {
		return this.tipoDeUsuarioBlo;
	}
	
	public void salvarTipoDeUsuario(TipoDeUsuario newInstance) {
		tipoDeUsuarioBlo.salvarTipoDeUsuario(newInstance);
	}

	public void atualizarTipoDeUsuario(TipoDeUsuario transientObject) {
		tipoDeUsuarioBlo.atualizarTipoDeUsuario(transientObject);
	}

	public TipoDeUsuario carregarTipoDeUsuario(long id) {
		return tipoDeUsuarioBlo.carregarTipoDeUsuario(id);
	}

	public List<TipoDeUsuario> listarTipoDeUsuario() {
		return tipoDeUsuarioBlo.listarTipoDeUsuario();
	}
	
	public List<TipoDeUsuario> listarTipoDeUsuarioFiltro(String descricao) {
		return tipoDeUsuarioBlo.listarTipoDeUsuarioFiltro(descricao);
	}
	
	public void removerTipoDeUsuario(TipoDeUsuario persistentObject) {
		tipoDeUsuarioBlo.removerTipoDeUsuario(persistentObject);
	}

	public void removerTipoDeUsuario(long id) {
		tipoDeUsuarioBlo.removerTipoDeUsuario(id);
	}
	

	//RegistroDeAula--------------------------------------------------------------
	private RegistroDeAulaBloInterface  registroDeAulaBlo;
	public void setRegistroDeAulaBlo(RegistroDeAulaBloInterface blo) {
		this.registroDeAulaBlo = blo;
	}
	public RegistroDeAulaBloInterface getRegistroDeAulaBlo() {
		return this.registroDeAulaBlo;
	}
	
	public void salvarRegistroDeAula(RegistroDeAula newInstance) {
		registroDeAulaBlo.salvarRegistroDeAula(newInstance);
	}

	public void atualizarRegistroDeAula(RegistroDeAula transientObject) {
		registroDeAulaBlo.atualizarRegistroDeAula(transientObject);
	}

	public RegistroDeAula carregarRegistroDeAula(long id) {
		return registroDeAulaBlo.carregarRegistroDeAula(id);
	}

	public List<RegistroDeAula> listarRegistroDeAula() {
		return registroDeAulaBlo.listarRegistroDeAula();
	}

	
	public List<RegistroDeAula> listarRegistroDeAulaFiltro(String assunto) {
		return registroDeAulaBlo.listarRegistroDeAulaFiltro(assunto);
	}
	
	public void removerRegistroDeAula(RegistroDeAula persistentObject) {
		registroDeAulaBlo.removerRegistroDeAula(persistentObject);
	}

	public void removerRegistroDeAula(long id) {
		registroDeAulaBlo.removerRegistroDeAula(id);
	}
	

	//DadosBancarios--------------------------------------------------------------
	private DadosBancariosBloInterface  dadosBancariosBlo;
	public void setDadosBancariosBlo(DadosBancariosBloInterface blo) {
		this.dadosBancariosBlo = blo;
	}
	public DadosBancariosBloInterface getDadosBancariosBlo() {
		return this.dadosBancariosBlo;
	}
	
	public void salvarDadosBancarios(DadosBancarios newInstance) {
		dadosBancariosBlo.salvarDadosBancarios(newInstance);
	}

	public void atualizarDadosBancarios(DadosBancarios transientObject) {
		dadosBancariosBlo.atualizarDadosBancarios(transientObject);
	}

	public DadosBancarios carregarDadosBancarios(long id) {
		return dadosBancariosBlo.carregarDadosBancarios(id);
	}

	public List<DadosBancarios> listarDadosBancarios() {
		return dadosBancariosBlo.listarDadosBancarios();
	}

	public void removerDadosBancarios(DadosBancarios persistentObject) {
		dadosBancariosBlo.removerDadosBancarios(persistentObject);
	}

	public void removerDadosBancarios(long id) {
		dadosBancariosBlo.removerDadosBancarios(id);
	}
	

	//RegistroDeDisciplina--------------------------------------------------------------
	private RegistroDeDisciplinaBloInterface  registroDeDisciplinaBlo;
	public void setRegistroDeDisciplinaBlo(RegistroDeDisciplinaBloInterface blo) {
		this.registroDeDisciplinaBlo = blo;
	}
	public RegistroDeDisciplinaBloInterface getRegistroDeDisciplinaBlo() {
		return this.registroDeDisciplinaBlo;
	}
	
	public void salvarRegistroDeDisciplina(RegistroDeDisciplina newInstance) {
		registroDeDisciplinaBlo.salvarRegistroDeDisciplina(newInstance);
	}

	public void atualizarRegistroDeDisciplina(RegistroDeDisciplina transientObject) {
		registroDeDisciplinaBlo.atualizarRegistroDeDisciplina(transientObject);
	}

	public RegistroDeDisciplina carregarRegistroDeDisciplina(long id) {
		return registroDeDisciplinaBlo.carregarRegistroDeDisciplina(id);
	}

	public List<RegistroDeDisciplina> listarRegistroDeDisciplina() {
		return registroDeDisciplinaBlo.listarRegistroDeDisciplina();
	}

	public void removerRegistroDeDisciplina(RegistroDeDisciplina persistentObject) {
		registroDeDisciplinaBlo.removerRegistroDeDisciplina(persistentObject);
	}

	public void removerRegistroDeDisciplina(long id) {
		registroDeDisciplinaBlo.removerRegistroDeDisciplina(id);
	}
	
	public List<Disciplina> listarDisciplinaTurma(long turma) {
		return registroDeDisciplinaBlo.listarDisciplinaTurma(turma);
	}
	
	public List<RegistroDeDisciplina> listarRegistroDeDisciplinaTurma(long turma) {
		return registroDeDisciplinaBlo.listarRegistroDeDisciplinaTurma(turma);
	}
	
	public void calcularResultadoTurma(Turma t) {
		String[] periodo = {"1º Período", "2º Período"};
		String[] etapa = {"1ª Etapa", "2ª Etapa", "3ª Etapa", "4ª Etapa"};
		
		for(RegistroDeDisciplina disc: listarRegistroDeDisciplinaTurma(t.getId())) {
			for(Aluno a: listarAlunoTurma(t.getId())) {
				float notaFinal = 0;
				ResultadoFinal rf = new ResultadoFinal();
				rf.setAluno(a);
				rf.setRegistroDeDisciplina(disc);
				for(String p: periodo) {
					float notaPeriodo = 0;
					for(String et: etapa) {
						float notaEtapa = 0;
						for(Resultado r: listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(a.getId(), disc.getId(), p, et)) {
							notaEtapa += r.getNota();
						}
						rf.getNotasFinais().put(p + ":" + et, notaEtapa);
						notaPeriodo += notaEtapa;
					}	
					rf.getNotasFinais().put(p , notaPeriodo);
					if(p.equals("1º Período")) {
						rf.setNotaSemestre1(notaPeriodo);
					} else {
						rf.setNotaSemestre2(notaPeriodo);
					}
					notaFinal += notaPeriodo;
				}
				rf.getNotasFinais().put("notaFinal" , notaFinal);
				rf.setNotaFinal(notaFinal);
				salvarResultadoFinal(rf);
				
			}
		}
	}
	
	public Connection getConnection(){
        try {	        	
    		Class.forName("org.postgresql.Driver");
            String driver = "jdbc:postgresql://localhost:5432/zksigep";
            Connection con = DriverManager.getConnection(driver, "sigep", "1234");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	
	/////////////////////////////////////////////////////////////////
	
	
	public boolean validacaoCPF(String cpf){  
	    int     d1, d2;  
	    int     digito1, digito2, resto;  
	    int     digitoCPF;  
	    String  nDigResult;  

	    d1 = d2 = 0;  
	    digito1 = digito2 = resto = 0;  

	    for (int nCount = 1; nCount < cpf.length() -1; nCount++)  
	    {  
	       digitoCPF = Integer.valueOf (cpf.substring(nCount -1, nCount)).intValue();  

	       //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
	       d1 = d1 + ( 11 - nCount ) * digitoCPF;  

	       //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
	       d2 = d2 + ( 12 - nCount ) * digitoCPF;  
	    };  

	    //Primeiro resto da divisão por 11.  
	    resto = (d1 % 11);  

	    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
	    if (resto < 2)  
	       digito1 = 0;  
	    else  
	       digito1 = 11 - resto;  

	    d2 += 2 * digito1;  

	    //Segundo resto da divisão por 11.  
	    resto = (d2 % 11);  

	    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
	    if (resto < 2)  
	       digito2 = 0;  
	    else  
	       digito2 = 11 - resto;  

	    //Digito verificador do CPF que está sendo validado.  
	    String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());  

	    //Concatenando o primeiro resto com o segundo.  
	    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  

	    //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
	    return nDigVerific.equals(nDigResult);  
	    
	 }
	
	public boolean verificarSeENumero(String valor){
		
		// "compila"a expressão que será usada  
		Pattern p = Pattern.compile("[0-9]+");   
		// "pega" informações da string  a ser testada
		Matcher m = p.matcher(valor);  

		return m.matches();
		
	}

	public boolean verificarSeCpfAlunoJaExiste(String cpf){
		Aluno a = Facade.getInstance().procurarAlunoPorCPF(cpf);
		boolean resposta;
		if(a != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}
	
	public boolean verificarSeRGAlunoJaExiste(String rg){
		Aluno a = Facade.getInstance().procurarAlunoPorRg(rg);
		boolean resposta;
		if(a != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}
	
	public boolean verificarSeCpfFuncionarioJaExiste(String cpf){
		Funcionario f = Facade.getInstance().procurarFuncionarioPorCPF(cpf);
		boolean resposta;
		if(f != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}
	
	public boolean verificarSeRGFuncionarioJaExiste(String rg){
		Funcionario f = Facade.getInstance().procurarFuncionarioPorRg(rg);
		boolean resposta;
		if(f != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}

	
	public boolean verificarSeCpfProfessorJaExiste(String cpf){
		Professor p = Facade.getInstance().procurarProfessorPorCPF(cpf);
		boolean resposta;
		if(p != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}
	
	public boolean verificarSeRGProfessorJaExiste(String rg){
		Professor p = Facade.getInstance().procurarProfessorPorRg(rg);
		boolean resposta;
		if(p != null){
			resposta = true;
		}else{
			resposta = false;
		}
		return resposta;		
	}


	
}