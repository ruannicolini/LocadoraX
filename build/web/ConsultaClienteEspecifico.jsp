<%-- 
    Document   : CadastraCliente
    Created on : 26/03/2015, 08:55:35
    Author     : Ruan
--%>

<%@page import="model.domain.Socio"%>
<%@page import="model.domain.Cliente"%>
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
        <TITLE>Editar Cadastro</TITLE>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Carregando o CSS do Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />

        <!-- Arquivo Css Criado -->
        <link href="css/style.css" rel="stylesheet" media="screen">
    </head>

    <body bgcolor="white">
        <%
            //Pega o Registro do Cliente
            String id = request.getParameter("valor");
            System.out.println(id);
            
            Socio so = (Socio) ClienteBD.consultaId(id);
        %>
        
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
                            <input type="hidden" name="operacao" value="alterarSocio">
                            <input type="hidden" name="idSocio" value="<%out.print(so.getNumInscricao()); %>">
                            <div class="nav col-sm-12 ">
                                <div class="nav row">
                                    <label for="User" class="col-sm-12">Nome</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder="Nome" name="nome" value = "<%out.print(so.getNome()); %>" >
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="col-sm-5" style="padding :0">
                                        <label for="User" class="col-sm-12">Sexo</label>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="m"  
                                                <% 
                                                    if(so.getSexo() == 'm'){
                                                        out.print("checked");
                                                    }
                                            %> >&nbsp Masculino
                                        </div>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="f"
                                                <% 
                                                    if(so.getSexo() == 'f'){
                                                        out.print("checked");
                                                    }
                                                %>
                                            >&nbsp Feminino
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Data de Nascimento</label>
                                        <input type="text" class="form-control" placeholder="Data de Nascimento" name="dataNascimento" value = "<%out.print(so.getDataNascimento()); %>">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">CPF</label>
                                        <input type="text" class="form-control" placeholder="CPF" name="cpf" value = "<%out.print(so.getCpf()); %>">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Endereço</label>
                                        <input type="text" class="form-control" placeholder="Endereço" 
                                        name="endereco" value = "<%out.print(so.getEndereco()); %>">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <label for="User" class="col-sm-12">Telefone</label>
                                        <input type="text" class="form-control" placeholder="Telefone" name="tel" value = "<%out.print(so.getTelefone()); %>">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-12" align="rigth">
                                <div class="nav col-sm-5 " align="right"> 
                                    <button type ="button" class="btn" onclick="location. href= 'ConsultaCliente.jsp' "> Cancelar </button>
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
