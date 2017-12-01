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
public class PassageiroTO {
    
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String sexo;

    public PassageiroTO() {
        this("", null, "", "");
    }    
    
    public PassageiroTO(String nome, Date dtNascimento, String cpf, String sexo) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "PassageiroTO{" + "nome=" + nome + ", dtNascimento=" + dtNascimento + ", cpf=" + cpf + ", sexo=" + sexo + '}';
    }
    
}
