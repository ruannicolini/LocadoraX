/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import model.domain.Diretor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class DiretorBD {
    public static int cadastrarDiretor( String nome){
        if (nome.equals("")) {
            return -1;
        }
        Diretor d = new Diretor(nome);
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            session.close();
        }catch(Exception x){
                System.out.println("Erro: " + x.getMessage());
        }
        return 1;
    }
    
    public static Diretor consultaId(String idDiretor){

            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            String strQuery = "from Diretor where idDiretor = " + idDiretor;
            session.beginTransaction();
            Query qr = session.createQuery(strQuery);
            List classes = qr.list();
            session.close();

            return (Diretor) classes.get(0);
    }
    
}
