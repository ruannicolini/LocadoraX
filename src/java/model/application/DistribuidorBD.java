/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import model.domain.Distribuidor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class DistribuidorBD {
    public static int cadastrarDistribuidor( String rz, int cnpj){
        if (rz.equals("")) {
            return -1;
        }
        Distribuidor d = new Distribuidor(rz, cnpj);
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
    
}
