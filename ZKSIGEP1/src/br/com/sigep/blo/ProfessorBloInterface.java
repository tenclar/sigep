package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Professor;

public interface ProfessorBloInterface {
	void salvarProfessor(Professor u);
	Professor carregarProfessor(long id);
	void atualizarProfessor(Professor u);
	void removerProfessor(Professor u);
	void removerProfessor(long id);
	List<Professor> listarProfessor();
    List<Professor> listarProfessorFiltro(String nome);
    Professor procurarProfessorPorCPF(String cpf);
    Professor procurarProfessorPorRg(String rg);
    

    
}