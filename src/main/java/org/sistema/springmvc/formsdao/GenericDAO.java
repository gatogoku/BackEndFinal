package org.sistema.springmvc.formsdao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

public interface GenericDAO<T> {

	public T selectById(Serializable id, Class<T> entityClass) throws HibernateException;

	public List<T> selectAll(Class<T> entity) throws HibernateException;

	public boolean insert(T entity) throws HibernateException;

	public void update(T entity) throws HibernateException;

	public void delete(T entity) throws HibernateException;

}