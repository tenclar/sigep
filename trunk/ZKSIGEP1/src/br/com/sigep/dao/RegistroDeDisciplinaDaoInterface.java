package br.com.sigep.dao;

import java.util.List;

import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.RegistroDeDisciplina;

public interface RegistroDeDisciplinaDaoInterface {

	public void atualizar(RegistroDeDisciplina transientObject) throws DaoException;
	
	public RegistroDeDisciplina carregar(long id) throws DaoException;

	public List<RegistroDeDisciplina> listar() throws DaoException ;
	
	public List<Disciplina> listarDisciplinaTurma(long turma) throws DaoException ;
	
	public List<RegistroDeDisciplina> listarRegistroDeDisciplinaTurma(long turma) throws DaoException ;

	public void remover(RegistroDeDisciplina persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(RegistroDeDisciplina newInstance) throws DaoException ;
	

}