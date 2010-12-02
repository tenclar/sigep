package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.DadosBancarios;

public class DadosBancariosDaoHibernate extends HibernateDaoSupport
implements DadosBancariosDaoInterface {

	public void atualizar(DadosBancarios transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar DadosBancarios", "DadosBancarios");
		}	
	}

	public DadosBancarios carregar(long id) throws DaoException {
		try {
			return (DadosBancarios) getHibernateTemplate().get(DadosBancarios.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar DadosBancarios", "DadosBancarios");
		}	
	}

	public List<DadosBancarios> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from DadosBancarios");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar DadosBancarios", "DadosBancarios");
		}	
	}

	public void remover(DadosBancarios persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover DadosBancarios", "DadosBancarios");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((DadosBancarios) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover DadosBancarios", "DadosBancarios");
		}
	}

	public void salvar(DadosBancarios newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar DadosBancarios", "DadosBancarios");
		}
	}
	

}