/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import java.io.PrintWriter;
import model.domain.Cliente;
import model.domain.Item;
import model.domain.Locacao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class LocacaoBD {

    public static int cadastrarLocacao(String dtLocacao, String dtDevolucaoPrevista, String valor, Cliente cliente, Item item) {
        if (cliente.getNome().equals("")) {
            return -1;
        }
        Locacao l = new Locacao(dtLocacao, dtDevolucaoPrevista, Float.parseFloat(valor), cliente, item);

        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(l);
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
