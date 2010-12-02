package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Matricula;

public interface MatriculaDaoInterface {

	public void atualizar(Matricula transientObject) throws DaoException;
	
	public Matricula carregar(long id) throws DaoException;

	public List<Matricula> listar() throws DaoException ;
	
	public List<Matricula> listarMatriculaAluno(long id) throws DaoException ;

	public void remover(Matricula persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Matricula newInstance) throws DaoException ;
	
	public List<Matricula> listarMatriculaAlunoRG(String rg) throws DaoException;
	
	public Matricula procurarMatriculaPorAlunoEAno(long aluno, long ano) throws DaoException;
	
}