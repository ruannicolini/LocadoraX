<%-- 
    Document   : CadastraAtor
    Created on : 04/04/2015, 14:08:33
    Author     : Ruan
--%>
<%@page import="model.domain.Ator"%>
<%@page import="model.application.AtorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset = "UTF-8"> 
	<meta http-equiv="content-language" content="pt-br">
	<meta name="Autor" content="Ruan">
	<meta name="Reply-To" content="XYZ@hotmail.com">
	<meta name="Generator" content="Sublime 3.0">
  	<TITLE>Editar Ator</TITLE>

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
            
            Ator at = (Ator) AtorBD.consultaId(id);
    %>
    <!-- Menu Superior -->
    <%@ include file="navBar.jsp"%>
    <div class="container-fluid" style="overflow: hidden">
    	<div class="row">
            <div class="col-md-2">
                <%@ include file="menu.jsp"%>
            </div>
            <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                <h2>Editar Ator</h2>
                <div class="row">
                    <form action="ControllerAtor" method="POST">
                        <input type="hidden" name="operacao" value="alterar">
                        <input type="hidden" name="idAtor" value="<%out.print(at.getIdAtor()); %>">
                        <div class="nav col-sm-12 "> 
                            <div class="nav row">
                                <label class="col-sm-12">Nome</label>
                                <div class="input-group input-group-sm col-sm-5">
                                    <input type="text" class="form-control" placeholder="Nome" name="nome" value = "<%out.print(at.getNome()); %>">
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
