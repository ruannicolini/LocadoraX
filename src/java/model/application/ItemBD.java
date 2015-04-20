/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.io.PrintWriter;
import model.domain.Item;
import model.domain.Socio;
import model.domain.TipoItem;
import model.domain.Titulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class ItemBD {
    public static int cadastrarItem(String numSerie, String dtArquisicao, TipoItem tipo, Titulo titulo){
        if (numSerie.equals("") || titulo.getNome().equals("")) {
            return -1;
        }
        Item i = new Item(Integer.parseInt(numSerie),dtArquisicao,tipo,titulo);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(i);
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
