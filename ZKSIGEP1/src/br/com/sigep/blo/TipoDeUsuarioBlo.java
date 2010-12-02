package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.TipoDeUsuarioDaoInterface;
import br.com.sigep.bean.TipoDeUsuario;
import br.com.sigep.dao.DaoException;

public class TipoDeUsuarioBlo implements TipoDeUsuarioBloInterface {
	TipoDeUsuarioDaoInterface dao;

	public TipoDeUsuarioBlo(TipoDeUsuarioDaoInterface dao) {
		this.dao = dao;
	}

	public TipoDeUsuarioBlo() {
	}
	
	public TipoDeUsuarioDaoInterface getDao() {
		return dao;
	}

	public void setDao(TipoDeUsuarioDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarTipoDeUsuario(TipoDeUsuario newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarTipoDeUsuario(TipoDeUsuario transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public TipoDeUsuario carregarTipoDeUsuario(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<TipoDeUsuario> listarTipoDeUsuario(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<TipoDeUsuario> listarTipoDeUsuarioFiltro(String descricao){
		try {
			return dao.listarTipoDeUsuarioFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerTipoDeUsuario(TipoDeUsuario persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerTipoDeUsuario(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}