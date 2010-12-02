package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.AvaliacaoDaoInterface;
import br.com.sigep.bean.Avaliacao;
import br.com.sigep.dao.DaoException;

public class AvaliacaoBlo implements AvaliacaoBloInterface {
	AvaliacaoDaoInterface dao;

	public AvaliacaoBlo(AvaliacaoDaoInterface dao) {
		this.dao = dao;
	}

	public AvaliacaoBlo() {
	}
	
	public AvaliacaoDaoInterface getDao() {
		return dao;
	}

	public void setDao(AvaliacaoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarAvaliacao(Avaliacao newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarAvaliacao(Avaliacao transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Avaliacao carregarAvaliacao(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Avaliacao> listarAvaliacao(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Avaliacao> listarAvaliacaoFiltro(String descricao){
		try {
			return dao.listarAvaliacaoFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerAvaliacao(Avaliacao persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerAvaliacao(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}