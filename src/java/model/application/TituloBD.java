/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import java.util.Set;
import model.domain.Ator;
import model.domain.Classe;
import model.domain.Diretor;
import model.domain.Distribuidor;
import model.domain.Titulo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Transaction;

/**
 *
 * @author Ruan
 */
public class TituloBD {
    public static int cadastrarTitulo(String nome, String ano, String sinopse, String categoria, Diretor diretor, Classe classe,Distribuidor distribuidor, Set<Ator> atores) {

        if (nome.equals("")) {
            return -1;
        }
        Titulo t = new Titulo(nome, ano, sinopse, categoria, diretor, classe, distribuidor, atores);
        
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static Titulo consultaId(String id){

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Titulo where idTitulo = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List titulos = qr.list();
        session.close();

        return (Titulo) titulos.get(0);
    }
    public static int Editar(Titulo t){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(t);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static int Excluir(Titulo t){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(t);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
