package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Pessoa;
import hibernate.util.HibernateUtil;

public class PessoaDAO {
	
	public Pessoa getPessoa(long id) {
		Transaction transaction = null;
		Pessoa pessoa = null;
		
		try(Session session = HibernateUtil.getSession().openSession()) {
			transaction = session.beginTransaction();
			
			pessoa = session.get(Pessoa.class, id);
			
			transaction.commit();
			
			return pessoa;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return null;
	}
	
	public void deletaPessoa(long id) {
		Transaction transaction = null;
		Pessoa pessoa = null;
		
		try(Session session = HibernateUtil.getSession().openSession()) {
			transaction = session.beginTransaction();
			
			pessoa = session.get(Pessoa.class, id);
			session.delete(pessoa);
			
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void alteraPessoa(Pessoa pessoa) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(pessoa);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void criarPessoa(Pessoa pessoa) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSession().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.save(pessoa);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
}
