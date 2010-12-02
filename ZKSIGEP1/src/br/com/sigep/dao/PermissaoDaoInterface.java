package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Permissao;

public interface PermissaoDaoInterface {

	public void atualizar(Permissao transientObject) throws DaoException;
	
	public Permissao carregar(long id) throws DaoException;

	public List<Permissao> listar() throws DaoException ;
	
	public List<Permissao> listarPermissaoFiltro(int descricao) throws DaoException ;

	public void remover(Permissao persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Permissao newInstance) throws DaoException ;
	

}