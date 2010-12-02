package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Professor;

public interface ProfessorDaoInterface {

	public void atualizar(Professor transientObject) throws DaoException;
	
	public Professor carregar(long id) throws DaoException;

	public List<Professor> listar() throws DaoException ;
	
	public List<Professor> listarProfessorFiltro(String nome) throws DaoException ;

	public void remover(Professor persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Professor newInstance) throws DaoException ;
	
	public Professor procurarProfessorPorRg(String rg) throws DaoException;
	
	public Professor procurarProfessorPorCPF(String cpf) throws DaoException;
	

}