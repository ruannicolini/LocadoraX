/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import java.util.List;
import model.domain.Ator;
import model.domain.Pagamento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class PagamentoBD {
     public static int cadastrar(Pagamento pag) {
        
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(pag);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            System.out.println("Erro: " + x.getMessage());
            return -1;
        }
        return (int) pag.getIdPagamento();
    }
    
     public static Pagamento consultaId(int id) {

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Pagamento where idPagamento = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List classes = qr.list();
        session.close();

        return (Pagamento) classes.get(0);
    }
     
     public static int Editar(Ator a){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(a);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
