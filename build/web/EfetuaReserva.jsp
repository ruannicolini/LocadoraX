<%-- 
    Document   : EfetuaReserva
    Created on : 22/04/2015, 21:22:52
    Author     : Ruan
--%>

<%@page import="model.domain.Titulo"%>
<%@page import="model.domain.TipoItem"%>
<%@page import="model.domain.TipoItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.domain.Cliente"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="XYZ@hotmail.com">
        <meta name="Generator" content="Sublime 3.0">
        <TITLE>Efetuar Reserva</TITLE>

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
                    <h2>Cadastro de Reserva</h2>
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
                    <div class="row">
                        <form action= "ControllerReserva" method="POST">
                            <input type="hidden" name="operacao" value="cadastrar"> 
                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label class="col-sm-12">Cliente</label>
                                    <%
                                        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                        Session s = sessions.openSession();

                                        //Listagem de socios
                                        String strQuery = "from Cliente";

                                        s.beginTransaction();
                                        Query qr = s.createQuery(strQuery);
                                        List clientes = qr.list();

                                        s.close();
                                    %>

                                    <div class="input-group col-sm-5">
                                        <select name="cliente" class="form-control">
                                            <%
                                                Iterator i = clientes.iterator();
                                                while (i.hasNext()) {
                                                    Cliente c = (Cliente) i.next();
                                            %>  
                                            <option value="<%out.println(c.getNumInscricao());%>"><%out.println(c.getNome());%></option>
                                            <%}%>
                                        </select>

                                        <!--
                                        <input type="text" class="form-control" placeholder="Nome" aria-describedby="cliente">
                                        <span class="input-group-addon" id="cliente">Pesquisar</span>
                                        -->


                                    </div>
                                </div>
                            </div>
                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <div class="row" style="margin :0">
                                            <div class="col-sm-3">
                                                <div class="row">
                                                    <label for="" class="col-sm-12" style="padding: 0 ">Tipo</label>
                                                    <%
                                                        sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                                        s = sessions.openSession();

                                                        //Listagem de socios
                                                        strQuery = "from TipoItem";

                                                        s.beginTransaction();
                                                        qr = s.createQuery(strQuery);
                                                        List tipos = qr.list();
                                                        s.close();
                                                    %>
                                                    <div class="col-sm-10" style="padding :0">
                                                        <select name="tipo" class="form-control">
                                                            <%
                                                                i = tipos.iterator();
                                                                while (i.hasNext()) {
                                                                    TipoItem tp = (TipoItem) i.next();
                                                            %>  
                                                            <option value="<%out.println(tp.getIdTipoItem());%>"><%out.println(tp.getNome());%></option>
                                                            <%}%>
                                                        </select>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="col-sm-9">
                                                <div class="row">
                                                    <label class="col-sm-12">Título</label>
                                                    <%
                                                        sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                                        s = sessions.openSession();

                                                        //Listagem de socios
                                                        strQuery = "from Titulo";

                                                        s.beginTransaction();
                                                        qr = s.createQuery(strQuery);
                                                        List titulos = qr.list();
                                                        s.close();
                                                    %>
                                                    <div class="input-group col-sm-12">
                                                        <select name="titulo" class="form-control">
                                                            <%
                                                                i = titulos.iterator();
                                                                while (i.hasNext()) {
                                                                    Titulo t = (Titulo) i.next();
                                                            %>  
                                                            <option value="<%out.println(t.getIdTitulo());%>"><%out.println(t.getNome());%></option>
                                                            <%}%>
                                                        </select>
                                                        <!--
                                                        <input type="text" class="form-control" placeholder="Nome" aria-describedby="titulo">
                                                             <span class="input-group-addon" id="titulo">Pesquisar</span>
                                                        -->
                                                     </div> 
                                                </div>
                                                
                                            </div>
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
                                                    <label for="" class="col-sm-12">Reservar Para(Dia):</label>
                                                    <div class="col-sm-11" style="padding :0">
                                                        
                                                        <input type="text" class="form-control" name="dtReserva">
                                                    </div> 
                                                </div>

                                            </div>
                                            <div class="col-sm-6">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Hora da Reserva </label>
                                                    <div class="col-sm-12" style="padding :0">
                                                        <input type="time" class="form-control"  name="hrReserva">
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <!--<script type="text/javascript" src="js/jsProject.js"></script>-->   
    </body>
</html>
