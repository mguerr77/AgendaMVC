package dao;

import java.util.List;

import modelo.Contacto;


public interface ContactoDao {
	
	//hay mas métodos necesarios
	List<Contacto> getContactos();
	public void insertarContactos(Contacto nuevoContacto);
}
