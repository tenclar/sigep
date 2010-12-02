package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.RegistroDeAulaDaoInterface;
import br.com.sigep.bean.RegistroDeAula;
import br.com.sigep.dao.DaoException;

public class RegistroDeAulaBlo implements RegistroDeAulaBloInterface {
	RegistroDeAulaDaoInterface dao;

	public RegistroDeAulaBlo(RegistroDeAulaDaoInterface dao) {
		this.dao = dao;
	}

	public RegistroDeAulaBlo() {
	}
	
	public RegistroDeAulaDaoInterface getDao() {
		return dao;
	}

	public void setDao(RegistroDeAulaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarRegistroDeAula(RegistroDeAula newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarRegistroDeAula(RegistroDeAula transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public RegistroDeAula carregarRegistroDeAula(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<RegistroDeAula> listarRegistroDeAula(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<RegistroDeAula> listarRegistroDeAulaFiltro(String assunto){
		try {
			return dao.listarRegistroDeAulaFiltro(assunto);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerRegistroDeAula(RegistroDeAula persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerRegistroDeAula(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}