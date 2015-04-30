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
import model.application.ClienteBD;
import model.application.ItemBD;
import model.application.LocacaoBD;
import model.domain.Cliente;
import model.domain.Item;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerLocacao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerLocacao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        //processRequest(request, response);
        String operacao = request.getParameter("operacao");
        if (operacao.equals("cadastrar")) {
            
            String dtDevolucao = request.getParameter("dtPrevDev");
            
              
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            String dtAquisicao = formatador.format( data );


            String valor = request.getParameter("valor");

            String idCliente = request.getParameter("cliente");
            Cliente cliente = ClienteBD.consultaId(idCliente);

            String numSerie = request.getParameter("item");
            Item item = ItemBD.consultaId(numSerie);

            int resposta = LocacaoBD.cadastrarLocacao(dtAquisicao, dtDevolucao, valor, cliente, item);
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControllerTitulo</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Data de Aquisição : " + dtAquisicao + "</h1>");
                out.println("<h1> Data de Devolução : " + dtDevolucao + "</h1>");
                out.println("<h1> Valor : " + valor + "</h1>");
                out.println("<h1> Cliente : " + cliente.getNome() + "</h1>");
                out.println("<h1> Item : " + item.getNumSerie() + "</h1>");
                out.println("<h1> Resposta : " + resposta + "</h1>");
                out.println("</body>");
                out.println("</html>");
                if(resposta == 1){
                    response.sendRedirect(request.getContextPath() + "/EfetuaPagamento.jsp");
                }
            }
            
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
