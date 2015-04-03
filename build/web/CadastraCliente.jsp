<%-- 
    Document   : CadastraCliente
    Created on : 26/03/2015, 08:55:35
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
        <TITLE>Cadastro de Cliente</TITLE>

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
                    <h2>Cadastro de Cliente</h2>
                    <div class="row">
                        <form action= "ControllerCliente" method="POST">
                            <input type="hidden" name="operacao" value="cadastrar">
                            <div class="nav col-sm-12 ">
                                  
                                <div class="nav row">
                                    <label for="User" class="col-sm-12">Nome</label>
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

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">CPF</label>
                                        <input type="text" class="form-control" placeholder="CPF" name="cpf">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Endereço</label>
                                        <input type="text" class="form-control" placeholder="Endereço" 
                                        name="endereco">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Telefone</label>
                                        <input type="text" class="form-control" placeholder="Telefone" name="tel">
                                    </div>
                                </div>
                            </div>



                            <div class=" nav col-sm-5 " style="margin-left: 10px">
                                <h4>Incluir Depedentes</h4>
                            </div>
                            <div class="col-sm-12" style="padding : 35px">
                                <div class="nav col-sm-5 testeVermelho" style="padding : 10px; margin-left : 10px">

                                    <div style= "padding : 0">
                                        <label for="User" class="nav col-sm-1" style= "padding : 0" >Nome</label>
                                        <input type="text" class="form-control nav col-sm-3" placeholder="Nome" name="nomeDependente">
                                    </div>

                                    <div style= "padding : 0">
                                        <label for="User" class="nav col-sm-12" style= "padding : 0" >Data de Nascimento</label>
                                        <input type="Date" id="DN" name="DataNascimentoDependente" class="nav col-sm-12" />
                                    </div> 

                                    <div style= "padding : 0">
                                        <label for="User" class="nav col-sm-12" style= "padding : 0" >Sexo</label>

                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sexDependente" value="Masculino">&nbsp Masculino
                                        </div>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sexDependente" value="Feminino">&nbsp Feminino
                                        </div>
                                    </div> 


                                </div>
                            </div>     

                            <div class="col-sm-12">
                                <div class="nav col-sm-4 testeVermelho" style="margin-left :10px">
                                </div>

                                <div class="nav col-sm-1 " align="right"> 
                                    <button class="btn" style= "padding : 3px"> Adicionar </button>
                                </div>   
                            </div>
                            <div class="col-sm-12">
                                <div class="nav col-sm-5 ">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Nome</th>
                                                <th>Sexo</th>
                                                <th>Data Nasc.</th>
                                                <th>Opções</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>   
                            </div>
                            <div class="col-sm-12" align="rigth">
                                <div class="nav col-sm-5 " align="right"> 
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
