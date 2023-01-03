package com.hotelalura.dao;

import java.util.List;

import com.hotelalura.models.Reserva;

public interface InterfaceReservaDAO {

	
	public List<Reserva> listar();
	
	public Integer guardar(Reserva reserva);
	
	public void eliminar(int idReserva);
	
	public void modificar(int idReserva);
		

}
