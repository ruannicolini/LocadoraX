/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import model.domain.Item;
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
            return -1;
        }
        return 0;
    }

    public static Item consultaId(String id) {
        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Item where numSerie = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List itens = qr.list();
        session.close();

        return (Item) itens.get(0);
    }
    
    public static int Editar(Item it){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(it);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static int Excluir(Item it){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(it);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
