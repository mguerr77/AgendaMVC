package controladores;

import java.io.IOException;
import java.util.List;

import dao.ContactoDAOJDBC;
import dao.ContactoDao;
import dao.ProvinciaDao;
import dao.ProvinciaDAOJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Contacto;
import modelo.Provincia;

/**
 * @author Manuel Guerrero
 *
 */
@WebServlet("/contactos")
public class ContactosServlet extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	public ContactosServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String opcion = request.getParameter("opcion");
		System.out.println("entrando por doGEt");
		System.out.println(opcion);
		if (opcion ==null || opcion.equals("listado")) {
			
			mostrarContactos(request,response);
		}
		else if(opcion.equals("alta") )
		{
			System.out.println("llamo al metodo altacontactos");
			altaContactos(request,response);
		}
		else if(opcion.equals("editar"))
		{
			editarContactos(request,response);
		}
		else if(opcion.equals("eliminar"))
		{
			eliminarContactos(request,response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String opcion = request.getParameter("opcion");
		
			if (opcion.equals("alta")) {
				System.out.println(request.getParameter("edad"));
				grabarContactos(request,response);
			
			}
	}

	private void mostrarContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ContactoDao dao = new ContactoDAOJDBC();
		List<Contacto> lista = dao.getContactos();
		request.setAttribute("listaContacto", lista);
		request.getRequestDispatcher("/contactos/listadoContactos.jsp").forward(request, response);
		
	}
	
	private void altaContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		//ProvinciaDao dao = new ProvinciaDAOJDBC();
		//List<Provincia> lista = dao.getProvincias();
		//request.setAttribute("listaProvincias", lista);
		System.out.println("voy a hacer la redirección a nuevocontacto.jsp");
		request.getRequestDispatcher("/contactos/nuevoContacto.jsp").forward(request, response);
		System.out.println("hecha la redirección a nuevocontacto.jsp");
	}	
		
	private void grabarContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException	
	{	
		int edad =Integer.parseInt(request.getParameter("edad"));
		String nombre = request.getParameter("nombre");
		String localidad = request.getParameter("localidad");
		String telefono = request.getParameter("telefono");
		int codProvincia =Integer.parseInt(request.getParameter("codProvincia"));
		String tipoTel = request.getParameter("tipoTel");
		
		Contacto nuevoContacto = new Contacto(0, nombre, edad, localidad, telefono, codProvincia,
				tipoTel);
		
		ContactoDao dao = new ContactoDAOJDBC(); //pendiente de implementar
		dao.insertarContactos(nuevoContacto);
		mostrarContactos(request, response);
	}
	
	private void editarContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	private void eliminarContactos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
}
