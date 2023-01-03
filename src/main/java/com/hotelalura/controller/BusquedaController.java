package com.hotelalura.controller;

import java.util.List;
import java.util.Map;

import com.hotelalura.ConnectionFactory.PoolConnection;
import com.hotelalura.dao.BusquedaDAO;
import com.hotelalura.models.Huesped;
import com.hotelalura.models.Reserva;



public class BusquedaController {
	
	private BusquedaDAO busquedaDAO;
	private PoolConnection pool; 
	

	public BusquedaController() {
		PoolConnection conexion = new PoolConnection();
		this.pool = conexion;
		this.busquedaDAO = new BusquedaDAO(conexion.obtenerConexion());
	}
	
	
	public void closeAndDestroy() {
		this.busquedaDAO.close();
		this.pool.destroy();
	}



	public List<Huesped> datosHuespedes() {
		return this.busquedaDAO.listarHuespedes();
	}

	public List<Reserva> datosReservas() {
		return this.busquedaDAO.listarReservas();
	}

	
	
	public Map<String, List<?>> busquedaMatch(String string) {
		return this.busquedaDAO.buscarAllMatch(string);
	}
	

	
	public Integer guardar(Object objetoGuardar) {
		return null;
	}

	
	public boolean modifcar(Reserva editarReserva) {
		// TODO Auto-generated method stub
		return this.busquedaDAO.modificar(editarReserva);
		
	}
	
	public boolean modifcar(Huesped editarHuesped) {
		// TODO Auto-generated method stub
		return this.busquedaDAO.modificar(editarHuesped);
	}



	public boolean eliminar(Integer idRow) {
		return this.busquedaDAO.eliminar(idRow);
	}





	
	
	
	
	
	
	
}
