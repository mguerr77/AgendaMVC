<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../plantillas/cabecera.jsp"></jsp:include>

<h1>Nuevo contacto</h1>

<form action="contactos" method="post">
	<input type="hidden" name="opcion" value="alta" />
	<div>
		<label for="nombre">Nombre: </label>
		<input type="text" name="nombre" id="nombre" />
	</div>
	<div>
		<label for="edad">Edad: </label>
		<input type="text" name="edad" id="edad" />
	</div>
	<div>
		<label for="localidad">Localidad: </label>
		<input type="text" name="localidad" id="localidad" />
	</div>
	<div>
		<label for="telefono">Télefono: </label>
		<input type="tel" pattern="[0-9]{9}" maxlength=9 name="telefono" id="telefono" />
	</div>
	<div>
		<label for="tipotel">Tipo de teléfono: </label>
		<select name="tipotel" id="tipotel">	
			<option value="Fijo">Fijo</option>
			<option value="Móvil">Móvil</option>
		</select>
	</div>
	<div>
		<label for="codProvincia">Código Provincia: </label>
		<input type="number" name="codProvincia" id="codProvincia" />
	</div>
	<input type="submit" value="enviar">
</form>




<jsp:include page="../plantillas/pie.jsp"></jsp:include>