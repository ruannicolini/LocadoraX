/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.io.PrintWriter;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Titulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class TituloBD {
    public static int cadastrarTitulo(String nome, String ano, String sinopse, String categoria, Diretor diretor, Classe classe) {

        if (nome.equals("")) {
            return -1;
        }
        Titulo t = new Titulo(nome, ano, sinopse, categoria, diretor, classe);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            PrintWriter out = null;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Erro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Erro " + x.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

        return 1;
    }
    
}
