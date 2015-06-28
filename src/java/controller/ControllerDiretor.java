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
import javax.servlet.http.HttpSession;
import model.application.DiretorBD;
import model.domain.Diretor;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerDiretor", urlPatterns = {"/ControllerDiretor"})
public class ControllerDiretor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
/*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerDiretor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDiretor at " + request.getContextPath() + "</h1>");
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
            int resposta =0;
            String operacao = request.getParameter("operacao");
            if (operacao.equals("cadastrar")){
                String nome = request.getParameter("nome");

                if(DiretorBD.cadastrarDiretor(nome) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("CadastraDiretor.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("CadastraDiretor.jsp?erro=-1");
                }

            } else if (operacao.equals("alterar")) {
                Diretor dir =  DiretorBD.consultaId(request.getParameter("idDiretor"));
                dir.setNome(request.getParameter("nome"));

                if(DiretorBD.Editar(dir) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaDiretor.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("ConsultaDiretor.jsp?erro=-1");
                }

            } else if (operacao.equals("excluir")) {
                String id = request.getParameter("btnExcluir");
                Diretor dir =  DiretorBD.consultaId(id);

                if(DiretorBD.Excluir(dir) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaDiretor.jsp?erro=0");
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
