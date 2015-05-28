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
import model.application.ClienteBD;
import model.application.ReservaBD;
import model.application.TipoItemBD;
import model.application.TituloBD;
import model.domain.Cliente;
import model.domain.Reserva;
import model.domain.TipoItem;
import model.domain.Titulo;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerReserva", urlPatterns = {"/ControllerReserva"})
public class ControllerReserva extends HttpServlet {

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
            out.println("<title>Servlet ControllerReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerReserva at " + request.getContextPath() + "</h1>");
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
            
            String idCliente = request.getParameter("cliente");
            Cliente cliente = ClienteBD.consultaId(idCliente);
            
            String idTipo = request.getParameter("tipo");
            TipoItem tipoitem = TipoItemBD.consultaId(idTipo);
            
            String idTitulo = request.getParameter("titulo");
            Titulo titulo = TituloBD.consultaId(idTitulo);
            
            String dtReserva = request.getParameter("dtReserva");
            String hrReserva = request.getParameter("hrReserva");
            
            
            if(ReservaBD.cadastrarReserva(dtReserva, hrReserva, cliente, titulo, tipoitem) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("EfetuaReserva.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("EfetuaReserva.jsp?erro=-1");
            }
        } else if (operacao.equals("alterar")) {
            Reserva res =  ReservaBD.consultaId(request.getParameter("idReserva"));
            
            String idCliente = request.getParameter("cliente");
            res.setCliente(ClienteBD.consultaId(idCliente));
            
            String idTipo = request.getParameter("tipo");
            res.setTipoItem(TipoItemBD.consultaId(idTipo));
            
            String idTitulo = request.getParameter("titulo");
            res.setTitulo(TituloBD.consultaId(idTitulo));

            String t = request.getParameter("dtReserva");
            res.setDtReserva(request.getParameter("dtReserva"));
            res.setHrReserva(request.getParameter("hrReserva"));
            
            res.setDtReserva(request.getParameter("dtComunicado"));
            res.setHrReserva(request.getParameter("hrComunicado"));
            
            if(ReservaBD.Editar(res) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaReserva.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaReserva.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Reserva res =  ReservaBD.consultaId(id);
                        
            if(ReservaBD.Excluir(res) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaReserva.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaReserva.jsp?erro=-1");
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
