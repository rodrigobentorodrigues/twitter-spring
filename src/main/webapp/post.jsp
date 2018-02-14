<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post</title>
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
                <div class="col-md-4">
                    <img style="margin:20px 60px;"
                        width="150px" height="150px" src="../${usuarioAux.caminhoImagem}"/>
                    <h4 style="text-align: center;">@${usuarioAux.nome}</h4>
                </div>
                <div class="col-md-8" style="padding-top: 50px;">
                    <h1 style="text-align: center;">${post.mensagem}</h1>
                </div>
            </div>

        </div>
    </body>
</html>
