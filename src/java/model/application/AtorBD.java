/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import java.io.PrintWriter;
import java.util.List;
import model.domain.Ator;
import model.domain.Socio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Transaction;

/**
 *
 * @author Ruan
 */
public class AtorBD {
    
    // Retorna das funções CRUD:      0 = ok  |   -1 = Erro
    
    public static int cadastrarAtor(String nome) {
        if (nome.equals("")) {
            return -1;
        }
        Ator a = new Ator(nome);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            System.out.println("Erro: " + x.getMessage());
            return -1;
        }
        return 0;
    }

    public static Ator consultaId(String id) {

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Ator where idAtor = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List classes = qr.list();
        session.close();

        return (Ator) classes.get(0);
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
    
    public static int Excluir(Ator at){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(at);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
}
