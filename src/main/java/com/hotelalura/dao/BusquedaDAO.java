package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hotelalura.models.Huesped;
import com.hotelalura.models.Reserva;




public class BusquedaDAO implements InterfaceBusqueda {
	
	private Map<String, List<?>> mapa = new HashMap<>();
	
	private Connection connection;
	
	public BusquedaDAO(Connection conexion) {
		this.connection = conexion;
	}
	
	public void close() {
		try {
			if (this.connection.isClosed() != true) {
				this.connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		
		List<Reserva> lista = new ArrayList<>();
		
		try {
			
			String query = "SELECT * FROM reservas";
			
			PreparedStatement sentencia = this.connection.prepareStatement(query);
			
			try (sentencia) {
				sentencia.execute();
				
				ResultSet resultado = sentencia.getResultSet();
				
				try (resultado) {
					
					while (resultado.next()) {
						lista.add( new Reserva(
									resultado.getInt("ID"),
									resultado.getString("FECHAENTRADA"),
									resultado.getString("FECHASALIDA"),
									resultado.getDouble("VALOR"),
									resultado.getString("FORMAPAGO")
								   )
							);
					}
					
					return lista;
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Huesped> listarHuespedes() {
		// TODO Auto-generated method stub
		
		List<Huesped> lista = new ArrayList<>();
		
		try {
			
			String query = "SELECT * FROM huespedes";
			
			PreparedStatement sentencia = this.connection.prepareStatement(query);
			
			try (sentencia) {
				sentencia.execute();
				
				ResultSet resultado = sentencia.getResultSet();
				
				try (resultado) {
					
					while (resultado.next()) {
						lista.add( new Huesped(
									resultado.getInt("ID"),
									resultado.getString("NOMBRE"),
									resultado.getString("APELLIDO"),
									resultado.getString("FECHANACIMIENTO"),
									resultado.getString("NACIONALIDAD"),
									resultado.getString("TELEFONO"),
									resultado.getInt("IDRESERVA")
								   )
							);
					}
					
					return lista;
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	
	@Override
	public Integer guardar(Object objetoGuardar) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	@Override
	public boolean modificar(Reserva objetoReserva) {
		// TODO Auto-generated method stub
		String updateString = "UPDATE reservas SET fechaentrada = ?, fechasalida = ?, valor = ?, formapago = ? WHERE id = ?";
		
		System.out.println("____> RESERVA MODIFICADO");
		
		try {
			
			final PreparedStatement sentenciaUpdate = this.connection.prepareStatement(
					updateString, PreparedStatement.RETURN_GENERATED_KEYS
				);
			
			try (sentenciaUpdate) {
				
				sentenciaUpdate.setString(1, objetoReserva.getFechaentrada());
				sentenciaUpdate.setString(2, objetoReserva.getFechasalida());
				sentenciaUpdate.setDouble(3, objetoReserva.getValor());
				sentenciaUpdate.setString(4, objetoReserva.getFormapago());
				sentenciaUpdate.setInt(5, objetoReserva.getId());

				Integer modificadas = sentenciaUpdate.executeUpdate();
				
				if (modificadas > 0) {
					return true;
				} else {
					return false;
				}
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean modificar(Huesped objetoHuesped) {
		// TODO Auto-generated method stub
		
		try {
			
			String query = "UPDATE huespedes SET nombre = ?, apellido = ?, fechanacimiento = ?, nacionalidad = ?, telefono = ?, idreserva = ? WHERE id = ?;";
			
			PreparedStatement sentencia = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			try (sentencia) {
				
				sentencia.setString(1, objetoHuesped.getNombre());
				sentencia.setString(2, objetoHuesped.getApellido());
				sentencia.setString(3, objetoHuesped.getFechanacimiento());
				sentencia.setString(4, objetoHuesped.getNacionalidad());
				sentencia.setString(5, objetoHuesped.getTelefono());
				sentencia.setInt(6, objetoHuesped.getIdreserva());
				sentencia.setInt(7, objetoHuesped.getId());
				
				Integer modificadas = sentencia.executeUpdate();
			
				if (modificadas > 0) {
					return true;
				} else {
					return false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	

	public Map<String, List<?>> buscarAllMatch(String string) {
		// TODO Auto-generated method stub
		
		List<Huesped> listaHuespedes = new ArrayList<>();
		List<Reserva> listaReserva = new ArrayList<>();
		

		try {
			
			String querySearch = "SELECT * FROM huespedes h, reservas r WHERE r.id = h.idreserva AND CONCAT(h.apellido, h.idreserva, r.id) LIKE ?;";
			
			PreparedStatement sentencia = this.connection.prepareStatement(querySearch);
			
			try (sentencia) {
				sentencia.setString(1, "%" + string + "%");
						
				ResultSet resultado = sentencia.executeQuery();				
				try (resultado) {
					while (resultado.next()) {
						
						listaHuespedes.add(new Huesped(
									resultado.getInt("H.ID"),
									resultado.getString("H.NOMBRE"),
									resultado.getString("H.APELLIDO"),
									resultado.getString("H.FECHANACIMIENTO"),
									resultado.getString("H.NACIONALIDAD"),
									resultado.getString("H.TELEFONO"),
									resultado.getInt("H.IDRESERVA")
								));
						
						listaReserva.add(new Reserva(
									resultado.getInt("R.ID"),
									resultado.getString("R.FECHAENTRADA"),
									resultado.getString("R.FECHASALIDA"),
									resultado.getDouble("R.VALOR"),
									resultado.getString("R.FORMAPAGO")
								));
					}
					
					mapa.put("Huespedes", listaHuespedes);
					mapa.put("Reservas", listaReserva);

				}
							
				return mapa;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean eliminar(Integer idObjeto) {
		// TODO Auto-generated method stub
		try {
			
			String deleteHuesped = "DELETE FROM huespedes WHERE id IN (SELECT id FROM (SELECT H.id FROM huespedes H, reservas R WHERE H.idreserva = R.id AND R.id = ?) AS temporal);";	
			
			PreparedStatement eliminarHuesped = this.connection.prepareStatement(deleteHuesped, PreparedStatement.RETURN_GENERATED_KEYS);
			
			try (eliminarHuesped) {
				
				eliminarHuesped.setInt(1, idObjeto);
				
				eliminarHuesped.executeUpdate();
				
				System.out.println(eliminarHuesped);
				
			}
			
			String deleteReserva = "DELETE FROM reservas WHERE id = ?;";
			
			PreparedStatement eliminarReserva = this.connection.prepareStatement(deleteReserva, PreparedStatement.RETURN_GENERATED_KEYS);
			
			try (eliminarReserva) {
				
				eliminarReserva.setInt(1, idObjeto);
				
				eliminarReserva.executeUpdate();
				
				System.out.println(eliminarReserva);
			}
			
			return true;			
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
