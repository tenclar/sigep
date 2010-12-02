package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.RecomendacoesMedicasDaoInterface;
import br.com.sigep.bean.RecomendacoesMedicas;
import br.com.sigep.dao.DaoException;

public class RecomendacoesMedicasBlo implements RecomendacoesMedicasBloInterface {
	RecomendacoesMedicasDaoInterface dao;

	public RecomendacoesMedicasBlo(RecomendacoesMedicasDaoInterface dao) {
		this.dao = dao;
	}

	public RecomendacoesMedicasBlo() {
	}
	
	public RecomendacoesMedicasDaoInterface getDao() {
		return dao;
	}

	public void setDao(RecomendacoesMedicasDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarRecomendacoesMedicas(RecomendacoesMedicas newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarRecomendacoesMedicas(RecomendacoesMedicas transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public RecomendacoesMedicas carregarRecomendacoesMedicas(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<RecomendacoesMedicas> listarRecomendacoesMedicas(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerRecomendacoesMedicas(RecomendacoesMedicas persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerRecomendacoesMedicas(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}