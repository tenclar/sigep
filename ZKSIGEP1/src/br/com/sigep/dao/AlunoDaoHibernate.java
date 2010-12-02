package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Aluno;

public class AlunoDaoHibernate extends HibernateDaoSupport
implements AlunoDaoInterface {

	public void atualizar(Aluno transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			//utilizando merge ao invés de update para evitar erro de duas sessões abertas
			//causado quando um objeto associado a uma sessão tenta ser alterado por outra sessão do hibernate.
			s.merge(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Aluno", "Aluno");
		}	
	}

	public Aluno carregar(long id) throws DaoException {
		try {
			return (Aluno) getHibernateTemplate().get(Aluno.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Aluno", "Aluno");
		}	
	}

	public List<Aluno> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Aluno");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Aluno", "Aluno");
		}	
	}
	
	public List<Aluno> listarAlunoFiltro(String nome) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Aluno as al where al.nome like ?");
			consulta.setString(0, "%"+ nome + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Aluno", "Aluno");
		}	
	}
	
	public void remover(Aluno persistentObject) throws DaoException {
		this.remover(persistentObject.getId());
	}
	
	
	public Aluno procurarAlunoPorRg(String rg) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Aluno where rg like ?");
			consulta.setString(0, rg);
			return (Aluno) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Aluno", "Aluno");
		}	
	}
	
	public Aluno procurarAlunoPorLogin(String login) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Aluno a where a.usuario.usuario = ?");
			consulta.setString(0, login);
			return (Aluno) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Aluno", "Aluno");
		}	
	}

public Aluno procurarAlunoPorCPF(String cpf) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Aluno where cpf like ?");
			consulta.setString(0, cpf);
			return (Aluno) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Aluno", "Aluno");
		}	
	}	


	public void remover (long id) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			Object record = this.carregar(id);
			s.delete(record);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Remover Aluno", "Aluno");
		}
	}

	public void salvar(Aluno newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Aluno", "Aluno");
		}
	}
	

}