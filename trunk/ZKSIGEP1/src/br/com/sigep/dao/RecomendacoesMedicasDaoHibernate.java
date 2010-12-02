package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.RecomendacoesMedicas;

public class RecomendacoesMedicasDaoHibernate extends HibernateDaoSupport
implements RecomendacoesMedicasDaoInterface {

	public void atualizar(RecomendacoesMedicas transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar RecomendacoesMedicas", "RecomendacoesMedicas");
		}	
	}

	public RecomendacoesMedicas carregar(long id) throws DaoException {
		try {
			return (RecomendacoesMedicas) getHibernateTemplate().get(RecomendacoesMedicas.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar RecomendacoesMedicas", "RecomendacoesMedicas");
		}	
	}

	public List<RecomendacoesMedicas> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RecomendacoesMedicas");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar RecomendacoesMedicas", "RecomendacoesMedicas");
		}	
	}

	public void remover(RecomendacoesMedicas persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RecomendacoesMedicas", "RecomendacoesMedicas");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((RecomendacoesMedicas) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RecomendacoesMedicas", "RecomendacoesMedicas");
		}
	}

	public void salvar(RecomendacoesMedicas newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar RecomendacoesMedicas", "RecomendacoesMedicas");
		}
	}
	

}