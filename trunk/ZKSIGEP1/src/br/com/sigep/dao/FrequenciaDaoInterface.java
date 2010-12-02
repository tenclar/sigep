package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Frequencia;

public interface FrequenciaDaoInterface {

	public void atualizar(Frequencia transientObject) throws DaoException;
	
	public Frequencia carregar(long id) throws DaoException;

	public List<Frequencia> listar() throws DaoException ;

	public void remover(Frequencia persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Frequencia newInstance) throws DaoException ;
	

}