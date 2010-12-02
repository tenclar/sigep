package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.ProfessorDaoInterface;
import br.com.sigep.bean.Professor;
import br.com.sigep.dao.DaoException;

public class ProfessorBlo implements ProfessorBloInterface {
	ProfessorDaoInterface dao;

	public ProfessorBlo(ProfessorDaoInterface dao) {
		this.dao = dao;
	}

	public ProfessorBlo() {
	}
	
	public ProfessorDaoInterface getDao() {
		return dao;
	}

	public void setDao(ProfessorDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarProfessor(Professor newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarProfessor(Professor transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Professor carregarProfessor(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Professor> listarProfessor(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Professor> listarProfessorFiltro(String nome){
		try {
			return dao.listarProfessorFiltro(nome);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public Professor procurarProfessorPorCPF(String cpf){
		try {
			return dao.procurarProfessorPorCPF(cpf);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public Professor procurarProfessorPorRg(String rg){
		try {
			return dao.procurarProfessorPorRg(rg);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerProfessor(Professor persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerProfessor(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}