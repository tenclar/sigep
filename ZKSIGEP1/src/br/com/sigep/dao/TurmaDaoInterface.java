package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Turma;

public interface TurmaDaoInterface {

	public void atualizar(Turma transientObject) throws DaoException;
	
	public Turma carregar(long id) throws DaoException;

	public List<Turma> listar() throws DaoException ;
	
	public List<Turma> listarTurmaSerie(long id, long idAno) throws DaoException ;
	
	public List<Turma> listarTurmaSerieTurno(long id, String turno) throws DaoException ;
	
	public List<Turma> listarTurmaFiltro(String nome) throws DaoException ;

	public void remover(Turma persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Turma newInstance) throws DaoException ;
	

}