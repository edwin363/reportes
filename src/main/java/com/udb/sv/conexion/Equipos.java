/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.conexion;

/**
 *
 * @author rigoberto
 */
public class Equipos {
    private int codiEqui;
    private String nomEqui;
    private String desEqui;

    public Equipos() {
    }

    public Equipos(int codiEqui, String nomEqui, String desEqui) {
        this.codiEqui = codiEqui;
        this.nomEqui = nomEqui;
        this.desEqui = desEqui;
    }

    public int getCodiEqui() {
        return codiEqui;
    }

    public void setCodiEqui(int codiEqui) {
        this.codiEqui = codiEqui;
    }

    public String getNomEqui() {
        return nomEqui;
    }

    public void setNomEqui(String nomEqui) {
        this.nomEqui = nomEqui;
    }

    public String getDesEqui() {
        return desEqui;
    }

    public void setDesEqui(String desEqui) {
        this.desEqui = desEqui;
    }

    @Override
    public String toString() {
        return this.nomEqui;
    }
    
    
}
