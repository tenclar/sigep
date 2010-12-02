package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Bloco;

public interface BlocoDaoInterface {

	public void atualizar(Bloco transientObject) throws DaoException;
	
	public Bloco carregar(long id) throws DaoException;

	public List<Bloco> listar() throws DaoException ;
	
	public List<Bloco> listarBlocoFiltro(String descricao) throws DaoException ;

	public void remover(Bloco persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Bloco newInstance) throws DaoException ;
	

}