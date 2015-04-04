/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.io.PrintWriter;
import model.domain.Classe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class ClasseBD {
     public static int cadastrarClasse( String nome, String valor, String prazo) {
        if (nome.equals("") || valor.equals("")|| prazo.equals("")) {
            return -1;
        }
        Classe cl = new Classe(nome, Float.parseFloat(valor), Integer.parseInt(prazo));
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(cl);
            session.getTransaction().commit();
            session.close();
        }catch(Exception x){
            System.out.println("Erro: " + x.getMessage());
        }
        return 1;
    }
    
}
