package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.BlocoDaoInterface;
import br.com.sigep.bean.Bloco;
import br.com.sigep.dao.DaoException;

public class BlocoBlo implements BlocoBloInterface {
	BlocoDaoInterface dao;

	public BlocoBlo(BlocoDaoInterface dao) {
		this.dao = dao;
	}

	public BlocoBlo() {
	}
	
	public BlocoDaoInterface getDao() {
		return dao;
	}

	public void setDao(BlocoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarBloco(Bloco newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarBloco(Bloco transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Bloco carregarBloco(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Bloco> listarBloco(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Bloco> listarBlocoFiltro(String descricao){
		try {
			return dao.listarBlocoFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerBloco(Bloco persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerBloco(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}