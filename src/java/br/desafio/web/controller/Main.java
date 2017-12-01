/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.controller;

import br.desafio.web.DAO.CorridaDAO;
import br.desafio.web.DAO.MotoristaDAO;
import br.desafio.web.DAO.PassageiroDAO;
import br.desafio.web.TO.CorridaTO;
import br.desafio.web.TO.MotoristaTO;
import br.desafio.web.TO.PassageiroTO;
import br.desafio.web.utils.DesafioWebUtils;
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
    
    private double valor;
    
    private List<CorridaTO> corridas = new ArrayList<>();
    private List<MotoristaTO> motoristas = new ArrayList<>();
    private List<PassageiroTO> passageiros = new ArrayList<>();
    
    FacesContext fc = FacesContext.getCurrentInstance();

    public Main() {
        motoristaTO = new MotoristaTO();
        passageiroTO = new PassageiroTO();
        corridaTO = new CorridaTO();
//        popularListaCorridas();
//        popularListaMotoristas();
//        popularListaPassageiros();
    }   

    public void cadastrarMotorista(){
        if (DesafioWebUtils.validarCPF(motoristaTO.getCpf())) {
            new MotoristaDAO().inserirMotorista(motoristaTO);
            fc.addMessage(null, new FacesMessage("Motorista cadastrado com sucesso"));
        }else{
            fc.addMessage(null, new FacesMessage("Motorista nao pode ser cadastrado com sucesso"));
        }
        
    }
    
    public void cadastrarCorrida(){
    if (motoristaTO.getStatus().contains("1")) {
            new CorridaDAO().inserirCorrida(motoristaTO.getNome(), passageiroTO.getNome(), this.valor);
            fc.addMessage(null, new FacesMessage("Motorista cadastrado com sucesso"));
        }else{
            fc.addMessage(null, new FacesMessage("Motorista nao pode ser cadastrado com sucesso"));
        }
    }
    
    public void cadastrarPassageiro(){
        if (DesafioWebUtils.validarCPF(passageiroTO.getCpf())) {
            new PassageiroDAO().inserirPassageiro(passageiroTO);
            fc.addMessage(null, new FacesMessage("passageiro cadastrado com sucesso"));
        }else{
            fc.addMessage(null, new FacesMessage("passageiro nao pode ser cadastrado com sucesso"));
        }
    }
    
    private void popularListaCorridas(){
        corridas = new CorridaDAO().consultarCorrida();
    }
    
    private void popularListaPassageiros(){
        passageiros = new PassageiroDAO().consultarPassageiros();
    }
    
    private void popularListaMotoristas(){
        corridas = new CorridaDAO().consultarCorrida();
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

    public List<MotoristaTO> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<MotoristaTO> motoristas) {
        this.motoristas = motoristas;
    }

    public List<PassageiroTO> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<PassageiroTO> passageiros) {
        this.passageiros = passageiros;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    
}
