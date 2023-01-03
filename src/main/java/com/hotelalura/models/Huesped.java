package com.hotelalura.models;

//import java.sql.Date;

public class Huesped {
	
	private int id;
	private String nombre;
	private String apellido;
	private String fechanacimiento;
	private String nacionalidad;
	private String telefono;
	private int idreserva;
	
	
	public Huesped(
			String nombre, 
			String apellido, 
			String fechanacimiento,
			String nacionalidad,
			String telefono
			) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huesped(
			int id,
			String nombre, 
			String apellido, 
			String fechanacimiento,
			String nacionalidad,
			String telefono
			) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huesped(
			String nombre, 
			String apellido, 
			String fechanacimiento,
			String nacionalidad,
			String telefono,
			Integer reservaid
			) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = reservaid;
	}

	
	public Huesped(
			Integer id,
			String nombre, 
			String apellido, 
			String fechanacimiento,
			String nacionalidad,
			String telefono,
			Integer reservaid
			) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = reservaid;
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getIdreserva() {
		return this.idreserva;
	}
	
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	
	
	
	@Override
	public String toString() {
		return String.format(
				"Nombre: %s, Apellido: %s, Telefono: %s, Nacionalidad: %s, Reserva: %d",
				this.nombre,
				this.apellido,
				this.telefono,
				this.nacionalidad,
				this.idreserva
				);
	}
	

}
