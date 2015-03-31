<%-- 
    Document   : listaCliente
    Created on : 31/03/2015, 11:23:43
    Author     : Ruan
--%>

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

            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();

            String strQuery = "from Cliente";

            s.beginTransaction();
            Query qr = s.createQuery(strQuery);
            List clientes = qr.list();

            Iterator<Cliente> i = clientes.iterator();
            while (i.hasNext()) {

                Cliente c = (Cliente) i.next();

                out.print(c.getNome() + "<br>");
            }

            s.close();

        %>




    </body>

</html>
