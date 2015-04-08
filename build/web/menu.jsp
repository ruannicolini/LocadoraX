<%-- 
    Document   : menu
    Created on : 04/04/2015, 13:28:22
    Author     : Ruan
--%>


<div class="accordion" id="leftMenu" class="left-menu">
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#">
                <i class="icon-home"></i> Home
            </a>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseAtor">
                <i class="icon-th"></i> Ator
            </a>
        </div>
        <div id="collapseAtor" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaAtor.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraAtor.jsp">Novo</a></li>
                </ul>
            </div>
        </div>
    </div>
	<div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseClasse">
                <i class="icon-th-list"></i> Classe
            </a>
        </div>
        <div id="collapseClasse" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaClasse.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraClasse.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseCliente">
                <i class="icon-th"></i> Cliente
            </a>
        </div>
        <div id="collapseCliente" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaCliente.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraCliente.jsp">Novo</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDep">
                <i class="icon-th"></i> Dependente
            </a>
        </div>
        <div id="collapseDep" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaDependente.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraDependente.jsp">Novo</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDevolucao">
                <i class="icon-list-alt"></i> Devolução
            </a>
        </div>
        <div id="collapseDevolucao" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaDevolucao.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="EfetuaDevolucao.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDiretor">
                <i class="icon-th"></i> Diretor
            </a>
        </div>
        <div id="collapseDiretor" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaDiretor.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraDiretor.jsp">Novo</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseDistribuidor">
                <i class="icon-cog"></i> Distribuidor
            </a>
        </div>
        <div id="collapseDistribuidor" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaDistribuidor.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraDistribuidor.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseFuncionario">
                <i class="icon-file"></i> Funcionário
            </a>
        </div>
        <div id="collapseFuncionario" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaFuncionario.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraFuncionario.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseItem">
                <i class="icon-file"></i> Item
            </a>
        </div>
        <div id="collapseItem" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaItem.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraItem.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseLocacao">
                <i class="icon-file"></i> Locação
            </a>
        </div>
        <div id="collapseLocacao" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaLocacao.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="EfetuaLocacao.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapsePagamento">
                <i class="icon-file"></i> Pagamento
            </a>
        </div>
        <div id="collapsePagamento" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaPagamento.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="EfetuaPagamento.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseReserva">
                <i class="icon-file"></i> Reserva
            </a>
        </div>
        <div id="collapseReserva" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaReserva.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="EfetuaReserva.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>
    <div class="accordion-group">
        <div class="accordion-heading">
            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseTitulo">
                <i class="icon-file"></i> Título
            </a>
        </div>
        <div id="collapseTitulo" class="accordion-body collapse" style="height: 0px; ">
            <div class="accordion-inner">
                <ul>
                    <li class="opcoesDeMenu"><a href="ConsultaTitulo.jsp">Consultar</a></li>
                    <li class="opcoesDeMenu"><a href="CadastraTitulo.jsp">Novo</a></li>
                </ul>                 
            </div>
        </div>
    </div>

</div>
