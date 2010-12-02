package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Turma;

public interface TurmaBloInterface {
	void salvarTurma(Turma u);
	Turma carregarTurma(long id);
	void atualizarTurma(Turma u);
	void removerTurma(Turma u);
	void removerTurma(long id);
	List<Turma> listarTurma();
	List<Turma> listarTurmaSerie(long id, long idAno);
	List<Turma> listarTurmaSerieTurno(long id, String turno);
	List<Turma> listarTurmaFiltro(String nome);
    

    
}