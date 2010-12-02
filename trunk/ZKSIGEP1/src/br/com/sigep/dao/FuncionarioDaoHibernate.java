package br.com.sigep.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Session;

import br.com.sigep.bean.Aluno;
import br.com.sigep.bean.Funcionario;

public class FuncionarioDaoHibernate extends HibernateDaoSupport
implements FuncionarioDaoInterface {

	public void atualizar(Funcionario transientObject) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.merge(transientObject);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Atualizar Funcionario", "Funcionario");
		}	
	}

	public Funcionario carregar(long id) throws DaoException {
		try {
			return (Funcionario) getHibernateTemplate().get(Funcionario.class, id);
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Carregar Funcionario", "Funcionario");
		}	
	}
	
	public Funcionario procurarFuncionarioPorCPF(String cpf) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Funcionario where cpf = ?");
			consulta.setString(0, cpf);
			return (Funcionario) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Funcionário", "Funcionario");
		}	
	}	
	
	public Funcionario procurarFuncionarioPorRg(String rg) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Funcionario where rg like ?");
			consulta.setString(0, rg);
			return (Funcionario) consulta.uniqueResult();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Procurar Funcionario", "Funcionario");
		}	
	}

	public List<Funcionario> listar() throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Funcionario as fn where fn.funcao <> 'Professor'");
			return consulta.list();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Funcionario", "Funcionario");
		}	
	}

	public List<Funcionario> listarFuncionarioFiltro(String nome) throws DaoException {
		try {
			Query consulta = getSession().createQuery("from Funcionario as fn where fn.nome like ?");
			consulta.setString(0, "%"+ nome + "%");
			return consulta.list();			
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Listar Funcionario", "Funcionario");
		}	
	}
	
	public void remover(Funcionario persistentObject) throws DaoException {
		this.remover(persistentObject.getId());
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
			throw new DaoException("Erro ao Remover Funcionario", "Funcionario");
		}
	}

	public void salvar(Funcionario newInstance) throws DaoException {
		try {
			Session s = getHibernateTemplate().getSessionFactory().openSession();
			s.beginTransaction();
			s.saveOrUpdate(newInstance);
			s.getTransaction().commit();
		} catch(DataAccessException ex) {
			ex.printStackTrace();
			throw new DaoException("Erro ao Salvar Funcionario", "Funcionario");
		}
	}
	

}