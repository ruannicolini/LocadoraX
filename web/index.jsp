<%-- 
    Document   : index
    Created on : 18/06/2015, 08:47:35
    Author     : Ruan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset = "UTF-8">  
        <meta name="keywords" content="Locadora X, Filmes">
        <meta name="description" content="Pagina  Locadora X">
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="locadorax@hotmail.com">
        <meta name="Generator" content="Sublime 3.0">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <!-- Arquivo Css Criado -->
        <link href="css/style.css" rel="stylesheet" media="screen">


        <TITLE>Locadora X</TITLE>
    </head>
    <body bgcolor = "#D3D3D3">
        <div>

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header col-sm-12">
                        <div class="row" style="padding-left: 20px; padding-right: 20px;">
                            <div class="navbar-brand col-sm-4" href="#" style=" padding-top: 10px">
                                <div class="row">
                                    <div class="nav col-sm-12">
                                        <img alt="" src="img/logo.png">
                                        Locadora   
                                    </div>   
                                </div>
                            </div>
                            <div class="nav col-sm-8" style="float: right; padding-top: 10px;"> 
                                <div class="row" style="float: right">
                                    <form action= "ControllerFuncionario" method="POST">
                                        <input type="hidden" name="operacao" value="login">
                                        <div class="form-group col-sm-4">
                                            <label class="sr-only" for="exampleInputEmail3">Email</label>
                                            <input type="text" class="form-control" placeholder="username" name="username">

                                        </div>
                                        <div class="form-group col-sm-4" style="margin :0">
                                            <label class="sr-only" for="exampleInputPassword3">Password</label>
                                            <input type="password" class="form-control" placeholder="Senha" name="senha">

                                            <label>
                                                <input type="checkbox"> Salvar Senha
                                            </label>
                                        </div>
                                        <div class="form-group col-sm-1">
                                            <button type="submit" class="btn btn-default">Sign in</button>
                                        </div>
                                    </form>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <div class="col-sm-12" style="padding :0">
            <%
                // Errors
                String error = request.getParameter("erro");
                if (error != null) {
                    if (error.equals("0")) {
                        out.println("<div class='alert alert-success' style = 'margin-right: 35px'>Ação realizada com sucesso!</div>");
                    } else {
                        out.println("<div class='alert alert-danger' style = 'margin-right: 35px'>Erro!</div>");
                    }
                }

            %>
        </div>
        <!-- BANNER -->
        <div>
            <img src="img/300.jpg" width="100%">
        </div>
        <hr>    


        <!-- Rodapé-->
        <div>
            <br>
            <br>
            <br>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jsProject.js"></script>
    </body>
</html>
