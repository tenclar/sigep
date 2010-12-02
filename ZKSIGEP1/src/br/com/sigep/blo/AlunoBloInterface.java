package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Aluno;

public interface AlunoBloInterface {
	void salvarAluno(Aluno u);
	Aluno carregarAluno(long id);
	void atualizarAluno(Aluno u);
	void removerAluno(Aluno u);
	void removerAluno(long id);
	List<Aluno> listarAluno();
	List<Aluno> listarAlunoFiltro(String nome);
	Aluno procurarAlunoPorRg(String rg);
	Aluno procurarAlunoPorLogin(String login);
	Aluno procurarAlunoPorCPF(String cpf);

    
}