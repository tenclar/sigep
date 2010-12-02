package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Afastamento;

public class AfastamentoDaoHibernate extends HibernateDaoSupport
implements AfastamentoDaoInterface {

	public void atualizar(Afastamento transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Afastamento", "Afastamento");
		}	
	}

	public Afastamento carregar(long id) throws DaoException {
		try {
			return (Afastamento) getHibernateTemplate().get(Afastamento.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Afastamento", "Afastamento");
		}	
	}

	public List<Afastamento> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Afastamento");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Afastamento", "Afastamento");
		}	
	}
	
	public List<Afastamento> listarAfastamentoFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Afastamento as afas where afas.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Afastamento", "Afastamento");
		}	
	}

	public void remover(Afastamento persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Afastamento", "Afastamento");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Afastamento) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Afastamento", "Afastamento");
		}
	}

	public void salvar(Afastamento newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Afastamento", "Afastamento");
		}
	}
	

}