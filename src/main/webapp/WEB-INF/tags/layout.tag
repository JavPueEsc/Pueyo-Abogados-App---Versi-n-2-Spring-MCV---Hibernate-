<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>
<%@ attribute name="title" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>${title}</title>
  <link rel="stylesheet" href="<c:url value='/resources/styles/layout.css'/>">
</head>
<body class="site">
  <header class="site_header" role="banner">
    <%@ include file="/WEB-INF/views/fragments/header.jspf"%>
  </header>

  <nav class="site_nav" aria-label="Principal">
    <%@ include file="/WEB-INF/views/fragments/nav.jspf"%>
  </nav>

  <main class="site_main" id="content" role="main" tabindex="-1">
    <jsp:doBody/>
  </main>

  <footer class="site_footer" role="contentinfo">
    <%@ include file="/WEB-INF/views/fragments/footer.jspf"%>
  </footer>
</body>
</html>

