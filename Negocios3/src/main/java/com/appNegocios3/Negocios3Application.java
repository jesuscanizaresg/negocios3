package com.appNegocios3;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dao.InterfazRepositorioTrabajo;
import com.entidades.Empleado2;
import com.entidades.Empresa2;
import com.repositorios.RepositorioEmpleadoJPA;
import com.repositorios.RepositorioEmpresaJPA;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories({"com.repositorios"})
@EntityScan("com.entidades")
@ComponentScan("com.*")
public class Negocios3Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Negocios3Application.class, args);
	}

	@Autowired
	InterfazRepositorioTrabajo repTrabajo;
	
	@Autowired
	RepositorioEmpleadoJPA repJPAempleado;
	
	@Autowired
	RepositorioEmpresaJPA repJPAempresa;
	

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Ejecutando Truncate a empresa2");
		repTrabajo.truncateTabla("empresa2");

		System.out.println("Ejecutando Truncate a empleado2");
		repTrabajo.truncateTabla("empleado2");
		
		
		
		
//		repJPAempleado.deleteAll();
//		repJPAempresa.deleteAll();
		System.out.println("Borrandos todos los datos de base de datos.......");

		Empresa2 empresa1 = new Empresa2("Amazon","955444887",null);
		repJPAempresa.save(empresa1);
		System.out.println("Empresa Guardada correctamente......");
		
		Empleado2 empleado1 = new Empleado2("Pezaeres", "Antonio", null);
		empleado1.setEmpresa2(empresa1);
		repJPAempleado.save(empleado1);
		System.out.println("Empleado creado, y set empresa ejecutado..............");
		
		System.out.println("___---------------------____________");
		System.out.println("Buscando empleado Antonio, que trabaja en amazon.....");
		
		Empleado2 e2 = repJPAempleado.findByNombreEmpleado("Antonio");
		System.out.println("Encontrado: "+e2.getNombreEmpleado()+", que trabaja en: "+e2.getEmpresa2().getNombreEmpresa());
		
		
		System.out.println("----------------------------------");
		System.out.println("Buscando empleado por nombre native query resultado: "+repJPAempleado.devuelveNombreEmpleado("Antonio"));
		
		System.out.println("----------------------------------");
		
		System.out.println("Se han encontrado: "+String.valueOf(repJPAempleado.findByNombreEmpleadoOrIdEmpleados("Antoni", 22).size())+" empleados.");
		//int tamañoLista = repEmpleado.findByNombreEmpleadoOrIdEmpleados("Antonio", 22).size();
		
		
		
		if(repJPAempleado.findByNombreEmpleadoOrIdEmpleados("Antonio", 22).size() > 0) {
			
			repJPAempleado.findByNombreEmpleadoOrIdEmpleados("Antonio", 22).forEach(empleado -> {
				int ee = 0;
				System.out.println("Encontrado empleado: "+(++ee ) + " " + empleado.getNombreEmpleado());
			});
		}else {
			System.out.println("No se han encontrado empleados");
		}
		
		if(repJPAempleado.findBySearchTermJPQL("Antonio").size() >0) {
			repJPAempleado.findBySearchTermJPQL("Antonio").forEach(empleadoEncontrado -> {
				System.out.println("Encontrado empleado con metodo searchTermJPQL: " + empleadoEncontrado.getIdEmpleados()
					+ " nombre: " + empleadoEncontrado.getNombreEmpleado()
					+ " empresa: " + empleadoEncontrado.getEmpresa2().getNombreEmpresa());
			});
		}else {
			System.out.println("No se han encontrado encpleados con serachtTermnJPQL");
		}
		
		if(repJPAempleado.findBySearchTermSQL("Antonio").size() >0) {
			repJPAempleado.findBySearchTermSQL("Antonio").forEach(empleadoEncontrado -> {
				System.out.println("Encontrado empleado con metodo searchTermSQL: " + empleadoEncontrado.getIdEmpleados()
					+ " nombre: " + empleadoEncontrado.getNombreEmpleado()
					+ " empresa: " + empleadoEncontrado.getEmpresa2().getNombreEmpresa());
			});
		}else {
			System.out.println("No se han encontrado encpleados con serachtTermnJPQL");
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("---------------FIN DE CONSULTAS REALIZADAS CON APOYO DE JPA REPOSITORIES, COMIENZO DE EXPERIMENTO CON REPOSITORIO NO JPA CUSTOM-------------------");
		
		
		//Cambio para commit desde casa
		System.out.println("Esto es el último cambio desde casa");
		//System.out.println("Buscando empresa por nombre en interfaz....."+repositorioEmpresa.
		
		
		
	}
	


	
//	@Bean
//	applicacion applicacion() {
//		return new applicacion();
//	}
}
