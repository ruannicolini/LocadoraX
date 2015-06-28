<%-- 
    Document   : EditarDependente
    Created on : 23/05/2015, 21:29:34
    Author     : Ruan
--%>

<%@page import="model.domain.Socio"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.domain.Cliente"%>
<%@page import="model.domain.Dependente"%>
<%@page import="model.application.ClienteBD"%>
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
    <TITLE>Editar Dependente</TITLE>

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
            
            //Pega o Registro do Cliente
            String idSocio = request.getParameter("idSocio");
            
            Socio soc = (Socio) ClienteBD.consultaId(idSocio);
            Dependente dep = (Dependente) ClienteBD.consultaId(id);
    %>
    <!-- Menu Superior -->
    <%@ include file="navBar.jsp"%>
    <div class="container-fluid" style="overflow: hidden">
        <div class="row">
            <div class="col-md-2">
                <%@ include file="menu.jsp"%>
            </div>
            <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                <h2>Editar Dependente</h2>
                <div class="row">

                    <form action="ControllerCliente" method="POST">
                        <input type="hidden" name="operacao" value="alterarDependente">
                        <input type="hidden" name="idDependente" value="<%out.print(dep.getNumInscricao()); %>">
                        <input type="hidden" name="idSocio" value="<%out.print(soc.getNumInscricao()); %>">
                        
                            <%
                            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                            Session s = sessions.openSession();

                            //Listagem de socios
                            String strQuery = "from Cliente as cli where cli.class=Socio";

                            s.beginTransaction();
                            Query qr = s.createQuery(strQuery);

                            List socios = qr.list();
                            %>
                            
                            <div class="nav col-sm-12 ">
                                <div class="nav row">
                                    <label for="User" class="col-sm-12">Socio</label>
                                    <div class="col-sm-5">
                                        <div class="row">
                                            <select name="idSocio" class="form-control col-sm-12" disabled>
                                                <%
                                                Iterator i = socios.iterator();
                                                while (i.hasNext()){
                                                    
                                                    Cliente c = (Cliente)i.next();
                                                %>  
                                                    <option value="<%out.println(c.getNumInscricao());%>"
                                                        <% if(c.getNumInscricao() == soc.getNumInscricao()){
                                                                out.println("selected");
                                                        }%>
                                                    >
                                                        <%out.println(c.getNome());%> 
                                                    </option>
                                                <%}%>
                                            </select>  
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 ">
                                <div class="nav row">
                                    <label for="User" class="col-sm-12">Dependente</label>
                                    <div class="input-group input-group-sm col-sm-5">
                                        <input type="text" class="form-control" placeholder="Nome" name="nome" value="<%out.println(dep.getNome());%>">
                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="col-sm-5" style="padding :0">
                                        <label for="User" class="col-sm-12">Sexo</label>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="m" 
                                                <% if(dep.getSexo() == 'm'){
                                                        out.println("checked");
                                                }
                                                %>
                                            >&nbsp Masculino
                                        </div>
                                        <div class="col-sm-3 formCadastro-RadioButtom">
                                            <input type="radio" name="sex" value="f"
                                                <% if(dep.getSexo() == 'f'){
                                                        out.println("checked");
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
                                        <input type="text" class="form-control" placeholder="Data de Nascimento" name="dataNascimento" value="<%out.println(dep.getDataNascimento());%>">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-12" align="rigth">
                            <div class="col-sm-6 formBTN2 " align="right"> 
                                <button type ="button" class="btn" onclick="location. href= 'ConsultaDependente.jsp' "> Cancelar </button>
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