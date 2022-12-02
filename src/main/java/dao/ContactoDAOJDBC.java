package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Contacto;
import utiles.ConexionBD;

public class ContactoDAOJDBC implements ContactoDao {

	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet rs = null;
	
	
	
	public ContactoDAOJDBC() {
		// TODO Auto-generated constructor stub
		conexion = new ConexionBD();
	}

	@Override
	public List<Contacto> getContactos() {
		// TODO Auto-generated method stub
		Connection con = conexion.getConexion();
		
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		try {
			consulta=con.createStatement();
			rs=consulta.executeQuery("select * from agenda");
			while(rs.next())
			{
				Contacto contacto = new Contacto();
				contacto.setNombre(rs.getString("nombre"));
				contacto.setIdContacto(rs.getInt("idcontacto"));
				contacto.setEdad(rs.getInt("edad"));
				contacto.setLocalidad(rs.getString("localidad"));
				contacto.setTelefono(rs.getString("teléfono"));
				contacto.setCodProvincia(rs.getInt("CodProv"));
				contacto.setTipoTel(rs.getString("tipo_tel"));
				
				
				System.out.println("Contacto insertado: ");
				System.out.println(contacto);
				listaContactos.add(contacto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaContactos;
	}

	@Override
	public void insertarContactos(Contacto nuevoContacto) {
		// TODO Auto-generated method stub
		Connection con = conexion.getConexion();
		int resultado;
		try {
			consultaPreparada = con.prepareStatement("insert into agenda(nombre,edad,localidad,teléfono,codprov,tipo_tel) values(?,?,?,?,?,?)");
			consultaPreparada.setString(1,nuevoContacto.getNombre());
			consultaPreparada.setInt(2,nuevoContacto.getEdad());
			consultaPreparada.setString(3,nuevoContacto.getLocalidad());
			consultaPreparada.setString(4,nuevoContacto.getTelefono());
			consultaPreparada.setInt(5,nuevoContacto.getCodProvincia());
			consultaPreparada.setString(6,nuevoContacto.getTipoTel());
			resultado = consultaPreparada.executeUpdate();
			System.out.println(resultado + "Contacto insertado: ");
			System.out.println(nuevoContacto);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
