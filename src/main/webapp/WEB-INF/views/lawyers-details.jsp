<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout title="lawyers-detail">

<h1>Detalles del abogado</h1>

<form:form method="POST" modelAttribute="lawyer">
<div class="tabla tabla--fit" >
    		<div class="tabla__fit">
    			<table class="tabla__table">
			<tr>
				<th>Id</th>
				<td>${lawyer.id}</td>
			</tr>
			<tr>
				<th>Nombre</th>
				<td>${lawyer.nombre}</td>
			</tr>
			<tr>
				<th>Apellidos</th>
				<td>${lawyer.apellidos}</td>
			</tr>
			<tr>
				<th>DNI</th>
				<td>${lawyer.dni}</td>
			</tr>
			<tr>
				<th>Teléfono</th>
				<td>${lawyer.telefono}</td>
			</tr>
			<tr>
				<th>Mail</th>
				<td>${lawyer.mail}</td>
			</tr>
			<tr>
				<th>Fecha de alta</th>
				<td>${lawyer.fechaAlta}</td>
			</tr>
			<tr>
				<th>Número de colegiado</th>
				<td>${lawyer.numColegiado}</td>
			</tr>
			<tr>
				<th>Honorarios</th>
				<td>${lawyer.honorarios}</td>
			</tr>
		</table>
		</div>
		</div>
		<br/>
		<div class="actions">
				<c:url var="linkUpdate" value="/lawyers/showLawyerUpdateForm">
					<c:param name="lawyerId" value="${lawyer.id}"/>
				</c:url>
				<button type="button" onclick="location.href='${linkUpdate}'">Modificar</button>
				
				<c:url var="linkDelete" value="/lawyers/deleteLawyer">
					<c:param name="lawyerId" value="${lawyer.id}"/>
				</c:url>
				<input type="submit" value="Eliminar" formaction="${linkDelete}" onclick="if(!(confirm('¿Seguro que desea eliminar este abogado?'))) return false"/>
				
				<input type="button" value="Volver" onclick="window.location.href='<c:url value='/lawyers'/>'"/>
		</div>
	</form:form>
</t:layout>