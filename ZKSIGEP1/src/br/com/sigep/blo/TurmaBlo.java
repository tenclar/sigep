package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.TurmaDaoInterface;
import br.com.sigep.bean.Turma;
import br.com.sigep.dao.DaoException;

public class TurmaBlo implements TurmaBloInterface {
	TurmaDaoInterface dao;

	public TurmaBlo(TurmaDaoInterface dao) {
		this.dao = dao;
	}

	public TurmaBlo() {
	}
	
	public TurmaDaoInterface getDao() {
		return dao;
	}

	public void setDao(TurmaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarTurma(Turma newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarTurma(Turma transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Turma carregarTurma(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Turma> listarTurma(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Turma> listarTurmaSerie(long id, long idAno){
		try {
			return dao.listarTurmaSerie(id, idAno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Turma> listarTurmaSerieTurno(long id, String turno){
		try {
			return dao.listarTurmaSerieTurno(id, turno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Turma> listarTurmaFiltro(String nome){
		try {
			return dao.listarTurmaFiltro(nome);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerTurma(Turma persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerTurma(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}