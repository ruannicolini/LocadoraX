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

                if(AtorBD.cadastrarAtor(nome) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("CadastraAtor.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("CadastraAtor.jsp?erro=-1");
                }

            } else if (operacao.equals("alterar")) {
                Ator at =  AtorBD.consultaId(request.getParameter("idAtor"));
                at.setNome(request.getParameter("nome"));

                if(AtorBD.Editar(at) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaAtor.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("ConsultaAtor.jsp?erro=-1");
                }

            } else if (operacao.equals("excluir")) {
                String id = request.getParameter("btnExcluir");
                Ator at =  AtorBD.consultaId(id);

                if(AtorBD.Excluir(at) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaAtor.jsp?erro=0");
                }else{
                    // Colocar mensagem de Erro!
                    response.sendRedirect("ConsultaAtor.jsp?erro=-1");
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
