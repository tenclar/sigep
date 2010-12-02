package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.ResultadoFinal;

public interface ResultadoFinalDaoInterface {

	public void atualizar(ResultadoFinal transientObject) throws DaoException;
	
	public ResultadoFinal carregar(long id) throws DaoException;

	public List<ResultadoFinal> listar() throws DaoException ;
	
	public List<ResultadoFinal> listarNotasPorPeriodo(long idAluno, long idTurma) throws DaoException;

	public void remover(ResultadoFinal persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(ResultadoFinal newInstance) throws DaoException ;
	

}