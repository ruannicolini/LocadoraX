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
                    <div class="row">
                        <form action= "ControllerLocacao" method="POST">
                            <input type="hidden" name="operacao" value="pagamento"> 
                            <div class="row">

                                <%
                                                SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                                                Session s = sessions.openSession();

                                                //Listagem de socios
                                                String strQuery = "from Locacao";

                                                s.beginTransaction();
                                                Query qr = s.createQuery(strQuery);

                                                List locacoes = qr.list();
                                                s.close();

                                            %>
                                <div class="col-sm-12" style="padding : 0; margin-left: 40px;"> 
                                    <div class="row">
                                        <div class="col-sm-3" style="padding :0">
                                            <h1 class="page-title">Pagamento</h1>
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
                                

                                <div class="nav col-sm-12 "> 
                                    <div class="nav row">
                                        
                                        <div class="col-sm-12 testeVermelho" style="padding :0">
                                            <div class="input-group">   
                                            </div> 
                                            <table class="table table-striped table-hover table-users" style="width:96%">
                                                <thead>
                                                    <tr>
                                                        <th>Cod</th>
                                                        <th>Filme</th>
                                                        <th>Item</th>
                                                        <th>Cliente</th>
                                                        <th>Status Pago</th>
                                                        <th>DT Locação</th>
                                                        <th>Valor</th>
                                                        <th>Selecionar</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%                                                    
                                                        Iterator i = locacoes.iterator();
                                                        while (i.hasNext()) {

                                                            Locacao loc = (Locacao) i.next();
                                                            out.println(
                                                            "<tr>"
                                                                    + "<td>" + loc.getIdLocacao() + "</td>"
                                                                    + "<td>" + loc.getItem().getTitulo().getNome() + "</td>"
                                                                    + "<td>" + loc.getItem().getNumSerie() + "</td>"
                                                                    + "<td>" + loc.getCliente().getNome() + "</td>"
                                                                    + "<td>" + loc.getDtLocacao() + "</td>"
                                                                    + "<td>" + loc.getItem().getTitulo().getClasse().getValor() + "</td>"
                                                                    + "<td>" + "teste" + "</td>"
                                                                    + "<td>" 
                                                                    + "<INPUT TYPE=\"checkbox\" NAME=\"selecionado"+ loc.getIdLocacao()+ "\" VALUE=\"" + loc.getIdLocacao() +"\">" 
                                                                    + "</td>"
                                                          + "</tr>");
                                                        }
                                                    %>
                                                </tbody>
                                            </table>  
                                        </div>
                                    </div>
                                </div>
                                <div class="nav col-sm-12"> 
                                    <div class="nav row">
                                        <div class="input-group input-group-sm col-sm-5">
                                            <div class="row" style="margin :0">
                                                <div class="col-sm-4">
                                                    <div class="row">
                                                        <label for="User" class="col-sm-12">Data do Pagamento</label>
                                                        <div class="input-group input-group-sm col-sm-11">
                                                            <input type="date" class="form-control" placeholder="dd/mm/aaaa" name="dataPag">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="row">
                                                        <label for="User" class="col-sm-12">Valor</label>
                                                        <div class="input-group input-group-sm col-sm-12">
                                                            <input type="text" class="form-control" placeholder="R$" name="valor">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="row">
                                                        
                                                        <label for="User" class="col-sm-12">Multa</label>
                                                        <div class="input-group input-group-sm col-sm-12">
                                                            <input type="text" class="form-control" placeholder="R$" name="multa">
                                                        </div>

                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div><!-- fim row -->  

                            








                            
                            <!-- Codigo referente ao campo pesquisa -->
                            <span id="no-rows" class="center-block text-center" style="display:none;">No results.</span>

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
        <script type="text/javascript" src="js/jsProject.js"></script>   
    </body>
</html>
