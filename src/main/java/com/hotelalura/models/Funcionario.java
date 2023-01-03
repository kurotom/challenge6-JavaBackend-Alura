package com.hotelalura.models;

public class Funcionario {
	
	private String nombre;
	private String password;
	
	public Funcionario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Nombre: %s, PASS: %s", this.nombre, this.password);
	}
	

}
