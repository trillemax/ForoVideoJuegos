package com.mycompany.forovideojuegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mycompany.forovideojuegos.model.Registro;

public class RegistroDao {
    
    public boolean guardarRegistro(Registro registro) {
        String sql = "INSERT INTO users (usuario, contraseña) VALUES (?, ?)";
        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, registro.getUsuario());
            stmt.setString(2, registro.getContraseña());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar el registro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
