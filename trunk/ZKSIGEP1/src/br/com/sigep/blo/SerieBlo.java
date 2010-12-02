package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.SerieDaoInterface;
import br.com.sigep.bean.Serie;
import br.com.sigep.dao.DaoException;

public class SerieBlo implements SerieBloInterface {
	SerieDaoInterface dao;

	public SerieBlo(SerieDaoInterface dao) {
		this.dao = dao;
	}

	public SerieBlo() {
	}
	
	public SerieDaoInterface getDao() {
		return dao;
	}

	public void setDao(SerieDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarSerie(Serie newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarSerie(Serie transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Serie carregarSerie(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Serie> listarSerie(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Serie> listarSerieNivel(long id){
		try {
			return dao.listarSerieNivel(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Serie> listarSerieFiltro(String descricao){
		try {
			return dao.listarSerieFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerSerie(Serie persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerSerie(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}