<%-- 
    Document   : CadastraTitulo
    Created on : 09/04/2015, 08:31:58
    Author     : Ruan
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.Iterator"%>
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
        <TITLE>Cadastro de Título</TITLE>

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
                        <h2>Cadastro de Título</h2>
                        <div class="row">
                            <form action= "ControllerTitulo" method="POST">
                                <input type="hidden" name="operacao" value="cadastrar">                    
                                <div class="nav col-sm-12 "> 
                                    <div class="nav row">
                                        <label for="Nome" class="col-sm-12">Nome</label>
                                        <div class="input-group input-group-sm col-sm-5">
                                            <input type="text" class="form-control" placeholder=" " nome ="nome">
                                        </div>
                                    </div>
                                </div>

                                <div class="nav col-sm-12"> 
                                    <div class="nav row">
                                        <div class="input-group input-group-sm col-sm-5">
                                            <div class="row" style="margin :0">
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <label for="" class="col-sm-12">Ano</label>
                                                        <div class="col-sm-11" style="padding :0">
                                                            <input type="text" class="form-control" placeholder=" " nome ="ano" style="text-align:right">
                                                        </div> 
                                                    </div>
                                                    
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <label for="" class="col-sm-12">Categoria </label>
                                                        <div class="col-sm-12" style="padding :0">
                                                            <input type="text" class="form-control" placeholder=" " nome ="categoria" style="text-align:right">
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
                                                        <%
                                                        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                                        Session s = sessions.openSession();

                                                        //Listagem de socios
                                                        String strQuery = "from Distribuidor";

                                                        s.beginTransaction();
                                                        Query qr = s.createQuery(strQuery);

                                                        List dist = qr.list();
                                                        %>
                                                        <label for="" class="col-sm-12">Distribuidor</label>
                                                        <div class="col-sm-11" style="padding :0">
                                                            <select name="distribuidor" class="form-control">
                                                                <%
                                                                Iterator i = dist.iterator();
                                                                while (i.hasNext()){
                                                                    
                                                                    Distribuidor d = (Distribuidor)i.next();
                                                                %>  
                                                                    <option value="<%out.println(d.getCnpj());%>"><%out.println(d.getRazaoSocial());%></option>
                                                                <%}%>
                                                             </select>
                                                        </div> 
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="row">
                                                        <label for="" class="col-sm-12">Classe </label>
                                                        <div class="col-sm-12" style="padding :0">
                                                            <select name="classe" class="form-control">
                                                                <option value="">Selecione</option>
                                                                <option value="C1">Classe1</option>
                                                                <option value="C2">Classe2</option>
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
                                        <label for="Nome" class="col-sm-12">Diretor</label>
                                        <div class="input-group input-group-sm col-sm-5">
                                            <select name="diretor" class="form-control">
                                                <option value="">Selecione</option>
                                                <option value="dt1">Diretor1</option>
                                                <option value="dt2">Diretor2</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-12" align="rigth">
                                    <div class="col-sm-6 formBTN2 " align="right"> 
                                    <button class="btn"> Cancelar </button>
                                    <button class="btn"> Salvar </button>
                                    </div> 
                                </div>

                                <div class="nav col-sm-12 "> 
                                    <div class="nav row">
                                        <div class="col-sm-5" style="padding :0">
                                            <h4>Atores Participantes</h4>  
                                        </div>
                                    </div>
                                </div>

                                <div class="nav col-sm-12 "> 
                                    <div class="nav row">
                                        <div class="col-sm-5 testeVermelho" style="padding :0">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="Nome" nome ="basic-addon2">
                                                 <span class="input-group-addon" id="basic-addon2">ADD</span>
                                            </div> 
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Cod</th>
                                                        
                                                        <th>Nome</th>
                                                        
                                                        <th>Opções</th>
                                                        
                                                    </tr>
                                                </thead>
                                            </table>  
                                        </div>
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
