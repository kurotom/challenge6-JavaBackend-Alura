package com.hotelalura.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;




public class PoolConnection {
	
	private DataSource dataSource = null;
	
	private ComboPooledDataSource poolConnections;
	
	
	public PoolConnection() {
		
		String URLDB = "jdbc:mysql://localhost/hotelalura?useTimeZone=true&serverTimeZone=UTC";
		
		ComboPooledDataSource poolConnection = new ComboPooledDataSource();
		poolConnection.setJdbcUrl(URLDB);
		
		
		poolConnection.setUser("admin");
		poolConnection.setPassword("admin");
		
		poolConnection.setMinPoolSize(3);
		poolConnection.setAcquireIncrement(2);
		poolConnection.setMaxPoolSize(5);
		
		poolConnection.setMaxIdleTime(10);
		
		poolConnection.setMaxConnectionAge(5);
		
		this.poolConnections = poolConnection;
		
		this.dataSource = poolConnection;
	}
	

	public ComboPooledDataSource getPool() {
		return this.poolConnections;
	}

	public Connection obtenerConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void destroy() {
		try {
			DataSources.destroy(this.dataSource);
			this.poolConnections.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		PoolConnection con = new PoolConnection();
//		
//		int i = 0;
//		while (i < 20) {
//			System.out.println(con.obtenerConexion());
//			i++;
//		}
//	}
	

}
