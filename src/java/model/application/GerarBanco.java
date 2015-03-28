/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.application;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Ruan
 */
public class GerarBanco {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }

}
