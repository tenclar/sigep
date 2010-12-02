package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.Professor;

public class ProfessorDaoHibernate extends HibernateDaoSupport
implements ProfessorDaoInterface {

	public void atualizar(Professor transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Professor", "Professor");
		}	
	}

	public Professor carregar(long id) throws DaoException {
		try {
			return (Professor) getHibernateTemplate().get(Professor.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Professor", "Professor");
		}	
	}

	public List<Professor> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Professor");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Professor", "Professor");
		}	
	}
	
	public List<Professor> listarProfessorFiltro(String nome) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Professor as pr where pr.nome like ?");
			consulta.setString(0, "%"+ nome + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Professor", "Professor");
		}	
	}
	
	public Professor procurarProfessorPorRg(String rg) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Professor where rg like ?");
			consulta.setString(0, rg);
			return (Professor) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Professor", "Professor");
		}	
	}
	
	public Professor procurarProfessorPorCPF(String cpf) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Professor where cpf like ?");
			consulta.setString(0, cpf);
			return (Professor) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Professor", "Professor");
		}	
	}

	public void remover(Professor persistentObject) throws DaoException {
		this.remover(persistentObject.getId());
	}

	public void remover (long id) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			Object record = this.carregar(id);
			s.delete(record);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Professor", "Professor");
		}
	}

	public void salvar(Professor newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Professor", "Professor");
		}
	}
	

}