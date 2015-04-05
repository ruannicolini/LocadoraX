<%-- 
    Document   : CadastraItem
    Created on : 04/04/2015, 23:54:10
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
        <TITLE>Cadastro de Item</TITLE>

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
                    <h2>Cadastro de Item</h2>
                    <div class="row">
                        <form action="ControllerItem" method="POST">
                            <input type="hidden" name="operacao" value="cadastrar">
                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label for="Nome" class="col-sm-12">Titulo</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder=" " nome="nomeTitulo">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5"> 
                                        <label for="" class="col-sm-12">Nº de Série</label>
                                        <div class="col-sm-12" style="padding :0">
                                            <input type="text" class="form-control" placeholder=" " nome="numDeSerie" style="padding :0">
                                        </div>        
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <div class="row" style="margin :0">
                                            <div class="col-sm-6">
                                                <div class="row">
                                                    <label for="" class="col-sm-12" style="padding: 0 ">Tipo</label>
                                                    <div class="col-sm-11" style="padding :0">
                                                        <select name="tipo" class="form-control">
                                                            <option value="Selecione">Selecione</option>
                                                            <option value="fita">FITA</option>
                                                            <option value="dvd">DVD</option>
                                                        </select>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Data de Aquisição</label>
                                                    <div class="col-sm-12" style="padding :0">
                                                        <input type="date" class="form-control" placeholder=" " nome="dtAquisicao">
                                                    </div> 
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-12" align="rigth">
                                <div class="col-sm-6 formBTN2 " align="right"> 
                                    <button class="btn"> Cancelar </button>
                                    <button class="btn"> Salvar </button>
                                </div> 
                            </div>
                        </form>
                    </div>




                    <div class="divider divider-single"></div>
                </div>

            </div>
        </div>

        <!-- MENU
<div class="col-sm-2 testeAzul">
                                <ul id="nav nav">
                                    <li><a href="#">Cliente</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Classe</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Distribuidor</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Devolução</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Funcionário</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>
                                 
                                        <li><a href="#">Item</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>
                                    
                                    <li><a href="#">Locação</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Pagamento</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Reserva</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>

                                    <li><a href="#">Título</a>
                                      <ul>
                                        <li><a href="#">Consultar</a></li>
                                        <li><a href="#">Novo</a></li>
                                      </ul>
                                    </li>
                                </ul>
                        </div>

        -->


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="js/jsProject.js"></script>-->


    </body>
</html>
