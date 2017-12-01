/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.DAO;

import br.desafio.web.TO.CorridaTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.oliveira
 */
public class CorridaDAO {

    private Connection connection;
    private PreparedStatement stm;

    Logger logger = Logger.getLogger(CorridaDAO.class.getName());

    public CorridaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void inserirCorrida(CorridaTO corridaTO) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ")
                .append("corrida ")
                .append("( ")
                .append("id_corrida, ")
                .append("nome_motorista, ")
                .append("nome_passageiro, ")
                .append("valor, ")                
                .append(") ")
                .append("VALUES(nextval('id_corrida'), ?, ?, ?); ");

        try {
            this.stm = this.connection.prepareStatement(sql.toString());

                this.stm.setString(1, corridaTO.getNomeMotorista());
                this.stm.setString(2, corridaTO.getNomePassageiro());
                this.stm.setDouble(3, corridaTO.getValor());                
            
            stm.executeBatch();

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
    
        public void consultarCorrida(CorridaTO corridaTO) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM corrida ");


        try {
            this.stm = this.connection.prepareStatement(sql.toString());         
            //terminar o select

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

}
