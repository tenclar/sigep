package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sigep.bean.Permissao;

public class PermissaoDaoHibernate extends HibernateDaoSupport
implements PermissaoDaoInterface {

	public void atualizar(Permissao transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Permissao", "Permissao");
		}	
	}

	public Permissao carregar(long id) throws DaoException {
		try {
			return (Permissao) getHibernateTemplate().get(Permissao.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Permissao", "Permissao");
		}	
	}

	public List<Permissao> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Permissao");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Permissao", "Permissao");
		}	
	}

	public void remover(Permissao persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Permissao", "Permissao");
		}		
	}

	public List<Permissao> listarPermissaoFiltro(int descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Permissao as permissao where permissao.nivel = ?");
			consulta.setInteger(0,  descricao);
			return consulta.list();
			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Permissão", "Permissao");
		}	
	}	

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Permissao) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Permissao", "Permissao");
		}
	}

	public void salvar(Permissao newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Permissao", "Permissao");
		}
	}
	

}