package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Frequencia;

public class FrequenciaDaoHibernate extends HibernateDaoSupport
implements FrequenciaDaoInterface {

	public void atualizar(Frequencia transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Frequencia", "Frequencia");
		}	
	}

	public Frequencia carregar(long id) throws DaoException {
		try {
			return (Frequencia) getHibernateTemplate().get(Frequencia.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Frequencia", "Frequencia");
		}	
	}

	public List<Frequencia> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Frequencia");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Frequencia", "Frequencia");
		}	
	}

	public void remover(Frequencia persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Frequencia", "Frequencia");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Frequencia) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Frequencia", "Frequencia");
		}
	}

	public void salvar(Frequencia newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Frequencia", "Frequencia");
		}
	}
	

}