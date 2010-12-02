package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Usuario;

public interface UsuarioDaoInterface {

	public void atualizar(Usuario transientObject) throws DaoException;
	
	public Usuario carregar(long id) throws DaoException;

	public List<Usuario> listar() throws DaoException ;

	public void remover(Usuario persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Usuario newInstance) throws DaoException ;
	

}