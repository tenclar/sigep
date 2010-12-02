package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.DisciplinaDaoInterface;
import br.com.sigep.bean.Disciplina;
import br.com.sigep.dao.DaoException;

public class DisciplinaBlo implements DisciplinaBloInterface {
	DisciplinaDaoInterface dao;

	public DisciplinaBlo(DisciplinaDaoInterface dao) {
		this.dao = dao;
	}

	public DisciplinaBlo() {
	}
	
	public DisciplinaDaoInterface getDao() {
		return dao;
	}

	public void setDao(DisciplinaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarDisciplina(Disciplina newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarDisciplina(Disciplina transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Disciplina carregarDisciplina(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Disciplina> listarDisciplina(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Disciplina> listarDisciplinaSerie(long serie){
		try {
			return dao.listarDisciplinaSerie(serie);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Disciplina> listarDisciplinaFiltro(String nome){
		try {
			return dao.listarDisciplinaFiltro(nome);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerDisciplina(Disciplina persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerDisciplina(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}