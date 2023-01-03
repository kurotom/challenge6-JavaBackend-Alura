package com.hotelalura.controller;

import java.sql.Connection;

import com.hotelalura.ConnectionFactory.PoolConnection;
import com.hotelalura.dao.HuespedDAO;
import com.hotelalura.models.Huesped;



public class HuespedController {
	
	private HuespedDAO huespedDAO;
	private PoolConnection clasePOOL;
	

	public HuespedController() {		
		
		PoolConnection pool = new PoolConnection();
		Connection conexionDB = pool.obtenerConexion();
		this.huespedDAO = new HuespedDAO(conexionDB);
		
		this.clasePOOL = pool;
	}
	
	
	public void closeAndDestroy() {
		this.huespedDAO.close();
		this.clasePOOL.destroy();
	}
	
	
	
	public boolean guardar(Huesped huesped) {
		try {
			return this.huespedDAO.guardar(huesped);
		} finally {
			this.clasePOOL.destroy();
		}
	}
	
	
}
