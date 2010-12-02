package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.AnoLetivo;
import br.com.sigep.bean.Bloco;
import br.com.sigep.bean.NivelEscolar;
import br.com.sigep.bean.Serie;

public class NivelEscolarDaoHibernate extends HibernateDaoSupport
implements NivelEscolarDaoInterface {

	public void atualizar(NivelEscolar transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.update(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar NivelEscolar", "NivelEscolar");
		}	
	}

	public NivelEscolar carregar(long id) throws DaoException {
		try {
			return (NivelEscolar) getHibernateTemplate().get(NivelEscolar.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar NivelEscolar", "NivelEscolar");
		}	
	}

	public List<NivelEscolar> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from NivelEscolar");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar NivelEscolar", "NivelEscolar");
		}	
	}
	
	public List<NivelEscolar> listarNivelPorAnoLetivo(long idAno) throws DaoException {
		try {
			Query consulta = getSession().createQuery("SELECT n FROM NivelEscolar n, AnoLetivo a, Serie s, Turma t  where a.id = t.anoLetivo and s.id = t.serie and n.id = s.nivelEscolar and a.id = ?");
			//select s.nivelescolar, t.anoletivo from turma t, serie s where t.serie = s.id and  t.anoletivo = 1 group by s.nivelescolar, t.anoletivo
			consulta.setLong(0, idAno);
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Nível Escolar", "Nível Escolar");
		}	
	}
	
	public List<NivelEscolar> listarNivelFiltro(String descricao) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from NivelEscolar as nivelescolar where nivelescolar.nivel like ?");
			consulta.setString(0, "%"+ descricao + "%");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar NivelEscolar", "NivelEscolar");
		}
	}

	
	public void remover(NivelEscolar persistentObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover NivelEscolar", "NivelEscolar");
		}		
	}

	public void remover (long id) throws DaoException {
		try {
			Object record = this.carregar(id);
			this.remover((NivelEscolar) record);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover NivelEscolar", "NivelEscolar");
		}
	}

	public void salvar(NivelEscolar newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar NivelEscolar", "NivelEscolar");
		}
	}
	

}