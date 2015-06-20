<%-- 
    Document   : EditarLocacao
    Created on : 20/06/2015, 14:09:00
    Author     : Ruan
--%>

<%@page import="model.domain.Item"%>
<%@page import="model.domain.Titulo"%>
<%@page import="model.domain.Cliente"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="model.domain.Locacao"%>
<%@page import="model.application.LocacaoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <meta http-equiv="content-language" content="pt-br">
        <meta name="Autor" content="Ruan">
        <meta name="Reply-To" content="XYZ@hotmail.com">
        <meta name="GenerClasse" content="Sublime 3.0">
        <TITLE>Editar Locação</TITLE>

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
                
                Locacao loc = (Locacao) LocacaoBD.consultaId(id);
        %>
        <!-- Menu Superior -->
        <%@ include file="navBar.jsp"%>
        <div class="container-fluid" style="overflow: hidden">
            <div class="row">
                <div class="col-md-2">
                    <%@ include file="menu.jsp"%>
                </div>
                <div class="nav col-sm-10 formCadastro" style="padding-left: 20px">
                    <h2>Editar Locacao</h2>
                    <div class="row">
                        <form action="ControllerLocacao" method="POST">
                            <input type="hidden" name="operacao" value="alterar">
                            <input type="hidden" name="idLocacao" value="<%out.print(loc.getIdLocacao()); %>">
                                
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
                                            <option value="<%out.println(c.getNumInscricao());%>"
                                            <% if(loc.getCliente().getNumInscricao() == c.getNumInscricao()){
                                                                out.println("selected");
                                                }
                                            %>
                                            
                                            ><%out.println(c.getNome());%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                            </div>

                                        
                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
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

                                    <div class="input-group col-sm-5">
                                        <select name="titulo" class="form-control">
                                            <%                                                   
                                                i = titulos.iterator();
                                                while (i.hasNext()) {

                                                Titulo tit = (Titulo) i.next();
                                            %>  
                                                <option value="<%out.println(tit.getIdTitulo());%>"
                                                <% if(loc.getItem().getTitulo().getIdTitulo() == tit.getIdTitulo()){
                                                                out.println("selected");
                                                    }
                                                %>
                                                
                                                ><%out.println(tit.getNome());%></option>
                                            <%}%>
                                        </select>
                                        
                                        <!--
                                        <input type="text" class="form-control" placeholder="Nome " nome="cliente">
                                        <span class="input-group-addon" id="item">Pesquisar</span>
                                        -->

                                    </div>
                                </div>
                            </div>

                            <div class="nav col-sm-12 "> 
                                <div class="nav row">
                                    <label class="col-sm-12">Item</label>
                                    <%
                                        sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                        s = sessions.openSession();

                                        //Listagem de socios
                                        strQuery = "from Item where statusLocado = false";

                                        s.beginTransaction();
                                        qr = s.createQuery(strQuery);

                                        List itens = qr.list();
                                        s.close();

                                    %>
                                    <script type="text/javascript">
                                        function FuncaoPreco(id)
                                        {
                                            var e = document.getElementById("id_select_Item");
                                            var itemSelecionado = e.options[e.selectedIndex].value;
                                            <%
                                        
                                            %>
                                        }
                                    </script>

                                    <div class="input-group col-sm-5">
                                        <select name="item" class="form-control" onchange="FuncaoPreco()" id="id_select_Item">
                                            <%                                                   
                                                i = itens.iterator();
                                                while (i.hasNext()) {

                                                Item it = (Item) i.next();
                                            %>  
                                                <option value="<%out.println(it.getNumSerie());%>"
                                                <% if(loc.getItem().getNumSerie() == it.getNumSerie()){
                                                                out.println("selected");
                                                    }
                                                %>
                                                    
                                                ><%out.println(it.getNumSerie());%></option>
                                            <%}%>
                                        </select>
                                        
                                        <!--
                                        <input type="text" class="form-control" placeholder="Nome " nome="cliente">
                                        <span class="input-group-addon" id="item">Pesquisar</span>
                                        -->

                                    </div>
                                </div>
                            </div>


                            <div class="nav col-sm-12"> 
                                <div class="nav row">
                                    <div class="input-group input-group-sm col-sm-5">
                                        <div class="row" style="margin :0">

                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Data de &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Locação &nbsp <br></label>
                                                    <div class="col-sm-11" style="padding :0">
                                                        <input type="text" class="form-control" placeholder=" " nome="dtLocacao" value="<%out.print(loc.getDtLocacao()); %>">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Data Prevista de Devolução</label>
                                                    
                                                    <div class="col-sm-11" style="padding :0">
                                                        <input type="text" class="form-control" placeholder=" " nome="dtPrevDevolucao" value="<%out.print(loc.getDtDevolucaoPrevista()); %>">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Data Efetiva de Devolução</label>
                                                    <div class="col-sm-12" style="padding :0">
                                                        <input type="tet" class="form-control" placeholder=" " nome="dtEfetDevolucao" value="<%out.print(loc.getDtDevolucaoEfetiva()); %>">
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
                                                    <label for="" class="col-sm-12">Valor</label>
                                                    <div class="col-sm-11" style="padding :0">
                                                        <input type="text" class="form-control" placeholder=" " nome="valor" value="<%out.print(loc.getValorCobrado()); %>">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="row">
                                                    <label for="" class="col-sm-12">Multa</label>
                                                    <div class="col-sm-12" style="padding :0">
                                                        <input type="text" class="form-control" placeholder=" " nome="multa" value="<%out.print(loc.getMultaCobrada()); %>">
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
                                                    <label for="" class="col-sm-12">Valor Total</label>
                                                    <div class="col-sm-11" style="padding :0">
                                                        <input type="text" class="form-control" nome="valorTotal" 
                                                               value="<%Float x = (loc.getValorCobrado() + loc.getMultaCobrada());out.print(x);%>">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>











                            <div class="col-sm-12" align="rigth">
                                <div class="col-sm-6 formBTN2 " align="right"> 
                                        <button type ="button" class="btn" onclick="location. href= 'ConsultaLocacao.jsp' "> Cancelar </button>
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
