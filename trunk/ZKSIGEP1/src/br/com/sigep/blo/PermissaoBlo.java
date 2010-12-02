package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.PermissaoDaoInterface;
import br.com.sigep.bean.Permissao;
import br.com.sigep.dao.DaoException;

public class PermissaoBlo implements PermissaoBloInterface {
	PermissaoDaoInterface dao;

	public PermissaoBlo(PermissaoDaoInterface dao) {
		this.dao = dao;
	}

	public PermissaoBlo() {
	}
	
	public PermissaoDaoInterface getDao() {
		return dao;
	}

	public void setDao(PermissaoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarPermissao(Permissao newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarPermissao(Permissao transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Permissao carregarPermissao(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Permissao> listarPermissao(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Permissao> listarPermissaoFiltro(int descricao){
		try {
			return dao.listarPermissaoFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}


	public void removerPermissao(Permissao persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerPermissao(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}