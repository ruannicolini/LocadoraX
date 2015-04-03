/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import java.io.PrintWriter;
import java.util.List;
import model.domain.Socio;
import org.hibernate.Query;
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
        try{
            SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
            Session session = sessions.openSession();
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            session.close();
        }catch(Exception x){
            PrintWriter out = null; 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Erro " + x.getMessage() + "</h1>");
                out.println("</body>");
                out.println("</html>");
        }

        return 1;
    }
    
    public static List consultaClientes(){
        SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
        Session s = sessions.openSession();
        String strQuery = "from Cliente";
        s.beginTransaction();
        Query qr = s.createQuery(strQuery);
        List clientes = qr.list();
//        Iterator<Cliente> i = clientes.iterator();
//        while (i.hasNext()) {
//            Cliente c = (Cliente) i.next();
//
//            out.print(c.getNome() + "<br>");
//        }
        s.close();
        return clientes;
    }

}
