package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.OcorrenciaDaoInterface;
import br.com.sigep.bean.Ocorrencia;
import br.com.sigep.dao.DaoException;

public class OcorrenciaBlo implements OcorrenciaBloInterface {
	OcorrenciaDaoInterface dao;

	public OcorrenciaBlo(OcorrenciaDaoInterface dao) {
		this.dao = dao;
	}

	public OcorrenciaBlo() {
	}
	
	public OcorrenciaDaoInterface getDao() {
		return dao;
	}

	public void setDao(OcorrenciaDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarOcorrencia(Ocorrencia newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarOcorrencia(Ocorrencia transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Ocorrencia carregarOcorrencia(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Ocorrencia> listarOcorrencia(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Ocorrencia> listarOcorrenciaFiltro(String descricao){
		try {
			return dao.listarOcorrenciaFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerOcorrencia(Ocorrencia persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerOcorrencia(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}