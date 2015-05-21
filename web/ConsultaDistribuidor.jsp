<%-- 
    Document   : ConsultaDistribuidor
    Created on : 21/05/2015, 18:43:39
    Author     : Ruan
--%>

<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Distribuidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="XYZ@hotmail.com">
        <meta name="Generator" content="Sublime 3.0">
        <TITLE>Consulta de Distribuidores</TITLE>

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
            <div class="row nav">
                <div class="col-md-2">
                    <%@ include file="menu.jsp"%>
                </div>

                <div class="col-sm-10 formCadastro" style="padding-left: 20px">
                    <%
                        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                        Session s = sessions.openSession();

                        String strQuery = "from Distribuidor";

                        s.beginTransaction();
                        Query qr = s.createQuery(strQuery);
                        List  distribuidores = qr.list();
                    %>

                    
                    <div class="col-sm-12" style="padding : 0"> 
                        <div class="row">
                            <div class="col-sm-3" style="padding :0">
                                <h1 class="page-title">Consultar Distribuidor</h1>
                            </div>
                            <div class="col-sm-9" style="padding :0; ">
                                <div class="row">
                                    <div id="input-div" class="col-sm-3" style="float : right; margin-right: 35px;">

                                        <input id="search" class="center-block form-control" placeholder="Search.." autocomplete= "off" />
                                        <div id="suggestions" class="text-center center-block" style="display:none;">
                                            <div id="suggestion-results"></div>
                                        </div>

                                    </div>
                                </div>
                                
                            </div>
                            <div class="col-sm-12" style="padding :0">

                                <%
                                     // Errors
                                    String error = request.getParameter("erro");
                                    if( error != null) {
                                        if(error.equals("0")) {
                                            out.println("<div class='alert alert-success' style = 'margin-right: 35px'>Ação realizada com sucesso!</div>");
                                        } else {
                                            out.println("<div class='alert alert-danger' style = 'margin-right: 35px'>Erro!</div>");
                                        }
                                    }

                                %>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                    <div class="row" style="margin-right: 18px">
                        <table class="table table-responsive table-striped table-hover table-users">
                            <thead>
                                <tr>
                                    <th class="hidden-phone">Cnpj</th>
                                    <th>Razão Social</th>
                                    <th>Editar</th>
                                    <th>Excluir</th>
                                </tr>
                            </thead>

                            <tbody>

                                <script type="text/javascript">
                                function consultaDist(id)
                                {
                                    location.href= "EditarDistribuidor.jsp?valor="+id;
                                }
                                </script>

                                <%
                                    Iterator<Distribuidor> i = distribuidores.iterator();
                                    while (i.hasNext()){            
                                        Distribuidor dist = (Distribuidor)i.next();
                                            out.println("<form action= \"ControllerDistribuidor\" method=\"POST\">"
                                               +" <input type=\"hidden\" name=\"operacao\" value=\"excluir\">");
                                        
                                                                               
                                            out.println("<tr>");
                                            out.println("<td class= \"hidden-phone\">" + dist.getCnpj() + "</td>"
                                                + "<td>" + dist.getRazaoSocial() + "</td>");

                                            out.println("<td>"
                                                            + "<button type=\"button\" onClick= \"consultaDist(" + dist.getCnpj() + ")\">Editar</button>"
                                                    + "</td>"       
                                                    + "<td>"
                                                        + "<button type=\"submit\" name = \"btnExcluir\" value = "+ dist.getCnpj() +">Excluir</button>"
                                                    + "</td>"                                           
                                            + "</tr>");
                                            out.println("</form>");
                                    }
                                    s.close();
                                %>                               
                            </tbody>
                        </table>
                    </div>

                    <!-- Codigo referente ao campo pesquisa -->
                    <span id="no-rows" class="center-block text-center" style="display:none;">No results.</span>


                    <div class="divider divider-single"></div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jsProject.js"></script>
        
    </body>
</html>
