/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.DAO;

import br.desafio.web.TO.CorridaTO;
import br.desafio.web.TO.MotoristaTO;
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
public class MotoristaDAO {

    private Connection connection;
    private PreparedStatement stm;
    private ResultSet rs;

    Logger logger = Logger.getLogger(MotoristaDAO.class.getName());

    public MotoristaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirMotorista(MotoristaTO motoristaTO) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
                .append("motorista ")
                .append("( ")
                .append("idMotorista, ")
                .append("nome, ")
                .append("dtNascimento, ")
                .append("cpf, ")
                .append("modeloCarro, ")
                .append("status, ")
                .append("sexo ")
                .append(") ")
                .append("VALUES(nextval('idMotorista'), ?, ?, ?, ?, ?, ?); ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());

            this.stm.setString(1, motoristaTO.getNome());
            this.stm.setDate(2, new java.sql.Date(motoristaTO.getDtNascimento().getTime()));
            this.stm.setString(3, motoristaTO.getCpf());
            this.stm.setString(4, motoristaTO.getModeloCarro());
            this.stm.setString(5, motoristaTO.getStatus());
            this.stm.setString(6, motoristaTO.getSexo());
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

    public List<MotoristaTO> consultarCorrida() {

        List<MotoristaTO> motoristas = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM motorista ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());
            this.stm.execute();

            this.rs = stm.executeQuery();
            while (rs.next()) {
                MotoristaTO motorista = new MotoristaTO();
                motorista.setNome(rs.getString("nome"));
                motorista.setDtNascimento(rs.getDate("dtNascimento"));
                motorista.setCpf(rs.getString("cpf"));
                motorista.setModeloCarro(rs.getString("modeloCarro"));
                motorista.setStatus(rs.getString("status"));
                motorista.setSexo(rs.getString("sexo"));
                motoristas.add(motorista);
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
        return motoristas;
    }
}
