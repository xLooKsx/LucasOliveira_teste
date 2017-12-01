/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.DAO;

import br.desafio.web.TO.MotoristaTO;
import br.desafio.web.TO.PassageiroTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class PassageiroDAO {

    private Connection connection;
    private PreparedStatement stm;
    private ResultSet rs;

    Logger logger = Logger.getLogger(PassageiroDAO.class.getName());

    public PassageiroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirPassageiro(PassageiroTO passageiroTO) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
                .append("passageiro ")
                .append("( ")
                .append("idPassageiro, ")
                .append("nome, ")
                .append("dtNascimento, ")
                .append("cpf, ")
                .append("sexo ")
                .append(") ")
                .append("VALUES(nextval('idPassageiro'), ?, ?, ?, ?); ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());

            this.stm.setString(1, passageiroTO.getNome());
            this.stm.setDate(2, new java.sql.Date(passageiroTO.getDtNascimento().getTime()));
            this.stm.setString(3, passageiroTO.getCpf());
            this.stm.setString(4, passageiroTO.getSexo());
            stm.execute();

        } catch (SQLException e) {
            logger.log(Level.SEVERE,
                    "Impossivel salvar os dados, porfavor verifique se tudo foi inserido corretamente ", e);
        } finally {
            try {
                this.stm.close();
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<PassageiroTO> consultarPassageiros() {

        List<PassageiroTO> passageiros = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM passageiro ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());
            this.stm.execute();

            this.rs = stm.executeQuery();
            while (rs.next()) {
                PassageiroTO passageiro = new PassageiroTO();
                passageiro.setNome(rs.getString("nome"));
                passageiro.setDtNascimento(rs.getDate("dtNascimento"));
                passageiro.setCpf(rs.getString("cpf"));                
                passageiro.setSexo(rs.getString("sexo"));
                passageiros.add(passageiro);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE,
                    "Impossivel salvar os dados, porfavor verifique se tudo foi inserido corretamente ", e);
        } finally {
            try {
                rs.close();
                this.stm.close();
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return passageiros;
    }
}
