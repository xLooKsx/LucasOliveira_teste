/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.desafio.web.DAO;

import br.desafio.web.utils.DesafioWebUtils;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas.oliveira
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            Class.forName(DesafioWebUtils.getProperty("config.bd.class"));
            return DriverManager.getConnection(DesafioWebUtils.getProperty("config.bd.conexao"), "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
