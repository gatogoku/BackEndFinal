package org.sistema.springmvc.forms.impl;

import javax.sql.DataSource;
import org.sistema.springmvc.forms.models.Delegacion;
import org.sistema.springmvc.formsdao.DelegacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DelegacionDAOHibernate extends GenericDAOHibernate<Delegacion> implements DelegacionDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
}
