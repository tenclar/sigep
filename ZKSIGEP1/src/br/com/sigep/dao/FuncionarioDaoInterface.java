package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Funcionario;

public interface FuncionarioDaoInterface {

	public void atualizar(Funcionario transientObject) throws DaoException;
	
	public Funcionario carregar(long id) throws DaoException;

	public List<Funcionario> listar() throws DaoException ;
	
	public List<Funcionario> listarFuncionarioFiltro(String nome) throws DaoException ;

	public void remover(Funcionario persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Funcionario newInstance) throws DaoException ;
	
	public Funcionario procurarFuncionarioPorCPF(String cpf) throws DaoException;
	
	public Funcionario procurarFuncionarioPorRg(String rg) throws DaoException;	

}