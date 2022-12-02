<%@page import="modelo.Contacto"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../plantillas/cabecera.jsp"></jsp:include>


<a href="contactos?opcion=alta"  class="boton">Insertar Contacto</a>
<h1>Listado de Contactos</h1>
<%
List<Contacto> lista = (List<Contacto>) request.getAttribute("listaContacto"); 
if (lista==null) 
	{
%>
		<h2>No hay datos de Centros registrados</h2>
<%  } 
else 
{%>
		<table class="estilo-tabla">
			<tr>
				<th>Id Contacto</th>
				<th style="min-width: 150px">Nombre</th>
				<th>Edad</th>
				<th>Localidad</th>
				<th>Código Provincia</th>
				<th>Teléfono</th>
				<th>Tipo de Teléfono</th>
				<th>Editar</th>
				<th>Eliminar</th>
			</tr>
		
<% 
		for (Contacto contacto:lista) {
			%>
			<tr>
				<td><%=contacto.getIdContacto() %></td>
				<td><%=contacto.getNombre() %></td>
				<td><%=contacto.getEdad() %></td>
				<td><%=contacto.getLocalidad() %></td>
				<td><%=contacto.getCodProvincia() %></td>
				<td><%=contacto.getTelefono() %></td>
				<td><%=contacto.getTipoTel() %></td>
				<td><a href="contactos?opcion=editar&IdContacto=<%=contacto.getIdContacto()%>">Editar</a></td>
				<td><a href="contactos?opcion=eliminar&IdContacto=<%=contacto.getIdContacto()%>">Borrar</a></td>
			</tr>
			<%
		}
%>			</table> 
<%

}
		%>
		


<jsp:include page="../plantillas/pie.jsp"></jsp:include>