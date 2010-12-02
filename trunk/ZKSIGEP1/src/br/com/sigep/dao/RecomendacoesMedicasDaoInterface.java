package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.RecomendacoesMedicas;

public interface RecomendacoesMedicasDaoInterface {

	public void atualizar(RecomendacoesMedicas transientObject) throws DaoException;
	
	public RecomendacoesMedicas carregar(long id) throws DaoException;

	public List<RecomendacoesMedicas> listar() throws DaoException ;

	public void remover(RecomendacoesMedicas persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(RecomendacoesMedicas newInstance) throws DaoException ;
	

}