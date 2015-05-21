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
import model.application.DistribuidorBD;
import model.domain.Distribuidor;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerDistribuidor", urlPatterns = {"/ControllerDistribuidor"})
public class ControllerDistribuidor extends HttpServlet {

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
            out.println("<title>Servlet ControllerDistribuidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDistribuidor at " + request.getContextPath() + "</h1>");
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
            String rs = request.getParameter("razao");
            String cnpj = request.getParameter("cnpj");
            
            if(DistribuidorBD.cadastrarDistribuidor(rs, cnpj) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("CadastraDistribuidor.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("CadastraDistribuidor.jsp?erro=-1");
            }
                            
        } else if (operacao.equals("alterar")) {
            Distribuidor dist =  DistribuidorBD.consultaId(request.getParameter("idDistribuidor"));
            dist.setCnpj(Integer.parseInt(request.getParameter("cnpj")));
            dist.setRazaoSocial(request.getParameter("razao"));
            
            if(DistribuidorBD.Editar(dist) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaDistribuidor.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaDistribuidor.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Distribuidor dist =  DistribuidorBD.consultaId(id);
                        
            if(DistribuidorBD.Excluir(dist) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaDistribuidor.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaDistribuidor.jsp?erro=-1");
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
