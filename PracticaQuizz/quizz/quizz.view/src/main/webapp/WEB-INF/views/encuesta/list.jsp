<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset id="parent">
	<legend>Listado de Encuestas</legend>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" />
		<input type="button" id="btnEditar" value="Editar" />
		<input type="button" id="btnEliminar" value="Eliminar"  />
		<input type="button" id="btnEstadistica" value="Ver estad&iacute;stica" />
	</div>
	<table id="lista" ></table>
	<div id=paginadorLista></div>
</fieldset>

<script type="text/javascript">
encuesta.formatList();
function showInformationIntoView(information){
	$("#lista").setGridParam({
		data : information
	}).trigger("reloadGrid");
};
</script>