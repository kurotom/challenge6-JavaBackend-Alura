package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hotelalura.models.Reserva;



public class ReservaDAO implements InterfaceReservaDAO {
	
	private Connection conexion;
	
	
	public ReservaDAO(Connection con) {
		this.conexion = con;
	}
	
	
	public void close() {
		try {
			this.conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	

	@Override
	public List<Reserva> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer guardar(Reserva reserva) {
		// TODO Auto-generated method stub
		
		String save = "INSERT INTO "
				+ "reservas(fechaentrada, fechasalida, valor, formapago) "
				+ "VALUES (?, ?, ?, ?);";
		
		try {
			PreparedStatement sentencia = this.conexion.prepareStatement(save, PreparedStatement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, reserva.getFechaentrada());
			sentencia.setString(2, reserva.getFechasalida());
			sentencia.setDouble(3, reserva.getValor());
			sentencia.setString(4, reserva.getFormapago());
			
			sentencia.execute();			
			ResultSet key = sentencia.getGeneratedKeys();
			
			while (key.next()) {				
				System.out.println(key.getInt(1));
				return key.getInt(1); 
			}
			sentencia.close();
			key.close();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return null;
	}

	@Override
	public void eliminar(int idReserva) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(int idReserva) {
		// TODO Auto-generated method stub
		
	}

}
