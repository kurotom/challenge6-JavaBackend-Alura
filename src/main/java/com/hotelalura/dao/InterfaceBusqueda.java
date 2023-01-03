package com.hotelalura.dao;

import java.util.List;

import com.hotelalura.models.Huesped;
import com.hotelalura.models.Reserva;



public interface InterfaceBusqueda {
	

	public List<Reserva> listarReservas();
	
	public List<Huesped> listarHuespedes();
	
	public Integer guardar(Object objetoGuardar);
	
	public boolean modificar(Reserva objetoReserva);
	
	public boolean modificar(Huesped objetoHuesped);
	
	public boolean eliminar(Integer idObjeto);

}
