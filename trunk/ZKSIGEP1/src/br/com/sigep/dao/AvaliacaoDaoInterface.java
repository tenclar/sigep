package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Avaliacao;

public interface AvaliacaoDaoInterface {

	public void atualizar(Avaliacao transientObject) throws DaoException;
	
	public Avaliacao carregar(long id) throws DaoException;

	public List<Avaliacao> listar() throws DaoException ;
	
	public List<Avaliacao> listarAvaliacaoFiltro(String descricao) throws DaoException ;

	public void remover(Avaliacao persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Avaliacao newInstance) throws DaoException ;
	

}