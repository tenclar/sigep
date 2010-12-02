package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Disciplina;

public interface DisciplinaBloInterface {
	void salvarDisciplina(Disciplina u);
	Disciplina carregarDisciplina(long id);
	void atualizarDisciplina(Disciplina u);
	void removerDisciplina(Disciplina u);
	void removerDisciplina(long id);
	List<Disciplina> listarDisciplina();
	List<Disciplina> listarDisciplinaSerie(long serie);
	List<Disciplina> listarDisciplinaFiltro(String nome);
    
    

    
}