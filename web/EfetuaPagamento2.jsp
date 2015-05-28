<%-- 
    Document   : EfetuaPagamento
    Created on : 23/04/2015, 00:02:25
    Author     : Ruan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.domain.Locacao"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
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
        <TITLE>Pagamento</TITLE>

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
                    <h2>Pagamento</h2>
                    <div class="row">
                        <form action= "ControllerLocacao" method="POST">
                            <input type="hidden" name="operacao" value="pagamento"> 
                            <div class="row">

                                <div class="nav col-sm-12"> 
                                    <div class="nav row">
                                        <div class="input-group input-group-sm col-sm-5">
                                            <div class="row" style="margin :0">
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <label for="" class="col-sm-12">Data</label>
                                                        <div class="col-sm-11" style="padding :0">
                                                            <input type="date" class="form-control" placeholder="Nome" name="dtLocacao">
                                                            <script>
                                                            document.getElementById("dtLocacao").onchange = function() {myFunction()};

                                                                function myFunction() {
                                                                        
                                                                        <%
                                                                            String dt = request.getParameter("dtLocacao");
                                                                            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                                                            Session s = sessions.openSession();

                                                                            //Listagem de socios
                                                                            String strQuery = "from Locacao as loc where loc.dtLocacao = " + dt;

                                                                            s.beginTransaction();
                                                                            Query qr = s.createQuery(strQuery);
                                                                            List locacoes = qr.list();
                                                                            s.close();
                                                                        %>
                                                                }
                                                            </script>
                                                            
                                                            
                                                        </div> 
                                                    </div>

                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <label for="" class="col-sm-12">Item</label>
                                                        <div class="col-sm-12" style="padding :0">
                                                            <select name="item" class="form-control">
                                                            <%                                                   
                                                                Iterator i = locacoes.iterator();
                                                                while (i.hasNext()) {

                                                                    Locacao c = (Locacao) i.next();
                                                            %>  
                                                            <option value="<%out.println(c.getIdLocacao());%>"><%out.println(c.getItem().getNumSerie());%></option>
                                                            <%}%>
                                                        </select>
                                                        </div> 
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="nav col-sm-12 ">
                                    <div class="nav row">
                                        <div class="input-group input-group-sm col-sm-5">
                                            <table class="table table-striped table-hover table-users">
                                                <thead>
                                                    <tr>
                                                        <th>Cod</th>
                                                        <th>Filme</th>
                                                        <th>Status</th>
                                                        <th>Valor</th>
                                                        <th> </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                


                                <div class="nav col-sm-12 ">
                                    <div class="nav row">
                                        <label for="User" class="col-sm-12">Data do Pagamento</label>
                                        <div class="input-group input-group-sm col-sm-5">
                                            <input type="date" class="form-control" placeholder="dd/mm/aaaa" name="dataPag">
                                        </div>
                                    </div>
                                </div>

                                <div class="nav col-sm-12 ">
                                    <div class="nav row">
                                        <label for="User" class="col-sm-12">Valor</label>
                                        <div class="input-group input-group-sm col-sm-5">
                                            <input type="text" class="form-control" placeholder="R$" name="valor">
                                        </div>
                                    </div>
                                </div>
                            </div><!-- fim row -->  
                            
                            <div class="col-sm-12" align="rigth">
                                <div class="col-sm-6 formBTN2 " align="right"> 
                                    <button type ="button" class="btn" onclick="location. href= 'EfetuaLocacao.jsp' "> Cancelar </button>
                                    <button type ="submit" class="btn"> Concluir </button>
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
