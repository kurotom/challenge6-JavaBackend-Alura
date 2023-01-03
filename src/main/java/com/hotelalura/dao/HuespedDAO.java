package com.hotelalura.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hotelalura.models.Huesped;


public class HuespedDAO implements InterfaceHuespedDAO {
	
	private Connection conexion;
	
	
	public HuespedDAO(Connection conexion) {
		this.conexion = conexion;
	}	
	

	public void close() {
		try {
			if (this.conexion.isClosed() != true) {
				this.conexion.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	

	@Override
	public List<Huesped> listar() {
		// TODO Auto-generated method stub
		
		List<Huesped> lista = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM huespedes;";
			
			final PreparedStatement sentence = this.conexion.prepareStatement(query);
			
			try {
				
				sentence.execute();
				
				ResultSet resultado = sentence.getResultSet();
				
				try {
					
					while (resultado.next()) {
						
						lista.add(new Huesped(
								resultado.getInt("ID"),
								resultado.getString("NOMBRE"),
								resultado.getString("APELLIDO"),
								resultado.getString("FECHANACIMIENTO"),
								resultado.getString("NACIONALIDAD"),
								resultado.getString("TELEFONO")
							));
						
					}
					resultado.close();
					
				} catch (Exception e) {
					resultado.close();
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			
				sentence.close();
				return lista;
				
			} catch (Exception e) {
				sentence.close();
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean guardar(Huesped huesped) {
		System.out.println(huesped);
		
		String query = "INSERT INTO "
				+ "huespedes(nombre, apellido, fechanacimiento, "
				+ "nacionalidad, telefono, idreserva) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
				
		try {
			PreparedStatement sentencia = this.conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			try (sentencia) {
				
				sentencia.setString(1, huesped.getNombre());
				sentencia.setString(2, huesped.getApellido());
				sentencia.setString(3, huesped.getFechanacimiento());
				sentencia.setString(4, huesped.getNacionalidad());
				sentencia.setString(5, huesped.getTelefono());
				sentencia.setInt(6, huesped.getIdreserva());
				
				sentencia.execute();
				
				ResultSet key = sentencia.getGeneratedKeys();
				
				try (key) {
					while (key.next()) {
						System.out.println(key.getInt(1));
						return true;
					}
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
				
		return false;
	}

	
	@Override
	public void modificar(Huesped huesped) {
		
	}

	@Override
	public void eliminar(int idHuesped) {

	}


	
	
//	public static void main(String[] args) {
//		PoolConnection pool = new PoolConnection();
//		Connection con = pool.obtenerConexion();
//		
//		HuespedDAO huespedDAO = new HuespedDAO(con);
//		List<Huesped> lista = huespedDAO.listar();
//		lista.forEach(item -> {
//			System.out.println(item);
//		});
//	}

}
