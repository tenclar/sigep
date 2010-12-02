package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Afastamento;
import br.com.sigep.bean.Ocorrencia;

public class OcorrenciaDaoHibernate extends HibernateDaoSupport
implements OcorrenciaDaoInterface {

	public void atualizar(Ocorrencia transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Ocorrencia", "Ocorrencia");
		}	
	}

	public Ocorrencia carregar(long id) throws DaoException {
		try {
			return (Ocorrencia) getHibernateTemplate().get(Ocorrencia.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Ocorrencia", "Ocorrencia");
		}	
	}

	public List<Ocorrencia> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Ocorrencia");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Ocorrencia", "Ocorrencia");
		}	
	}

	public List<Ocorrencia> listarOcorrenciaFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Ocorrencia as oco where oco.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Ocorrencia", "Ocorrencia");
		}	
	}
	
	public void remover(Ocorrencia persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Ocorrencia", "Ocorrencia");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Ocorrencia) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Ocorrencia", "Ocorrencia");
		}
	}

	public void salvar(Ocorrencia newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Ocorrencia", "Ocorrencia");
		}
	}
	

}