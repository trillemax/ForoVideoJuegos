package com.mycompany.forovideojuegos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Centraliza la lógica para obtener una conexión a tu base de datos (MariaDB).
    private static final String URL_DB = "jdbc:mariadb://localhost:3305/basededatosforovideojuegos";  // URL de la base de datos
    private static final String USER_DB = "root";  // Usuario de la base de datos
    private static final String PASSWORD_DB = "123quesito";  // Contraseña de la base de datos

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Registrar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            // Establecer la conexión a la base de datos con la URL, usuario y contraseña
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);  // Muestra el objeto de conexión en la consola para verificar que se conectó
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();  // Mostrar detalles del error
        }
        return conexion;
}
}
