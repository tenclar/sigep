package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Sala;

public class SalaDaoHibernate extends HibernateDaoSupport
implements SalaDaoInterface {

	public void atualizar(Sala transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Sala", "Sala");
		}	
	}

	public Sala carregar(long id) throws DaoException {
		try {
			return (Sala) getHibernateTemplate().get(Sala.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Sala", "Sala");
		}	
	}

	public List<Sala> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Sala");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Sala", "Sala");
		}	
	}
	
	public List<Sala> listarSalaFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Sala as sala where sala.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Sala", "Sala");
		}	
	}


	public void remover(Sala persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Sala", "Sala");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Sala) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Sala", "Sala");
		}
	}

	public void salvar(Sala newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Sala", "Sala");
		}
	}
	

}