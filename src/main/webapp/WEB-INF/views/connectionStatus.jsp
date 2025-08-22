<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="connectionStatus">
	
	<div class="show_mainContent">
	<h1>Estado de conexión a la base de datos</h1>
	<c:choose>
		<c:when test="${ok}">
			<p>✅ Conexión establecida correctamente</p>
			<div>
				<dl>
					<dt>Motor:</dt><dd>${dbProduct}</dd>
					<dt>JDBC URL:</dt><dd>${jdbcUrl}</dd>
					<dt>Tiempo:</dt><dd>${elapsedMs} ms</dd>
					<dt>Momento:</dt><dd>${timestamp}</dd>
				</dl>
			</div>
		</c:when>
		<c:otherwise>
			<p>❌ Error al conectar con la base de datos</p>
			<pre><c:out value="${error}"/></pre>
		</c:otherwise>
	</c:choose>
	</div>
</t:layout>