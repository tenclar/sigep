package br.com.sigep.blo;

import java.util.List;

import br.com.sigep.dao.AlunoDaoInterface;
import br.com.sigep.bean.Aluno;
import br.com.sigep.dao.DaoException;

public class AlunoBlo implements AlunoBloInterface {
	AlunoDaoInterface dao;

	public AlunoBlo(AlunoDaoInterface dao) {
		this.dao = dao;
	}

	public AlunoBlo() {
	}
	
	public AlunoDaoInterface getDao() {
		return dao;
	}

	public void setDao(AlunoDaoInterface dao) {
		this.dao = dao;
	}	

	public void salvarAluno(Aluno newInstance) {
		try {
			dao.salvar(newInstance);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarAluno(Aluno transientObject) {
		try {
			dao.atualizar(transientObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}	
	}

	public Aluno carregarAluno(long id) {
		try {
			return dao.carregar(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Aluno procurarAlunoPorRg(String rg) {
		try {
			return dao.procurarAlunoPorRg(rg);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Aluno procurarAlunoPorLogin(String login) {
		try {
			return dao.procurarAlunoPorLogin(login);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Aluno procurarAlunoPorCPF(String cpf) {
		try {
			return dao.procurarAlunoPorCPF(cpf);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}
	}	

	public List<Aluno> listarAluno(){
		try {
			return dao.listar();
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}
	
	public List<Aluno> listarAlunoFiltro(String nome){
		try {
			return dao.listarAlunoFiltro(nome);
		} catch(DaoException ex) {
			ex.printStackTrace();
			return null;
		}			
	}

	public void removerAluno(Aluno persistentObject){
		try {
			dao.remover(persistentObject);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}
	
	public void removerAluno(long id){
		try {
			dao.remover(id);
		} catch(DaoException ex) {
			ex.printStackTrace();
		}			
	}	
	
	
	
}