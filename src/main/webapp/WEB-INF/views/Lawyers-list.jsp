<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <t:layout title="lawyers">
    	<br/>
    	<h1>Listado de abogados</h1>
    	<br/>
    	<div class="tabla">
    	<table>
    		<tr>
    			<th>Id</th>
    			<th>Nombre</th>
    			<th>Apellidos</th>
    			<th>DNI</th>
    			<th>Teléfono</th>
    			<th>Mail</th>
    			<th>Fecha de alta</th>
    			<th>Núm. colegiado</th>
    			<th>Honorarios</th>
    		</tr>
    		<c:forEach var="lawyerTemp" items="${lawyers}">
    		<tr>
    			<td>${lawyerTemp.id}</td>
    			<td>${lawyerTemp.nombre}</td>
    			<td>${lawyerTemp.apellidos}</td>
    			<td>${lawyerTemp.dni}</td>
    			<td>${lawyerTemp.telefono}</td>
    			<td>${lawyerTemp.mail}</td>
    			<td>${lawyerTemp.fechaAlta}</td>
    			<td>${lawyerTemp.numColegiado}</td>
    			<td>${lawyerTemp.honorarios}</td>
    		</tr>
    		</c:forEach>
    	</table>
 		</div>
 		<br/>
 		<a href="${pageContext.request.contextPath}/lawyers/new" class="btn">Agregar abogado</a>

    </t:layout>