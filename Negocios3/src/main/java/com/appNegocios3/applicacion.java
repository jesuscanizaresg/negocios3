package com.appNegocios3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.dao.InterfazRepositorioTrabajo;


@Controller
public class applicacion {

	@Autowired
	InterfazRepositorioTrabajo repositorioTrabajo;
	
	public applicacion() {
		// TODO Auto-generated constructor stub
	}

}
