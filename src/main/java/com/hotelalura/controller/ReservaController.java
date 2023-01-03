package com.hotelalura.controller;


import java.util.List;

import com.hotelalura.ConnectionFactory.PoolConnection;
import com.hotelalura.dao.ReservaDAO;
import com.hotelalura.models.Reserva;



public class ReservaController {
	
	private ReservaDAO reservaDAO;
	PoolConnection poolClase = null;
	
	public ReservaController() {
				
		PoolConnection pool = new PoolConnection();
		this.reservaDAO = new ReservaDAO(pool.obtenerConexion());
		
		this.poolClase = pool;
		
	}
	
	public void closeAndDestroy() {
		this.reservaDAO.close();
		this.poolClase.destroy();
	}
	

	
	public List<Reserva> listar() {
		return this.reservaDAO.listar();
	}
	
	
	public Integer guardar(Reserva reserva) {
		try {
			return this.reservaDAO.guardar(reserva);
		} finally {
			this.poolClase.destroy();
		}
	}

	public void modificar(Object objetoModificar) {
	}

	public void eliminar(Integer idObjeto) {		
	}

	
	
	

}
