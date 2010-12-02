package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.AnoLetivoDaoInterface;
import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.dao.DaoException;

public class AnoLetivoBlo implements AnoLetivoBloInterface {
	AnoLetivoDaoInterface dao;

	public AnoLetivoBlo(AnoLetivoDaoInterface dao) {
		this.dao = dao;
	}

	public AnoLetivoBlo() {
	}
	
	public AnoLetivoDaoInterface getDao() {
		return dao;
	}

	public void setDao(AnoLetivoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarAnoLetivo(AnoLetivo newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarAnoLetivo(AnoLetivo transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public AnoLetivo carregarAnoLetivo(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<AnoLetivo> listarAnoLetivo(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<AnoLetivo> listarAnoLetivoFiltro(int descricao){
		try {
			return dao.listarAnoLetivoFiltro(descricao);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<AnoLetivo> listarAnoLetivoPorMatriculaAluno(long idAluno){
		try {
			return dao.listarAnoLetivoPorMatriculaAluno(idAluno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(long idAluno){
		try {
			return dao.listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(idAluno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoFoiMatriculado(long idAluno){
		try {
			return dao.listarAnoLetivoNosQuaisOAlunoFoiMatriculado(idAluno);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerAnoLetivo(AnoLetivo persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerAnoLetivo(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}