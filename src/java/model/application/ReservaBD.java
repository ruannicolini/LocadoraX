/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.io.PrintWriter;
import java.util.List;
import model.domain.Cliente;
import model.domain.Reserva;
import model.domain.TipoItem;
import model.domain.Titulo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
            return -1;
        }
        return 0;
    }
    public static Reserva consultaId(String id) {

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Reserva where idReserva = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List classes = qr.list();
        session.close();

        return (Reserva) classes.get(0);
    }
    
    public static int Editar(Reserva r){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(r);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static int Excluir(Reserva r){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(r);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
