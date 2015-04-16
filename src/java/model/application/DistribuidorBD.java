/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import model.domain.Distribuidor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class DistribuidorBD {
    public static int cadastrarDistribuidor( String rs, String cnpj){
        if (rs.equals("") || cnpj.equals("")) {
            return -1;
        }
        Distribuidor d = new Distribuidor(rs, Integer.parseInt(cnpj));
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
    
    public static Distribuidor consultaId(String cnpj){
        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            String strQuery = "from Distribuidor where idDistribuidor = " + cnpj;
            session.beginTransaction();
            Query qr = session.createQuery(strQuery);
            List classes = qr.list();
            session.close();

            return (Distribuidor) classes.get(0);
    }
    
}
