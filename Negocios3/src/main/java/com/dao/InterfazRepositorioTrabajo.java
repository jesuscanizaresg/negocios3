package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

import com.entidades.Empleado2;



public interface InterfazRepositorioTrabajo {
	
	Empleado2 findById(Long id);
	Empleado2 save(Empleado2 empleado);
	List<Empleado2> findAll();
	
	void miscojonesBellos();
	
	void truncateTabla(String tabla);

}
