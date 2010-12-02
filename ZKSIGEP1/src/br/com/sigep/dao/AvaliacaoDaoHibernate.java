package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Avaliacao;
import br.com.sigep.bean.RegistroDeAula;

public class AvaliacaoDaoHibernate extends HibernateDaoSupport
implements AvaliacaoDaoInterface {

	public void atualizar(Avaliacao transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Avaliacao", "Avaliacao");
		}	
	}

	public Avaliacao carregar(long id) throws DaoException {
		try {
			return (Avaliacao) getHibernateTemplate().get(Avaliacao.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Avaliacao", "Avaliacao");
		}	
	}

	public List<Avaliacao> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Avaliacao");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Avaliacao", "Avaliacao");
		}	
	}
	
	public List<Avaliacao> listarAvaliacaoFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Avaliacao as av where av.descricao like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Avaliacao", "Avaliacao");
		}	
	}

	public void remover(Avaliacao persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Avaliacao", "Avaliacao");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Avaliacao) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Avaliacao", "Avaliacao");
		}
	}

	public void salvar(Avaliacao newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Avaliacao", "Avaliacao");
		}
	}
	

}