package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Formacao;

public interface FormacaoDaoInterface {

	public void atualizar(Formacao transientObject) throws DaoException;
	
	public Formacao carregar(long id) throws DaoException;

	public List<Formacao> listar() throws DaoException ;

	public void remover(Formacao persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Formacao newInstance) throws DaoException ;
	
	public List<Formacao> listarFormacaoFuncionario(long idFuncionario) throws DaoException;
	

}