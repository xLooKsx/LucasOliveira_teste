/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.DAO;

import br.desafio.web.TO.CorridaTO;
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
 * @author lucas.oliveira
 */
public class CorridaDAO {

    private Connection connection;
    private PreparedStatement stm;
    private ResultSet rs;

    Logger logger = Logger.getLogger(CorridaDAO.class.getName());

    public CorridaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirCorrida(String nomeMotorista, String nomePassageiro, double valor) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
                .append("corrida ")
                .append("( ")
                .append("idCorrida, ")
                .append("nomeMotorista, ")
                .append("nomePassageiro, ")
                .append("valor ")
                .append(") ")
                .append("VALUES(nextval('id_corrida'), ?, ?, ?); ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());

            this.stm.setString(1, nomeMotorista);
            this.stm.setString(2, nomePassageiro);
            this.stm.setDouble(3, valor);
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

    public List<CorridaTO> consultarCorrida() {

        List<CorridaTO> corridas = new ArrayList<CorridaTO>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM corrida ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());
            this.stm.execute();

            this.rs = stm.executeQuery();
            while (rs.next()) {
                CorridaTO corrida = new CorridaTO();
                corrida.setNomeMotorista(rs.getString("nomeMotorista"));
                corrida.setNomePassageiro(rs.getString("nomePassageiro"));
                corrida.setValor(rs.getDouble("valor"));
                corridas.add(corrida);
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
        return corridas;
    }

}
