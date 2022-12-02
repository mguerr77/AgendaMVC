package dao;

import java.util.List;

import modelo.Provincia;

public interface ProvinciaDao {
	List<Provincia> getProvincias();
	public void insertarProvincias(Provincia nuevaProvincia);
	//hay mas métodos necesarios
}
