package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.NivelEscolar;

public interface NivelEscolarDaoInterface {

	public void atualizar(NivelEscolar transientObject) throws DaoException;
	
	public NivelEscolar carregar(long id) throws DaoException;

	public List<NivelEscolar> listar() throws DaoException ;
	
	public List<NivelEscolar> listarNivelFiltro(String descricao) throws DaoException ;

	public void remover(NivelEscolar persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(NivelEscolar newInstance) throws DaoException ;
	
	public List<NivelEscolar> listarNivelPorAnoLetivo(long idAno) throws DaoException ;
	

}