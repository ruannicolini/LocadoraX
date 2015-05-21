/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import java.util.List;
import model.domain.Funcionario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Transaction;

/**
 *
 * @author Ruan
 */
public class FuncionarioBD {
        public static int cadastrarFuncionario(String nome, String userName, String senha) {
        if (nome.equals("")) {
            return -1;
        }
        Funcionario f = new Funcionario(nome, userName, senha);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(f);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            System.out.println("Erro: " + x.getMessage());
            return -1;
        }
        return 0;
    }
    
    public static Funcionario consultaId(String id) {

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Funcionario where idFuncionario = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List classes = qr.list();
        session.close();

        return (Funcionario) classes.get(0);
    }    
        
    public static int Editar(Funcionario f){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(f);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
    
    public static int Excluir(Funcionario f){
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(f);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }
}
