package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.TipoDeUsuario;

public class TipoDeUsuarioDaoHibernate extends HibernateDaoSupport
implements TipoDeUsuarioDaoInterface {

	public void atualizar(TipoDeUsuario transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar TipoDeUsuario", "TipoDeUsuario");
		}	
	}

	public TipoDeUsuario carregar(long id) throws DaoException {
		try {
			return (TipoDeUsuario) getHibernateTemplate().get(TipoDeUsuario.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar TipoDeUsuario", "TipoDeUsuario");
		}	
	}

	public List<TipoDeUsuario> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from TipoDeUsuario");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar TipoDeUsuario", "TipoDeUsuario");
		}	
	}
	
	public List<TipoDeUsuario> listarTipoDeUsuarioFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from TipoDeUsuario as tipodeusuario where tipodeusuario.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Tipo De Usuário", "TipoDeUsuario");
		}	
	}


	public void remover(TipoDeUsuario persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover TipoDeUsuario", "TipoDeUsuario");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((TipoDeUsuario) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover TipoDeUsuario", "TipoDeUsuario");
		}
	}

	public void salvar(TipoDeUsuario newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar TipoDeUsuario", "TipoDeUsuario");
		}
	}
	

}