<%-- 
    Document   : CadastraDistribuidor
    Created on : 04/04/2015, 17:54:30
    Author     : Ruan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="XYZ@hotmail.com">
        <meta name="Generator" content="Sublime 3.0">
        <TITLE>Cadastro de Distribuidor</TITLE>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <!-- Arquivo Css Criado -->
        <link href="css/style.css" rel="stylesheet" media="screen">




    </head>

    <body bgcolor="white">
        <!-- Menu Superior -->
        <%@ include file="navBar.jsp"%>

        <div class="container-fluid" style="overflow: hidden">
            <div class="row">
                <div class="col-md-2">
                    <%@ include file="menu.jsp"%>
                </div>

                <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                    <h2>Cadastro de Distribuidor</h2>
                    <div class="row">
                        <form action = "ControllerDistribuidor" method="POST">
                            <input type="hidden" name="operacao" value="cadastrar">

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label class="col-sm-12">Razão Social</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder="Razão Social" nome ="razao">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label class="col-sm-12">CNPJ</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder="CNPJ" nome ="cnpj">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12" align="rigth">
                                <div class="col-sm-6 formBTN2 " align="right"> 
                                    <button class="btn"> Cancelar </button>
                                    <button type ="submit" class="btn"> Salvar </button>
                                </div> 
                            </div>
                        </form>
                    </div>
                    <div class="divider divider-single"></div>
                </div>

            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="js/jsProject.js"></script>-->


    </body>
</html>