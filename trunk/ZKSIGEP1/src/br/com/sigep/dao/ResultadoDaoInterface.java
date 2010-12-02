package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Resultado;

public interface ResultadoDaoInterface {

	public void atualizar(Resultado transientObject) throws DaoException;
	
	public Resultado carregar(long id) throws DaoException;

	public List<Resultado> listar() throws DaoException ;
	
	public List<Resultado> listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(long idAluno, long idRegistro, String periodo, String etapa) throws DaoException;
	
	public void remover(Resultado persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Resultado newInstance) throws DaoException ;
	
}