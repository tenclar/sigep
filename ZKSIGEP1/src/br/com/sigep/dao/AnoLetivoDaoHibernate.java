package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;
import br.com.sigep.bean.AnoLetivo;

public class AnoLetivoDaoHibernate extends HibernateDaoSupport
implements AnoLetivoDaoInterface {

	public void atualizar(AnoLetivo transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar AnoLetivo", "AnoLetivo");
		}	
	}

	public AnoLetivo carregar(long id) throws DaoException {
		try {
			return (AnoLetivo) getHibernateTemplate().get(AnoLetivo.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar AnoLetivo", "AnoLetivo");
		}	
	}

	public List<AnoLetivo> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from AnoLetivo");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar AnoLetivo", "AnoLetivo");
		}	
	}
	
	public List<AnoLetivo> listarAnoLetivoPorMatriculaAluno(long idAluno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("FROM AnoLetivo WHERE id = (SELECT anoLetivo FROM Turma WHERE id = (SELECT turma FROM Matricula WHERE idAluno = (SELECT id FROM Aluno WHERE id = ?)))");
			consulta.setLong(0, idAluno);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar AnoLetivo", "AnoLetivo");
		}	
	}
	
	public List<AnoLetivo> listarAnoLetivoFiltro(int descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from AnoLetivo as anoletivo where anoletivo.ano = ?");
			consulta.setLong(0, descricao);
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar AnoLetivo", "AnoLetivo");
		}
	}
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoNaoFoiMatriculado(long idAluno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from AnoLetivo where id not in (select anoLetivo from Turma where id in (select turma from Matricula where idAluno = (select id from Aluno where id = ?)))");
			consulta.setLong(0, idAluno);
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar AnoLetivo", "AnoLetivo");
		}
	}
	
	public List<AnoLetivo> listarAnoLetivoNosQuaisOAlunoFoiMatriculado(long idAluno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from AnoLetivo where id in (select anoLetivo from Turma where id in (select turma from Matricula where idAluno = (select id from Aluno where id = ?)))");
			consulta.setLong(0, idAluno);
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar AnoLetivo", "AnoLetivo");
		}
	}



	public void remover(AnoLetivo persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover AnoLetivo", "AnoLetivo");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((AnoLetivo) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover AnoLetivo", "AnoLetivo");
		}
	}

	public void salvar(AnoLetivo newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar AnoLetivo", "AnoLetivo");
		}
	}
	

}