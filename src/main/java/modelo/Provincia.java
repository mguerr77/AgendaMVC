package modelo;

import java.util.Objects;

public class Provincia {

	private int codProvincia;
	private String nombreProvincia;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public Provincia(int codProvincia, String nombreProvincia) {
		super();
		this.codProvincia = codProvincia;
		this.nombreProvincia = nombreProvincia;
	}

	public int getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(int codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codProvincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return codProvincia == other.codProvincia;
	}

	@Override
	public String toString() {
		return "Provincia [codProvincia=" + codProvincia + ", nombreProvincia=" + nombreProvincia + "]";
	}

	
	
}
