
package org.sistema.springmvc.forms.impl;

import javax.sql.DataSource;
import org.sistema.springmvc.forms.models.Ciudad;
import org.sistema.springmvc.formsdao.CiudadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CiudadDAOHibernate extends GenericDAOHibernate<Ciudad> implements CiudadDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
}
