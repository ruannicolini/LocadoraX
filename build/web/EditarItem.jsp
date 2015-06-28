<%-- 
    Document   : EditarItem
    Created on : 24/05/2015, 12:52:02
    Author     : Ruan
--%>

<%@page import="model.domain.TipoItem"%>
<%@page import="model.domain.Titulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="model.domain.Item"%>
<%@page import="model.application.ItemBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="sessao1.jsp"%>
<html>
<head>
    <meta charset = "UTF-8"> 
    <meta http-equiv="content-language" content="pt-br">
    <meta name="Autor" content="Ruan">
    <meta name="Reply-To" content="XYZ@hotmail.com">
    <meta name="GenerClasse" content="Sublime 3.0">
    <TITLE>Editar Item</TITLE>

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
            
            Item item = (Item) ItemBD.consultaId(id);
    %>
    <!-- Menu Superior -->
    <%@ include file="navBar.jsp"%>
    <div class="container-fluid" style="overflow: hidden">
        <div class="row">
            <div class="col-md-2">
                <%@ include file="menu.jsp"%>
            </div>
            <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                <h2>Editar Item</h2>
                <div class="row">
                    <form action="ControllerItem" method="POST">
                        <input type="hidden" name="operacao" value="alterar">
                        <input type="hidden" name="idItem" value="<%out.print(item.getNumSerie()); %>">
                            
                        <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label for="Nome" class="col-sm-12">Titulo</label>
                                    <%
                                        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                        Session s = sessions.openSession();

                                        //Listagem de socios
                                        String strQuery = "from Titulo";

                                        s.beginTransaction();
                                        Query qr = s.createQuery(strQuery);
                                        List titulos = qr.list();
                                        s.close();
                                    %>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <select name="titulo" class="form-control">
                                            <%
                                                Iterator i = titulos.iterator();
                                                while (i.hasNext()) {
                                                    Titulo t = (Titulo) i.next();
                                            %>  
                                            <option value="<%out.println(t.getIdTitulo());%>"
                                            <% if(item.getTitulo().getIdTitulo() == t.getIdTitulo()){
                                                out.println("selected");
                                            }%>
                                                    
                                            ><%out.println(t.getNome());%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5"> 
                                        <label for="" class="col-sm-12">Nº de Série</label>
                                        <div class="col-sm-12" style="padding :0">
                                            <input type="text" class="form-control" placeholder="Numero De Serie" name="numDeSerie" style="padding :0" value="<%out.print(item.getNumSerie()); %>">
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
                                                    <div class="col-sm-11" style="padding :0">
                                                        <select name="tipo" class="form-control">
                                                            <%
                                                                i = tipos.iterator();
                                                                while (i.hasNext()) {
                                                                    TipoItem tp = (TipoItem) i.next();
                                                            %>  
                                                            <option value="<%out.println(tp.getIdTipoItem());%>"
                                                            <% if(item.getTipo().getIdTipoItem() == tp.getIdTipoItem()){
                                                                out.println("selected");
                                                            }%>        
                                                            ><%out.println(tp.getNome());%></option>
                                                            <%}%>
                                                        </select>
                                                    </div> 
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Data de Aquisição</label>
                                                    <div class="col-sm-12" style="padding :0">
                                                        <input type="text" class="form-control" placeholder="Data" name="dtAquisicao" value="<%out.print(item.getDtArquisicao()); %>" >
                                                    </div> 
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12" align="rigth">
                            <div class="col-sm-6 formBTN2 " align="right"> 
                                    <button type ="button" class="btn" onclick="location. href= 'ConsultaItem.jsp' "> Cancelar </button>
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
<%@ include file="sessao2.jsp"%>