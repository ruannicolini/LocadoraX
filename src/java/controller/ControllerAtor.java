/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AtorBD;
import model.domain.Ator;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerAtor", urlPatterns = {"/ControllerAtor"})
public class ControllerAtor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerAtor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerAtor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    */

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
        int resposta =0;
        String operacao = request.getParameter("operacao");
        if (operacao.equals("cadastrar")){
            String nome = request.getParameter("nome");
            resposta = AtorBD.cadastrarAtor(nome);
            try (PrintWriter out = response.getWriter()) { 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControllerCliente</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Resposta = " + resposta + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else if (operacao.equals("alterar")) {
            
            Ator at =  AtorBD.consultaId(request.getParameter("idAtor"));
            at.setNome(request.getParameter("nome"));
            
            AtorBD.Editar(at);
            
            response.sendRedirect("ConsultaAtor.jsp");
            
        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Ator at =  AtorBD.consultaId(id);
            AtorBD.Excluir(at);
            
            response.sendRedirect("ConsultaAtor.jsp");
        } else {
            System.out.println("Operacao invalida");
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
