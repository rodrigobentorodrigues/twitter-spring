<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <h1>${usuario.nome}</h1>
        <h1>${usuario.senha}</h1>
        <img src="${usuario.caminhoImagem}"/>
        <c:forEach var="post" items="${posts}">
            ${post}
        </c:forEach>
    </body>
</html>
