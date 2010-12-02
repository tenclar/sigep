package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Bloco;
import br.com.sigep.bean.Turma;

public class TurmaDaoHibernate extends HibernateDaoSupport
implements TurmaDaoInterface {

	public void atualizar(Turma transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Turma", "Turma");
		}	
	}

	public Turma carregar(long id) throws DaoException {
		try {
			return (Turma) getHibernateTemplate().get(Turma.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Turma", "Turma");
		}	
	}

	public List<Turma> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Turma");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Turma", "Turma");
		}	
	}
	
	public List<Turma> listarTurmaSerie(long id, long idAno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Turma where serie = ? and anoletivo = ?");
			consulta.setLong(0, id);
			consulta.setLong(1, idAno);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Turma", "Turma");
		}	
	}
	
	public List<Turma> listarTurmaFiltro(String nome) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Turma as turma where turma.nome like ?");
			consulta.setString(0, "%"+ nome + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Turma", "Turma");
		}	
	}
	
	public List<Turma> listarTurmaSerieTurno(long id, String turno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Turma where serie = ? and turno = ?");
			consulta.setLong(0, id);
			consulta.setString(1, turno);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Turma", "Turma");
		}	
	}

	public void remover(Turma persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Turma", "Turma");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Turma) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Turma", "Turma");
		}
	}

	public void salvar(Turma newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Turma", "Turma");
		}
	}
	

}