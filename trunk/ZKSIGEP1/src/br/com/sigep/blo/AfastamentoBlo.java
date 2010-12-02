package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.AfastamentoDaoInterface;
import br.com.sigep.bean.Afastamento;
import br.com.sigep.dao.DaoException;

public class AfastamentoBlo implements AfastamentoBloInterface {
	AfastamentoDaoInterface dao;

	public AfastamentoBlo(AfastamentoDaoInterface dao) {
		this.dao = dao;
	}

	public AfastamentoBlo() {
	}
	
	public AfastamentoDaoInterface getDao() {
		return dao;
	}

	public void setDao(AfastamentoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarAfastamento(Afastamento newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarAfastamento(Afastamento transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Afastamento carregarAfastamento(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Afastamento> listarAfastamento(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Afastamento> listarAfastamentoFiltro(String descricao){
		try {
			return dao.listarAfastamentoFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerAfastamento(Afastamento persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerAfastamento(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}