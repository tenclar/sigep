package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.FrequenciaDaoInterface;
import br.com.sigep.bean.Frequencia;
import br.com.sigep.dao.DaoException;

public class FrequenciaBlo implements FrequenciaBloInterface {
	FrequenciaDaoInterface dao;

	public FrequenciaBlo(FrequenciaDaoInterface dao) {
		this.dao = dao;
	}

	public FrequenciaBlo() {
	}
	
	public FrequenciaDaoInterface getDao() {
		return dao;
	}

	public void setDao(FrequenciaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarFrequencia(Frequencia newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarFrequencia(Frequencia transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Frequencia carregarFrequencia(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Frequencia> listarFrequencia(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerFrequencia(Frequencia persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerFrequencia(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}