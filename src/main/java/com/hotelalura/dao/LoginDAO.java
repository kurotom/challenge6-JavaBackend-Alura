package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hotelalura.models.Funcionario;


public class LoginDAO implements InterfaceLogin {
	
	
	private Connection con;
	
	
	public LoginDAO(Connection conexion) {
		this.con = conexion;
	}
	

	@Override
	public boolean login(Funcionario funcionario) {
		
		try {
			
			String query = "SELECT password FROM funcionarios WHERE nombre = ?;";
			
			PreparedStatement sentencia = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			try (sentencia) {
				
				sentencia.setString(1, funcionario.getNombre());
				
				sentencia.execute();
				
				ResultSet resultado = sentencia.getResultSet();

				
				try (resultado) {
					
					String pass = "";
					
					while (resultado.next()) {
						pass = (String) resultado.getString(1);					
					}
					
					if (funcionario.getPassword().equals(pass)) {
						return true;
					} else {
						return false;
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registro() {
		
	}
	
	

}
