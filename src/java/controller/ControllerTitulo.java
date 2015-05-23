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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.application.AtorBD;
import model.application.ClasseBD;
import model.application.DiretorBD;
import model.application.DistribuidorBD;
import model.application.TituloBD;
import model.domain.Ator;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Distribuidor;
import model.domain.Titulo;

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
            String sinopse = request.getParameter("sinopse");
            
            String cnpjDist = request.getParameter("distribuidor");
            Distribuidor distribuidor = DistribuidorBD.consultaId(cnpjDist);
            
            String idClasse = request.getParameter("classe");
            Classe classe = ClasseBD.consultaId(idClasse);
            
            String idDiretor = request.getParameter("diretor");
            Diretor diretor = DiretorBD.consultaId(idDiretor);        
            
            // Lista de Atores
            Enumeration e = request.getParameterNames();
            Set<Ator> atores = new HashSet<Ator>();
            while(e.hasMoreElements()){
                Object o = e.nextElement();
                System.out.println("==="+o);
        
                if (o.toString().toLowerCase().contains("selecionado".toLowerCase())){
                    System.out.println("ator="+request.getParameter(o.toString()));
                    atores.add(AtorBD.consultaId(request.getParameter(o.toString())));
                }
            }
            
            if(TituloBD.cadastrarTitulo(nome, ano, sinopse, categoria, diretor, classe, distribuidor, atores) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("CadastraTitulo.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("CadastraTitulo.jsp?erro=-1");
            }
            
        } else if (operacao.equals("alterar")) {
            Titulo t =  TituloBD.consultaId(request.getParameter("idTitulo"));
            t.setNome(request.getParameter("nome"));
            t.setAno(request.getParameter("ano"));
            t.setCategoria(request.getParameter("categoria"));
            t.setSinopse(request.getParameter("sinopse"));
            
            String cnpjDist = request.getParameter("distribuidor");
            t.setDistribuidor(DistribuidorBD.consultaId(cnpjDist));
            
            String idClasse = request.getParameter("classe");
            t.setClasse(ClasseBD.consultaId(idClasse));
            
            String idDiretor = request.getParameter("diretor");
            t.setDiretor(DiretorBD.consultaId(idDiretor));
            
            // Lista de Atores
            Enumeration e = request.getParameterNames();
            Set<Ator> atores = new HashSet<Ator>();
            while(e.hasMoreElements()){
                Object o = e.nextElement();
                System.out.println("==="+o);
        
                if (o.toString().toLowerCase().contains("selecionado".toLowerCase())){
                    System.out.println("ator="+request.getParameter(o.toString()));
                    atores.add(AtorBD.consultaId(request.getParameter(o.toString())));
                }
            }
            t.setAtores(atores);
            
            if(TituloBD.Editar(t) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaTitulo.jsp?erro=0");
            }else{
                // Coloca mensagem de Erro!
                response.sendRedirect("ConsultaTitulo.jsp?erro=-1");
            }

        } else if (operacao.equals("excluir")) {
            String id = request.getParameter("btnExcluir");
            Titulo t =  TituloBD.consultaId(id);
                        
            if(TituloBD.Excluir(t) == 0){
                // Coloca mensagem de sucesso!
                response.sendRedirect("ConsultaTitulo.jsp?erro=0");
            }else{
                // Colocar mensagem de Erro!
                response.sendRedirect("ConsultaTitulo.jsp?erro=-1");
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
