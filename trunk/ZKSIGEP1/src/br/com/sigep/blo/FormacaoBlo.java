package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.FormacaoDaoInterface;
import br.com.sigep.bean.Formacao;
import br.com.sigep.dao.DaoException;

public class FormacaoBlo implements FormacaoBloInterface {
	FormacaoDaoInterface dao;

	public FormacaoBlo(FormacaoDaoInterface dao) {
		this.dao = dao;
	}

	public FormacaoBlo() {
	}
	
	public FormacaoDaoInterface getDao() {
		return dao;
	}

	public void setDao(FormacaoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarFormacao(Formacao newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarFormacao(Formacao transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Formacao carregarFormacao(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Formacao> listarFormacao(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public List<Formacao> listarFormacaoFuncionario(long idFuncionario){
		try {
			return dao.listarFormacaoFuncionario(idFuncionario);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public void removerFormacao(Formacao persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerFormacao(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}