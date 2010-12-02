package br.com.sigep.dao;

import java.util.List;
import br.com.sigep.bean.Aluno;

public interface AlunoDaoInterface {

	public void atualizar(Aluno transientObject) throws DaoException;
	
	public Aluno carregar(long id) throws DaoException;

	public List<Aluno> listar() throws DaoException ;
	
	public List<Aluno> listarAlunoFiltro(String nome) throws DaoException ;

	public void remover(Aluno persistentObject) throws DaoException ;

	public void remover (long id) throws DaoException ;

	public void salvar(Aluno newInstance) throws DaoException ;
	
	public Aluno procurarAlunoPorRg(String rg) throws DaoException;
	
	public Aluno procurarAlunoPorLogin(String login) throws DaoException;

	public Aluno procurarAlunoPorCPF(String cpf) throws DaoException;

	

}