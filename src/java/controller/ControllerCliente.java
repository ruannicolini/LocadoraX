/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.application.ClienteBD;
import model.domain.Dependente;
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

            String operacao = request.getParameter("operacao");
            if (operacao.equals("cadastrar")) {
                String nome = request.getParameter("nome");
                char sexo = ((request.getParameter("sex")).toCharArray())[0];
                String dataNascimento = request.getParameter("dataNascimento");
                String cpf = request.getParameter("cpf");
                String endereco = request.getParameter("endereco");
                String tel = request.getParameter("tel");
                int resposta = 0;

                if (ClienteBD.cadastrarSocio(endereco, tel, cpf, nome, dataNascimento, sexo) == 0) {
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("CadastraCliente.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("CadastraCliente.jsp?erro=-1");
                }

            } else if (operacao.equals("cadastrarDependente")) {

                String idSocio = request.getParameter("idSocio");
                String nome = request.getParameter("nome");
                char sexo = ((request.getParameter("sex")).toCharArray())[0];
                String nasc = request.getParameter("dataNascimento");



                if (ClienteBD.inscreverDependente(Integer.parseInt(idSocio), nome, sexo, nasc) == 0) {
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("CadastraDependente.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("CadastraDependente.jsp?erro=-1");
                }
            } else if (operacao.equals("alterarSocio")) {

                Socio so = (Socio) ClienteBD.consultaId(request.getParameter("idSocio"));
                so.setNome(request.getParameter("nome"));
                so.setSexo(((request.getParameter("sex")).toCharArray())[0]);
                so.setDataNascimento(request.getParameter("dataNascimento"));
                so.setCpf(request.getParameter("cpf"));
                so.setEndereco(request.getParameter("endereco"));
                so.setTelefone(request.getParameter("tel"));

                if(ClienteBD.EditarCliente(so) == 0){
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaCliente.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("ConsultaCliente.jsp?erro=-1");
                }

            } else if (operacao.equals("alterarDependente")) {
                Socio so = (Socio) ClienteBD.consultaId(request.getParameter("idSocio"));
                Dependente dep = (Dependente) ClienteBD.consultaId(request.getParameter("idDependente"));
                dep.setNome(request.getParameter("nome"));
                dep.setDataNascimento(request.getParameter("dataNascimento"));
                dep.setSexo(request.getParameter("sex").charAt (0));

                so.inserirDependente(dep);

                if (ClienteBD.EditarCliente(dep) == 0) {
                    // Coloca mensagem de sucesso!
                    response.sendRedirect("ConsultaDependente.jsp?erro=0");
                }else{
                    // Coloca mensagem de Erro!
                    response.sendRedirect("ConsultaDependente.jsp?erro=-1");
                }
            } else if (operacao.equals("ExcluirSocio")) {
                String id = request.getParameter("btnExcluir");
                Socio so = (Socio) ClienteBD.consultaId(id);
                ClienteBD.ExcluiCliente(so);


            } else if (operacao.equals("excluirDependente")) {

                Socio so = new Socio();
                Dependente dep = new Dependente();


                // Obtendo Socio e Dependente
                Enumeration e = request.getParameterNames();
                while(e.hasMoreElements()){
                    Object o = e.nextElement();
                    if (o.toString().toLowerCase().contains("btnExcluir".toLowerCase())){
                        String teste = o.toString();

                        //Obtendo Dependente a ser excluído
                        System.out.println("Dependente: " + teste.substring(10));
                        dep = (Dependente) ClienteBD.consultaId(  (teste.substring(10))  );

                        System.out.println("Socio="+request.getParameter(o.toString()));
                        so = (Socio) ClienteBD.consultaId(request.getParameter(o.toString()));

                        ClienteBD.removerDependente(so, dep);
                    }
                }


                System.out.println("KBÔ");
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
