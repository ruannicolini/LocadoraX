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
import org.hibernate.Transaction;
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
            return -1;
        }
        return 0;  
    }
    
    public static Distribuidor consultaId(String cnpj){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            String strQuery = "from Distribuidor where cnpj = " + cnpj;
            session.beginTransaction();
            Query qr = session.createQuery(strQuery);
            List<Distribuidor> dists = qr.list();
            session.close();

            return (Distribuidor) dists.get(0);
        }catch(Exception x){
                System.out.println("Erro: " + x.getMessage());
        }
        return null;
    }
    
    public static int Editar(Distribuidor d){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(d);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static int Excluir(Distribuidor d){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(d);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
