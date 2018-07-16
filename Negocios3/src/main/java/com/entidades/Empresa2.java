package com.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa2 database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa2.findAll", query="SELECT e FROM Empresa2 e")
public class Empresa2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private int idEmpresa;
	
	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="telefono_empresa")
	private String telefonoEmpresa;

	//bi-directional many-to-one association to Empleado2
	@OneToMany(mappedBy="empresa2")
	private List<Empleado2> empleado2s;

	public Empresa2() {
	}

	public Empresa2(String nombreEmpresa, String telefonoEmpresa, List<Empleado2> empleado2s) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.empleado2s = empleado2s;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefonoEmpresa() {
		return this.telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public List<Empleado2> getEmpleado2s() {
		return this.empleado2s;
	}

	public void setEmpleado2s(List<Empleado2> empleado2s) {
		this.empleado2s = empleado2s;
	}

	public Empleado2 addEmpleado2(Empleado2 empleado2) {
		getEmpleado2s().add(empleado2);
		empleado2.setEmpresa2(this);

		return empleado2;
	}

	public Empleado2 removeEmpleado2(Empleado2 empleado2) {
		getEmpleado2s().remove(empleado2);
		empleado2.setEmpresa2(null);

		return empleado2;
	}

}