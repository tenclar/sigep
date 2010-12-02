package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Sala;

public interface SalaDaoInterface {

	public void atualizar(Sala transientObject) throws DaoException;
	
	public Sala carregar(long id) throws DaoException;

	public List<Sala> listar() throws DaoException ;
	
	public List<Sala> listarSalaFiltro(String descricao) throws DaoException ;

	public void remover(Sala persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Sala newInstance) throws DaoException ;


}