package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.Matricula;

public class MatriculaDaoHibernate extends HibernateDaoSupport
implements MatriculaDaoInterface {

	public void atualizar(Matricula transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Matricula", "Matricula");
		}	
	}

	public Matricula carregar(long id) throws DaoException {
		try {
			return (Matricula) getHibernateTemplate().get(Matricula.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Matricula", "Matricula");
		}	
	}

	public List<Matricula> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Matricula");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Matricula", "Matricula");
		}	
	}
	
	public List<Matricula> listarMatriculaAluno(long id) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Matricula where idAluno = (SELECT id FROM Aluno where id = ?)");
			consulta.setLong(0, id);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Matricula", "Matricula");
		}	
	}
	
	public List<Matricula> listarMatriculaAlunoRG(String rg) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Matricula where idAluno = (SELECT id FROM Aluno where rg like ?)");
			consulta.setString(0, rg);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Matricula", "Matricula");
		}
	}
	
	public Matricula procurarMatriculaPorAlunoEAno(long aluno, long ano) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Matricula m where m.idaluno = ? and m.turma.anoletivo = ?");
			consulta.setLong(0, aluno);
			consulta.setLong(1, ano);
			return (Matricula) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Matricula", "Matricula");
		}	
	}	
	

	public void remover(Matricula persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Matricula", "Matricula");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Matricula) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Matricula", "Matricula");
		}
	}

	public void salvar(Matricula newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Matricula", "Matricula");
		}
	}
	

}