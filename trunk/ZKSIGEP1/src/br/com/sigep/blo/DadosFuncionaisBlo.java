package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.DadosFuncionaisDaoInterface;
import br.com.sigep.bean.DadosFuncionais;
import br.com.sigep.dao.DaoException;

public class DadosFuncionaisBlo implements DadosFuncionaisBloInterface {
	DadosFuncionaisDaoInterface dao;

	public DadosFuncionaisBlo(DadosFuncionaisDaoInterface dao) {
		this.dao = dao;
	}

	public DadosFuncionaisBlo() {
	}
	
	public DadosFuncionaisDaoInterface getDao() {
		return dao;
	}

	public void setDao(DadosFuncionaisDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarDadosFuncionais(DadosFuncionais newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarDadosFuncionais(DadosFuncionais transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public DadosFuncionais carregarDadosFuncionais(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<DadosFuncionais> listarDadosFuncionais(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerDadosFuncionais(DadosFuncionais persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerDadosFuncionais(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}