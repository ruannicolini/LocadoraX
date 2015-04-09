/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.ClienteBD;
import model.domain.Socio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
@WebServlet(name = "ControllerCliente", urlPatterns = {"/ControllerCliente"})
public class ControllerCliente extends HttpServlet {

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
            out.println("<title>Servlet ControllerCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCliente at " + request.getContextPath() + "</h1>");
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

        String operacao = request.getParameter("operacao");

        if (operacao.equals("cadastrar")) {
            String nome = request.getParameter("nome");
            char sexo = ((request.getParameter("sex")).toCharArray())[0];
            String dataNascimento = request.getParameter("dataNascimento");
            String cpf = request.getParameter("cpf");
            String endereco = request.getParameter("endereco");
            String tel = request.getParameter("tel");
            int resposta = 0;
            try (PrintWriter out = response.getWriter()) {
                /* 
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Servlet ControllerCliente</title>");            
                 out.println("</head>")
                 out.println("<body>");
                 out.println("<h1>" + nome + "</h1>");
                 out.println("<h1>" + sexo + "</h1>");
                 out.println("<h1>" + cpf + "</h1>");
                 out.println("<h1>" + dataNascimento + "</h1>");
                 out.println("<h1>" + endereco + "</h1>");
                 out.println("<h1>" + tel + "</h1>");
                 out.println("</body>");
                 out.println("</html>");
                 */

                resposta = ClienteBD.cadastrarSocio(endereco, tel, cpf, nome, dataNascimento, sexo);

                /*
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Servlet ControllerCliente</title>");            
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<h1> Resposta = " + resposta + "</h1>");
                 out.println("</body>");
                 out.println("</html>");
                 */
            }

        } else if (operacao.equals("cadastrarDependente")) {
            
            String idSocio = request.getParameter("idSocio");
            String nome = request.getParameter("nome");
            char sexo = ((request.getParameter("sex")).toCharArray())[0];
            String nasc = request.getParameter("dataNascimento");

            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            String strQuery = "from Cliente where numInscricao = " + idSocio;
            session.beginTransaction();
            Query qr = session.createQuery(strQuery);
            List clientes = qr.list();
            session.close();

            Socio socio = (Socio) clientes.get(0);

            if (ClienteBD.inscreverDependente(socio, nome, sexo, nasc) == 1) {
                // OK
            } else {

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
