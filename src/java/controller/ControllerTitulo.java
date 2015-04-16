/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.ClasseBD;
import model.application.DiretorBD;
import model.application.DistribuidorBD;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Distribuidor;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerTitulo", urlPatterns = {"/ControllerTitulo"})
public class ControllerTitulo extends HttpServlet {

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
//            out.println("<title>Servlet ControllerTitulo</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerTitulo at " + request.getContextPath() + "</h1>");
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
        if (operacao.equals("cadastrar")) {
            String nome = request.getParameter("nome");
            String ano = request.getParameter("ano");
            String categoria = request.getParameter("categoria");
            
            String cnpjDist = request.getParameter("distribuidor");
            Distribuidor distribuidor = DistribuidorBD.consultaId(cnpjDist);
            
            String idClasse = request.getParameter("classe");
            Classe classe = ClasseBD.consultaId(idClasse);
            
            String idDiretor = request.getParameter("diretor");
            Diretor diretor = DiretorBD.consultaId(idDiretor);
            
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerTitulo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> nome : " + nome + "</h1>");
            out.println("<h1> ano : " + ano + "</h1>");
            out.println("<h1> categoria : " + categoria + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
            
            // Lista de Atores
            Enumeration e = request.getParameterNames();
            List atores = new ArrayList();
            while(e.hasMoreElements()){
                Object o = e.nextElement();
                System.out.println("==="+o);
                if (o.toString().equals("selecionado%")){
                    System.out.println("ator="+request.getParameter(o.toString()));

                }
            }
        }
        
        
        
        
        
//        if (operacao.equals("cadastrar")) {
//            String nome = request.getParameter("nome");
//            String ano = request.getParameter("ano");
//            String categoria = request.getParameter("categoria");
//            
//            String cnpjDist = request.getParameter("distribuidor");
//            Distribuidor distribuidor = DistribuidorBD.consultaId(cnpjDist);
//            
//            String idClasse = request.getParameter("classe");
//            Classe classe = ClasseBD.consultaId(idClasse);
//            
//            String idDiretor = request.getParameter("diretor");
//            Diretor diretor = DiretorBD.consultaId(idDiretor);
//            
//        }
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
