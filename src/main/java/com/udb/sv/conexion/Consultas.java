/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rigoberto
 */
public class Consultas {
    private final Connection conn;

    public Consultas() {
        this.conn = new Conexion().getConn();
    }
    
    public List<Equipos> llenarCombo(){
        List<Equipos> resp = new ArrayList<>();
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("select * from equipos");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Equipos(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
}
