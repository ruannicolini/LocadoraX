<%-- 
    Document   : listaCliente
    Created on : 31/03/2015, 11:23:43
    Author     : Ruan
--%>

<%@page import="model.application.ClienteBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%@ page import="org.hibernate.Session"%>
        <%@ page import="org.hibernate.SessionFactory"%>
        <%@ page import="org.hibernate.Query"%>
        <%@ page import="org.hibernate.cfg.AnnotationConfiguration"%>
        <%@ page import="model.domain.Cliente"%>
        <%@ page import="java.util.Iterator"%>
        <%@ page import="java.util.List"%>
        
       

        <%
             List clientes = ClienteBD.consultaClientes();
             Iterator<Cliente> i = clientes.iterator();
             while (i.hasNext()) {

                Cliente c = (Cliente) i.next();

                out.print(c.getNome() + "<br>");
            }
        %>




    </body>

</html>
