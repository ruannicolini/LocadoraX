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
import model.application.ClasseBD;
import model.domain.Classe;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerClasse", urlPatterns = {"/ControllerClasse"})
public class ControllerClasse extends HttpServlet {

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
            out.println("<title>Servlet ControllerClasse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerClasse at " + request.getContextPath() + "</h1>");
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
		
        if (operacao.equals("cadastrar")){
            String nome = request.getParameter("nome");
            String valor = request.getParameter("valor");
            String prazo = request.getParameter("prazo");
            
             
            if(ClasseBD.cadastrarClasse(nome, valor, prazo) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("CadastraClasse.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("CadastraClasse.jsp?erro=-1");
            }
       } else if (operacao.equals("alterar")) {
            Classe cl =  ClasseBD.consultaId(request.getParameter("idClasse"));
            cl.setNome(request.getParameter("nome"));
            
            if(ClasseBD.Editar(cl) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaClasse.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaClasse.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Classe cl =  ClasseBD.consultaId(id);
                        
            if(ClasseBD.Excluir(cl) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaClasse.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaClasse.jsp?erro=-1");
            }
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
