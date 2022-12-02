package modelo;

import java.util.Objects;

public class Contacto {

	private int idContacto;
	private String nombre;
	private int edad;
	private String localidad;
	private String telefono;
	private int codProvincia;
	private String tipoTel;
	
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}


	public Contacto(int idContacto, String nombre, int edad, String localidad, String telefono, int codProvincia,
			String tipoTel) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.edad = edad;
		this.localidad = localidad;
		this.telefono = telefono;
		this.codProvincia = codProvincia;
		this.tipoTel = tipoTel;
	}


	public int getIdContacto() {
		return idContacto;
	}


	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getCodProvincia() {
		return codProvincia;
	}


	public void setCodProvincia(int codProvincia) {
		this.codProvincia = codProvincia;
	}


	public String getTipoTel() {
		return tipoTel;
	}


	public void setTipoTel(String tipoTel) {
		this.tipoTel = tipoTel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idContacto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return idContacto == other.idContacto;
	}

	


	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre + ", edad=" + edad + ", localidad="
				+ localidad + ", telefono=" + telefono + ", codProvincia=" + codProvincia + ", tipoTel=" + tipoTel
				+ "]";
	}

	

}
