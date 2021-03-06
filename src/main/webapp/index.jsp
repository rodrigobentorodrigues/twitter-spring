<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
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
        <div class="container">
            <div class="col-md-12">
                <h1>Twitter Spring</h1>
                <hr>
                <div class="col-md-6">
                    <h3>Cadastrar</h3>
                    <form method="POST" action="usuario/adicionar" enctype="multipart/form-data">
                        Nome:<input class="form-control" type="text" name="nome" required/><br>
                        Senha:<input class="form-control" type="password" name="senha" required/><br>
                        Foto:<input class="form-control" type="file" name="foto" accept="image/*" required><br>
                        <input class="btn btn-primary" type="submit" value="Cadastrar"/>
                    </form>
                </div>
                <div class="col-md-6">
                    <h3>Realizar Login</h3>
                    <form method="POST" action="usuario/autenticar">
                        Nome: <input class="form-control" type="text" name="nome" required/><br>
                        Senha: <input class="form-control" type="password" name="senha" required/><br>
                        <input class="btn btn-primary" type="submit" value="Autenticar"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
