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
import model.application.ItemBD;
import model.application.TipoItemBD;
import model.application.TituloBD;
import model.domain.Item;
import model.domain.TipoItem;
import model.domain.Titulo;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerItem", urlPatterns = {"/ControllerItem"})
public class ControllerItem extends HttpServlet {

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
            out.println("<title>Servlet ControllerItem</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerItem at " + request.getContextPath() + "</h1>");
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
            String idTitulo = request.getParameter("titulo");
            Titulo titulo = TituloBD.consultaId(idTitulo);
            
            String idTipo = request.getParameter("tipo");
            TipoItem tipoitem = TipoItemBD.consultaId(idTipo);
            
            String numSerie = request.getParameter("numDeSerie");
            String dtAquisicao = request.getParameter("dtAquisicao");
            
            if(ItemBD.cadastrarItem(numSerie, dtAquisicao, tipoitem, titulo) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("CadastraItem.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("CadastraItem.jsp?erro=-1");
            }
        } else if (operacao.equals("alterar")) {
            Item it =  ItemBD.consultaId(request.getParameter("idItem"));
            String idTitulo = request.getParameter("titulo");
            it.setTitulo(TituloBD.consultaId(idTitulo));
            String idTipo = request.getParameter("tipo");
            it.setTipo(TipoItemBD.consultaId(idTipo));
            String numSerie = request.getParameter("numDeSerie");
            
            it.setNumSerie(Integer.parseInt(request.getParameter("numDeSerie")));
            
            if(ItemBD.Editar(it) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaItem.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaItem.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Item it =  ItemBD.consultaId(id);
                        
            if(ItemBD.Excluir(it) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaItem.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaItem.jsp?erro=-1");
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
