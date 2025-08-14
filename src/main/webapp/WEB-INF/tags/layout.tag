<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="title" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>${title}</title>
  <link rel="stylesheet" href="<c:url value='/resources/styles/base.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/styles/layout.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/styles/nav.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/styles/footer.css'/>">
  <link rel="stylesheet" href="<c:url value='/resources/styles/home.css'/>">
</head>
<body class="site">
  <header class="site_header" role="banner">
  		<div class="container">
    		<%@ include file="/WEB-INF/views/fragments/header.jspf"%>
    		
    		<nav class="site_nav" aria-label="Principal">
    			<%@ include file="/WEB-INF/views/fragments/nav.jspf"%>
  			</nav>
    	</div>
  </header>
  
  <main class="site_main" id="content" role="main" tabindex="-1">
  	
  	<div class="container">
    	<jsp:doBody/>
    	<c:url value="/resources/images/main/fondo/" var="fondoDir"/>
    
    	<a class="brand" href="${pageContext.request.contextPath}/" aria-label="Inicio">
    		<img class="mainBackgroung"	src="${fondoDir}fondo.png" alt="fondo">
  		</a>
    </div>
  </main>

  <footer class="site_footer" role="contentinfo">
  	<div class="container">
    	<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>
    </div>
  </footer>
  
  <spring:url value="/resources/js/menu.js" var="menuJs"/>
  <script src="${menuJs}" defer></script>
</body>
</html>

