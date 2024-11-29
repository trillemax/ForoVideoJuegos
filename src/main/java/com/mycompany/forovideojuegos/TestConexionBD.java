package com.mycompany.forovideojuegos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 */

public class TestConexionBD {
    public static void main(String[] args) {
        String URL_DB = "jdbc:mariadb://localhost:3305/basededatosforovideojuegos";
        String USER_DB = "root";
        String PASSWORD_DB = "123quesito";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println("Conexión exitosa: " + conexion);
            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
}
   }
 }

