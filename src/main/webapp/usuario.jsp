<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
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
        <br>
        <div class="container" style="border: 1px solid black">            
            <div class="col-md-12">
                <c:choose>
                    <c:when test="${usuarioAux eq null}">
                        <h2 style="text-align: center;">Nenhum usuário cadastrado com esse nome</h2>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-6" style="border: 1px solid black; margin: 10px 0px">
                            <h1 style="text-align: center;">Posts:</h1>
                            <hr>
                            <c:if test="${empty postsAux}">
                                <h2 style="text-align: center;">Nenhum post cadastrado</h2>
                            </c:if>
                            <c:forEach var="post" items="${postsAux}">
                                <h2>${post.mensagem}</h2>
                                <a href="post/${post.id}"><p style="text-align: right;">Direct Link</p></a>
                                <hr>
                            </c:forEach>
                        </div>
                        <div class="col-md-6" >
                            <div style="border: 1px solid black; margin-top: 10px;">
                                <img width="150px" height="150px" style="margin: 5px 150px;"
                                     src="${usuarioAux.caminhoImagem}"/>
                                <h3 style="text-align: center;">@${usuarioAux.nome}</h3>
                            </div>
                        </div> 
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </body>
</html>
