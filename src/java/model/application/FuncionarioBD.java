/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.application;

import model.domain.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
        }
        return 1;
    }
    
}
