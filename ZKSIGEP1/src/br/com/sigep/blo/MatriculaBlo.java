package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.MatriculaDaoInterface;
import br.com.sigep.bean.Matricula;
import br.com.sigep.dao.DaoException;

public class MatriculaBlo implements MatriculaBloInterface {
	MatriculaDaoInterface dao;

	public MatriculaBlo(MatriculaDaoInterface dao) {
		this.dao = dao;
	}

	public MatriculaBlo() {
	}
	
	public MatriculaDaoInterface getDao() {
		return dao;
	}

	public void setDao(MatriculaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarMatricula(Matricula newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarMatricula(Matricula transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Matricula carregarMatricula(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Matricula procurarMatriculaPorAlunoEAno(long aluno, long ano) {
		try {
			return dao.procurarMatriculaPorAlunoEAno(aluno, ano);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	


	public List<Matricula> listarMatricula(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Matricula> listarMatriculaAlunoRG(String rg){
		try {
			return dao.listarMatriculaAlunoRG(rg);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Matricula> listarMatriculaAluno(long id){
		try {
			return dao.listarMatriculaAluno(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerMatricula(Matricula persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerMatricula(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}