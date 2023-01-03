package com.hotelalura.controller;



import com.hotelalura.ConnectionFactory.PoolConnection;
import com.hotelalura.dao.LoginDAO;
import com.hotelalura.models.Funcionario;

public class LoginController {
	
	private PoolConnection clasePOOL;
	
	private LoginDAO loginDAO;

	
	public LoginController() {
		PoolConnection pool = new PoolConnection();
		this.loginDAO = new LoginDAO(pool.obtenerConexion());
		this.clasePOOL = pool;
	}
	
	public void closeAndDestroy() {
		this.clasePOOL.destroy();
	}

	
	public boolean login(Funcionario funcionario) {
		return this.loginDAO.login(funcionario);
	}
	

}
