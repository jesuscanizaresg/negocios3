package com.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado2 database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado2.findAll", query="SELECT e FROM Empleado2 e")
public class Empleado2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="apellido_empleado")
	private String apellidoEmpleado;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleados")
	private int idEmpleados;

	@Column(name="nombre_empleado")
	private String nombreEmpleado;

	//bi-directional many-to-one association to Empresa2
	@ManyToOne
	@JoinColumn(name="empresa_empleado", referencedColumnName="id_empresa")
	private Empresa2 empresa2;

	public Empleado2() {
	}
	

	public Empleado2(String apellidoEmpleado, String nombreEmpleado, Empresa2 empresa2) {
		super();
		this.apellidoEmpleado = apellidoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.empresa2 = empresa2;
	}


	public String getApellidoEmpleado() {
		return this.apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public int getIdEmpleados() {
		return this.idEmpleados;
	}

	public void setIdEmpleados(int idEmpleados) {
		this.idEmpleados = idEmpleados;
	}

	public String getNombreEmpleado() {
		return this.nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Empresa2 getEmpresa2() {
		return this.empresa2;
	}

	public void setEmpresa2(Empresa2 empresa2) {
		this.empresa2 = empresa2;
	}

}