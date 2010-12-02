package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.DadosFuncionais;

public class DadosFuncionaisDaoHibernate extends HibernateDaoSupport
implements DadosFuncionaisDaoInterface {

	public void atualizar(DadosFuncionais transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar DadosFuncionais", "DadosFuncionais");
		}	
	}

	public DadosFuncionais carregar(long id) throws DaoException {
		try {
			return (DadosFuncionais) getHibernateTemplate().get(DadosFuncionais.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar DadosFuncionais", "DadosFuncionais");
		}	
	}

	public List<DadosFuncionais> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from DadosFuncionais");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar DadosFuncionais", "DadosFuncionais");
		}	
	}

	public void remover(DadosFuncionais persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover DadosFuncionais", "DadosFuncionais");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((DadosFuncionais) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover DadosFuncionais", "DadosFuncionais");
		}
	}

	public void salvar(DadosFuncionais newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar DadosFuncionais", "DadosFuncionais");
		}
	}
	

}