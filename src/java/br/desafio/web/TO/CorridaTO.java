/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.TO;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lucas.oliveira
 */
public class CorridaTO {
    
    private double valor;        
    private String nomeMotorista;
    private String nomePassageiro;
    
    public CorridaTO() {
        this(0.0, "", "");
    }    

    public CorridaTO(double valor, String nomeMotorista, String nomePassageiro) {
        this.valor = valor;
        this.nomeMotorista = nomeMotorista;
        this.nomePassageiro = nomePassageiro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }
  
    
}
