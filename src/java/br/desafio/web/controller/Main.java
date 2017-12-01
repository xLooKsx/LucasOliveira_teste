/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.controller;

import br.desafio.web.TO.CorridaTO;
import br.desafio.web.TO.MotoristaTO;
import br.desafio.web.TO.PassageiroTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author lucas.oliveira
 */

@RequestScoped
@ManagedBean(name = "controller")
public class Main {
    
    MotoristaTO motoristaTO;
    PassageiroTO passageiroTO;
    CorridaTO corridaTO;
    
    private List<CorridaTO> corridas = new ArrayList<>();

    public Main() {
        motoristaTO = new MotoristaTO();
        passageiroTO = new PassageiroTO();
        corridaTO = new CorridaTO();
    }   

    public void cadastrarMotorista(){
        //Dao Aqui
    }
    
    public void cadastrarPassageiro(){
        //Dao Aqui
    }
    
    public void popularListaCorridas(){
        //DAO aqui
    }

    public MotoristaTO getMotoristaTO() {
        return motoristaTO;
    }

    public void setMotoristaTO(MotoristaTO motoristaTO) {
        this.motoristaTO = motoristaTO;
    }        

    public PassageiroTO getPassageiroTO() {
        return passageiroTO;
    }

    public void setPassageiroTO(PassageiroTO passageiroTO) {
        this.passageiroTO = passageiroTO;
    }

    public CorridaTO getCorridaTO() {
        return corridaTO;
    }

    public void setCorridaTO(CorridaTO corridaTO) {
        this.corridaTO = corridaTO;
    }

    public List<CorridaTO> getCorridas() {
        return corridas;
    }           
}
