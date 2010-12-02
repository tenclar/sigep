package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.RegistroDeDisciplinaDaoInterface;
import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.RegistroDeDisciplina;
import br.com.sigep.dao.DaoException;

public class RegistroDeDisciplinaBlo implements RegistroDeDisciplinaBloInterface {
	RegistroDeDisciplinaDaoInterface dao;

	public RegistroDeDisciplinaBlo(RegistroDeDisciplinaDaoInterface dao) {
		this.dao = dao;
	}

	public RegistroDeDisciplinaBlo() {
	}
	
	public RegistroDeDisciplinaDaoInterface getDao() {
		return dao;
	}

	public void setDao(RegistroDeDisciplinaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarRegistroDeDisciplina(RegistroDeDisciplina newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarRegistroDeDisciplina(RegistroDeDisciplina transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public RegistroDeDisciplina carregarRegistroDeDisciplina(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<RegistroDeDisciplina> listarRegistroDeDisciplina(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<RegistroDeDisciplina> listarRegistroDeDisciplinaTurma(long turma){
		try {
			return dao.listarRegistroDeDisciplinaTurma(turma);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Disciplina> listarDisciplinaTurma(long turma){
		try {
			return dao.listarDisciplinaTurma(turma);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerRegistroDeDisciplina(RegistroDeDisciplina persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerRegistroDeDisciplina(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}