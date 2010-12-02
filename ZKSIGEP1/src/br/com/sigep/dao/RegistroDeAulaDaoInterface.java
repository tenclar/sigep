package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.RegistroDeAula;
import br.com.sigep.bean.Resultado;

public interface RegistroDeAulaDaoInterface {

	public void atualizar(RegistroDeAula transientObject) throws DaoException;
	
	public RegistroDeAula carregar(long id) throws DaoException;

	public List<RegistroDeAula> listar() throws DaoException ;
	
	public List<RegistroDeAula> listarRegistroDeAulaFiltro(String assunto) throws DaoException ;

	public void remover(RegistroDeAula persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(RegistroDeAula newInstance) throws DaoException ;
	

}