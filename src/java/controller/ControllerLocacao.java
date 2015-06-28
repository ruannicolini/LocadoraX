/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.application.ClienteBD;
import model.application.ItemBD;
import model.application.LocacaoBD;
import model.domain.Cliente;
import model.domain.Item;
import model.domain.Locacao;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerLocacao", urlPatterns = {"/ControllerLocacao"})
public class ControllerLocacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerLocacao</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerLocacao at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("username") != null) {

        } else {
            response.sendRedirect("index.jsp?erro=-2");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("username") != null) {
            String operacao = request.getParameter("operacao");
            if (operacao.equals("cadastrar")) {

                String dtprevDevolucao = request.getParameter("dtPrevDev");

                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                Date data = new Date();
                String dtLocacao = formatador.format( data );

                String valor = request.getParameter("valor");

                String idCliente = request.getParameter("cliente");
                Cliente cliente = ClienteBD.consultaId(idCliente);

                String numSerie = request.getParameter("item");
                Item item = ItemBD.consultaId(numSerie);

                if( LocacaoBD.cadastrarLocacao(dtLocacao, dtprevDevolucao, valor, cliente, item, false) == 0 ){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("EfetuaLocacao.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("EfetuaLocacao.jsp?erro=-1");
                }
            } else if (operacao.equals("alterar")) {
                Locacao loc =  LocacaoBD.consultaId(request.getParameter("idLocacao"));

                String valor = request.getParameter("valor");
                loc.setValorCobrado(Float.parseFloat(valor));

                String idCliente = request.getParameter("cliente");
                Cliente cliente = ClienteBD.consultaId(idCliente);
                loc.setCliente(cliente);

                String numSerie = request.getParameter("item");
                Item item = ItemBD.consultaId(numSerie);
                loc.setItem(item);

                String multa = request.getParameter("multa");
                loc.setMultaCobrada(Float.parseFloat(multa));

                String dtLocacao = request.getParameter("dtLocacao");
                loc.setDtLocacao(dtLocacao);
                String dtPrevDevolucao = request.getParameter("dtPrevDevolucao");
                loc.setDtDevolucaoPrevista(dtPrevDevolucao);

                String dtEfetDevolucao = request.getParameter("dtEfetDevolucao");
                if(dtEfetDevolucao != null){
                    loc.setDtDevolucaoEfetiva(dtEfetDevolucao);
                }

                if(LocacaoBD.Editar(loc) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaLocacao.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("ConsultaLocacao.jsp?erro=-1");
                }

            } else if (operacao.equals("excluir")) {
                String id = request.getParameter("btnExcluir");
                Locacao loc =  LocacaoBD.consultaId(id);

                if(LocacaoBD.Excluir(loc) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaLocacao.jsp?erro=0");
                }else{
                    // Colocar mensagem de Erro!
                    response.sendRedirect("ConsultaDiretor.jsp?erro=-1");
                }
            } else {
                System.out.println("Operacao invalida");
            }
        } else {
            response.sendRedirect("index.jsp?erro=-2");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
