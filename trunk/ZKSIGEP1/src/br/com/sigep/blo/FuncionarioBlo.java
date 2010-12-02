package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.FuncionarioDaoInterface;
import br.com.sigep.bean.Funcionario;
import br.com.sigep.dao.DaoException;

public class FuncionarioBlo implements FuncionarioBloInterface {
	FuncionarioDaoInterface dao;

	public FuncionarioBlo(FuncionarioDaoInterface dao) {
		this.dao = dao;
	}

	public FuncionarioBlo() {
	}
	
	public FuncionarioDaoInterface getDao() {
		return dao;
	}

	public void setDao(FuncionarioDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarFuncionario(Funcionario newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarFuncionario(Funcionario transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Funcionario carregarFuncionario(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Funcionario procurarFuncionarioPorCPF(String cpf) {
		try {
			return dao.procurarFuncionarioPorCPF(cpf);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Funcionario procurarFuncionarioPorRg(String rg) {
		try {
			return dao.procurarFuncionarioPorRg(rg);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public List<Funcionario> listarFuncionario(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Funcionario> listarFuncionarioFiltro(String nome){
		try {
			return dao.listarFuncionarioFiltro(nome);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerFuncionario(Funcionario persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerFuncionario(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}