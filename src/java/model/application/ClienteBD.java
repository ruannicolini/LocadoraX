/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.domain.Cliente;
import model.domain.Dependente;
import model.domain.Socio;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Ruan
 */
public class ClienteBD {

    public static int cadastrarSocio(String end, String tel, String cpf, String nome, String dtNasc, char sexo) {

        if (nome.equals("") || cpf.equals("")) {
            return -1;
        }
        Socio s = new Socio(end, tel, cpf, nome, dtNasc, true, sexo);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            return -1;
        }

        return 0;
    }

    public static List consultaClientes() {
        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session s = sessions.openSession();
        String strQuery = "from Cliente";
        s.beginTransaction();
        Query qr = s.createQuery(strQuery);
        List clientes = qr.list();
        s.close();
        return clientes;
    }

    public static int removerDependente(Socio so, Dependente dep) {
        Set<Dependente> dependentes = new HashSet<Dependente>();
        Collection<Dependente> aux = new HashSet<Dependente>();
        dependentes = so.getDependentes();
        aux.add(dep);
        
        dependentes.removeAll(aux);

        so.setDependentes(dependentes);

        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            so.setDependentes(dependentes);
            session.update(so);          
            session.getTransaction().commit();
            session.close();
           
        } catch (Exception x) {
            return -1;
        }
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(dep);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }

    public static int inscreverDependente(Socio socio, String nome, char sexo, String dtNasc) {
        if (nome.equals("")) {
            return -1;
        }
        Dependente d = new Dependente();
        d.setDataNascimento(dtNasc);
        d.setNome(nome);
        d.setSexo(sexo);
        d.setAtivo(true);
        socio.inserirDependente(d);
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();

            session.beginTransaction();

            socio.inserirDependente(d);
            session.update(socio);
            session.getTransaction().commit();
            session.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }

    public static Cliente consultaId(String id) {
        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        String strQuery = "from Cliente where numInscricao = " + id;
        session.beginTransaction();
        Query qr = session.createQuery(strQuery);
        List clientes = qr.list();
        session.close();

        return (Cliente) clientes.get(0);
    }

    public static int EditarCliente(Cliente cli) {
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.update(cli);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }

    public static int ExcluiCliente(Cliente cli) {
        try {
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session s = sessions.openSession();
            Transaction tx = s.beginTransaction();
            s.delete(cli);
            tx.commit();
            s.close();
        } catch (Exception x) {
            return -1;
        }
        return 0;
    }

}
