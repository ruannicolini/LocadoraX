/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.io.PrintWriter;
import model.domain.Cliente;
import model.domain.Reserva;
import model.domain.TipoItem;
import model.domain.Titulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class ReservaBD {
    public static int cadastrarReserva(String dtReserva, String hrReserva, Cliente cliente, Titulo titulo, TipoItem tipoItem){
        if (cliente.getNome().equals("")) {
            return -1;
        }

        Reserva r = new Reserva(dtReserva, hrReserva, cliente, titulo, tipoItem);

        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(r);
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
