package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.ResultadoDaoInterface;
import br.com.sigep.bean.Resultado;
import br.com.sigep.dao.DaoException;

public class ResultadoBlo implements ResultadoBloInterface {
	ResultadoDaoInterface dao;

	public ResultadoBlo(ResultadoDaoInterface dao) {
		this.dao = dao;
	}

	public ResultadoBlo() {
	}
	
	public ResultadoDaoInterface getDao() {
		return dao;
	}

	public void setDao(ResultadoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarResultado(Resultado newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarResultado(Resultado transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Resultado carregarResultado(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Resultado> listarResultado(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Resultado> listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(long idAluno, long idRegistro, String periodo, String etapa){
		try {
			return dao.listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(idAluno, idRegistro, periodo, etapa);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerResultado(Resultado persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerResultado(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}