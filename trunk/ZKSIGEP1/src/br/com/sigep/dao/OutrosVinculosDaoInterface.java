package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.OutrosVinculos;

public interface OutrosVinculosDaoInterface {

	public void atualizar(OutrosVinculos transientObject) throws DaoException;
	
	public OutrosVinculos carregar(long id) throws DaoException;

	public List<OutrosVinculos> listar() throws DaoException ;

	public void remover(OutrosVinculos persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(OutrosVinculos newInstance) throws DaoException ;
	
	public List<OutrosVinculos> listarOutrosVinculosFuncionario(long idFuncionario) throws DaoException;
	

}