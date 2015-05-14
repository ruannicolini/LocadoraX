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
        <TITLE>Editar Cadastro</TITLE>

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
                    <h2>Editar Cliente</h2>
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
