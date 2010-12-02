package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Formacao;
import br.com.sigep.bean.OutrosVinculos;

public class FormacaoDaoHibernate extends HibernateDaoSupport
implements FormacaoDaoInterface {

	public void atualizar(Formacao transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Formacao", "Formacao");
		}	
	}

	public Formacao carregar(long id) throws DaoException {
		try {
			return (Formacao) getHibernateTemplate().get(Formacao.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Formacao", "Formacao");
		}	
	}

	public List<Formacao> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Formacao");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Formacao", "Formacao");
		}	
	}
	
	public List<Formacao> listarFormacaoFuncionario(long idFuncionario) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Formacao where idfuncionario = ?");
			consulta.setLong(0, idFuncionario);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Formacao", "Formacao");
		}	
	}

	public void remover(Formacao persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Formacao", "Formacao");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Formacao) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Formacao", "Formacao");
		}
	}

	public void salvar(Formacao newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Formacao", "Formacao");
		}
	}
	

}