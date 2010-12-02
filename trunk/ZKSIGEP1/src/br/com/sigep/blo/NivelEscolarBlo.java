package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.NivelEscolarDaoInterface;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.dao.DaoException;

public class NivelEscolarBlo implements NivelEscolarBloInterface {
	NivelEscolarDaoInterface dao;

	public NivelEscolarBlo(NivelEscolarDaoInterface dao) {
		this.dao = dao;
	}

	public NivelEscolarBlo() {
	}
	
	public NivelEscolarDaoInterface getDao() {
		return dao;
	}

	public void setDao(NivelEscolarDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarNivelEscolar(NivelEscolar newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarNivelEscolar(NivelEscolar transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public NivelEscolar carregarNivelEscolar(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<NivelEscolar> listarNivelEscolar(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<NivelEscolar> listarNivelPorAnoLetivo(long idAno){
		try {
			return dao.listarNivelPorAnoLetivo(idAno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<NivelEscolar> listarNivelFiltro(String descricao){
		try {
			return dao.listarNivelFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}


	public void removerNivelEscolar(NivelEscolar persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerNivelEscolar(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}