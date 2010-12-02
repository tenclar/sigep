package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.UsuarioDaoInterface;
import br.com.sigep.bean.Usuario;
import br.com.sigep.dao.DaoException;

public class UsuarioBlo implements UsuarioBloInterface {
	UsuarioDaoInterface dao;

	public UsuarioBlo(UsuarioDaoInterface dao) {
		this.dao = dao;
	}

	public UsuarioBlo() {
	}
	
	public UsuarioDaoInterface getDao() {
		return dao;
	}

	public void setDao(UsuarioDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarUsuario(Usuario newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarUsuario(Usuario transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Usuario carregarUsuario(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Usuario> listarUsuario(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerUsuario(Usuario persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerUsuario(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}