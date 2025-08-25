<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <t:layout title="lawyers">
    	<br/>
    	<h1>Listado de abogados</h1>
    	
    	<div class="actions">
 		<a href="${pageContext.request.contextPath}/lawyers/new" class="btn"><input type="button" value="Añadir abogado"/></a>
 		</div>
 		<br/>
    	<div class="tabla tabla--fit" >
    		<div class="tabla__fit">
    			<table class="tabla__table">
    					<tr>
    						<th>Id</th>
    						<th>Nombre</th>
    						<th>Apellidos</th>
    						<th>Núm. colegiado</th>
    						<th>Consultar</th>
    						<!--<th>Teléfono</th>
    						<th>Mail</th>
    						<th>Fecha de alta</th>
    						<th>Honorarios</th>-->
    					</tr>
    				<c:forEach var="lawyerTemp" items="${lawyers}">
    					<tr>
    						<td>${lawyerTemp.id}</td>
    						<td>${lawyerTemp.nombre}</td>
    						<td>${lawyerTemp.apellidos}</td>
    						<td>${lawyerTemp.numColegiado}</td>
    						<c:url var="linkConsultar" value="/lawyers/details">
							<c:param name="lawyerId" value="${lawyerTemp.id}"/>
							</c:url>
    						
    						<td>
    						<div class="actions">
 								<a href="${linkConsultar}" 
 								class="btn"><input type="button" value="ver detalles"/></a>
 							</div>	
 							</td>
 							
    						<!--<td>${lawyerTemp.dni}</td>
    						<td>${lawyerTemp.telefono}</td>
    						<td>${lawyerTemp.mail}</td>
    						<td>${lawyerTemp.fechaAlta}</td>
    						<td>${lawyerTemp.honorarios}</td>-->
    					</tr>
    				</c:forEach>
    			</table>
 			</div>
 		</div>
 		
    </t:layout>