package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Bloco;
import br.com.sigep.bean.Sala;

public class BlocoDaoHibernate extends HibernateDaoSupport
implements BlocoDaoInterface {

	public void atualizar(Bloco transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Bloco", "Bloco");
		}	
	}

	public Bloco carregar(long id) throws DaoException {
		try {
			return (Bloco) getHibernateTemplate().get(Bloco.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Bloco", "Bloco");
		}	
	}

	public List<Bloco> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Bloco");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Bloco", "Bloco");
		}	
	}
	
	public List<Bloco> listarBlocoFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Bloco as bloco where bloco.nome like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Bloco", "Bloco");
		}	
	}

	public void remover(Bloco persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Bloco", "Bloco");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Bloco) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Bloco", "Bloco");
		}
	}

	public void salvar(Bloco newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Bloco", "Bloco");
		}
	}
	

}