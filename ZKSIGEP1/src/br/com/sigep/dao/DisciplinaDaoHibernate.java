package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Disciplina;
import br.com.sigep.bean.Sala;

public class DisciplinaDaoHibernate extends HibernateDaoSupport
implements DisciplinaDaoInterface {

	public void atualizar(Disciplina transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Disciplina", "Disciplina");
		}	
	}

	public Disciplina carregar(long id) throws DaoException {
		try {
			return (Disciplina) getHibernateTemplate().get(Disciplina.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Disciplina", "Disciplina");
		}	
	}

	public List<Disciplina> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Disciplina");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Disciplina", "Disciplina");
		}	
	}
	
	public List<Disciplina> listarDisciplinaSerie(long serie) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Disciplina where serie = ?");
			consulta.setLong(0, serie);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Disciplina", "Disciplina");
		}	
	}

	public List<Disciplina> listarDisciplinaFiltro(String nome) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Disciplina as disc where disc.nome like ?");
			consulta.setString(0, "%"+ nome + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Disciplina", "Disciplina");
		}
	}
	
	public void remover(Disciplina persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Disciplina", "Disciplina");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Disciplina) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Disciplina", "Disciplina");
		}
	}

	public void salvar(Disciplina newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Disciplina", "Disciplina");
		}
	}
	

}