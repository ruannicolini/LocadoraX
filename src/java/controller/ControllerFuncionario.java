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
import model.application.FuncionarioBD;
import model.domain.Funcionario;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerFuncionario", urlPatterns = {"/ControllerFuncionario"})
public class ControllerFuncionario extends HttpServlet {

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
            out.println("<title>Servlet ControllerFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerFuncionario at " + request.getContextPath() + "</h1>");
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
        String operacao = request.getParameter("operacao");

        if (operacao.equals("cadastrar")) {
            String nome = request.getParameter("nome");
            String userName = request.getParameter("userName");
            String senha = request.getParameter("senha");
            
            ;
            if(FuncionarioBD.cadastrarFuncionario(nome, userName, senha) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("CadastraFuncionario.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("CadastraFuncionario.jsp?erro=-1");
            }
            
        } else if (operacao.equals("alterar")) {
            Funcionario dir =  FuncionarioBD.consultaId(request.getParameter("idFuncionario"));
            dir.setNome(request.getParameter("nome"));
            dir.setUsername(request.getParameter("userName"));
            dir.setSenha(request.getParameter("senha"));
            
            if(FuncionarioBD.Editar(dir) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaFuncionario.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaFuncionario.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Funcionario dir =  FuncionarioBD.consultaId(id);
                        
            if(FuncionarioBD.Excluir(dir) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaFuncionario.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaFuncionario.jsp?erro=-1");
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
