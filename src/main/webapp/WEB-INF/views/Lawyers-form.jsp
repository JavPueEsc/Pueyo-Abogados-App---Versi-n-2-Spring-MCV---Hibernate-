<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="lawyer-Form">

	<h2>
		<c:choose>
			<c:when test="${modo eq 'insert'}">Inserte los datos del nuevo abogado.</c:when>
			<c:otherwise>Actualice los datos del abogado</c:otherwise>
		</c:choose>
	</h2>
	
	<c:choose>
  		<c:when test="${modo eq 'insert'}">
    		<c:url var="formAction" value="/lawyers"/>
    		<c:set var="textButton" value="Guardar"/>
  		</c:when>
  		<c:otherwise>
    		<c:url var="formAction" value="/lawyers/updateLawyer"/>
    		<c:set var="textButton" value="Actualizar"/>
  		</c:otherwise>
	</c:choose>
	
	<form:form action="${formAction}" method="POST" modelAttribute="lawyer">
		<c:if test="${modo != 'insert'}">
			<form:hidden path="id"/>
		</c:if>
		
		<div class="page-center">
		<div class="form-grid">
			<div class="field">
				<form:label path="nombre">Nombre: </form:label>
				<form:input path="nombre" placeholder="Escriba el nombre"></form:input>
				<form:errors path="nombre" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="apellidos">Apellidos: </form:label>
				<form:input path="apellidos" placeholder="Escriba el apellido"></form:input>
				<form:errors path="apellidos" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="dni">DNI: </form:label>
				<form:input path="dni" placeholder="Escriba el DNI"></form:input>
				<form:errors path="dni" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="telefono">Telefono: </form:label>
				<form:input path="telefono" placeholder="Escriba el telefono"></form:input>
				<form:errors path="telefono" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="mail">Mail: </form:label>
				<form:input path="mail" placeholder="Escriba el mail"></form:input>
				<form:errors path="mail" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="fechaAlta">Fecha de alta: </form:label>
				<form:input path="fechaAlta" type="date"></form:input>
				<form:errors path="fechaAlta" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="numColegiado">Número de colegiado: </form:label>
				<form:input path="numColegiado" placeholder="Escriba el núm. colegiado"></form:input>
				<form:errors path="numColegiado" cssClass="error"/>
			</div>
			
			<div class="field">
				<form:label path="honorarios">Honorarios: </form:label>
				<form:input path="honorarios" placeholder="Introduzca los honorarios"></form:input>
				<form:errors path="honorarios" cssClass="error"/>
			</div>
			<div class="actions">
				<input type="submit" value="${textButton}" onclick="if(!(confirm('¿Seguro?'))) return false"/>
			
				<input type="button" value="Cancelar" onclick="window.location.href='<c:url value='/lawyers'/>'"/>
			</div>
		</div>
		</div>
		
	</form:form>

</t:layout>