/**
 * 
 */
package org.sistema.springmvc.forms.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.springmvc.forms.hibernate.HibernateSession;
import org.sistema.springmvc.forms.hibernate.HibernateUtil;
import org.sistema.springmvc.formsdao.GenericDAO;

public class GenericDAOHibernate<T> implements GenericDAO<T> {

	SessionFactory sessionFactory;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	protected void startTransaction() {
		sessionFactory = HibernateSession.getSessionFactory();
		session = sessionFactory.openSession();
		session = HibernateUtil.getSession();
		session.getTransaction().begin();
	}

	protected void endTransaction() {
		if (null != session && session.isOpen()) {
			session.getTransaction().commit();
			session.close();
		}
	}

	protected void handleException(HibernateException he) throws HibernateException {
		System.out.println("Exception: " + he.getMessage());
		if (null != session && session.isOpen()) {
			session.getTransaction().rollback();
		}
		throw he;
	}

	protected Session getSession() {
		return session;
	}

	public boolean insert(T entity) throws HibernateException {
		try {
			startTransaction();
			getSession().save(entity);
			return true;
		} catch (HibernateException he) {
			System.out.println("excep");
			handleException(he);
		} finally {
			System.out.println("Listo ");
			endTransaction();
		}
		return false;
	}

	public void update(T entity) throws HibernateException {
		try {
			startTransaction();
			getSession().merge(entity);
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
	}

	public T selectById(Serializable id, Class<T> entityClass) throws HibernateException {
		T obj = null;
		try {
			startTransaction();
			obj = (T) getSession().get(entityClass, id);
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
		return obj;
	}

	public List<T> selectAll(Class entityClass) throws HibernateException {
		List<T> result = null;
		try {
			startTransaction();
			result = getSession().createQuery("From " + entityClass.getSimpleName()).list();

		} catch (HibernateException he) {

			handleException(he);
		} finally {
			endTransaction();
		}
		return result;
	}

	public void delete(T entityClass) throws HibernateException {
		try {
			startTransaction();
			getSession().delete(entityClass);
			getSession().flush();
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}

	}

}
