package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.Resultado;

public class ResultadoDaoHibernate extends HibernateDaoSupport
implements ResultadoDaoInterface {

	public void atualizar(Resultado transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Resultado", "Resultado");
		}	
	}

	public Resultado carregar(long id) throws DaoException {
		try {
			return (Resultado) getHibernateTemplate().get(Resultado.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Resultado", "Resultado");
		}	
	}

	public List<Resultado> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Resultado");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Resultado", "Resultado");
		}	
	}
	
	public List<Resultado> listarResultadoPorAlunoRegistroDeDisciplinaPeriodoEEtapa(long idAluno, long idRegistro, String periodo, String etapa) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Resultado r where r.aluno.id = ? and r.avaliacao.registroDeDisciplina.id = ? and r.avaliacao.periodo like ? and r.avaliacao.etapa like ?");
			consulta.setLong(0, idAluno);
			consulta.setLong(1, idRegistro);
			consulta.setString(2, periodo);
			consulta.setString(3, etapa);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Resultado", "Resultado");
		}	
	}
	
	public void remover(Resultado persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Resultado", "Resultado");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((Resultado) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Resultado", "Resultado");
		}
	}

	public void salvar(Resultado newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Resultado", "Resultado");
		}
	}
	

}