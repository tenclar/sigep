package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.DadosBancarios;

public interface DadosBancariosDaoInterface {

	public void atualizar(DadosBancarios transientObject) throws DaoException;
	
	public DadosBancarios carregar(long id) throws DaoException;

	public List<DadosBancarios> listar() throws DaoException ;

	public void remover(DadosBancarios persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(DadosBancarios newInstance) throws DaoException ;
	

}