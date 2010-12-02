package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.AnoLetivo;

public interface AnoLetivoDaoInterface {

	public void atualizar(AnoLetivo transientObject) throws DaoException;
	
	public AnoLetivo carregar(long id) throws DaoException;

	public List<AnoLetivo> listar() throws DaoException ;
	
	public List<AnoLetivo> listarAnoLetivoFiltro(int descricao) throws DaoException;

	public void remover(AnoLetivo persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(AnoLetivo newInstance) throws DaoException ;
	
	public List<AnoLetivo> listarAnoLetivoPorMatriculaAluno(long idAluno) throws DaoException;
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(long idAluno) throws DaoException;
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoFoiMatriculado(long idAluno) throws DaoException ;
	

}