package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Disciplina;

public interface DisciplinaDaoInterface {

	public void atualizar(Disciplina transientObject) throws DaoException;
	
	public Disciplina carregar(long id) throws DaoException;

	public List<Disciplina> listar() throws DaoException ;
	
	public List<Disciplina> listarDisciplinaSerie(long serie) throws DaoException ;
	
	public List<Disciplina> listarDisciplinaFiltro(String nome) throws DaoException ;

	public void remover(Disciplina persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Disciplina newInstance) throws DaoException ;
	

}