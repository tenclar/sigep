package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Afastamento;
import br.com.sigep.bean.RegistroDeAula;

public class RegistroDeAulaDaoHibernate extends HibernateDaoSupport
implements RegistroDeAulaDaoInterface {

	public void atualizar(RegistroDeAula transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar RegistroDeAula", "RegistroDeAula");
		}	
	}

	public RegistroDeAula carregar(long id) throws DaoException {
		try {
			return (RegistroDeAula) getHibernateTemplate().get(RegistroDeAula.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar RegistroDeAula", "RegistroDeAula");
		}	
	}

	public List<RegistroDeAula> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RegistroDeAula");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar RegistroDeAula", "RegistroDeAula");
		}	
	}

	public List<RegistroDeAula> listarRegistroDeAulaFiltro(String assunto) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from RegistroDeAula as ra where ra.assunto like ?");
			consulta.setString(0, "%"+ assunto + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar RegistroDeAula", "RegistroDeAula");
		}	
	}
	
	public void remover(RegistroDeAula persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RegistroDeAula", "RegistroDeAula");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((RegistroDeAula) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover RegistroDeAula", "RegistroDeAula");
		}
	}

	public void salvar(RegistroDeAula newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar RegistroDeAula", "RegistroDeAula");
		}
	}
	

}