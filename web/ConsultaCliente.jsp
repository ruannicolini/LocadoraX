<%-- 
    Document   : ConsultaCliente
    Created on : 02/04/2015, 21:26:46
    Author     : Ruan
--%>

<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="model.domain.Socio"%>
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
        <TITLE>Consulta de Socio</TITLE>

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
                    <h2>Consultar Sócio</h2>
                    <%
                        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                        Session s = sessions.openSession();

                        String strQuery = "from Cliente as c where c.class=Socio";

                        s.beginTransaction();
                        Query qr = s.createQuery(strQuery);
                        List socios = qr.list();
                    %>

                    
                    <div class="nav col-sm-12"> 
                        <div class="nav row">
                            <div class="col-sm-5" style="padding :0">
                                <div id="input-div">
                                    <input id="search" class="center-block form-control" placeholder="Search.." autocomplete= "off" />
                                    <div id="suggestions" class="text-center center-block" style="display:none;">
                                        <div id="suggestion-results"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row" style="margin-right: 18px">
                        <table class="table table-responsive table-striped table-hover table-users">
                            <thead>
                                <tr>
                                    <th class="hidden-phone">Cod</th>
                                    <th>Nome</th>
                                    <th class="hidden-phone">CPF</th>
                                    <th>Data de Nascimento</th>
                                    <th class="hidden-phone">Telefone</th>
                                    <th>Status</th>
                                    <th>Editar</th>
                                    <th>Excluir</th>
                                </tr>
                            </thead>

                            <tbody>

                                <script type="text/javascript">
                                function consultaCli(id)
                                {
                                    alert("Cod Cliente = " + id);
                                    location.href= "ConsultaClienteEspecifico.jsp?valor="+id
                                }
                                </script>

                                <%
                                    Iterator<Socio> i = socios.iterator();
                                    while (i.hasNext()){			
                                        Socio so = (Socio)i.next();
					
                                        out.println("<tr>"			
                                        + "<td class= \"hidden-phone\">" + so.getNumInscricao()+ "</td>"
                    					+ "<td>" + so.getNome() + "</td>"
                    					+ "<td>" + so.getCpf() + "</td>"
                                        + "<td>" 
                                            + so.getDataNascimento() 
                                        + "</td>"
                    					
                                        + "<td>" 
                                        + so.getTelefone() 
                                        + "</td>");

                                        if(((Cliente)so).isAtivo() == true) {
                                            out.println("<td>" 
                                                    + "<span class= \"label label-danger\"> Ativo </span>" 
                                                    + "</td>");  
                                        }else{
                                            out.println("<td>" 
                                            + "<span class= \"label label-warning\"> Não Ative </span>" 
                                            + "</td>");
                                        }


                                        out.println("<td>"
                                                        + "<a href=\"ConsultaClienteEspecifico.jsp\"> <button type=\"button\" value = " + so.getNumInscricao() + ">Editar</button></a>"
                                                + "</td>"
                                                + "<td>"
                                                    + "<button type=\"button\" onClick= \"consultaCli(" + so.getNumInscricao() + ")\">Excluir</button>"
                                		+ "</td>"	
                                            + "</tr>");
								
                                        
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
