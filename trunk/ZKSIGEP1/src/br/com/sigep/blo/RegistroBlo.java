package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.RegistroDaoInterface;
import br.com.sigep.bean.Registro;
import br.com.sigep.dao.DaoException;

public class RegistroBlo implements RegistroBloInterface {
	RegistroDaoInterface dao;

	public RegistroBlo(RegistroDaoInterface dao) {
		this.dao = dao;
	}

	public RegistroBlo() {
	}
	
	public RegistroDaoInterface getDao() {
		return dao;
	}

	public void setDao(RegistroDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarRegistro(Registro newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarRegistro(Registro transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Registro carregarRegistro(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Registro> listarRegistro(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerRegistro(Registro persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerRegistro(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}