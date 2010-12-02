package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.OutrosVinculosDaoInterface;
import br.com.sigep.bean.OutrosVinculos;
import br.com.sigep.dao.DaoException;

public class OutrosVinculosBlo implements OutrosVinculosBloInterface {
	OutrosVinculosDaoInterface dao;

	public OutrosVinculosBlo(OutrosVinculosDaoInterface dao) {
		this.dao = dao;
	}

	public OutrosVinculosBlo() {
	}
	
	public OutrosVinculosDaoInterface getDao() {
		return dao;
	}

	public void setDao(OutrosVinculosDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarOutrosVinculos(OutrosVinculos newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarOutrosVinculos(OutrosVinculos transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public OutrosVinculos carregarOutrosVinculos(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<OutrosVinculos> listarOutrosVinculos(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<OutrosVinculos> listarOutrosVinculosFuncionario(long idFuncionario){
		try {
			return dao.listarOutrosVinculosFuncionario(idFuncionario);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerOutrosVinculos(OutrosVinculos persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerOutrosVinculos(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}