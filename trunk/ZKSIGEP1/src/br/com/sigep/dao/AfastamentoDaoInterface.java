package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Afastamento;

public interface AfastamentoDaoInterface {

	public void atualizar(Afastamento transientObject) throws DaoException;
	
	public Afastamento carregar(long id) throws DaoException;

	public List<Afastamento> listar() throws DaoException ;
	
	public List<Afastamento> listarAfastamentoFiltro(String descricao) throws DaoException ;

	public void remover(Afastamento persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Afastamento newInstance) throws DaoException ;
	

}