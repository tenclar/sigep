package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Serie;

public interface SerieDaoInterface {

	public void atualizar(Serie transientObject) throws DaoException;
	
	public Serie carregar(long id) throws DaoException;

	public List<Serie> listar() throws DaoException ;
	
	public List<Serie> listarSerieNivel(long id) throws DaoException ;
	
	public List<Serie> listarSerieFiltro(String descricao) throws DaoException ;

	public void remover(Serie persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Serie newInstance) throws DaoException ;
	

}