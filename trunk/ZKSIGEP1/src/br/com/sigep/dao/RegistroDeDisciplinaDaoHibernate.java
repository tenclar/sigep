package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.RegistroDeDisciplina;

public class RegistroDeDisciplinaDaoHibernate extends HibernateDaoSupport
implements RegistroDeDisciplinaDaoInterface {

	public void atualizar(RegistroDeDisciplina transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar RegistroDeDisciplina", "RegistroDeDisciplina");
		}	
	}

	public RegistroDeDisciplina carregar(long id) throws DaoException {
		try {
			return (RegistroDeDisciplina) getHibernateTemplate().get(RegistroDeDisciplina.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar RegistroDeDisciplina", "RegistroDeDisciplina");
		}	
	}

	public List<RegistroDeDisciplina> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RegistroDeDisciplina");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar RegistroDeDisciplina", "RegistroDeDisciplina");
		}	
	}
	
	public List<Disciplina> listarDisciplinaTurma(long turma) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RegistroDeDisciplina where turma = ?");
			consulta.setLong(0, turma);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Disciplina", "Disciplina");
		}
	}
	
	public List<RegistroDeDisciplina> listarRegistroDeDisciplinaTurma(long turma) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RegistroDeDisciplina where turma = ?");
			consulta.setLong(0, turma);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar RegistroDeDisciplina", "RegistroDeDisciplina");
		}
	}

	public void remover(RegistroDeDisciplina persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RegistroDeDisciplina", "RegistroDeDisciplina");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((RegistroDeDisciplina) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RegistroDeDisciplina", "RegistroDeDisciplina");
		}
	}

	public void salvar(RegistroDeDisciplina newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar RegistroDeDisciplina", "RegistroDeDisciplina");
		}
	}
	

}