package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Registro;

public interface RegistroDaoInterface {

	public void atualizar(Registro transientObject) throws DaoException;
	
	public Registro carregar(long id) throws DaoException;

	public List<Registro> listar() throws DaoException ;

	public void remover(Registro persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Registro newInstance) throws DaoException ;
	

}