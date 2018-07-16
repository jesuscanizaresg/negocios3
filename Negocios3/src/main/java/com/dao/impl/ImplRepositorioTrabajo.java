package com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

//import org.hibernate.jpa.event.spi.JpaIntegrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.InterfazRepositorioTrabajo;
import com.entidades.Empleado2;

@Repository
public class ImplRepositorioTrabajo implements InterfazRepositorioTrabajo {

	@Autowired
	EntityManager entitymana;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public ImplRepositorioTrabajo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Empleado2 findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado2 save(Empleado2 empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado2> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void miscojonesBellos() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Modifying
	@Override
	public void truncateTabla(String tabla) {
		// TODO Auto-generated method stub
		jdbctemplate.execute("SET FOREIGN_KEY_CHECKS  = 0;");
		jdbctemplate.execute("TRUNCATE "+tabla);
		jdbctemplate.execute("SET FOREIGN_KEY_CHECKS  = 1;");
	}

}
