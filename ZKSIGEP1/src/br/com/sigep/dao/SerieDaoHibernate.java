package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Sala;
import br.com.sigep.bean.Serie;

public class SerieDaoHibernate extends HibernateDaoSupport
implements SerieDaoInterface {

	public void atualizar(Serie transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Serie", "Serie");
		}	
	}

	public Serie carregar(long id) throws DaoException {
		try {
			return (Serie) getHibernateTemplate().get(Serie.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Serie", "Serie");
		}	
	}

	public List<Serie> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Serie");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Serie", "Serie");
		}	
	}
	
	public List<Serie> listarSerieFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Serie as serie where serie.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Serie", "Serie");
		}	
	}
	
	public List<Serie> listarSerieNivel(long id) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Serie where nivelescolar = ?");
			consulta.setLong(0, id);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Serie", "Serie");
		}	
	}

	public void remover(Serie persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Serie", "Serie");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Serie) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Serie", "Serie");
		}
	}

	public void salvar(Serie newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Serie", "Serie");
		}
	}
	

}