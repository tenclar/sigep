package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Matricula;

public interface MatriculaBloInterface {
	void salvarMatricula(Matricula u);
	Matricula carregarMatricula(long id);
	void atualizarMatricula(Matricula u);
	void removerMatricula(Matricula u);
	void removerMatricula(long id);
	List<Matricula> listarMatricula();
	List<Matricula> listarMatriculaAluno(long id);
	Matricula procurarMatriculaPorAlunoEAno(long aluno, long ano);
	List<Matricula> listarMatriculaAlunoRG(String rg);

    
}