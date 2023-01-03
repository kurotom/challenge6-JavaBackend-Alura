package com.hotelalura.dao;

import java.util.List;

import com.hotelalura.models.Huesped;



public interface InterfaceHuespedDAO {
	
	public List<Huesped> listar();
	
	public boolean guardar(Huesped huesped);
	
	public void modificar(Huesped huesped);
	
	public void eliminar(int idHuesped);
	
}
