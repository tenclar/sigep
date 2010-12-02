package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.RegistroDeDisciplina;

public interface RegistroDeDisciplinaBloInterface {
	void salvarRegistroDeDisciplina(RegistroDeDisciplina u);
	RegistroDeDisciplina carregarRegistroDeDisciplina(long id);
	void atualizarRegistroDeDisciplina(RegistroDeDisciplina u);
	void removerRegistroDeDisciplina(RegistroDeDisciplina u);
	void removerRegistroDeDisciplina(long id);
	List<RegistroDeDisciplina> listarRegistroDeDisciplina();
	List<RegistroDeDisciplina> listarRegistroDeDisciplinaTurma(long turma);
	List<Disciplina> listarDisciplinaTurma(long turma);
    
    

    
}