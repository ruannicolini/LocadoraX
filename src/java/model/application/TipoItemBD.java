/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import model.domain.TipoItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class TipoItemBD {
    public static TipoItem consultaId(String id){

            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            String strQuery = "from TipoItem where idTipoItem = " + id;
            session.beginTransaction();
            Query qr = session.createQuery(strQuery);
            List classes = qr.list();
            session.close();

            return (TipoItem) classes.get(0);
    }
    
}
