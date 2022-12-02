package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Provincia;
import utiles.ConexionBD;

public class ProvinciaDAOJDBC implements ContactoDao {

	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet rs = null;
	
	
	
	public ProvinciaDAOJDBC() {
		// TODO Auto-generated constructor stub
		conexion = new ConexionBD();
	}

	@Override
	public List<Provincia> getProvincias() {
		// TODO Auto-generated method stub
		Connection con = conexion.getConexion();
		
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		try {
			consulta=con.createStatement();
			rs=consulta.executeQuery("select * from provincias");
			while(rs.next())
			{
				Provincia provincia = new Provincia();
				provincia.setCodProvincia(rs.getInt("CodProv"));  
				provincia.setNombreProvincia(rs.getString("NomProv"));
				System.out.println("Provincia insertado: ");
				System.out.println(provincia);
				listaProvincias.add(provincia);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaProvincias;
	}

	@Override
	public void insertarProvincias(Provincia nuevaProvincia) {
		// TODO Auto-generated method stub
		Connection con = conexion.getConexion();
		int resultado;
		try {
			consultaPreparada = con.prepareStatement("insert into provincias(CodProv,NomProv) values(?,?)");
			consultaPreparada.setInt(1,nuevaProvincia.getCodProvincia());
			consultaPreparada.setString(2,nuevaProvincia.getNombreProvincia());
			resultado = consultaPreparada.executeUpdate();
			System.out.println(resultado + "Provincia insertada: ");
			System.out.println(nuevaProvincia);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
