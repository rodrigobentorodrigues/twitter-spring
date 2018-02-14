<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina do Usuario</title>
        <!-- Última versão CSS compilada e minificada -->
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous">

        <!-- Tema opcional -->
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" 
              crossorigin="anonymous">

        <!-- Última versão JavaScript compilada e minificada -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
        crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="border: 1px solid black">
            <div class="col-md-12">
                <div class="col-md-6" style="border: 1px solid black; margin: 10px 0px">
                    <h1 style="text-align: center;">Posts:</h1>
                    <br>
                    <form action="post/cadastrar" method="POST">
                        <input type="hidden" name="usuario" value="${usuario.id}"/>
                        <input class="form-control" type="text" style="text-align: center;"
                               name="mensagem" placeholder="O que você esta pensando?"/>
                        <br>
                        <input type="submit" class="btn btn-primary"
                               style="width: 120px; height: 34px; margin: auto 300px;" value="Adicionar Post"/>
                    </form>
                    <hr>
                    <c:if test="${empty posts}">
                        <h2 style="text-align: center;">Nenhum post cadastrado</h2>
                    </c:if>
                    <c:forEach var="post" items="${posts}">
                        <h2>${post.mensagem}</h2>
                        <a href="post/${post.id}"><p style="text-align: right;">Direct Link</p></a>
                        <hr>
                    </c:forEach>
                </div>
                <div class="col-md-6" >
                    <div style="border: 1px solid black; margin-top: 10px;">
                        <img width="150px" height="150px" style="margin: 5px 150px;"
                             src="${usuario.caminhoImagem}"/>
                        <h3 style="text-align: center;">@${usuario.nome}</h3>
                        <hr>
                        <a href="usuario/logout"><p style="text-align: center;">Logout</p></a>
                    </div>
                </div>                
            </div>
        </div>
    </body>
</html>
