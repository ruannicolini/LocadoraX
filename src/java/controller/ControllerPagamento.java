/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AtorBD;
import model.application.LocacaoBD;
import model.application.PagamentoBD;
import model.domain.Ator;
import model.domain.Locacao;
import model.domain.Pagamento;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerPagamento", urlPatterns = {"/ControllerPagamento"})
public class ControllerPagamento extends HttpServlet {

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
            out.println("<title>Servlet ControllerPagamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPagamento at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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
        if (operacao.equals("cadastrar")){
            String data = request.getParameter("dataPag");
            String valor = request.getParameter("valor");
            Pagamento pag = new Pagamento(data, Float.parseFloat(valor));
            int id = PagamentoBD.cadastrar(pag);
            pag = PagamentoBD.consultaId(id);
            // Lista de Locacoes
            Enumeration e = request.getParameterNames();
            
            while(e.hasMoreElements()){
                Object o = e.nextElement();
                System.out.println("==="+o);
        
                if (o.toString().toLowerCase().contains("selecionado".toLowerCase())){
                    System.out.println("Locacao="+request.getParameter(o.toString()));
                    Locacao loc = LocacaoBD.consultaId(request.getParameter(o.toString()));
                    loc.getPagamentos().add(pag);
                    
                    loc.setStatusPagamento(true);
                    LocacaoBD.Editar(loc);
                }
            }
            // Coloca mensagem de sucesso!
            response.sendRedirect("EfetuaPagamento.jsp?erro=0");
            
            
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
