package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.TipoDeUsuario;

public interface TipoDeUsuarioDaoInterface {

	public void atualizar(TipoDeUsuario transientObject) throws DaoException;
	
	public TipoDeUsuario carregar(long id) throws DaoException;

	public List<TipoDeUsuario> listar() throws DaoException ;
	
	public List<TipoDeUsuario> listarTipoDeUsuarioFiltro(String descricao) throws DaoException ;

	public void remover(TipoDeUsuario persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(TipoDeUsuario newInstance) throws DaoException ;
	

}