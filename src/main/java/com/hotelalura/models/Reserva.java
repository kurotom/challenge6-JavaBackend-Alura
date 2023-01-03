package com.hotelalura.models;

import java.sql.Date;


public class Reserva {
	
	private Integer id;
	private String fechaentrada;
	private String fechasalida;
	private Double valor;
	private String formapago;
	
	

	public Reserva(
			String fechaentrada,
			String fechasalida,
			Double valor,
			String formapago
			) {
		
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.valor = valor;
		this.formapago = formapago;
	}
	
	public Reserva(
			Integer id,
			String fechaentrada,
			String fechasalida,
			Double valor,
			String formapago
			) {
		
		this.id = id;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.valor = valor;
		this.formapago = formapago;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getFechaentrada() {
		return this.fechaentrada;
	}

	public void setFechaentrada(String fechaentrada) {
		this.fechaentrada = fechaentrada;
	}


	public String getFechasalida() {
		return this.fechasalida;
	}

	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}


	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getFormapago() {
		return this.formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Reserva ID: %d, Entrada: %s, Salida: %s, Valor: %s",
				this.id,
				this.fechaentrada.toString(),
				this.fechasalida.toString(),
				this.valor
				);
	}
	

}
