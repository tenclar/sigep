package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Matricula;
import br.com.sigep.bean.OutrosVinculos;

public class OutrosVinculosDaoHibernate extends HibernateDaoSupport
implements OutrosVinculosDaoInterface {

	public void atualizar(OutrosVinculos transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar OutrosVinculos", "OutrosVinculos");
		}	
	}

	public OutrosVinculos carregar(long id) throws DaoException {
		try {
			return (OutrosVinculos) getHibernateTemplate().get(OutrosVinculos.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar OutrosVinculos", "OutrosVinculos");
		}	
	}

	public List<OutrosVinculos> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from OutrosVinculos");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar OutrosVinculos", "OutrosVinculos");
		}	
	}
	
	public List<OutrosVinculos> listarOutrosVinculosFuncionario(long idFuncionario) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from OutrosVinculos where idfuncionario = ?");
			consulta.setLong(0, idFuncionario);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Outros Vínculos", "Outros Vínculos");
		}	
	}

	public void remover(OutrosVinculos persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover OutrosVinculos", "OutrosVinculos");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((OutrosVinculos) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover OutrosVinculos", "OutrosVinculos");
		}
	}

	public void salvar(OutrosVinculos newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar OutrosVinculos", "OutrosVinculos");
		}
	}
	

}