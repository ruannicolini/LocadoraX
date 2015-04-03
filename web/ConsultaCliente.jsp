<%-- 
    Document   : ConsultaCliente
    Created on : 02/04/2015, 21:26:46
    Author     : Ruan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.domain.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="model.application.ClienteBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="XYZ@hotmail.com">
        <meta name="Generator" content="Sublime 3.0">
        <TITLE>Consulta de Clientes</TITLE>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <!-- Arquivo Css Criado -->
        <link href="css/style.css" rel="stylesheet" media="screen">
    </head>
    <body bgcolor="white">
        <!-- Menu Superior -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header col-sm-12">
                    <div class="navbar-brand col-sm-10" href="#" style=" padding-top: 10px">
                        <div class="row">
                            <div class="nav col-sm-2">
                                <img alt="" src="img/logo.png">
                                Locadora   
                            </div>   
                        </div>
                    </div>
                    <div class="nav col-sm-2">
                        <li class="dropdown img-User-nome">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                <div>
                                    <img src="img/user.png" alt=""  >
                                    Administrador
                                    <span class="caret"></span>   
                                </div>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <!--
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                -->

                                <li><a href="#">Sair</a></li>
                            </ul>
                        </li>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container-fluid" style="overflow: hidden">
            <div class="row">
                <div class="col-md-2">
                    <div class="accordion" id="leftMenu" class="left-menu">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#">
                                    <i class="icon-home"></i> Home
                                </a>
                            </div>
                        </div>

                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseAtor">
                                    <i class="icon-th"></i> Ator
                                </a>
                            </div>
                            <div id="collapseAtor" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaAtor.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraAtor.jsp">Novo</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseCliente">
                                    <i class="icon-th"></i> Cliente
                                </a>
                            </div>
                            <div id="collapseCliente" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaCliente.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraCliente.jsp">Novo</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseClasse">
                                    <i class="icon-th-list"></i> Classe
                                </a>
                            </div>
                            <div id="collapseClasse" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaClasse.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraClasse.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDevolucao">
                                    <i class="icon-list-alt"></i> Devolução
                                </a>
                            </div>
                            <div id="collapseDevolucao" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaDevolucao.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="EfetuaDevolucao.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>

                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDiretor">
                                    <i class="icon-th"></i> Diretor
                                </a>
                            </div>
                            <div id="collapseDiretor" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaDiretor.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraDiretor.jsp">Novo</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDistribuidor">
                                    <i class="icon-cog"></i> Distribuidor
                                </a>
                            </div>
                            <div id="collapseDistribuidor" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaDistribuidor.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraDistribuidor.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseFuncionario">
                                    <i class="icon-file"></i> Funcionário
                                </a>
                            </div>
                            <div id="collapseFuncionario" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaFuncionario.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraFuncionario.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseItem">
                                    <i class="icon-file"></i> Item
                                </a>
                            </div>
                            <div id="collapseItem" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaItem.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraItem.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseLocacao">
                                    <i class="icon-file"></i> Locação
                                </a>
                            </div>
                            <div id="collapseLocacao" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaLocacao.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="EfetuaLocacao.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapsePagamento">
                                    <i class="icon-file"></i> Pagamento
                                </a>
                            </div>
                            <div id="collapsePagamento" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaPagamento.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="EfetuaPagamento.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseReserva">
                                    <i class="icon-file"></i> Reserva
                                </a>
                            </div>
                            <div id="collapseReserva" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaReserva.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="EfetuaReserva.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseTitulo">
                                    <i class="icon-file"></i> Título
                                </a>
                            </div>
                            <div id="collapseTitulo" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <ul>
                                        <li class="opcoesDeMenu"><a href="ConsultaTitulo.jsp">Consultar</a></li>
                                        <li class="opcoesDeMenu"><a href="CadastraTitulo.jsp">Novo</a></li>
                                    </ul>                 
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                    <h2>Consultar Cliente</h2>
                    <%
                        List clientes = ClienteBD.consultaClientes();
                        Iterator<Cliente> i = clientes.iterator();
                        while (i.hasNext()) {

                           Cliente c = (Cliente) i.next();

                           out.print(c.getNome() + "<br>");
                       }
                    %>

                    
                    <div class="row" style="margin-right: 18px">
                        
                        <table class="table table-striped table-hover table-users">
                            <thead>
                                <tr>
                                    <th class="hidden-phone">Cod</th>
                                    <th>Nome</th>
                                    <th class="hidden-phone">CPF</th>
                                    <th>Data de Nascimento</th>
                                    <th class="hidden-phone">Telefone</th>
                                    <th class="hidden-phone">Miembro desde</th>
                                    <th>Estado</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr style=" padding-rigth: 30px;">
                                    <td class="hidden-phone">1</td>
                                    <td>johnny velasquez Nicolini</td>
                                    <td>11014912644</td>
                                    <td class="hidden-phone">10/08/1991</td>
                                    <td class="hidden-phone">(33)9132-1006</td>
                                    <td class="hidden-phone">10/12/1999</td>
                                                        
                                    <td><span class="label label-warning">Not Active</span></td>
                                                        
                                    <td><a class="btn mini blue-stripe" href="{site_url()}admin/editFront/1">Edit</a></td>

                                    <td><a href="#" class="confirm-delete btn mini red-stripe" role="button" data-title="johnny" data-id="1">Delete</a></td>
                                </tr>
                                <tr>
                                    <td class="hidden-phone">2</td>
                                    <td>jane Ferreira Loca</td>
                                    <td>12843265514</td>
                                    <td class="hidden-phone">31/10/1964</td>
                                    <td class="hidden-phone">(33)3263-2920</td>
                                    <td class="hidden-phone">10/1/1999</td>
                                                        
                                    <td><span class="label label-danger">Activo</span></td>
                                                        
                                    <td><a class="btn mini blue-stripe" href="{site_url()}admin/editFront/2">Edit</a></td>

                                    <td><a href="#" class="confirm-delete btn mini red-stripe" role="button" data-title="kitty" data-id="2">Delete</a></td>
                                </tr>
                            </tbody>
                        </table>
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
