package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.cfg.AnnotationConfiguration;
import model.domain.Cliente;
import model.domain.Socio;
import java.util.Iterator;
import java.util.List;

public final class CadastraDependente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/navBar.jsp");
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset = \"UTF-8\"> \n");
      out.write("        <meta http-equiv=\"content-language\" content=\"pt-br\">\n");
      out.write("        <meta name=\"Autor\" content=\"Ruan\">\n");
      out.write("        <meta name=\"Reply-To\" content=\"XYZ@hotmail.com\">\n");
      out.write("        <meta name=\"Generator\" content=\"Sublime 3.0\">\n");
      out.write("        <TITLE>Cadastro de Dependente</TITLE>\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <!-- Carregando o CSS do Bootstrap -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\" />\n");
      out.write("\n");
      out.write("        <!-- Arquivo Css Criado -->\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body bgcolor=\"white\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        <!-- Menu Superior -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-default\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"navbar-header col-sm-12\">\n");
      out.write("            <div class=\"navbar-brand col-sm-10\" href=\"#\" style=\" padding-top: 10px\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"nav col-sm-2\">\n");
      out.write("                                <img alt=\"\" src=\"img/logo.png\">\n");
      out.write("                                Locadora   \n");
      out.write("                            </div>   \n");
      out.write("                        </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"nav col-sm-2\">\n");
      out.write("                <li class=\"dropdown img-User-nome\">\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">\n");
      out.write("                        <div>\n");
      out.write("                                    <img src=\"img/user.png\" alt=\"\"  >\n");
      out.write("                                    Administrador\n");
      out.write("                                    <span class=\"caret\"></span>   \n");
      out.write("                        </div>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                        <li><a href=\"#\">Sair</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\" style=\"overflow: hidden\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"accordion\" id=\"leftMenu\" class=\"left-menu\">\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#\">\n");
      out.write("                <i class=\"icon-home\"></i> Home\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseAtor\">\n");
      out.write("                <i class=\"icon-th\"></i> Ator\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseAtor\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaAtor.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraAtor.jsp\">Novo</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\t<div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseClasse\">\n");
      out.write("                <i class=\"icon-th-list\"></i> Classe\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseClasse\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaClasse.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraClasse.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseCliente\">\n");
      out.write("                <i class=\"icon-th\"></i> Socio\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseCliente\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaCliente.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraCliente.jsp\">Novo</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseDep\">\n");
      out.write("                <i class=\"icon-th\"></i> Dependente\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseDep\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaDependente.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraDependente.jsp\">Novo</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseDevolucao\">\n");
      out.write("                <i class=\"icon-list-alt\"></i> Devolução\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseDevolucao\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaDevolucao.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"EfetuaDevolucao.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseDiretor\">\n");
      out.write("                <i class=\"icon-th\"></i> Diretor\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseDiretor\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaDiretor.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraDiretor.jsp\">Novo</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseDistribuidor\">\n");
      out.write("                <i class=\"icon-cog\"></i> Distribuidor\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseDistribuidor\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaDistribuidor.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraDistribuidor.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseFuncionario\">\n");
      out.write("                <i class=\"icon-file\"></i> Funcionário\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseFuncionario\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaFuncionario.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraFuncionario.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseItem\">\n");
      out.write("                <i class=\"icon-file\"></i> Item\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseItem\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaItem.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraItem.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseLocacao\">\n");
      out.write("                <i class=\"icon-file\"></i> Locação\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseLocacao\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaLocacao.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"EfetuaLocacao.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapsePagamento\">\n");
      out.write("                <i class=\"icon-file\"></i> Pagamento\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapsePagamento\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaPagamento.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"EfetuaPagamento.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseReserva\">\n");
      out.write("                <i class=\"icon-file\"></i> Reserva\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseReserva\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaReserva.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"EfetuaReserva.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"accordion-group\">\n");
      out.write("        <div class=\"accordion-heading\">\n");
      out.write("            <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#leftMenu\" href=\"#collapseTitulo\">\n");
      out.write("                <i class=\"icon-file\"></i> Título\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"collapseTitulo\" class=\"accordion-body collapse\" style=\"height: 0px; \">\n");
      out.write("            <div class=\"accordion-inner\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"ConsultaTitulo.jsp\">Consultar</a></li>\n");
      out.write("                    <li class=\"opcoesDeMenu\"><a href=\"CadastraTitulo.jsp\">Novo</a></li>\n");
      out.write("                </ul>                 \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"nav col-sm-10 formCadastro\" style=\"padding-left: 20px\">\n");
      out.write("                    <h2>Incluir Dependente</h2>\n");
      out.write("                    ");

                        // Errors
                        String error = request.getParameter("erro");
                        if (error != null) {
                            if (error.equals("0")) {
                                out.println("<div class='alert alert-success' style = 'margin-right: 35px'>Ação realizada com sucesso!</div>");
                            } else {
                                out.println("<div class='alert alert-danger' style = 'margin-right: 35px'>Erro!</div>");
                            }
                        }

                    
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <form action= \"ControllerCliente\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"operacao\" value=\"cadastrarDependente\">\n");
      out.write("                            ");

                            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
                            Session s = sessions.openSession();

                            //Listagem de socios
                            String strQuery = "from Cliente as cli where cli.class=Socio";

                            s.beginTransaction();
                            Query qr = s.createQuery(strQuery);

                            List socios = qr.list();
                            
      out.write("\n");
      out.write("                            \n");
      out.write("                            <div class=\"nav col-sm-12 \">\n");
      out.write("                                <div class=\"nav row\">\n");
      out.write("                                    <label for=\"User\" class=\"col-sm-12\">Socio</label>\n");
      out.write("                                    <div class=\"col-sm-5\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <select name=\"idSocio\" class=\"form-control col-sm-12\">\n");
      out.write("                                                ");

                                                Iterator i = socios.iterator();
                                                while (i.hasNext()){
                                                    
                                                    Cliente c = (Cliente)i.next();
                                                
      out.write("  \n");
      out.write("                                                    <option value='");
out.println(c.getNumInscricao());
      out.write('\'');
      out.write('>');
out.println(c.getNome());
      out.write("</option>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                            </select>  \n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"nav col-sm-12 \">\n");
      out.write("                                <div class=\"nav row\">\n");
      out.write("                                    <label for=\"User\" class=\"col-sm-12\">Dependente</label>\n");
      out.write("                                    <div class=\"input-group input-group-sm col-sm-5\">\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Nome\" name=\"nome\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"nav col-sm-12\"> \n");
      out.write("                                <div class=\"nav row\">\n");
      out.write("                                    <div class=\"col-sm-5\" style=\"padding :0\">\n");
      out.write("                                        <label for=\"User\" class=\"col-sm-12\">Sexo</label>\n");
      out.write("                                        <div class=\"col-sm-3 formCadastro-RadioButtom\">\n");
      out.write("                                            <input type=\"radio\" name=\"sex\" value=\"m\" checked>&nbsp Masculino\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-3 formCadastro-RadioButtom\">\n");
      out.write("                                            <input type=\"radio\" name=\"sex\" value=\"f\">&nbsp Feminino\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"nav col-sm-12 \"> \n");
      out.write("                                <div class=\"nav row\">\n");
      out.write("                                    <div class=\"input-group input-group-sm col-sm-5\">\n");
      out.write("                                        <label for=\"User\" class=\"col-sm-12\">Data de Nascimento</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"Data de Nascimento\" name=\"dataNascimento\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-12\" align=\"rigth\">\n");
      out.write("                                <div class=\"col-sm-6 formBTN2 \" align=\"right\">  \n");
      out.write("                                    <button class=\"btn\"> Cancelar </button>\n");
      out.write("                                    <button type =\"submit\" class=\"btn\" > Salvar </button>\n");
      out.write("                                </div> \n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"divider divider-single\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"js/jsProject.js\"></script>-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
