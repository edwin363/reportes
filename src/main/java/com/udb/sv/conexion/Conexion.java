/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.conexion;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author rigoberto
 */
public class Conexion {
    private Connection conn;
    private String url, user, pass;
    
    public boolean getDataConn(){
        boolean resp = false;
        try {
             Properties prop = new Properties();
            try (InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
                prop.load(file);
                this.url = prop.getProperty("url");
                this.user = prop.getProperty("user");
                this.pass = prop.getProperty("password");
                resp = true;
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo de configuracion: " + e.getMessage());
        }
        return resp;
    }
    
    public Connection getConn(){
        try {
            if(this.getDataConn()){
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
            }
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
