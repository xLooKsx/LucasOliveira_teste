/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.TO;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author lucas.oliveira
 */
public class MotoristaTO {
    
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String modeloCarro;
    private String status;
    private String sexo;

    public MotoristaTO() {
        this("", null, "", "", "", "");
    }    

    public MotoristaTO(String nome, Date dtNascimento, String cpf, String modeloCarro, String status, String sexo) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.modeloCarro = modeloCarro;
        this.status = status;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "MotoristaTO{" + "nome=" + nome + ", dtNascimento=" + dtNascimento + ", cpf=" + cpf + ", modeloCarro=" + modeloCarro + ", status=" + status + ", sexo=" + sexo + '}';
    }
    
    
}
