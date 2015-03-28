/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import model.domain.Socio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class ClienteBD {

    public static int cadastrarSocio( String end, String tel, String cpf, String nome, String dtNasc, char sexo) {

        if (nome.equals("") || cpf.equals("")) {
            return -1;
        }
        
        Socio s = new Socio(end, tel, cpf, nome, dtNasc, true, sexo);

        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();

        return 1;
    }

}
