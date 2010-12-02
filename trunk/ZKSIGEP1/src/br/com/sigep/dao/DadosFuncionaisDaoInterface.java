package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.DadosFuncionais;

public interface DadosFuncionaisDaoInterface {

	public void atualizar(DadosFuncionais transientObject) throws DaoException;
	
	public DadosFuncionais carregar(long id) throws DaoException;

	public List<DadosFuncionais> listar() throws DaoException ;

	public void remover(DadosFuncionais persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(DadosFuncionais newInstance) throws DaoException ;
	

}