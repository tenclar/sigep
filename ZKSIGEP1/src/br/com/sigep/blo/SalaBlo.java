package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.SalaDaoInterface;
import br.com.sigep.bean.Sala;
import br.com.sigep.dao.DaoException;

public class SalaBlo implements SalaBloInterface {
	SalaDaoInterface dao;

	public SalaBlo(SalaDaoInterface dao) {
		this.dao = dao;
	}

	public SalaBlo() {
	}
	
	public SalaDaoInterface getDao() {
		return dao;
	}

	public void setDao(SalaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarSala(Sala newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarSala(Sala transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Sala carregarSala(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Sala> listarSala(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public List<Sala> listarSalaFiltro(String descricao){
		try {
			return dao.listarSalaFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
		
	public void removerSala(Sala persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerSala(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}