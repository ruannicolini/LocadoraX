<%-- 
    Document   : CadastraDependente
    Created on : 07/04/2015, 21:35:40
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
        <TITLE>Cadastro de Dependente</TITLE>

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
                    <h2>Incluir Dependente</h2>
                    <div class="row">
                        <form action= "ControllerCliente" method="POST">
                            <input type="hidden" name="operacao" value="cadastrarDependente">


                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="col-sm-5 testeVermelho" style="padding :0">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Socio" nome ="socio">
                                             <span class="input-group-addon" id="basic-addon2">Pesq</span>
                                        </div>  
                                    </div>
                                </div>
                            </div>
                            <div class="nav col-sm-12 ">
                                <div class="nav row">
                                    <label for="User" class="col-sm-12">Dependente</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder="Nome" name="nome">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="col-sm-5" style="padding :0">
                                        <label for="User" class="col-sm-12">Sexo</label>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="m">&nbsp Masculino
                                        </div>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="f">&nbsp Feminino
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Data de Nascimento</label>
                                        <input type="date" class="form-control" placeholder="Data de Nascimento" name="dataNascimento">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12" align="rigth">
                                <div class="col-sm-6 formBTN2 " align="right">  
                                    <button class="btn"> Cancelar </button>
                                    <button type ="submit" class="btn" > Salvar </button>
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
