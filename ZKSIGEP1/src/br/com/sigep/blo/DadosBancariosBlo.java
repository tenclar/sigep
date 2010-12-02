package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.DadosBancariosDaoInterface;
import br.com.sigep.bean.DadosBancarios;
import br.com.sigep.dao.DaoException;

public class DadosBancariosBlo implements DadosBancariosBloInterface {
	DadosBancariosDaoInterface dao;

	public DadosBancariosBlo(DadosBancariosDaoInterface dao) {
		this.dao = dao;
	}

	public DadosBancariosBlo() {
	}
	
	public DadosBancariosDaoInterface getDao() {
		return dao;
	}

	public void setDao(DadosBancariosDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarDadosBancarios(DadosBancarios newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarDadosBancarios(DadosBancarios transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public DadosBancarios carregarDadosBancarios(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<DadosBancarios> listarDadosBancarios(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerDadosBancarios(DadosBancarios persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerDadosBancarios(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}